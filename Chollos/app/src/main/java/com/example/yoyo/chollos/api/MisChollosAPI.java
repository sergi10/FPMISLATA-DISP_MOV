package com.example.yoyo.chollos.api;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import com.example.yoyo.chollos.bd.MiBD;
import com.example.yoyo.chollos.pojo.Alojamiento;
import com.example.yoyo.chollos.pojo.Chollo;
import com.example.yoyo.chollos.pojo.Usuario;

/**
 * Created by LOREN on 05/10/2016.
 */

public class MisChollosAPI {

    private static MisChollosAPI instance = null;

    public static MisChollosAPI getInstance(Context contextoAplicacion) {
        if(instance == null) {
            instance = new MisChollosAPI();
            MiBD.setContextoAplicacion(contextoAplicacion);
        }
        return instance;
    }

    // Operacion Login: Verifica que el Usuario existe y que su contraseña es correcta. Recibira un Usuario
    // que solo contendrá el nif y la password.
    public Usuario login(Usuario c){
        Usuario aux = (Usuario) MiBD.getInstanceBD().getUsuarioDAO().search(c);
        if(aux==null){
            return null;
        }else if (aux.getClaveSeguridad().trim().equals(c.getClaveSeguridad().trim())){
            return aux;
        }else{
            return null;
        }
    }

    // Operacion changePassword: Cambia la password del usuario. Recibirá el usuario de la aplicación con la password cambiada.
    // Si devuelve un 1 es que ha verificado el cambio de password como correcto y todo ha ido bien, mientras que si devuelve
    // mientras que si devuelve un 0 no ha verificado el cambio de password como correcto y ha habido un error al cambiarlo.
    public long changePassword(Usuario c){
        long resultado =  MiBD.getInstanceBD().getUsuarioDAO().update(c);
        if (resultado==0) {
            return 0;
        } else {
            return 1;
        }
    }

    // Operacion getListChollos: Obtiene una lista de chollos
    public ArrayList<Chollo> getListChollos(){
        return MiBD.getInstanceBD().getCholloDAO().getAll();
    }

    // Operacion getListAlojamientosByChollo: Obtiene una lista de alojamientos a partir de un chollo que se le pasa
    public ArrayList<Alojamiento> getListAlojamientosByChollo(Chollo chollo){
        return MiBD.getInstanceBD().getAlojamientoDAO().getAlojamientosByChollo(chollo);
    }


}
