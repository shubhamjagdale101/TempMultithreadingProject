import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

public class vistata{
    private int id;
    public String src, dest;
    public Date date;
    public int prize;
    public static final String name = "Vistara";

    @Override
    public String toString() {
        return "vistata\n" +
                "{" + '\n' +
                "src = " + src + " - " + "dest = " + dest + '\n' +
                "date = " + date.getDate() + '-' + date.getMonth() + '-' + date.getYear() + '\n' +
                "prize = " + prize + '\n' +
                '}' + '\n';
    }

    public vistata(int id, String src, String dest, Date date, int prize) {
        this.id = id;
        this.src = src;
        this.dest = dest;
        this.date = date;
        this.prize = prize;
    }
}
