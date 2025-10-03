## Starte den Server
```
node index.js
```
## Mood speichern
```
curl -X POST http://localhost:3000/mood \
  -H "Content-Type: application/json" \
  -d '{"mood":"happy"}'
```
## Alles Moods abrufen
```
curl http://localhost:3000/mood
```
## Einen Mood löschen
```
curl -X DELETE http://localhost:3000/mood/1
```