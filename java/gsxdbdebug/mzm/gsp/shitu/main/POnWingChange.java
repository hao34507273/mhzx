/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import mzm.gsp.wing.event.WingModelChangedArg;
/*    */ 
/*    */ public class POnWingChange extends mzm.gsp.wing.event.WingModelChangedEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     ShiTuManager.synShiTuRoleInfoChange(((WingModelChangedArg)this.arg).getRoleId());
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\POnWingChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */