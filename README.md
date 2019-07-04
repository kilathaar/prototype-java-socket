# Prototyp: SocketServer

Prototyp för att demonstrera kommunikation via socket. Servern tar emot en sträng som returneras baklänges.

Starta server med `gradle run`

Ubuntu har en generell TCP/UDP-klient som heter nc man kan använda som klient mot SocketServer.

```bash
$ nc 127.0.0.1 56789
Hello World
dlroW olleH
```
