/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.shitu.SShouTuSuccess;
/*     */ import mzm.gsp.shitu.confbean.ShiTuConsts;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ApprenticeInfo;
/*     */ import xbean.MasterInfo;
/*     */ import xbean.ShiTuTimeInfo;
/*     */ import xbean.role2ShiTuInfo;
/*     */ import xtable.Role2shitu;
/*     */ 
/*     */ public class PCShouTuReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCShouTuReq(long roleId)
/*     */   {
/*  26 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcServiceIgnoreNpcLocationCond(ShiTuConsts.getInstance().shiTuNPCId, ShiTuConsts.getInstance().shouTuNpcServiceId, this.roleId))
/*     */     {
/*     */ 
/*  35 */       GameServer.logger().error(String.format("[coupledaily]PCShouTuReq.processImp@npc service is not useable|npc_id=%d|service_id=%d|leader_role_id=%d", new Object[] { Integer.valueOf(ShiTuConsts.getInstance().shiTuNPCId), Integer.valueOf(ShiTuConsts.getInstance().shouTuNpcServiceId), Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/*     */ 
/*  39 */       return false;
/*     */     }
/*  41 */     if (!ShiTuManager.isShiTuSwitchOpen(this.roleId, "PCShouTuReq.processImp"))
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, false);
/*     */     
/*  48 */     if (teamId == null)
/*     */     {
/*     */ 
/*  51 */       GameServer.logger().error(String.format("[shitu]PCShouTuReq.processImp@team not exist|master_role_id=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     List<Long> selectTeamMembers = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*     */     
/*  57 */     if (selectTeamMembers.size() != 2)
/*     */     {
/*  59 */       GameServer.logger().error(String.format("[shitu]PCShouTuReq.processImp@select team size not equal 2|master_role_id=%d|team_size=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(selectTeamMembers.size()) }));
/*     */       
/*     */ 
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     long masterRoleId = ((Long)selectTeamMembers.get(0)).longValue();
/*  66 */     long apprenticeRoleId = ((Long)selectTeamMembers.get(1)).longValue();
/*     */     
/*  68 */     String masterUserId = RoleInterface.getUserId(masterRoleId);
/*  69 */     String apprenticeUserId = RoleInterface.getUserId(apprenticeRoleId);
/*  70 */     lock(xtable.User.getTable(), Arrays.asList(new String[] { masterUserId, apprenticeUserId }));
/*     */     
/*  72 */     lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(masterRoleId), Long.valueOf(apprenticeRoleId) }));
/*     */     
/*     */ 
/*  75 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1724, true, true))
/*     */     {
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), true);
/*  81 */     if (teamInfo == null)
/*     */     {
/*  83 */       GameServer.logger().error(String.format("[shitu]PCShouTuReq.processImp@team not exist|apprentice_role_id=%d|team_id=%d", new Object[] { Long.valueOf(apprenticeRoleId), teamId }));
/*     */       
/*     */ 
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     List<Long> teamMembers = teamInfo.getTeamMemberList();
/*     */     
/*  91 */     if (teamMembers.size() != 2)
/*     */     {
/*  93 */       GameServer.logger().error(String.format("[shitu]PCShouTuReq.processImp@team size not equal 2|master_role_id=%d|team_size=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(selectTeamMembers.size()) }));
/*     */       
/*     */ 
/*  96 */       return false;
/*     */     }
/*  98 */     if ((masterRoleId != ((Long)teamMembers.get(0)).longValue()) || (apprenticeRoleId != ((Long)teamMembers.get(1)).longValue()) || (this.roleId != masterRoleId))
/*     */     {
/* 100 */       GameServer.logger().error(String.format("[shitu]PCShouTuReq.processImp@team info exchange|master_role_id=%d|apprentice_role_id=%d|role_id=%d|team_list_0=%d|team_list_1=%d", new Object[] { Long.valueOf(masterRoleId), Long.valueOf(apprenticeRoleId), Long.valueOf(this.roleId), teamMembers.get(0), teamMembers.get(1) }));
/*     */       
/*     */ 
/*     */ 
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     if (((Long)teamMembers.get(0)).longValue() != this.roleId)
/*     */     {
/* 109 */       GameServer.logger().error(String.format("[shitu]PCShouTuReq.processImp@master is not team leader|master_role_id=%d|apprentice_role_id=%d|leader_role_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(apprenticeRoleId), teamMembers.get(0) }));
/*     */       
/*     */ 
/*     */ 
/* 113 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 117 */     int masterStatus = teamInfo.getMemberStatus(masterRoleId);
/* 118 */     int apprenticeStatus = teamInfo.getMemberStatus(apprenticeRoleId);
/* 119 */     if ((apprenticeStatus != 0) || (masterStatus != 0))
/*     */     {
/* 121 */       GameServer.logger().error(String.format("[shitu]PCShouTuReq.processImp@team member status is not normal|master_role_id=%d|master_role_status=%d|apprentice_role_id=%d|apprentice_role_status=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(masterStatus), Long.valueOf(apprenticeRoleId), Integer.valueOf(apprenticeStatus) }));
/*     */       
/*     */ 
/*     */ 
/* 125 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 129 */     int apprenticeRoleLevel = RoleInterface.getLevel(apprenticeRoleId);
/* 130 */     int masterRoleLevel = RoleInterface.getLevel(this.roleId);
/* 131 */     if ((apprenticeRoleLevel < ShiTuConsts.getInstance().apprenticeMinLevel) || (masterRoleLevel < apprenticeRoleLevel + ShiTuConsts.getInstance().minHighLevel))
/*     */     {
/*     */ 
/* 134 */       GameServer.logger().error(String.format("[shitu]PCShouTuReq.processImp@role level is not match|master_role_id=%d|master_role_level=%d|apprentice_role_id=%d|apprentice_role_level=%d|min_high_level=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(masterRoleLevel), Long.valueOf(apprenticeRoleId), Integer.valueOf(apprenticeRoleLevel), Integer.valueOf(ShiTuConsts.getInstance().minHighLevel) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 139 */       return false;
/*     */     }
/*     */     
/* 142 */     role2ShiTuInfo xMasterShiTuInfo = Role2shitu.get(Long.valueOf(masterRoleId));
/*     */     
/* 144 */     if (xMasterShiTuInfo == null)
/*     */     {
/* 146 */       GameServer.logger().error(String.format("[shitu]PCShouTuReq.processImp@master shi tu info is null|master_role_id=%d|apprentice_role_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(apprenticeRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 150 */       return false;
/*     */     }
/*     */     
/* 153 */     MasterInfo xMasterInfo = xMasterShiTuInfo.getMasterinfo();
/* 154 */     int nowApprenticeSize = xMasterInfo.getApprentice_now().size();
/* 155 */     if (nowApprenticeSize >= ShiTuConsts.getInstance().maxApprenticeNum)
/*     */     {
/* 157 */       GameServer.logger().error(String.format("[shitu]PCShouTuReq.processImp@apprentice num is full|master_role_id=%d|now_apprentice_size=%d|apprentice_role_id=%d|max_apprentice_num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(nowApprenticeSize), Long.valueOf(apprenticeRoleId), Integer.valueOf(ShiTuConsts.getInstance().maxApprenticeNum) }));
/*     */       
/*     */ 
/*     */ 
/* 161 */       return false;
/*     */     }
/*     */     
/* 164 */     role2ShiTuInfo xApprenticeShiTuInfo = Role2shitu.get(Long.valueOf(apprenticeRoleId));
/*     */     
/* 166 */     if (xApprenticeShiTuInfo == null)
/*     */     {
/* 168 */       GameServer.logger().error(String.format("[shitu]PCShouTuReq.processImp@apprentice shi tu info is null|master_role_id=%d|apprentice_role_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(apprenticeRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 172 */       return false;
/*     */     }
/* 174 */     String logString = "PCShouTuReq.processImp";
/*     */     
/* 176 */     if (ShiTuManager.checkIsInPunishTime(masterRoleId, apprenticeRoleId, xMasterInfo, xApprenticeShiTuInfo.getMasterinfo(), "PCShouTuReq.processImp", true))
/*     */     {
/*     */ 
/* 179 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 183 */     if (ShiTuManager.checkIsHasShiTuRelation(masterRoleId, apprenticeRoleId, xApprenticeShiTuInfo.getMasterinfo(), xMasterInfo, "PCShouTuReq.processImp", true))
/*     */     {
/*     */ 
/* 186 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 190 */     ApprenticeInfo xApprenticeInfo = xApprenticeShiTuInfo.getApprenticeinfo();
/* 191 */     if (xApprenticeInfo.getMasterroleid() != 0L)
/*     */     {
/* 193 */       GameServer.logger().error(String.format("[shitu]PCShouTuReq.processImp@apprentice aleardy has master or has chu shi once|master_role_id=%d|start_time=%d|end_time=%d|graduate_times=%d|apprentice_role_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(xApprenticeInfo.getTimeinfo().getStarttime()), Long.valueOf(xApprenticeInfo.getTimeinfo().getEndtime()), Integer.valueOf(xApprenticeShiTuInfo.getGraduatetimes()), Long.valueOf(apprenticeRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 198 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 202 */     int relationValue = FriendInterface.getRelationValue(this.roleId, apprenticeRoleId, true);
/* 203 */     if (relationValue < ShiTuConsts.getInstance().minQinMiDu)
/*     */     {
/* 205 */       GameServer.logger().error(String.format("[shitu]PCShouTuReq.processImp@qin mi du not enough|master_role_id=%d|apprentice_role_id=%d|relation_value=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(apprenticeRoleId), Integer.valueOf(relationValue) }));
/*     */       
/*     */ 
/*     */ 
/* 209 */       return false;
/*     */     }
/*     */     
/* 212 */     long sessionid = new ShouTuSession(ShiTuConsts.getInstance().waitSeconds, this.roleId, apprenticeRoleId).getSessionId();
/*     */     
/* 214 */     SShouTuSuccess sShouTuSuccess = new SShouTuSuccess();
/* 215 */     sShouTuSuccess.masterroleid = this.roleId;
/* 216 */     sShouTuSuccess.masterrolename = RoleInterface.getName(this.roleId);
/* 217 */     sShouTuSuccess.sessionid = sessionid;
/*     */     
/* 219 */     OnlineManager.getInstance().sendMulti(sShouTuSuccess, teamMembers);
/*     */     
/* 221 */     GameServer.logger().info(String.format("[shitu]PCShouTuReq.processImp@handle shou tu req success|master_role_id=%d|apprentice_role_id=%d|session_id=%d", new Object[] { Long.valueOf(masterRoleId), Long.valueOf(apprenticeRoleId), Long.valueOf(sessionid) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 226 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PCShouTuReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */