package employee;

import javax.persistence.Entity;

@Entity
public class User extends Employee{
	
	private String eproject;
	
	public String getEproject() {
		return eproject;
	}

	public void setEproject(String eproject) {
		this.eproject = eproject;
	}

	@Override
	public String toString() {
		return "User [eproject=" + eproject + ", getEid()=" + getEid() + ", getEname()=" + getEname()
				+ ", getSalary()=" + getSalary() + ", getErole()=" + getErole()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
}

