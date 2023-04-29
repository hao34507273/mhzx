/*     */ package mzm.gsp.menpaistar.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.menpaistar.SStartVoteFightFailed;
/*     */ import mzm.gsp.menpaistar.confbean.SMenPaiStarConst;
/*     */ import mzm.gsp.menpaistar.confbean.SMenPaiStarNpcCfg;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MenPaiStarVoteInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCStartVoteFight extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PCStartVoteFight(long roleid)
/*     */   {
/*  34 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (!MenPaiStarManager.canDoAction(this.roleid, 1004))
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if (!MenPaiStarManager.isFunOpen(this.roleid))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  51 */     long endTime = MenPaiStarConfigManager.voteEndTime();
/*  52 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  53 */     if (now >= endTime)
/*     */     {
/*     */ 
/*  56 */       Map<String, Object> extras = new HashMap();
/*  57 */       extras.put("end_time", Long.valueOf(endTime));
/*  58 */       onFailed(14, extras);
/*  59 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  63 */     int ocpid = RoleInterface.getOccupationId(this.roleid);
/*  64 */     if (!CampaignChartManager.canJoin(ocpid))
/*     */     {
/*  66 */       Map<String, Object> extras = new HashMap();
/*  67 */       extras.put("occupationid", Integer.valueOf(ocpid));
/*  68 */       onFailed(-7, extras);
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     String userid = RoleInterface.getUserId(this.roleid);
/*  73 */     if (userid == null)
/*     */     {
/*  75 */       onFailed(2);
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  80 */     if (TeamInterface.isRoleInTeam(this.roleid, false))
/*     */     {
/*  82 */       onFailed(-5);
/*  83 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  87 */     lock(Lockeys.get(User.getTable(), userid));
/*  88 */     Role role = RoleInterface.getRole(this.roleid, true);
/*  89 */     int level = role.getLevel();
/*  90 */     if (level < SMenPaiStarConst.getInstance().VOTE_MIN_LEVEL)
/*     */     {
/*  92 */       Map<String, Object> extras = new HashMap();
/*  93 */       extras.put("level", Integer.valueOf(level));
/*  94 */       onFailed(-1, extras);
/*  95 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  99 */     int serverLevel = ServerInterface.getCurrentServerLevel();
/* 100 */     if (level < serverLevel - SMenPaiStarConst.getInstance().VOTE_NOT_LESS_SERVER_LEVEL)
/*     */     {
/* 102 */       Map<String, Object> extras = new HashMap();
/* 103 */       extras.put("server_level", Integer.valueOf(serverLevel));
/* 104 */       extras.put("level", Integer.valueOf(level));
/* 105 */       onFailed(-2, extras);
/* 106 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 110 */     int occupationid = role.getOccupationId();
/* 111 */     SMenPaiStarNpcCfg menPaiStarNpcCfg = SMenPaiStarNpcCfg.get(occupationid);
/* 112 */     if (menPaiStarNpcCfg == null)
/*     */     {
/* 114 */       Map<String, Object> extras = new HashMap();
/* 115 */       extras.put("occupationid", Integer.valueOf(occupationid));
/* 116 */       onFailed(3, extras);
/* 117 */       return false;
/*     */     }
/* 119 */     if (!NpcInterface.checkNpcService(menPaiStarNpcCfg.npcCfgid, menPaiStarNpcCfg.voteBattleServiceCfgid, this.roleid))
/*     */     {
/* 121 */       onFailed(5);
/* 122 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 126 */     int activityCfgid = SMenPaiStarConst.getInstance().ACTIVITY_CFG_ID;
/* 127 */     ActivityJoinResult joinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, activityCfgid);
/*     */     
/* 129 */     if (!joinResult.isCanJoin())
/*     */     {
/* 131 */       Map<String, Object> extras = new HashMap();
/* 132 */       extras.put("activity_cfgid", Integer.valueOf(activityCfgid));
/* 133 */       extras.put("reason", Integer.valueOf(joinResult.getReasonValue()));
/* 134 */       onFailed(-6, extras);
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     MenPaiStarVoteInfo xVoteInfo = MenPaiStarManager.getAndInitXVoteInfo(this.roleid);
/* 139 */     if (xVoteInfo.getVote() == 1)
/*     */     {
/* 141 */       onFailed(7);
/* 142 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 146 */     long lastVoteFightTime = xVoteInfo.getLast_vote_time();
/* 147 */     if (DateTimeUtils.needDailyReset(lastVoteFightTime, now, 0, 0))
/*     */     {
/* 149 */       xVoteInfo.setToday_vote_num(0);
/*     */     }
/* 151 */     if (xVoteInfo.getToday_vote_num() >= SMenPaiStarConst.getInstance().DAILY_VOTE_BATTLE_NUM)
/*     */     {
/* 153 */       onFailed(-3);
/* 154 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 158 */     xVoteInfo.setLast_vote_time(now);
/*     */     
/* 160 */     PVEFightContext fightContex = new PVEFightContext();
/* 161 */     fightContex.setRoleid(this.roleid);
/* 162 */     fightContex.setFightReson(FightReason.MENPAI_STAR_VOTE_FIGHT);
/* 163 */     FightInterface.startPVEFight(this.roleid, menPaiStarNpcCfg.voteFightPveid, fightContex, FightReason.MENPAI_STAR_VOTE_FIGHT);
/*     */     
/*     */ 
/* 166 */     addTlog(userid, ocpid, xVoteInfo.getToday_vote_num());
/*     */     
/* 168 */     GameServer.logger().info(String.format("[menpaistar]PCStartVoteFight.processImp@start vote fight|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */     
/* 170 */     return true;
/*     */   }
/*     */   
/*     */   private void addTlog(String userid, int ocpid, int todayVoteFightNum)
/*     */   {
/* 175 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 176 */     int roleLevel = RoleInterface.getLevel(this.roleid);
/*     */     
/* 178 */     TLogManager.getInstance().addLog(userid, "MenPaiStarStartVoteFightForServer", new Object[] { vGameIp, userid, Long.valueOf(this.roleid), Integer.valueOf(roleLevel), Integer.valueOf(ocpid), Integer.valueOf(todayVoteFightNum) });
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFailed(int retcode)
/*     */   {
/* 184 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 189 */     SStartVoteFightFailed resp = new SStartVoteFightFailed();
/* 190 */     resp.retcode = retcode;
/* 191 */     OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     
/* 193 */     StringBuffer logBuilder = new StringBuffer();
/* 194 */     logBuilder.append("[menpaistar]PCStartVoteFight.onFailed@start vote fight failed");
/* 195 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 196 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 198 */     if (extraParams != null)
/*     */     {
/* 200 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 202 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 206 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\PCStartVoteFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */