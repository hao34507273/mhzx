/*     */ package mzm.gsp.qingyuan.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingyuan.SMakeQingYuanRelationSuccess;
/*     */ import mzm.gsp.qingyuan.confbean.QingYuanConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.QingYuanRoleInfo;
/*     */ import xbean.Role2QingYuanInfo;
/*     */ import xtable.Role2properties;
/*     */ import xtable.Role2qingyuan;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCMakeQingYuanRelation
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long teamLeaderRoleId;
/*     */   private long teamMemberRoleId;
/*     */   
/*     */   public PCMakeQingYuanRelation(long teamLeaderRoleId)
/*     */   {
/*  37 */     this.teamLeaderRoleId = teamLeaderRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     if (!NpcInterface.checkNpcServiceIgnoreNpcLocationCond(QingYuanConsts.getInstance().qingYuanNpcId, QingYuanConsts.getInstance().makeQingYuanNpcServiceId, this.teamLeaderRoleId))
/*     */     {
/*     */ 
/*  46 */       GameServer.logger().error(String.format("[qingyuan]PCMakeQingYuanRelation.processImp@npc service is not useable|npc_id=%d|service_id=%d|apprentice_role_id=%d", new Object[] { Integer.valueOf(QingYuanConsts.getInstance().qingYuanNpcId), Integer.valueOf(QingYuanConsts.getInstance().makeQingYuanNpcServiceId), Long.valueOf(this.teamLeaderRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     if (!QingYuanManager.isQingYuanSwitchOpen(this.teamLeaderRoleId, "PCMakeQingYuanRelation.processImp"))
/*     */     {
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     Long teamId = TeamInterface.getTeamidByRoleid(this.teamLeaderRoleId, false);
/*     */     
/*  61 */     if (teamId == null)
/*     */     {
/*     */ 
/*  64 */       GameServer.logger().error(String.format("[qingyuan]PCMakeQingYuanRelation.processImp@team not exist|team_leader_role_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  68 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 9, new ArrayList());
/*     */       
/*     */ 
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     List<Long> selectTeamMembers = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*     */     
/*  76 */     if (selectTeamMembers.size() != 2)
/*     */     {
/*  78 */       GameServer.logger().error(String.format("[qingyuan]PCMakeQingYuanRelation.processImp@select team size not equal 2|team_leader_role_id=%d|team_size=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Integer.valueOf(selectTeamMembers.size()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  83 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 3, new ArrayList());
/*     */       
/*     */ 
/*  86 */       return false;
/*     */     }
/*  88 */     this.teamMemberRoleId = ((Long)selectTeamMembers.get(1)).longValue();
/*     */     
/*  90 */     String teamLeaderUserId = RoleInterface.getUserId(this.teamLeaderRoleId);
/*  91 */     String teamMemberUserId = RoleInterface.getUserId(this.teamMemberRoleId);
/*     */     
/*     */ 
/*  94 */     lock(User.getTable(), Arrays.asList(new String[] { teamLeaderUserId, teamMemberUserId }));
/*     */     
/*     */ 
/*  97 */     lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId) }));
/*     */     
/*  99 */     if (!RoleStatusInterface.checkCanSetStatus(this.teamLeaderRoleId, 1704, true, true))
/*     */     {
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), true);
/* 105 */     if (teamInfo == null)
/*     */     {
/* 107 */       GameServer.logger().error(String.format("[qingyuan]PCMakeQingYuanRelation.processImp@team not exist|team_leader_role_id=%d|team_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), teamId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 112 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 9, new ArrayList());
/*     */       
/*     */ 
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     List<Long> teamMembers = teamInfo.getTeamMemberList();
/*     */     
/* 120 */     if (teamMembers.size() != 2)
/*     */     {
/* 122 */       GameServer.logger().error(String.format("[qingyuan]PCMakeQingYuanRelation.processImp@team size not equal 2|team_leader_role_id=%d|team_size=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Integer.valueOf(selectTeamMembers.size()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 127 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 3, new ArrayList());
/*     */       
/*     */ 
/* 130 */       return false;
/*     */     }
/*     */     
/* 133 */     if ((this.teamLeaderRoleId != ((Long)teamMembers.get(0)).longValue()) || (this.teamMemberRoleId != ((Long)teamMembers.get(1)).longValue()))
/*     */     {
/* 135 */       GameServer.logger().error(String.format("[qingyuan]PCMakeQingYuanRelation.processImp@team info exchange|team_leader_role_id=%d|team_member_role_id=%d|team_list_0=%d|team_list_1=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId), teamMembers.get(0), teamMembers.get(1) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 140 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 9, new ArrayList());
/*     */       
/*     */ 
/* 143 */       return false;
/*     */     }
/*     */     
/* 146 */     int teamLeaderStatus = teamInfo.getMemberStatus(this.teamLeaderRoleId);
/* 147 */     int teamMemberStatus = teamInfo.getMemberStatus(this.teamMemberRoleId);
/* 148 */     if ((teamLeaderStatus != 0) || (teamMemberStatus != 0))
/*     */     {
/* 150 */       GameServer.logger().error(String.format("[qingyuan]PCMakeQingYuanRelation.processImp@team member status is not normal|team_leader_role_id=%d|team_member_role_id=%d|team_leader_role_status=%d|team_member_role_status=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId), Integer.valueOf(teamLeaderStatus), Integer.valueOf(teamMemberStatus) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 155 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 8, new ArrayList());
/*     */       
/*     */ 
/* 158 */       return false;
/*     */     }
/*     */     
/* 161 */     int teamLeaderRoleLevel = RoleInterface.getLevel(this.teamLeaderRoleId);
/* 162 */     int teamMemberRoleLevel = RoleInterface.getLevel(this.teamMemberRoleId);
/*     */     
/* 164 */     int minQingYuanRoleLevel = QingYuanConsts.getInstance().minRoleLevel;
/* 165 */     if ((teamLeaderRoleLevel < minQingYuanRoleLevel) || (teamMemberRoleLevel < minQingYuanRoleLevel))
/*     */     {
/* 167 */       GameServer.logger().error(String.format("[qingyuan]PCMakeQingYuanRelation.processImp@role level not enough|need_min_level=%d|team_leader_role_level=%d|team_member_role_level=%d|team_leader_role_id=%d|team_member_role_id=%d", new Object[] { Integer.valueOf(minQingYuanRoleLevel), Integer.valueOf(teamLeaderRoleLevel), Integer.valueOf(teamMemberRoleLevel), Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 173 */       List<String> paramsList = new ArrayList();
/* 174 */       paramsList.add(String.valueOf(minQingYuanRoleLevel));
/*     */       
/* 176 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 5, paramsList);
/* 177 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 181 */     int relationValue = FriendInterface.getRelationValue(this.teamLeaderRoleId, this.teamMemberRoleId, true);
/* 182 */     int minRelationValue = QingYuanConsts.getInstance().minFriendValue;
/* 183 */     if (relationValue < minRelationValue)
/*     */     {
/* 185 */       GameServer.logger().error(String.format("[qingyuan]PCMakeQingYuanRelation.processImp@friend not enough|team_leader_role_id=%d|team_member_role_id=%d|relation_value=%d|need_relation_value=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId), Integer.valueOf(relationValue), Integer.valueOf(minRelationValue) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 190 */       List<String> paramsList = new ArrayList();
/* 191 */       paramsList.add(String.valueOf(minRelationValue));
/*     */       
/* 193 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 5, paramsList);
/*     */       
/* 195 */       return false;
/*     */     }
/*     */     
/* 198 */     boolean isMarriageRelation = MarriageInterface.isMarriageRelation(this.teamLeaderRoleId, this.teamMemberRoleId);
/* 199 */     if (isMarriageRelation)
/*     */     {
/* 201 */       GameServer.logger().error(String.format("[qingyuan]PCMakeQingYuanRelation.processImp@aleardy is couple|team_leader_role_id=%d|team_member_role_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 206 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 6, new ArrayList());
/*     */       
/*     */ 
/* 209 */       return false;
/*     */     }
/*     */     
/* 212 */     Role2QingYuanInfo xLeaderRole2QingYuanInfo = Role2qingyuan.get(Long.valueOf(this.teamLeaderRoleId));
/* 213 */     if (xLeaderRole2QingYuanInfo == null)
/*     */     {
/* 215 */       xLeaderRole2QingYuanInfo = Pod.newRole2QingYuanInfo();
/* 216 */       Role2qingyuan.add(Long.valueOf(this.teamLeaderRoleId), xLeaderRole2QingYuanInfo);
/*     */     }
/*     */     
/* 219 */     Role2QingYuanInfo xMemberRole2QingYuanInfo = Role2qingyuan.get(Long.valueOf(this.teamMemberRoleId));
/* 220 */     if (xMemberRole2QingYuanInfo == null)
/*     */     {
/* 222 */       xMemberRole2QingYuanInfo = Pod.newRole2QingYuanInfo();
/* 223 */       Role2qingyuan.add(Long.valueOf(this.teamMemberRoleId), xMemberRole2QingYuanInfo);
/*     */     }
/*     */     
/* 226 */     Map<Long, QingYuanRoleInfo> xLeaderQingYuanRoleMapInfo = xLeaderRole2QingYuanInfo.getQing_yuan_map_info();
/*     */     
/* 228 */     if (xLeaderQingYuanRoleMapInfo.containsKey(Long.valueOf(this.teamMemberRoleId)))
/*     */     {
/* 230 */       GameServer.logger().error(String.format("[qingyuan]PCMakeQingYuanRelation.processImp@aleardy is qing yuan relation|team_leader_role_id=%d|team_member_role_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 235 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 6, new ArrayList());
/*     */       
/*     */ 
/* 238 */       return false;
/*     */     }
/*     */     
/* 241 */     if (xLeaderQingYuanRoleMapInfo.size() >= QingYuanConsts.getInstance().maxQingYuanRelationNum)
/*     */     {
/* 243 */       GameServer.logger().error(String.format("[qingyuan]PCMakeQingYuanRelation.processImp@leader qing yuan relation size not enough|team_leader_role_id=%d|team_member_role_id=%d|leader_now_qing_yuan_size=%d|limit_size=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId), Integer.valueOf(xLeaderQingYuanRoleMapInfo.size()), Integer.valueOf(QingYuanConsts.getInstance().maxQingYuanRelationNum) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 249 */       String teamLeaderName = RoleInterface.getName(this.teamLeaderRoleId);
/* 250 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 1, Arrays.asList(new String[] { teamLeaderName }));
/*     */       
/*     */ 
/* 253 */       return false;
/*     */     }
/*     */     
/* 256 */     Map<Long, QingYuanRoleInfo> xMemberQingYuanRoleMapInfo = xMemberRole2QingYuanInfo.getQing_yuan_map_info();
/*     */     
/* 258 */     if (xMemberQingYuanRoleMapInfo.size() >= QingYuanConsts.getInstance().maxQingYuanRelationNum)
/*     */     {
/* 260 */       GameServer.logger().error(String.format("[qingyuan]PCMakeQingYuanRelation.processImp@member qing yuan relation size not enough|team_leader_role_id=%d|team_member_role_id=%d|leader_now_qing_yuan_size=%d|limit_size=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId), Integer.valueOf(xLeaderQingYuanRoleMapInfo.size()), Integer.valueOf(QingYuanConsts.getInstance().maxQingYuanRelationNum) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 266 */       String teamMemberName = RoleInterface.getName(this.teamMemberRoleId);
/* 267 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 1, Arrays.asList(new String[] { teamMemberName }));
/*     */       
/*     */ 
/* 270 */       return false;
/*     */     }
/*     */     
/* 273 */     long sessionId = new QingYuanConfirmSession(QingYuanConsts.getInstance().waitSeconds, this.teamLeaderRoleId, this.teamMemberRoleId).getSessionId();
/*     */     
/*     */ 
/* 276 */     SMakeQingYuanRelationSuccess sMakeQingYuanRelationSuccess = new SMakeQingYuanRelationSuccess();
/* 277 */     sMakeQingYuanRelationSuccess.sessionid = sessionId;
/* 278 */     sMakeQingYuanRelationSuccess.team_leader_role_id = this.teamLeaderRoleId;
/* 279 */     sMakeQingYuanRelationSuccess.team_member_role_id = this.teamMemberRoleId;
/*     */     
/* 281 */     OnlineManager.getInstance().sendMulti(sMakeQingYuanRelationSuccess, Arrays.asList(new Long[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId) }));
/*     */     
/*     */ 
/* 284 */     GameServer.logger().info(String.format("[qingyuan]PCMakeQingYuanRelation.processImp@make handle qing yuan relation req success|team_leader_role_id=%d|team_member_role_id=%d|session_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId), Long.valueOf(sessionId) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 289 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\main\PCMakeQingYuanRelation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */