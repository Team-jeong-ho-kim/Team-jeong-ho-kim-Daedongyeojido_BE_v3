package org.example.daedongyeojido_be.domain.sse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SSEController {

    private final SseEmitterService sseEmitterService;

    @GetMapping(path = "/v1/sse/subscribe", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<SseEmitter> subscribe() {
        String sseId = UUID.randomUUID().toString();
        SseEmitter emitter = sseEmitterService.subscribe(sseId);
        return ResponseEntity.ok(emitter);
    }

    @PostMapping(path = "/v1/sse/broadcast", consumes = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8", produces = MediaType.TEXT_EVENT_STREAM_VALUE + ";charset=UTF-8")
    public ResponseEntity<Void> broadcast(@RequestBody EventPayload eventPayload) {
        eventPayload.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")));
        sseEmitterService.broadcast(eventPayload);
        return ResponseEntity.ok().build();
    }

}
