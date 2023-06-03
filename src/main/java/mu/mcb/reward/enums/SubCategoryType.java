package mu.mcb.reward.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.*;

/**
 * @author Brume
 */
@RequiredArgsConstructor
public enum SubCategoryType {
    SME("Shopping at SMEs or Made in Moris brands", CategoryType.SUSTAINABILITY, 2.0),
    CHARITIES("Donating to Environmental Causes / Charities", CategoryType.SUSTAINABILITY, 1.8),
    ECO_FRIENDLY("Purchasing Eco-Friendly Products", CategoryType.SUSTAINABILITY, 1.6),
    DIGITAL_PRODUCTS("Opting for Digital Products (e.g. online books)", CategoryType.SUSTAINABILITY, 1.4),

   GROCERIES(" Purchasing basic products (Food / groceries)", CategoryType.BASIC, 1.8),
    BILL_PAYMENT("Making Bill payments (CEB, CWA)", CategoryType.BASIC, 1.4),
    LUXURY_OR_BOOKING_SERVICES("Shopping a luxury shops/ Booking services (Flights)", CategoryType.BASIC, 1.2),

    FINANCIAL_ASSETS_INVESTMENTS("Investment in Sustainable financial assets", CategoryType.TRADING, 1.8),
    OTHER_FINANCIAL_ASSETS("Investment in other financial assets", CategoryType.TRADING, 1.4);

    @Getter
    private final String subCategory;
    @Getter
    private final CategoryType categoryType;
    @Getter
    private final Double pointsMultiplier;

    private final static Map<CategoryType, Set<SubCategoryType>> BY_CATEGORY_TYPE;

    static {
        BY_CATEGORY_TYPE = new TreeMap<>();
        for (SubCategoryType subCategoryType : SubCategoryType.values()) {
            var thisBillingCategoryResourceType = subCategoryType.categoryType;

            Set<SubCategoryType> set = byResourceType(thisBillingCategoryResourceType);
            if (set == null) {
                set = new TreeSet();
                BY_CATEGORY_TYPE.put(thisBillingCategoryResourceType, set);
            }
            set.add(subCategoryType);
        }
    }

    public static Set<SubCategoryType> byResourceType(CategoryType categoryType) {
        return BY_CATEGORY_TYPE.get(categoryType);
    }

    public static SubCategoryType getSubCategory( String subCategory) {
        for (SubCategoryType subCategoryType : values()) {
            if (subCategoryType.subCategory.equalsIgnoreCase(subCategory.trim())) {
                return subCategoryType;
            }
        }
        throw new IllegalArgumentException("Invalid Sub category for " + subCategory);

        }


    public static List<SubCategoryType> getSubCategory( ) {
       return List.of(SubCategoryType.values());

    }


}
