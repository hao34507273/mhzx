/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleDrawLotsCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnActivtyStageStart extends LogicProcedure
/*    */ {
/*    */   private final int activityCfgid;
/*    */   private final int stage;
/*    */   private final boolean startAgain;
/*    */   
/*    */   public POnActivtyStageStart(int activityCfgid, int stage, boolean startAgain)
/*    */   {
/* 16 */     this.activityCfgid = activityCfgid;
/* 17 */     this.stage = stage;
/* 18 */     this.startAgain = startAgain;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 26 */       return false;
/*    */     }
/* 28 */     if (!SCrossBattleDrawLotsCfg.getAll().containsKey(Integer.valueOf(this.activityCfgid)))
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     switch (this.stage)
/*    */     {
/*    */     case 3: 
/* 35 */       CrossBattlePointManager.onZoneDivideStart(this.activityCfgid, this.startAgain);
/* 36 */       break;
/*    */     case 4: 
/* 38 */       CrossBattlePointManager.onPointRaceStageStart(this.activityCfgid);
/* 39 */       break;
/*    */     }
/*    */     
/*    */     
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\POnActivtyStageStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */