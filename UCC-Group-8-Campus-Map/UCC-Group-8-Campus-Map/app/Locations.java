package app;

public class Locations {
    private String name;
    private String direction;
    private boolean isPivot;  // New field to indicate whether the location is a pivot

    public Locations(String name, String direction, boolean isPivot) {
        this.name = name;
        this.direction = direction;
        this.isPivot = isPivot;
    }


    public Locations(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Locations){
            Locations other = (Locations) obj;
            return other.getName().equals(getName());
            }
        return false;
    }
    
    @Override
    public String toString() {
        return this.name;
    }    
}

