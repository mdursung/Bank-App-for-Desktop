package bank.model.user;

public abstract class User implements Citizen {

	protected int age;
	protected String tc;
	protected String name;
	protected String lastName;
	protected String gender;

	public User(String tc, String name, String lastName, String gender, int age) {
		this.tc = tc;
		this.age = age;
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
	}

	@Override
	public String getTc() {
		return tc;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public String getGender() {
		return gender;
	}

	@Override
	public void setTc(String tc) {
		this.tc = tc;
	}

	@Override
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public void setGender(String gender) {
		this.gender = gender;
	}
}
