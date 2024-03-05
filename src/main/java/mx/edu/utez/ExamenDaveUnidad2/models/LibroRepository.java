package mx.edu.utez.ExamenDaveUnidad2.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro,Long> {
    Optional<Libro> findById(Long id);

    @Query(
            value = "SELECT * FROM examendaveu2.libro ORDER BY fechapub",
            nativeQuery = true
    )
    List<Libro> getLibroOrderByFecha();
    @Query(
            value = "SELECT * FROM examendaveu2.libro ORDER BY nombre",
            nativeQuery = true
    )
    List<Libro> getLibroOrderByNombre();

    @Query(
            value = "SELECT * FROM examendaveu2.libro ORDER BY autor",
            nativeQuery = true
    )
    List<Libro> getLibroOrderByAutor();
    @Query(
            value = "SELECT * FROM examendaveu2.libro ORDER BY enlaceimagen desc",
            nativeQuery = true
    )
    List<Libro> getLibroOrderByImagen();
    @Query(
            value = "SELECT enlaceimagen FROM examendaveu2.libro where enlaceimagen is not null",
            nativeQuery = true
    )
    List<String> getImages();
}
