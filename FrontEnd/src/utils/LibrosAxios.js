import axios from "axios";

const baseURL = "http://localhost:8080/api/";
export const getLibros = async () => {
  const url = `${baseURL}libros/`;
  console.log(url)
  try {
    const response = await axios.get(url);
    console.log(response.data)
    return response.data;
  } catch (error) {
    console.error(error);
  }
}

const saveLibro = async (nombre, autor, fecha, enlaceimagen) => {
  const url = `${baseURL}libros/save`;
  console.log(url);

  const data = {
    nombre: nombre,
    autor: autor,
    date: fecha,
    enlaceimagen: enlaceimagen
  };

  console.log("Datos enviados:", data);

  try {
    const response = await axios.post(url, data);
    console.log(response.data);
    return response.data;
  } catch (error) {
    console.error(error);

  }
};

const delateLibro = async (id) => {
  const url = `${baseURL}libros/delete/${id}`;
  console.log(url);

  try {
    const response = await axios.delete(url);
    console.log(response.data);
    return response.data;
  } catch (error) {
    console.error(error);
  }
};


export default {
  getLibros,
  saveLibro,
  delateLibro
};