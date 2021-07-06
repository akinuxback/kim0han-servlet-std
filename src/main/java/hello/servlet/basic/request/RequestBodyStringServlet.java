package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "RequestBodyStringServlet.class", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //메시지바디의 내용을 바이트 코드로 받을수 있다. -> request.getInputStream()
        ServletInputStream inputStream = request.getInputStream();
        //항상 바이트를 문자로 변환할때는 어떤 인코딩인지 알려줘야 한다. (문자 -> 바이트 일때도 마찬가지.)
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody =" + messageBody);

        response.getWriter().write("OK");

    }

}
