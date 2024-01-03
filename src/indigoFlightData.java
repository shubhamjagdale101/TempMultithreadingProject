import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class indigoFlightData implements Callable<List<indigo>> {
    List<indigo> list;
    private Date date;
    private int prize;
    private String src;
    private String dest;

    public indigoFlightData(Date date, int prize, String src, String dest) {
        this.date = date;
        this.prize = prize;
        this.src = src;
        this.dest = dest;
        this.list = new ArrayList<>();
    }

    private void addData(){
        String[] _cities = {
                cities.MUMBAI.getName(),
                cities.CHENNAI.getName(),
                cities.HYDERABAD.getName(),
                cities.PUNE.getName(),
                cities.BENGALURU.getName(),
                cities.LUCKNOW.getName(),
                cities.CHANDIGARH.getName(),
                cities.SIKKIM.getName(),
                cities.DELHI.getName(),
                cities.KOLKATA.getName(),
                cities.AHMEDABAD.getName(),
                cities.JAIPUR.getName(),
                cities.VARANASI.getName(),
                cities.KOCHI.getName(),
                cities.MYSURU.getName(),
                cities.GOA.getName(),
                cities.PATNA.getName(),
                cities.BHOPAL.getName(),
                cities.NAGPUR.getName()
        };

        for(int i=0; i<_cities.length; i++){
            for(int j=0; j< _cities.length; j++){
                if(i == j) continue;

                for(int k=1; k<=100; k++){
                    int id = (int)(Math.random()*10000);
                    int prize = (int)(Math.random() * 100000);
                    int day = (int)(Math.random()*1000) % 30 + 1;
                    int month = (int)(Math.random()*1000) % 12 + 1;
                    int year = (int)(Math.random()*10) % 2;

                    if(year == 1) year = 2023;
                    else year = 2024;

                    Date date = new Date(year,month,day);
                    list.add(new indigo(id,_cities[i],_cities[j],date,prize));
                }
            }
        }
    }

    public indigoFlightData(String src, String dest){
        this.list = new ArrayList<>();
        this.date = new Date();
        this.prize = Integer.MAX_VALUE;
        this.src = src;
        this.dest = dest;
    }

    private boolean cmpDate(Date date){
        long d1 = this.date.getDate(), d2 = date.getDate();
        long m1 = this.date.getMonth(), m2 = date.getMonth();

        //        check for all date present int that month and after the selected day
        return d1 <= d2 && m1 == m2;
    }

    @Override
    public List<indigo> call() throws Exception {
        this.addData();
        List<indigo> data = list.stream().filter(x -> this.src.equals(x.src) && this.dest.equals(x.dest) && this.cmpDate(x.date) && x.prize <= prize).collect(Collectors.toList());
        return data;
    }
}
