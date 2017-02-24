package ru.wedro22.auctioneer.util;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wedro on 18.02.2017.
 */
public class ADate {

    /**
     * @return текущее время
     */
    public static Date currentDate() {
        return new Date();
    }


    /**
     * https://msdn.microsoft.com/ru-ru/library/ms186724.aspx
     * smalldatetime	ГГГГ-ММ-ДД чч:мм:сс
     * обращение: Формат.format(date)
     * @return формат времени для работы с типом smalldatetime в БД
     */
    public static SimpleDateFormat getSQLDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @return результат сложения Date
     */
    public static Date sumDate(Date dt1, Date dt2) {
        long sum=dt1.getTime()+dt2.getTime();
        Date dt=new Date();
        dt.setTime(sum);
        return dt;
    }

}
