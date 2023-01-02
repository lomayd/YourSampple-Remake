package lomayd.YourSamppleRemake.api.domain.bill.controller;

import lomayd.YourSamppleRemake.api.domain.bill.dto.BillRequestDto;
import lomayd.YourSamppleRemake.api.domain.bill.dto.BillResponseDto;
import lomayd.YourSamppleRemake.api.domain.bill.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BillController {
    private final BillService billService;

    @GetMapping("/bill")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BillResponseDto.BillCalc> billCalc(@Validated @RequestBody BillRequestDto.BillCalc billCalc) throws Exception {
        return ResponseEntity.ok(billService.billCalc(billCalc));
    }
}
