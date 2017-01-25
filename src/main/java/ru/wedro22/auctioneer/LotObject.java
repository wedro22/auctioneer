package ru.wedro22.auctioneer;


import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import ru.wedro22.auctioneer.util.AChat;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by wedro on 22.01.2017.
 */
public class LotObject{
    private ItemStack lot;

    private EntityPlayerMP seller;      //продавец товара
    private Date dateStart;     //дата старта аукциона
    private Date dateEnd;       //дата конца аукциона
    private Date dateServSaved; //дата сохранения сервера
    private PricesList pricesList;//список вариантов продаж

    public static final int PRICECOUNT = 5;    //лимит итемов в одной ставке
    public static final int PRICESCOUNT = 5;   //лимит различных ставок для лота


    /**
     * Список вариантов продаж.
     * (ограничение количества потому что так надо вот)
     */
    public class PricesList{
        public PriceList[] pricesList = new PriceList[PRICESCOUNT];

        /**
         * @param prices - варианты продаж(с лимитом)
         * @return заполненный список вариантов продаж
         */
        public PricesList addPricesList(PriceList... prices){
            if (prices.length > PRICESCOUNT){
                //ДОПИСАТЬ СООБЩЕНИЕ О ОШИБКЕ ПЕРЕПОЛНЕНИЯ
                return null;
            }
            int i=0;
            for (PriceList pl:prices) {//заполнение
                this.pricesList[i]=pl;
                i+=1;
            }
            return this;
        }

    }
    public class PriceList{
        public ItemStack[] itemsStack = new ItemStack[PRICECOUNT];

        /**
         * @param items - список итемов
         * @return заполненный итемами вариант продажи
         */
        public PriceList addItems(ItemStack... items){
            if (items.length > PRICECOUNT){
                //ДОПИСАТЬ СООБЩЕНИЕ О ОШИБКЕ ПЕРЕПОЛНЕНИЯ
                return null;
            }
            int i=0;
            for (ItemStack is:items) {//заполнение
                this.itemsStack[i]=is;
                i+=1;
            }
            return this;
        }
    }


    /**
     * Use the verification before!
     * @param item - object for auction
     */
    public void addLotFromGame(ItemStack item               ){//доделать
        this.lot=item;
    }

    public LotObject addLotFromBD(){
        return null;            //not yet ready!!!
    }

    public static boolean verification(ItemStack lot) {
        return true;            //not yet ready!!!
    }

    public String getName() {
        return lot.getDisplayName();
    }
    public int getId(){
        return lot.getItemDamage();
    }
    public int getMeta(){
        return lot.getMetadata();
    }
    public int getAmount(){
        return lot.stackSize;
    }
    public NBTTagCompound getNbt(){
        return lot.getTagCompound();
    }




}

    /*UNUSED
    public Class getTClass(){
        Class c = null;
        try {
            c = Class.forName(this.nameT);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return c;
    }
    public Object getTInstance(){
        Class c = getTClass();
        if (c!=null) {
            try {
                return c.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    */

//package net.minecraftforge.fml.common.registry.IForgeRegistryEntry.Impl;
//package net.minecraft.client.gui.MapItemRenderer;
//package net.minecraft.client.gui.GuiSlot;