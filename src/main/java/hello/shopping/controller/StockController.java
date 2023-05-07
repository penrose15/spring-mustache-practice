package hello.shopping.controller;

import hello.shopping.domain.Stock;
import hello.shopping.dto.StockUpdateDto;
import hello.shopping.repository.StockRepository;
import hello.shopping.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/stock")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @RequestMapping(method = RequestMethod.POST)
    public String save(@RequestBody Stock stock) {
        stockService.save(stock);

        return "save";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public String update(@PathVariable(value = "id") String id,
                       @RequestBody StockUpdateDto stock) {
        Long ids = Long.parseLong(id);
        stockService.update(ids, stock);

        return "update";
    }
}
