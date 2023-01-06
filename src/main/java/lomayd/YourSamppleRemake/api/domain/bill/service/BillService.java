package lomayd.YourSamppleRemake.api.domain.bill.service;

import lomayd.YourSamppleRemake.api.domain.agreement.repository.AgreementRepository;
import lomayd.YourSamppleRemake.api.domain.bill.dto.BillRequestDto;
import lomayd.YourSamppleRemake.api.domain.bill.dto.BillResponseDto;
import lomayd.YourSamppleRemake.api.domain.phone.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BillService {
    private final PhoneRepository phoneRepository;
    private final AgreementRepository agreementRepository;

    public BillResponseDto.BillCalc billCalc(BillRequestDto.BillCalc bill) throws Exception {
        BillResponseDto.BillCalc billCalc = new BillResponseDto.BillCalc();
        if (bill.getAgreementCategory().equals("PHONESALE")) {
            Integer phoneSale = agreementRepository.findByPhoneId(bill.getPhoneId()).get().getSale();
            Integer phoneInstallment = phoneRepository.findById(bill.getPhoneId()).get().getPrize() - phoneSale;
            Integer monthPayment = Math.toIntExact(Math.round(phoneInstallment * 0.00492 * Math.pow(1.00492, bill.getAgreementTime()) / Math.pow(1 + 0.00492, bill.getAgreementTime() - 1)));
            Integer totalPayment = Math.round(monthPayment * bill.getAgreementTime());
            Integer monthInstallmentInterest = Math.toIntExact(Math.round((phoneInstallment - (monthPayment * bill.getCurrentTime())) * 0.00492));
            Integer monthBill = bill.getPlanCost() + monthPayment;
            billCalc = BillResponseDto.BillCalc.builder()
                    .phoneId(bill.getPhoneId())
                    .phonePrize(phoneRepository.findById(bill.getPhoneId()).get().getPrize())
                    .planCarrier(bill.getPlanCarrier())
                    .planCost(bill.getPlanCost())
                    .agreementCategory(bill.getAgreementCategory())
                    .agreementTime(bill.getAgreementTime())
                    .phoneSale(phoneSale)
                    .billSale(0)
                    .phoneInstallment(phoneInstallment)
                    .monthPayment(monthPayment)
                    .totalPayment(totalPayment)
                    .monthInstallmentInterest(monthInstallmentInterest)
                    .monthBill(monthBill)
                    .build();
        }
        else if (bill.getAgreementCategory().equals("BILLSALE")){
            Integer phoneInstallment = phoneRepository.findById(bill.getPhoneId()).get().getPrize();
            Integer monthPayment = Math.toIntExact(Math.round(phoneInstallment * 0.00492 * Math.pow(1.00492, bill.getAgreementTime()) / Math.pow(1 + 0.00492, bill.getAgreementTime() - 1)));
            Integer totalPayment = Math.round(monthPayment * bill.getAgreementTime());
            Integer monthInstallmentInterest = Math.toIntExact(Math.round((phoneInstallment - (monthPayment * bill.getCurrentTime())) * 0.00492));
            Integer monthBill = Math.round(bill.getPlanCost() / 100 * 75) + monthPayment;
            billCalc = BillResponseDto.BillCalc.builder()
                    .phoneId(bill.getPhoneId())
                    .phonePrize(phoneRepository.findById(bill.getPhoneId()).get().getPrize())
                    .planCarrier(bill.getPlanCarrier())
                    .planCost(bill.getPlanCost())
                    .agreementCategory(bill.getAgreementCategory())
                    .agreementTime(bill.getAgreementTime())
                    .phoneSale(0)
                    .billSale(Math.round(bill.getPlanCost() / 100 * 25))
                    .phoneInstallment(phoneInstallment)
                    .monthPayment(monthPayment)
                    .totalPayment(totalPayment)
                    .monthInstallmentInterest(monthInstallmentInterest)
                    .monthBill(monthBill)
                    .build();
        }
        return billCalc;
    }
}
