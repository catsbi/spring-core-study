package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request")
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        String format = String.format("[%s][%s]%s", uuid, requestURL, message);
        System.out.println(format);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println(String.format("[%s]request scope bean create:", uuid) + this);
    }

    @PreDestroy
    public void destroy() {
        System.out.println(String.format("[%s]request scope bean close:", uuid) + this);
    }
}
