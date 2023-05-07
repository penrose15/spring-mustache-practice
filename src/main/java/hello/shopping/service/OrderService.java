package hello.shopping.service;

import hello.shopping.domain.OrderStock;
import hello.shopping.repository.OrderRepository;
import hello.shopping.repository.OrderStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private OrderRepository orderRepository;
    private OrderStockRepository orderStockRepository;


}
