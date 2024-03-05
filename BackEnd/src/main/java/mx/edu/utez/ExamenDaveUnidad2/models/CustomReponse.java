package mx.edu.utez.ExamenDaveUnidad2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomReponse<T> {
    private T data;
    private boolean error;
    private int code;
    private String message;
}
