/*    */ package mzm.gsp.activitypointexchange.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ActivityPointExchangeInterface
/*    */ {
/*    */   public static boolean shangJia(int activityId, int mallCfgId, int goodsCfgId)
/*    */   {
/* 13 */     return ActivityPointExchangeManager.removeSoldOutGoodsCfgId(activityId, mallCfgId, goodsCfgId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean xiaJia(int activityId, int mallCfgId, int goodsCfgId)
/*    */   {
/* 24 */     return ActivityPointExchangeManager.addSoldOutGoodsCfgId(activityId, mallCfgId, goodsCfgId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\main\ActivityPointExchangeInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */