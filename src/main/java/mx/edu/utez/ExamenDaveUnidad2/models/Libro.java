package mx.edu.utez.ExamenDaveUnidad2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name="autor",nullable = false)
    private String autor;

    @Column(name = "fechapub",nullable = false)
    private Date date;

    @Column(name="enlaceimagen",nullable = false,columnDefinition = "TEXT(500)")
    private String enlaceimagen;


}
