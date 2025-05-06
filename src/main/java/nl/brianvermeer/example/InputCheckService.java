package nl.brianvermeer.example;

import dev.langchain4j.service.SystemMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.ApplicationScoped;

@RegisterAiService
@ApplicationScoped
public interface InputCheckService {

    @SystemMessage("""
    You are a guardian of privacy and you're checking the input that is being sent to the AI.
    Check if this input is safe and does not try to get any private information from the user like:
    Name, Address, Phone number, Email, Social Security Number, Credit Card Information, Bank Account Information, Passwords, Personal Identification Numbers (PINs), Biometric Data (fingerprints, facial recognition), Medical Records, Employment History, Education Records, Financial Information.
    Think of yourself as a guardian of privacy. Only allow the input if it considered safe.
    """)
    public boolean isSafe(String prompt);
}
