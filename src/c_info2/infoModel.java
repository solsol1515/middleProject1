package c_info2;

import java.sql.SQLException;
import java.util.ArrayList;

public interface infoModel {

	void insertInfo(InfoVO vo) throws SQLException;// end of insertInfo()

	ArrayList<InfoVO> selectAll() throws SQLException; // end of selectAll()

	
	/*
	 * 전화번호를 넘겨받아서 해당하는 사람의 정보 검색 
	 */
	
	InfoVO selectByTel(String tel) throws SQLException;
	
	
	/*
	 * 전화번호를 넘겨 받아서 해당하는 사람의 정보 삭제 
	 */
	
	int delete(String tel) throws SQLException;
	
	void modify(InfoVO vo) throws SQLException;
	
	
}