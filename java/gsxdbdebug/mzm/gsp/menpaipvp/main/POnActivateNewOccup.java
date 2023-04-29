/*    */ package mzm.gsp.menpaipvp.main;
/*    */ 
/*    */ import mzm.gsp.multioccupation.event.ActivateNewOccupArg;
/*    */ import mzm.gsp.multioccupation.event.ActivateNewOccupProcedure;
/*    */ 
/*    */ 
/*    */ public class POnActivateNewOccup
/*    */   extends ActivateNewOccupProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     MenpaiPVPManager.onRoleSwitchOccup(((ActivateNewOccupArg)this.arg).roleid, ((ActivateNewOccupArg)this.arg).oldOccup, ((ActivateNewOccupArg)this.arg).newOccup);
/*    */     
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\POnActivateNewOccup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */