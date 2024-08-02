package hn.unah.lenguajes.jose.martinez.pulperia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.jose.martinez.pulperia.Modelos.TipoProductoModel;
import hn.unah.lenguajes.jose.martinez.pulperia.Servicios.TipoProductoServicio;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/productos")
public class TipoProductoController {

    @Autowired
    private TipoProductoServicio tipoProductoServicio;


    @GetMapping("/todos")   
    public List<TipoProductoModel> obtenerTodos() {
        return this.tipoProductoServicio.obtenerTodos();
    }

    @GetMapping("/prueba")
    public String hola()
    {
        return "funciona";
    }

    @PostMapping("/crear")
    public TipoProductoModel crearNuevoProducto(@RequestParam String descripcion) {
        return this.tipoProductoServicio.crearNuevo(descripcion);
    }

    @GetMapping("/obtener/{codigotipo}") /*esto es solo para valores tipo long   */
    public TipoProductoModel getProducto(@PathVariable(name="codigotipo")long codigoTipo) {
        return this.tipoProductoServicio.obtenerPorCodigo(codigoTipo);
    }



    @GetMapping("/descripcion")
    public List<TipoProductoModel> getProductoByDesc(@RequestParam(name="descripcion")String descripcion ) {
        return this.tipoProductoServicio.ObtenerPorDescripcion(descripcion);
    }
    

    @DeleteMapping("/eliminar/{codigoTipo}")
    public String EliminarPorProducto(@PathVariable(name="codigoTipo") long codigoTipo )
    {
        return this.tipoProductoServicio.eliminarPorCodigo(codigoTipo);
    }
    
    @DeleteMapping("/delete")
    public String DeleteByProduct (@RequestParam(name="descripcion")String descripcion )
    {
        return this.tipoProductoServicio.eliminarPorDescripcion(descripcion);
    }
    
    @PutMapping("/actualizar/{codigoTipo}")
    public TipoProductoModel actualizar(@PathVariable (name="codigoTipo") long codigo, @RequestBody TipoProductoModel tipoProducto) {
    
        
        return this.tipoProductoServicio.actualizar(codigo, tipoProducto);
    }
    


}
