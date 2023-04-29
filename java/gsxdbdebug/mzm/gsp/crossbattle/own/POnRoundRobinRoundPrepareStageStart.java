/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.common.confbean.STimePointCommonCfg;
/*     */ import mzm.gsp.crossbattle.SSynRoundRobinRoundInfoInCrossBattle;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AttendCorpsInfo;
/*     */ import xbean.CrossBattleOwn;
/*     */ import xbean.RoundRobinRoundInfo;
/*     */ import xtable.Cross_battle_owns;
/*     */ 
/*     */ public class POnRoundRobinRoundPrepareStageStart
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final int activityCfgid;
/*     */   private final int roundIndex;
/*     */   private final boolean isMain;
/*     */   
/*     */   public POnRoundRobinRoundPrepareStageStart(int activityCfgid, int roundIndex, boolean isMain)
/*     */   {
/*  31 */     this.activityCfgid = activityCfgid;
/*  32 */     this.roundIndex = roundIndex;
/*  33 */     this.isMain = isMain;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/*  40 */     if (cfg == null)
/*     */     {
/*     */ 
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  47 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  48 */     CrossBattleOwn xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/*  49 */     if (xCrossBattleOwn.getStage() != 2)
/*     */     {
/*     */ 
/*  52 */       onFail(5, null);
/*  53 */       return false;
/*     */     }
/*  55 */     if (CrossBattleOwnManager.isRoundRobinRoundEnd(xCrossBattleOwn, this.roundIndex))
/*     */     {
/*     */ 
/*  58 */       onFail(6, null);
/*  59 */       return false;
/*     */     }
/*  61 */     RoundRobinRestartInfo restartInfo = RoundRobinRestartManager.getInstance().getRestartInfo(this.activityCfgid);
/*  62 */     if ((restartInfo == null) && (xCrossBattleOwn.getRound_robin_round_index() != this.roundIndex))
/*     */     {
/*     */ 
/*  65 */       onFail(7, null);
/*  66 */       return false;
/*     */     }
/*  68 */     RoundRobinRoundInfo xRoundRobinRoundInfo = (RoundRobinRoundInfo)xCrossBattleOwn.getRound_robin_round_infos().get(this.roundIndex - 1);
/*     */     
/*     */ 
/*  71 */     if (CrossBattleOwnManager.isCrossBattleRoundRobinStageSwitchOpen(this.activityCfgid))
/*     */     {
/*  73 */       SSynRoundRobinRoundInfoInCrossBattle protocol = new SSynRoundRobinRoundInfoInCrossBattle();
/*  74 */       protocol.activity_cfg_id = this.activityCfgid;
/*  75 */       protocol.index = this.roundIndex;
/*  76 */       protocol.stage = 0;
/*  77 */       for (xbean.RoundRobinFightInfo xRoundRobinFightInfo : xRoundRobinRoundInfo.getFight_infos())
/*     */       {
/*  79 */         if ((!xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))) || (!xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))))
/*     */         {
/*     */ 
/*  82 */           CrossBattleOwnManager.logger.error(String.format("[crossbattle_own]POnRoundRobinRoundPrepareStageStart.processImp@no corps info|corps_a_id=%d|corps_b_id=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()), Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()), Integer.valueOf(this.activityCfgid) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*  87 */           mzm.gsp.crossbattle.RoundRobinFightInfo fightInfo = new mzm.gsp.crossbattle.RoundRobinFightInfo();
/*  88 */           CrossBattleOwnManager.fillCorpsBriefInfo(fightInfo.corps_a_brief_info, xRoundRobinFightInfo.getCorps_a_id(), (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id())));
/*     */           
/*  90 */           CrossBattleOwnManager.fillCorpsBriefInfo(fightInfo.corps_b_brief_info, xRoundRobinFightInfo.getCorps_b_id(), (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id())));
/*     */           
/*  92 */           fightInfo.state = xRoundRobinFightInfo.getState();
/*  93 */           protocol.fight_infos.add(fightInfo);
/*     */         } }
/*  95 */       OnlineManager.getInstance().sendAll(protocol);
/*     */     }
/*     */     
/*  98 */     xRoundRobinRoundInfo.setStage(0);
/*     */     
/* 100 */     RoundRobinWorldManager.getInstance().createWorld(this.activityCfgid);
/*     */     
/* 102 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 103 */     if (restartInfo != null)
/*     */     {
/* 105 */       long interval = (restartInfo.timestamp - now) / 1000L;
/* 106 */       if (interval <= 0L)
/*     */       {
/* 108 */         CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new POnRoundRobinRoundFightStageStart(this.activityCfgid, this.roundIndex, this.isMain));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 113 */         RoundRobinRoundSessionManager.getInstance().startFightSession(interval, this.activityCfgid, this.roundIndex, this.isMain);
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/* 119 */       int timePointCfgid = -1;
/* 120 */       if (this.isMain)
/*     */       {
/* 122 */         timePointCfgid = ((Integer)cfg.round_robin_time_points.get(this.roundIndex - 1)).intValue();
/*     */       }
/*     */       else
/*     */       {
/* 126 */         timePointCfgid = ((Integer)cfg.round_robin_backup_time_points.get(this.roundIndex - 1)).intValue();
/*     */       }
/* 128 */       long interval = (TimeCommonUtil.getTimePoint(STimePointCommonCfg.get(timePointCfgid)) - now) / 1000L;
/* 129 */       if (interval <= 0L)
/*     */       {
/* 131 */         CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new POnRoundRobinRoundFightStageStart(this.activityCfgid, this.roundIndex, this.isMain));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 136 */         RoundRobinRoundSessionManager.getInstance().startFightSession(interval, this.activityCfgid, this.roundIndex, this.isMain);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 141 */     StringBuilder sb = new StringBuilder();
/* 142 */     sb.append(String.format("[crossbattle_own]POnRoundRobinRoundPrepareStageStart.processImp@round robin round prepare stage start process success|activity_cfg_id=%d|round_index=%d|is_main=%b", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.roundIndex), Boolean.valueOf(this.isMain) }));
/*     */     
/*     */ 
/* 145 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 146 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 151 */     StringBuilder sb = new StringBuilder();
/* 152 */     sb.append(String.format("[crossbattle_own]POnRoundRobinRoundPrepareStageStart.processImp@round robin round prepare stage start process fail|activity_cfg_id=%d|round_index=%d|is_main=%b|res=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.roundIndex), Boolean.valueOf(this.isMain), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 155 */     if (extraInfo != null)
/*     */     {
/* 157 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 159 */         sb.append("|").append((String)entry.getKey());
/* 160 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 163 */     CrossBattleOwnManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\POnRoundRobinRoundPrepareStageStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */