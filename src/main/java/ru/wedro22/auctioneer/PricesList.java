package ru.wedro22.auctioneer;


/**
 * Массив вариантов продаж
 * Массив вариантов продаж(лимит:PRICESCOUNT),
 * имеет информацию о изменении цен при ставках
 * Варианты продаж хранят массив APItemStack(лимит:PRICECOUNT),
 * имеют информацию о выкупе, росте цены для выкупа.
 * Рост цены идет скачками, при ручном вводе цены идет округление.
 * Округление делается до ближайшего целого числа, если *.5 - то до большего.
 */
public class PricesList{

    //ДОДЕЛАТЬ!!! загрузка констант из конфига, игнор/не игнор нбт, проверка подходит ли итем для покупки

    public static final int PRICECOUNT = 5;     //лимит итемов в одной ставке
    public static final int PRICESCOUNT = 5;    //лимит различных ставок для лота
    public static final double COEFFICIENT = 0.25;  //ступень минимальной ставки
    private double factor=1;                      //текущий множитель цен (распространяется на все ставки)

    public PriceList[] pricesList = new PriceList[PRICESCOUNT];

    /**
     * Массив вариантов продаж
     * @param prices варианты продаж (лимит - PRICESCOUNT)
     * @throws PricesException - исключение при переполнении массивов
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

    /**
     * @param d устанавливает новый текущий множитель цен
     */
    public void setFactor(double d){
        factor = d;
    }

    /**
     * @param d устанавливает новый текущий множитель цен С ОКРУГЛЕНИЕМ
     */
    public void setFactorRound(double d){
        factor = round(d);
    }

    /**
     * @param d округляемое число
     * @return число, кратное ступени минимальной ставки, если=0 - вернет ступень
     */
    public static double round(double d) {  //НЕ ЛУЧШИЙ СПОСОБ, ПОТОМ ПЕРЕДЕЛАТЬ В ПОБИТОВЫЕ
        double dd = (Math.round(d/COEFFICIENT))*COEFFICIENT;
        return (dd!=0) ? dd : COEFFICIENT;
    }

    /**
     * @return количество итемов, хранящееся в AItemStack
     */
    public static int getItemAmount(AItemStack aIS) {
        return aIS.getAmount();
    }

    /**
     * @param factor - текущий множитель цены этой продажи
     * @return округленное количество итемов с учетом множителя цены
     */
    public static int getItemAmountRound(AItemStack aIS, double factor) {
        return (int) Math.round(getItemAmount(aIS)*factor);
    }






    /**
     * Вариант продажи (один из PRICESCOUNT)
     */
    public class PriceList{
        private APItemStack[] itemsStack = new APItemStack[PRICECOUNT];
        private boolean isBay;  //выкуп
        private boolean isGai;  //рост цен (только для выкупа)

        /**
         * Вариант продажи (один из PRICESCOUNT)
         * @param isBayout - выкуп (без торга), если true
         * @param isGain - для "выкупа", не для ставок. Если true, цена на выкуп растет со ставками
         * @param items - список итемов (лимит - PRICECOUNT)
         * @throws PricesException при переполнении items
         */
        PriceList(boolean isBayout, boolean isGain, APItemStack... items) throws PricesException{
            if (items.length > PRICECOUNT)
                throw new PricesException("Array overflow in PriceList constructor", PRICECOUNT, items.length);
            int i=0;
            for (APItemStack is:items) {//заполнение
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
        public PriceList addPriceList(boolean isBayout, boolean isGain, APItemStack... items){
            try {
                return new PriceList(isBayout, isGain, items);
            } catch (PricesException e) {
                e.printStackTrace();
                System.out.println(e.toString());
            }
            return null;
        }


        /**
         * @return массив предметов для этого варианта продажи.
         */
        public APItemStack[] getItems(){
            return this.itemsStack;
        }

        /**
         * @return true, если выкуп
         */
        public boolean isBayout(){
            return this.isBay;
        }

        /**
         * @return true, если для ВЫКУПА установлен рост цен от ставок
         */
        public boolean isGain(){
            return this.isGai;
        }

    }

    /**
     * Исключение переполнения массивов
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