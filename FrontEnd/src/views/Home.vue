<template>
  <div>
    <b-carousel id="carousel-1" v-model="slide" controls background="#ababab" img-width="1024" img-height="480"
      style="text-shadow: 1px 1px 2px #333;" @sliding-start="onSlideStart" @sliding-end="onSlideEnd">
      <!-- Text slides with image -->
      <b-carousel-slide caption="First slide" text="Nulla vitae elit libero, a pharetra augue mollis interdum."
        img-src="https://picsum.photos/1024/480/?image=52"></b-carousel-slide>

      <!-- Slides with custom text -->
      <b-carousel-slide img-src="https://picsum.photos/1024/480/?image=54">
        <h1>Hello world!</h1>
      </b-carousel-slide>

      <!-- Slides with image only -->
      <b-carousel-slide img-src="https://picsum.photos/1024/480/?image=58"></b-carousel-slide>

      <!-- Slides with img slot -->
      <!-- Note the classes .d-block and .img-fluid to prevent browser default image alignment -->
      <b-carousel-slide>
        <template #img>
          <img class="d-block img-fluid w-100" width="1024" height="480" src="https://picsum.photos/1024/480/?image=55"
            alt="image slot">
        </template>
      </b-carousel-slide>

      <!-- Slide with blank fluid image to maintain slide aspect ratio -->

    </b-carousel>


    <!-- Contenedor principal -->

    <div class='container mt-4 mb-10'>
      <b-container class="bv-example-row">
        <!-- Colulmnas -->
        <b-row>

          <b-col>
            <!-- Filtros -->
            <b-form>

              <div class=''>
                <b-form-group>
                  <b-button class='ml-1 mx-2' variant='primary'>Ordenar por autor</b-button>
                  <b-button class='ml-2 mx-2' variant='primary'>Ordenar por fecha</b-button>
                  <b-button class='ml-2 mx-2' variant='primary'>Mostrar imagen</b-button>
                </b-form-group>
              </div>
            </b-form>
            <!-- Cards -->
           <div class="drop-zone-1 col" @drop="onDropD($event)" @dragover.prevent @dragenter.prevent>
  <div v-show="showElement" class="drag-el" style="background-color: rgb(179, 179, 247);" draggable
    @dragstart="startDrag($event)">
    <div class='mt-2'>
      <b-row>
        <b-col cols="12" md="4" v-for="(libro, index) in libros" :key="libro.id">
          <!-- Agregamos los atributos de arrastre a la tarjeta -->
          <b-card no-body style="max-width: 20rem;" class="mb-3" draggable="true" @dragstart="drag($event, libro)">
            <img :src="libro.enlaceimagen" class="card-img-top" alt="...">
            <b-card-body>
              <h5 class="card-title">{{ libro.nombre }}</h5>
              <p class="card-text">Autor: {{ libro.autor }}</p>
              <p class="card-text">Fecha: {{ libro.fecha }}</p>
            </b-card-body>
          </b-card>
        </b-col>
      </b-row>
    </div>
  </div>
</div>

          </b-col>
          <!-- Acciones -->
          <b-col>
            <!-- Crear -->
            <div>
              <b-button id="show-btn" @click="$bvModal.show('bv-modal-example')" class='' variant='primary'><b-icon
                  icon="plus"></b-icon> </b-button>
            </div>
            <!-- Editar -->
            <div @drop="onDropE($event)" @dragover.prevent @dragenter.prevent class=" mt-2 drop-zone-edit">
              <h4>Sulta para edititar el libro</h4>
            </div>
            <!-- Eliminar -->
          <div @drop="onDropD($event)" @dragover.prevent @dragenter.prevent class="mt-2 drop-zone-delate">
  <h4>Suelta para eliminar el libro</h4>
</div>
          </b-col>

        </b-row>
      </b-container>
    </div>
    <!--Modal Guardar -->
    <div>

      <b-modal hide-header-close='true' id="bv-modal-example" hide-footer hide-header>

        <div class="d-block text-center">
          <h3>Crear una pelicula</h3>
        </div>
        <b-form @submit="onSave" @reset="onReset">
          <!-- Inputs -->
          <b-form-group class="mt-2">
            <b-form-input v-model="form.nombre" placeholder="Nombre"  ype="text"required></b-form-input>

            <br>
            <b-form-input v-model="form.autor" placeholder="Autor" type="text" required></b-form-input>
            <br>
            <b-form-input v-model="form.date" placeholder="Fecha" type="date" required></b-form-input>
            <br>
            <b-form-input v-model="form.enlaceimagen" ype="text" placeholder="Enlace de la imagen" ></b-form-input>
          </b-form-group>
          <br>
          <b-button class="mt-3 mx-3" variant='danger' block @click="$bvModal.hide('bv-modal-example')">
            Cancelar</b-button>
          <b-button class="mt-3"  type="submit" variant='primary' block> Guardar</b-button>
        </b-form>

      </b-modal>
    </div>
     <!--Modal Editar -->
    <div>

      <b-modal hide-header-close='true' id="modal-editar" hide-footer hide-header>

        <div class="d-block text-center">
          <h3>Editar Pelicula</h3>
        </div>
        <b-form @submit="onSave" @reset="onReset">
          <!-- Inputs -->
          <b-form-group class="mt-2">
            <b-form-input v-model="form.nombre" placeholder="Nombre"  ype="text"required></b-form-input>

            <br>
            <b-form-input v-model="form.autor" placeholder="Autor" type="text" required></b-form-input>
            <br>
            <b-form-input v-model="form.date" placeholder="Fecha" type="date" required></b-form-input>
            <br>
            <b-form-input v-model="form.enlaceimagen" ype="text" placeholder="Enlace de la imagen" ></b-form-input>
          </b-form-group>
          <br>
          <b-button class="mt-3 mx-3" variant='danger' block @click="$bvModal.hide('bv-modal-example')">
            Cancelar</b-button>
          <b-button class="mt-3"  type="submit" variant='primary' block> Guardar</b-button>
        </b-form>

      </b-modal>
    </div>
  </div>
</template>

<script>
import librosAxios from '../utils/LibrosAxios.js'

export default {
  data() {
    return {
            showElement: true,

      slide: 0,
      sliding: null,
      libros: [],
      form: {
        nombre: '',
        autor: '',
        date: '',
        enlaceimagen: ''
      }
    }
  },
mounted() {
    this.getLibros()
  },
  methods: {
    onDropD(event) {
  console.log('Soltado para eliminar');
  const libroId = event.dataTransfer.getData("libroId");
  console.log('ID del libro soltado:', libroId);
  this.onDelate(libroId);
},
     onDropE(event) {
      console.log('Soltado');
      console.log(event);
      // this.onDelate()
      
    },

    startDrag(event, libro) {
        event.dataTransfer.setData("libroId", libro.id);

      console.log('Drag started');
      console.log(event);
    },
    onSlideStart(slide) {
      this.sliding = true
    },
    onSlideEnd(slide) {
      this.sliding = false
    },
    async onSave(event) {
      event.preventDefault()

      try {
        await librosAxios.saveLibro(
          this.form.nombre,
          this.form.autor,
          this.form.date,
          this.form.enlaceimagen
        )
        alert('Libro guardado') 
          this.$bvModal.hide('bv-modal-example')
      } catch (error) {
        console.log(error)
        alert('Error al guardar el libro')
      }
      this.resetForm();
    },
    async getLibros() {
      try {
        const response = await librosAxios.getLibros()
        console.log(response.data)

        this.libros = response.data

      } catch (error) {
        console.log(error)
        alert('Error al obtener los libros')
      }
    },
    async onDelate (id) {
      try {
        await librosAxios.delateLibro(id)
        alert('Libro eliminado')
        this.getLibros()
      } catch (error) {
        console.log(error)
        alert('Error al eliminar el libro')
      }
    },
    onReset(event) {
      event.preventDefault()
      this.resetForm();
    },
    resetForm() {
      this.form.nombre = ''
      this.form.autor = ''
      this.form.date = ''
      this.form.enlaceimagen = ''
    }
  }
}
</script>

<style>
.drop-zone-edit {
  margin-bottom: 10px;
  padding: 10px;
  text-align: center;
  width: 400px;
  height: 400px;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #B796D9;
  color: white;

}

.drop-zone-delate {
  margin-bottom: 10px;
  padding: 10px;
  text-align: center;
  width: 400px;
  height: 400px;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #EEF26D;
  color: black;

}
</style>