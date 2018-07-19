public class Buyer {

    Coordinates coordinates;

    public Buyer(String[] buyerDetails){
        this.coordinates = readBuyerCoordinates(buyerDetails);
        BuyerRepository.addToList(this);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public static Buyer readBuyerDetails(String[] buyerDetails) throws Exception {


        if (Integer.parseInt(buyerDetails[0]) > World.getWorld().length ||Integer.parseInt(buyerDetails[1]) > World.getWorld().length) {
            throw new Exception("Buyer is out of bounds of the world!");

        }

        return new Buyer(buyerDetails);
    }

    public static Coordinates readBuyerCoordinates(String[] buyerDetails){
        Coordinates coordinates = new Coordinates();
        coordinates.setBuyerCoordinates(buyerDetails);
        return coordinates;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "coordinates=" + coordinates +
                '}';
    }
}
