
import java.util.Arrays;

public class WorkShop {
    public static void main(String[] args) {
        Friend[] friends ={
            new Friend("Вася",12,true,12.3f),
            new Friend("Петя",16,true,12.1f)
        };

        System.out.println("Мои друзья " + Arrays.toString(friends));
    }
}
