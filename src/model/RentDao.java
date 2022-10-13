package model;

import java.util.ArrayList;

public interface RentDao {

	// 대여
	public void rentVideo(String tel, int vnum) throws Exception; // 고객 전화번호, 비디오 번호
	
	// 반납
	public void returnVideo(int vnum) throws Exception; // 비디오 번호
	
	// 미납 목록 검색 
	public ArrayList selectList() throws Exception;
	
	// 대여관리 화면에서 전화번호 입력 후 엔터 쳤을 때 이름 얻어오기
	public String rentSelectTel(String tel) throws Exception;
}
