package phong.kafka.request;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

@Jacksonized
@Data
@Builder(toBuilder = true)
public class BalanceMessage {
    String name;
    Double amount;
    LocalDateTime time;
}
