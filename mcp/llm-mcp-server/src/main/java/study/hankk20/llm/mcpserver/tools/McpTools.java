package study.hankk20.llm.mcpserver.tools;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpTools {

    @Tool(description = "사업자번호를 입력하고 월 매출 정보를 가져 온다. 만약 사업자 번호가 없다면 사용자에게 사업자번호를 입력 하라는 메세지를 보내야 한다.")
    public Sales sales(@ToolParam(required = true, description = "숫자로된 문자열 10글자 입니다. 형식은 00000000 이거나 000-000-0000 입니다.") String businessNo) {
        return new Sales(businessNo, 1000000, 10000000);
    }

    @Bean
    public ToolCallbackProvider salesToolCallbackProvider() {
        return MethodToolCallbackProvider.builder()
                .toolObjects(new McpTools())
                .build();
    }

    public record Sales(String businessNo, long monthly, long total) {}
}
