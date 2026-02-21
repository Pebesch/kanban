package ch.schmucki.web.controller;

import ch.schmucki.core.board.KanbanBoard;
import ch.schmucki.services.BoardService;
import java.util.List;

import ch.schmucki.web.dto.BoardDto;
import ch.schmucki.web.dto.NewBoardDto;
import ch.schmucki.web.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/boards")
public class BoardController {
  private final BoardService boardService;
  private final BoardMapper boardMapper;

  @Autowired
  public BoardController(
          BoardService boardService,
          BoardMapper boardMapper
  ) {
    this.boardService = boardService;
    this.boardMapper = boardMapper;
  }

  @GetMapping
  public List<BoardDto> getAllBoards() {
    return boardMapper.toDtoList(this.boardService.findAll());
  }

  @PostMapping
  public BoardDto createBoard(@RequestBody NewBoardDto dto) {
    var board = new KanbanBoard();
    board.setName(dto.name());
    return boardMapper.toDto(this.boardService.createBoard(board).toDomain());
  }
}
