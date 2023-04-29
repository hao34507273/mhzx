/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import mzm.gsp.magicmark.event.MagicMarkModelChangeEventProcedure;
/*    */ 
/*    */ public class POnMagicMarkModelChange extends MagicMarkModelChangeEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     ShiTuManager.synShiTuRoleInfoChange(((Long)this.arg).longValue());
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\POnMagicMarkModelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */