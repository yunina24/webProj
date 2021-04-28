package co.ina.ajax;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.DBCon;

@WebServlet("/jquery/memberServlet.do")
public class memberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public memberServlet() {
        super();
    }

    //get은 조회용으로 추천
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); //한글 깨짐 방지
		response.getWriter().print("<h2>정상적으로 조회되었습니다.</h2>");
		
		Connection conn = DBCon.getConnect();
		PreparedStatement psmt = null;
		
		String SQL = "SELECT * FROM MEMBER";
		psmt = conn.prepareStatement(SQL);
		
		String jsonData = "[";
		int cnt = 0;
		for (Employee emp : list) {
	         jsonData += "{\"mId\": \"" + emp.getEmployeeId()//
	               + "\",\"mName\": \"" + emp.getSalary()//
	               + "\",\"mAge\": \"" + emp.getHireDate()//
	               + "\"}";
	         if (++cnt == list.size()) {
	            continue;
	         }
	         jsonData += ",";
	      }
	      jsonData += "]";
	      response.getWriter().print(jsonData);
	   

		
		
		//조회용 SQL
		//조회결과를 json형식으로 작성
		//[{"id": 1, "name": "hong", "age": 20},
		//{"id": 1, "name": "hong", "age": 20},
		//{"id": 1, "name": "hong", "age": 20}]
		
		//결과를 response.getWriter().print(); 출력
	}
	//pest는 정보입력용으로 추천
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p1 = request.getParameter("m_id");
		String p2 = request.getParameter("m_name");
		String p3 = request.getParameter("m_age");
		
		Connection conn = DBCon.getConnect();
		PreparedStatement psmt = null;
		
		String SQL = "INSERT INTO MEMBER VALUES(?, ?, ?)";
		try {
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, p1);
			psmt.setString(2, p2);
			psmt.setString(3, p3);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		response.setContentType("text/html;charset=UTF-8"); //한글 깨짐 방지
		response.getWriter().print("<h2>정상적으로 입력되었습니다.</h2>");
	}
}
