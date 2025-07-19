package entities;

public class Client {

    private static int counter = 0;


    private Integer id;
    private String name;
    private Integer phone;
    private String cpf;

    public Client () {

    }

    public Client (String name, Integer phone, String cpf) {

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

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
