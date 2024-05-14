package cgg.springrolesandperm.springrolesandpermissions.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

@Configuration
public class MyConfig {

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       
        http
        .csrf(csrf->csrf.disable())
        
        .authorizeHttpRequests(auth->{
                       auth.expressionHandler(customWebSecurityExpressionHandler());
                       auth.requestMatchers("/roleHierarchy").hasRole("STAFF");
                       }
                      

                       );
                       
    return http.build();
}

@Bean
	PasswordEncoder PasswordEncoder(){
	return	new BCryptPasswordEncoder();
	}

	@Bean
    RoleHierarchy roleHierarchy() {
    RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
    String hierarchy = "ROLE_ADMIN > ROLE_STAFF  > ROLE_USER";
    roleHierarchy.setHierarchy(hierarchy);
    return roleHierarchy;
}

@Bean
DefaultWebSecurityExpressionHandler customWebSecurityExpressionHandler() {
    DefaultWebSecurityExpressionHandler expressionHandler = new DefaultWebSecurityExpressionHandler();
    expressionHandler.setRoleHierarchy(roleHierarchy());
    return expressionHandler;
}
	
}
