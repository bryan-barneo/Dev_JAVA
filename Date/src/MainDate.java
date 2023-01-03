import java.sql.SQLOutput;

public class MainDate {
    public static void main(String[] args) {
        Date d = new Date(21,12,2022);
        Date e = new Date(d);
        if (e.toString().equals(d.toString())) {
            System.out.println("1");
        }
        else {
            System.out.println("0");
        }
    }
}