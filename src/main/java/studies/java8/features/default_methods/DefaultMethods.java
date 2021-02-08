package studies.java8.features.default_methods;

public interface DefaultMethods {
	default public boolean isValidEmployee(String código) {
		return false;
	}
}
