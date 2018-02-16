package com.sensegraph.ws.example;

/**
 * Created by dperini on 03/01/17.
 */


import java.net.URI;
import java.net.URISyntaxException;

public class WSClientApp {

    public static void main(String[] args) {
        try {
            // open websocket
            final WSClientAppEndpoint clientEndPoint = new WSClientAppEndpoint(new URI("ws://localhost:8025/ws/example/path"));

            // add listener
            clientEndPoint.addMessageHandler(new WSClientAppEndpoint.MessageHandler() {
                public void handleMessage(String message) {
                    System.out.println("asdfasd" + message);
                }
            });

            // send message to websocket
            clientEndPoint.sendMessage("{'event':'addChannel','channel':'ok_btccny_ticker'}");

            // wait 5 seconds for messages from websocket
            Thread.sleep(5000);

        } catch (InterruptedException ex) {
            System.err.println("InterruptedException exception: " + ex.getMessage());
        } catch (URISyntaxException ex) {
            System.err.println("URISyntaxException exception: " + ex.getMessage());
        }
    }
}