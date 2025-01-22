package example;

public class Park {
    class FerrisWheel{
        String name;
        String openHours;
        double price;

        public FerrisWheel(String name, String openHours, double price) {
            this.name = name;
            this.openHours = openHours;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOpenHours() {
            return openHours;
        }

        public void setOpenHours(String openHours) {
            this.openHours = openHours;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "FerrisWheel{" +
                    "name='" + name + '\'' +
                    ", openHours='" + openHours + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    class Slides{
        String name;
        String openHours;
        double price;

        public Slides(String name, String openHours, double price) {
            this.name = name;
            this.openHours = openHours;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOpenHours() {
            return openHours;
        }

        public void setOpenHours(String openHours) {
            this.openHours = openHours;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Slides{" +
                    "name='" + name + '\'' +
                    ", openHours='" + openHours + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    class DeathRope{
        String name;
        String openHours;
        double price;

        public DeathRope(String name, String openHours, double price) {
            this.name = name;
            this.openHours = openHours;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOpenHours() {
            return openHours;
        }

        public void setOpenHours(String openHours) {
            this.openHours = openHours;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "DeathRope{" +
                    "name='" + name + '\'' +
                    ", openHours='" + openHours + '\'' +
                    ", price=" + price +
                    '}';
        }
    }


}
