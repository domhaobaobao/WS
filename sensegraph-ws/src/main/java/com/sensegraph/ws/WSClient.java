package com.sensegraph.ws;

/**
 * Created by dperini on 03/01/17.
 */


import java.net.URI;
import java.net.URISyntaxException;

public class WSClient {

    private final String uri = "ws://localhost:8025/ws/example/path";
    private WSClientEndpoint clientEndPoint = null;
    private MessageHandler messageHandler = null;

    public WSClient(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
        ensureConnected();
    }

    void ensureConnected() {
        if (null == clientEndPoint || null == clientEndPoint.userSession || !clientEndPoint.userSession.isOpen()) {
            try {
                clientEndPoint = new WSClientEndpoint(new URI(uri));
                clientEndPoint.addMessageHandler(new MessageHandler() {
                    public void handleMessage(String message) {
                        System.out.println("asdfasd" + message);
                    }
                });
            } catch (URISyntaxException ex) {
                System.err.println("URISyntaxException exception: " + ex.getMessage());
            }
        }
    }

    public void send(String message) {
        ensureConnected();
        clientEndPoint.userSession.getAsyncRemote().sendText(message);
    }
}
