package hello.external;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;

import java.util.List;
import java.util.Set;

/**
 * 외부 설정 - 커맨드 라인 인수V2 - main(args) 파라미터로 전달
 * -- 를 통해 인수를 넣어주면 규격대로 파싱 가능 -> ApplicationArguments appArgs = new DefaultApplicationArguments(args);
 */
@Slf4j
public class CommandLineV2 {

    public static void main(String[] args) {
        for (String arg : args) {
            log.info("arg {}", arg);
        }

        ApplicationArguments appArgs = new DefaultApplicationArguments(args);
        log.info("SourceArgs = {}", List.of(appArgs.getSourceArgs()));  // 모든 인수 출력
        log.info("NonOptionArgs = {}", appArgs.getNonOptionArgs());     // 인수에 -- 가 안들어간 값 출력
        log.info("OptionNames = {}", appArgs.getOptionNames());         // 인수에 -- 가 들어간 키값만 출력

        Set<String> optionNames = appArgs.getOptionNames();             // key=value 형태로 출력
        for (String optionName : optionNames) {
            log.info("option arg {}={}", optionName, appArgs.getOptionValues(optionName));
        }

        // 리스트인 이유 - 같은 키에 여러 개의 값을 넣을 수 있음
        List<String> url = appArgs.getOptionValues("url");
        List<String> username = appArgs.getOptionValues("username");
        List<String> password = appArgs.getOptionValues("password");
        List<String> mode = appArgs.getOptionValues("mode");
        log.info("url={}", url);
        log.info("username={}", username);
        log.info("password={}", password);
        log.info("mode={}", mode);  // 옵션 인수가 아니므로 null 값 출력
    }
}
