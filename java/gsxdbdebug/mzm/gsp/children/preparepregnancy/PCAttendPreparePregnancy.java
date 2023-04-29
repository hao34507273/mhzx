/*     */ package mzm.gsp.children.preparepregnancy;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.bubblegame.main.BubbleGameInterface;
/*     */ import mzm.gsp.children.SAttendPreparePregnancyFail;
/*     */ import mzm.gsp.children.STransmitAttendPreparePregnancyInvite;
/*     */ import mzm.gsp.children.confbean.PreparePregnancyConsts;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.children.main.ChildrenInterface;
/*     */ import mzm.gsp.homeland.main.HomeInfoWrapper;
/*     */ import mzm.gsp.homeland.main.HomeServiceChecker;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCAttendPreparePregnancy
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long leaderid;
/*     */   private final long partnerid;
/*     */   
/*     */   public PCAttendPreparePregnancy(long leaderid, long partnerid)
/*     */   {
/*  39 */     this.leaderid = leaderid;
/*  40 */     this.partnerid = partnerid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     if ((!PreparePregnancyManager.isPreparePregnancySwitchOpenForRole(this.leaderid)) || (!PreparePregnancyManager.isPreparePregnancySwitchOpenForRole(this.partnerid)))
/*     */     {
/*     */ 
/*     */ 
/*  50 */       onFail(-1, null);
/*  51 */       return false;
/*     */     }
/*  53 */     if (!PreparePregnancyManager.checkRoleStatus(this.leaderid, 711))
/*     */     {
/*     */ 
/*  56 */       onFail(-2, null);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     HomeInfoWrapper homeInfoWrapper = HomelandInterface.getHomeInfoWrapper(this.leaderid, false);
/*  61 */     if (homeInfoWrapper == null)
/*     */     {
/*     */ 
/*  64 */       onFail(-3, null);
/*  65 */       return false;
/*     */     }
/*  67 */     if (!NpcInterface.checkNpcService(this.leaderid, SChildrenConsts.getInstance().pregnant_npc_service_id, HomelandInterface.getMaidNpc(homeInfoWrapper), new HomeServiceChecker(this.leaderid, homeInfoWrapper.getxHomeInfo().getCurrentmaiduuid())))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*  72 */       onFail(-3, null);
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     Long teamid = TeamInterface.getTeamidByRoleid(this.leaderid, false);
/*  77 */     if (teamid == null)
/*     */     {
/*     */ 
/*  80 */       onFail(1, null);
/*  81 */       return false;
/*     */     }
/*  83 */     List<Long> teamMembers = TeamInterface.getTeamMemberList(teamid.longValue(), false);
/*  84 */     if (teamMembers.size() != 2)
/*     */     {
/*     */ 
/*  87 */       Map<String, Object> extraInfo = new HashMap();
/*  88 */       extraInfo.put("teamid", teamid);
/*  89 */       extraInfo.put("memberlist", teamMembers);
/*  90 */       onFail(2, extraInfo);
/*  91 */       return false;
/*     */     }
/*  93 */     if (this.leaderid != ((Long)teamMembers.get(0)).longValue())
/*     */     {
/*     */ 
/*  96 */       Map<String, Object> extraInfo = new HashMap();
/*  97 */       extraInfo.put("teamid", teamid);
/*  98 */       extraInfo.put("memberlist", teamMembers);
/*  99 */       onFail(3, extraInfo);
/* 100 */       return false;
/*     */     }
/* 102 */     if (this.partnerid != ((Long)teamMembers.get(1)).longValue())
/*     */     {
/*     */ 
/* 105 */       Map<String, Object> extraInfo = new HashMap();
/* 106 */       extraInfo.put("teamid", teamid);
/* 107 */       extraInfo.put("memberlist", teamMembers);
/* 108 */       onFail(4, extraInfo);
/* 109 */       return false;
/*     */     }
/* 111 */     String leaderUserid = RoleInterface.getUserId(this.leaderid);
/* 112 */     String partnerUserid = RoleInterface.getUserId(this.partnerid);
/*     */     
/*     */ 
/* 115 */     lock(User.getTable(), Arrays.asList(new String[] { leaderUserid, partnerUserid }));
/*     */     
/* 117 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.leaderid), Long.valueOf(this.partnerid) }));
/*     */     
/*     */ 
/* 120 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamid.longValue(), true);
/* 121 */     if (teamInfo == null)
/*     */     {
/*     */ 
/* 124 */       Map<String, Object> extraInfo = new HashMap();
/* 125 */       extraInfo.put("teamid", teamid);
/* 126 */       onFail(5, extraInfo);
/* 127 */       return false;
/*     */     }
/* 129 */     List<Long> memberList = teamInfo.getTeamMemberList();
/* 130 */     if (memberList.size() != 2)
/*     */     {
/*     */ 
/* 133 */       Map<String, Object> extraInfo = new HashMap();
/* 134 */       extraInfo.put("teamid", teamid);
/* 135 */       extraInfo.put("memberlist", memberList);
/* 136 */       onFail(2, extraInfo);
/* 137 */       return false;
/*     */     }
/* 139 */     if (this.leaderid != ((Long)memberList.get(0)).longValue())
/*     */     {
/*     */ 
/* 142 */       Map<String, Object> extraInfo = new HashMap();
/* 143 */       extraInfo.put("teamid", teamid);
/* 144 */       extraInfo.put("memberlist", memberList);
/* 145 */       onFail(3, extraInfo);
/* 146 */       return false;
/*     */     }
/* 148 */     if (this.partnerid != ((Long)memberList.get(1)).longValue())
/*     */     {
/*     */ 
/* 151 */       Map<String, Object> extraInfo = new HashMap();
/* 152 */       extraInfo.put("teamid", teamid);
/* 153 */       extraInfo.put("memberlist", memberList);
/* 154 */       onFail(4, extraInfo);
/* 155 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 159 */     if (MarriageInterface.getMarriedRoleid(this.partnerid, true) != this.leaderid)
/*     */     {
/*     */ 
/* 162 */       onFail(6, null);
/* 163 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 167 */     int currentPoint = ChildrenInterface.isCanCouplePreparePregnant(this.leaderid, this.partnerid, true);
/* 168 */     if (currentPoint < 0)
/*     */     {
/*     */ 
/* 171 */       onFail(11, null);
/* 172 */       return false;
/*     */     }
/* 174 */     if (currentPoint >= BubbleGameInterface.getBubbleGamePointUpperLimit(PreparePregnancyConsts.getInstance().BUBBLE_GAME_ID))
/*     */     {
/*     */ 
/* 177 */       onFail(12, null);
/* 178 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 182 */     Map<Long, String> userids = new HashMap();
/* 183 */     userids.put(Long.valueOf(this.leaderid), leaderUserid);
/* 184 */     userids.put(Long.valueOf(this.partnerid), partnerUserid);
/* 185 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userids, memberList, PreparePregnancyConsts.getInstance().ACTIVITY_CFG_ID);
/*     */     
/* 187 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/* 189 */       Map<String, Object> extraInfo = new HashMap();
/* 190 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/* 191 */       onFail(7, extraInfo);
/* 192 */       return false;
/*     */     }
/*     */     
/* 195 */     InviteSession session = new InviteSession(PreparePregnancyConsts.getInstance().INVITE_TIMEOUT_TIME, this.leaderid, this.partnerid, MarriageInterface.getMarriedId(this.leaderid, true));
/*     */     
/*     */ 
/* 198 */     STransmitAttendPreparePregnancyInvite protocol = new STransmitAttendPreparePregnancyInvite();
/* 199 */     protocol.inviterid = this.leaderid;
/* 200 */     protocol.sessionid = session.getSessionId();
/* 201 */     OnlineManager.getInstance().sendMulti(protocol, memberList);
/*     */     
/* 203 */     StringBuilder sb = new StringBuilder();
/* 204 */     sb.append(String.format("[prepare_pregnancy]PCAttendPreparePregnancy.processImp@attend prepare pregnancy success|leaderid=%d|partnerid=%d", new Object[] { Long.valueOf(this.leaderid), Long.valueOf(this.partnerid) }));
/*     */     
/*     */ 
/* 207 */     PreparePregnancyManager.logger.info(sb.toString());
/* 208 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 213 */     StringBuilder sb = new StringBuilder();
/* 214 */     sb.append(String.format("[prepare_pregnancy]PCAttendPreparePregnancy.processImp@attend prepare pregnancy fail|leaderid=%d|partnerid=%d|res=%d", new Object[] { Long.valueOf(this.leaderid), Long.valueOf(this.partnerid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 217 */     if (extraInfo != null)
/*     */     {
/* 219 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 221 */         sb.append("|").append((String)entry.getKey());
/* 222 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 225 */     PreparePregnancyManager.logger.info(sb.toString());
/* 226 */     if (res > 0)
/*     */     {
/* 228 */       SAttendPreparePregnancyFail protocol = new SAttendPreparePregnancyFail();
/* 229 */       protocol.res = res;
/* 230 */       OnlineManager.getInstance().sendAtOnce(this.leaderid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\preparepregnancy\PCAttendPreparePregnancy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */