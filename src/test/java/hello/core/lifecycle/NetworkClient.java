package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient{

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출 , url=" + url);
        connect();
        call("초기화 연결 메세지");
    }

    public void call(String msg) {
        System.out.println("call= " + url + " message= " + msg);
    }

    public void connect() {
        System.out.println("connect= " + url);
    }

    public void disconnect() {
        System.out.println("close= " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
