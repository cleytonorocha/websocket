package cleytonorocha.com.github.websocket_back.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import cleytonorocha.com.github.websocket_back.handler.WebSocketBinaryHandler;
import cleytonorocha.com.github.websocket_back.handler.WebSocketTextHandler;
import lombok.AllArgsConstructor;

@Configuration
@EnableWebSocket
@AllArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {

    private final WebSocketTextHandler webSocketTextHandler;
    private final WebSocketBinaryHandler webSocketBinaryHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketTextHandler, "/appText").setAllowedOrigins("*").withSockJS();
        registry.addHandler(webSocketBinaryHandler, "/appBinary").setAllowedOrigins("*").withSockJS();
    }

}
