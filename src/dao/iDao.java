package dao;

import java.util.List;

//LA INTERFACE DEBERIA PODER PERMITIR: GUARDAT, LEER, MODIFICAR, BORRAR
//CRUD
public interface iDao<T> {
    //LA T SERIA EL PARAMETRO A RECIBIR
    T guardar(T t);
    //Lista
    List<T> listar();
}
