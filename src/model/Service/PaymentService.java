package model.Service;

import model.Exception.Domain.LaundryException;
import model.entities.Client;
import model.entities.PieceValue;
import model.enums.laundryServices;

import java.util.ArrayList;
import java.util.List;

public class PaymentService {
    private Client client;
    private List<PieceValue> pieceList = new ArrayList<>();

    private laundryServices laundryServices;

    public PaymentService(Client client) {
        this.client = client;
    }

    public void addProduct (PieceValue piece) {
        pieceList.add(piece);
    }

    public void chooseTypeOfWash (laundryServices laundryServices) {
        this.laundryServices = laundryServices;
    }

    public double total() {
        Double sum = 0.0;

        // Calcula o preço total das peças
        for (PieceValue i : pieceList) {
            sum += i.getPrice();
        }

        // Verifica se o serviço de lavagem foi escolhido
        if (laundryServices == null) {
            throw new LaundryException("No wash type was selected.");
        }

        // Adiciona o preço base do serviço diretamente, sem comparações perigosas
        return sum + laundryServices.getBasePrice();
    }

    // PaymentService.java
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Client: " + client.getName() + "\n");
        sb.append("ID: " + client.getId() + "\n");
        sb.append("Service chosen: " + laundryServices.getDescription() + "\n");
        sb.append("Products:\n"); // Adiciona uma quebra de linha antes da lista de produtos
        for (PieceValue i : pieceList) {
            sb.append("    - " + i.toString() + "\n"); // Adiciona o toString de cada item em uma nova linha e com um recuo
        }
        sb.append("Value Total: R$" + String.format("%.2f", total()));
        return sb.toString();
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
