package info.joygram;

import java.io.IOException;

import javax.servlet.ServletException;

import static org.springframework.security.config.Customizer.withDefaults;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private LoginSuccessHandler loginSuccessHandler; 

	@Override 
	protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> requests.antMatchers("/info").authenticated().anyRequest().permitAll())
                .formLogin(login -> login
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .failureUrl("/login?error=true")
                        .successHandler(loginSuccessHandler)
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .permitAll())
                .httpBasic(withDefaults())
                .logout(logout -> logout
                        .deleteCookies("remove")
                        .invalidateHttpSession(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/"));
	}
}


@Component
class LoginSuccessHandler implements AuthenticationSuccessHandler {
	@Override 
	public void onAuthenticationSuccess(HttpServletRequest request, 
		HttpServletResponse response,
		Authentication authentication) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_OK);
		response.sendRedirect("/");
	}
}