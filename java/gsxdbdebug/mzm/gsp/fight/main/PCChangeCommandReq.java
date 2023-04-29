/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.confbean.SFightConsts;
/*    */ import mzm.gsp.server.main.AvailableStringArgs;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.FightCommand;
/*    */ import xbean.FightCommandInfo;
/*    */ import xbean.Pod;
/*    */ import xtable.Role2fightcmd;
/*    */ 
/*    */ public class PCChangeCommandReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int commandType;
/*    */   private int commandindex;
/*    */   private String commandname;
/*    */   
/*    */   public PCChangeCommandReq(long roleid, int commandtype, int commandindex, String commandname)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.commandindex = commandindex;
/* 24 */     this.commandname = commandname;
/* 25 */     this.commandType = commandtype;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 30 */     if ((this.commandname.isEmpty()) || (Math.ceil(mzm.gsp.util.CommonUtils.getUTF16Length(this.commandname) / 2.0D) > SFightConsts.getInstance().COMMAND_NAME_LENGTH) || (!AvailableStringArgs.getInstance().isStringUsable(this.commandname)))
/*    */     {
/*    */ 
/* 33 */       FightManager.sendNormalResult(this.roleid, 201, new String[0]);
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     if (mzm.gsp.sensitive.main.SensitiveInterface.isContentSensitive(this.commandname)) {
/* 38 */       FightManager.sendNormalResult(this.roleid, 202, new String[0]);
/* 39 */       return false;
/*    */     }
/* 41 */     FightCommand xfightCommand = Role2fightcmd.get(Long.valueOf(this.roleid));
/* 42 */     if (xfightCommand == null) {
/* 43 */       xfightCommand = Pod.newFightCommand();
/* 44 */       Role2fightcmd.insert(Long.valueOf(this.roleid), xfightCommand);
/*    */     }
/* 46 */     switch (this.commandType) {
/*    */     case 1: 
/* 48 */       int size = xfightCommand.getCommandenermylist().size();
/* 49 */       if (size < this.commandindex) {
/* 50 */         this.commandindex = size;
/*    */       }
/* 52 */       if (size < this.commandindex) {
/* 53 */         if (GameServer.logger().isDebugEnabled())
/* 54 */           GameServer.logger().debug("index超出了指挥命令的范围" + this.commandindex);
/* 55 */         return false; }
/* 56 */       if (size == this.commandindex) {
/* 57 */         FightCommandInfo fightCommandInfo = Pod.newFightCommandInfo();
/* 58 */         fightCommandInfo.setContent(this.commandname);
/* 59 */         xfightCommand.getCommandenermylist().add(fightCommandInfo);
/*    */       } else {
/* 61 */         ((FightCommandInfo)xfightCommand.getCommandenermylist().get(this.commandindex)).setContent(this.commandname);
/*    */       }
/*    */       
/* 64 */       break;
/*    */     case 0: 
/* 66 */       int friendSize = xfightCommand.getCommandfriendlist().size();
/* 67 */       if (friendSize < this.commandindex) {
/* 68 */         this.commandindex = friendSize;
/*    */       }
/* 70 */       if (friendSize < this.commandindex) {
/* 71 */         if (GameServer.logger().isDebugEnabled())
/* 72 */           GameServer.logger().debug("index超出了指挥命令的范围" + this.commandindex);
/* 73 */         return false; }
/* 74 */       if (friendSize == this.commandindex) {
/* 75 */         FightCommandInfo fightCommandInfo = Pod.newFightCommandInfo();
/* 76 */         fightCommandInfo.setContent(this.commandname);
/* 77 */         xfightCommand.getCommandfriendlist().add(fightCommandInfo);
/*    */       } else {
/* 79 */         ((FightCommandInfo)xfightCommand.getCommandfriendlist().get(this.commandindex)).setContent(this.commandname);
/*    */       }
/*    */       
/* 82 */       break;
/*    */     default: 
/* 84 */       if (GameServer.logger().isDebugEnabled())
/* 85 */         GameServer.logger().debug("不存在的指挥类型");
/* 86 */       return false;
/*    */     }
/* 88 */     mzm.gsp.fight.SCommandChangeRes commandChangeRes = new mzm.gsp.fight.SCommandChangeRes();
/* 89 */     commandChangeRes.commandindex = this.commandindex;
/* 90 */     commandChangeRes.commandtype = this.commandType;
/* 91 */     commandChangeRes.commandname = this.commandname;
/* 92 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleid, commandChangeRes);
/* 93 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PCChangeCommandReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */