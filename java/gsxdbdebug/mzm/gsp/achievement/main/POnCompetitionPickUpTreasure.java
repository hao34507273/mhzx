/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalDoneOneEventTimes.Context;
/*    */ import mzm.gsp.achievement.main.goaltype.CompetitionPickUpTreasure.TreasureType;
/*    */ import mzm.gsp.competition.event.PickUpTreasureArg;
/*    */ import mzm.gsp.competition.event.PickUpTreasureProcedure;
/*    */ 
/*    */ public class POnCompetitionPickUpTreasure extends PickUpTreasureProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/*    */     int treasureType;
/*    */     int treasureType;
/* 14 */     if (((PickUpTreasureArg)this.arg).isGold())
/*    */     {
/* 16 */       treasureType = CompetitionPickUpTreasure.TreasureType.GOLD.value;
/*    */     } else { int treasureType;
/* 18 */       if (((PickUpTreasureArg)this.arg).isSilver())
/*    */       {
/* 20 */         treasureType = CompetitionPickUpTreasure.TreasureType.SILVER.value;
/*    */       }
/*    */       else
/*    */       {
/* 24 */         treasureType = CompetitionPickUpTreasure.TreasureType.COPPER.value;
/*    */       }
/*    */     }
/* 27 */     AbstractConditionalDoneOneEventTimes.Context context = new AbstractConditionalDoneOneEventTimes.Context(treasureType, 1);
/* 28 */     AchievementManager.updateGoalTypeState(((PickUpTreasureArg)this.arg).roleid, 909, context, "POnCompetitionPickUpTreasure.processImp@handle COMPETITION_PICKUP_TREASURE finish");
/*    */     
/*    */ 
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnCompetitionPickUpTreasure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */