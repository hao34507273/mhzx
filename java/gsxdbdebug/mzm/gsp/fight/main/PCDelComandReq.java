/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.SynCommandInfos;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.FightCommand;
/*    */ 
/*    */ public class PCDelComandReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int commandtype;
/*    */   private int commandindex;
/*    */   
/*    */   public PCDelComandReq(long roleid, int commandtype, int commandindex)
/*    */   {
/* 16 */     this.roleid = roleid;
/* 17 */     this.commandtype = commandtype;
/* 18 */     this.commandindex = commandindex;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     FightCommand xfightCommand = xtable.Role2fightcmd.get(Long.valueOf(this.roleid));
/* 29 */     if (xfightCommand == null) {
/* 30 */       return false;
/*    */     }
/* 32 */     switch (this.commandtype) {
/*    */     case 1: 
/* 34 */       int size = xfightCommand.getCommandenermylist().size();
/* 35 */       if (size <= this.commandindex) {
/* 36 */         if (GameServer.logger().isDebugEnabled())
/* 37 */           GameServer.logger().debug("index超出了指挥命令的范围" + this.commandindex);
/* 38 */         return false;
/*    */       }
/* 40 */       xfightCommand.getCommandenermylist().remove(this.commandindex);
/* 41 */       break;
/*    */     case 0: 
/* 43 */       int friendSize = xfightCommand.getCommandfriendlist().size();
/* 44 */       if (friendSize <= this.commandindex) {
/* 45 */         if (GameServer.logger().isDebugEnabled())
/* 46 */           GameServer.logger().debug("index超出了指挥命令的范围" + this.commandindex);
/* 47 */         return false;
/*    */       }
/* 49 */       xfightCommand.getCommandfriendlist().remove(this.commandindex);
/* 50 */       break;
/*    */     default: 
/* 52 */       if (GameServer.logger().isDebugEnabled())
/* 53 */         GameServer.logger().debug("不存在的指挥类型");
/* 54 */       return false;
/*    */     }
/*    */     
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 61 */     SynCommandInfos synCommandInfos = new SynCommandInfos();
/* 62 */     for (xbean.FightCommandInfo commandInfo : xfightCommand.getCommandenermylist()) {
/* 63 */       synCommandInfos.commandenermyinfos.add(commandInfo.getContent());
/*    */     }
/* 65 */     for (xbean.FightCommandInfo commandInfo : xfightCommand.getCommandfriendlist()) {
/* 66 */       synCommandInfos.commandfriendinfos.add(commandInfo.getContent());
/*    */     }
/* 68 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleid, synCommandInfos);
/*    */     
/* 70 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PCDelComandReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */