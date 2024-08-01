package hn.unah.lenguajes.jose.martinez.pulperia.Modelos;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tipoproducto")


public class TipoProductoModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private long codigoTipoProducto;


private String descripcionString;

}
