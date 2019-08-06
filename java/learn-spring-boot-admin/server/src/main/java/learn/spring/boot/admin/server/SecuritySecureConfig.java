package learn.spring.boot.admin.server;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

@Configuration
public class SecuritySecureConfig extends WebSecurityConfigurerAdapter {

    private final String adminContextPath;

    public SecuritySecureConfig(AdminServerProperties adminServerProperties) {
        this.adminContextPath = adminServerProperties.getContextPath();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter( "redirectTo" );

        http.authorizeRequests()
                .antMatchers( adminContextPath + "/assets/**" ).permitAll()
                .antMatchers( adminContextPath + "/login" ).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage( adminContextPath + "/login" ).successHandler( successHandler ).and()
                .logout().logoutUrl( adminContextPath + "/logout" ).and()
                .httpBasic().and()
                .csrf().disable();
        // @formatter:on
    }

    public static void main(String[] args) throws IOException {
        int [] arr={2,34,4,Integer.MAX_VALUE,    2,Integer.MAX_VALUE};
        int[] containor= new int[Integer.MAX_VALUE / 8 +1 ];
        long count =0;


        for (int num : arr) {
            int x=num / 8;
            int y=num % 8;

            //在数组中定位---标记该数
            byte val1=  (byte) (1<< y);
            int item=containor[x];

            if( (item & val1) ==0){

                containor[x]=  (item | val1);//在该元素的 byte[y] 位置： 标记1
                count ++;
            }

        }//for
        System.out.println(count);
    }
}