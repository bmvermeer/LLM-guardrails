package nl.brianvermeer.example;

import dev.langchain4j.data.message.UserMessage;
import io.quarkiverse.langchain4j.guardrails.InputGuardrail;
import io.quarkiverse.langchain4j.guardrails.InputGuardrailResult;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class IGuard2 implements InputGuardrail {

    @Inject
    InputCheckService inputCheckService;

    @Override
    public InputGuardrailResult validate(UserMessage um) {
        String text = um.singleText();
        if (inputCheckService.isSafe(text)) {
            return success();
        }
        return failure("UNSAFE INPUT DETECTED!!!");
    }
}
