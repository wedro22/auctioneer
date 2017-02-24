package ru.wedro22.auctioneer;


import com.sun.istack.internal.NotNull;
import net.minecraft.entity.player.EntityPlayerMP;
import ru.wedro22.auctioneer.db.DB;
import ru.wedro22.auctioneer.util.ADate;


import javax.annotation.Nonnull;
import java.util.Date;


/**
 * Основной класс для создания и загрузки лотов. Хранит объект продажи, список покупок, продавца, даты.
 */
public class LotObject{
    private AItemStack lot;

    private EntityPlayerMP seller;      //продавец товара
    private Date dateStart;     //дата старта аукциона
    private Date dateEnd;       //дата конца аукциона
    private Date dateLong;      //продолжительность аукциона (от старта до конца)
    private PricesList pricesList;//список вариантов продаж


    /**
     * Конструктор, все поля класса обязательны к заполнению.
     * @param item  продаваемый предмет, количество
     * @param prices    список покупок
     * @param player    продавец
     * @param dateLong  продолжительность аукциона
     */
    public LotObject(@Nonnull AItemStack item, @Nonnull PricesList prices, @Nonnull EntityPlayerMP player,
                     @Nonnull Date dateLong){
        this.lot=item;
        this.seller=player;
        this.pricesList=prices;
        this.dateStart=ADate.currentDate();
        this.dateLong=dateLong;
        this.dateEnd=ADate.sumDate(this.dateStart, this.dateLong);
    }

    /**
     * Выложить лот на аукцион
     * @return true, если лот добавлен в БД
     */
    public static boolean addLotToBD(@Nonnull LotObject lotObject) {
        if (DB.isInit()==false) {
            if (DB.init(DB.URL)==false) {
                // @todo
                return false;
            }
        }
        if (DB.addLot(lotObject)==false) {
            // @todo
            DB.close();
            return false;
        }
        // @todo
        DB.close();
        return true;
    }
    /**
     * Выложить лот на аукцион
     * @return true, если лот добавлен в БД
     */
    public boolean addLotToBD(){
        return addLotToBD(this);
    }

    /**
     * @param i поле индекс в БД в таблице auctioneer
     * @return  полностью загруженный лот
     */
    public LotObject getLotFromBD(int i) {
        return null; // @todo
    }




}
