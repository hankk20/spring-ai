package study.hankk20.llm.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LLMConfig {

    @Bean
    ChatClient chatClient(@Qualifier("ollamaChatModel") ChatModel chatModel, SyncMcpToolCallbackProvider toolCallbackProvider) {
        return ChatClient
                .builder(chatModel)
                .defaultSystem(
                        """ 
                                모든 질문에 Tool 사용을 고려해서 답변을 하세요.
                                spring_ai_mcp_client_sequential_thinking_sequentialthinking tool에서 thought_number, total_thoughts, needs_more_thoughts는 number 형식 이어야 합니다.
                            """)
                .defaultTools(new LLMConfig())
                .defaultToolCallbacks(toolCallbackProvider)
                .build();
    }

    @Tool(description = "본인의 이름을 가져 옵니다.")
    public String myname() {
        return "홍길동";
    }
}
