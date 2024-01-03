public enum cities {
    MUMBAI("Mumbai"),
    CHENNAI("Chennai"),
    HYDERABAD("Hyderabad"),
    PUNE("Pune"),
    BENGALURU("Bengaluru"),
    LUCKNOW("Lucknow"),
    CHANDIGARH("Chandigarh"),
    SIKKIM("Sikkim"),
    DELHI("Delhi"),
    KOLKATA("Kolkata"),
    AHMEDABAD("Ahmedabad"),
    JAIPUR("Jaipur"),
    VARANASI("Varanasi"),
    KOCHI("Kochi"),
    MYSURU("Mysuru"),
    GOA("Goa"),
    PATNA("Patna"),
    BHOPAL("Bhopal"),
    NAGPUR("Nagpur");

    private final String name;

    private cities(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static cities findCity(String cityName) {
        for (cities city : cities.values()) {
            if (city.getName().equalsIgnoreCase(cityName)) {
                return city;
            }
        }
        return null;
    }
}
