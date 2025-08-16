package model.Program;

import model.entities.Client;
import model.entities.PieceValue;
import model.entities.Product;
import model.entities.Service;
import enums.laundryServices;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Laundry customer registration");
        System.out.println();

        System.out.println("===Client===");
        System.out.println("Name:");
        String nameClient = sc.nextLine();

        System.out.println("CPF:");
        String cpfClient = sc.nextLine();

        System.out.println("Phone:");
        int phoneClient = sc.nextInt();
        sc.nextLine();


        Client client = new Client(nameClient, phoneClient, cpfClient);

        Service service = new Service(client);

        laundryServices laundryServices = null;

        while (true) {
            try {
                System.out.println("Type of wash: NORMAL / A_SECO / DELICADA");
                String desc = sc.nextLine().toUpperCase();
                laundryServices = laundryServices.valueOf(desc); // conversão segura
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid wash type. Try again.");
            } finally {
                sc.close();
            }
        }

        service.chooseTypeOfWash(laundryServices);

        int amountOfRepetition = 0;

        try{
        System.out.println("How many pieces of clothing will you wash?");
        amountOfRepetition = sc.nextInt();
        sc.nextLine();
        }  catch (InputMismatchException e) {
            // excessão para  avisar se for escrito um codigo cm tipo primitivo incorreto
            System.out.println("Invalid option!!!");
        } finally {
            sc.close();
        }



            for (int i = 0 ; i < amountOfRepetition ; i ++) {
                try {
                    System.out.println("Par type:");
                    String parTypeProduct = sc.nextLine();

                    System.out.println("color:");
                    String colorProduct = sc.nextLine();

                    System.out.println("mark:");
                    String markProduct = sc.nextLine();


                    Product product = new Product(markProduct, colorProduct, parTypeProduct);
                    PieceValue pieceValue = new PieceValue(product);

                    service.addProduct(pieceValue);
                }catch (InputMismatchException e) {
                    System.out.println("Option Invalid");
                } finally {
                    sc.close();
                }
            }

        System.out.println(service.toString());;

        sc.close();
    }
}