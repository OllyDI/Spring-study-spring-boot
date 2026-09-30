package hello.config;

import hello.dataSource.MyDataSource;
import hello.dataSource.MyDataSourcePropertiesV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

// @ConfigurationPropertiesScan을 사용하면 스프링 부트가 알아서 찾아서 등록
@Slf4j
@EnableConfigurationProperties(MyDataSourcePropertiesV2.class)
public class MyDataSourceConfigV2 {

    private final MyDataSourcePropertiesV2 properties;

    public MyDataSourceConfigV2(MyDataSourcePropertiesV2 properties) {
        this.properties = properties;
    }

    @Bean
    public MyDataSource myDataSource() {
        return new MyDataSource(
                properties.getUrl(),
                properties.getUsername(),
                properties.getPassword(),
                properties.getEtc().getMaxConnection(),
                properties.getEtc().getTimeout(),
                properties.getEtc().getOptions());
    }
}

