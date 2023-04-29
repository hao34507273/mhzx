/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.role.event.RoleLevelUpProcedure;
/*    */ import xbean.MatchActivityCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLevelUp
/*    */   extends RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     MatchActivityCfg matchData = TeamMatchMananger.getRoleActivity(((RoleLevelUpArg)this.arg).roleId, false);
/* 18 */     if (matchData == null)
/*    */     {
/* 20 */       return false;
/*    */     }
/* 22 */     switch (matchData.getMatchtype())
/*    */     {
/*    */     case 0: 
/* 25 */       return RoleQueueManager.onRoleLevelUp(((RoleLevelUpArg)this.arg).roleId, ((RoleLevelUpArg)this.arg).newLevel, ((RoleLevelUpArg)this.arg).oldLevel);
/*    */     case 1: 
/* 27 */       return TeamQueueManager.onRoleLevelUp(((RoleLevelUpArg)this.arg).roleId, ((RoleLevelUpArg)this.arg).newLevel, ((RoleLevelUpArg)this.arg).oldLevel);
/*    */     }
/* 29 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */