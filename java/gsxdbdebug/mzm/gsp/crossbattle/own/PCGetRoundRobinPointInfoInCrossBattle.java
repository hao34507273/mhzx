/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.crossbattle.CrossBattleVoteRoundRobinPointRankData;
/*     */ import mzm.gsp.crossbattle.SGetRoundRobinPointInfoInCrossBattleFail;
/*     */ import mzm.gsp.crossbattle.SGetRoundRobinPointInfoInCrossBattleSuccess;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AttendCorpsInfo;
/*     */ import xbean.CrossBattleOwn;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetRoundRobinPointInfoInCrossBattle extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCGetRoundRobinPointInfoInCrossBattle(long roleid, int activityCfgid)
/*     */   {
/*  26 */     this.roleid = roleid;
/*  27 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     if (!CrossBattleOwnManager.isCrossBattleRoundRobinStageSwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  36 */       onFail(-1, null);
/*  37 */       return false;
/*     */     }
/*  39 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/*  40 */     if (cfg == null)
/*     */     {
/*     */ 
/*  43 */       onFail(-3, null);
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*     */     
/*  49 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  51 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*     */ 
/*  54 */     if (!CrossBattleOwnManager.isActivityOpen(this.activityCfgid))
/*     */     {
/*     */ 
/*  57 */       onFail(1, null);
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     long globalActivityCfgid = mzm.gsp.GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  62 */     CrossBattleOwn xCrossBattleOwn = xtable.Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/*  63 */     SGetRoundRobinPointInfoInCrossBattleSuccess protocol = new SGetRoundRobinPointInfoInCrossBattleSuccess();
/*  64 */     protocol.activity_cfg_id = this.activityCfgid;
/*  65 */     for (int i = 0; i < xCrossBattleOwn.getRound_robin_point_rank_list().size(); i++)
/*     */     {
/*  67 */       long corpsid = ((Long)xCrossBattleOwn.getRound_robin_point_rank_list().get(i)).longValue();
/*  68 */       AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsid));
/*  69 */       if (xAttendCorpsInfo == null)
/*     */       {
/*  71 */         CrossBattleOwnManager.logger.error(String.format("[crossbattle_own]PCGetRoundRobinPointInfoInCrossBattle.processImp@no corps info|corps_id=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(corpsid), Integer.valueOf(this.activityCfgid) }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*  76 */         CrossBattleVoteRoundRobinPointRankData rankdata = new CrossBattleVoteRoundRobinPointRankData();
/*  77 */         rankdata.rank = (i + 1);
/*  78 */         CrossBattleOwnManager.fillCorpsBriefInfo(rankdata.corps_brief_info, corpsid, xAttendCorpsInfo);
/*  79 */         rankdata.point = xAttendCorpsInfo.getRound_robin_point();
/*  80 */         rankdata.win_num = xAttendCorpsInfo.getRound_robin_win_num();
/*  81 */         rankdata.lose_num = xAttendCorpsInfo.getRound_robin_lose_num();
/*  82 */         rankdata.vote_num = xAttendCorpsInfo.getVote_num();
/*  83 */         rankdata.vote_timestamp = ((int)(xAttendCorpsInfo.getVote_num_timestamp() / 1000L));
/*  84 */         protocol.ranklist.add(rankdata);
/*     */       } }
/*  86 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/*  88 */     StringBuilder sb = new StringBuilder();
/*  89 */     sb.append(String.format("[crossbattle_own]PCGetRoundRobinPointInfoInCrossBattle.processImp@get round robin point info success|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid) }));
/*     */     
/*     */ 
/*  92 */     CrossBattleOwnManager.logger.info(sb.toString());
/*  93 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/*  98 */     StringBuilder sb = new StringBuilder();
/*  99 */     sb.append(String.format("[crossbattle_own]PCGetRoundRobinPointInfoInCrossBattle.processImp@get round robin point info fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 102 */     if (extraInfo != null)
/*     */     {
/* 104 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 106 */         sb.append("|").append((String)entry.getKey());
/* 107 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 110 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 111 */     if (res > 0)
/*     */     {
/* 113 */       SGetRoundRobinPointInfoInCrossBattleFail protocol = new SGetRoundRobinPointInfoInCrossBattleFail();
/* 114 */       protocol.res = res;
/* 115 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\PCGetRoundRobinPointInfoInCrossBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */