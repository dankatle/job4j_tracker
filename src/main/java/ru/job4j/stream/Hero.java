package ru.job4j.stream;

public class Hero {
    private String name;
    private String mark;
    private String origin;
    private float height;
    private float weight;
    private int speed;
    private int armor;

    public static void main(String[] args) {
        Hero hero = new Builder().buildName("name")
                .buildMark("mark")
                .buildOrigin("origin")
                .buildHeight(42.32F)
                .buildWeight(1592.21F)
                .buildSpeed(199)
                .buildArmor(23)
                .build();
    }

    static class Builder {
        private String name;
        private String mark;
        private String origin;
        private float height;
        private float weight;
        private int speed;
        private int armor;

        public Builder buildName(String name) {
            this.name = name;
            return this;
        }

        public Builder buildMark(String mark) {
            this.mark = mark;
            return this;
        }

        public Builder buildOrigin(String origin) {
            this.origin = origin;
            return this;
        }

        public Builder buildHeight(float height) {
            this.height = height;
            return this;
        }

        public Builder buildWeight(float weight) {
            this.weight = weight;
            return this;
        }

        public Builder buildSpeed(int speed) {
            this.speed = speed;
            return this;
        }

        public Builder buildArmor(int armor) {
            this.armor = armor;
            return this;
        }

        Hero build() {
            Hero hero = new Hero();
            hero.name = name;
            hero.mark = mark;
            hero.origin = origin;
            hero.height = height;
            hero.weight = weight;
            hero.speed = speed;
            hero.armor = armor;
            return hero;
        }
    }
}
