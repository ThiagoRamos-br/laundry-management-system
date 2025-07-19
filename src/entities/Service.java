package entities;

import enums.laundryServices;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private Client client;
    private List<PieceValue> pieceList = new ArrayList<>();

    private laundryServices laundryServices;

    public Service(Client client) {
        this.client = client;
    }

    public void addProduct (PieceValue piece) {
        pieceList.add(piece);
    }

    public void chooseTypeOfWash (laundryServices laundryServices) {
        this.laundryServices = laundryServices;
    }

    public Double total () {
        Double sum = 0.0;

        for (PieceValue i : pieceList) {
            sum += i.getPrice();
        }

        if (laundryServices.getBasePrice() == 15.00) {
          return  sum += 15.00;
        }else if (laundryServices.getBasePrice() == 20.00) {
            return  sum += 20.00;
        }else {
            return sum += 30.00;
        }
    }

    @Override
    public String toString () {
        StringBuilder test = new StringBuilder();
        test.append("Client: " + client.getName() + "\n");
        test.append("ID: " + client.getId() + "\n");
        test.append("Service chosen" + laundryServices.getDescription() + "\n");
        test.append("Products:");
        for (PieceValue i : pieceList) {
            test.append(i);
        }
        test.append("Value Total: R$" + total() );


        return test.toString();
    }

    public laundryServices getLaundryServices() {
        return laundryServices;
    }

    public void setLaundryServices(laundryServices laundryServices) {
        this.laundryServices = laundryServices;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
