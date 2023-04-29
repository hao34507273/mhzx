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
/*     */ import mzm.gsp.crossbattle.SUnregisterInCrossBattleFail;
/*     */ import mzm.gsp.crossbattle.SUnregisterInCrossBattleSuccess;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleOwn;
/*     */ import xtable.Basic;
/*     */ import xtable.Corps;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCUnregisterInCrossBattle extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCUnregisterInCrossBattle(long roleid, int activityCfgid)
/*     */   {
/*  32 */     this.roleid = roleid;
/*  33 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (!CrossBattleOwnManager.isCrossBattleActivitySwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  42 */       onFail(-1, null);
/*  43 */       return false;
/*     */     }
/*  45 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 1302, true))
/*     */     {
/*     */ 
/*  48 */       onFail(-2, null);
/*  49 */       return false;
/*     */     }
/*  51 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/*  52 */     if (cfg == null)
/*     */     {
/*     */ 
/*  55 */       onFail(-3, null);
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  61 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  63 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  65 */     CorpsInfo selectCorpsInfo = CorpsInterface.getCorpsInfoByRoleId(this.roleid, false, false);
/*  66 */     if (selectCorpsInfo == null)
/*     */     {
/*     */ 
/*  69 */       onFail(3, null);
/*  70 */       return false;
/*     */     }
/*  72 */     if (selectCorpsInfo.getCaptain() != this.roleid)
/*     */     {
/*     */ 
/*  75 */       onFail(4, null);
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  80 */     lock(Corps.getTable(), Arrays.asList(new Long[] { Long.valueOf(selectCorpsInfo.getCorpsId()) }));
/*  81 */     CorpsInfo corpsInfo = CorpsInterface.getCorpsInfoByCorpsId(selectCorpsInfo.getCorpsId(), true);
/*  82 */     if (corpsInfo == null)
/*     */     {
/*     */ 
/*  85 */       onFail(3, null);
/*  86 */       return false;
/*     */     }
/*  88 */     if (corpsInfo.getCaptain() != this.roleid)
/*     */     {
/*     */ 
/*  91 */       onFail(4, null);
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     if (!CrossBattleOwnManager.isInRegisterStage(this.activityCfgid))
/*     */     {
/*     */ 
/*  98 */       onFail(2, null);
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/* 103 */     CrossBattleOwn xCrossBattleOwn = xtable.Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/* 104 */     if (!xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(corpsInfo.getCorpsId())))
/*     */     {
/*     */ 
/* 107 */       onFail(5, null);
/* 108 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 112 */     xCrossBattleOwn.getAttend_corps_infos().remove(Long.valueOf(corpsInfo.getCorpsId()));
/*     */     
/* 114 */     SUnregisterInCrossBattleSuccess protocol = new SUnregisterInCrossBattleSuccess();
/* 115 */     protocol.activity_cfg_id = this.activityCfgid;
/* 116 */     protocol.corps_id = corpsInfo.getCorpsId();
/* 117 */     protocol.reason = 0;
/* 118 */     OnlineManager.getInstance().sendMulti(protocol, corpsInfo.getAllMemberIds());
/*     */     
/* 120 */     for (Iterator i$ = corpsInfo.getAllMemberIds().iterator(); i$.hasNext();) { long memberid = ((Long)i$.next()).longValue();
/*     */       
/* 122 */       MailInterface.asynBuildAndSendMail(memberid, cfg.active_unregister_mail_cfg_id, null, Arrays.asList(new String[] { RoleInterface.getName(this.roleid) }), new TLogArg(LogReason.CROSS_BATTLE_OWN_UNREGISTER_MAIL, this.activityCfgid));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 127 */     StringBuilder sb = new StringBuilder();
/* 128 */     sb.append(String.format("[crossbattle_own]PCRegisterInCrossBattle.processImp@unregister in cross battle success|roleid=%d|activity_cfg_id=%d|corpsid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Long.valueOf(corpsInfo.getCorpsId()) }));
/*     */     
/*     */ 
/* 131 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 132 */     CrossBattleOwnTLogManager.addRegisterStageTLog(this.roleid, this.activityCfgid, 2, 1, corpsInfo.getCorpsId());
/*     */     
/*     */ 
/* 135 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 140 */     StringBuilder sb = new StringBuilder();
/* 141 */     sb.append(String.format("[crossbattle_own]PCRegisterInCrossBattle.processImp@unregister in cross battle fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 144 */     if (extraInfo != null)
/*     */     {
/* 146 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 148 */         sb.append("|").append((String)entry.getKey());
/* 149 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 152 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 153 */     if (res > 0)
/*     */     {
/* 155 */       SUnregisterInCrossBattleFail protocol = new SUnregisterInCrossBattleFail();
/* 156 */       protocol.res = res;
/* 157 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\PCUnregisterInCrossBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */