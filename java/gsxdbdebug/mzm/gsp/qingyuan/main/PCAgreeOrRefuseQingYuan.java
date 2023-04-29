/*     */ package mzm.gsp.qingyuan.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingyuan.SAgreeOrRefuseQingYuan;
/*     */ import mzm.gsp.qingyuan.SQingYuanNormalFail;
/*     */ import mzm.gsp.qingyuan.confbean.QingYuanConsts;
/*     */ import mzm.gsp.qingyuan.confbean.SQingYuanAppelationCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.title.main.TitleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCAgreeOrRefuseQingYuan
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long teamMemberRoleId;
/*     */   private final int operator;
/*     */   private final long sessionId;
/*     */   private long teamLeaderRoleId;
/*     */   
/*     */   public PCAgreeOrRefuseQingYuan(long teamMemberRoleId, int operator, long sessionId)
/*     */   {
/*  53 */     this.teamMemberRoleId = teamMemberRoleId;
/*  54 */     this.operator = operator;
/*  55 */     this.sessionId = sessionId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  61 */     if (!QingYuanManager.isQingYuanSwitchOpen(this.teamMemberRoleId, "PCAgreeOrRefuseQingYuan.processImp"))
/*     */     {
/*  63 */       return false;
/*     */     }
/*  65 */     Long teamId = TeamInterface.getTeamidByRoleid(this.teamMemberRoleId, false);
/*     */     
/*  67 */     if (teamId == null)
/*     */     {
/*     */ 
/*  70 */       GameServer.logger().error(String.format("[qingyuan]PCAgreeOrRefuseQingYuan.processImp@team not exist|team_member_role_id=%d", new Object[] { Long.valueOf(this.teamMemberRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  74 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 9, new ArrayList());
/*     */       
/*     */ 
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     List<Long> selectTeamMembers = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*     */     
/*  82 */     if (selectTeamMembers.size() != 2)
/*     */     {
/*  84 */       GameServer.logger().error(String.format("[qingyuan]PCAgreeOrRefuseQingYuan.processImp@select team size not equal 2|team_member_role_id=%d|team_size=%d", new Object[] { Long.valueOf(this.teamMemberRoleId), Integer.valueOf(selectTeamMembers.size()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  89 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 3, new ArrayList());
/*     */       
/*     */ 
/*  92 */       return false;
/*     */     }
/*  94 */     this.teamLeaderRoleId = ((Long)selectTeamMembers.get(0)).longValue();
/*  95 */     String teamLeaderUserId = RoleInterface.getUserId(this.teamLeaderRoleId);
/*  96 */     String teamMemberUserId = RoleInterface.getUserId(this.teamMemberRoleId);
/*     */     
/*     */ 
/*  99 */     lock(User.getTable(), Arrays.asList(new String[] { teamLeaderUserId, teamMemberUserId }));
/*     */     
/*     */ 
/* 102 */     lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId) }));
/*     */     
/* 104 */     if (!RoleStatusInterface.checkCanSetStatus(this.teamMemberRoleId, 1701, true, true))
/*     */     {
/*     */ 
/* 107 */       return false;
/*     */     }
/*     */     
/* 110 */     QingYuanConfirmSession qingYuanConfirmSession = null;
/* 111 */     Session session = QingYuanConfirmSession.getSession(this.sessionId);
/* 112 */     if (!(session instanceof QingYuanConfirmSession))
/*     */     {
/* 114 */       GameServer.logger().error(String.format("[qingyuan]PCAgreeOrRefuseQingYuan.processImp@session not exist|team_leader_role_id=%d|team_member_role_id=%d|session_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId), Long.valueOf(this.sessionId) }));
/*     */       
/*     */ 
/*     */ 
/* 118 */       return false;
/*     */     }
/* 120 */     qingYuanConfirmSession = (QingYuanConfirmSession)session;
/*     */     
/* 122 */     if ((this.teamLeaderRoleId != qingYuanConfirmSession.getOwerId()) || (this.teamMemberRoleId != qingYuanConfirmSession.getTeamMemberRoleId()))
/*     */     {
/*     */ 
/* 125 */       GameServer.logger().error(String.format("[qingyuan]PCAgreeOrRefuseQingYuan.processImp@context not match|team_leader_role_id=%d|team_member_role_id=%d|session_id=%d|session_team_leader_role_id=%d|session_team_member_role_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId), Long.valueOf(this.sessionId), Long.valueOf(qingYuanConfirmSession.getOwerId()), Long.valueOf(qingYuanConfirmSession.getTeamMemberRoleId()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 131 */       return false;
/*     */     }
/*     */     
/* 134 */     Session.removeSession(this.sessionId);
/*     */     
/* 136 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), true);
/* 137 */     if (teamInfo == null)
/*     */     {
/* 139 */       GameServer.logger().error(String.format("[qingyuan]PCAgreeOrRefuseQingYuan.processImp@team not exist|team_leader_role_id=%d|team_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), teamId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 144 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 9, new ArrayList());
/*     */       
/*     */ 
/* 147 */       return false;
/*     */     }
/*     */     
/* 150 */     List<Long> teamMembers = teamInfo.getTeamMemberList();
/*     */     
/* 152 */     if (teamMembers.size() != 2)
/*     */     {
/* 154 */       GameServer.logger().error(String.format("[qingyuan]PCAgreeOrRefuseQingYuan.processImp@team size not equal 2|team_leader_role_id=%d|team_size=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Integer.valueOf(selectTeamMembers.size()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 159 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 3, new ArrayList());
/*     */       
/*     */ 
/* 162 */       return false;
/*     */     }
/*     */     
/* 165 */     if ((this.teamLeaderRoleId != ((Long)teamMembers.get(0)).longValue()) || (this.teamMemberRoleId != ((Long)teamMembers.get(1)).longValue()))
/*     */     {
/* 167 */       GameServer.logger().error(String.format("[qingyuan]PCAgreeOrRefuseQingYuan.processImp@team info exchange|team_leader_role_id=%d|team_member_role_id=%d|team_list_0=%d|team_list_1=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId), teamMembers.get(0), teamMembers.get(1) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 172 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 9, new ArrayList());
/*     */       
/*     */ 
/* 175 */       return false;
/*     */     }
/*     */     
/* 178 */     int teamLeaderStatus = teamInfo.getMemberStatus(this.teamLeaderRoleId);
/* 179 */     int teamMemberStatus = teamInfo.getMemberStatus(this.teamMemberRoleId);
/* 180 */     if ((teamLeaderStatus != 0) || (teamMemberStatus != 0))
/*     */     {
/* 182 */       GameServer.logger().error(String.format("[qingyuan]PCAgreeOrRefuseQingYuan.processImp@team member status is not normal|team_leader_role_id=%d|team_member_role_id=%d|team_leader_role_status=%d|team_member_role_status=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId), Integer.valueOf(teamLeaderStatus), Integer.valueOf(teamMemberStatus) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 187 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 8, new ArrayList());
/*     */       
/*     */ 
/* 190 */       return false;
/*     */     }
/*     */     
/* 193 */     int teamLeaderRoleLevel = RoleInterface.getLevel(this.teamLeaderRoleId);
/* 194 */     int teamMemberRoleLevel = RoleInterface.getLevel(this.teamMemberRoleId);
/*     */     
/* 196 */     int minQingYuanRoleLevel = QingYuanConsts.getInstance().minRoleLevel;
/* 197 */     if ((teamLeaderRoleLevel < minQingYuanRoleLevel) || (teamMemberRoleLevel < minQingYuanRoleLevel))
/*     */     {
/* 199 */       GameServer.logger().error(String.format("[qingyuan]PCAgreeOrRefuseQingYuan.processImp@role level not enough|need_min_level=%d|team_leader_role_level=%d|team_member_role_level=%d", new Object[] { Integer.valueOf(minQingYuanRoleLevel), Integer.valueOf(teamLeaderRoleLevel), Integer.valueOf(teamMemberRoleLevel) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 204 */       List<String> paramsList = new ArrayList();
/* 205 */       paramsList.add(String.valueOf(minQingYuanRoleLevel));
/*     */       
/* 207 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 5, paramsList);
/*     */       
/* 209 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 213 */     int relationValue = FriendInterface.getRelationValue(this.teamLeaderRoleId, this.teamMemberRoleId, true);
/* 214 */     int minRelationValue = QingYuanConsts.getInstance().minFriendValue;
/* 215 */     if (relationValue < minRelationValue)
/*     */     {
/* 217 */       GameServer.logger().error(String.format("[qingyuan]PCAgreeOrRefuseQingYuan.processImp@friend not enough|team_leader_role_id=%d|team_member_role_id=%d|relation_value=%d|need_relation_value=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId), Integer.valueOf(relationValue), Integer.valueOf(minRelationValue) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 222 */       List<String> paramsList = new ArrayList();
/* 223 */       paramsList.add(String.valueOf(minRelationValue));
/*     */       
/* 225 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 5, paramsList);
/*     */       
/* 227 */       return false;
/*     */     }
/*     */     
/* 230 */     boolean isMarriageRelation = MarriageInterface.isMarriageRelation(this.teamLeaderRoleId, this.teamMemberRoleId);
/* 231 */     if (isMarriageRelation)
/*     */     {
/* 233 */       GameServer.logger().error(String.format("[qingyuan]PCAgreeOrRefuseQingYuan.processImp@aleardy is couple|team_leader_role_id=%d|team_member_role_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 238 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 6, new ArrayList());
/*     */       
/*     */ 
/* 241 */       return false;
/*     */     }
/*     */     
/* 244 */     Role2QingYuanInfo xLeaderRole2QingYuanInfo = Role2qingyuan.get(Long.valueOf(this.teamLeaderRoleId));
/* 245 */     if (xLeaderRole2QingYuanInfo == null)
/*     */     {
/* 247 */       GameServer.logger().error(String.format("[qingyuan]PCAgreeOrRefuseQingYuan.processImp@role leader qing yuan info is null|team_leader_role_id=%d|team_member_role_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 251 */       return false;
/*     */     }
/*     */     
/* 254 */     Role2QingYuanInfo xMemberRole2QingYuanInfo = Role2qingyuan.get(Long.valueOf(this.teamMemberRoleId));
/* 255 */     if (xMemberRole2QingYuanInfo == null)
/*     */     {
/* 257 */       GameServer.logger().error(String.format("[qingyuan]PCAgreeOrRefuseQingYuan.processImp@role member qing yuan info is null|team_leader_role_id=%d|team_member_role_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 261 */       return false;
/*     */     }
/*     */     
/* 264 */     Map<Long, QingYuanRoleInfo> xLeaderQingYuanRoleMapInfo = xLeaderRole2QingYuanInfo.getQing_yuan_map_info();
/*     */     
/* 266 */     if (xLeaderQingYuanRoleMapInfo.containsKey(Long.valueOf(this.teamMemberRoleId)))
/*     */     {
/* 268 */       GameServer.logger().error(String.format("[qingyuan]PCAgreeOrRefuseQingYuan.processImp@aleardy is qing yuan relation|team_leader_role_id=%d|team_member_role_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 273 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 6, new ArrayList());
/*     */       
/*     */ 
/* 276 */       return false;
/*     */     }
/*     */     
/* 279 */     if (xLeaderQingYuanRoleMapInfo.size() >= QingYuanConsts.getInstance().maxQingYuanRelationNum)
/*     */     {
/* 281 */       GameServer.logger().error(String.format("[qingyuan]PCAgreeOrRefuseQingYuan.processImp@leader qing yuan relation size not enough|team_leader_role_id=%d|team_member_role_id=%d|leader_now_qing_yuan_size=%d|limit_size=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId), Integer.valueOf(xLeaderQingYuanRoleMapInfo.size()), Integer.valueOf(QingYuanConsts.getInstance().maxQingYuanRelationNum) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 287 */       SQingYuanNormalFail sQingYuanNormalFail = new SQingYuanNormalFail();
/* 288 */       sQingYuanNormalFail.result = 1;
/* 289 */       sQingYuanNormalFail.params.add(RoleInterface.getName(this.teamLeaderRoleId));
/* 290 */       OnlineManager.getInstance().sendAtOnce(this.teamMemberRoleId, sQingYuanNormalFail);
/*     */       
/* 292 */       String teamLeaderName = RoleInterface.getName(this.teamLeaderRoleId);
/* 293 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 1, Arrays.asList(new String[] { teamLeaderName }));
/*     */       
/*     */ 
/* 296 */       return false;
/*     */     }
/*     */     
/* 299 */     Map<Long, QingYuanRoleInfo> xMemberQingYuanRoleMapInfo = xMemberRole2QingYuanInfo.getQing_yuan_map_info();
/*     */     
/* 301 */     if (xMemberQingYuanRoleMapInfo.size() >= QingYuanConsts.getInstance().maxQingYuanRelationNum)
/*     */     {
/* 303 */       GameServer.logger().error(String.format("[qingyuan]PCAgreeOrRefuseQingYuan.processImp@member qing yuan relation size not enough|team_leader_role_id=%d|team_member_role_id=%d|leader_now_qing_yuan_size=%d|limit_size=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId), Integer.valueOf(xLeaderQingYuanRoleMapInfo.size()), Integer.valueOf(QingYuanConsts.getInstance().maxQingYuanRelationNum) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 309 */       String teamMemberName = RoleInterface.getName(this.teamMemberRoleId);
/* 310 */       QingYuanManager.onQingYuanFail(this.teamLeaderRoleId, 1, Arrays.asList(new String[] { teamMemberName }));
/*     */       
/*     */ 
/* 313 */       return false;
/*     */     }
/*     */     
/* 316 */     SAgreeOrRefuseQingYuan sAgreeOrRefuseQingYuan = new SAgreeOrRefuseQingYuan();
/* 317 */     sAgreeOrRefuseQingYuan.operator = this.operator;
/* 318 */     sAgreeOrRefuseQingYuan.team_leader_role_id = this.teamLeaderRoleId;
/* 319 */     sAgreeOrRefuseQingYuan.team_member_role_id = this.teamMemberRoleId;
/*     */     
/*     */ 
/* 322 */     if (this.operator == 0)
/*     */     {
/* 324 */       OnlineManager.getInstance().sendAtOnce(this.teamLeaderRoleId, sAgreeOrRefuseQingYuan);
/*     */       
/* 326 */       GameServer.logger().info(String.format("[qingyuan]PCAgreeOrRefuseQingYuan.processImp@member refuse qing yuan relaton|team_leader_role_id=%d|team_member_role_id=%d|session_id=%d|operator=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId), Long.valueOf(this.sessionId), Integer.valueOf(this.operator) }));
/*     */       
/*     */ 
/*     */ 
/* 330 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 334 */     Set<Integer> xLeaderAleardyUsedAppellationCfgIdSet = xLeaderRole2QingYuanInfo.getAleardy_used_appellation_cfg_id_set();
/*     */     
/* 336 */     Set<Integer> xMemberAleardyUsedAppellationCfgIdSet = xMemberRole2QingYuanInfo.getAleardy_used_appellation_cfg_id_set();
/*     */     
/* 338 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*     */ 
/* 341 */     QingYuanRoleInfo xLeaderQingYuanRoleInfo = Pod.newQingYuanRoleInfo();
/*     */     
/*     */ 
/* 344 */     QingYuanRoleInfo xMemberQingYuanRoleInfo = Pod.newQingYuanRoleInfo();
/*     */     
/*     */ 
/* 347 */     for (Iterator i$ = SQingYuanAppelationCfg.getAll().keySet().iterator(); i$.hasNext();) { int appellationCfgId = ((Integer)i$.next()).intValue();
/*     */       
/* 349 */       if (!xLeaderAleardyUsedAppellationCfgIdSet.contains(Integer.valueOf(appellationCfgId)))
/*     */       {
/* 351 */         xLeaderQingYuanRoleInfo.setAppellation_cfg_id(appellationCfgId);
/* 352 */         xLeaderQingYuanRoleInfo.setStart_time(currentTimeMillis);
/* 353 */         xLeaderAleardyUsedAppellationCfgIdSet.add(Integer.valueOf(appellationCfgId));
/* 354 */         xLeaderQingYuanRoleMapInfo.put(Long.valueOf(this.teamMemberRoleId), xLeaderQingYuanRoleInfo);
/*     */         
/* 356 */         xLeaderRole2QingYuanInfo.getQing_yuan_role_list().add(Long.valueOf(this.teamMemberRoleId));
/*     */         
/* 358 */         List<String> appellationArgs = new ArrayList();
/* 359 */         appellationArgs.add(RoleInterface.getName(this.teamMemberRoleId));
/*     */         
/* 361 */         TitleInterface.addAppellation(this.teamLeaderRoleId, appellationCfgId, appellationArgs);
/* 362 */         break;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 367 */     for (Iterator i$ = SQingYuanAppelationCfg.getAll().keySet().iterator(); i$.hasNext();) { int appellationCfgId = ((Integer)i$.next()).intValue();
/*     */       
/* 369 */       if (!xMemberAleardyUsedAppellationCfgIdSet.contains(Integer.valueOf(appellationCfgId)))
/*     */       {
/* 371 */         xMemberQingYuanRoleInfo.setAppellation_cfg_id(appellationCfgId);
/* 372 */         xMemberQingYuanRoleInfo.setStart_time(currentTimeMillis);
/* 373 */         xMemberRole2QingYuanInfo.getQing_yuan_role_list().add(Long.valueOf(this.teamLeaderRoleId));
/* 374 */         xMemberQingYuanRoleMapInfo.put(Long.valueOf(this.teamLeaderRoleId), xMemberQingYuanRoleInfo);
/*     */         
/* 376 */         xMemberAleardyUsedAppellationCfgIdSet.add(Integer.valueOf(appellationCfgId));
/*     */         
/* 378 */         List<String> appellationArgs = new ArrayList();
/* 379 */         appellationArgs.add(RoleInterface.getName(this.teamLeaderRoleId));
/*     */         
/* 381 */         TitleInterface.addAppellation(this.teamMemberRoleId, appellationCfgId, appellationArgs);
/* 382 */         break;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 387 */     BuffInterface.installBuff(this.teamLeaderRoleId, QingYuanConsts.getInstance().qingYuanRelationTeamBuffId);
/* 388 */     BuffInterface.installBuff(this.teamMemberRoleId, QingYuanConsts.getInstance().qingYuanRelationTeamBuffId);
/*     */     
/* 390 */     OnlineManager.getInstance().sendMulti(sAgreeOrRefuseQingYuan, Arrays.asList(new Long[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId) }));
/*     */     
/*     */ 
/* 393 */     QingYuanManager.tlogQingYuanRelation(this.teamLeaderRoleId, this.teamMemberRoleId, teamLeaderUserId, teamMemberUserId, QingYuanRelationTLogEnum.MAKE_QING_YUANI);
/*     */     
/* 395 */     QingYuanManager.tlogQingYuanRelation(this.teamMemberRoleId, this.teamLeaderRoleId, teamMemberUserId, teamLeaderUserId, QingYuanRelationTLogEnum.MAKE_QING_YUANI);
/*     */     
/*     */ 
/* 398 */     GameServer.logger().info(String.format("[qingyuan]PCAgreeOrRefuseQingYuan.processImp@member agree qing yuan relaton|team_leader_role_id=%d|team_member_role_id=%d|session_id=%d|operator=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId), Long.valueOf(this.sessionId), Integer.valueOf(this.operator) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 403 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\main\PCAgreeOrRefuseQingYuan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */