# Prototyp: SocketServer

Prototyp för att demonstrera kommunikation via socket. Servern tar emot en sträng som returneras baklänges.

## Starta server via Gradle
`gradle run`

## Starta server via docker-compose
1. `gradle build jar`
1. `docker build -t kilathaar/server .; docker system prune -f`
1. `docker-compose up`

## Kommunicera med server
Ubuntu har en generell TCP/UDP-klient som heter nc man kan använda som klient mot SocketServer.

```bash
$ nc 127.0.0.1 56789
Hello World
dlroW olleH
```

