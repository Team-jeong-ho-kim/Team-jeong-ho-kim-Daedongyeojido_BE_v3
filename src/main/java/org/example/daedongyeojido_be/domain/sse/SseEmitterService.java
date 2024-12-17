package org.example.daedongyeojido_be.domain.sse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class SseEmitterService {

    private final Map<String, SseEmitter> emitterMap = new ConcurrentHashMap<>();
    private static final long TIMEOUT = 60 * 1000;
    private static final long RECONNECTION_TIMEOUT = 1000L;

    public SseEmitter subscribe(String id) {
        SseEmitter emitter = createEmitter();

        emitter.onTimeout(() -> {
            log.info("server sent event timed out :  id={}", id);
            emitter.complete();
        });

        emitter.onError(e -> {
            log.info("server sent event error occurred : id={}", id, e);
            emitter.complete();
        });

        emitter.onCompletion(() -> {
            if(emitterMap.remove(id) != null) {
                log.info("server sent event removed in emitter cache: id={}", id);
            }

            log.info("disconnected by completed server sent event: id={}", id);
        });

        emitterMap.put(id, emitter);

        try {
            SseEmitter.SseEventBuilder event = SseEmitter.event()
                    .name("Sillok SSE 연결")
                    .id(UUID.randomUUID().toString())
                    .data("SSE 연결됨", MediaType.valueOf("text/plain;charset=UTF-8"))
                    .reconnectTime(RECONNECTION_TIMEOUT);
                    emitter.send(event);
        } catch (IOException e) {
            log.error("failure send media position data, id={}, {}", id, e.getMessage() );
        }
        return emitter;
    };

    public void broadcast(EventPayload eventPayload) {
        emitterMap.forEach((id, emitter) -> {
            log.info("데이터를 클라한테 보내는중 id={}, payload={}", id, eventPayload);
            try {
                String jsonData = convertToJson(eventPayload);
                emitter.send(SseEmitter.event()
                        .name("Sillok event")
                        .id("broadcast event 1")
                        .reconnectTime(RECONNECTION_TIMEOUT)
                        .data(jsonData));
                log.info("성공적으로 보냄, id={}, payload={}", id, eventPayload);
            } catch (IOException e) {
                log.error("데이터가 안보내짐ㅠㅠ id={}. {}", id, e.getMessage());
                emitter.complete();
                emitterMap.remove(id);
            }
        });
    }

    private String convertToJson(EventPayload eventPayload) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(eventPayload);
        } catch (JsonProcessingException e) {
            log.error("Failed to convert EventPayload to JSON: {}", e.getMessage());
            return "{}"; // 예외 처리: 기본 빈 객체로 반환
        }
    }

    private SseEmitter createEmitter() {
        return new SseEmitter(TIMEOUT);
    }

}
