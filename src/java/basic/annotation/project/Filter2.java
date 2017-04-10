package java.basic.annotation.project;

@Table("address")
public class Filter2 {

	@Column("id")
	private int id;
	@Column("address")
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
