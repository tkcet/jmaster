package kadai50add;

public class Emp {
	private String code;
	private String name;
	private int age;
	private String tel;

	public Emp() {

	}

	public Emp(String code, String name, int age, String tel) {
		this.code = code;
		this.name = name;
		this.age = age;
		this.tel = tel;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
