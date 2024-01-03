import java.util.Date;

public class spicejet {
    private int id;
    public String src, dest;
    public Date date;
    public int prize;
    public static final String name = "Indigo";
    public spicejet(int id, String src, String dest, Date date, int prize) {
        this.id = id;
        this.src = src;
        this.dest = dest;
        this.date = date;
        this.prize = prize;
    }

    @Override
    public String toString() {
        return "spicejet\n" +
                "{" + '\n' +
                "src = " + src + " - " + "dest = " + dest + '\n' +
                "date = " + date.getDate() + '-' + date.getMonth() + '-' + date.getYear() + '\n' +
                "prize = " + prize + '\n' +
                '}' + '\n';
    }
}
