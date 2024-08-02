package hn.unah.lenguajes.jose.martinez.pulperia.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.jose.martinez.pulperia.repositorio.TipoProductoRepositorio;
import jakarta.transaction.Transactional;
import hn.unah.lenguajes.jose.martinez.pulperia.Modelos.TipoProductoModel;

@Service
@Transactional 
/*Se agrega esto para poder eliminar los datos a traves de la descripcion
* O en general para crear un metodo personalizado de delete
*
*/
public class TipoProductoServicio {

    @Autowired
    private TipoProductoRepositorio tipoProductoRepositorio;

    /*Obtener todos los productos dentro del modelo */
    public List<TipoProductoModel> obtenerTodos(){
        return this.tipoProductoRepositorio.findAll();
    }


    public TipoProductoModel crearNuevo(String descripcionString){
        TipoProductoModel tipoProductoModel = new TipoProductoModel();
        tipoProductoModel.setDescripcionString(descripcionString); 
        return this.tipoProductoRepositorio.save(tipoProductoModel);
    }

    public TipoProductoModel obtenerPorCodigo(long codigoTipoProducto)
    {
        return this.tipoProductoRepositorio.findById(codigoTipoProducto).get();

    }


    public String eliminarPorCodigo(long codigoTipo){
        if(this.tipoProductoRepositorio.existsById(codigoTipo)){
            this.tipoProductoRepositorio.deleteById(codigoTipo);
            return "Se ha eliminado el registro";
        }
        return "No existe el registro";
    }

    public String eliminarPorDescripcion (String descripcion)
    {
        if(this.tipoProductoRepositorio.existsByDescripcionString(descripcion))
        {
            this.tipoProductoRepositorio.deleteByDescripcionString(descripcion);
            return "Registro eliminado por medio de la descripcion con exito";
        }
        else
        {
            return "No Existe el Registro";
        }
    }

     public TipoProductoModel actualizar(long codigoTipoProducto, TipoProductoModel tipoProducto){
        if(this.tipoProductoRepositorio.existsById(codigoTipoProducto)){            
            TipoProductoModel tipoProductoActualizar = this.tipoProductoRepositorio.findById(codigoTipoProducto).get();
            tipoProductoActualizar.setDescripcionString(tipoProducto.getDescripcionString());
            tipoProductoActualizar.setReorden(tipoProducto.getReorden());
            this.tipoProductoRepositorio.save(tipoProductoActualizar);
            return tipoProductoActualizar;
        }
        return null;
    }

    public List<TipoProductoModel >ObtenerPorDescripcion (String descripcion )
    {
        return this.tipoProductoRepositorio.ObtenerPorDescripcion(descripcion);
      // return this.tipoProductoRepositorio.ObtenerPorDescripcion(descripcion);
    }




    
    
    /*
     * Como buscar por un campo en especifico 
     * y eliminar por campo en especifico
     *
    
    */
    


    /*
     *  Esto regresa el tipo de proctuo por base al codigo
     * 
     * 
     */




    /*
     * La funcion crearNuevo se encarga de utilizar en el modelo 
     * Se genera un modelo nuevo para crear un nuevo registro dentro de la tabla 
     * Utiliza el setDescripcionString en modelo gracias a Lombok 
     * y regresa este objeto para guardarlo con el this.tipoProductoRepositorio.save()
     * 
     */

    /*   
    public TipoProducto crearNuevo(String descripcion){
        TipoProducto tipoProducto = new TipoProducto();
        tipoProducto.setDescripcion(descripcion);
        return this.tipoProductoRepositorio.save(tipoProducto);
    }
    */

}
