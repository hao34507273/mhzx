/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.corps.main.CorpsInfo;
/*    */ import mzm.gsp.corps.main.CorpsInterface;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointConst;
/*    */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CrossbattleDrawLots;
/*    */ 
/*    */ public class PReportCorpsFightValue extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final int activityCfgid;
/*    */   private final boolean force;
/*    */   
/*    */   public PReportCorpsFightValue(int activityCfgid, boolean force)
/*    */   {
/* 21 */     this.activityCfgid = activityCfgid;
/* 22 */     this.force = force;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     List<Long> corpsids = CrossBattleOwnInterface.getAllCrossBattleOwnPromotionCorpsids(this.activityCfgid, false);
/* 30 */     if (corpsids.isEmpty())
/*    */     {
/* 32 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.onReportFightValueStart@corps empty|activity_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*    */       
/*    */ 
/*    */ 
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     Map<Long, Float> corpsFightValues = new HashMap();
/* 40 */     for (Long corpsid : corpsids)
/*    */     {
/* 42 */       CorpsInfo corpsInfo = CorpsInterface.getCorpsInfoByCorpsId(corpsid.longValue(), false);
/* 43 */       if (corpsInfo != null)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 49 */         float fight = corpsInfo.getMultiFightValueAVG();
/* 50 */         corpsFightValues.put(corpsid, Float.valueOf(fight));
/*    */       }
/*    */     }
/* 53 */     if (!this.force)
/*    */     {
/*    */ 
/* 56 */       CrossbattleDrawLots xCrossbattleDrawLots = CrossBattlePointManager.getAndInitCrossbattleDrawLots(this.activityCfgid);
/* 57 */       if (xCrossbattleDrawLots.getReported())
/*    */       {
/* 59 */         return true;
/*    */       }
/*    */     }
/*    */     
/* 63 */     if (!CrossBattlePointManager.reportCorpsFightValue(this.activityCfgid, SCrossBattlePointConst.getInstance().ZONE_NUM, this.force, corpsFightValues))
/*    */     {
/*    */ 
/* 66 */       GameServer.logger().error(String.format("[crossbattlepoint]CrossBattlePointManager.onReportFightValueStart@report corps fight value fail|activity_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PReportCorpsFightValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */