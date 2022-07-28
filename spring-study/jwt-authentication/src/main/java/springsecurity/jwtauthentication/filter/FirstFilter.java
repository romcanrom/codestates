package springsecurity.jwtauthentication.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class FirstFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //downcasting -> HttpServletRequest/Response의 메서드를 사용
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        res.setCharacterEncoding("UTF-8");
        if (req.getMethod().equals("POST")) {

            String headerAuth = req.getHeader("Authorization");
            //Authorization 헤더 없을 시 NPE 발생
            if (headerAuth.equals("codestates")) {
                chain.doFilter(req, res);
            } else {
                PrintWriter writer = res.getWriter();
                writer.println("인증 실패");
            }
        }



    }
}
