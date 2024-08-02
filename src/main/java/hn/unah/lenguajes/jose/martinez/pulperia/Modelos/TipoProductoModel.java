package hn.unah.lenguajes.jose.martinez.pulperia.Modelos;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tipoproducto")

@Data
public class TipoProductoModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigotipoproducto")
private long codigoTipoProducto;

@Column(name="descripcion")
private String descripcionString;

private Integer reorden;

}
