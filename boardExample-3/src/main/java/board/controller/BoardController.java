package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import board.command.BoardCommand;
import board.mapper.BoardMapper;
import board.service.BoardDetailService;
import board.service.BoardListService;
import board.service.BoardUpdateService;
import board.service.BoardWriteService;

@Controller
public class BoardController {
	@Autowired
	BoardWriteService boardWriteService;
	@Autowired
	BoardListService boardListService;
	@Autowired
	BoardDetailService boardDetailService;
	@Autowired
	BoardUpdateService boardUpdateService;
	
	@RequestMapping("boardList")
	public String boardList(Model model) {
		boardListService.execute(model);
		return "thymeleaf/board/boardList";
	}
	
	@RequestMapping(value = "boardWrite", method=RequestMethod.GET)
	public String boardWrite() {
		return "thymeleaf/board/boardForm";
	}
	@RequestMapping(value = "boardWrite", method = RequestMethod.POST)
	public String boardWrite(BoardCommand boardCommand) {
		boardWriteService.execute(boardCommand);
		return "redirect:boardList";
	}
	
	@GetMapping("boardDetail")
	public String boardDetail(@RequestParam("boardNum") Integer boardNum
			, Model model) {
		boardDetailService.execute(boardNum, model);
		return "thymeleaf/board/boardDetail";
	}
	
	@GetMapping("boardModify")
	public String boardModify(@RequestParam("boardNum") Integer boardNum
			, Model model) {
		boardDetailService.execute(boardNum, model);
		return "thymeleaf/board/boardUpdate";
	}
	
	@PostMapping("boardModify")
	public String boardModify(BoardCommand boardCoammnd) {
		boardUpdateService.execute(boardCoammnd);
		return "redirect:boardDetail?boardNum="+boardCoammnd.getBoardNum();
	}
	
	@Autowired
	BoardMapper boardMapper;
	@GetMapping("boardDelete")
	public String boardDelete(Integer boardNum) {
		boardMapper.boardDelete(boardNum);
		return "redirect:boardList";
	}
	
	
	
	

}
