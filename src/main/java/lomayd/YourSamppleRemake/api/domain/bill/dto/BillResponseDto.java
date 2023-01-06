package lomayd.YourSamppleRemake.api.domain.bill.dto;

import lombok.*;

public class BillResponseDto {
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BillCalc {
        private String phoneId;
        private Integer phonePrize;

        private String planCarrier;
        private Integer planCost;

        private String agreementCategory;
        private Integer agreementTime;

        private Integer currentTime;

        private Integer phoneSale;
        private Integer billSale;

        private Integer phoneInstallment; // 할부원금
        private Integer monthPayment; // 월 할부금
        private Integer totalPayment; // 총 할부금
        private Integer monthInstallmentInterest; // 월 할부이자
        private Integer installmentInterest;

        private Integer monthBill; // 월 요금
    }
}
