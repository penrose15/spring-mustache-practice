package hello.shopping.dto;

import lombok.Getter;

@Getter
public class StockUpdateDto {
    private String name;
    private Integer price;
    private Integer quantity;
}
