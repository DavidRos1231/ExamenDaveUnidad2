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


const getLibrosOrderFec = async () => {
  const url = `${baseURL}libros/get/fecha/1`;
  console.log(url)
  try {
    const response = await axios.get(url);
    console.log(response.data)
    return response.data;
  } catch (error) {
    console.error(error);
  }
}

// servicio para http://localhost:8080/api/libros/get/nombre/0

const getLibrosOrderNom = async () => {
  const url = `${baseURL}libros/get/nombre/0`;
  console.log(url)
  try {
    const response = await axios.get(url);
    console.log(response.data)
    return response.data;

  } catch (error) {
    console.error(error);

  }

}


const getLibrosOrderAut = async () => {
  const url = `${baseURL}libros/get/autor/1`;
  console.log(url)
  try {
    const response = await axios.get(url);
    console.log(response.data)
    return response.data;

  } catch (error) {
    console.error(error);

  }


}


const getLibrosOrderImg = async () => {
  const url = `${baseURL}libros/get/imagen`;
  console.log(url)
  try {
    const response = await axios.get(url);
    console.log(response.data)
    return response.data;

  } catch (error) {
    console.error(error);

  }
}

const getLibrosImagen = async () => {
  const url = `${baseURL}libros/get/onlyImages`;
  console.log(url)
  try {
    const response = await axios.get(url);
    console.log(response.data)
    return response.data;

  } catch (error) {
    console.error(error);

  }
}

export default {
  getLibros,
  saveLibro,
  delateLibro,
  getLibrosOrderFec,
  getLibrosOrderNom,
  getLibrosOrderAut,
  getLibrosOrderImg,
  getLibrosImagen




};