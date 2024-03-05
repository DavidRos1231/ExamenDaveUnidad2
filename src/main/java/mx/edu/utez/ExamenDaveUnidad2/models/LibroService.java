package mx.edu.utez.ExamenDaveUnidad2.models;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LibroService {
    @Autowired
    LibroRepository libroRepository;

    @Transactional(rollbackOn = {Exception.class})
    public CustomReponse<Libro> saveLibro(Libro libro){
        return new CustomReponse<>(
                libroRepository.save(libro),
                false,
                200,
                "Ok"
        );
    }

    @Transactional(rollbackOn = {Exception.class})
    public CustomReponse<Libro> updateLibro(Libro libro,Long id){
        Optional<Libro> libroa=libroRepository.findById(id);
        if(libroa.isPresent()){
            libro.setId(id);
        }else {
            return new CustomReponse<>(
                    null,true,400,"No existe tal Libro"
            );
        }
        return new CustomReponse<>(
                libroRepository.save(libro),
                false,
                200,
                "Ok"
        );
    }

    @Transactional
    public CustomReponse<List<Libro>> getAll(){
        return new CustomReponse<>(
                libroRepository.findAll(),
                false,
                200,
                "OK"
        );
    }
    public CustomReponse<String> delete(Long id){
        Optional<Libro> libro=libroRepository.findById(id);
        if(libro.isPresent()){
            libroRepository.delete(libro.get());
            return new CustomReponse<>(
                    null,
                    false,
                    200,
                    "Libro borrado correctamente"
            );
        }else {
            return new CustomReponse<>(
                    null,true,400,"No existe tal Libro"
            );
        }

    }
}
