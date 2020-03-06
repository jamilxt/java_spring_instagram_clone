package com.jamilxt.instagram_clone;

import com.jamilxt.instagram_clone.config.security.CustomAuthSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/*
 *
 * TODO:
 *   1. soft delete (c)
 *   2. multiple authorities/roles for a user (c)
 *   3. profiling - dev/prod (c)
 *   4. deployment to heroku (c)
 *   5. add user (c), change password, change role
 *   6. image upload, user details
 *   7. SMTP setup
 *   8. change password, forgot password
 *   9. api for searching (c)
 *  10. Jquery Date Plugin in form
 *  11. Soft Delete for user
 *  12. Pagination
 *  13. Sortable
 *  14.
 *
 *
 *
 *
 * question:
 * 1) adding date to db
 * 2) redirecting to index if user is already logged in
 * */

@ComponentScan(basePackages = {
        "com.jamilxt.instagram_clone.service",
        "com.jamilxt.instagram_clone.config.persistence",
        "com.jamilxt.instagram_clone.config.security"})
public class RootConfig {
    @Bean
    GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CustomAuthSuccessHandler authSuccessHandler() {
        return new CustomAuthSuccessHandler();
    }

    @Bean
    public CommonsMultipartResolver commonsMultipartResolver() {
        return new CommonsMultipartResolver();
    }
}
