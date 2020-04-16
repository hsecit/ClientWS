package com.example.clientws;

/**
 *
 * @author Administrator
 */
public class Contact {
    int idcontact;
    String nomcontact;
    String tel;

    public Contact() {
    }

    public Contact(int idcontact, String nomcontact, String tel) {
        this.idcontact = idcontact;
        this.nomcontact = nomcontact;
        this.tel = tel;
    }

    public int getIdcontact() {
        return idcontact;
    }

    public String getNomcontact() {
        return nomcontact;
    }

    public String getTel() {
        return tel;
    }

    public void setIdcontact(int idcontact) {
        this.idcontact = idcontact;
    }

    public void setNomcontact(String nomcontact) {
        this.nomcontact = nomcontact;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    public String toString() {
        return "Contact{" + "idcontact=" + idcontact + ", nomcontact=" + nomcontact + ", tel=" + tel + '}';
    }

}
