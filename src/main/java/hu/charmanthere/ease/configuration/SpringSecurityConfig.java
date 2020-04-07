package hu.charmanthere.ease.configuration;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
public class SpringSecurityConfig{
//    extends
//} WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private DataSource dataSource;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.inMemoryAuthentication()
////                .withUser("user").password("{noop}password").roles("USER")
////                .and()
////                .withUser("admin").password("{noop}password").roles("ADMIN");
//    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http
////                .httpBasic()
////                .and()
////                .authorizeRequests()
////                .antMatchers(HttpMethod.GET, "/swagger-ui.html").permitAll()
////                .antMatchers(HttpMethod.GET, "/api/**").hasRole("USER")
////                .antMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN")
////                .and()
////                .csrf().disable()
////                .formLogin().disable();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select email,password,enabled "
//                        + "from bael_users "
//                        + "where email = ?")
//                .authoritiesByUsernameQuery("select email,authority "
//                        + "from authorities "
//                        + "where email = ?");
//    }
}
