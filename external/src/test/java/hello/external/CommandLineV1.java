package hello.external;

import lombok.extern.slf4j.Slf4j;

/**
 * 외부 설정 - 커맨드 라인 인수 - main(args) 파라미터로 전달
 * ex1) java -jar app.jar exA exB
 * ex2) url=devdb username=dev_user password=dev_pw -> 파싱이 안되는 문자임, 직접 파싱해야되서 번거로움 -> V2 버전에서 개선
 */
@Slf4j
public class CommandLineV1 {

    public static void main(String[] args) {
        for (String arg : args) {
            log.info("arg {}", arg);
        }
    }
}
