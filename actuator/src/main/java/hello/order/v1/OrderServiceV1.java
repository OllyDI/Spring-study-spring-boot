package hello.order.v1;

import hello.order.OrderService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 주문, 취소, 재고 매트릭 예제
 */
@Slf4j
public class OrderServiceV1 implements OrderService {

    private final MeterRegistry registry;  // 매트릭 등록을 위해 사용
    private AtomicInteger stock = new AtomicInteger(100);

    public OrderServiceV1(MeterRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void order() {
        log.info("주문");
        stock.decrementAndGet();

        Counter.builder("my.order")
                .tag("class", this.getClass().getName())
                .tag("method", "order")
                .description("order")
                .register(registry).increment();
    }

    @Override
    public void cancel() {
        log.info("취소");
        stock.incrementAndGet();

        // 메서드 태그로 구분이 되기 때문에 이름이 같아도 됨
        Counter.builder("my.order")
                .tag("class", this.getClass().getName())
                .tag("method", "cancel")
                .description("cancel")
                .register(registry).increment();
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}
