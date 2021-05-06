package co.ina.fileBoard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/getFileServlet")
public class getFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public getFileServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		String num = request.getParameter("num"); //글 번호로 upload의 linkClickCallBack 기능 안에 서블릿 내용이 넘어감
		int fileNum = Integer.parseInt(num);
		
		FileDAO dao = new FileDAO();
		FileVO vo = dao.getFile(fileNum);
		
		JSONObject obj = new JSONObject();
		obj.put("num", vo.getNum());
	    obj.put("author", vo.getAuthor());
	    obj.put("title", vo.getTitle());
	    obj.put("day", vo.getDay());
	    obj.put("fileName", vo.getFilename());
	    
	    response.getWriter().print(obj);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
