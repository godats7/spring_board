package com.wook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wook.mapper.BoardMapper;
import com.wook.model.BoardVO;
import com.wook.model.Criteria;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper mapper;

	@Override
	public void enroll(BoardVO board) {
		// TODO Auto-generated method stub
		mapper.enroll(board);
		
	}

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public BoardVO getPage(int bno) {
		// TODO Auto-generated method stub
		return mapper.getPage(bno);
	}

	@Override
	public int modify(BoardVO board) {
		// TODO Auto-generated method stub
		return mapper.modify(board);
	}

	@Override
	public int delete(int bno) {
		// TODO Auto-generated method stub
		return mapper.delete(bno);
	}

	@Override
	public List<BoardVO> getListPaging(Criteria criteria) {
		// TODO Auto-generated method stub
		return mapper.getListPaging(criteria);
	}

	@Override
	public int getTotal(Criteria criteria) {
		// TODO Auto-generated method stub
		return mapper.getTotal(criteria);
	}
	
	
	
	
	
	

}
