package model.entities;

import model.Exception.Domain.LaundryException;

public class Client {

    private Integer id;
    private String name;
    private Long phone;
    private String cpf;

    public Client (String name, Long phone, String cpf) {

        if (String.valueOf(phone).length() < 11) {
            throw new LaundryException("The number must contain 10 digits, counting the dd and the 9 after it");
            // aqui esta fazendo um tratamento de escessão onde se os numero digitados forem menos que o numero limite ira aparecer um aviso dizendo q esta errado
        }

        this.cpf = cpf;
        this.name = name;
        this.phone = phone;
        this.id += 1;

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
