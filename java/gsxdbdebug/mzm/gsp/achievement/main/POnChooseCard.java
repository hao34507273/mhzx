/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.constellation.event.ChooseCardArg;
/*    */ import mzm.gsp.constellation.event.ChooseCardProcedure;
/*    */ 
/*    */ public class POnChooseCard
/*    */   extends ChooseCardProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 12 */     AchievementManager.updateGoalTypeState(((ChooseCardArg)this.arg).roleid, 2412, Integer.valueOf(((ChooseCardArg)this.arg).star), "POnChooseCard.processImp@handle CONSTELLATION_COMBO_CHOOSE_CARD_STAR success");
/*    */     
/*    */ 
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnChooseCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */