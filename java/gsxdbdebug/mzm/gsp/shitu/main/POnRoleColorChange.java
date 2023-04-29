/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import mzm.gsp.role.event.RoleColorChangeEventProcedure;
/*    */ 
/*    */ public class POnRoleColorChange extends RoleColorChangeEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     ShiTuManager.synShiTuRoleInfoChange(((Long)this.arg).longValue());
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\POnRoleColorChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */