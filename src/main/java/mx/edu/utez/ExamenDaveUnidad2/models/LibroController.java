package mx.edu.utez.ExamenDaveUnidad2.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin(origins = {"*"})
public class LibroController {
    @Autowired
    LibroService libroService;

    @GetMapping("/")
    public ResponseEntity<CustomReponse<List<Libro>>> getAll(){
        return new ResponseEntity<>(libroService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<CustomReponse<Libro>> save(@RequestBody Libro libro){
        return new ResponseEntity<>(libroService.saveLibro(libro), HttpStatus.OK);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<CustomReponse<Libro>> edit(@RequestBody Libro libro,@PathVariable Long id){
        return new ResponseEntity<>(libroService.updateLibro(libro,id), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CustomReponse<String>> delete(@PathVariable Long id){
        return new ResponseEntity<>(libroService.delete(id), HttpStatus.OK);
    }
    @GetMapping("/get/fecha/{ascdesc}")
    public ResponseEntity<CustomReponse<List<Libro>>> getOrderFecha(@PathVariable int ascdesc){
        return new ResponseEntity<>(libroService.getbyFecha(ascdesc), HttpStatus.OK);
    }
    @GetMapping("/get/nombre/{ascdesc}")
    public ResponseEntity<CustomReponse<List<Libro>>> getOrderNombre(@PathVariable int ascdesc){
        return new ResponseEntity<>(libroService.getbyNombre(ascdesc), HttpStatus.OK);
    }
    @GetMapping("/get/autor/{ascdesc}")
    public ResponseEntity<CustomReponse<List<Libro>>> getOrderAutor(@PathVariable int ascdesc){
        return new ResponseEntity<>(libroService.getByAutor(ascdesc), HttpStatus.OK);
    }

}