package com.example.safekorea.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.safekorea.DTO.BoardDTO;
import com.example.safekorea.service.BoardService;

import org.springframework.ui.Model;
@Controller
public class BoardController {

	private BoardService boardservice;
	
	public BoardController(BoardService boardService) {
		this.boardservice = boardService;
	}
	
	@GetMapping("/")
	public String start() {
		
		return "common/index.html";
	}
	
	@GetMapping("/post")
	public String write() {
		return "board/write.html";
	}
	
	@PostMapping("/post")
	public String write(BoardDTO boardDTO){
		boardservice.savePost(boardDTO);
		return "redirect:/";
	}
	
	@GetMapping("/list")
	public String list(Model model, @RequestParam(value = "page", defaultValue = "1") Integer pageNum) {
		List<BoardDTO> boardDtoList = boardservice.getBoardList(pageNum);
		Integer[] pageList = boardservice.getPageList(pageNum);
		
		model.addAttribute("boardList",boardDtoList);
		model.addAttribute("pageList",pageList);
		return "board/list.html";
	}
	
	@GetMapping("/post/{no}")
	public String detail(@PathVariable("no") Long id,  Model model) {
		BoardDTO boardDto = boardservice.getPost(id);
		model.addAttribute("boardDto",boardDto);
		return "board/detail.html";
	}
	
	@GetMapping("/post/edit/{no}")
	public String edit(@PathVariable("no") Long id,  Model model) {
		BoardDTO boardDto = boardservice.getPost(id);
		
		model.addAttribute("boardDto",boardDto);
		return "board/update.html";
	}
	
	@PutMapping("/post/edit/{no}")
	public String edit(BoardDTO boardDTO) {
		boardservice.savePost(boardDTO);
		return "redirect:/";
	}
	
	@DeleteMapping("/post/{no}")
	public String delete(@PathVariable("no") Long id) {
		boardservice.deletePost(id);
		return "redirect:/";
	}
	
	@GetMapping("/board/search")
	public String search(@RequestParam(value = "keyword") String keyword,  Model model) {
		List<BoardDTO> boardDtoList = boardservice.searchPosts(keyword);
		
		model.addAttribute("boardList",boardDtoList);
		return "board/list.html";
	}
	
}
