/*    */ package mzm.gsp.singlebattle.task;
/*    */ 
/*    */ import xtable.Role2battletask;
/*    */ 
/*    */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/* 11 */     xbean.RoleBattleTaskData xRoleBattleTaskData = Role2battletask.get(Long.valueOf(roleId));
/* 12 */     if (xRoleBattleTaskData == null)
/*    */     {
/* 14 */       return false;
/*    */     }
/* 16 */     BattleTaskManager.synRoleTaskDatas(roleId, xRoleBattleTaskData);
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\task\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */