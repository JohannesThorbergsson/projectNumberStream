import java.util.Optional;

public record Student(int id, String name, String zipCode, int age ) {

	protected static Optional<Student> empty() {
		return Optional.empty();
	}
}

