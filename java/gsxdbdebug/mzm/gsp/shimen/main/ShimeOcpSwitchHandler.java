/*    */ package mzm.gsp.shimen.main;
/*    */ 
/*    */ import mzm.gsp.multioccupation.main.MultiOccupHandler;
/*    */ 
/*    */ 
/*    */ public class ShimeOcpSwitchHandler
/*    */   implements MultiOccupHandler
/*    */ {
/*    */   public boolean onActivateNewOccupation(long roleid, int newOccup, int oldOccup)
/*    */   {
/* 11 */     return ShimenManager.switchShimeGraph(roleid, newOccup, oldOccup);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean onSwitchOccupation(long roleid, int newOccup, int oldOccup)
/*    */   {
/* 17 */     return ShimenManager.switchShimeGraph(roleid, newOccup, oldOccup);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shimen\main\ShimeOcpSwitchHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */