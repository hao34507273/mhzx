/*    */ package mzm.gsp.item.main.expbottle;
/*    */ 
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.award.main.AwardModel;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.item.confbean.SExpBottleItemCfg;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ 
/*    */ 
/*    */ public class MergeServerLevelExpBottleItem
/*    */   implements ExpBottleItem
/*    */ {
/*    */   public int getExpBottleItemExp(long roleId, SExpBottleItemCfg sExpBottleItemCfg)
/*    */   {
/* 15 */     AwardReason reason = new AwardReason(LogReason.ROLE_USE_EXP_ITEM);
/* 16 */     reason.setJustQuery(true);
/* 17 */     AwardModel awardModel = AwardInterface.getRoleAwardModel(sExpBottleItemCfg.award_id, roleId, -1, reason);
/* 18 */     if (awardModel == null)
/*    */     {
/* 20 */       return -1;
/*    */     }
/* 22 */     return awardModel.getRoleExp() * sExpBottleItemCfg.server_level_diff_days;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\expbottle\MergeServerLevelExpBottleItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */