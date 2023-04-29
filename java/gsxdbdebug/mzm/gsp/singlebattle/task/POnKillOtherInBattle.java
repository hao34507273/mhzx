/*    */ package mzm.gsp.singlebattle.task;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.singlebattle.event.EventArg_KillOther;
/*    */ import xtable.Role2battletask;
/*    */ 
/*    */ public class POnKillOtherInBattle extends mzm.gsp.singlebattle.event.KillOtherInBattleProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     long roleId = ((EventArg_KillOther)this.arg).getRoleId();
/*    */     
/* 13 */     xbean.RoleBattleTaskData xRoleBattleTaskData = Role2battletask.get(Long.valueOf(roleId));
/* 14 */     if (xRoleBattleTaskData == null)
/*    */     {
/* 16 */       return false;
/*    */     }
/* 18 */     BattleTaskManager.updateTaskParameter(roleId, ((EventArg_KillOther)this.arg).getOtherIds().size(), xRoleBattleTaskData, 2);
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\task\POnKillOtherInBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */