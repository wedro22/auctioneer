package ru.wedro22.auctioneer;


import com.sun.istack.internal.NotNull;
import net.minecraft.entity.player.EntityPlayerMP;
import ru.wedro22.auctioneer.util.ADate;


import java.util.Date;


public class LotObject{
    private AItemStack lot;

    private EntityPlayerMP seller;      //продавец товара
    private Date dateStart;     //дата старта аукциона
    private Date dateEnd;       //дата конца аукциона
    private Date dateLong;      //продолжительность аукциона (от старта до конца)
    private PricesList pricesList;//список вариантов продаж




    public LotObject(@NotNull AItemStack item, @NotNull PricesList prices, @NotNull EntityPlayerMP player,
                     @NotNull Date dateLong){
        this.lot=item;
        this.seller=player;
        this.pricesList=prices;
        this.dateStart=ADate.currentDate();
        this.dateLong=dateLong;
        this.dateEnd=ADate.sumDate(this.dateStart, this.dateLong);
    }

    public boolean addLotToBD(@NotNull LotObject lotObject) {
        return false; // @todo
    }

    public LotObject getLotFromBD(/*todo*/) {
        return null; // @todo
    }




}
