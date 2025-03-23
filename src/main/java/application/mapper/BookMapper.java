package application.mapper;

import application.dto.BookDto;
import application.model.Book;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;

@MapperConfig(componentModel = "spring")
public interface BookMapper {
    BookDto toDto(Book book);

    @Mapping(target = "id", ignore = true)
    Book toEntity(BookDto bookDto);
}
