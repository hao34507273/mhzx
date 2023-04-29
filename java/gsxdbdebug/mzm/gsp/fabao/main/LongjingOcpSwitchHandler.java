/*    */ package mzm.gsp.fabao.main;
/*    */ 
/*    */ import mzm.gsp.multioccupation.main.MultiOccupHandler;
/*    */ 
/*    */ 
/*    */ public class LongjingOcpSwitchHandler
/*    */   implements MultiOccupHandler
/*    */ {
/*    */   public boolean onActivateNewOccupation(long roleid, int newOccup, int oldOccup)
/*    */   {
/* 11 */     return LongjingTransferInterface.activeNewOccupation(roleid, newOccup, oldOccup);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean onSwitchOccupation(long roleid, int newOccup, int oldOccup)
/*    */   {
/* 17 */     return LongjingTransferInterface.switchOccupation(roleid, newOccup, oldOccup);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\LongjingOcpSwitchHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */