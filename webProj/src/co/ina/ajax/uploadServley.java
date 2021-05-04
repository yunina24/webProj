package co.ina.ajax;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/jqurey/uploadServlet")
public class uploadServley extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    public uploadServley() {
        super();
    }
    
    @Override
       public void init() throws ServletException {
       System.out.println("init call()");
    }

//    @Override
//       protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       System.out.println("Service call()");
//       Enumeration<String> enumer = req.getHeaderNames();
//       while(enumer.hasMoreElements()) {
//          String key = enumer.nextElement();
//          String val = req.getHeader(key);
//          System.out.println(key + " : " + val);
//       }
//    }
    
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("doget call()");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("dopost call()");
      String path = "c:/temp";
      
      ServletContext sc = this.getServletContext();
      path = sc.getRealPath("uplaod"); //서버상의 경로
      
      MultipartRequest multi = new MultipartRequest(request, "c:/temp", 8 * 1024 * 1024, "UTP-8", new DefaultFileRenamePolicy());
      Enumeration en = multi.getFileNames();
      while (en.hasMoreElements()) {
    	  String name = (String) en.nextElement();
    	  String fileName = multi.getFilesystemName(name);
    	  System.out.println("name: " + name + ", fileName :" + fileName);
    	  
      }
   }

}