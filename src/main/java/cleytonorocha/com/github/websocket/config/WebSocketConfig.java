package cleytonorocha.com.github.websocket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import cleytonorocha.com.github.websocket.handler.WebSocketBinaryHandler;
import cleytonorocha.com.github.websocket.handler.WebSocketTextHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private WebSocketTextHandler webSocketTextHandler;
    @Autowired
    private WebSocketBinaryHandler webSocketBinaryHandler;



    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketTextHandler, "appText").setAllowedOrigins("*").withSockJS();
        registry.addHandler(webSocketBinaryHandler, "appBinary'").setAllowedOrigins("*").withSockJS();
    }
    
}
