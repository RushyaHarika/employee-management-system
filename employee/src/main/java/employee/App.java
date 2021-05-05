package employee;

import java.util.*;


public class App {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("1.Add Employee");
		System.out.println("2.Remove Employee");
		System.out.println("3.View Employees");
		System.out.println("4.Add new project");
		System.out.println("5.Allocate project to an employee");
		
		int n = sc.nextInt();
		
		EmployeeModel empm = new EmployeeModel();
		
		Admin admin = new Admin();
		User user = new User();
		
		switch(n) {
		
		case 1: System.out.println("Enter employee role, id, name, salary and password");
				String role = sc.next();
				int id = sc.nextInt();
				String name = sc.next();
				double salary = sc.nextDouble();
				String password = sc.next();
				
				if(role.contentEquals("admin")) {
					admin.setEid(id);
					admin.setEname(name);
					admin.setErole(role);
					admin.setPassword(password);
					admin.setSalary(salary);
					empm.create(admin);
				} else if(role.contentEquals("user")) {
					user.setEid(id);
					user.setEname(name);
					user.setErole(role);
					user.setPassword(password);
					user.setSalary(salary);
					empm.create(user);
				}
				break;
				
		case 2: System.out.println("Enter eid of the employee whose data is to be deleted");		
				int deletion_id = sc.nextInt();
				empm.remove(deletion_id);				
				break;
				
		case 3: empm.view();
				
				break;
				
		case 4: System.out.println("Enter project id, project name and project domain");
				int pid = sc.nextInt();
				String pname = sc.next();
				String pdomain = sc.next();
				Project proj = new Project();
				proj.setPid(pid);
				proj.setPname(pname);
				proj.setPdomain(pdomain);
				empm.addProject(proj);
				break;
				
		case 5: System.out.println("Enter the employee id and project id");
				int empid = sc.nextInt();
				int projid = sc.nextInt();
				empm.allocateProject(empid, projid);
				break;
		}
	    

	}

}
