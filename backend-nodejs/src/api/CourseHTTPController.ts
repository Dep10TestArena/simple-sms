import express from "express";
import {dataSource} from "../db/dbcp";


export const router = express.Router();

//console.log(dataSource);

router.get('/', (req, res) => {
    res.send("<h1>Get All Books</h1>");
});
router.post('/:id', (req, res) => {
    res.send("<h1>Save a book</h1>");
});
router.delete('/:id', (req, res) => {
    res.send("<h1>Delete a book</h1>");
});
