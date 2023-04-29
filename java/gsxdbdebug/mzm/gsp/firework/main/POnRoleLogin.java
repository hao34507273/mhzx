/*    */ package mzm.gsp.firework.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity3.confbean.SFireworkCfg;
/*    */ import mzm.gsp.firework.FireWorkStageInfo;
/*    */ import mzm.gsp.firework.SSynAllFireworkShowStage;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.Pair;
/*    */ import xbean.FireworkInfo;
/*    */ import xbean.FireworkRecord;
/*    */ import xtable.Basic;
/*    */ import xtable.Globalfirework;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 22 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/* 24 */     lock(Basic.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/*    */     
/* 26 */     FireworkInfo xFireworkInfo = Globalfirework.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 27 */     if (xFireworkInfo == null)
/*    */     {
/* 29 */       return false;
/*    */     }
/* 31 */     long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 32 */     Map<Integer, FireWorkStageInfo> stageInfos = new HashMap();
/* 33 */     for (Map.Entry<Integer, FireworkRecord> entry : xFireworkInfo.getActivityid2record().entrySet())
/*    */     {
/* 35 */       int activityId = ((Integer)entry.getKey()).intValue();
/* 36 */       FireworkRecord xFireworkRecord = (FireworkRecord)entry.getValue();
/* 37 */       SFireworkCfg cfg = SFireworkCfg.get(activityId);
/* 38 */       if ((cfg != null) && 
/*    */       
/*    */ 
/*    */ 
/* 42 */         (mzm.gsp.activity.main.ActivityInterface.isActivityOpen(activityId)))
/*    */       {
/*    */ 
/*    */ 
/* 46 */         Pair<Integer, Long> stagePair = getStage(curTime, activityId, xFireworkRecord, cfg);
/* 47 */         if (stagePair != null)
/*    */         {
/*    */ 
/*    */ 
/* 51 */           FireWorkStageInfo stageInfo = new FireWorkStageInfo();
/* 52 */           stageInfo.stage = ((Integer)stagePair.first).intValue();
/* 53 */           stageInfo.stagestarttime = (((Long)stagePair.second).longValue() / 1000L);
/*    */           
/* 55 */           stageInfos.put(Integer.valueOf(activityId), stageInfo);
/*    */         } } }
/* 57 */     if (stageInfos.size() == 0)
/*    */     {
/* 59 */       return false;
/*    */     }
/* 61 */     SSynAllFireworkShowStage p = new SSynAllFireworkShowStage();
/* 62 */     p.activityinfos.putAll(stageInfos);
/* 63 */     OnlineManager.getInstance().send(roleId, p);
/* 64 */     return true;
/*    */   }
/*    */   
/*    */   Pair<Integer, Long> getStage(long curTime, int activityId, FireworkRecord xFireworkRecord, SFireworkCfg cfg)
/*    */   {
/* 69 */     long fireShowStartTime = xFireworkRecord.getFireworkstarttime();
/* 70 */     if (fireShowStartTime > 0L)
/*    */     {
/* 72 */       if (fireShowStartTime - curTime >= cfg.fireworkEffectDuration * 1000L)
/*    */       {
/* 74 */         return null;
/*    */       }
/* 76 */       return new Pair(Integer.valueOf(3), Long.valueOf(fireShowStartTime));
/*    */     }
/* 78 */     long countDownStartTime = xFireworkRecord.getFireworkcountdowntime();
/* 79 */     if (countDownStartTime > 0L)
/*    */     {
/* 81 */       if (countDownStartTime - curTime > cfg.countDown * 1000L)
/*    */       {
/* 83 */         return null;
/*    */       }
/* 85 */       return new Pair(Integer.valueOf(2), Long.valueOf(countDownStartTime));
/*    */     }
/* 87 */     long findStartTime = xFireworkRecord.getFindfireworkstarttime();
/* 88 */     if (findStartTime > 0L)
/*    */     {
/* 90 */       if (findStartTime - curTime > FireworkGmDataCache.getInstance().getFindLastInterval(cfg) * 1000L)
/*    */       {
/* 92 */         return null;
/*    */       }
/* 94 */       return new Pair(Integer.valueOf(1), Long.valueOf(findStartTime));
/*    */     }
/* 96 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */