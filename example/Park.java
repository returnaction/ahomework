package example;

import java.util.ArrayList;
import java.util.List;

public class Park {
    private String parkName;
    private List<Attraction> attractionList;

    public Park(String parkName) {
        this.attractionList = new ArrayList<>();
        this.parkName = parkName;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public List<Attraction> getAttractionList() {
        return attractionList;
    }


    @Override
    public String toString() {
        return "Park{" +
                "parkName='" + parkName + '\'' +
                ", attractionList=" + attractionList +
                '}';
    }

    public class Attraction {
        private String name;
        private double price;
        private String openHours;

        public Attraction(String name, double price, String openHours) {
            this.name = name;
            this.price = price;
            this.openHours = openHours;
            Park.this.attractionList.add(this);

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getOpenHours() {
            return openHours;
        }

        public void setOpenHours(String openHours) {
            this.openHours = openHours;
        }

        @Override
        public String toString() {
            return "Attraction{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", openHours='" + openHours + '\'' +
                    '}';
        }
    }




}
