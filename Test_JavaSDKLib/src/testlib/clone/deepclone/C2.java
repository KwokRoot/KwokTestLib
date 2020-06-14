package testlib.clone.deepclone;

import java.io.Serializable;

public class C2 implements Serializable{

	private static final long serialVersionUID = 1L;
	
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
