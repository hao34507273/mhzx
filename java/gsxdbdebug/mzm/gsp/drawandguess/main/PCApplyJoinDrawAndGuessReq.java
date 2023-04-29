/*     */ package mzm.gsp.drawandguess.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.drawandguess.SApplyJoinDrawAndGuessFailRep;
/*     */ import mzm.gsp.drawandguess.SApplyJoinDrawAndGuessSuccessRep;
/*     */ import mzm.gsp.drawandguess.SNotifyDrawAndGuessInvite;
/*     */ import mzm.gsp.drawandguess.confbean.SDrawAndGuessActivityCfg;
/*     */ import mzm.gsp.drawandguess.confbean.SDrawAndGuessRuleCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCApplyJoinDrawAndGuessReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long leaderRoleId;
/*     */   private final int activityCfgid;
/*     */   private final int npcId;
/*     */   
/*     */   public PCApplyJoinDrawAndGuessReq(long leaderRoleId, int activityCfgid, int npcId)
/*     */   {
/*  32 */     this.leaderRoleId = leaderRoleId;
/*  33 */     this.activityCfgid = activityCfgid;
/*  34 */     this.npcId = npcId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     if (this.activityCfgid <= 0)
/*     */     {
/*  45 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  51 */     SDrawAndGuessActivityCfg sDrawAndGuessActivityCfg = SDrawAndGuessActivityCfg.get(this.activityCfgid);
/*  52 */     if (sDrawAndGuessActivityCfg == null)
/*     */     {
/*  54 */       onFailed(-3);
/*  55 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  61 */     if (this.npcId != sDrawAndGuessActivityCfg.npcCfgid)
/*     */     {
/*  63 */       onFailed(-4);
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  71 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcServiceIgnoreNpcLocationCond(sDrawAndGuessActivityCfg.npcCfgid, sDrawAndGuessActivityCfg.npcServiceCfgid, this.leaderRoleId))
/*     */     {
/*     */ 
/*  74 */       onFailed(-5);
/*  75 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  82 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.leaderRoleId, 1211, true))
/*     */     {
/*  84 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  90 */     if (!DrawAndGuessManager.isFunOpen(this.leaderRoleId, this.activityCfgid))
/*     */     {
/*  92 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  99 */     Long teamId = TeamInterface.getTeamidByRoleid(this.leaderRoleId, false);
/* 100 */     if (teamId == null)
/*     */     {
/* 102 */       Map<String, Object> extras = new HashMap();
/* 103 */       extras.put("teamId", teamId);
/* 104 */       onFailed(-9, extras);
/* 105 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 111 */     List<Long> selectMembers = TeamInterface.getNormalRoleList(this.leaderRoleId);
/* 112 */     if ((selectMembers.size() < sDrawAndGuessActivityCfg.minTeamMember) || (selectMembers.size() > sDrawAndGuessActivityCfg.maxTeamMember))
/*     */     {
/*     */ 
/* 115 */       Map<String, Object> extras = new HashMap();
/* 116 */       extras.put("selectMembersize", Integer.valueOf(selectMembers.size()));
/* 117 */       onFailed(-7, extras);
/* 118 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 122 */     Map<Long, String> userIds = new HashMap();
/*     */     
/* 124 */     for (Iterator i$ = selectMembers.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/* 125 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(tmpRoleId);
/* 126 */       if (userid == null)
/*     */       {
/* 128 */         onFailed(-2);
/* 129 */         return false;
/*     */       }
/* 131 */       userIds.put(Long.valueOf(tmpRoleId), userid);
/*     */     }
/*     */     
/* 134 */     lock(User.getTable(), userIds.values());
/*     */     
/* 136 */     lock(Basic.getTable(), selectMembers);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 143 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(userIds, selectMembers, this.activityCfgid);
/*     */     
/* 145 */     if (!result.isCanJoin())
/*     */     {
/* 147 */       Map<String, Object> extras = new HashMap();
/* 148 */       extras.put("reason", Integer.valueOf(result.getReasonValue()));
/* 149 */       onFailed(-8, extras);
/* 150 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 156 */     if (this.leaderRoleId != ((Long)selectMembers.get(0)).longValue())
/*     */     {
/* 158 */       onFailed(-10);
/* 159 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 165 */     if (DrawAndGuessManager.isInDrawAndGuess(this.leaderRoleId))
/*     */     {
/* 167 */       onFailed(-6);
/* 168 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 174 */     SDrawAndGuessRuleCfg sDrawAndGuessRuleCfg = SDrawAndGuessRuleCfg.get(sDrawAndGuessActivityCfg.ruleId);
/* 175 */     if (sDrawAndGuessRuleCfg == null)
/*     */     {
/* 177 */       onFailed(-3);
/* 178 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 184 */     DrawAndGuessApplyJoinSession sessinon = new DrawAndGuessApplyJoinSession(sDrawAndGuessRuleCfg.waitMemberConfirmTime, this.leaderRoleId, this.activityCfgid, selectMembers);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 192 */     sessinon.agree(Long.valueOf(this.leaderRoleId));
/*     */     
/* 194 */     long timestamp = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 199 */     SApplyJoinDrawAndGuessSuccessRep sApplyJoinDrawAndGuessSuccessRep = new SApplyJoinDrawAndGuessSuccessRep();
/* 200 */     sApplyJoinDrawAndGuessSuccessRep.timestamp = TimeUnit.MILLISECONDS.toSeconds(timestamp);
/* 201 */     sApplyJoinDrawAndGuessSuccessRep.sessionid = sessinon.getSessionId();
/* 202 */     OnlineManager.getInstance().send(this.leaderRoleId, sApplyJoinDrawAndGuessSuccessRep);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 207 */     SNotifyDrawAndGuessInvite sNotifyDrawAndGuessInvite = new SNotifyDrawAndGuessInvite();
/* 208 */     sNotifyDrawAndGuessInvite.timestamp = TimeUnit.MILLISECONDS.toSeconds(timestamp);
/* 209 */     sNotifyDrawAndGuessInvite.sessionid = sessinon.getSessionId();
/* 210 */     OnlineManager.getInstance().sendMulti(sNotifyDrawAndGuessInvite, DrawAndGuessManager.getFilteredMembers(sessinon.getTeamMembers(), Long.valueOf(this.leaderRoleId)));
/*     */     
/*     */ 
/* 213 */     GameServer.logger().info(String.format("[drawandguess]PCApplyJoinDrawAndGuessReq.processImp@ success|roleid=%d|activity_cfgid=%d|selectMembers=%s", new Object[] { Long.valueOf(this.leaderRoleId), Integer.valueOf(this.activityCfgid), sessinon.getTeamMembers().toString() }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 218 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 223 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFailed(int error_code, Map<String, Object> extraParams)
/*     */   {
/* 234 */     SApplyJoinDrawAndGuessFailRep rsp = new SApplyJoinDrawAndGuessFailRep();
/* 235 */     rsp.error_code = error_code;
/* 236 */     OnlineManager.getInstance().sendAtOnce(this.leaderRoleId, rsp);
/*     */     
/* 238 */     StringBuffer logBuilder = new StringBuffer();
/* 239 */     logBuilder.append("[drawandguess]PCApplyJoinDrawAndGuessReq.onFailed@processImp() failed");
/* 240 */     logBuilder.append('|').append("roleid=").append(this.leaderRoleId);
/* 241 */     logBuilder.append('|').append("activity_cfgid=").append(this.activityCfgid);
/* 242 */     logBuilder.append('|').append("error_code=").append(error_code);
/*     */     
/* 244 */     if (extraParams != null)
/*     */     {
/* 246 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 248 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 252 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\main\PCApplyJoinDrawAndGuessReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */