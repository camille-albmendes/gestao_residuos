package br.com.fiap.collectage.security;

public class SecurityEventListener {
    import org.springframework.context.event.EventListener;
import org.springframework.security.web.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.web.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

    @Component
    public class SecurityEventListener {

        @EventListener
        public void handleAuthSuccess(InteractiveAuthenticationSuccessEvent event) {
            System.out.println("Autenticação bem-sucedida para o usuário: " + event.getAuthentication().getName());
        }

        @EventListener
        public void handleAuthFailure(AuthenticationFailureBadCredentialsEvent event) {
            System.out.println("Falha na autenticação: " + event.getAuthentication().getName());
        }
    }
}
