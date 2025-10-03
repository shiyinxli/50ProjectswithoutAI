//require("dotenv").config();
const express = require("express");
const cors = require("cors");

const app = express();

app.use(cors());
app.use(express.json());

//Routes
const moodRoutes = require("./routes/mood");

app.use("/mood", moodRoutes);

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
    console.log(`Server running on http://localhost: ${PORT}`);
});