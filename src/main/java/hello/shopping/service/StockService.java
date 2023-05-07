package hello.shopping.service;

import hello.shopping.domain.Stock;
import hello.shopping.dto.StockResponsesDto;
import hello.shopping.dto.StockUpdateDto;
import hello.shopping.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StockService {
    private final StockRepository stockRepository;

    public void save(Stock stock) {
        stockRepository.save(stock);
    }

    public void update(Long id, StockUpdateDto dto) {
        Stock stock = stockRepository.findById(id)
                        .orElseThrow();
        stock.updateStock(dto);
        stockRepository.save(stock);
    }

    public StockResponsesDto find(Long id) {
        return stockRepository.find(id)
                .orElseThrow();
    }

    public Page<StockResponsesDto> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size, Sort.Direction.DESC, "id");

        return stockRepository.findDTOAll(pageable);
    }

    public void delete(Long id) {
        stockRepository.deleteById(id);
    }


}
