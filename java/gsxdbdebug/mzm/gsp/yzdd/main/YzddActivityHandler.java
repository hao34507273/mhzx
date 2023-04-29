/*    */ package mzm.gsp.yzdd.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.activity.main.ActivityStage.TimeBaseLine;
/*    */ import mzm.gsp.activity.main.ActivityStage.TimeLogic;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.yzdd.confbean.YzddConsts;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ public class YzddActivityHandler
/*    */   implements ActivityHandler
/*    */ {
/*    */   public void initData(String s, long l, int i, int i1) {}
/*    */   
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 26 */     return null;
/*    */   }
/*    */   
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 31 */     List<ActivityStage> stages = new ArrayList();
/* 32 */     ActivityStage prepare = new ActivityStage(YzddConsts.getInstance().PerpareMinute, ActivityStage.TimeBaseLine.BEGIN, ActivityStage.TimeLogic.FIX);
/* 33 */     ActivityStage match1 = new ActivityStage(YzddConsts.getInstance().PKMinute, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX);
/* 34 */     ActivityStage match2 = new ActivityStage(YzddConsts.getInstance().EndMinute, ActivityStage.TimeBaseLine.END, ActivityStage.TimeLogic.FIX);
/* 35 */     stages.add(prepare);
/* 36 */     stages.add(match1);
/* 37 */     stages.add(match2);
/* 38 */     return stages;
/*    */   }
/*    */   
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int i)
/*    */   {
/* 43 */     YzddManager.logger.info("一战到底活动开始");
/* 44 */     long worldId = MapInterface.createWorld(YzddManager.getInstance().getAllMapIds());
/* 45 */     YzddManager.getInstance().setWorldId(worldId);
/* 46 */     YzddManager.getInstance().clearAllFights();
/* 47 */     YzddManager.getInstance().sendGunjunAward = false;
/* 48 */     YzddManager.getInstance().sendJijunAward = false;
/* 49 */     YzddManager.getInstance().sendYajunAward = false;
/* 50 */     ControllerInterface.triggerController(YzddConsts.getInstance().ControllerId);
/*    */   }
/*    */   
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid)
/*    */   {
/* 55 */     List<Long> roleids = MapInterface.getRoleList(YzddManager.getInstance().getWorldId().longValue());
/* 56 */     YzddManager.getInstance().brocastStage(stage, roleids);
/* 57 */     switch (stage) {
/*    */     case 1: 
/* 59 */       ControllerInterface.collectController(YzddConsts.getInstance().ControllerId);
/* 60 */       List<Long> roleIds = MapInterface.getRoleList(YzddManager.getInstance().getWorldId().longValue(), YzddConsts.getInstance().PerpareMapId);
/* 61 */       MapInterface.transferAllRole(roleIds, YzddManager.getInstance().getWorldId().longValue(), YzddConsts.getInstance().MapId1);
/* 62 */       for (final Long roleId : roleIds) {
/* 63 */         YzddManager.getInstance().newRoleRelatedSession(roleId.longValue(), 2, new LogicRunnable()
/*    */         {
/*    */           public void process() {
/* 66 */             YzddManager.getInstance().syncPlayerModel(roleId.longValue());
/*    */           }
/*    */         });
/*    */       }
/* 70 */       YzddManager.logger.info("一战到底入场阶段,隐藏入场npc，玩家不能再入场！进入战斗地图");
/* 71 */       break;
/*    */     
/*    */     case 3: 
/* 74 */       for (Long l : YzddManager.getInstance().getAllFightIds()) {
/* 75 */         long fightid = l.longValue();
/* 76 */         FightInterface.endFightNonRealTime(fightid);
/*    */       }
/*    */     }
/*    */     
/*    */   }
/*    */   
/*    */   public void onActivityEnd(int i)
/*    */   {
/* 84 */     YzddManager.getInstance().CheckActivityEnd();
/* 85 */     List<Long> roleIds = MapInterface.getRoleList(YzddManager.getInstance().getWorldId().longValue());
/* 86 */     for (Long roleId : roleIds) {
/* 87 */       MapInterface.unSetModelProtocol(roleId.longValue(), 12634400);
/*    */     }
/*    */     
/* 90 */     MapInterface.dragAllRoleTo(YzddManager.getInstance().getWorldId().longValue(), 330000001);
/* 91 */     MapInterface.destroyWorld(YzddManager.getInstance().getWorldId().longValue());
/* 92 */     YzddManager.getInstance().clearAllFights();
/* 93 */     YzddManager.logger.info("一战到底入活动结束");
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\yzdd\main\YzddActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */