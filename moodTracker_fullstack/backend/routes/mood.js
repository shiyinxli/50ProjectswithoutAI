const express = require("express");
const router = express.Router();

let moods = []; // hier speichern wir die Stimmungseinträge

// POST /mood → neue Stimmung speichern
router.post("/", (req, res) => {
  const { mood } = req.body;

  if (!mood) {
    return res.status(400).json({ error: "Mood fehlt!" });
  }

  const newMood = {
    id: moods.length + 1,
    mood,
    date: new Date().toISOString(),
  };

  moods.push(newMood);
  res.status(201).json(newMood);
});

// GET /mood → alle Stimmungen abrufen
router.get("/", (req, res) => {
  res.json(moods);
});

// DELETE /mood/:id → Stimmung löschen
router.delete("/:id", (req, res) => {
  const { id } = req.params;
  const index = moods.findIndex((m) => m.id === parseInt(id));

  if (index === -1) {
    return res.status(404).json({ error: "Mood nicht gefunden" });
  }

  const deleted = moods.splice(index, 1);
  res.json({ message: "Mood gelöscht", deleted });
});

module.exports = router;
