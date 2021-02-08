package studies.java8.features;

public interface DefaultMethods {
	default public boolean isValidEmployee(String código) {
		return false;
	}
}
