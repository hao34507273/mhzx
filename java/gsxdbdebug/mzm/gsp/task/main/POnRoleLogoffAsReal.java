/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLogoffAsReal
/*    */   extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     return new TimeLimitConProLogoffReal(((Long)this.arg).longValue()).handleTimeConTask();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\POnRoleLogoffAsReal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */