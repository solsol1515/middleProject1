package c_info2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InfoView {

	// 1. 멤버 변수 선언
	
	JFrame f;
	JTextField tfName, tfId,   tfTel, tfGender, tfAge, tfHome;
	JTextArea ta;
	JButton bAdd, bShow, bSearch, bDelete, bCancel, bExit;
	
	// 비즈니스 로직 - 모델단 (데이터 처리하는 중간다리 역할?)
	infoModel model;
	
	// 2. 멤버 변수 객체 생성
	InfoView(){
			// * 프레임
		f = new JFrame("DBTest");							// 프레임 제목 만들어주기
		
			// * 입력 항목(좌측)
		tfName 		= new JTextField(10);					// 이름
		tfId 		= new JTextField(10);					// ID
		tfTel 		= new JTextField(10);					// Tel
		tfGender 	= new JTextField(10);					// Gender
		tfAge 		= new JTextField(10);					// Age
		tfHome		= new JTextField(10);					// Home
		
			// * 입력 공간(우측)
		ta = new JTextArea(5, 20);							// textArea
		
			// * 버튼(하단)
		bAdd 	= new JButton("Add");						// Add
		bShow 	= new JButton("Show");						// Show
		bSearch = new JButton("Search");					// Search
		bDelete = new JButton("Delete");					// Delete			
		bCancel = new JButton("Cancel");					// Cancel
		bExit 	= new JButton("수정하기");						// 수정하기
	
		// 모델 객체 생성
		try {
			model = new InfoModelImpl();					// InfoModelImpl을 model로 받음
		} catch (ClassNotFoundException e) {
			e.printStackTrace();							// 에러 발생 근원지 찾아 단계별로 에러 출력
		}
	}  // end of InfoView()

	
	// 3. 화면 구성 & 출력 borderlayout - west center(텍스트 에어리어) east south(패널)
	
	/* 전체 프레임 BorderLayout
	   WEST: JPanel (GridLayout(6, 2))
	   CENTER: textArea
	   SOUTH: JPanel GridLayout(1, 6)
	 */
	
	public void addLayout() {
		// 붙이기 작업
		// 프레임_붙이기
		f.setLayout(new BorderLayout());
		
		// 좌측 textField_붙이기(JPanel(GridLayout(6, 2))
		JPanel pWest = new JPanel();
		pWest.setLayout(new GridLayout(6, 2));
		f.add(pWest, BorderLayout.WEST);
		pWest.add(new JLabel("Name",JLabel.CENTER));
		pWest.add(tfName);
		pWest.add(new JLabel("Id",JLabel.CENTER));
		pWest.add(tfId);
		pWest.add(new JLabel("Tel",JLabel.CENTER));
		pWest.add(tfTel);
		pWest.add(new JLabel("Gender",JLabel.CENTER));
		pWest.add(tfGender);
		pWest.add(new JLabel("Age",JLabel.CENTER));
		pWest.add(tfAge);
		pWest.add(new JLabel("Home",JLabel.CENTER));
		pWest.add(tfHome);
		
		// 우측 textArea_붙이기
		f.add(ta, BorderLayout.CENTER);
		
		// 하단 버튼_붙이기
		JPanel pSouth = new JPanel();				// 만들기
		pSouth.setLayout(new GridLayout(1,6));		// 그리드 선언
		f.add(pSouth, BorderLayout.SOUTH);			// 프레임 안에 붙이기 
		pSouth.add(bAdd);							// 그리드 안에 버튼 붙이기 ↓
		pSouth.add(bShow);
		pSouth.add(bSearch);
		pSouth.add(bDelete);
		pSouth.add(bCancel);
		pSouth.add(bExit);
		
		// 화면 출력
		f.setBounds(100, 100, 550, 350);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void eventProc() {
		// 입력한 정보 데이터에 저장하기 (textfield)
		bAdd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				insertData();
			}
		});

		// 입력되어 있는 정보 출력하기 (textarea)	
		bShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectAll();
			}
		});
		
		// 입력되어 있는 정보 가져오기 (textfield)
		bSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectByTel();	
			}
		});
		
		// 전화번호로 입력되어 있는 정보 찾기
		tfTel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectByTel();
			}
		});
		
		// 전화번호로 입력되어 있는 정보 삭제하기
		bDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteByTel();
			}
		});
		
		// 전화번호로 입력되어 있는 정보 수정하기
		bExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modify();
			}
		});
		
	} // end of eventProc()
	
	// * 데이터 수정하기(수정하기) modify()
	void modify() {
		// (1) 사용자 입력 값 얻어오기
			String name 	= tfName.getText();
			String id 		= tfId.getText();
			String tel 		= tfTel.getText();
			String gender 	= tfGender.getText();
			int age 		= Integer.parseInt(tfAge.getText());
			String home 	= tfHome.getText();
			
		// (2) 1번의 값들을 infoVO에 지정
			InfoVO vo = new InfoVO(name, id, tel, gender, age, home);
			vo.setName(name);
			vo.setId(id);
			vo.setTel(tel);
			vo.setGender(gender);
			vo.setAge(age);
			vo.setHome(home);	
		
			try {
				model.modify(vo);
				
		// (3) 화면을 지우고
			clearText();
			} catch (SQLException e) {
				ta.setText("수정 실패: " + e.getMessage());
			}
	} //end of modify()

	// * 전화번호를 이용해 데이터 삭제하기(DELETE) deleteByTel()
	void deleteByTel() {
		// (1) 입력한 전화번호 값 삭제하기
		String tel = tfTel.getText();
		// (2) 모델단에 deleteByTel() 호출
		try {
			model.delete(tel);
		
		// (3) 화면을 지우고
		clearText();
		} catch (SQLException e) {
			ta.setText("삭제 실패: " + e.getMessage());
		}
	} // end of delete()
	
	// * 전화번호를 이용해 데이터 조회하는 메소드(SEARCH) selectByTel()
	void selectByTel() {
		try {
		// (1) 입력한 전화번호 값 얻어오기
		String tel = tfTel.getText();
		
		// (2) 모델단에 selectByTel() 호출
		InfoVO vo = model.selectByTel(tel);
		
		// (3) 받은 결과를 각각의 화면의 텍스트필드에 지정(출력)
			tfName.setText(vo.getName());
			tfId.setText(vo.getId());
			tfTel.setText(vo.getTel());
			tfAge.setText(String.valueOf(vo.getAge()));
			tfGender.setText(vo.getGender());
			tfHome.setText(vo.getHome());
		}catch(Exception ex) {
			ta.setText("전화번호 검색 실패: " + ex.getMessage());
		} // end of catch(Exception ex)
		
	} // end of selectByTel()
	
	// * 전체 데이터 조회하는 메소드(SHOW) selectAll() 
	void selectAll() {  
		try {
			ArrayList<InfoVO> data = model.selectAll();
			ta.setText("---------------------------- 검색결과 ---------------------------\n");
			for(InfoVO vo : data) {
				ta.append(vo.toString());	// 인수로 전달된 값을 문자열로 변환 후, 해당 문자열의 마지막에 추가(이어붙이기)	
			} // end of for
		} catch (SQLException e) {
			ta.setText("검색실패: "+e.getMessage());
		}
	} // end of selectAll()
	
	// * 데이터 입력하는 메소드(ADD) insertData()
	void insertData() {
		// (1) 사용자 입력 값 얻어오기
		String name 	= tfName.getText();
		String id 		= tfId.getText();
		String tel 		= tfTel.getText();
		String gender 	= tfGender.getText();
		int age 		= Integer.parseInt(tfAge.getText());
		String home 	= tfHome.getText();
		
		// (2) 1번의 값들을 infoVO에 지정
		InfoVO vo = new InfoVO();
			// InfoVO vo = new InfoVO(name, id, tel, gender, age, home);
		
		vo.setName(name);
		vo.setId(id);
		vo.setTel(tel);
		vo.setGender(gender);
		vo.setAge(age);
		vo.setHome(home);
		
		// (3) 모델의 insertInfo() 호출
		try {
			model.insertInfo(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// (4) 화면의 입력 값들을 지우기 
		clearText();
		
	} // insertData()
	
	// * 입력 필드 지우기 clearText()
	void clearText() {
		tfName.setText(null);
		tfId.setText(null);
		tfTel.setText(null);
		tfGender.setText(null);
		tfAge.setText(null);
		tfHome.setText(null);
	} // end of clearText()
	
	public static void main(String[] args) {
		
		InfoView info = new InfoView();
		info.addLayout();
		info.eventProc();

	} 


}
