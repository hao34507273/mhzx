/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ import mzm.gsp.multioccupation.main.MultiOccupHandler;
/*    */ 
/*    */ public class OcpRankHandler
/*    */   implements MultiOccupHandler
/*    */ {
/*    */   public boolean onActivateNewOccupation(long roleid, int newOccup, int oldOccup)
/*    */   {
/* 10 */     MultiRankManager.delOcpRankData(roleid, oldOccup);
/* 11 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean onSwitchOccupation(long roleid, int newOccup, int oldOccup)
/*    */   {
/* 17 */     MultiRankManager.delOcpRankData(roleid, oldOccup);
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\OcpRankHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */