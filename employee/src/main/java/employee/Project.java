package employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Transient;

@Entity
public class Project {
@Id
private int pid;
private String pname;
private String pdomain;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getPdomain() {
	return pdomain;
}
public void setPdomain(String pdomain) {
	this.pdomain = pdomain;
}


}
