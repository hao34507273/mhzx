/*    */ package mzm.gsp.fashiondress.main;
/*    */ 
/*    */ import mzm.gsp.multioccupation.main.MultiOccupHandler;
/*    */ 
/*    */ 
/*    */ public class OcpFashionDressSwitchHandler
/*    */   implements MultiOccupHandler
/*    */ {
/*    */   public boolean onActivateNewOccupation(long roleid, int newOccup, int oldOccup)
/*    */   {
/* 11 */     return FashionDressInterface.activeNewOccupation(roleid, newOccup, oldOccup);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean onSwitchOccupation(long roleid, int newOccup, int oldOccup)
/*    */   {
/* 17 */     return FashionDressInterface.switchOccupation(roleid, newOccup, oldOccup);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\OcpFashionDressSwitchHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */