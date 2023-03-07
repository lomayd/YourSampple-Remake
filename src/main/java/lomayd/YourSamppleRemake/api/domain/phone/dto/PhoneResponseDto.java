package lomayd.YourSamppleRemake.api.domain.phone.dto;

import lomayd.YourSamppleRemake.api.domain.phone.Phone;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

public class PhoneResponseDto {
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PhoneInfo {
        private String id;
        private String name;
        private Integer prize;

        public static PhoneInfo of(Phone phone) {
            return PhoneInfo.builder()
                    .id(phone.getId())
                    .name(phone.getName())
                    .prize(phone.getPrize())
                    .build();
        }

        public static List<PhoneInfo> of(List<Phone> phoneList) {
            return phoneList.stream().map(PhoneInfo::of).collect(Collectors.toList());
        }


    }
}
