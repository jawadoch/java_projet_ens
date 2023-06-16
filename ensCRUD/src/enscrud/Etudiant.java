/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enscrud;

/**
 *
 * @author jawad
 */
public class Etudiant {
    
    private int cne;
    private String nom;
    private String prenom;
    private int filiere_id;
    private int dep_id;
    private String tel;

    public Etudiant(int cne, String nom, String prenom, int filiere_id, int dep_id, String tel) {
        this.cne = cne;
        this.nom = nom;
        this.prenom = prenom;
        this.filiere_id = filiere_id;
        this.dep_id = dep_id;
        this.tel = tel;
    }

    public int getCne() {
        return cne;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getFiliere_id() {
        return filiere_id;
    }

    public int getDep_id() {
        return dep_id;
    }

    public String getTel() {
        return tel;
    }

    public void setCne(int cne) {
        this.cne = cne;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setFiliere_id(int filiere_id) {
        this.filiere_id = filiere_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
    
    
}


