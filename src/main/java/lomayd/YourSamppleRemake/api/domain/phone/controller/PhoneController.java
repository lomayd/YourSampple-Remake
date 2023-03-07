package lomayd.YourSamppleRemake.api.domain.phone.controller;

import lomayd.YourSamppleRemake.api.domain.phone.dto.PhoneResponseDto;
import lomayd.YourSamppleRemake.api.domain.phone.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PhoneController {

    private final PhoneService phoneService;

    @GetMapping("/phone")
    public ResponseEntity<List<PhoneResponseDto.PhoneInfo>> getPhone(){
        return ResponseEntity.ok(phoneService.getPhone());
    }
}
