/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_RefreshKnockOutFightZoneInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final int activityCfgId;
/*    */   private final int knockOutType;
/*    */   private final int fightZoneId;
/*    */   
/*    */   public PGM_RefreshKnockOutFightZoneInfo(long gmRoleId, int activityCfgId, int knockOutType, int fightZoneId)
/*    */   {
/* 20 */     this.gmRoleId = gmRoleId;
/* 21 */     this.activityCfgId = activityCfgId;
/* 22 */     this.knockOutType = knockOutType;
/* 23 */     this.fightZoneId = fightZoneId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     int retcode = CrossBattleKnockoutManager.refreshKnockOutData(this.activityCfgId, this.knockOutType, this.fightZoneId);
/*    */     
/* 31 */     if (retcode == 63986)
/*    */     {
/* 33 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "活动id配置错误");
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     if (retcode == 63985)
/*    */     {
/* 39 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "淘汰赛类型错误");
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     if (retcode == 63984)
/*    */     {
/* 45 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "战区id配置错误");
/* 46 */       return false;
/*    */     }
/*    */     
/* 49 */     if (retcode == 63983)
/*    */     {
/* 51 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "当前淘汰赛阶段计算错误");
/* 52 */       return false;
/*    */     }
/*    */     
/* 55 */     if (retcode == 63982)
/*    */     {
/* 57 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "grc通信失败");
/* 58 */       return false;
/*    */     }
/*    */     
/* 61 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "发送成功,清刷新查看界面数据");
/* 62 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PGM_RefreshKnockOutFightZoneInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */