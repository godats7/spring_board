package com.wook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wook.model.BoardVO;
import com.wook.service.BoardService;

@Controller
@RequestMapping("/board")

public class BoardController {
	
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
		/* 게시판 목록 페이지 접속 */
		@GetMapping("/list")
	    // => @RequestMapping(value="list", method=RequestMethod.GET)
	    public void boardListGet() {
	        
	        log.info("게시판 목록 페이지 진입");
	        
	    }
	    
		/* 게시판 등록 페이지 접속 */
	    @GetMapping("/enroll")
	    // => @RequestMapping(value="enroll", method=RequestMethod.GET)
	    public void boardEnrollGet() {
	        
	        log.info("게시판 등록 페이지 진입");
	        
	    }
	    
	    /* 게시판 등록 */
	    @PostMapping("/enroll")
	    public String boardEnrollPost(BoardVO board, RedirectAttributes rttr) {
	        
	        log.info("BoardVO : " + board);
	        
	        boardService.enroll(board);
	        
	        rttr.addFlashAttribute("result", "enroll success");
	        
	        return "redirect:/board/list";
	        
	    }
	
	

}
