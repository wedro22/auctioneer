package ru.wedro22.auctioneer.db;

import net.minecraft.nbt.NBTTagCompound;
import ru.wedro22.auctioneer.AItemStack;
import ru.wedro22.auctioneer.LotObject;

import java.io.*;
import java.sql.*;

/**
 * Класс для работы с БД
 */
public class DB {
    //ДОДЕЛАТЬ!!! загрузка констант из конфига
    public static final String URL="jdbc:mysql://localhost:3306/test1?user=test&password=testtest";
    private static Connection db=null;


    /**
     * @param   url БД, пользователь, пароль
     * @return  true, если БД рискнула открыться
     */
    public static boolean init(String url) {
        try {
            db = DriverManager.getConnection(url);
            db.setAutoCommit(false);    //для пакетных выполнений
            if (!db.getMetaData().supportsBatchUpdates()) {   //не поддерживаются пакетные выполнения, кыш!
                System.out.println("supportsBatchUpdates=false!"); //ПЕРЕДЕЛАТЬ!!!
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            close();
        }
        return false;
    }

    /**
     * @return true, если БД закрылась/не была открыта
     */
    public static boolean close(){
        if (db!=null) {
            try {
                db.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return  false;
            }
        }
        return true;
    }

    /**
     * @return true, если БД открыта
     */
    public static boolean isInit() {
        if (db!=null) {
            return true;
        }
        return false;
    }

    /**
     * Сохраняет лот в БД
     * @param lot лот аукциона
     * @return true, если успешно
     * @throws SQLException
     */
    public boolean addLot(LotObject lot) throws SQLException {
        if (!this.isInit()) {
            return false;
        }
        if (lot==null) {
            return false;
        }
        Savepoint save = db.setSavepoint();     //Конец близок!
        Statement st=db.createStatement();

        //st.addBatch("INSERT INTO auctioneer SET "+lotToString(lot));  //НЕВЕРНО
        //ДОДЕЛАТЬ!!!
        //сохранение объекта продажи
        //сохранение списков покупаемых итемов и их параметров


        try {
            st.executeBatch();      //!
        } catch (SQLException e) {
            e.printStackTrace();
            db.rollback(save);                  //Конец.
            return false;
        }
        db.commit();
        return true;
    }

    /**
     * @return строка для итема в виде части sql, для сохранения
     */
    private String itemToString(AItemStack item) {
        //ДОДЕЛАТЬ!!!
    }

    /**
     * Serialization NBT
     * @return NBT объекта ItemStack item в виде byte[] для хранения
     * @throws IOException
     */
    private byte[] itemNBTToByte(AItemStack item) throws IOException {  //ПРОВЕРИТЬ!!!
        ByteArrayOutputStream bOutS = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(bOutS);
        out.writeObject(item.getNbt());
        out.close();
        byte[] bytes = bOutS.toByteArray();
        bOutS.close();
        return bytes;
    }

    /**
     * Deserialization NBT
     * @param bytes сериализованный NBT
     * @return  NBT
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private NBTTagCompound byteToItemNBT(byte[] bytes) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes));
        NBTTagCompound nbt = (NBTTagCompound) in.readObject();
        in.close();
        return nbt;
    }








    /**
     * Исключения работы с БД
     */
    public class DBException extends Exception{
        //ДОДЕЛАТЬ!!!                       вывод в лог
        /**
         * @param message Сообщение о ошибке
         */
        public DBException(String message){
            super(message);
        }

        /**
         * @return сообщение о ошибке
         */
        public String toString(){
            String s = getClass().getName();
            String message = getLocalizedMessage();
            return (message != null) ? message : s;
        }

        public void setLog(String message){

        }
    }
}
