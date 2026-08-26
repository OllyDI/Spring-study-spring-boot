package hello.container;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

import java.util.Set;

/**
 * 옛날 방식 "서블릿 컨테이너" 초기화 방법 1. ServletContainerInitializer
 * WAS에 실행할 초기화 클래스 알려주는 방법
 *  - resources 에 jakarta.servlet.ServletContainerInitializer 파일 생성
 */
public class MyContainerInitV1 implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("MyContainerInitV1.onStartup");
        System.out.println("MyContainerInitV1 set = " + set);
        System.out.println("MyContainerInitV1 servletContext = " + servletContext);
    }
}
