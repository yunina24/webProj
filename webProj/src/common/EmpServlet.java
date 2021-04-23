package common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/empList.do")
public class EmpServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		String dept = req.getParameter("dept");
		
		EmpDAO dao = new EmpDAO();
		List<Employee> list = null;
		
		if(dept == null) {
			list = dao.getEmpList();
		} else {
			list = dao.getEmpByDept(dept);
		}
		
		// 제이슨 타입[{"empId":"?", "fName": "?", "lName": "?"}, ... ]
		String jsonData = "[";
		int cnt = 0;
		for(Employee emp : list) {
			jsonData += "{\"empId\":\"" + emp.getEmployeeId()//
						+ "\", \"fName\":\"" + emp.getFirstName()//
						+ "\", \"lName\":\"" + emp.getLastName()//
						+ "\", \"email\":\"" + emp.getEmail()//
						+ "\", \"hrieDate\":\"" + emp.getHireDate()//
						+ "\", \"jId\":\"" + emp.getJobId()//
						+ "\", \"salary\":\"" + emp.getSalary()//
						+ "\"}";
			if(++cnt == list.size()) {
				continue;
			}
			jsonData += ",";
		}
		jsonData += "]";
		
		out.println(jsonData);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("first_name");
		String lastName = req.getParameter("last_name");
		String email = req.getParameter("email");
		String hireDate = req.getParameter("hire_date");
		String jobId = req.getParameter("job_id");
		String salary = req.getParameter("salary");
		int sal = Integer.parseInt(salary);
		
		Employee emp = new Employee();
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setEmail(email);
		emp.setHireDate(hireDate);
		emp.setJobId(jobId);
		emp.setSalary(sal);
		
		EmpDAO dao = new EmpDAO();
		Employee emp1 = dao.insertEmpBySeq(emp);
		
		// { "eid":"?","fName":"?", ... }
		PrintWriter out = resp.getWriter();
		out.print("{\"employee_id\":\"" + emp1.getEmployeeId() + "\","//
				+ "\"first_name\":\"" + emp1.getFirstName() +"\","//
				+ "\"last_name\":\"" + emp1.getLastName() + "\","//
				+ "\"email\":\"" + emp1.getEmail() + "\","//
				+ "\"hire_date\":\"" + emp1.getHireDate() + "\","//
				+ "\"job_id\":\"" + emp1.getJobId() + "\","//
				+ "\"salary\":\"" + emp1.getSalary() + "\""
				+ "}");
	}
}
