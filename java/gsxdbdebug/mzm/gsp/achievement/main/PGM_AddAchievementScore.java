/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.ActivityAchievementInfo;
/*    */ import xbean.Role2AchievementInfo;
/*    */ 
/*    */ public class PGM_AddAchievementScore extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityCfgId;
/*    */   private final int score;
/*    */   
/*    */   public PGM_AddAchievementScore(long roleId, int activityCfgId, int score)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.activityCfgId = activityCfgId;
/* 19 */     this.score = score;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 26 */     lock(xdb.Lockeys.get(xtable.User.getTable(), userId));
/*    */     
/* 28 */     Role2AchievementInfo xRole2AchievementInfo = xtable.Role2achievement.get(Long.valueOf(this.roleId));
/* 29 */     if (xRole2AchievementInfo == null)
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     ActivityAchievementInfo xActivityAchievementInfo = (ActivityAchievementInfo)xRole2AchievementInfo.getActivity_achievement_info().get(Integer.valueOf(this.activityCfgId));
/*    */     
/* 36 */     if (xActivityAchievementInfo == null)
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     AchievementManager.offerAchievementScore(this.roleId, xActivityAchievementInfo, this.score, this.activityCfgId);
/*    */     
/* 43 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 44 */     messagetip.result = Integer.MAX_VALUE;
/* 45 */     messagetip.args.add(String.format("增加天帝宝库积分成功!", new Object[0]));
/* 46 */     OnlineManager.getInstance().sendAtOnce(this.roleId, messagetip);
/*    */     
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\PGM_AddAchievementScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */