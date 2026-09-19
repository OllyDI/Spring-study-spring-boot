package hello.external;

import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

/**
 * 외부 설정 - 자바 시스템 속성 -> System.getProperties, System.getProperty(String.valueOf(key))
 * -D VM 옵션을 통해 key=value 형태로 사용
 * 순서 주의 -D 가 먼저 오고 -jar 옵션 사용 - java -Durl=dev -jar app.jar
 * 실행파일 구성 편집 - VM 옵션 추가를 통해 url, username, password 값을 넣었음
 * jar로 빌드 되어 있다면 java -Durl=devdb... 를 통해서 추가 가능
 */
@Slf4j
public class JavaSystemProperties {

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        for (Object key : properties.keySet()) {
            log.info("prop {}={}", key, System.getProperty(String.valueOf(key)));
        }

        String url = System.getProperty("url");
        String username = System.getProperty("username");
        String password = System.getProperty("password");

        log.info("url={}", url);
        log.info("username={}", username);
        log.info("password={}", password);
    }
}
