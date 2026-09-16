package memory;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;


/**
 * @AutoConfiguration 아래의 어노테이션 조건이 맞으면 빈을 자동으로 등록해줌
 * @ConditionalOnProperty(name = "memory", havingValue = "on")
 *
 * 주의 *
 * 자동 구성을 적용하려면 대상을 무조건 지정해줘야 함
 * src/main/resources/META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports
 */
@AutoConfiguration
@ConditionalOnProperty(name = "memory", havingValue = "on")
public class MemoryAutoConfig {

    @Bean
    public MemoryController memoryController() {
        return new MemoryController(memoryFinder());
    }

    @Bean
    public MemoryFinder memoryFinder() {
        return new MemoryFinder();
    }
}
