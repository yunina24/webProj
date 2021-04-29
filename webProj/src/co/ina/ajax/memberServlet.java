package co.ina.ajax;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	// get은 조회용으로 추천
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); // 한글 깨짐 방지
//		response.getWriter().print("<h2>정상적으로 조회되었습니다.</h2>");
		// 조회용 SQL
		// 조회결과를 json형식으로 작성
		// [{"id": 1, "name": "hong", "age": 20},
		// {"id": 1, "name": "hong", "age": 20},
		// {"id": 1, "name": "hong", "age": 20}]

		// 결과를 response.getWriter().print(); 출력

		Connection conn = DBCon.getConnect();
		PreparedStatement psmt = null;
		ResultSet rs = null;

		String SQL = "SELECT MEMBER_ID, MEMBER_NAME, MEMBER_AGE FROM MEMBER";
		String json = "[";
		try {
			psmt = conn.prepareStatement(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = psmt.executeQuery();
			while (rs.next()) {
				String mId = rs.getString(1);
				String mName = rs.getString(2);
				int mAge = rs.getInt(3);

				json += "{\"ID\":\"" + mId + "\",\"NAME\":\"" + mName + "\",\"AGE\":" + mAge + "}";
				if (!rs.isLast()) {
					json += ",";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		}
		json += "]";
		response.getWriter().print(json);

	}

	// pest는 정보입력용으로 추천
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
	    String json = "{\"ID\":" + p1 + ",\"NAME\":\"" + p2 + "\",\"AGE\":" + p3 + "}";
		response.getWriter().print(json);
		response.setContentType("text/html;charset=UTF-8"); //한글 깨짐 방지
//		response.getWriter().print("<h2>정상적으로 입력되었습니다.</h2>");
	}
}
