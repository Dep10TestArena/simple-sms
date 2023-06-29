import express from "express";


export const router = express.Router();

router.get('/', (req, res) => {
    res.send("<h1>Get All Books</h1>");
});
router.post('/:id', (req, res) => {
    res.send("<h1>Save a book</h1>");
});
router.delete('/:id', (req, res) => {
    res.send("<h1>Delete a book</h1>");
});
