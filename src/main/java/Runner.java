import java.util.HashMap;
import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        CustomHashTable table = new CustomHashTable();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
//            table.add(random.nextInt(100));
            table.add(i);
//            table.add(i);
        }

        System.out.println(table);

        table.remove(6);

        System.out.println(table);



    }
}
