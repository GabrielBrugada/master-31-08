package raccoon.gym.config;

import raccoon.gym.servicios.UsuarioServicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	private UsuarioServicios usuarioServicios;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioServicios).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests((requests) -> requests
						.requestMatchers("/index","/", "/home","/nuevo-empleado","/formulario_empleado","/lista-empleado","/editar-empleado", "/registro", "/css/*", "/images/*","/error").permitAll()
						.requestMatchers("/empleado/*").authenticated()
						.anyRequest().authenticated())
				.formLogin((form) -> form
						.loginPage("/login")
						.loginProcessingUrl("/loginCheck")
						.usernameParameter("email")
						.passwordParameter("password")
						.permitAll())
				.logout((logout) -> logout.permitAll());

		return http.build();
	}

}