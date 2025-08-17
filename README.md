# 📚 Literalura Challenge 2025

[![Java](https://img.shields.io/badge/Java-17+-blue)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.4-green)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16+-blue)](https://www.postgresql.org/download/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

---

## 🔹 Descripción

**Literalura Challenge 2025** es una aplicación Java con Spring Boot que permite:

- Consultar libros desde la API [Gutendex](https://gutendex.com/).  
- Registrar libros y autores en PostgreSQL usando Spring Data JPA.  
- Realizar búsquedas interactivas de libros y autores desde consola.  
- Listar libros por idioma y buscar autores por año de nacimiento.  

El proyecto fue desarrollado como parte del desafío LiterAlura 2025.

---

## 🛠 Requisitos

- Java JDK 17 o superior  
- Maven 4 o superior  
- Spring Boot 3.5.4 
- PostgreSQL 16 o superior  
- IDE recomendado: IntelliJ IDEA o Visual Studio Code  

---

## ⚙️ Configuración

1. **Crear la base de datos PostgreSQL**:

```sql
CREATE DATABASE literalura;
```

2. **Configurar variables de entorno**:

```
DB_HOST=localhost
DB_USER=tu_usuario
DB_PASSWORD=tu_contraseña
```

3. **Verificar `application.properties`**:

```properties
spring.datasource.url=jdbc:postgresql://${DB_HOST}/literalura
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

---

## 🚀 Cómo ejecutar

1. Ejecuta la clase Principal desde tu IDE o terminal


2. Interactuar con el menú en consola:

- Buscar libro por título  
- Listar libros registrados  
- Ver autores  
- Buscar autor por año  
- Listar libros por idioma  

---

## 🎯 Funcionalidades principales

- Búsqueda por título con lista de coincidencias.  
- Registro de libros y autores en la base de datos.  
- Listado de libros por idioma.  
- Búsqueda de autores por año de nacimiento.  
- Menú seguro que maneja entradas inválidas y evita crashes.  

---

## 👨‍💻 Autor

**Gonzalo** – Proyecto desarrollado para el desafío LiterAlura Challenge 2025. 🔗 [GitHub](https://github.com/Husky-Bit)

---

## 📄 Licencia

Este proyecto está bajo la licencia **MIT**:

```
MIT License

Copyright (c) 2025 Gonzalo

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
