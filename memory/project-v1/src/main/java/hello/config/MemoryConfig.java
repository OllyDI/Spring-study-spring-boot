package hello.config;

import memory.MemoryController;
import memory.MemoryFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * memory-v1.jar 파일을 불러오고 memory-v1 클래스를 빈으로 등록
 */
@Configuration
public class MemoryConfig {

    @Bean
    public MemoryFinder memoryFinder() {
        return new MemoryFinder();
    }

    @Bean MemoryController memoryController() {
        return new MemoryController(memoryFinder());
    }
}
