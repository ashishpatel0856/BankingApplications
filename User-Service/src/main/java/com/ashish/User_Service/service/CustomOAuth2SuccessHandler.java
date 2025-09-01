//package com.ashish.User_Service.service;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CustomOAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//
//    private final JwtService jwtService;
//
//    public CustomOAuth2SuccessHandler(JwtService jwtService) {
//        this.jwtService = jwtService;
//    }
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request,
//                                        HttpServletResponse response,
//                                        Authentication authentication) throws IOException {
//        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
//        String email = oAuth2User.getAttribute("email");
//
//        // JWT generate
//        String token = jwtService.genrateAccessToken(email);
//
//        // Redirect with JWT token (frontend ya postman me dekh sakte ho)
//        response.sendRedirect("http://localhost:3000/home?token=" + token);
//    }
//}
//
