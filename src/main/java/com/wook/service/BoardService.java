package com.wook.service;


import java.util.List;

import com.wook.model.BoardVO;


public interface BoardService {
	
	public void enroll(BoardVO board);
	
	public List<BoardVO> getList();

}
