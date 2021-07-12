package controllers

import models.Producto


fun cargar(productos: MutableMap<Int, Producto>) {
    productos[10] = Producto("Galaxi Z flip                       ", "Samsung", 19, "Tecnologia", 2,     24999.99f, 20)
    productos[11] = Producto("Huawei P40                          ", "Huawei ", 7,"Tecnologia", 2,       5099.909f, 15)
    productos[12] = Producto("Iphone 11 Pro Max                   ", "Apple", 2, "Tecnologia", 2,        32999.01f, 15)
    productos[13] = Producto("Smart TV Samsung 40\"                ", "Samsung", 19, "Tecnologia", 2,    5500.001f, 13)
    productos[14] = Producto("Smart TV Sony 43\"                   ", "Sony", 21, "Tecnologia", 2,       8999.901f, 17)
    productos[15] = Producto("Smart TV Samsung 50\"                ", "Samsung", 19, "Tecnologia", 2,    12699.91f, 19)
    productos[16] = Producto("Huawei watch Fit 1.64\"              ", "Huawei", 7,"Tecnologia", 2,       1849.001f, 20)
    productos[17] = Producto("Samsung Galaxy Note 10              ", "Samsung", 19, "Tecnologia", 2,     9261.201f, 33)
    productos[18] = Producto("Samsung Galaxi S21+                 ", "Samsung", 19, "Tecnologia", 2,     18496.91f, 28)
    productos[19] = Producto("Smart TV Hisense 40\"                ", "Hisense", 6, "Tecnologia", 2,     5499.991f, 18)
    productos[20] = Producto("Smart TV LG 32\"                     ", "LG", 10, "Tecnologia", 2,         4895.999f, 17)
    productos[21] = Producto("LG K71 128GB gris                   ", "LG", 10, "Tecnologia", 2,          6470.909f, 33)
    productos[22] = Producto("Iphone X 256GB plata                ", "Apple", 2, "Tecnologia", 2,        10199.01f, 39)
    productos[23] = Producto("Apple Watch Series 3                ", "Apple", 2, "Tecnologia", 2,        6250.999f, 10)
    productos[24] = Producto("Smart TV Hisense 50\"                ", "Hisense", 6, "Tecnologia", 2,     8999.999f, 18)
    productos[25] = Producto("Sony Xperia 5 li                    ", "Sony", 21, "Tecnologia", 2,        23999.99f, 13)
    productos[26] = Producto("Macbook Pro 16\"                     ", "Apple", 2, "Tecnologia", 2,       62999.91f, 17)
    productos[27] = Producto("2 matebook X pro 2020               ", "Huawei", 7,"Tecnologia", 2,        35599.91f, 23)
    productos[28] = Producto("Huawei watch GT 2e                  ", "Huawei", 7,"Tecnologia", 2,        2399.901f, 60)
    productos[29] = Producto("Smart TV Samsung 70\" 4k             ", "Samsung", 19, "Tecnologia", 2,    22393.01f, 32)
    productos[30] = Producto("Organizador de zapatos              ", "Sululu", 23, "hogar y muebles", 4, 231.9999f, 25)
    productos[31] = Producto("sofa cama individual                ", "Nuuk concept", 14, "hogar y muebles", 4, 2300.191f, 26)
    productos[32] = Producto("Silla ejecutiva con respaldo y giro ", "Sululu", 23, "hogar y muebles", 4,       1495.201f, 15)
    productos[33] = Producto("sofa cama matrimonial               ", "Nuuk concept", 14, "hogar y muebles", 4, 8100.999f, 28)
    productos[34] = Producto("Recamara king size                  ", "Nuuk concept", 14, "hogar y muebles", 4, 16100.01f, 12)
    productos[35] = Producto("Mueble de baño                      ", "Sululu", 23, "hogar y muebles", 4,       1560.009f, 67)
    productos[36] = Producto("Licuadora Oster 1.25L               ", "Oster", 15, "Electrodomesticos", 3,      1400.309f, 21)
    productos[37] = Producto("Maquina de palomitas                ", "Oster", 15, "Electrodomesticos", 3,      1560.999f, 18)
    productos[38] = Producto("Freidora electrica                  ", "T-fal", 24, "Electrodomesticos", 3,      2360.199f, 12)
    productos[39] = Producto("Cafetera de goteo 12 tazas          ", "T-fal", 24, "Electrodomesticos", 3,      789.9099f, 23)
    productos[40] = Producto("Camisa manga corta azul             ", "Levis", 9, "Moda", 5,                    580.9019f,     56)
    productos[41] = Producto("Playera Adidas negra                ", "Adidas", 1, "Moda", 5,                   599.9022f, 56)
    productos[42] = Producto("Pantalon levis                      ", "Levis", 9, "Moda", 5,                    860.9022f, 36)
    productos[43] = Producto("Sueter para hombre                  ", "Levis", 9, "Moda", 5,                    760.9022f, 26)
    productos[44] = Producto("Playera tipo polo                   ", "Adidas", 1, "Moda", 5,                   580.9031f, 16)
    productos[45] = Producto("Croqueta para cachorro              ", "Nupec", 13, "Animales y mascotas", 1,    1590.903f, 16)
    productos[46] = Producto("Croqueta para adulto                ", "Nupec", 13, "Animales y mascotas", 1,    1780.933f, 45)
    productos[47] = Producto("Coqueta para razas pequeñas         ", "Nupec", 13, "Animales y mascotas", 1,    1380.944f, 24)
    productos[48] = Producto("Croqueta para gatos                 ", "Sport", 22, "Animales y mascotas", 1,    580.9033f, 33)
    productos[49] = Producto("Caminadora electrica 110v           ", "Sport", 22, "Deportes y fitness", 6,     11999.93f, 13)
    productos[50] = Producto("Caminadora electrica 120v           ", "Sport", 22, "Deportes y fitness", 6,     15980.03f, 10)
    productos[51] = Producto("Bicicleta fija Dynamic              ", "Dynamic", 5, "Deportes y fitness", 6,    15990.03f, 15)
    productos[52] = Producto("Taladro atornillador 20v            ", "Dewalt", 4, "Herramientas", 7,           3080.933f, 16)
    productos[53] = Producto("Sierra circular 60Hz                ", "Dewalt", 4, "Herramientas", 7,           4139.933f, 26)
    productos[54] = Producto("Brocas avellanadoras                ", "Dewalt", 4, "Herramientas", 7,           299.0209f, 51)
    productos[55] = Producto("Rotomartillo cincelador             ", "Bosch", 3, "Herramientas", 7,            3900.002f, 10)
    productos[56] = Producto("Taladro electrico 20v               ", "Bosch", 3, "Herramientas", 7,            2500.022f, 11)
    productos[57] = Producto("Taladro electrico 20v               ", "Pretul", 18, "Herramientas", 7,          2399.022f, 10)
    productos[58] = Producto("Esmeriladora angular Pretul         ", "Pretul", 18, "Herramientas", 7,          2699.022f, 10)
    productos[59] = Producto("Escalera de acero tijera            ", "Pretul", 18, "Construccion", 8,          1199.022f, 12)
    productos[60] = Producto("Bomba electrica periferica          ", "Pretul", 18, "Construccion", 8,          450.9222f, 13)
    productos[61] = Producto("Escritorio homeoficce estudiantil   ", "Nueble", 12, "Industrias y oficinas", 9, 1680.022f, 13)
    productos[62] = Producto("Escritorio homeoficce profesional   ", "Nueble", 12, "Industrias y oficinas", 9, 2600.822f, 40)
    productos[63] = Producto("Escritorio grande empotrado repisa  ", "Nueble", 12, "Industrias y oficinas", 9, 999.9999f, 23)
    productos[64] = Producto("Carburador tsuru3                   ", "Nisaan", 11, "Accesorios para vehiculos", 10,    1949.909f, 24)
    productos[65] = Producto("Kit de distribucion c/bomba         ", "Pontiac", 17, "Accesorios para vehiculos", 10,   2000.119f, 29)
    productos[66] = Producto("Tapa de punterias Tsuru3            ", "Nisaan", 11, "Accesorios para vehiculos", 10,    650.1001f, 21)
    productos[67] = Producto("Lego avengers                       ", "Lego", 8, "Juegos y juguetes", 11,               2499.022f, 41)
    productos[68] = Producto("Set de construccion star wars       ", "Lego", 8, "Juegos y juguetes", 11,               1499.111f, 23)
    productos[69] = Producto("Set de construccion Alcon milenaro  ", "Lego", 8, "Juegos y juguetes", 11,               3099.999f, 43)
    productos[70] = Producto("Conjunto/traje bebe 2 años          ", "Adidas", 1, "Bebes", 12,                         3099.109f,            12)
    productos[71] = Producto("Conjunto/traje bebe 2 años          ", "Adidas", 1, "Bebes", 12,                         899.1019f, 34)
    productos[72] = Producto("Tenis adidas sport 14               ", "Adidas", 1, "Bebes", 12,                         1399.122f, 23)
    productos[73] = Producto("Tenis adidas switch 3 12            ", "Adidas", 1, "Bebes", 12,                         1299.192f, 22)
    productos[74] = Producto("Gel antibacterial para manos 5l     ", "Sani", 20, "Salud y equipamento medico", 13,     1299.222f, 45)
    productos[75] = Producto("Crema limpiadora facial             ", "Oxygen", 16, "Belleza y cuidado personal", 14,   799.1222f, 45)
    productos[76] = Producto("Tonico facial                       ", "Oxygen", 16, "Belleza y cuidado personal", 14,   499.2123f, 45)
    productos[77] = Producto("Crema nocturna facial               ", "Oxygen", 16, "Belleza y cuidado personal", 14,   99.09999f, 35)
    productos[78] = Producto("Guitarra electrica con funda        ", "Yamaha", 25, "Instrumentos musicales", 15,       7499.209f, 25)
    productos[79] = Producto("Guitarra clasica nylon c40m         ", "Yamaha", 25, "Instrumentos musicales", 15,       3199.021f, 45)
    productos[80] = Producto("Paquete de guitarra acustica        ", "Yamaha", 25, "Instrumentos musicales", 15,       3650.022f, 15)

}