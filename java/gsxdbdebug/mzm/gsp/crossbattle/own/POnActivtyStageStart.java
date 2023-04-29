/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnActivtyStageStart
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int activityCfgid;
/*    */   private final int stage;
/*    */   private final boolean startAgain;
/*    */   
/*    */   public POnActivtyStageStart(int activityCfgid, int stage, boolean startAgain)
/*    */   {
/* 19 */     this.activityCfgid = activityCfgid;
/* 20 */     this.stage = stage;
/* 21 */     this.startAgain = startAgain;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     if (!SCrossBattleOwnCfg.getAll().containsKey(Integer.valueOf(this.activityCfgid)))
/*    */     {
/* 29 */       return false;
/*    */     }
/* 31 */     switch (this.stage)
/*    */     {
/*    */     case 1: 
/* 34 */       CrossBattleOwnManager.OnCrossBattleVoteStageStart(this.startAgain, this.activityCfgid);
/* 35 */       break;
/*    */     case 2: 
/* 37 */       CrossBattleOwnManager.OnCrossBattleRoundRobinStageStart(this.startAgain, this.activityCfgid);
/* 38 */       break;
/*    */     }
/*    */     
/*    */     
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\POnActivtyStageStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */