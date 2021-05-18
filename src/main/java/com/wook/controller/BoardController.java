package com.wook.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wook.model.BoardVO;
import com.wook.model.Criteria;
import com.wook.model.PageMakerDTO;
import com.wook.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	
	@Autowired
	private BoardService boardService;
	
//		 /* 게시판 목록 페이지 접속 */
//	    @GetMapping("/list")
//	    // => @RequestMapping(value="list", method=RequestMethod.GET)
//	    public void boardListGet(Model model) {
//	        
//	        log.info("게시판 목록 페이지 진입");
//	        
//	        model.addAttribute("list", boardService.getList());
//	        
//	    }
	    
		/* 게시판 목록 페이지 접속(페이징 적용) */
	    @GetMapping("/list")
	    public void boardListGet(Model model, Criteria criteria) {
	        
	        log.info("boardListGET");
	        
	        model.addAttribute("list", boardService.getListPaging(criteria));
	        
	        int total = boardService.getTotal(criteria);
	        
	        PageMakerDTO pageMake = new PageMakerDTO(criteria, total);
	        
	        model.addAttribute("pageMaker", pageMake);	             
	        
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
	    
	    /* 게시판 조회 */
	    @GetMapping("/get")
	    public void boardGetPageGet(int bno, Model model, Criteria criteria) {
	        
	        model.addAttribute("pageInfo", boardService.getPage(bno));
	        
	        model.addAttribute("criteria", criteria);
	        
	    }
	    
	    /* 수정 페이지 이동 */
	    @GetMapping("/modify")
	    public void boardModifyGet(int bno, Model model, Criteria criteria) {
	        
	        model.addAttribute("pageInfo", boardService.getPage(bno));
	        
	        model.addAttribute("criteria", criteria);
	        
	    }
	    
	    /* 페이지 수정 */
	    @PostMapping("/modify")
	    public String boardModifyPost(BoardVO board, RedirectAttributes rttr) {
	        
	        boardService.modify(board);
	        
	        rttr.addFlashAttribute("result", "modify success");
	        
	        return "redirect:/board/list";
	        
	    }
	    
	    /* 페이지 삭제 */
	    @PostMapping("/delete")
	    public String boardDeletePost(int bno, RedirectAttributes rttr) {
	        
	        boardService.delete(bno);
	        
	        rttr.addFlashAttribute("result", "delete success");
	        
	        return "redirect:/board/list";
	    }
	 
	    
	  
	   
	 
	
	

}
