package ru.wedro22.auctioneer.util;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;

/**
 * new commands (chat)
 */
public class ACommands{

    public static CommandBase[] commands=
    {
        new Test1(),
        new Test2(),
        new Test3(),
        new Cp()
    };

    private static class Test1 extends CommandBase{

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
    }
    private static class Cp extends CommandBase{

        @Override
        public String getCommandName() {
            return "cp";
        }

        @Override
        public String getCommandUsage(ICommandSender sender) {
            return "cp";
        }

        @Override
        public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        }
    }
}
