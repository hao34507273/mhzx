/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.wing.event.WingModelChangedArg;
/*    */ 
/*    */ public class POnWingChangedEvent extends mzm.gsp.wing.event.WingModelChangedEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     CorpsManager.synCorpsMemberModelChange(((WingModelChangedArg)this.arg).getRoleId());
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\POnWingChangedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */