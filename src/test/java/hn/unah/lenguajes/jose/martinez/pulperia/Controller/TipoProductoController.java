package hn.unah.lenguajes.jose.martinez.pulperia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.jose.martinez.pulperia.Modelos.TipoProductoModel;
import hn.unah.lenguajes.jose.martinez.pulperia.repositorio.TipoProductoRepositorio;
import hn.unah.lenguajes.jose.martinez.pulperia.Servicios.TipoProductoServicio;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api/tiproductos")
public class TipoProductoController {

    @Autowired
    private TipoProductoServicio tipoProductoServicio;


    @GetMapping("/todos")   
    public List<TipoProductoModel> obtenerTodos() {
        return this.tipoProductoServicio.obtenerTodos();
    }
    


}
