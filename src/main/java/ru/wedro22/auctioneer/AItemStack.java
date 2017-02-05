package ru.wedro22.auctioneer;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * ItemStack, не ограниченный стаком, работа со стаками.
 * Используется ДЛЯ ОБЪЕКТА ПРОДАЖИ
 * Также здесь находятся методы получения id, meta, nbt,
 */
public class AItemStack {
    private ItemStack item;
    private int amount; //количество продаваемого/СТАРТОВОЕ количество покупаемых объектов

    //ДОДЕЛАТЬ!!! - возможный случай переполнения int

    /**
     * @param i количество итемов
     */
    AItemStack(ItemStack itemStack, int i){
        this.item=itemStack;
        this.amount=i;
    }

    public AItemStack addAItemStack(ItemStack itemStack, int i){
        return new AItemStack(itemStack,i);
    }

    /**
     * @return количество ПОЛНЫХ стаков
     */
    public int getFullStacks(){
        return this.amount/this.item.getMaxStackSize();
    }

    /**
     * @return количество итемов в ОСТАВШЕМСЯ стаке
     */
    public int getNotFullStack(){
        return this.amount-(this.getFullStacks()*this.item.getMaxStackSize());
    }

    /**
     * @return максимальный размер стака
     */
    public int getMaxStackSize(){
        return this.item.getMaxStackSize();
    }

    /**
     * @return общее количество итемов
     */
    public int getAmount(){
        return this.amount;
    }

    public ItemStack getItemStack(){
        return this.item;
    }


    public static String getName(ItemStack iS) {
        return iS.getDisplayName();
    }
    public static String getName(AItemStack aIS) {
        return getName(aIS.getItemStack());
    }
    public String getName() {
        return getName(this.getItemStack());
    }

    public static int getId(ItemStack iS) {
        return iS.getItem().REGISTRY.getIDForObject(iS.getItem());
    }
    public static int getId(AItemStack aIS) {
        return getId(aIS.getItemStack());
    }
    public int getId(){
        return getId(this.getItemStack());
    }

    public static int getMeta(ItemStack iS){
        return iS.getMetadata();
    }
    public static int getMeta(AItemStack aIS) {
        return getMeta(aIS.getItemStack());
    }
    public int getMeta(){
        return getMeta(this.getItemStack());
    }

    public static NBTTagCompound getNBT(ItemStack iS) {
        return iS.getTagCompound();
    }
    public static NBTTagCompound getNBT(AItemStack aIS) {
        return getNBT(aIS.getItemStack());
    }
    public NBTTagCompound getNbt(){
        return getNBT(this.getItemStack());
    }




    /**
     * Исключение неверных параметров конструктора
     *//*
    public class AItemStackException extends Exception{
        private ItemStack item;
        private int amount;

        public AItemStackException(String message, ItemStack item, Integer amount){
            super(message);
            this.item=item;
            this.amount=amount;
        }

        public String toString(){
            String s = getClass().getName();
            String message = getLocalizedMessage();
            return (message != null) ? (message + "; Item:"+item.getDisplayName()+", Количество:"+
                    String.valueOf(amount))
                    : s;
        }
    }*/
}