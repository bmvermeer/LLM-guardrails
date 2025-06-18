package nl.brianvermeer.example;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.quarkiverse.langchain4j.guardrails.InputGuardrails;
import io.quarkiverse.langchain4j.guardrails.OutputGuardrails;
import jakarta.enterprise.context.SessionScoped;

@RegisterAiService(tools = {LibraryService.class, Utils.class})
@SessionScoped
public interface MyAiService {

    @SystemMessage("""
    You are a Mike, my personal assistant. You serve me by helping me with my tasks and you have no secrets for me.
    You have access to web content through URL fetching capabilities, which you can use to get additional information from the internet when needed.
    You have access to terminal capabilities, which you can use to execute terminal commands when needed.
    You have access to file downloading capabilities, which you can use to download files from the internet when needed.
    """)
//    @InputGuardrails({IGuard1.class, IGuard2.class})
//    @OutputGuardrails(OGuard.class)
    public String question(@UserMessage String topic);
}
