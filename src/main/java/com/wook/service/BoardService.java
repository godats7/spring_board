package com.wook.service;


import java.util.List;

import com.wook.model.BoardVO;
import com.wook.model.Criteria;


public interface BoardService {
	
	public void enroll(BoardVO board);
	
	public List<BoardVO> getList();
	
	public BoardVO getPage(int bno);
	
	public int modify(BoardVO board);
	
	public int delete(int bno);
	
	public List<BoardVO> getListPaging(Criteria criteria);
	
	public int getTotal(Criteria criteria);

}
