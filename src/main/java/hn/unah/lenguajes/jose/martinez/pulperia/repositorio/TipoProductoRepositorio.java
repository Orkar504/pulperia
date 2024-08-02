package hn.unah.lenguajes.jose.martinez.pulperia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hn.unah.lenguajes.jose.martinez.pulperia.Modelos.TipoProductoModel;

/*Al usar JPA debemos remarcar que modelo vamos a utilizar 
y el tipo de dato que es su llave primaria por ende se utiliza TipoProductoModel,Long*/
public interface TipoProductoRepositorio extends JpaRepository<TipoProductoModel,Long>{


    /* Esto se utiliza cuando queremos buscar en el modelo utilizando un tipo de dato
     *  Si quisieramos hacerlo con otros datos realizaremos un 
     * public nombreDelModelo getByNombreDeVariable(TipoDeDato nombreDeDato)
     */
    //public TipoProductoModel buscarPorProducto(String descripcionString);


    public List<TipoProductoModel> getByDescripcionString(String descripcionString);

    /*El nombre de la funcion realiza un modelo basandose en el nombre de la 
     * variable dentro del modelo
     */
    public boolean existsByDescripcionString(String descripcionString);

    public long deleteByDescripcionString(String descripcionString);


    /*Esto sirve para obtener un registro utilizando un dato diferente */
    @Query("select f from TipoProductoModel f where f.descripcionString =  :descripcion")

    public List<TipoProductoModel> ObtenerPorDescripcion(@Param("descripcion")String descripcionString);




    /*
     * @Query("select f from tipo productos f where lower(f.descripcion) = lower(:descripcion)")
    public List<TipoProductoModel> obtenerPorDescripcion(@Param("descripcion")String descripcion);

     * 
     */
    

}
