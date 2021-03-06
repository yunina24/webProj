package co.ina.plugin;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.EmpDAO;

@WebServlet("/empByDeptServlet")
public class empByDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public empByDeptServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDAO dao = new EmpDAO();
		Map<String, Integer> map = dao.getEmployeeByDept(); //부서이름 | 해당 부서 사원수
		
	      String json = "[";
	      Set<String> keyset = map.keySet();
	      Iterator<String> iter = keyset.iterator();
	      while(iter.hasNext()) {
	         String key = iter.next();
	         Integer val = map.get(key);
	         json += "[\"" + key + "\"," + val + "]";
	         if(iter.hasNext()) {
	            json += ",";
	         }
		}
		json += "]";
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
