//package pjm.microservice.dashboard.config;
//
//import ch.qos.logback.core.util.StringUtil;
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.interfaces.Claim;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//import pjm.microservice.dashboard.model.AuthLogin;
//import pjm.microservice.dashboard.service.JwtUserDetailsService;
//
//import java.io.IOException;
//
//@Component
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
////    @Autowired
////    private JwtUserDetailsService userService;
////
////    @Autowired
////    private JwtTokenUtil jwtTokenUtil;
//
//    @Override
//    protected  void doFilterInternal(jakarta.servlet.http.HttpServletRequest request,
//                                     jakarta.servlet.http.HttpServletResponse response,
//                                     jakarta.servlet.FilterChain filterChain) throws
//            jakarta.servlet.ServletException, IOException{
//        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
//
//        if(!StringUtils.hasLength(header) || !header.startsWith("Bearer ")){
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//
//        final String token = header.split(" ")[1].trim();
////        if (!jwtTokenUtil.validate(token)) {
////            filterChain.doFilter(request, response);
////            return;
////        }
//
//        final String useragent = request.getHeader(HttpHeaders.USER_AGENT);
//        AuthLogin authlogin = new AuthLogin();
//        DecodedJWT jwt = JWT.decode(token);
//        Claim claimUsername = jwt.getClaim("username");
//        String Jti = jwt.getId();
//        if(!claimUsername.isNull()) {
//            authlogin.setUsername(claimUsername.asString());
//        }
//
//
////        UserDetails userDetails = userService.loadUserByUsername(jwtTokenUtil.getUserName(token));
//    }
//}
