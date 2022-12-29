package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        chain.doFilter(request,response);

    }
}
