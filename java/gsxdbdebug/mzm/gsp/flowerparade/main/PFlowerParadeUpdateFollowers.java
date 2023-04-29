/*    */ package mzm.gsp.flowerparade.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity4.confbean.SFlowerParadeCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.FlowerParade;
/*    */ 
/*    */ public class PFlowerParadeUpdateFollowers extends LogicProcedure
/*    */ {
/*    */   private final int activityId;
/*    */   
/*    */   public PFlowerParadeUpdateFollowers(int activityId)
/*    */   {
/* 14 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     long localid = GameServerInfoManager.getLocalId();
/* 21 */     FlowerParade xFlowerParade = xtable.Flowerparade.get(Long.valueOf(localid));
/* 22 */     if (xFlowerParade == null)
/*    */     {
/* 24 */       return false;
/*    */     }
/* 26 */     SFlowerParadeCfg cfg = SFlowerParadeCfg.get(this.activityId);
/* 27 */     int intervalSec = cfg.followAliveTime;
/* 28 */     FlowerParadeManager.startUpdateFollowerObserver(intervalSec, this.activityId);
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\PFlowerParadeUpdateFollowers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */