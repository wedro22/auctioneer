package ru.wedro22.auctioneer;

import net.minecraft.item.ItemStack;

/**
 * ItemStack, не ограниченный стаком
 */
public class AItemStack {
    public ItemStack item;
    public Integer amount;

    //ДОДЕЛАТЬ!!! - возможный случай переполнения int, приват переменных

    /**
     *
     * @param itemStack
     * @param i количество итемов
     */
    AItemStack(ItemStack itemStack, int i){
        this.item=itemStack;
        this.amount=i;
    }

    /**
     * @return количество ПОЛНЫХ стаков
     */
    public int getFullStacks(){
        return this.amount/item.getMaxStackSize();
    }

    /**
     * @return количество итемов в ОСТАВШЕМСЯ стаке
     */
    public int getNotFullStack(){
        return this.amount-(this.getFullStacks()*item.getMaxStackSize());
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
}