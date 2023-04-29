/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.multioccupation.event.ActivateNewOccupArg;
/*    */ 
/*    */ public class POnRoleActivateNewOccup extends mzm.gsp.multioccupation.event.ActivateNewOccupProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     CorpsManager.synCorpsMemberBaseChange(((ActivateNewOccupArg)this.arg).roleid);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\POnRoleActivateNewOccup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */