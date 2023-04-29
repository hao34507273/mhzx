/*    */ package mzm.gsp.menpaipvp.main;
/*    */ 
/*    */ import mzm.gsp.multioccupation.event.SwitchOccupArg;
/*    */ import mzm.gsp.multioccupation.event.SwitchOccupProcedure;
/*    */ 
/*    */ 
/*    */ public class POnSwitchOccup
/*    */   extends SwitchOccupProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     MenpaiPVPManager.onRoleSwitchOccup(((SwitchOccupArg)this.arg).roleid, ((SwitchOccupArg)this.arg).oldOccup, ((SwitchOccupArg)this.arg).newOccup);
/*    */     
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\POnSwitchOccup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */