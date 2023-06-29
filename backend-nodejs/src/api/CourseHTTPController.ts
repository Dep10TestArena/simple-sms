import express from "express";
import {dataSource} from "../db/dbcp";


export const router = express.Router();

//console.log(dataSource);

type Course = {
    id: string,
    description: string,
    duration: string
}

router.get('/', async (req, res) => {
    const result = await dataSource.query('SELECT * FROM course')
    console.log(result)
    res.json(result);
    //res.sendStatus(result.affectedRows ? 204 : 404);
});
router.post('/', async (req, res) => {
    const course =  req.body as Course;
    if (!course.id?.trim()) {
        res.sendStatus(400);
        return;
    }
    if (!course.description?.trim()) {
        res.sendStatus(400);
        return;
    }
    if (!course.duration?.trim()) {
        res.sendStatus(400);
        return;
    }
    const result=await dataSource.query('INSERT INTO course (id, description, duration) VALUES (?,?,?)',[course.id,course.description,course.duration]);
    res.sendStatus(result.affectedRows ? 200 : 404);
});
router.delete('/:id', async (req, res) => {

    const result = await dataSource.query('DELETE FROM course WHERE id=?',[req.params.id])
    res.sendStatus(result.affectedRows ? 204 : 404);
});
