/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misclases;

import java.sql.Date;

/**
 *
 * @author alejandro
 */
public class usuario {
    int id;
    String usu;
    String pass;
    int credito;
    Date fecha;
    String rol;

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getCredito() {
        return credito;
    }

    public usuario(int id,String usu, String pass, int credito,Date fecha, String rol) {
        this.id=id;
        this.usu=usu;
        this.pass=pass;
        this.credito=credito;
        this.fecha=fecha;
        this.rol=rol;
    }

    public String getUsu() {
        return usu;
    }

    public String getPass() {
        return pass;
    }

    public String getRol() {
        return rol;
    }


    
    
}
