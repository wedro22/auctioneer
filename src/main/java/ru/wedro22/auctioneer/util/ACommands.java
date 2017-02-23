package ru.wedro22.auctioneer.util;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import ru.wedro22.auctioneer.AItemStack;
import ru.wedro22.auctioneer.LotObject;

/**
 * new commands (chat)
 */
public class ACommands{

    public static CommandBase[] commands=
    {
        /*new Test1(),
        new Test2(),
        new Test3(),*/
        //new Hs(),
        //new Hs1()
        new tst()
    };

    /*private static class Test1 extends CommandBase{

        @Override
        public String getCommandName() {
            return "test1";
        }

        @Override
        public String getCommandUsage(ICommandSender sender) {
            return "test1";
        }

        @Override
        public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
            EntityPlayer entityplayer = getCommandSenderAsPlayer(sender);
            AChat.chatServToPlayer(entityplayer, "TESTCOMMAND 1");
        }
    }

    private static class Test2 extends CommandBase{

        @Override
        public String getCommandName() {
            return "test2";
        }

        @Override
        public String getCommandUsage(ICommandSender sender) {
            return "test2";
        }

        @Override
        public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
            EntityPlayer entityplayer = getCommandSenderAsPlayer(sender);
            Style style = new Style();
            style.setColor(TextFormatting.RED);
            AChat.chatServToPlayer(entityplayer, "TESTCOMMAND 2", style);
        }
    }

    private static class Test3 extends CommandBase{

        @Override
        public String getCommandName() {
            return "test3";
        }

        @Override
        public String getCommandUsage(ICommandSender sender) {
            return "test3 <string>";
        }

        @Override
        public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
            EntityPlayer entityplayer = getCommandSenderAsPlayer(sender);
            Style style = new Style();
            style.setColor(TextFormatting.RED);

            String message = "test3";
            if (args.length!=0){
                for (String str:args) {
                    message=message+" "+str;
                }
            }

            AChat.chatServToPlayer(entityplayer, message, style);
        }
    }*/
    /*
    private static class Hs extends CommandBase{

        @Override
        public String getCommandName() {
            return "hs";
        }

        @Override
        public String getCommandUsage(ICommandSender sender) {
            return "/hs";
        }

        @Override
        public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
            EntityPlayer entityplayer = getCommandSenderAsPlayer(sender);
            ItemStack testItemStack = entityplayer.getHeldItem(entityplayer.getActiveHand());
            if (testItemStack==null) AChat.chatServToPlayer((EntityPlayerMP)entityplayer, "ItemStack=null");
            else {
                LotObject lot = new LotObject();
                lot.addLotFromGame(testItemStack);

                AChat.chatServToPlayer((EntityPlayerMP) entityplayer, String.valueOf(lot.getId()) + ":"
                        + String.valueOf(lot.getMeta()) + ", " + lot.getName());
                if (lot.getNbt() != null)
                    AChat.chatServToPlayer((EntityPlayerMP) entityplayer, "Nbt=" + lot.getNbt().toString());
                else
                    AChat.chatServToPlayer((EntityPlayerMP) entityplayer, "Nbt=null");
            }
        }
    }
    private static class Hs1 extends CommandBase{

        @Override
        public String getCommandName() {
            return "hs1";
        }

        @Override
        public String getCommandUsage(ICommandSender sender) {
            return "/hs1";
        }

        @Override
        public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
            EntityPlayer entityplayer = getCommandSenderAsPlayer(sender);
            ItemStack testItemStack = entityplayer.inventory.getStackInSlot(17);
            if (testItemStack==null) AChat.chatServToPlayer((EntityPlayerMP)entityplayer, "ItemStack=null");
            else {
                LotObject lot = new LotObject();
                lot.addLotFromGame(testItemStack);

                AChat.chatServToPlayer((EntityPlayerMP) entityplayer, String.valueOf(lot.getId()) + ":"
                        + String.valueOf(lot.getMeta()) + ", " + lot.getName());
                if (lot.getNbt() != null)
                    AChat.chatServToPlayer((EntityPlayerMP) entityplayer, "Nbt=" + lot.getNbt().toString());
                else
                    AChat.chatServToPlayer((EntityPlayerMP) entityplayer, "Nbt=null");
            }
        }
    }*/

    private static class tst extends CommandBase{

        @Override
        public String getCommandName() {
            return "tst";
        }

        @Override
        public String getCommandUsage(ICommandSender sender) {
            return "/tst";
        }

        @Override
        public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
            EntityPlayer entityplayer = getCommandSenderAsPlayer(sender);
            ItemStack testItemStack = entityplayer.getHeldItem(entityplayer.getActiveHand());
            AItemStack tst = AItemStack.addAItemStack(testItemStack, 1);
            if (tst==null) AChat.chatServToPlayer((EntityPlayerMP)entityplayer, "AItemStack=null");
            else {

                AChat.chatServToPlayer((EntityPlayerMP) entityplayer, tst.getId() + " ; "
                        + String.valueOf(tst.getMeta()) + " , " + tst.getName());
                if (tst.getNbt() != null)
                    AChat.chatServToPlayer((EntityPlayerMP) entityplayer, "Nbt=" + tst.getNbt().toString());
                else
                    AChat.chatServToPlayer((EntityPlayerMP) entityplayer, "Nbt=null");
            }
        }
    }
}
