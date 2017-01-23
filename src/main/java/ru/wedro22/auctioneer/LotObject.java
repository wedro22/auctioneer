package ru.wedro22.auctioneer;


/**
 * Created by wedro on 22.01.2017.
 */
public class LotObject{
    private String name;
    private Object lot;
    private String nameT;


    /**
     * Use the verification before!
     * @param lot - object for auction
     */
    LotObject(Object lot){
        this.name = addName(lot);
        this.lot=lot;
        this.nameT=lot.getClass().getName();
    }

    public static boolean verification(Object lot) {
        return true;                                    //TEST!!!
    }

    private static String addName(Object lot) {
        return getIdString(lot);                        //VARIANT
    }
    public static String getIdString(Object lot) {
        return "testId"+String.valueOf(Math.random());  //TEST!!!
    }
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
        Class c = null;
        try {
            c = Class.forName(this.nameT);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}


//package net.minecraftforge.fml.common.registry.IForgeRegistryEntry.Impl;
//package net.minecraft.client.gui.MapItemRenderer;
//package net.minecraft.client.gui.GuiSlot;