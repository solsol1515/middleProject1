package middleProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import middleProject.dao.JudaDAO;
import middleProject.domain.GoodsTypeVO;
import middleProject.domain.GoodsVO;
import middleProject.domain.MemberVO;

@Service("judaService")
public class JudaServiceImpl implements JudaService {
	
	@Autowired
	private JudaDAO judaDAO;
	
	public List<GoodsVO> getGoodsList(GoodsTypeVO vo) {
		return judaDAO.getGoodsList(vo);
	}

	public Integer insertMember(MemberVO vo) {
		return judaDAO.insertMember(vo);
	}

}
