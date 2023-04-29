/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.partner.event.GetPartnerProcedure;
/*    */ import mzm.gsp.partner.event.PartnerEventArg;
/*    */ 
/*    */ public class POnGetPartner
/*    */   extends GetPartnerProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((PartnerEventArg)this.arg).getRoleId(), 603, Integer.valueOf(((PartnerEventArg)this.arg).getPartnerCfgId()), "POnGetPartner.processImp@handle PARTNER_SPECIFIC_OWN finish");
/*    */     
/*    */ 
/*    */ 
/* 15 */     AchievementManager.updateGoalTypeState(((PartnerEventArg)this.arg).getRoleId(), 604, null, "POnGetPartner.processImp@handle PARTNER_ACCUMULATE_OWN finish");
/*    */     
/*    */ 
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnGetPartner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */