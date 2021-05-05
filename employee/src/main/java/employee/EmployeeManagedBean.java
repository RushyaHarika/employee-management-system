package employee;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@SessionScoped
@ManagedBean(name="employeeManagedBean")
public class EmployeeManagedBean {

	private User employee;
	
	private Project pro;
	
	private List<User> users;

	public User getEmployee() {
		return employee;
	}
	
	public void setEmployee(User employee) {
		this.employee = employee;
	}


	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	
	
	public Project getPro() {
		return pro;
	}

	public void setPro(Project pro) {
		this.pro = pro;
	}

	public EmployeeManagedBean() {
		this.employee = new User();
		this.pro = new Project();
	}
	
	public String callAdd() {
		return "add?faces-redirect=true";
	}

	public String callRemove() {
		return "remove?faces-redirect=true";
	}
	
	public String callView() {
		return "view?faces-redirect=true";
	}
	
	public String callAddProject() {
		return "addproject?faces-redirect=true";
	}
	
	public String callAllocateProject() {
		return "allocateproject?faces-redirect=true";
	}
	
	public String save() {
		EmployeeModel empModel = new EmployeeModel();
		empModel.create(this.employee);
		return "success?faces-redirect=true";
	}
	
	public String delete() {
		EmployeeModel empModel = new EmployeeModel();
		empModel.remove(this.employee.getEid());
		return "success?faces-redirect=true";
	}
	
	public String view() {
		EmployeeModel empModel = new EmployeeModel();
		 this.setUsers(empModel.view());
		System.out.println("View() method called");
		//return "success?faces-redirect=true";
		return "";
	}
	
	public String saveProject() {
		EmployeeModel empModel = new EmployeeModel();
		empModel.addProject(this.pro);
		return "success?faces-redirect=true";
	}
	
	public String allocateProject() {
		EmployeeModel empModel = new EmployeeModel();
		empModel.allocateProject(this.employee.getEid(),this.pro.getPid());
		return "success?faces-redirect=true";
	}
}
