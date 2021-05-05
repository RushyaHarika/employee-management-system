package employee;

import javax.persistence.Entity;

@Entity
public class Admin extends Employee{

	@Override
	public String toString() {
		return "Admin [getEid()=" + getEid() + ", getEname()=" + getEname()
				+ ", getSalary()=" + getSalary() + ", getErole()=" + getErole() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	

}