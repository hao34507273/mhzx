/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class PGM_RestartKnockOut
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityCfgId;
/*    */   private final int knockOutType;
/*    */   private final int restartFightZoneId;
/*    */   private final int restartFightIndexId;
/*    */   private final long prepareWroldCreateTime;
/*    */   
/*    */   public PGM_RestartKnockOut(long roleId, int activityCfgId, int knockOutType, int restartFightZoneId, int restartFightIndexId, long prepareWorldCreateTime)
/*    */   {
/* 19 */     this.roleId = roleId;
/* 20 */     this.activityCfgId = activityCfgId;
/* 21 */     this.knockOutType = knockOutType;
/* 22 */     this.restartFightZoneId = restartFightZoneId;
/* 23 */     this.restartFightIndexId = restartFightIndexId;
/* 24 */     this.prepareWroldCreateTime = (prepareWorldCreateTime * 1000L);
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     int result = CrossBattleKnockoutManager.restartKnockOut(this.activityCfgId, this.knockOutType, this.restartFightZoneId, this.restartFightIndexId, this.prepareWroldCreateTime);
/*    */     
/* 32 */     if (result < 0)
/*    */     {
/* 34 */       if (result == 64006)
/*    */       {
/* 36 */         GmManager.getInstance().sendResultToGM(this.roleId, "活动配置不存在");
/*    */       }
/* 38 */       else if (result == 64005)
/*    */       {
/* 40 */         GmManager.getInstance().sendResultToGM(this.roleId, "不是当前活动id");
/*    */       }
/* 42 */       else if (result == 64004)
/*    */       {
/* 44 */         GmManager.getInstance().sendResultToGM(this.roleId, "淘汰赛配置不存在");
/*    */       }
/* 46 */       else if (result == 64003)
/*    */       {
/* 48 */         GmManager.getInstance().sendResultToGM(this.roleId, "战区id不存在");
/*    */       }
/* 50 */       else if (result == 64002)
/*    */       {
/* 52 */         GmManager.getInstance().sendResultToGM(this.roleId, "当前阶段计算错误");
/*    */       }
/* 54 */       else if (result == 64001)
/*    */       {
/* 56 */         GmManager.getInstance().sendResultToGM(this.roleId, "当前淘汰赛尚未开始");
/*    */       }
/* 58 */       else if (result == 64000)
/*    */       {
/* 60 */         GmManager.getInstance().sendResultToGM(this.roleId, "最大战斗id计算错误");
/*    */       }
/* 62 */       else if (result == 63999)
/*    */       {
/* 64 */         GmManager.getInstance().sendResultToGM(this.roleId, "战斗id配置错误");
/*    */       }
/* 66 */       else if (result == 63998)
/*    */       {
/* 68 */         GmManager.getInstance().sendResultToGM(this.roleId, "不能设置为过去的开始时间");
/*    */       }
/* 70 */       else if (result == 63997)
/*    */       {
/* 72 */         GmManager.getInstance().sendResultToGM(this.roleId, "下一阶段开始时间计算错误");
/*    */       }
/* 74 */       else if (result == 63996)
/*    */       {
/* 76 */         GmManager.getInstance().sendResultToGM(this.roleId, "补赛结束时间大于下一阶段的开始时间了,不能进行补赛了");
/*    */       }
/* 78 */       else if (result == 63995)
/*    */       {
/* 80 */         GmManager.getInstance().sendResultToGM(this.roleId, "当前存在淘汰赛准备大厅,出现异常");
/*    */       }
/* 82 */       else if (result == 63992)
/*    */       {
/* 84 */         GmManager.getInstance().sendResultToGM(this.roleId, "已经设置所有赛区重赛了");
/*    */       }
/* 86 */       else if (result == 63991)
/*    */       {
/* 88 */         GmManager.getInstance().sendResultToGM(this.roleId, "已经设置该赛区的该场比赛重赛了");
/*    */       }
/* 90 */       else if (result == 63993)
/*    */       {
/* 92 */         GmManager.getInstance().sendResultToGM(this.roleId, "时间不和之前设置的相同");
/*    */       }
/* 94 */       return false;
/*    */     }
/*    */     
/* 97 */     GmManager.getInstance().sendResultToGM(this.roleId, "补赛启动成功,请各队按时入场");
/* 98 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PGM_RestartKnockOut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */