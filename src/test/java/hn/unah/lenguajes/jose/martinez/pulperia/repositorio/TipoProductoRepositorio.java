package hn.unah.lenguajes.jose.martinez.pulperia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hn.unah.lenguajes.jose.martinez.pulperia.Modelos.TipoProductoModel;

/*Al usar JPA debemos remarcar que modelo vamos a utilizar 
y el tipo de dato que es su llave primaria por ende se utiliza TipoProductoModel,Long*/
public interface TipoProductoRepositorio extends JpaRepository<TipoProductoModel,Long>{


    /* Esto se utiliza cuando queremos buscar en el modelo utilizando un tipo de dato
     *  Si quisieramos hacerlo con otros datos realizaremos un 
     * public nombreDelModelo nombreDeFuncion(TipoDeDato nombreDeDato)
     */
    public TipoProductoModel buscarPorProducto(String descripcionString);


    public List<TipoProductoModel> getByDescripcion(String descripcion);

    public boolean existsByDescripcion(String descripcion);


    /*
     * @Query("select f from tipo productos f where lower(f.descripcion) = lower(:descripcion)")
    public List<TipoProductoModel> obtenerPorDescripcion(@Param("descripcion")String descripcion);

     * 
     */
    
    /*que es la f */
}
