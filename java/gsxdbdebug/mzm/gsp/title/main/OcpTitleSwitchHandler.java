/*    */ package mzm.gsp.title.main;
/*    */ 
/*    */ import mzm.gsp.multioccupation.main.MultiOccupHandler;
/*    */ 
/*    */ 
/*    */ public class OcpTitleSwitchHandler
/*    */   implements MultiOccupHandler
/*    */ {
/*    */   public boolean onActivateNewOccupation(long roleid, int newOccup, int oldOccup)
/*    */   {
/* 11 */     return TitleInterface.activeNewOccupation(roleid, newOccup, oldOccup);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean onSwitchOccupation(long roleid, int newOccup, int oldOccup)
/*    */   {
/* 17 */     return TitleInterface.switchOccupation(roleid, newOccup, oldOccup);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\OcpTitleSwitchHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */