/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.confbean.SFightConsts;
/*    */ import mzm.gsp.server.main.AvailableStringArgs;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.FightCommand;
/*    */ import xbean.FightCommandInfo;
/*    */ import xbean.Pod;
/*    */ 
/*    */ public class PCAddCommand extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private int commandType;
/*    */   private String content;
/*    */   private long roleid;
/*    */   
/*    */   public PCAddCommand(long roleid, int commandType, String content)
/*    */   {
/* 19 */     this.commandType = commandType;
/* 20 */     this.content = content;
/* 21 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 26 */     if ((this.content.isEmpty()) || (Math.ceil(mzm.gsp.util.CommonUtils.getUTF16Length(this.content) / 2.0D) > SFightConsts.getInstance().COMMAND_NAME_LENGTH) || (!AvailableStringArgs.getInstance().isStringUsable(this.content)))
/*    */     {
/*    */ 
/* 29 */       FightManager.sendNormalResult(this.roleid, 201, new String[0]);
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     if (mzm.gsp.sensitive.main.SensitiveInterface.isContentSensitive(this.content)) {
/* 34 */       FightManager.sendNormalResult(this.roleid, 202, new String[0]);
/* 35 */       return false;
/*    */     }
/* 37 */     FightCommand xFightCommand = xtable.Role2fightcmd.get(Long.valueOf(this.roleid));
/* 38 */     if (xFightCommand == null) {
/* 39 */       xFightCommand = Pod.newFightCommand();
/* 40 */       xtable.Role2fightcmd.insert(Long.valueOf(this.roleid), xFightCommand);
/*    */     }
/* 42 */     switch (this.commandType) {
/*    */     case 1: 
/* 44 */       FightCommandInfo fightCommandInfo = Pod.newFightCommandInfo();
/* 45 */       fightCommandInfo.setContent(this.content);
/* 46 */       xFightCommand.getCommandenermylist().add(fightCommandInfo);
/* 47 */       break;
/*    */     case 0: 
/* 49 */       FightCommandInfo fightFriendCommandInfo = Pod.newFightCommandInfo();
/* 50 */       fightFriendCommandInfo.setContent(this.content);
/* 51 */       xFightCommand.getCommandfriendlist().add(fightFriendCommandInfo);
/* 52 */       break;
/*    */     
/*    */     default: 
/* 55 */       if (GameServer.logger().isDebugEnabled())
/* 56 */         GameServer.logger().debug("没有改指挥类型");
/* 57 */       return false;
/*    */     }
/*    */     
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PCAddCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */