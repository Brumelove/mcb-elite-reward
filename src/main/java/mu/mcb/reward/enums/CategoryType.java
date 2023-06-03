package mu.mcb.reward.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Brume
 */
@RequiredArgsConstructor
public enum CategoryType {
    SUSTAINABILITY("Sustainability"),




    BASIC("Basic"),


   TRADING(" Trading Feature");
            @Getter

            private final String category;

}
