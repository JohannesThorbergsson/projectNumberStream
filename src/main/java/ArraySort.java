import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ArraySort {
    static int[] zahlen = new int[]{9, 1, 8, 2, 7, 3, 6, 4, 5};

    public static void main(String[] args) {
        List<Integer> result = Arrays.stream(zahlen).boxed().sorted().collect(Collectors.toList());
        Integer result4 = Arrays.stream(zahlen).reduce(1, (sum, number) -> sum * number);
        Integer result2 = Arrays.stream(zahlen).reduce(0, (sum, number) -> sum + number );



        String result3 = Arrays.stream(zahlen).mapToObj(number -> String.valueOf(number)).reduce("Numbers: ", (prev, next) -> prev + "-" + next);
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);


        ReadStudentDBFile.readLineFromCsv("../resources/students.csv");


    }
}
