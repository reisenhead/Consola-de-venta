//package prueba
//Data class v3

data class Producto(val nombre: String, val marca:String, val categoria:String,val precio: Float, val cantidad: Int)

    fun cargar(productos: MutableMap<Int, Producto>) {
        productos[10] = Producto("Galaxi Z flip           ", "Samsung", "Celular   ", 24999.99f, 20)
        productos[11] = Producto("Huawei P40              ", "Huawei", "Celular    ", 5099.901f , 15)
        productos[12] = Producto("Iphone 11 Pro Max       ", "Apple", "Celular     ", 32999.02f, 25)
        productos[13] = Producto("Smart TV Samsung 40\"    ", "Samsung", "Televisor", 5500.002f    , 23)
        productos[14] = Producto("Smart TV Sony 43\"      ", "Sony", "Televisor    ", 8999.901f , 27)
        productos[15] = Producto("Smart TV Samsung 50\"    ", "Samsung", "Televisor", 12699.91f, 29)
        productos[16] = Producto("Huawei whatch Fit 1.64\" ", "Huawei", "Reloj     ", 1849.001f, 20)
        productos[17] = Producto("Samsung Galaxy Note 10  ", "Samsung", "Celular   ", 9261.201f, 13)
        productos[18] = Producto("Samsung Galaxi S21+     ", "Samsung", "Celular   ", 18496.91f, 18)
        productos[19] = Producto("Smart TV Hisense 40\"    ", "Hisense", "Televisor", 5499.991f, 18)
        productos[20] = Producto("Smart TV LG 32\"         ", "LG", "Televisor     ", 4895.902f, 27)
        productos[21] = Producto("LG K71 128GB gris       ", "LG", "Celular        ", 6470.902f, 23)
        productos[22] = Producto("Iphone X 256GB plata    ", "Apple", "Celular     ", 10199.02f, 29)
        productos[23] = Producto("Apple Watch Series 3    ", "Apple", "Reloj       ", 6250.002f, 20)
        productos[24] = Producto("Smart TV Hisense 50\"    ", "Hisense", "Televisor", 8999.991f, 28)
        productos[25] = Producto("Sony Xperia 5 li        ", "Sony", "Celular      ", 23999.99f, 30)
        productos[26] = Producto("Macbook Pro 16\"         ", "Apple", "Laptop     ", 62999.91f, 27)
        productos[27] = Producto("Laptop matebookX pro2020", "Huawei", "Laptop     ", 35599.01f, 13)
        productos[28] = Producto("Huawei watch GT 2e      ", "Huawei", "Reloj      ", 2399.901f, 16)
        productos[29] = Producto("Smart TV Samsung 70\" 4k ", "Samsung", "Televisor", 22393.01f, 12)

    }

