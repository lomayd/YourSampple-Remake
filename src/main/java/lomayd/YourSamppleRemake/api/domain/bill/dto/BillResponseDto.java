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

        private Integer phoneSale;
        private Integer billSale;

        private Integer totalInstallment;
        private Integer monthInstallment;
        private Integer installmentInterest;

        private Integer monthPayment;
    }
}
