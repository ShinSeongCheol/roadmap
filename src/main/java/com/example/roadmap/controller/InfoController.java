package com.example.roadmap.controller;

import com.example.roadmap.dto.InfoDTO;
import com.example.roadmap.service.InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Restuful 웹서비스의 컨트롤러, Json 형태로 객체 데이터를 반환
@RequiredArgsConstructor // final 혹은 @NotNull이 붙은 필드의 생성자를 자동으로 만들어준다
public class InfoController {
    private final InfoService infoService;

    /**
     * 로드맵 쓰기 ( POST /tour/{roadmapId}/info )
     *
     */
    @PostMapping("/tour/{roadmapId}/info")
    public ResponseEntity save(@PathVariable Long roadmapId, @RequestBody InfoDTO.Request dto) {
        return ResponseEntity.ok(infoService.save(roadmapId, dto));
    }

    /**
     * 로드맵 조회 ( GET /tour/{roadmapId}/info )
     *
     */
    @GetMapping("/tour/{roadmapId}/info")
    public List<InfoDTO.Response> read(@PathVariable Long roadmapId) {
        return infoService.findAll(roadmapId);
    }

    /**
     * 로드맵 수정 ( PUT /tour/{roadmapId}/info/{infoId} )
     *
     */
    @PutMapping({"/tour/{roadmapId}/info/{infoId}"})
    public ResponseEntity update(@PathVariable Long infoId, @RequestBody InfoDTO.Request dto) {
        infoService.update(infoId, dto);
        return ResponseEntity.ok(infoId);
    }

    /**
     * 로드맵 삭제 ( DELETE /tour/{roadmapId}/info/{infoId} )
     *
     */
    @DeleteMapping("/tour/{roadmapId}/info/{infoId}")
    public ResponseEntity delete(@PathVariable Long infoId) {
        infoService.delete(infoId);
        return ResponseEntity.ok(infoId);
    }
}
