package nl.brianvermeer.example;

import io.quarkus.websockets.next.OnError;
import io.quarkus.websockets.next.OnOpen;
import io.quarkus.websockets.next.OnTextMessage;
import io.quarkus.websockets.next.WebSocket;

@WebSocket(path = "/chat")
public class ChatBot {

    private final MyAiService aiService;
    public ChatBot(MyAiService aiService) {
        this.aiService = aiService;
    }

    @OnOpen
    public String open() {
        return "Hello! I am Mike. How can I assist you today?";
    }

    @OnTextMessage
    public String onTextMessage(String message) {
        System.out.println("Received message: " + message);
        return aiService.question(message);
    }

    @OnError
    public String onError(Throwable throwable) {
        System.out.println("Error: " + throwable.getMessage());
        return "ERROR: something went wrong";
    }


}
