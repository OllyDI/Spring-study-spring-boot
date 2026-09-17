package hello.selector;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.*;

public class ImportSelectorTest {

    // 정적 등록
    @Test
    void staticConfig() {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(StaticConfig.class);
        HelloBean bean = appContext.getBean(HelloBean.class);
        assertThat(bean).isNotNull();
    }

    // 동적 등록
    @Test
    void selectorConfig() {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SelectorConfig.class);
        HelloBean bean = appContext.getBean(HelloBean.class);
        assertThat(bean).isNotNull();
    }


    // 정적 임포트는 바로 실행
    @Configuration
    @Import(HelloConfig.class)
    public static class StaticConfig {
    }


    // 동적 임포트는 구현체 실행 후 리턴 값을 불러와 실행 -> 반환된 문자(클래스 이름)를 설정 정보로 사용
    @Configuration
    @Import(HelloImportSelector.class)  // ImportSelector 를 임포트하면 ImportSelector 클래스의 구현체 실행 -> 결과를 설정 정보로 사용
    public static class SelectorConfig {

    }
}
