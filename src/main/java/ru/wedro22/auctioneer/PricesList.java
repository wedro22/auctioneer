package ru.wedro22.auctioneer;

import net.minecraft.item.ItemStack;

/**
 * Список вариантов продаж.
 * (ограничение количества потому что так надо вот)
 */
public class PricesList{

    //ДОДЕЛАТЬ!!! -приват переменных, множитель цены, загрузка констант из конфига

    public static final int PRICECOUNT = 5;     //лимит итемов в одной ставке
    public static final int PRICESCOUNT = 5;    //лимит различных ставок для лота
    public static final double COEFFICIENT = 1.25;  //множитель минимальной ставки
    public double factor=1;                      //текущий множитель цены (распространяется на все ставки)

    public PriceList[] pricesList = new PriceList[PRICESCOUNT];

    /**
     * @param prices - варианты продаж(с лимитом)
     * @return заполненный список вариантов продаж
     */
    public PricesList addPricesList(PriceList... prices){
        if (prices.length > PRICESCOUNT){
            System.out.println("ПЕРЕПОЛНЕНИЕ PRICESLIST!");
            return null;
        }
        int i=0;
        for (PriceList pl:prices) {//заполнение
            this.pricesList[i]=pl;
            i+=1;
        }
        return this;
    }






    public class PriceList{
        public AItemStack[] itemsStack = new AItemStack[PRICECOUNT];
        public boolean isBayout;

        /**
         * @param b - выкуп (без торга), если true
         * @param items - список итемов
         * @return заполненный итемами вариант продажи
         */
        public PriceList addItems(boolean b, AItemStack... items){
            if (items.length > PRICECOUNT){
                System.out.println("ПЕРЕПОЛНЕНИЕ PRICELIST!");
                return null;
            }
            int i=0;
            for (AItemStack is:items) {//заполнение
                this.itemsStack[i]=is;
                i+=1;
            }
            return this;
        }
    }
}