package controllers

import models.Usuario

fun cargarUsuarios(usuarios: MutableMap<Int, Usuario>){
    usuarios[1] = Usuario("Bedu","toor")

}