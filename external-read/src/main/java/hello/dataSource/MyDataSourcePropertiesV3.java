package hello.dataSource;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import org.hibernate.validator.constraints.time.DurationMax;
import org.hibernate.validator.constraints.time.DurationMin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


/**
 * 변수 타입이 맞지 않는 경우는 @ConfigurationProperties를 통해 해결 가능
 * @Validated: 변수 값 형식, 범위가 맞지 않는 오류 해결
 * @NotEmpty: 필수값
 * @Min, @Max, @DurationMin, @DurationMax: 값 범위
 *
 */
@Getter
@ConfigurationProperties("my.datasource")
@Validated
public class MyDataSourcePropertiesV3 {

    @NotEmpty
    private String url;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    private Etc etc;

    public MyDataSourcePropertiesV3(String url, String username, String password, Etc etc) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.etc = etc;
    }

    @Getter
    public static class Etc {
        @Min(1)
        @Max(999)
        private int maxConnection;
        @DurationMin(seconds = 1)
        @DurationMax(seconds = 60)
        private Duration timeout;
        private List<String> options = new ArrayList<>();


        public Etc(int maxConnection, Duration timeout, @DefaultValue("DEFAULT") List<String> options) {
            this.maxConnection = maxConnection;
            this.timeout = timeout;
            this.options = options;
        }
    }
}
