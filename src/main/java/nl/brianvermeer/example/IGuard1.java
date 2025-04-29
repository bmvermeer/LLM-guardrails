package nl.brianvermeer.example;

import dev.langchain4j.data.message.UserMessage;
import io.quarkiverse.langchain4j.guardrails.InputGuardrail;
import io.quarkiverse.langchain4j.guardrails.InputGuardrailResult;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class IGuard1 implements InputGuardrail {

    @Override
    public InputGuardrailResult validate(UserMessage um) {
        String text = um.singleText();
        if (text.contains("malicious") || text.contains("hack")) {
            return fatal("MALICIOUS INPUT DETECTED!!!");
        }

        return success();
    }
}
