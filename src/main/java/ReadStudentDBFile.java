import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ReadStudentDBFile {

    public static void readLineFromCsv(String csvPath) {
        List<Student> result;
         {
            try {
                result = Files.lines(Path.of(csvPath)).map(nextLine -> {
                    String[] res = nextLine.split(",");
                    Student nextStudent = new Student( Integer.parseInt(res[0]), res[1], res[2], Integer.parseInt(res[3]));
                    System.out.println(nextStudent);
                    return nextStudent;
                }).collect(Collectors.toList());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(result.toString());
    }
}
