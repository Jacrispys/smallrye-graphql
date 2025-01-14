package io.smallrye.graphql.client.vertx.websocket;

import io.smallrye.graphql.client.vertx.websocket.graphqltransportws.GraphQLTransportWSSubprotocolHandler;
import io.smallrye.graphql.client.vertx.websocket.graphqlws.GraphQLWSSubprotocolHandler;
import io.vertx.core.http.WebSocket;

public class BuiltinWebsocketSubprotocolHandlers {

    public static WebSocketSubprotocolHandler createHandlerFor(String protocolName, WebSocket webSocket,
            Integer subscriptionInitializationTimeout, Runnable onClose) {
        switch (protocolName) {
            case "graphql-ws":
                return new GraphQLWSSubprotocolHandler(webSocket, subscriptionInitializationTimeout, onClose);
            case "graphql-transport-ws":
                return new GraphQLTransportWSSubprotocolHandler(webSocket, subscriptionInitializationTimeout, onClose);
            default:
                throw new IllegalArgumentException("Unknown subprotocol: " + protocolName);
        }
    }

}
