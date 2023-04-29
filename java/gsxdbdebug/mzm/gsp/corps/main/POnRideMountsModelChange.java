/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.mounts.event.RideMountsModelChangeArg;
/*    */ 
/*    */ public class POnRideMountsModelChange extends mzm.gsp.mounts.event.RideMountsModelChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     CorpsManager.synCorpsMemberModelChange(((RideMountsModelChangeArg)this.arg).getRoleId());
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\POnRideMountsModelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */