package mu.mcb.reward.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Brume
 */
@RequiredArgsConstructor
public enum TierType {
    TIER1("TEER 1"),
    TIER2("TEER 2"),
    TIER3("TEER 3"),
    TIER4("TEER 4");

    @Getter
    private final String type;
}
