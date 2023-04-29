/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.role.event.RoleColorChangeEventProcedure;
/*    */ 
/*    */ public class POnRoleColorChangeEvent extends RoleColorChangeEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     CorpsManager.synCorpsMemberModelChange(((Long)this.arg).longValue());
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\POnRoleColorChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */