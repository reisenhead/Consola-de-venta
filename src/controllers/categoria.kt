package controllers

import `mercadolibre eq3`.Producto
import models.Categoria


fun cargarCategorias(categorias: MutableMap<Int, Categoria>){
    categorias[1] = Categoria(1,"Vehiculos")
    categorias[2] = Categoria(2,"Tecnologia")
    categorias[3] = Categoria(3,"Electrodomesticos")
    categorias[4] = Categoria(4,"Hogar y muebles")
    categorias[5] = Categoria(5,"Moda")
    categorias[6] = Categoria(6,"Deportes y fitness")
    categorias[7] = Categoria(7,"Herramientas")
    categorias[8] = Categoria(8,"Construccion")
    categorias[9] = Categoria(9,"Industrias y oficinas")
    categorias[10] = Categoria(10,"Accesorios para vehiculos")
    categorias[11] = Categoria(11,"Juegos y juguetes")
    categorias[12] = Categoria(12,"Bebes")
    categorias[13] = Categoria(13,"Salud y equipamiento medico")
    categorias[14] = Categoria(14,"Belleza y cuidado personal")
    categorias[15] = Categoria(15,"Inmuebles")
    categorias[16] = Categoria(16,"Productos sustentables")
    categorias[17] = Categoria(17,"Tiendas oficiales")
    categorias[18] = Categoria(18,"Ver mas categorias")
}