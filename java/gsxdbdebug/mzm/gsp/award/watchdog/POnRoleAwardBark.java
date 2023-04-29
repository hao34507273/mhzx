/*    */ package mzm.gsp.award.watchdog;
/*    */ 
/*    */ import mzm.gsp.award.event.RoleAwardBarkEventProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleAwardBark
/*    */   extends RoleAwardBarkEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     if (!(this.arg instanceof AwardBarkEventArg))
/*    */     {
/* 17 */       return false;
/*    */     }
/* 19 */     return new PRoleAwardBark((AwardBarkEventArg)this.arg).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\watchdog\POnRoleAwardBark.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */