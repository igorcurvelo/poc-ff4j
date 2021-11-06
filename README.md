# FF4J

O **poc-ff4j** é um projeto para estudos do framework [ff4j](https://github.com/ff4j/ff4j).

### **Negócio**

Validação das funcionalidades do framework.

### **Projeto**

- **ff4j**: Projeto que contém o front do ff4j.
- **rest**: Projeto que simula uma API que utiliza o ff4j.
- **worker**: Projeto que simula um worker que utiliza o ff4j.

## **Requisitos**

```shell
Java 11
Maven 3.6+
Docker
```

### **Build**

Em cada projeto individualmente

```(shell)
./mvnw clean install
```

### **Desenvolvimento**

## Docker

Para subir o banco de dados.

```(shell)
docker-compose up -d
```

## Subindo local

via IDE:
`Clicar em "run" na classes de ...Application.java`

via terminal
`java -jar target/{app_name}.jar`

Confira o log.

