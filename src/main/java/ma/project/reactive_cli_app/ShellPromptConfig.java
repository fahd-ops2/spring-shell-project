package ma.project.reactive_cli_app;

import org.jline.utils.AttributedString;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.jline.PromptProvider;

@Configuration
public class ShellPromptConfig implements PromptProvider {

    @Override
    public AttributedString getPrompt() {
        return new AttributedString("Command :> ");
    }
}
