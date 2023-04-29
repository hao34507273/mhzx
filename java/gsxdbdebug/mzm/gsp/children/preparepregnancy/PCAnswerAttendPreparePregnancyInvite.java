/*     */ package mzm.gsp.children.preparepregnancy;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.bubblegame.event.BubbleGameContext;
/*     */ import mzm.gsp.bubblegame.main.BubbleGameInterface;
/*     */ import mzm.gsp.children.SAnswerAttendPreparePregnancyInviteFail;
/*     */ import mzm.gsp.children.SAnswerAttendPreparePregnancyInviteSuccess;
/*     */ import mzm.gsp.children.confbean.PreparePregnancyConsts;
/*     */ import mzm.gsp.children.main.ChildrenInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCAnswerAttendPreparePregnancyInvite
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long leaderid;
/*     */   private final long partnerid;
/*     */   private final long sessionid;
/*     */   private final int answer;
/*     */   
/*     */   public PCAnswerAttendPreparePregnancyInvite(long leaderid, long partnerid, long sessionid, int answer)
/*     */   {
/*  40 */     this.leaderid = leaderid;
/*  41 */     this.partnerid = partnerid;
/*  42 */     this.sessionid = sessionid;
/*  43 */     this.answer = answer;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  49 */     if ((this.leaderid < 0L) || (this.sessionid < 0L) || ((this.answer != 1) && (this.answer != 2)))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*  54 */       onFail(-3, null, false);
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if ((!PreparePregnancyManager.isPreparePregnancySwitchOpenForRole(this.leaderid)) || (!PreparePregnancyManager.isPreparePregnancySwitchOpenForRole(this.partnerid)))
/*     */     {
/*     */ 
/*     */ 
/*  62 */       onFail(-1, null, false);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     if (!PreparePregnancyManager.checkRoleStatus(this.partnerid, 712))
/*     */     {
/*     */ 
/*  69 */       onFail(-2, null, false);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     Session session = Session.getSession(this.sessionid);
/*  74 */     if (session == null)
/*     */     {
/*     */ 
/*  77 */       onFail(8, null, false);
/*  78 */       return false;
/*     */     }
/*  80 */     InviteSession inviteSession = null;
/*  81 */     if ((session instanceof InviteSession))
/*     */     {
/*  83 */       inviteSession = (InviteSession)session;
/*     */     }
/*     */     
/*  86 */     if ((inviteSession == null) || (inviteSession.getInviterid() != this.leaderid) || (inviteSession.getInviteeid() != this.partnerid) || (inviteSession.getMarriageid() != MarriageInterface.getMarriedId(this.leaderid, false)) || (inviteSession.getMarriageid() != MarriageInterface.getMarriedId(this.partnerid, false)))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  92 */       onFail(-4, null, false);
/*  93 */       return false;
/*     */     }
/*  95 */     Session.removeSession(this.sessionid, this.leaderid);
/*     */     
/*  97 */     Long teamid = TeamInterface.getTeamidByRoleid(this.leaderid, false);
/*  98 */     if (teamid == null)
/*     */     {
/*     */ 
/* 101 */       onFail(1, null, true);
/* 102 */       return false;
/*     */     }
/* 104 */     List<Long> teamMembers = TeamInterface.getTeamMemberList(teamid.longValue(), false);
/* 105 */     if (teamMembers.size() != 2)
/*     */     {
/*     */ 
/* 108 */       Map<String, Object> extraInfo = new HashMap();
/* 109 */       extraInfo.put("teamid", teamid);
/* 110 */       extraInfo.put("memberlist", teamMembers);
/* 111 */       onFail(2, extraInfo, true);
/* 112 */       return false;
/*     */     }
/* 114 */     if (this.leaderid != ((Long)teamMembers.get(0)).longValue())
/*     */     {
/*     */ 
/* 117 */       Map<String, Object> extraInfo = new HashMap();
/* 118 */       extraInfo.put("teamid", teamid);
/* 119 */       extraInfo.put("memberlist", teamMembers);
/* 120 */       onFail(3, extraInfo, true);
/* 121 */       return false;
/*     */     }
/* 123 */     if (this.partnerid != ((Long)teamMembers.get(1)).longValue())
/*     */     {
/*     */ 
/* 126 */       Map<String, Object> extraInfo = new HashMap();
/* 127 */       extraInfo.put("teamid", teamid);
/* 128 */       extraInfo.put("memberlist", teamMembers);
/* 129 */       onFail(4, extraInfo, true);
/* 130 */       return false;
/*     */     }
/*     */     
/* 133 */     String leaderUserid = RoleInterface.getUserId(this.leaderid);
/* 134 */     String partnerUserid = RoleInterface.getUserId(this.partnerid);
/*     */     
/*     */ 
/* 137 */     lock(User.getTable(), Arrays.asList(new String[] { leaderUserid, partnerUserid }));
/*     */     
/* 139 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.leaderid), Long.valueOf(this.partnerid) }));
/*     */     
/*     */ 
/* 142 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamid.longValue(), true);
/* 143 */     if (teamInfo == null)
/*     */     {
/*     */ 
/* 146 */       Map<String, Object> extraInfo = new HashMap();
/* 147 */       extraInfo.put("teamid", teamid);
/* 148 */       onFail(5, extraInfo, true);
/* 149 */       return false;
/*     */     }
/* 151 */     List<Long> memberList = teamInfo.getTeamMemberList();
/* 152 */     if (memberList.size() != 2)
/*     */     {
/*     */ 
/* 155 */       Map<String, Object> extraInfo = new HashMap();
/* 156 */       extraInfo.put("teamid", teamid);
/* 157 */       extraInfo.put("memberlist", memberList);
/* 158 */       onFail(2, extraInfo, true);
/* 159 */       return false;
/*     */     }
/* 161 */     if (this.leaderid != ((Long)memberList.get(0)).longValue())
/*     */     {
/*     */ 
/* 164 */       Map<String, Object> extraInfo = new HashMap();
/* 165 */       extraInfo.put("teamid", teamid);
/* 166 */       extraInfo.put("memberlist", memberList);
/* 167 */       onFail(3, extraInfo, true);
/* 168 */       return false;
/*     */     }
/* 170 */     if (this.partnerid != ((Long)memberList.get(1)).longValue())
/*     */     {
/*     */ 
/* 173 */       Map<String, Object> extraInfo = new HashMap();
/* 174 */       extraInfo.put("teamid", teamid);
/* 175 */       extraInfo.put("memberlist", memberList);
/* 176 */       onFail(4, extraInfo, true);
/* 177 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 181 */     if (MarriageInterface.getMarriedRoleid(this.partnerid, true) != this.leaderid)
/*     */     {
/*     */ 
/* 184 */       onFail(6, null, true);
/* 185 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 189 */     int currentPoint = ChildrenInterface.isCanCouplePreparePregnant(this.leaderid, this.partnerid, true);
/* 190 */     if (currentPoint < 0)
/*     */     {
/*     */ 
/* 193 */       onFail(11, null, true);
/* 194 */       return false;
/*     */     }
/* 196 */     if (currentPoint >= BubbleGameInterface.getBubbleGamePointUpperLimit(PreparePregnancyConsts.getInstance().BUBBLE_GAME_ID))
/*     */     {
/*     */ 
/* 199 */       onFail(12, null, true);
/* 200 */       return false;
/*     */     }
/*     */     
/* 203 */     if (this.answer == 1)
/*     */     {
/*     */ 
/* 206 */       Map<Long, String> userids = new HashMap();
/* 207 */       userids.put(Long.valueOf(this.leaderid), leaderUserid);
/* 208 */       userids.put(Long.valueOf(this.partnerid), partnerUserid);
/* 209 */       ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userids, memberList, PreparePregnancyConsts.getInstance().ACTIVITY_CFG_ID);
/*     */       
/* 211 */       if (!activityJoinResult.isCanJoin())
/*     */       {
/* 213 */         Map<String, Object> extraInfo = new HashMap();
/* 214 */         extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/* 215 */         onFail(7, extraInfo, true);
/* 216 */         return false;
/*     */       }
/*     */       
/* 219 */       long marriageid = MarriageInterface.getMarriedId(this.leaderid, true);
/* 220 */       long now = DateTimeUtils.getCurrTimeInMillis();
/*     */       
/*     */ 
/* 223 */       boolean isLeaderContextMatch = false;
/* 224 */       BubbleGameContext leaderContext = BubbleGameInterface.getRoleLastBubbleGameContext(this.leaderid, PreparePregnancyConsts.getInstance().BUBBLE_GAME_ID);
/*     */       
/* 226 */       if ((leaderContext != null) && ((leaderContext instanceof PreparePregnancyBubbleGameContext)))
/*     */       {
/* 228 */         PreparePregnancyBubbleGameContext leaderPreparePregnancyBubbleGameContext = (PreparePregnancyBubbleGameContext)leaderContext;
/* 229 */         if ((leaderPreparePregnancyBubbleGameContext.partnerid == this.partnerid) && (leaderPreparePregnancyBubbleGameContext.marriageid == marriageid))
/*     */         {
/*     */ 
/* 232 */           isLeaderContextMatch = true;
/*     */         }
/*     */       }
/*     */       
/* 236 */       boolean isLeaderLastBubbleGameStartInSameDay = false;
/* 237 */       long timestamp = BubbleGameInterface.getRoleLastBubbleGameStartTimestamp(this.leaderid, PreparePregnancyConsts.getInstance().BUBBLE_GAME_ID);
/*     */       
/* 239 */       if ((timestamp > 0L) && (!DateTimeUtils.needDailyReset(timestamp, now, 0)))
/*     */       {
/* 241 */         isLeaderLastBubbleGameStartInSameDay = true;
/*     */       }
/*     */       
/* 244 */       boolean isPartnerContextMatch = false;
/* 245 */       BubbleGameContext partnerContext = BubbleGameInterface.getRoleLastBubbleGameContext(this.partnerid, PreparePregnancyConsts.getInstance().BUBBLE_GAME_ID);
/*     */       
/* 247 */       if ((partnerContext != null) && ((partnerContext instanceof PreparePregnancyBubbleGameContext)))
/*     */       {
/* 249 */         PreparePregnancyBubbleGameContext partnerPreparePregnancyBubbleGameContext = (PreparePregnancyBubbleGameContext)partnerContext;
/* 250 */         if ((partnerPreparePregnancyBubbleGameContext.partnerid == this.leaderid) && (partnerPreparePregnancyBubbleGameContext.marriageid == marriageid))
/*     */         {
/*     */ 
/* 253 */           isPartnerContextMatch = true;
/*     */         }
/*     */       }
/*     */       
/* 257 */       boolean isPartnerLastBubbleGameStartInSameDay = false;
/* 258 */       timestamp = BubbleGameInterface.getRoleLastBubbleGameStartTimestamp(this.partnerid, PreparePregnancyConsts.getInstance().BUBBLE_GAME_ID);
/*     */       
/* 260 */       if ((timestamp > 0L) && (!DateTimeUtils.needDailyReset(timestamp, now, 0)))
/*     */       {
/* 262 */         isPartnerLastBubbleGameStartInSameDay = true;
/*     */       }
/*     */       
/* 265 */       if (((isLeaderLastBubbleGameStartInSameDay) && (!isLeaderContextMatch)) || ((isPartnerLastBubbleGameStartInSameDay) && (!isPartnerContextMatch)))
/*     */       {
/*     */ 
/* 268 */         onFail(9, null, true);
/* 269 */         return false;
/*     */       }
/*     */       
/* 272 */       if (isLeaderLastBubbleGameStartInSameDay)
/*     */       {
/*     */ 
/* 275 */         BubbleGameInterface.startBubbleGame(this.leaderid, PreparePregnancyConsts.getInstance().BUBBLE_GAME_ID, false, currentPoint, new PreparePregnancyBubbleGameContext(marriageid, this.partnerid));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 281 */         BubbleGameInterface.startBubbleGame(this.leaderid, PreparePregnancyConsts.getInstance().BUBBLE_GAME_ID, true, currentPoint, new PreparePregnancyBubbleGameContext(marriageid, this.partnerid));
/*     */       }
/*     */       
/*     */ 
/* 285 */       if (isPartnerLastBubbleGameStartInSameDay)
/*     */       {
/*     */ 
/* 288 */         BubbleGameInterface.startBubbleGame(this.partnerid, PreparePregnancyConsts.getInstance().BUBBLE_GAME_ID, false, currentPoint, new PreparePregnancyBubbleGameContext(marriageid, this.leaderid));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 294 */         BubbleGameInterface.startBubbleGame(this.partnerid, PreparePregnancyConsts.getInstance().BUBBLE_GAME_ID, true, currentPoint, new PreparePregnancyBubbleGameContext(marriageid, this.leaderid));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 299 */     SAnswerAttendPreparePregnancyInviteSuccess protocol = new SAnswerAttendPreparePregnancyInviteSuccess();
/* 300 */     protocol.answer = this.answer;
/* 301 */     protocol.inviterid = this.leaderid;
/* 302 */     protocol.inviteeid = this.partnerid;
/* 303 */     OnlineManager.getInstance().sendMulti(protocol, Arrays.asList(new Long[] { Long.valueOf(this.leaderid), Long.valueOf(this.partnerid) }));
/*     */     
/* 305 */     StringBuilder sb = new StringBuilder();
/* 306 */     sb.append(String.format("[prepare_pregnancy]PCAnswerAttendPreparePregnancyInvite.processImp@answer attend prepare pregnancy invite success|leaderid=%d|partnerid=%d|sessionid=%d|answer=%d", new Object[] { Long.valueOf(this.leaderid), Long.valueOf(this.partnerid), Long.valueOf(this.sessionid), Integer.valueOf(this.answer) }));
/*     */     
/*     */ 
/* 309 */     PreparePregnancyManager.logger.info(sb.toString());
/* 310 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo, boolean isSendMulti)
/*     */   {
/* 315 */     StringBuilder sb = new StringBuilder();
/* 316 */     sb.append(String.format("[prepare_pregnancy]PCAnswerAttendPreparePregnancyInvite.processImp@answer attend prepare pregnancy invite fail|leaderid=%d|partnerid=%d|sessionid=%d|answer=%d|res=%d", new Object[] { Long.valueOf(this.leaderid), Long.valueOf(this.partnerid), Long.valueOf(this.sessionid), Integer.valueOf(this.answer), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 319 */     if (extraInfo != null)
/*     */     {
/* 321 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 323 */         sb.append("|").append((String)entry.getKey());
/* 324 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 327 */     PreparePregnancyManager.logger.info(sb.toString());
/* 328 */     if (res > 0)
/*     */     {
/* 330 */       SAnswerAttendPreparePregnancyInviteFail protocol = new SAnswerAttendPreparePregnancyInviteFail();
/* 331 */       protocol.res = res;
/* 332 */       if (isSendMulti)
/*     */       {
/* 334 */         OnlineManager.getInstance().sendMultiAtOnce(protocol, Arrays.asList(new Long[] { Long.valueOf(this.leaderid), Long.valueOf(this.partnerid) }));
/*     */       }
/*     */       else
/*     */       {
/* 338 */         OnlineManager.getInstance().sendAtOnce(this.partnerid, protocol);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\preparepregnancy\PCAnswerAttendPreparePregnancyInvite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */