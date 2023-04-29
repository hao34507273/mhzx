/*    */ package mzm.gsp.worldgoal.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityLimitTimeStageEnum;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.worldgoal.confbean.SWorldGoalCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_AddWorldGoalPoint
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   private final int addPonit;
/*    */   
/*    */   public PGM_AddWorldGoalPoint(long roleid, int activityCfgid, int addPonit)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.activityCfgid = activityCfgid;
/* 24 */     this.addPonit = addPonit;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if (!SWorldGoalCfg.getAll().containsKey(Integer.valueOf(this.activityCfgid)))
/*    */     {
/* 32 */       GmManager.getInstance().sendResultToGM(this.roleid, String.format("无效的活动id|activityCfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/* 33 */       return false;
/*    */     }
/* 35 */     if (ActivityInterface.getActivityLimitTimeStage(this.activityCfgid, DateTimeUtils.getCurrTimeInMillis()) != ActivityLimitTimeStageEnum.LIMIT_TIME_NOW)
/*    */     {
/* 37 */       GmManager.getInstance().sendResultToGM(this.roleid, String.format("活动未开启|activityCfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     if (this.addPonit <= 0)
/*    */     {
/* 43 */       GmManager.getInstance().sendResultToGM(this.roleid, String.format("需要增加的分数必须为正数|addPonit=%d", new Object[] { Integer.valueOf(this.addPonit) }));
/* 44 */       return false;
/*    */     }
/* 46 */     WorldGoalOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new PAddWorldGoalPoint(this.roleid, this.activityCfgid, this.addPonit));
/*    */     
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\PGM_AddWorldGoalPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */