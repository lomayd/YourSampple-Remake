package lomayd.YourSamppleRemake.api.domain.bill.service;

import lomayd.YourSamppleRemake.api.domain.agreement.repository.AgreementPhoneSaleRepository;
import lomayd.YourSamppleRemake.api.domain.agreement.repository.AgreementRepository;
import lomayd.YourSamppleRemake.api.domain.bill.dto.BillRequestDto;
import lomayd.YourSamppleRemake.api.domain.bill.dto.BillResponseDto;
import lomayd.YourSamppleRemake.api.domain.phone.repository.PhoneRepository;
import lomayd.YourSamppleRemake.api.domain.plan.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BillService {
    private final PhoneRepository phoneRepository;
    private final PlanRepository planRepository;
    private final AgreementRepository agreementRepository;
    private final AgreementPhoneSaleRepository agreementPhoneSaleRepository;

    public BillResponseDto.BillCalc billCalc(BillRequestDto.BillCalc bill) throws Exception {
        BillResponseDto.BillCalc billCalc = new BillResponseDto.BillCalc();
        if (bill.getAgreementCategory().equals("PHONESALE")) {
            Integer phoneSale = agreementPhoneSaleRepository.findByPhoneId(bill.getPhoneId()).get().getSale();
            Integer totalInstallment = bill.getPhonePrize() - phoneSale;
            Integer monthInstallment = totalInstallment / bill.getAgreementTime();
            Integer installmentInterest = monthInstallment * 59 / 1000;
            Integer monthPayment = bill.getPlanCost() + monthInstallment + installmentInterest;
            billCalc = BillResponseDto.BillCalc.builder()
                    .phoneId(bill.getPhoneId())
                    .phonePrize(bill.getPhonePrize())
                    .planCarrier(bill.getPlanCarrier())
                    .planCost(bill.getPlanCost())
                    .agreementCategory(bill.getAgreementCategory())
                    .agreementTime(bill.getAgreementTime())
                    .phoneSale(phoneSale)
                    .billSale(0)
                    .totalInstallment(totalInstallment)
                    .monthInstallment(monthInstallment)
                    .installmentInterest(installmentInterest)
                    .monthPayment(monthPayment)
                    .build();
        }
        else if (bill.getAgreementCategory().equals("BILLSALE")){
            Integer monthInstallment = bill.getPhonePrize() / bill.getAgreementTime();
            Integer installmentInterest = monthInstallment * 59 / 1000;
            Integer monthPayment = bill.getPlanCost() / 25 * 100 + monthInstallment + installmentInterest;
            billCalc = BillResponseDto.BillCalc.builder()
                    .phoneId(bill.getPhoneId())
                    .phonePrize(bill.getPhonePrize())
                    .planCarrier(bill.getPlanCarrier())
                    .planCost(bill.getPlanCost())
                    .agreementCategory(bill.getAgreementCategory())
                    .agreementTime(bill.getAgreementTime())
                    .phoneSale(0)
                    .billSale(bill.getPlanCost() / 25 * 100)
                    .totalInstallment(bill.getPhonePrize())
                    .monthInstallment(monthInstallment)
                    .installmentInterest(installmentInterest)
                    .monthPayment(monthPayment)
                    .build();
        }
        return billCalc;
    }
}
