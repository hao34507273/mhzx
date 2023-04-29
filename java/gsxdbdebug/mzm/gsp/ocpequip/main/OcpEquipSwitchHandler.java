/*    */ package mzm.gsp.ocpequip.main;
/*    */ 
/*    */ import mzm.gsp.multioccupation.main.MultiOccupHandler;
/*    */ 
/*    */ 
/*    */ public class OcpEquipSwitchHandler
/*    */   implements MultiOccupHandler
/*    */ {
/*    */   public boolean onActivateNewOccupation(long roleid, int newOccup, int oldOccup)
/*    */   {
/* 11 */     return OcpEquipInterface.activeNewOccupation(roleid, newOccup, oldOccup);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean onSwitchOccupation(long roleid, int newOccup, int oldOccup)
/*    */   {
/* 17 */     return OcpEquipInterface.switchOccupation(roleid, newOccup, oldOccup);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ocpequip\main\OcpEquipSwitchHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */