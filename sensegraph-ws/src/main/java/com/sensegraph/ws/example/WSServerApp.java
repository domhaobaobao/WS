package com.sensegraph.ws.example;

import javax.websocket.DeploymentException;
import java.util.Scanner;

/**
 * Created by dperini on 01/05/17.
 */

public class WSServerApp {

    public static void main(String[] args) {
        org.glassfish.tyrus.server.Server server =
                new org.glassfish.tyrus.server.Server("localhost", 8025, "/ws", WSServerEndpoint.class);
        try {
            server.start();
            System.out.println("Press any key to stop the server..");
            new Scanner(System.in).nextLine();
        } catch (DeploymentException e) {
            throw new RuntimeException(e);
        } finally {
            server.stop();
        }
    }
}
