package mu.mcb.reward.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Brume
 */
@RequiredArgsConstructor
public enum TierType {
    TIER1("TEER 1",0.0, 250000.0),
    TIER2("TEER 2", 250001.0,900000.0 ),
    TIER3("TEER 3", 900001.0, 2000000.0),
    TIER4("TEER 4", 2000001.0,  999999999.0);

    @Getter
    private final String type;
    @Getter
    private final Double minimumAmount;
    @Getter
    private final Double maximumAmount;

    public static TierType findTierByPoints( Double points) {
        for (TierType tierType : values()) {
            if ( tierType.getMaximumAmount() >= points && tierType.getMinimumAmount() <= points ) {
                return tierType;
            }
        }
        throw new IllegalArgumentException("Invalid Tier points for " + points);

    }

    public static void main(String[] args) {
        System.out.println(findTierByPoints(1000.0));
    }
}
