package dev.huseyin.library.LiteraryLand.dao;

import dev.huseyin.library.LiteraryLand.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findByTitleContaining(@RequestParam("title") String title, Pageable pageable);

    Page<Book> findByCategory(@RequestParam("category") String category, Pageable pageable);

    @Query("SELECT o FROM Book o WHERE id IN :book_ids")
    List<Book> findBookByBookIds (@Param("book_ids") List<Long> bookId);
}
