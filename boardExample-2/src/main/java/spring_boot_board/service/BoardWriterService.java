package spring_boot_board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_boot_board.command.BoardCommand;
import spring_boot_board.domain.BoardDTO;
import spring_boot_board.mapper.BoardMapper;

@Service
public class BoardWriterService {
	@Autowired
	BoardMapper boardMapper;
	public void execute(BoardCommand boardCommand) {
		BoardDTO dto = new BoardDTO();
		dto.setBoardContent(boardCommand.getBoardContent());
		dto.setBoardSubject(boardCommand.getBoardSubject());
		dto.setBoardWriter(boardCommand.getBoardWriter());
		boardMapper.boardInsert(dto);
	}

}
