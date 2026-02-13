package ch.schmucki.web.mapper;

import ch.schmucki.core.board.KanbanBoard;
import ch.schmucki.web.dto.BoardDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardMapper {

    BoardDto toDto(KanbanBoard board);

    List<BoardDto> toDtoList(List<KanbanBoard> boards);

    @Mapping(source = "id", target = "id", ignore = true)
    @Mapping(source = "name", target = "name", ignore = true)
    KanbanBoard dtoToDomain(BoardDto dto);
}