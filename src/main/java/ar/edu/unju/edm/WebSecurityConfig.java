package ar.edu.unju.edm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.edu.unju.edm.service.imp.LoginTuristaServiceImp;

@Configuration
@EnableWebSecurity
/*El @EnableWebSecurityes una anotación de marcador. 
Permite que Spring encuentre (es un @Configurationy, por lo tanto, @Component) 
y aplique automáticamente la clase al global WebSecurity.*/
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private AutenticationSuccessHandler autenticacion;

	String[] resources = new String[] {
			"/include/**","/css/**","/img/**","/js/**","/layer/**","/webjars/**",
	};

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
				.antMatchers(resources).permitAll()
				.antMatchers("/","/index","/turista/mostrar","/turista/guardar","/mensaje/error/turi").permitAll()
			.anyRequest().authenticated()
				.and().formLogin()				
				.loginPage("/login").permitAll()
				.successHandler(autenticacion)
				//.defaultSuccessUrl("/home")
				.failureUrl("/login?error=true")
				.usernameParameter("correo")
				.passwordParameter("password")
				.and()
			    .logout().permitAll();
		http.csrf().disable();
}


	@Bean
	//devuelve una contraseña encriptada
    public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        return bCryptPasswordEncoder;
    }	

	@Autowired
    LoginTuristaServiceImp userDetailsService;

    @Autowired
    //ponemos en memoria el encriptador y el desencriptador de la contraseña
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

}
