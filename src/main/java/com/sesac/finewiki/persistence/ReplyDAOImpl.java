package com.sesac.finewiki.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.sesac.finewiki.vo.ReplyVo;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	private static String NAMESPACE = "com.cameldev.mypage.mappers.reply.ReplyMapper";
	private final SqlSession sqlSession;

	@Inject
	public ReplyDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<ReplyVo> list(Integer article_no) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".list", article_no);
	}

	@Override
	public void create(ReplyVo replyVO) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", replyVO);
	}

	@Override
	public void update(ReplyVo replyVO) throws Exception {
		sqlSession.update(NAMESPACE + ".update", replyVO);
	}

	@Override
	public void delete(Integer reply_no) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", reply_no);
	}
}
