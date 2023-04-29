/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ 
/*    */ public class POnRoleLogoff extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     if (this.arg == null)
/*    */     {
/* 11 */       return false;
/*    */     }
/* 13 */     RefreshTaskSetSession.remRefreshTaskSession(((Long)this.arg).longValue());
/* 14 */     RegisterPlaceManager.onRoleLogoff(((Long)this.arg).longValue());
/*    */     
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */