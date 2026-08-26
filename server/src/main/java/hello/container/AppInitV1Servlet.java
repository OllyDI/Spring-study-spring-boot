package hello.container;

import hello.servlet.HelloServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;

/**
 * 옛날 방식 "애플리케이션 컨테이너" 초기화 방법 -> 인터페이스 필수
 * 직접 코드 작성을 통해 서블릿 등록, @WebServlet 두 가지가 있음
 * 프로그래밍 방식 서블릿 등록을 사용하면 경로를 유연하게 변경 가능
 */
public class AppInitV1Servlet implements AppInit {
    
    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("AppInitV1Servlet.onStartup");
        
        // 순수 서블릿 코드 등록
        ServletRegistration.Dynamic helloServlet = servletContext.addServlet("helloServlet", new HelloServlet());
        helloServlet.addMapping("/hello-servlet");
    }
}
