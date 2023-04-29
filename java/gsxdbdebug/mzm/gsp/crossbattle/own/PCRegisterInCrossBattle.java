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
/*     */ import mzm.gsp.crossbattle.SRegisterInCrossBattleFail;
/*     */ import mzm.gsp.crossbattle.SRegisterInCrossBattleSuccess;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleOwn;
/*     */ import xtable.Basic;
/*     */ import xtable.Corps;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCRegisterInCrossBattle extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCRegisterInCrossBattle(long roleid, int activityCfgid)
/*     */   {
/*  37 */     this.roleid = roleid;
/*  38 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if (!CrossBattleOwnManager.isCrossBattleRegisterStageSwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  47 */       onFail(-1, null);
/*  48 */       return false;
/*     */     }
/*  50 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 1301, true))
/*     */     {
/*     */ 
/*  53 */       onFail(-2, null);
/*  54 */       return false;
/*     */     }
/*  56 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/*  57 */     if (cfg == null)
/*     */     {
/*     */ 
/*  60 */       onFail(-3, null);
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  66 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  68 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  70 */     CorpsInfo selectCorpsInfo = CorpsInterface.getCorpsInfoByRoleId(this.roleid, false, false);
/*  71 */     if (selectCorpsInfo == null)
/*     */     {
/*     */ 
/*  74 */       onFail(3, null);
/*  75 */       return false;
/*     */     }
/*  77 */     if (selectCorpsInfo.getCaptain() != this.roleid)
/*     */     {
/*     */ 
/*  80 */       onFail(4, null);
/*  81 */       return false;
/*     */     }
/*  83 */     if ((selectCorpsInfo.getAllMemberIds().size() > cfg.register_corps_member_num_upper_limit) || (selectCorpsInfo.getAllMemberIds().size() < cfg.register_corps_member_num_lower_limit))
/*     */     {
/*     */ 
/*     */ 
/*  87 */       onFail(5, null);
/*  88 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  92 */     lock(Corps.getTable(), Arrays.asList(new Long[] { Long.valueOf(selectCorpsInfo.getCorpsId()) }));
/*  93 */     CorpsInfo corpsInfo = CorpsInterface.getCorpsInfoByCorpsId(selectCorpsInfo.getCorpsId(), true);
/*  94 */     if (corpsInfo == null)
/*     */     {
/*     */ 
/*  97 */       onFail(3, null);
/*  98 */       return false;
/*     */     }
/* 100 */     if (corpsInfo.getCaptain() != this.roleid)
/*     */     {
/*     */ 
/* 103 */       onFail(4, null);
/* 104 */       return false;
/*     */     }
/* 106 */     if ((corpsInfo.getAllMemberIds().size() > cfg.register_corps_member_num_upper_limit) || (corpsInfo.getAllMemberIds().size() < cfg.register_corps_member_num_lower_limit))
/*     */     {
/*     */ 
/*     */ 
/* 110 */       onFail(5, null);
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     if (!CrossBattleOwnManager.isInRegisterStage(this.activityCfgid))
/*     */     {
/*     */ 
/* 117 */       onFail(2, null);
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/* 122 */     CrossBattleOwn xCrossBattleOwn = xtable.Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/* 123 */     if (xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(corpsInfo.getCorpsId())))
/*     */     {
/*     */ 
/* 126 */       onFail(6, null);
/* 127 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 131 */     switch (cfg.register_cost_type)
/*     */     {
/*     */     case 1: 
/* 134 */       long yuanbao = QingfuInterface.getYuanbao(userid, true) + QingfuInterface.getBindYuanbao(userid, true);
/* 135 */       if (yuanbao < cfg.register_cost_num)
/*     */       {
/*     */ 
/* 138 */         onFail(7, null);
/* 139 */         return false;
/*     */       }
/* 141 */       if (QingfuInterface.costYuanbao(userid, this.roleid, cfg.register_cost_num, CostType.COST_BIND_FIRST_CROSS_BATTLE_REGISTER, new TLogArg(LogReason.CROSS_BATTLE_OWN_REGISTER_COST, this.activityCfgid)) != CostResult.Success)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 146 */         onFail(7, null);
/* 147 */         return false;
/*     */       }
/*     */       break;
/*     */     case 2: 
/* 151 */       long gold = RoleInterface.getGold(this.roleid);
/* 152 */       if (gold < cfg.register_cost_num)
/*     */       {
/*     */ 
/* 155 */         onFail(7, null);
/* 156 */         return false;
/*     */       }
/* 158 */       if (!RoleInterface.cutGold(this.roleid, cfg.register_cost_num, new TLogArg(LogReason.CROSS_BATTLE_OWN_REGISTER_COST, this.activityCfgid)))
/*     */       {
/*     */ 
/*     */ 
/* 162 */         onFail(7, null);
/* 163 */         return false;
/*     */       }
/*     */       break;
/*     */     case 3: 
/* 167 */       long silver = RoleInterface.getSilver(this.roleid);
/* 168 */       if (silver < cfg.register_cost_num)
/*     */       {
/*     */ 
/* 171 */         onFail(7, null);
/* 172 */         return false;
/*     */       }
/* 174 */       if (!RoleInterface.cutSilver(this.roleid, cfg.register_cost_num, new TLogArg(LogReason.CROSS_BATTLE_OWN_REGISTER_COST, this.activityCfgid)))
/*     */       {
/*     */ 
/*     */ 
/* 178 */         onFail(7, null);
/* 179 */         return false;
/*     */       }
/*     */       
/*     */       break;
/*     */     default: 
/* 184 */       onFail(-3, null);
/* 185 */       return false;
/*     */     }
/*     */     
/*     */     
/* 189 */     xCrossBattleOwn.getAttend_corps_infos().put(Long.valueOf(corpsInfo.getCorpsId()), xbean.Pod.newAttendCorpsInfo());
/*     */     
/* 191 */     SRegisterInCrossBattleSuccess protocol = new SRegisterInCrossBattleSuccess();
/* 192 */     protocol.activity_cfg_id = this.activityCfgid;
/* 193 */     protocol.corps_id = corpsInfo.getCorpsId();
/* 194 */     OnlineManager.getInstance().sendMulti(protocol, corpsInfo.getAllMemberIds());
/*     */     
/* 196 */     String timePoint = DateTimeUtils.formatTimestamp(CrossBattleOwnManager.getVoteStageStartTimestamp(this.activityCfgid));
/* 197 */     for (Iterator i$ = corpsInfo.getAllMemberIds().iterator(); i$.hasNext();) { long memberid = ((Long)i$.next()).longValue();
/*     */       
/* 199 */       MailInterface.asynBuildAndSendMail(memberid, cfg.register_mail_cfg_id, null, Arrays.asList(new String[] { RoleInterface.getName(this.roleid), timePoint.substring(0, 4), timePoint.substring(4, 6), timePoint.substring(6, 8), timePoint.substring(8, 10), timePoint.substring(10, 12) }), new TLogArg(LogReason.CROSS_BATTLE_OWN_REGISTER_MAIL, this.activityCfgid));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 205 */     StringBuilder sb = new StringBuilder();
/* 206 */     sb.append(String.format("[crossbattle_own]PCRegisterInCrossBattle.processImp@register in cross battle success|roleid=%d|activity_cfg_id=%d|corpsid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Long.valueOf(corpsInfo.getCorpsId()) }));
/*     */     
/*     */ 
/* 209 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 210 */     CrossBattleOwnTLogManager.addRegisterStageTLog(this.roleid, this.activityCfgid, 1, 1, corpsInfo.getCorpsId());
/*     */     
/*     */ 
/* 213 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 218 */     StringBuilder sb = new StringBuilder();
/* 219 */     sb.append(String.format("[crossbattle_own]PCRegisterInCrossBattle.processImp@register in cross battle fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 222 */     if (extraInfo != null)
/*     */     {
/* 224 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 226 */         sb.append("|").append((String)entry.getKey());
/* 227 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 230 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 231 */     if (res > 0)
/*     */     {
/* 233 */       SRegisterInCrossBattleFail protocol = new SRegisterInCrossBattleFail();
/* 234 */       protocol.res = res;
/* 235 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\PCRegisterInCrossBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */