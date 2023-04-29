/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import mzm.gsp.crossserver.main.CollectServerBalanceInfoHandler;
/*    */ 
/*    */ public class PointRaceBalanceInfo
/*    */   implements CollectServerBalanceInfoHandler
/*    */ {
/*    */   public int getReservedNum()
/*    */   {
/* 10 */     return PointRaceManager.getInstance().getReservedNum();
/*    */   }
/*    */   
/*    */ 
/*    */   public int getOnlineNum()
/*    */   {
/* 16 */     return PointRaceManager.getInstance().getOnlineNum();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PointRaceBalanceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */