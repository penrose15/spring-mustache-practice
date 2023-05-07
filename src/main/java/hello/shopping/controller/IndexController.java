package hello.shopping.controller;

import hello.shopping.domain.Stock;
import hello.shopping.dto.StockResponsesDto;
import hello.shopping.dto.StockUpdateDto;
import hello.shopping.repository.StockRepository;
import hello.shopping.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class IndexController {

    private final StockService stockService;

    @GetMapping("/shop/save")
    public String save() {
        return "stock-save";
    }
    @GetMapping("/shop/update/{id}")
    public String update(@PathVariable Long id,
                         Model model) {
        StockResponsesDto stock = stockService.find(id);
        model.addAttribute("stock", stock);
        return "stock-update";
    }

}
