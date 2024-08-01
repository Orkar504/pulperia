package hn.unah.lenguajes.jose.martinez.pulperia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.lenguajes.jose.martinez.pulperia.Modelos.TipoProductoModel;

/*Al usar JPA debemos remarcar que modelo vamos a utilizar 
y el tipo de dato que es su llave primaria por ende se utiliza TipoProductoModel,Long*/
public interface TipoProductoRepositorio extends JpaRepository<TipoProductoModel,Long>{


    /* Esto se utiliza cuando queremos buscar en el modelo utilizando un tipo de dato
     * 
     */
    public TipoProductoModel buscarPorProducto(String descripcionString);

}
