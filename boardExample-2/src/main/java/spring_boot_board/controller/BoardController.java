package spring_boot_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring_boot_board.command.BoardCommand;
import spring_boot_board.mapper.BoardMapper;
import spring_boot_board.service.BoardDetailService;
import spring_boot_board.service.BoardListService;
import spring_boot_board.service.BoardUpdateService;
import spring_boot_board.service.BoardWriterService;

@Controller
public class BoardController {
	@Autowired
	BoardWriterService boardWriterService;
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
	public String boardWrite(/*@RequestParam("boardWriter") String boardWriter, 
								@RequestParam("boardSubject") String boardSubject,
								@RequestParam("boardContent") String boardContent*/
			BoardCommand boardCommand) {
		boardWriterService.execute(boardCommand);
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
	public String boardModify(BoardCommand boardCommand) {
		boardUpdateService.execute(boardCommand);
		return "redirect:boardDetail?boardNum="+boardCommand.getBoardNum();
	}
	
	@Autowired
	BoardMapper boardMapper;
	@GetMapping("boardDelete")
	public String boardDelete(Integer boardNum) {
		boardMapper.boardDelete(boardNum);
		return "redirect:boardList";
	}
	
	

}
