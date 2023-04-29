/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.corps.main.CorpsInfo;
/*     */ import mzm.gsp.corps.main.CorpsInterface;
/*     */ import mzm.gsp.crossbattle.SUnregisterInCrossBattleSuccess;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleOwn;
/*     */ import xtable.Basic;
/*     */ import xtable.Corps;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PTryUnregisterOnCorpsMemberChange extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long corpsid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PTryUnregisterOnCorpsMemberChange(long corpsid, int activityCfgid)
/*     */   {
/*  30 */     this.corpsid = corpsid;
/*  31 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/*  38 */     if (cfg == null)
/*     */     {
/*     */ 
/*  41 */       return false;
/*     */     }
/*  43 */     CorpsInfo selectCorpsInfo = CorpsInterface.getCorpsInfoByCorpsId(this.corpsid, false);
/*  44 */     if (selectCorpsInfo == null)
/*     */     {
/*     */ 
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(selectCorpsInfo.getCaptain());
/*     */     
/*  52 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  54 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(selectCorpsInfo.getCaptain()) }));
/*     */     
/*  56 */     lock(Corps.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.corpsid) }));
/*  57 */     CorpsInfo corpsInfo = CorpsInterface.getCorpsInfoByCorpsId(this.corpsid, true);
/*  58 */     if (corpsInfo == null)
/*     */     {
/*     */ 
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     if (!CrossBattleOwnManager.isInRegisterStage(this.activityCfgid))
/*     */     {
/*     */ 
/*  67 */       onFail(5, null);
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  72 */     CrossBattleOwn xCrossBattleOwn = xtable.Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/*  73 */     if (!xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(this.corpsid)))
/*     */     {
/*     */ 
/*  76 */       onFail(2, null);
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     if ((corpsInfo.getAllMemberIds().size() <= cfg.register_corps_member_num_upper_limit) && (corpsInfo.getAllMemberIds().size() >= cfg.register_corps_member_num_lower_limit))
/*     */     {
/*     */ 
/*     */ 
/*  84 */       onFail(3, null);
/*  85 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  89 */     xCrossBattleOwn.getAttend_corps_infos().remove(Long.valueOf(corpsInfo.getCorpsId()));
/*     */     
/*  91 */     SUnregisterInCrossBattleSuccess protocol = new SUnregisterInCrossBattleSuccess();
/*  92 */     protocol.activity_cfg_id = this.activityCfgid;
/*  93 */     protocol.corps_id = corpsInfo.getCorpsId();
/*  94 */     protocol.reason = 1;
/*  95 */     OnlineManager.getInstance().sendMulti(protocol, corpsInfo.getAllMemberIds());
/*     */     
/*  97 */     for (Iterator i$ = corpsInfo.getAllMemberIds().iterator(); i$.hasNext();) { long memberid = ((Long)i$.next()).longValue();
/*     */       
/*  99 */       MailInterface.asynBuildAndSendMail(memberid, cfg.corps_member_num_dissatisfied_unregister_mail_cfg_id, null, null, new TLogArg(LogReason.CROSS_BATTLE_OWN_UNREGISTER_MAIL, this.activityCfgid));
/*     */     }
/*     */     
/*     */ 
/* 103 */     StringBuilder sb = new StringBuilder();
/* 104 */     sb.append(String.format("[crossbattle_own]PTryUnregisterOnCorpsMemberChange.processImp@try unregister on corps member change success|corpsid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.corpsid), Integer.valueOf(this.activityCfgid) }));
/*     */     
/*     */ 
/* 107 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 108 */     CrossBattleOwnTLogManager.addRegisterStageTLog(corpsInfo.getCaptain(), this.activityCfgid, 2, 2, corpsInfo.getCorpsId());
/*     */     
/*     */ 
/* 111 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 116 */     StringBuilder sb = new StringBuilder();
/* 117 */     sb.append(String.format("[crossbattle_own]PTryUnregisterOnCorpsMemberChange.processImp@try unregister on corps member change fail|corpsid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.corpsid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 120 */     if (extraInfo != null)
/*     */     {
/* 122 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 124 */         sb.append("|").append((String)entry.getKey());
/* 125 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 128 */     CrossBattleOwnManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\PTryUnregisterOnCorpsMemberChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */