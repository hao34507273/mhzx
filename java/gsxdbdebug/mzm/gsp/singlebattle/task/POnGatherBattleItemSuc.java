/*    */ package mzm.gsp.singlebattle.task;
/*    */ 
/*    */ import mzm.gsp.singlebattle.event.GatherBattleItemSucProcedure;
/*    */ import mzm.gsp.singlebattle.gather.EventArg_GatherSuc;
/*    */ import xtable.Role2battletask;
/*    */ 
/*    */ public class POnGatherBattleItemSuc extends GatherBattleItemSucProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     long roleId = ((EventArg_GatherSuc)this.arg).getRoleId();
/*    */     
/* 13 */     xbean.RoleBattleTaskData xRoleBattleTaskData = Role2battletask.get(Long.valueOf(roleId));
/* 14 */     if (xRoleBattleTaskData == null)
/*    */     {
/* 16 */       return false;
/*    */     }
/* 18 */     BattleTaskManager.updateTaskParameter(roleId, ((EventArg_GatherSuc)this.arg).getAddSource(), xRoleBattleTaskData, 3);
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\task\POnGatherBattleItemSuc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */