/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.shitu.SAgreeOrRefuseShouTu;
/*     */ import mzm.gsp.shitu.SSynShiTuTaskInfo;
/*     */ import mzm.gsp.shitu.ShiTuActiveInfo;
/*     */ import mzm.gsp.shitu.SynShiTuActiveInfo;
/*     */ import mzm.gsp.shitu.confbean.ShiTuConsts;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.title.main.TitleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ApprenticeInfo;
/*     */ import xbean.MasterInfo;
/*     */ import xbean.ShiTuTimeInfo;
/*     */ import xbean.role2ShiTuInfo;
/*     */ import xtable.Role2shitu;
/*     */ 
/*     */ public class PCAgreeOrRefuseShouTu extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final int operator;
/*     */   private final long roleId;
/*     */   private final long sessionId;
/*     */   
/*     */   public PCAgreeOrRefuseShouTu(int operator, long roleId, long sessionId)
/*     */   {
/*  32 */     this.operator = operator;
/*  33 */     this.roleId = roleId;
/*  34 */     this.sessionId = sessionId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if ((this.operator != 1) && (this.operator != 0))
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if (!ShiTuManager.isShiTuSwitchOpen(this.roleId, "PCAgreeOrRefuseShouTu.processImp"))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     mzm.gsp.timer.main.Session session = ShouTuSession.getSession(this.sessionId);
/*  51 */     ShouTuSession shouTuSession = null;
/*     */     
/*  53 */     if ((session instanceof ShouTuSession))
/*     */     {
/*  55 */       shouTuSession = (ShouTuSession)session;
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  60 */       GameServer.logger().error(String.format("[shitu]PCAgreeOrRefuseShouTu.processImp@session is not exist|apprentice_role_id=%d|operator=%d|session_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.operator), Long.valueOf(this.sessionId) }));
/*     */       
/*     */ 
/*     */ 
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, false);
/*  68 */     if (teamId == null)
/*     */     {
/*     */ 
/*  71 */       GameServer.logger().error(String.format("[shitu]PCAgreeOrRefuseShouTu.processImp@team not exist|apprentice_role_id=%d|operator=%d|session_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.operator), Long.valueOf(this.sessionId) }));
/*     */       
/*     */ 
/*     */ 
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     List<Long> selectTeamMembers = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*     */     
/*  80 */     if (selectTeamMembers.size() != 2)
/*     */     {
/*  82 */       GameServer.logger().error(String.format("[shitu]PCAgreeOrRefuseShouTu.processImp@select team size not equal 2|apprentice_role_id=%d|team_size=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(selectTeamMembers.size()) }));
/*     */       
/*     */ 
/*     */ 
/*  86 */       return false;
/*     */     }
/*  88 */     long masterRoleId = ((Long)selectTeamMembers.get(0)).longValue();
/*  89 */     long apprenticeRoleId = ((Long)selectTeamMembers.get(1)).longValue();
/*     */     
/*     */ 
/*  92 */     String masterUserId = RoleInterface.getUserId(masterRoleId);
/*  93 */     String apprenticeUserId = RoleInterface.getUserId(apprenticeRoleId);
/*  94 */     lock(xtable.User.getTable(), Arrays.asList(new String[] { masterUserId, apprenticeUserId }));
/*     */     
/*     */ 
/*  97 */     lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(masterRoleId), Long.valueOf(apprenticeRoleId) }));
/*     */     
/*     */ 
/* 100 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1711, true, true))
/*     */     {
/* 102 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 106 */     if (ShouTuSession.getSession(this.sessionId) == null)
/*     */     {
/* 108 */       GameServer.logger().error(String.format("[shitu]PCAgreeOrRefuseShouTu.processImp@time out or session has removed|master_role_id=%d|apprentice_role_id=%d|session_master_role_id=%d|session_apprentice_role_id=%d|session_id=%d", new Object[] { Long.valueOf(masterRoleId), Long.valueOf(apprenticeRoleId), Long.valueOf(shouTuSession.getRoleid()), Long.valueOf(shouTuSession.getApprenticeRoleId()), Long.valueOf(this.sessionId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 113 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 117 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), true);
/* 118 */     if (teamInfo == null)
/*     */     {
/* 120 */       GameServer.logger().error(String.format("[shitu]PCAgreeOrRefuseShouTu.processImp@team not exist|apprentice_role_id=%d|master_role_id=%d|team_id=%d", new Object[] { Long.valueOf(apprenticeRoleId), Long.valueOf(masterRoleId), teamId }));
/*     */       
/*     */ 
/*     */ 
/* 124 */       return false;
/*     */     }
/* 126 */     List<Long> teamMembers = teamInfo.getTeamMemberList();
/*     */     
/* 128 */     if (teamMembers.size() != 2)
/*     */     {
/* 130 */       GameServer.logger().error(String.format("[shitu]PCAgreeOrRefuseShouTu.processImp@team size not equal 2|apprentice_role_id=%d|master_role_id=%d|team_size=%d", new Object[] { Long.valueOf(apprenticeRoleId), Long.valueOf(masterRoleId), Integer.valueOf(teamMembers.size()) }));
/*     */       
/*     */ 
/*     */ 
/* 134 */       return false;
/*     */     }
/*     */     
/* 137 */     if ((masterRoleId != ((Long)teamMembers.get(0)).longValue()) || (apprenticeRoleId != ((Long)teamMembers.get(1)).longValue()) || (this.roleId != apprenticeRoleId))
/*     */     {
/* 139 */       GameServer.logger().error(String.format("[shitu]PCAgreeOrRefuseShouTu.processImp@team info exchange|master_role_id=%d|apprentice_role_id=%d|role_id=%d|team_list_0=%d|team_list_1=%d", new Object[] { Long.valueOf(masterRoleId), Long.valueOf(apprenticeRoleId), Long.valueOf(this.roleId), teamMembers.get(0), teamMembers.get(1) }));
/*     */       
/*     */ 
/*     */ 
/* 143 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 147 */     if ((shouTuSession.getRoleid() != masterRoleId) || (shouTuSession.getApprenticeRoleId() != apprenticeRoleId))
/*     */     {
/* 149 */       GameServer.logger().error(String.format("[shitu]PCAgreeOrRefuseShouTu.processImp@session context not match|master_role_id=%d|apprentice_role_id=%d|session_master_role_id=%d|session_apprentice_role_id=%d|session_id=%d", new Object[] { Long.valueOf(masterRoleId), Long.valueOf(apprenticeRoleId), Long.valueOf(shouTuSession.getRoleid()), Long.valueOf(shouTuSession.getApprenticeRoleId()), Long.valueOf(this.sessionId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 154 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 158 */     int masterStatus = teamInfo.getMemberStatus(masterRoleId);
/* 159 */     int apprenticeStatus = teamInfo.getMemberStatus(apprenticeRoleId);
/* 160 */     if ((apprenticeStatus != 0) || (masterStatus != 0))
/*     */     {
/* 162 */       GameServer.logger().error(String.format("[shitu]PCAgreeOrRefuseShouTu.processImp@team member status is not normal|master_role_id=%d|master_role_status=%d|apprentice_role_id=%d|apprentice_role_status=%d", new Object[] { Long.valueOf(masterRoleId), Integer.valueOf(masterStatus), Long.valueOf(apprenticeRoleId), Integer.valueOf(apprenticeStatus) }));
/*     */       
/*     */ 
/*     */ 
/* 166 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 170 */     int apprenticeRoleLevel = RoleInterface.getLevel(apprenticeRoleId);
/* 171 */     int masterRoleLevel = RoleInterface.getLevel(masterRoleId);
/* 172 */     if ((apprenticeRoleLevel < ShiTuConsts.getInstance().apprenticeMinLevel) || (masterRoleLevel < apprenticeRoleLevel + ShiTuConsts.getInstance().minHighLevel))
/*     */     {
/*     */ 
/* 175 */       GameServer.logger().error(String.format("[shitu]PCAgreeOrRefuseShouTu.processImp@role level is not match|master_role_id=%d|master_role_level=%d|apprentice_role_id=%d|apprentice_role_level=%d|min_high_level=%d", new Object[] { Long.valueOf(masterRoleId), Integer.valueOf(masterRoleLevel), Long.valueOf(apprenticeRoleId), Integer.valueOf(apprenticeRoleLevel), Integer.valueOf(ShiTuConsts.getInstance().minHighLevel) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 180 */       return false;
/*     */     }
/*     */     
/* 183 */     role2ShiTuInfo xMasterShiTuInfo = Role2shitu.get(Long.valueOf(masterRoleId));
/*     */     
/* 185 */     if (xMasterShiTuInfo == null)
/*     */     {
/* 187 */       GameServer.logger().error(String.format("[shitu]PCAgreeOrRefuseShouTu.processImp@master shi tu info is null|master_role_id=%d|apprentice_role_id=%d", new Object[] { Long.valueOf(masterRoleId), Long.valueOf(apprenticeRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 191 */       return false;
/*     */     }
/* 193 */     MasterInfo xMasterInfo = xMasterShiTuInfo.getMasterinfo();
/* 194 */     int nowApprenticeSize = xMasterInfo.getApprentice_now().size();
/*     */     
/* 196 */     if (nowApprenticeSize >= ShiTuConsts.getInstance().maxApprenticeNum)
/*     */     {
/* 198 */       GameServer.logger().error(String.format("[shitu]PCAgreeOrRefuseShouTu.processImp@apprentice num is full|master_role_id=%d|now_apprentice_size=%d|apprentice_role_id=%d|max_apprentice_num=%d", new Object[] { Long.valueOf(masterRoleId), Integer.valueOf(nowApprenticeSize), Long.valueOf(apprenticeRoleId), Integer.valueOf(ShiTuConsts.getInstance().maxApprenticeNum) }));
/*     */       
/*     */ 
/*     */ 
/* 202 */       return false;
/*     */     }
/*     */     
/* 205 */     role2ShiTuInfo xApprenticeShiTuInfo = Role2shitu.get(Long.valueOf(apprenticeRoleId));
/*     */     
/* 207 */     if (xApprenticeShiTuInfo == null)
/*     */     {
/* 209 */       GameServer.logger().error(String.format("[shitu]PCAgreeOrRefuseShouTu.processImp@apprentice shi tu info is null|master_role_id=%d|apprentice_role_id=%d", new Object[] { Long.valueOf(masterRoleId), Long.valueOf(apprenticeRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 213 */       return false;
/*     */     }
/* 215 */     String logString = "PCAgreeOrRefuseShouTu.processImp";
/*     */     
/*     */ 
/* 218 */     if (ShiTuManager.checkIsInPunishTime(masterRoleId, apprenticeRoleId, xMasterInfo, xApprenticeShiTuInfo.getMasterinfo(), "PCAgreeOrRefuseShouTu.processImp", true))
/*     */     {
/*     */ 
/* 221 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 225 */     if (ShiTuManager.checkIsHasShiTuRelation(masterRoleId, apprenticeRoleId, xApprenticeShiTuInfo.getMasterinfo(), xMasterInfo, "PCAgreeOrRefuseShouTu.processImp", true))
/*     */     {
/*     */ 
/* 228 */       return false;
/*     */     }
/*     */     
/* 231 */     ApprenticeInfo xApprenticeInfo = xApprenticeShiTuInfo.getApprenticeinfo();
/* 232 */     if (xApprenticeInfo.getMasterroleid() != 0L)
/*     */     {
/* 234 */       GameServer.logger().error(String.format("[shitu]PCAgreeOrRefuseShouTu.processImp@apprentice aleardy has master or has chu shi once|master_role_id=%d|graduate_times=%d|apprentice_role_id=%d", new Object[] { Long.valueOf(xApprenticeInfo.getMasterroleid()), Integer.valueOf(xApprenticeShiTuInfo.getGraduatetimes()), Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/*     */ 
/* 238 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 242 */     int relationValue = mzm.gsp.friend.main.FriendInterface.getRelationValue(masterRoleId, apprenticeRoleId, true);
/* 243 */     if (relationValue < ShiTuConsts.getInstance().minQinMiDu)
/*     */     {
/* 245 */       GameServer.logger().error(String.format("[shitu]PCAgreeOrRefuseShouTu.processImp@qin mi du not enough|master_role_id=%d|apprentice_role_id=%d|relation_value=%d", new Object[] { Long.valueOf(masterRoleId), Long.valueOf(apprenticeRoleId), Integer.valueOf(relationValue) }));
/*     */       
/*     */ 
/*     */ 
/* 249 */       return false;
/*     */     }
/* 251 */     ShouTuSession.removeSession(this.sessionId);
/*     */     
/* 253 */     String masterName = RoleInterface.getName(masterRoleId);
/* 254 */     String apprenticeName = RoleInterface.getName(apprenticeRoleId);
/*     */     
/* 256 */     SAgreeOrRefuseShouTu sAgreeOrRefuseShouTu = new SAgreeOrRefuseShouTu();
/* 257 */     sAgreeOrRefuseShouTu.operator = this.operator;
/* 258 */     ShiTuManager.setShiTuRoleInfoAndModelInfo(this.roleId, sAgreeOrRefuseShouTu.apprenticeroleinfo);
/* 259 */     ShiTuManager.setShiTuRoleInfoAndModelInfo(masterRoleId, sAgreeOrRefuseShouTu.masterroleinfo);
/*     */     
/*     */ 
/* 262 */     if (this.operator == 1)
/*     */     {
/* 264 */       long currentTimeMillis = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*     */       
/* 266 */       ShiTuTimeInfo xShiTuTimeInfo = xbean.Pod.newShiTuTimeInfo();
/* 267 */       xShiTuTimeInfo.setStarttime(currentTimeMillis);
/* 268 */       xMasterInfo.getApprentice_now().put(Long.valueOf(apprenticeRoleId), xShiTuTimeInfo);
/* 269 */       xMasterInfo.getNow_apprentice_role_list().add(Long.valueOf(apprenticeRoleId));
/*     */       
/* 271 */       xApprenticeInfo.setMasterroleid(masterRoleId);
/* 272 */       xApprenticeInfo.getTimeinfo().setStarttime(currentTimeMillis);
/*     */       
/* 274 */       int newApprenticeSize = nowApprenticeSize + 1;
/*     */       
/* 276 */       if ((newApprenticeSize == 1) && (xMasterInfo.getApprentice_graduate().size() == 0))
/*     */       {
/* 278 */         TitleInterface.addAppellation(masterRoleId, ShiTuConsts.getInstance().masterAppellationId);
/*     */       }
/*     */       
/* 281 */       TitleInterface.addAppellation(apprenticeRoleId, ShiTuConsts.getInstance().apprenticeAppellationId, Arrays.asList(new String[] { masterName }));
/*     */       
/*     */ 
/* 284 */       MasterRankManager.getInstance().rank(masterRoleId, newApprenticeSize + xMasterInfo.getApprentice_graduate().size());
/* 285 */       ShiTuManager.tlogShiTuRelation(apprenticeRoleId, masterRoleId, apprenticeRoleId, ShiTuRelationTLogEnum.SHOU_TU);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 290 */     OnlineManager.getInstance().sendMulti(sAgreeOrRefuseShouTu, teamMembers);
/*     */     
/*     */ 
/* 293 */     if (this.operator == 1)
/*     */     {
/*     */       SSynShiTuTaskInfo sSynShiTuTaskInfo;
/*     */       SSynShiTuTaskInfo sSynShiTuTaskInfo;
/* 297 */       if (ShiTuManager.isMaxPublishTimes(xMasterInfo))
/*     */       {
/* 299 */         sSynShiTuTaskInfo = ShiTuManager.changeShiTuTaskPublishState(apprenticeRoleId, 0, 7);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 304 */         sSynShiTuTaskInfo = ShiTuManager.getAndCheckResetShiTuTaskInfo(apprenticeRoleId);
/*     */       }
/*     */       
/* 307 */       OnlineManager.getInstance().sendMulti(sSynShiTuTaskInfo, selectTeamMembers);
/*     */       
/* 309 */       OnlineManager.getInstance().send(masterRoleId, new SynShiTuActiveInfo((ShiTuActiveInfo)ShiTuManager.getAndCheckResetShiTuActiveInfo(masterRoleId, Arrays.asList(new Long[] { Long.valueOf(apprenticeRoleId) })).get(0)));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 314 */       OnlineManager.getInstance().send(apprenticeRoleId, new SynShiTuActiveInfo((ShiTuActiveInfo)ShiTuManager.getAndCheckResetShiTuActiveInfo(apprenticeRoleId, Arrays.asList(new Long[] { Long.valueOf(apprenticeRoleId) })).get(0)));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 319 */       ShiTuManager.triggerBaishiEvent(masterRoleId, apprenticeRoleId, true);
/*     */     }
/*     */     
/* 322 */     GameServer.logger().info(String.format("[shitu]PCAgreeOrRefuseShouTu.processImp@handle agree or refuse shou tu req success|role_id=%d|operator=%d|session_id=%d|apprentice_role_name=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.operator), Long.valueOf(this.sessionId), apprenticeName }));
/*     */     
/*     */ 
/*     */ 
/* 326 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PCAgreeOrRefuseShouTu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */