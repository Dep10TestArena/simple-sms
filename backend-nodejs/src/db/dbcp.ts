import mysql, {Pool} from 'promise-mysql';
import env from 'dotenv'


env.config();
export let dataSource:Pool;


(async function () {
    dataSource = await mysql.createPool({
        host: process.env.DB_HOST,
        user: process.env.DB_USER,
        password: process.env.DB_PASSWORD,
        port: +process.env.DB_PORT!,
        database: process.env.DB_NAME,
        connectionLimit: +process.env.DB_CP_SIZE!,

    });
    //console.log(dataSource);
})();
