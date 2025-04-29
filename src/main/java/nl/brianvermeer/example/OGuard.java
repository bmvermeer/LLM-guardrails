package nl.brianvermeer.example;

import dev.langchain4j.data.message.AiMessage;
import io.quarkiverse.langchain4j.guardrails.OutputGuardrail;
import io.quarkiverse.langchain4j.guardrails.OutputGuardrailResult;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OGuard implements OutputGuardrail {

    public OutputGuardrailResult validate(AiMessage responseFromLLM) {
        if (responseFromLLM.text().contains("JavaScript")) {
            return successWith(responseFromLLM.text().replaceAll("JavaScript", "******"));
        }
        return success();
    }
}
