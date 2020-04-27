package testlib.jaas;

import java.security.Principal;

public class CustomPrincipal implements Principal {

	private String name;

	public CustomPrincipal(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public boolean equals(Object o) {
		if (o == null)
			return false;

		if (this == o)
			return true;

		if (!(o instanceof CustomPrincipal))
			return false;
		CustomPrincipal that = (CustomPrincipal) o;

		if (this.getName().equals(that.getName()))
			return true;
		return false;
	}

	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public String toString() {
		return "Principal{" + "name='" + name + '\'' + '}';
	}
}