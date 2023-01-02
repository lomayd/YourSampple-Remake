package lomayd.YourSamppleRemake.api.domain.bill.dto;

import lombok.*;

public class BillRequestDto {
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BillCalc {
        private String phoneId;

        private String planCarrier;
        private Integer planCost;

        private String agreementCategory;
        private Integer agreementTime;
    }
}
