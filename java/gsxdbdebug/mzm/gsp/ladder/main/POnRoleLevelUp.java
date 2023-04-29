/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.ladder.confbean.SLadderGradeCfg;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import xbean.Ladder;
/*    */ 
/*    */ public class POnRoleLevelUp extends mzm.gsp.role.event.RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     Ladder xLadder = LadderManager.getAndInitXLadder(((RoleLevelUpArg)this.arg).roleId, true);
/* 13 */     if (xLadder == null)
/*    */     {
/* 15 */       return false;
/*    */     }
/* 17 */     int leavelStage = LadderManager.getLevelStage(((RoleLevelUpArg)this.arg).newLevel);
/* 18 */     int oldStage = LadderManager.getLevelStage(((RoleLevelUpArg)this.arg).oldLevel);
/* 19 */     int oldLevelRange = LadderManager.getLevelRange(((RoleLevelUpArg)this.arg).oldLevel);
/* 20 */     int newLevelRange = LadderManager.getLevelRange(((RoleLevelUpArg)this.arg).newLevel);
/* 21 */     if ((leavelStage == oldStage) && (oldLevelRange == newLevelRange))
/*    */     {
/* 23 */       return false;
/*    */     }
/* 25 */     if ((oldStage == 0) && (oldLevelRange == 0))
/*    */     {
/*    */ 
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     if (leavelStage != oldStage)
/*    */     {
/* 33 */       int newStageScore = LadderManager.getMinScore(((RoleLevelUpArg)this.arg).newLevel);
/* 34 */       int oldStageScore = LadderManager.getMinScore(((RoleLevelUpArg)this.arg).oldLevel);
/* 35 */       int extra = newStageScore - oldStageScore;
/* 36 */       if (oldStageScore == 0)
/*    */       {
/* 38 */         extra = 0;
/*    */       }
/* 40 */       xLadder.setScore(xLadder.getScore() - extra);
/* 41 */       if (xLadder.getScore() < 0)
/*    */       {
/* 43 */         xLadder.setScore(0);
/*    */       }
/*    */     }
/* 46 */     if ((oldLevelRange != newLevelRange) && (oldLevelRange != 0))
/*    */     {
/* 48 */       SLadderGradeCfg cfg = SLadderGradeCfg.get(oldLevelRange);
/* 49 */       if (cfg == null)
/*    */       {
/*    */ 
/* 52 */         return false;
/*    */       }
/* 54 */       int score = LadderManager.getScore(((RoleLevelUpArg)this.arg).roleId, xLadder);
/* 55 */       int minScore = LadderManager.getMinScore(((RoleLevelUpArg)this.arg).newLevel);
/* 56 */       if (score > minScore)
/*    */       {
/* 58 */         score = (int)Math.round(score * (cfg.levelUpReductionRate * 1.0D / 10000.0D));
/* 59 */         if (score > minScore)
/*    */         {
/* 61 */           xLadder.setScore(score - minScore);
/*    */         }
/*    */         else
/*    */         {
/* 65 */           xLadder.setScore(0);
/*    */         }
/*    */       }
/*    */       else
/*    */       {
/* 70 */         xLadder.setScore(0);
/*    */       }
/* 72 */       xLadder.getAwardstages().clear();
/*    */     }
/* 74 */     LadderManager.calAndSetHonor(((RoleLevelUpArg)this.arg).roleId, xLadder);
/* 75 */     Long beforeSeasonTime = LadderManager.getBeforeSessionTimeMilSec(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/* 76 */     if (beforeSeasonTime != null)
/*    */     {
/* 78 */       LadderRankManager.getInstance().rank(((RoleLevelUpArg)this.arg).roleId, beforeSeasonTime.longValue());
/*    */     }
/* 80 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */