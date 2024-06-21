package bank.model.user;

public interface Citizen {

	public int getAge();

	public String getTc();

	public String getName();

	public String getLastName();

	public String getGender();

	public void setAge(int age);

	public void setTc(String tc);

	public void setName(String name);

	public void setLastName(String lastName);

	public void setGender(String gender);
}
