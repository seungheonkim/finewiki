package com.sesac.finewiki.persistence;

import java.util.List;
import com.sesac.finewiki.vo.ReplyVo;

public interface ReplyDAO {
	List<ReplyVo> list(Integer article_no) throws Exception;

	void create(ReplyVo replyVO) throws Exception;

	void update(ReplyVo replyVO) throws Exception;

	void delete(Integer reply_no) throws Exception;
}
