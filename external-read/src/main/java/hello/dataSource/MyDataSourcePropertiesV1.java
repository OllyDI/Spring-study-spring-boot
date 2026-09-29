package hello.dataSource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


// @ConfigurationProperties: 외부 설정을 주입받는 객체라는 뜻으로 사용
@Data
@ConfigurationProperties("my.datasource")
public class MyDataSourcePropertiesV1 {

    private String url;
    private String username;
    private String password;
    private Etc etc;

    @Data
    public static class Etc {
        private int maxConnection;
        private Duration timeout;
        private List<String> options = new ArrayList<>();
    }
}
