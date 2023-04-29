/*    */ package mzm.gsp.tmpactivity.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     if (needRmGraph())
/*    */     {
/* 22 */       TaskInterface.closeActivityGraphWithoutEvent(((Long)this.arg).longValue(), TmpActivityManager.getGraphId());
/*    */     }
/* 24 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   boolean needRmGraph()
/*    */   {
/* 36 */     if (ActivityInterface.isActivityOpen(TmpActivityManager.getActivityId()))
/*    */     {
/* 38 */       if ((!OpenInterface.getOpenStatus(52)) || (OpenInterface.isBanPlay(((Long)this.arg).longValue(), 52)))
/*    */       {
/*    */ 
/* 41 */         return true;
/*    */       }
/* 43 */       return false;
/*    */     }
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\tmpactivity\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */