import express, {json} from 'express';
import {router as CourseHTTPController} from "./api/CourseHTTPController";
import cors from 'cors';


const app =express();

app.use(json())
app.use(cors());
app.use("/api/v1/courses",CourseHTTPController)

app.listen(8081, () => console.log("Server has been created"));