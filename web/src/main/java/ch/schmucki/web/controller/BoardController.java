package ch.schmucki.web.controller;

import ch.schmucki.core.board.KanbanBoard;
import ch.schmucki.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping()
    public List<KanbanBoard> getAllBoards() {
        this.boardService.createBoard(new KanbanBoard());
        return boardService.findAll();
    }
}
