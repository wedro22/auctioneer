package ru.wedro22.auctioneer;


/**
 * Массив вариантов продаж
 * Массив вариантов продаж(лимит:PRICESCOUNT),
 * имеет информацию о изменении цен при ставках
 * Варианты продаж хранят массив AItemStack(лимит:PRICECOUNT),
 * имеют информацию о выкупе, росте цены для выкупа
 *
 */
public class PricesList{

    //ДОДЕЛАТЬ!!! -множитель цены, загрузка констант из конфига

    public static final int PRICECOUNT = 5;     //лимит итемов в одной ставке
    public static final int PRICESCOUNT = 5;    //лимит различных ставок для лота
    public static final double COEFFICIENT = 0.25;  //ступень минимальной ставки
    private double factor=1;                      //текущий множитель цен (распространяется на все ставки)

    public PriceList[] pricesList = new PriceList[PRICESCOUNT];

    /**
     * Массив вариантов продаж
     * @param prices варианты продаж (лимит - PRICESCOUNT)
     * @throws PricesException
     */
    PricesList(PriceList... prices) throws PricesException {
        if (prices.length > PRICESCOUNT)
            throw new PricesException("Array overflow in PricesList constructor", PRICESCOUNT, prices.length);
        int i=0;
        for (PriceList pl:prices) {//заполнение
            this.pricesList[i]=pl;
            i+=1;
        }
    }

    /**
     * @param prices - варианты продаж (лимит - PRICESCOUNT)
     * @return массив вариантов продаж (если не переполнение prices, иначе - null)
     */
    public PricesList addPricesList(PriceList... prices){
        try {
            return new PricesList(prices);
        } catch (PricesException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        return null;
    }

    /**
     * @return текущий множитель цен
     */
    public double getFactor(){
        return factor;
    }

    /**
     * @return следующий минимальный множитель цен
     */
    public double getNextMinFactor(){
        return factor+COEFFICIENT;
    }

    /**
     * @param n ступеней минимальной ставки
     * @return множитель цен с пропуском n ступеней (может быть полезно для скролл-бара -
     * например, получения скролла на 100 ступеней)
     */
    public double getNFactor(int n){
        return factor+COEFFICIENT*n;
    }
    /**                                                     //ПЕРЕДЕЛАТЬ!!!
     * @param f устанавливает новый текущий множитель цен
     */
    public void setFactor(double f){
        factor = f;
    }




    /**
     * Вариант продажи (один из PRICESCOUNT)
     */
    public class PriceList{
        private AItemStack[] itemsStack = new AItemStack[PRICECOUNT];
        private boolean isBay;  //выкуп
        private boolean isGai;  //рост цен (только для выкупа)

        /**
         * Вариант продажи (один из PRICESCOUNT)
         * @param isBayout - выкуп (без торга), если true
         * @param isGain - для "выкупа", не для ставок. Если true, цена на выкуп растет со ставками
         * @param items - список итемов (лимит - PRICECOUNT)
         * @throws PricesException при переполнении items
         */
        PriceList(boolean isBayout, boolean isGain, AItemStack... items) throws PricesException{
            if (items.length > PRICECOUNT)
                throw new PricesException("Array overflow in PriceList constructor", PRICECOUNT, items.length);
            int i=0;
            for (AItemStack is:items) {//заполнение
                this.itemsStack[i]=is;
                i+=1;
            }
            this.isBay=isBayout;
            if (isBayout==true)
                this.isGai = isGain;
            else
                this.isGai = true;
        }

        /**
         * @param isBayout - выкуп (без торга), если true
         * @param isGain - для "выкупа", не для ставок. Если true, цена на выкуп растет со ставками
         * @param items - список итемов (лимит - PRICECOUNT)
         * @return заполненный итемами вариант продажи (если не переполнение items, иначе - null)
         */
        public PriceList addPriceList(boolean isBayout, boolean isGain, AItemStack... items){
            try {
                return new PriceList(isBayout, isGain, items);
            } catch (PricesException e) {
                e.printStackTrace();
                System.out.println(e.toString());
            }
            return null;
        }

        public AItemStack[] getItems(){
            return this.itemsStack;
        }

        public boolean isBayout(){
            return this.isBay;
        }

        public boolean isGain(){
            return this.isGai;
        }

    }

    /**
     * Ошибка переполнения массивов
     */
    public class PricesException extends Exception{
        private int numberNorm;
        private int numberReal;

        /**
         * @param message Сообщение о переполнении массива
         * @param numNorm Размер массива
         * @param numReal Размер переполнения
         */
        public PricesException(String message, int numNorm, int numReal){
            super(message);
            this.numberNorm=numNorm;
            this.numberReal=numReal;
        }

        /**
         * @return сообщение о переполнении массива, размер массива, размер переполнения
         */
        public String toString(){
            String s = getClass().getName();
            String message = getLocalizedMessage();
            return (message != null) ? (message + "; numberNorm:"+String.valueOf(numberNorm)+", numberReal:"+
                    String.valueOf(numberReal))
                    : s;
        }
    }
}