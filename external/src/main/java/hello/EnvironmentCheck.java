package hello;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 외부 설정 - 스프링 통합 (추상화)
 * 지금까지 해온 OsEnv, JavaSystemProperties, CommandLine 들은 key=value 형식으로 사용
 * 하지만 전부 사용법이 다르다는 문제 발생 - 스프링에서 Environment, PropertySource 추상화를 통해 해결
 * VMOption, ArgsOption 등 중복 사용시 우선 순위에 따라서 하나만 나옴 - file -> VM -> Args 순서
 */
@Slf4j
@Component
public class EnvironmentCheck {

    private final Environment env;

    public EnvironmentCheck(Environment env) {
        this.env = env;
    }

    @PostConstruct
    public void init() {
        String url = env.getProperty("url");
        String username = env.getProperty("username");
        String password = env.getProperty("password");
        log.info("env url={}", url);
        log.info("env username={}", username);
        log.info("env password={}", password);
    }
}
