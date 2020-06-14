package testlib.clone;

public class C2 {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public C2() {}

	public C2(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "C2 [id=" + id + "]";
	}
	
}
