package co.ina.fileBoard;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileUploadServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");

		System.out.println("dopost call()");
		String path = "c:/temp";

		ServletContext sc = this.getServletContext();
		path = sc.getRealPath("upload"); // 서버상의 경로

		// 서버에 파일 올리는 ...
		MultipartRequest multi = new MultipartRequest(request, path, 8 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
		Enumeration en = multi.getFileNames();

		String author = multi.getParameter("author");
		String title = multi.getParameter("title");
		String fileN = null;

		while (en.hasMoreElements()) {
			String name = (String) en.nextElement();
			String fileName = multi.getFilesystemName(name);
			fileN = fileName;
			System.out.println("name: " + name + ", fileName :" + fileName);
		}
		FileDAO dao = new FileDAO();
		FileVO vo = new FileVO();
		vo.setAuthor(author);
		vo.setFilename(fileN);
		vo.setTitle(title);
		FileVO rvo = dao.getInsertKeyVal(vo);
		JSONObject obj = new JSONObject();
		obj.put("num", rvo.getNum());
		obj.put("author", rvo.getAuthor());
		obj.put("title", rvo.getTitle());
		obj.put("day", rvo.getDay());
		obj.put("fileName", rvo.getFilename());

		response.getWriter().print(obj);
	}
}
