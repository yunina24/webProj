package co.ina.fileBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBCon;

public class FileDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	public List<FileVO> getFileList(){
		conn = DBCon.getConnect();
		List<FileVO> list = new ArrayList<FileVO>();
		try {
			psmt = conn.prepareStatement("select * from file_board");
			rs = psmt.executeQuery();
			while(rs.next()) {
				FileVO vo = new FileVO();
				vo.setAuthor(rs.getString("author"));
				vo.setTitle(rs.getString("title"));
				vo.setFilename(rs.getString("file_name"));
				vo.setDay(rs.getString("day"));
				vo.setNum(rs.getInt("num"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
		return list;
	}
	
	public FileVO getInsertKeyVal(FileVO vo) {
		conn = DBCon.getConnect();
		//신규번호, 한 건 입력, 한 건 조회
		String selectKey = "slelct nvl(max(num),0)+1 from file_board";
		String insertSql = "insert into file_board values(?, ?, ?, ?, to_char(sysdate, 'YYYY-MM-DD'))";
		String selectSql = "slelct * from file_board where num = ?";
		
		FileVO file = new FileVO();
		int key = 0;
		
		try {
			//키값 호출...
			psmt = conn.prepareStatement(selectKey);
			rs = psmt.executeQuery();
			if(rs.next()) {
				key = rs.getInt(1);
			}
			//새로운 키값 입력...
			psmt = conn.prepareStatement(insertSql);
			psmt.setInt(1, key);
			psmt.setString(2, vo.getAuthor());
			psmt.setString(3, vo.getTitle());
			psmt.setString(4, vo.getFilename());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");
			
			//신규 입력된 키값 전체정보 호출...
			psmt = conn.prepareStatement(selectSql);
			psmt.setInt(1, key);
			rs = psmt.executeQuery();
			if(rs.next()) {
				file.setNum(rs.getInt("num"));
				file.setAuthor(rs.getString("author"));
				file.setTitle(rs.getString("title"));
				file.setFilename(rs.getString("file_name"));
				file.setDay(rs.getString("day"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
		return file;
	}
}
