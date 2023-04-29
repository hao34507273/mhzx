/*    */ package mzm.gsp.flowerparade.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.FlowerParade;
/*    */ 
/*    */ public class PFlowerParadeStopCountdownEnd extends LogicProcedure
/*    */ {
/*    */   private final int activityId;
/*    */   
/*    */   public PFlowerParadeStopCountdownEnd(int activityId)
/*    */   {
/* 13 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     long localid = GameServerInfoManager.getLocalId();
/* 20 */     FlowerParade xFlowerParade = xtable.Flowerparade.get(Long.valueOf(localid));
/* 21 */     if (xFlowerParade == null)
/*    */     {
/* 23 */       return false;
/*    */     }
/* 25 */     xFlowerParade.setSessionidstopcountdown(0L);
/*    */     
/* 27 */     FlowerParadeManager.stopFlowerParade(this.activityId);
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\PFlowerParadeStopCountdownEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */