package hello.order.v3;

import hello.order.OrderService;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 주문, 취소, 재고 매트릭 예제
 */
@Slf4j
public class OrderServiceV3 implements OrderService {

    private final MeterRegistry registry;   // 나중에 자동 등록이 가능하지만 공부를 위해 수동 등록
    private AtomicInteger stock = new AtomicInteger(100);

    public OrderServiceV3(MeterRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void order() {
        // 이걸 통해서 시간 측정
        Timer timer = Timer.builder("my.order")
                .tag("class", this.getClass().getName())
                .tag("method", "order")
                .description("order")
                .register(registry);

        timer.record(() -> {
            log.info("주문");
            stock.decrementAndGet();
            sleep();
        });
    }

    private static void sleep() {
        try {
            Thread.sleep(500 + new Random().nextInt(200));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cancel() {
        Timer timer = Timer.builder("my.order")
                .tag("class", this.getClass().getName())
                .tag("method", "cancel")
                .description("cancel")
                .register(registry);

        timer.record(() -> {
            log.info("취소");
            stock.incrementAndGet();
        });
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}
