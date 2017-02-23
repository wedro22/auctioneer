package ru.wedro22.auctioneer;

import net.minecraft.item.ItemStack;

/**
 * Используется ДЛЯ ОБЪЕКТОВ ПОКУПОК
 * Хранит информацию о игноре нбт, количество покупаемых предметов (для более быстрого отображения)
 */
public class APItemStack extends AItemStack {
    private boolean useNBT=false;   //Игнорирует/не игнорирует нбт
    private int amountPlus;         //Изменяемое количество покупаемых итемов (храним для быстрого отображения)

    /**
     * @param i количество итемов
     * @param useNBT true, если проверять NBT
     */
    APItemStack(ItemStack itemStack, int i, boolean useNBT) {
        super(itemStack, i);
        this.useNBT=useNBT;
    }

    public static APItemStack addAPItemStack(ItemStack itemStack, int i, boolean useNBT){
        return new APItemStack(itemStack,i,useNBT);
    }

    /**
     * @return используется ли нбт для проверки продажи
     */
    public static boolean isUseNBT(APItemStack apIS) {
        return apIS.useNBT;
    }
    /**
     * @return используется ли нбт для проверки продажи
     */
    public boolean isUseNBT() {
        return this.useNBT;
    }

    public static void setAmountPlus(APItemStack apIS, int i) {
        apIS.amountPlus=i;
    }
    public void setAmountPlus(int i){
        this.amountPlus=i;
    }

    public static int getAmountPlus(APItemStack apIS){
        return apIS.amountPlus;
    }
    public int getAmountPlus(){
        return this.amountPlus;
    }










    /**
     * Исключение неверных параметров конструктора
     *//*
    public class APItemStackException extends AItemStackException{
        private boolean useNBT;

        public APItemStackException(String message, ItemStack item, Integer amount, boolean useNBT) {
            super(message, item, amount);
            this.useNBT=useNBT;
        }

        public String toString(){
            return super.toString()+", useNBT:"+String.valueOf(this.useNBT);
        }
    }*/
}
