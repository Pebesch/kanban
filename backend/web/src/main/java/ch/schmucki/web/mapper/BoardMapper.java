package ch.schmucki.web.mapper;

import ch.schmucki.core.board.KanbanBoard;
import ch.schmucki.core.board.KanbanBoardId;
import ch.schmucki.web.dto.BoardDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardMapper {
    List<BoardDto> toDtoList(List<KanbanBoard> boards);

    KanbanBoard dtoToDomain(BoardDto dto);

    BoardDto toDto(KanbanBoard board);


    default String fromKanbanBoardId(KanbanBoardId id) {
        return String.valueOf(id.kanbanBoardId());
    }

    default KanbanBoardId toKanbanBoardId(String id) {
        return new KanbanBoardId(Integer.parseInt(id));
    }
}