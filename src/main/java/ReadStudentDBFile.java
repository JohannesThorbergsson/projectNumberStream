import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReadStudentDBFile {

	public static void readLineFromCsv(String csvPath) {
		List<Object> result;
		List<String> legend;
		final Path of = Path.of(csvPath);

		try {
			legend = Arrays.stream(Files.lines(of).findFirst().toString().split(",")).toList();
			System.out.println(" * * * ");
			System.out.println("This is the legend of the incoming stream: ");
			System.out.println(legend.get(0) + " " + legend.get(1) + " " + legend.get(2) + " " + legend.get(3));
			System.out.println(" * * * ");

			result = Files.lines(of)
				.map((String nextLine) -> {
					String[] res = nextLine.split(",");
					if (res.length != 4) {
						System.out.println("Invalid line: " + nextLine + " - adding empty student");
						return Student.empty();
					} else {
						try {
							Student nextStudent = new Student( Integer.parseInt(res[0]), res[1], res[2], Integer.parseInt(res[3]));
							return nextStudent;
						} catch (NumberFormatException e) {
							return Student.empty();
						}
					}
				})
				.collect(Collectors.toList());
//				return result;
		} catch (IOException e) {
			e.printStackTrace();
			result = Collections.emptyList();
		}
		result.stream().map(Object::toString).forEach(System.out::println);
	}
}