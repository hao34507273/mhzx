/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.crossbattle.SVoteInCrossBattleFail;
/*     */ import mzm.gsp.crossbattle.SVoteInCrossBattleSuccess;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AttendCorpsInfo;
/*     */ import xbean.CrossBattleOwn;
/*     */ import xbean.CrossBattleOwnActivityInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleCrossBattleOwnInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_cross_battle_own_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCVoteInCrossBattle extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final long targetCorpsid;
/*     */   
/*     */   public PCVoteInCrossBattle(long roleid, int activityCfgid, long targetCorpsid)
/*     */   {
/*  33 */     this.roleid = roleid;
/*  34 */     this.activityCfgid = activityCfgid;
/*  35 */     this.targetCorpsid = targetCorpsid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (this.targetCorpsid < 0L)
/*     */     {
/*     */ 
/*  44 */       onFail(-3, null);
/*  45 */       return false;
/*     */     }
/*  47 */     if (!CrossBattleOwnManager.isCrossBattleVoteStageSwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  50 */       onFail(-1, null);
/*  51 */       return false;
/*     */     }
/*  53 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 1303, true))
/*     */     {
/*     */ 
/*  56 */       onFail(-2, null);
/*  57 */       return false;
/*     */     }
/*  59 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/*  60 */     if (cfg == null)
/*     */     {
/*     */ 
/*  63 */       onFail(-3, null);
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  69 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  71 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*  72 */     if (RoleInterface.getLevel(this.roleid) < cfg.vote_level_limit)
/*     */     {
/*     */ 
/*  75 */       onFail(6, null);
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     if (!CrossBattleOwnManager.isInVoteStage(this.activityCfgid))
/*     */     {
/*     */ 
/*  82 */       onFail(2, null);
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  87 */     CrossBattleOwn xCrossBattleOwn = xtable.Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/*  88 */     AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(this.targetCorpsid));
/*  89 */     if (xAttendCorpsInfo == null)
/*     */     {
/*     */ 
/*  92 */       onFail(3, null);
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  97 */     RoleCrossBattleOwnInfo xRoleCrossBattleOwnInfo = Role_cross_battle_own_infos.get(Long.valueOf(this.roleid));
/*  98 */     if (xRoleCrossBattleOwnInfo == null)
/*     */     {
/* 100 */       xRoleCrossBattleOwnInfo = Pod.newRoleCrossBattleOwnInfo();
/* 101 */       Role_cross_battle_own_infos.insert(Long.valueOf(this.roleid), xRoleCrossBattleOwnInfo);
/*     */     }
/* 103 */     CrossBattleOwnActivityInfo xCrossBattleOwnActivityInfo = (CrossBattleOwnActivityInfo)xRoleCrossBattleOwnInfo.getCross_battle_own_activity_infos().get(Integer.valueOf(this.activityCfgid));
/*     */     
/* 105 */     if (xCrossBattleOwnActivityInfo == null)
/*     */     {
/* 107 */       xCrossBattleOwnActivityInfo = Pod.newCrossBattleOwnActivityInfo();
/* 108 */       xCrossBattleOwnActivityInfo.setVote_times(0);
/* 109 */       xCrossBattleOwnActivityInfo.setVote_timestamp(now);
/* 110 */       xRoleCrossBattleOwnInfo.getCross_battle_own_activity_infos().put(Integer.valueOf(this.activityCfgid), xCrossBattleOwnActivityInfo);
/*     */     }
/* 112 */     if (DateTimeUtils.needDailyReset(xCrossBattleOwnActivityInfo.getVote_timestamp(), now, 0))
/*     */     {
/* 114 */       xCrossBattleOwnActivityInfo.setVote_times(0);
/* 115 */       xCrossBattleOwnActivityInfo.setVote_timestamp(now);
/*     */     }
/* 117 */     if (xCrossBattleOwnActivityInfo.getVote_times() >= cfg.daily_vote_times_limit)
/*     */     {
/*     */ 
/* 120 */       onFail(4, null);
/* 121 */       return false;
/*     */     }
/*     */     
/* 124 */     if (cfg.vote_fix_award_id > 0)
/*     */     {
/* 126 */       mzm.gsp.award.main.AwardModel awardModel = mzm.gsp.award.main.AwardInterface.awardFixAward(cfg.vote_fix_award_id, userid, this.roleid, false, true, new AwardReason(LogReason.CROSS_BATTLE_OWN_VOTE_AWARD, this.activityCfgid));
/*     */       
/* 128 */       if (awardModel == null)
/*     */       {
/*     */ 
/* 131 */         onFail(5, null);
/* 132 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 136 */     xCrossBattleOwnActivityInfo.setVote_times(xCrossBattleOwnActivityInfo.getVote_times() + 1);
/* 137 */     xCrossBattleOwnActivityInfo.setVote_timestamp(now);
/*     */     
/* 139 */     xAttendCorpsInfo.setVote_num(xAttendCorpsInfo.getVote_num() + 1);
/* 140 */     xAttendCorpsInfo.setVote_num_timestamp(now);
/*     */     
/* 142 */     VoteStageVoteNumChartManager.getInstance().getChart(this.activityCfgid).rank(new VoteStageVoteNumChartObj(this.targetCorpsid, xAttendCorpsInfo.getVote_stage_start_average_fight_value(), xAttendCorpsInfo.getVote_num(), xAttendCorpsInfo.getVote_num_timestamp()));
/*     */     
/*     */ 
/* 145 */     VoteStageAverageFightValueChartManager.getInstance().getChart(this.activityCfgid).rank(new VoteStageAverageFightValueChartObj(this.targetCorpsid, xAttendCorpsInfo.getVote_stage_start_average_fight_value(), xAttendCorpsInfo.getVote_num(), xAttendCorpsInfo.getVote_num_timestamp()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 150 */     SVoteInCrossBattleSuccess protocol = new SVoteInCrossBattleSuccess();
/* 151 */     protocol.activity_cfg_id = this.activityCfgid;
/* 152 */     protocol.target_corps_id = this.targetCorpsid;
/* 153 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/* 155 */     StringBuilder sb = new StringBuilder();
/* 156 */     sb.append(String.format("[crossbattle_own]PCVoteInCrossBattle.processImp@vote in cross battle success|roleid=%d|activity_cfg_id=%d|target_corps_id=%d|vote_num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Long.valueOf(this.targetCorpsid), Integer.valueOf(xAttendCorpsInfo.getVote_num()) }));
/*     */     
/*     */ 
/* 159 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 160 */     CrossBattleOwnTLogManager.addVoteStageTLog(this.roleid, this.activityCfgid, 3, 1, this.targetCorpsid, xAttendCorpsInfo.getVote_num());
/*     */     
/* 162 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 167 */     StringBuilder sb = new StringBuilder();
/* 168 */     sb.append(String.format("[crossbattle_own]PCVoteInCrossBattle.processImp@vote in cross battle fail|roleid=%d|activity_cfg_id=%d|target_corps_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Long.valueOf(this.targetCorpsid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 171 */     if (extraInfo != null)
/*     */     {
/* 173 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 175 */         sb.append("|").append((String)entry.getKey());
/* 176 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 179 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 180 */     if (res > 0)
/*     */     {
/* 182 */       SVoteInCrossBattleFail protocol = new SVoteInCrossBattleFail();
/* 183 */       protocol.res = res;
/* 184 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\PCVoteInCrossBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */