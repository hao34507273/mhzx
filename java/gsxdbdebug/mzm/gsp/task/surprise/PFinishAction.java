/*     */ package mzm.gsp.task.surprise;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.activity3.confbean.SSurpriseActionCfg;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.common.confbean.STimeDurationCommonCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PFinishAction extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int mapId;
/*     */   private final int positionX;
/*     */   private final int positionY;
/*     */   private final int actionId;
/*     */   
/*     */   public PFinishAction(long roleId, int mapId, int positionX, int positionY, int actionId)
/*     */   {
/*  27 */     this.roleId = roleId;
/*  28 */     this.mapId = mapId;
/*  29 */     this.positionX = positionX;
/*  30 */     this.positionY = positionY;
/*  31 */     this.actionId = actionId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     Set<SSurpriseActionCfg> cfgs = SurpriseTaskManager.getSurpriseActionCfg(this.actionId, this.mapId, this.positionX, this.positionY);
/*  38 */     if ((cfgs == null) || (cfgs.isEmpty()))
/*     */     {
/*  40 */       return false;
/*     */     }
/*  42 */     for (final SSurpriseActionCfg cfg : cfgs)
/*     */     {
/*  44 */       new LogicProcedure()
/*     */       {
/*     */ 
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/*  50 */           return PFinishAction.this.handOpenGraph(cfg);
/*     */         }
/*     */       }.execute();
/*     */     }
/*  54 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean handOpenGraph(SSurpriseActionCfg cfg)
/*     */   {
/*  60 */     if (cfg == null)
/*     */     {
/*  62 */       return false;
/*     */     }
/*  64 */     if (!needOpenGraph(cfg))
/*     */     {
/*  66 */       return false;
/*     */     }
/*  68 */     SurpriseTaskManager.loggerInfo("PFinishAction.handOpenGraph@ right time, right action, can open graph!|roleId=%d|mapId=%d|x=%d|y=%d|actionId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.mapId), Integer.valueOf(this.positionX), Integer.valueOf(this.positionY), Integer.valueOf(this.actionId) });
/*     */     
/*     */ 
/*     */ 
/*  72 */     lock(User.getTable(), Arrays.asList(new String[] { RoleInterface.getUserId(this.roleId) }));
/*     */     
/*  74 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */     
/*  76 */     if (!SurpriseTaskManager.neverAcceptGraph(this.roleId, cfg.graphId, cfg.graphFinishCount))
/*     */     {
/*  78 */       SurpriseTaskManager.loggerError("PFinishAction.handOpenGraph@ already finished graph!|roleId=%d|actionId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.actionId) });
/*     */       
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     if (!TaskInterface.activeGraph(Long.valueOf(this.roleId), cfg.graphId))
/*     */     {
/*  85 */       SurpriseTaskManager.loggerError("PFinishAction.handOpenGraph@ activeGraph error!|roleId=%d|actionId=%d|graphId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.actionId), Integer.valueOf(cfg.graphId) });
/*     */       
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     SurpriseTaskManager.tlogSurprise(RoleInterface.getUserId(this.roleId), this.roleId, 3, cfg.id, cfg.graphId);
/*     */     
/*  92 */     return true;
/*     */   }
/*     */   
/*     */   private boolean needOpenGraph(SSurpriseActionCfg cfg)
/*     */   {
/*  97 */     int level = RoleInterface.getLevel(this.roleId);
/*  98 */     if (level < cfg.joinLevel)
/*     */     {
/* 100 */       SurpriseTaskManager.loggerError("PFinishAction.needOpenGraph@ role level is not enough!|roleId=%d|level=%d|cfgLevel=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(level), Integer.valueOf(cfg.joinLevel) });
/*     */       
/*     */ 
/* 103 */       return false;
/*     */     }
/* 105 */     int curServerLevel = ServerInterface.getCurrentServerLevel();
/* 106 */     if (curServerLevel < cfg.joinServerLevel)
/*     */     {
/* 108 */       SurpriseTaskManager.loggerError("PFinishAction.needOpenGraph@ server level is not enough!|roleId=%d|curServerLevel=%d|cfgServerLevel=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(curServerLevel), Integer.valueOf(cfg.joinServerLevel) });
/*     */       
/*     */ 
/* 111 */       return false;
/*     */     }
/* 113 */     if (cfg.actionId != this.actionId)
/*     */     {
/* 115 */       return false;
/*     */     }
/* 117 */     if (!SurpriseTaskManager.isActivityValid(cfg.activityId))
/*     */     {
/* 119 */       return false;
/*     */     }
/* 121 */     if (!SurpriseTaskManager.isServerlevelValid(cfg.joinServerLevel, cfg.needServerLevelTime))
/*     */     {
/* 123 */       return false;
/*     */     }
/* 125 */     if (!isTimeOk(DateTimeUtils.getCurrTimeInMillis(), STimeDurationCommonCfg.get(cfg.refreshTime)))
/*     */     {
/* 127 */       return false;
/*     */     }
/* 129 */     return true;
/*     */   }
/*     */   
/*     */   private boolean isTimeOk(long curTime, STimeDurationCommonCfg durationCommonCfg)
/*     */   {
/* 134 */     if (durationCommonCfg == null)
/*     */     {
/* 136 */       return false;
/*     */     }
/* 138 */     long beforeStartTime = TimeCommonUtil.getBeforeStartTime(curTime, durationCommonCfg.timeCommonCfgId);
/* 139 */     long lastMills = TimeUnit.DAYS.toMillis(durationCommonCfg.lastDay) + TimeUnit.HOURS.toMillis(durationCommonCfg.lastHour) + TimeUnit.MINUTES.toMillis(durationCommonCfg.lastMinute);
/*     */     
/* 141 */     long beforeLastTime = beforeStartTime + lastMills;
/*     */     
/* 143 */     if ((curTime > beforeLastTime) || (curTime < beforeStartTime))
/*     */     {
/* 145 */       return false;
/*     */     }
/* 147 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\surprise\PFinishAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */