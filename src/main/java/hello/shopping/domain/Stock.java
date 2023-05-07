package hello.shopping.domain;

import hello.shopping.dto.StockUpdateDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.parameters.P;

@NoArgsConstructor
@Getter
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private int quantity;

    @Builder
    public Stock(Long id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void updateStock(StockUpdateDto dto) {
        if(dto.getName() != null) {
            this.name = dto.getName();
        }
        if(dto.getPrice() != null) {
            this.price = dto.getPrice();
        }
        if(dto.getQuantity() != null) {
            this.quantity = dto.getQuantity();
        }

    }
}
