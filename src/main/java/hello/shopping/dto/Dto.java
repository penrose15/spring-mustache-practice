package hello.shopping.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Dto {
    private String name;
    private Integer quantity;
    private int price;

    @Builder
    public Dto(String name, Integer quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
