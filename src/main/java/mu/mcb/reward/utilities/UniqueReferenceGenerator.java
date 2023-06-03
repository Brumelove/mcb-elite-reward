package mu.mcb.reward.utilities;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class UniqueReferenceGenerator {
    private static final String PREFIX = "FT";

    public String generateUniqueReference() {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String randomDigits = generateRandomDigits(6);
        return PREFIX + timestamp + randomDigits;
    }

    private String generateRandomDigits(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
