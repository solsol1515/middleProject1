package middleProject.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import middleProject.domain.GoodsTypeVO;
import middleProject.domain.GoodsVO;
import middleProject.domain.MemberVO;

@Repository("judaDAO")
public class JudaDAOImpl implements JudaDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<GoodsVO> getGoodsList(GoodsTypeVO vo) {
		System.out.println(vo);
		return mybatis.selectList("JudaMap.getGoodsList", vo);
	}

	public Integer insertMember(MemberVO vo) {
		return mybatis.insert("JudaMap.insertMember", vo);
	}

}
