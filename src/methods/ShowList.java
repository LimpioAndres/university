package methods;

import java.util.List;

public class ShowList {
    public static void listDetailed(List<?> list){
        for (Object count: list){
            System.out.println(count);
        }
    }
}
