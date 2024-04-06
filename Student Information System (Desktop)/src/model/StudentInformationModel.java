package model;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")

public class StudentInformationModel extends DefaultTableModel{
	private Integer StudNo;
	private String firstname;
	private String lastname;
	private String sex;
	private String sexuality;
	private Integer age;
	private Integer yearlvl;
	private String program;
	private static final Object[] table_header = { "Student No", "FirstName",
            "Lastname", "Sex", "Sexuality", "Age", "Year level", "Program" };
	private static final Object[][] data = {};
	

	public Integer getStudNo() {
		return StudNo;
	}
	public void setStudNo(Integer studNo) {
		StudNo = studNo;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSexuality() {
		return sexuality;
	}
	public void setSexuality(String sexuality) {
		this.sexuality = sexuality;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getYearlvl() {
		return yearlvl;
	}
	public void setYearlvl(Integer yearlvl) {
		this.yearlvl = yearlvl;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	
	public StudentInformationModel() {
		super(data, table_header);
	}
	
	
}
