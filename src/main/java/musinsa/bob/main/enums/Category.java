package musinsa.bob.main.enums;

import lombok.Getter;

import java.util.Optional;

@Getter
public enum Category {

    TOP("상의"),
    OUTER("아우터"),
    PANTS("바지"),
    SNEAKERS("스니커즈"),
    BAG("가방"),
    HAT("모자"),
    SOCKS("양말"),
    ACCESSORIES("액세서리");

    ;

    private final String koreanName;

    Category(String name) {
        this.koreanName = name;
    }

    public static Category findByKoreanName(String koreanName) {
        for (Category category : values()) {
            if (category.getKoreanName().equals(koreanName)) {
                return category;
            }
        }
        return null;
    }

    public String getDisplayName() {
        return this.koreanName;
    }

    public static Optional<Category> findByNameOptional(String name) {
        try {
            return Optional.of(Category.valueOf(name.toUpperCase()));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }
}
