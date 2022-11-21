package middleProject.service;

import java.util.List;

import middleProject.domain.GoodsTypeVO;
import middleProject.domain.GoodsVO;
import middleProject.domain.MemberVO;

public interface JudaService {
	
	List<GoodsVO> getGoodsList(GoodsTypeVO vo);
	
	Integer insertMember(MemberVO vo);

}
