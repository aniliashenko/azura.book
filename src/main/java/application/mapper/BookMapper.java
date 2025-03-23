package application.mapper;

import application.dto.BookDto;
import application.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);
}
