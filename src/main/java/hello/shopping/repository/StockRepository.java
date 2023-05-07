package hello.shopping.repository;

import hello.shopping.domain.Stock;
import hello.shopping.dto.StockResponsesDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {

    @Query("select new hello.shopping.dto.StockResponsesDto(s.id, s.name, s.price, s.quantity)" +
            " from Stock s where s.id = :id" )
    Optional<StockResponsesDto> find(Long id);

    @Query("select new hello.shopping.dto.StockResponsesDto(s.id ,s.name, s.price, s.quantity) from Stock s")
    Page<StockResponsesDto> findDTOAll(Pageable pageable);
}
