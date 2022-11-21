package middleProject.dao;

import java.util.List;

import middleProject.domain.GoodsTypeVO;
import middleProject.domain.GoodsVO;
import middleProject.domain.MemberVO;

public interface JudaDAO {
	
	List<GoodsVO> getGoodsList(GoodsTypeVO vo);
	
	Integer insertMember(MemberVO vo);
	
}
