/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.crossbattle.SGetRoundRobinRoundInfoInCrossBattleFail;
/*     */ import mzm.gsp.crossbattle.SGetRoundRobinRoundInfoInCrossBattleSuccess;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AttendCorpsInfo;
/*     */ import xbean.CrossBattleOwn;
/*     */ import xbean.RoundRobinRoundInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetRoundRobinRoundInfoInCrossBattle extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int roundIndex;
/*     */   
/*     */   public PCGetRoundRobinRoundInfoInCrossBattle(long roleid, int activityCfgid, int roundIndex)
/*     */   {
/*  27 */     this.roleid = roleid;
/*  28 */     this.activityCfgid = activityCfgid;
/*  29 */     this.roundIndex = roundIndex;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     if (!CrossBattleOwnManager.isCrossBattleRoundRobinStageSwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  38 */       onFail(-1, null);
/*  39 */       return false;
/*     */     }
/*  41 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/*  42 */     if (cfg == null)
/*     */     {
/*     */ 
/*  45 */       onFail(-3, null);
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*     */     
/*  51 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  53 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*     */ 
/*  56 */     if (!CrossBattleOwnManager.isActivityOpen(this.activityCfgid))
/*     */     {
/*     */ 
/*  59 */       onFail(1, null);
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     long globalActivityCfgid = mzm.gsp.GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  64 */     CrossBattleOwn xCrossBattleOwn = xtable.Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/*  65 */     if ((this.roundIndex <= 0) || (this.roundIndex > xCrossBattleOwn.getRound_robin_round_infos().size()))
/*     */     {
/*     */ 
/*  68 */       onFail(-3, null);
/*  69 */       return false;
/*     */     }
/*  71 */     RoundRobinRoundInfo xRoundRobinRoundInfo = (RoundRobinRoundInfo)xCrossBattleOwn.getRound_robin_round_infos().get(this.roundIndex - 1);
/*     */     
/*     */ 
/*  74 */     SGetRoundRobinRoundInfoInCrossBattleSuccess protocol = new SGetRoundRobinRoundInfoInCrossBattleSuccess();
/*  75 */     protocol.activity_cfg_id = this.activityCfgid;
/*  76 */     protocol.index = this.roundIndex;
/*  77 */     protocol.stage = xRoundRobinRoundInfo.getStage();
/*  78 */     for (xbean.RoundRobinFightInfo xRoundRobinFightInfo : xRoundRobinRoundInfo.getFight_infos())
/*     */     {
/*  80 */       if ((!xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()))) || (!xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()))))
/*     */       {
/*     */ 
/*  83 */         CrossBattleOwnManager.logger.error(String.format("[crossbattle_own]PCGetRoundRobinRoundInfoInCrossBattle.processImp@no corps info|corps_a_id=%d|corps_b_id=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(xRoundRobinFightInfo.getCorps_a_id()), Long.valueOf(xRoundRobinFightInfo.getCorps_b_id()), Integer.valueOf(this.activityCfgid) }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*  88 */         mzm.gsp.crossbattle.RoundRobinFightInfo fightInfo = new mzm.gsp.crossbattle.RoundRobinFightInfo();
/*  89 */         CrossBattleOwnManager.fillCorpsBriefInfo(fightInfo.corps_a_brief_info, xRoundRobinFightInfo.getCorps_a_id(), (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_a_id())));
/*     */         
/*  91 */         CrossBattleOwnManager.fillCorpsBriefInfo(fightInfo.corps_b_brief_info, xRoundRobinFightInfo.getCorps_b_id(), (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(xRoundRobinFightInfo.getCorps_b_id())));
/*     */         
/*  93 */         fightInfo.state = xRoundRobinFightInfo.getState();
/*  94 */         protocol.fight_infos.add(fightInfo);
/*     */       } }
/*  96 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/*  98 */     StringBuilder sb = new StringBuilder();
/*  99 */     sb.append(String.format("[crossbattle_own]PCGetRoundRobinRoundInfoInCrossBattle.processImp@get round robin round info fail|roleid=%d|activity_cfg_id=%d|roundindex=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.roundIndex) }));
/*     */     
/*     */ 
/* 102 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 103 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 108 */     StringBuilder sb = new StringBuilder();
/* 109 */     sb.append(String.format("[crossbattle_own]PCGetRoundRobinRoundInfoInCrossBattle.processImp@get round robin round info fail|roleid=%d|activity_cfg_id=%d|roundindex=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.roundIndex), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 112 */     if (extraInfo != null)
/*     */     {
/* 114 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 116 */         sb.append("|").append((String)entry.getKey());
/* 117 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 120 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 121 */     if (res > 0)
/*     */     {
/* 123 */       SGetRoundRobinRoundInfoInCrossBattleFail protocol = new SGetRoundRobinRoundInfoInCrossBattleFail();
/* 124 */       protocol.res = res;
/* 125 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\PCGetRoundRobinRoundInfoInCrossBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */