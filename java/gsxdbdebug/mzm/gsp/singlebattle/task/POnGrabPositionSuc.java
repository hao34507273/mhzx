/*    */ package mzm.gsp.singlebattle.task;
/*    */ 
/*    */ import mzm.gsp.singlebattle.event.GrabPositionSucProcedure;
/*    */ import mzm.gsp.singlebattle.grab.EventArg_GrabPositionSuc;
/*    */ import xtable.Role2battletask;
/*    */ 
/*    */ public class POnGrabPositionSuc extends GrabPositionSucProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     long roleId = ((EventArg_GrabPositionSuc)this.arg).getRoleId();
/*    */     
/* 13 */     xbean.RoleBattleTaskData xRoleBattleTaskData = Role2battletask.get(Long.valueOf(roleId));
/* 14 */     if (xRoleBattleTaskData == null)
/*    */     {
/* 16 */       return false;
/*    */     }
/* 18 */     BattleTaskManager.updateTaskParameter(roleId, 1, xRoleBattleTaskData, 1);
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\task\POnGrabPositionSuc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */