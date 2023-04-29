/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AttendCorpsInfo;
/*     */ import xbean.CrossBattleOwn;
/*     */ import xbean.RoundRobinFightInfo;
/*     */ import xbean.RoundRobinRoundInfo;
/*     */ 
/*     */ public class PSendRoundRobinRemindMail extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final int activityCfgid;
/*     */   private final int roundIndex;
/*     */   private final boolean isMain;
/*     */   private final String timePoint;
/*     */   
/*     */   public PSendRoundRobinRemindMail(int activityCfgid, int roundIndex, boolean isMain, String timePoint)
/*     */   {
/*  28 */     this.activityCfgid = activityCfgid;
/*  29 */     this.roundIndex = roundIndex;
/*  30 */     this.isMain = isMain;
/*  31 */     this.timePoint = timePoint;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (this.timePoint.length() != 14)
/*     */     {
/*  39 */       return false;
/*     */     }
/*  41 */     if (!CrossBattleOwnManager.isCrossBattleRoundRobinStageSwitchOpen(this.activityCfgid))
/*     */     {
/*     */ 
/*  44 */       onFail(-1, null);
/*  45 */       return false;
/*     */     }
/*  47 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/*  48 */     if (cfg == null)
/*     */     {
/*     */ 
/*  51 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  55 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  56 */     CrossBattleOwn xCrossBattleOwn = xtable.Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/*  57 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() == -1))
/*     */     {
/*     */ 
/*  60 */       onFail(4, null);
/*  61 */       return false;
/*     */     }
/*  63 */     if (xCrossBattleOwn.getStage() != 2)
/*     */     {
/*     */ 
/*  66 */       onFail(5, null);
/*  67 */       return false;
/*     */     }
/*  69 */     if (CrossBattleOwnManager.isRoundRobinRoundEnd(xCrossBattleOwn, this.roundIndex))
/*     */     {
/*     */ 
/*  72 */       onFail(6, null);
/*  73 */       return false;
/*     */     }
/*  75 */     if (xCrossBattleOwn.getRound_robin_round_index() != this.roundIndex)
/*     */     {
/*     */ 
/*  78 */       onFail(7, null);
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     for (Iterator i$ = ((RoundRobinRoundInfo)xCrossBattleOwn.getRound_robin_round_infos().get(this.roundIndex - 1)).getFight_infos().iterator(); i$.hasNext();) { xRoundRobinFightInfo = (RoundRobinFightInfo)i$.next();
/*     */       
/*  84 */       if (!CrossBattleOwnManager.isRoundRobinFightEnd(xRoundRobinFightInfo))
/*     */       {
/*     */ 
/*     */ 
/*  88 */         if ((!xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))) || (!xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))))
/*     */         {
/*     */ 
/*  91 */           CrossBattleOwnManager.logger.error(String.format("[crossbattle_own]PSendRoundRobinRemindMail.processImp@no attend corps info|corps_a_id=%d|corps_b_id=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()), Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()), Integer.valueOf(this.activityCfgid) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*  96 */           for (Iterator i$ = ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).getMembers().iterator(); i$.hasNext();) { long memberid = ((Long)i$.next()).longValue();
/*     */             
/*  98 */             if (this.isMain)
/*     */             {
/* 100 */               MailInterface.asynBuildAndSendMail(memberid, cfg.round_robin_main_remind_mail_cfg_id, null, Arrays.asList(new String[] { String.valueOf(this.roundIndex), this.timePoint.substring(0, 4), this.timePoint.substring(4, 6), this.timePoint.substring(6, 8), this.timePoint.substring(8, 10), this.timePoint.substring(10, 12), ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).getName(), String.valueOf(xRoundRobinFightInfo.getCorps_b_id()) }), new TLogArg(LogReason.CROSS_BATTLE_OWN_ROUND_ROBIN_STAGE_MAIN_REMIND_MAIL, this.activityCfgid));
/*     */ 
/*     */ 
/*     */ 
/*     */             }
/*     */             else
/*     */             {
/*     */ 
/*     */ 
/* 109 */               MailInterface.asynBuildAndSendMail(memberid, cfg.round_robin_backup_remind_mail_cfg_id, null, Arrays.asList(new String[] { String.valueOf(this.roundIndex), this.timePoint.substring(0, 4), this.timePoint.substring(4, 6), this.timePoint.substring(6, 8), this.timePoint.substring(8, 10), this.timePoint.substring(10, 12), ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).getName(), String.valueOf(xRoundRobinFightInfo.getCorps_b_id()) }), new TLogArg(LogReason.CROSS_BATTLE_OWN_ROUND_ROBIN_STAGE_BACKUP_REMIND_MAIL, this.activityCfgid));
/*     */             }
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 118 */           for (i$ = ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))).getMembers().iterator(); i$.hasNext();) { long memberid = ((Long)i$.next()).longValue();
/*     */             
/* 120 */             if (this.isMain)
/*     */             {
/* 122 */               MailInterface.asynBuildAndSendMail(memberid, cfg.round_robin_main_remind_mail_cfg_id, null, Arrays.asList(new String[] { String.valueOf(this.roundIndex), this.timePoint.substring(0, 4), this.timePoint.substring(4, 6), this.timePoint.substring(6, 8), this.timePoint.substring(8, 10), this.timePoint.substring(10, 12), ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).getName(), String.valueOf(xRoundRobinFightInfo.getCorps_a_id()) }), new TLogArg(LogReason.CROSS_BATTLE_OWN_ROUND_ROBIN_STAGE_MAIN_REMIND_MAIL, this.activityCfgid));
/*     */ 
/*     */ 
/*     */ 
/*     */             }
/*     */             else
/*     */             {
/*     */ 
/*     */ 
/* 131 */               MailInterface.asynBuildAndSendMail(memberid, cfg.round_robin_backup_remind_mail_cfg_id, null, Arrays.asList(new String[] { String.valueOf(this.roundIndex), this.timePoint.substring(0, 4), this.timePoint.substring(4, 6), this.timePoint.substring(6, 8), this.timePoint.substring(8, 10), this.timePoint.substring(10, 12), ((AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))).getName(), String.valueOf(xRoundRobinFightInfo.getCorps_a_id()) }), new TLogArg(LogReason.CROSS_BATTLE_OWN_ROUND_ROBIN_STAGE_BACKUP_REMIND_MAIL, this.activityCfgid));
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     RoundRobinFightInfo xRoundRobinFightInfo;
/*     */     
/*     */     Iterator i$;
/*     */     
/* 142 */     StringBuilder sb = new StringBuilder();
/* 143 */     sb.append(String.format("[crossbattle_own]PSendRoundRobinRemindMail.processImp@send round robin remind mail success|activity_cfg_id=%d|round_index=%d|is_main=%b|time_point=%s", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.roundIndex), Boolean.valueOf(this.isMain), this.timePoint }));
/*     */     
/*     */ 
/* 146 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 147 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 152 */     StringBuilder sb = new StringBuilder();
/* 153 */     sb.append(String.format("[crossbattle_own]PSendRoundRobinRemindMail.processImp@send round robin remind mail fail|activity_cfg_id=%d|round_index=%d|is_main=%b|time_point=%s|res=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.roundIndex), Boolean.valueOf(this.isMain), this.timePoint, Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 156 */     if (extraInfo != null)
/*     */     {
/* 158 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 160 */         sb.append("|").append((String)entry.getKey());
/* 161 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 164 */     CrossBattleOwnManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\PSendRoundRobinRemindMail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */