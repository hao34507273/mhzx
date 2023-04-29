/*    */ package mzm.gsp.grow.daytarget;
/*    */ 
/*    */ import mzm.gsp.grow.hand.TargetHandle;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class DayTargetHandle
/*    */   implements TargetHandle
/*    */ {
/*    */   static volatile DayTargetHandle instance;
/*    */   
/*    */   static DayTargetHandle getInstance()
/*    */   {
/* 13 */     if (instance == null)
/*    */     {
/* 15 */       synchronized (DayTargetHandle.class)
/*    */       {
/* 17 */         if (instance == null)
/*    */         {
/* 19 */           instance = new DayTargetHandle();
/*    */         }
/*    */       }
/*    */     }
/* 23 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isGoalValid(long roleId, int goalId)
/*    */   {
/* 29 */     RoleDayInfo roleDayInfo = new RoleDayInfo(roleId, true);
/* 30 */     return DayTargetManager.validTarget(roleDayInfo, goalId);
/*    */   }
/*    */   
/*    */ 
/*    */   public void setParam(long roleId, int goalId, int param)
/*    */   {
/* 36 */     RoleDayInfo roleDayInfo = new RoleDayInfo(roleId, true);
/* 37 */     DayTargetManager.setParam(roleDayInfo, goalId, param);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getParam(long roleId, int goalId)
/*    */   {
/* 43 */     RoleDayInfo roleDayInfo = new RoleDayInfo(roleId, true);
/* 44 */     return DayTargetManager.getTargetParam(roleDayInfo, goalId);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean onCanFinishTarget(long roleId, int goalId)
/*    */   {
/* 50 */     LogicProcedure p = new PFinishDayTarget(roleId, goalId);
/* 51 */     if (!p.call())
/*    */     {
/* 53 */       return false;
/*    */     }
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\daytarget\DayTargetHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */