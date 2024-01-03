import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Object> data = new ArrayList<>();

        int day, month, yr, prize;
        System.out.print("Enter date(1-31) : ");
        day = sc.nextInt();
        System.out.print("enter month(1-12) : ");
        month = sc.nextInt();
        System.out.print("enter year(2023/2024) : ");
        yr = sc.nextInt();
        System.out.print("enter max Prize filter : ");
        prize = sc.nextInt();
        System.out.println();

        String src, dest;
        System.out.print("enter source city : ");
        src = sc.next();
        System.out.print("enter destination city : ");
        dest = sc.next();
        System.out.println("\n");

        String _src, _dest;
        try{
            _src = cities.findCity(src).getName();
            _dest = cities.findCity(dest).getName();
        }
        catch(Exception e){
            System.out.println("input cities are invalid or wrong." );
            return;
        }

        Date date = new Date(yr,month,day);
        long start = System.currentTimeMillis();

        indigoFlightData indigo = new indigoFlightData(date,prize,_src,_dest);
        vistaraFlightData vistara = new vistaraFlightData(date,prize,_src,_dest);
        spicejetFlightData spicejet = new spicejetFlightData(date,prize,_src,_dest);

        Future<List<indigo>> indigoData = executorService.submit(indigo);
        Future<List<vistata>> vistaraData = executorService.submit(vistara);
        Future<List<spicejet>> spicejetData = executorService.submit(spicejet);

        data.addAll(indigoData.get());
        data.addAll(vistaraData.get());
        data.addAll(spicejetData.get());

        executorService.shutdown();
        data.stream().sorted((x,y) -> {
            int prize1, prize2;

            if(x instanceof indigo) prize1 = ((indigo)x).prize;
            else if(x instanceof vistata) prize1 = ((vistata)x).prize;
            else prize1 = ((spicejet)x).prize;

            if(y instanceof indigo) prize2 = ((indigo)y).prize;
            else if(y instanceof vistata) prize2 = ((vistata)y).prize;
            else prize2 = ((spicejet)y).prize;

            return prize1 - prize2;
        }).forEach(x -> System.out.println(x));

        long end = System.currentTimeMillis();
        System.out.println("!!!Time consumed in process : " + (end-start));
    }
}