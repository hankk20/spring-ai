# **MCP 예제**
Spring AI와 MCP (Model Context Protocol)를 사용한 LLM 연동

## **주요 기능**
- Spring AI 기반 MCP Host 구현
- Spring AI 기반 MCP 서버 구현
- **사업자번호 입력**을 사용해 매출 정보를 처리 하는 SSE 기반 MCP 테스트

## **모듈**
### **공통**
- **Java 21** 이상
- **Gradle** 또는 **IntelliJ IDEA** 빌드 환경
- **Ollama**
### **2. Ollama 설치**
- [Ollama 사이트](https://ollama.com/) 에서 Download 설치
- 환경변수 설정(Option)
```aiignore
OLLAMA_MODELS=model 저장 경로 설정
```
- Spring AI Ollama 설정
```yml
spring:
  ai:
    ollama:
      base-url: http://localhost:11434
      chat:
        options:
          model: llama3.1
          temperature: 0.7
          max-tokens: 8192
      init: #Embbeding
        pull-model-strategy: when_missing
```
ollama가 설치되어 실행 되고 있어야 한다. ollama api를 통해 모델 확인여부와 설치를 시도 한다.

## **문서**
- [MCP 정리 Notion](https://hankk.notion.site/MCP-Model-Context-Protocol-1f526ff3cb5280a290fdc8eb4b6ce884)
- [개발 참고(baeldung)](https://www.baeldung.com/spring-ai-model-context-protocol-mcp)

