package model.entities;

public class Client {

    private static int counter = 0;


    private Integer id;
    private String name;
    private Long phone;
    private String cpf;

    public Client (String nameClient, long phoneClient, String cpfClient) {

    }

    public Client (String name, Long phone, String cpf) {

        this.cpf = cpf;
        this.name = name;
        this.phone = phone;
        this.id = counter++;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
