/*      */ package mzm.gsp.shitu.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*      */ import mzm.gsp.avatar.main.AvatarInterface;
/*      */ import mzm.gsp.common.TimeCommonUtil;
/*      */ import mzm.gsp.common.confbean.STimeCommonCfg;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.shitu.SSynShiTuRoleInfoAndModelInfoChange;
/*      */ import mzm.gsp.shitu.SSynShiTuTaskInfo;
/*      */ import mzm.gsp.shitu.SSynShiTuTaskStatus;
/*      */ import mzm.gsp.shitu.ShiTuActiveInfo;
/*      */ import mzm.gsp.shitu.ShiTuRoleInfo;
/*      */ import mzm.gsp.shitu.ShiTuRoleInfoAndModelInfo;
/*      */ import mzm.gsp.shitu.confbean.SShiTuActiveValueConsts;
/*      */ import mzm.gsp.shitu.confbean.SShiTuTaskConsts;
/*      */ import mzm.gsp.shitu.confbean.ShiTuConsts;
/*      */ import mzm.gsp.shitu.event.MasterRecommend;
/*      */ import mzm.gsp.shitu.event.MasterRecommendArg;
/*      */ import mzm.gsp.task.main.TaskInterface;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.ApprenticeInfo;
/*      */ import xbean.AwardIndexIds;
/*      */ import xbean.MasterInfo;
/*      */ import xbean.Pod;
/*      */ import xbean.Role2PayRespectInfo;
/*      */ import xbean.ShiTuActive;
/*      */ import xbean.ShiTuTimeInfo;
/*      */ import xbean.role2ShiTuInfo;
/*      */ import xtable.Role2payrespect;
/*      */ import xtable.Role2shitu;
/*      */ import xtable.Role2shituactive;
/*      */ import xtable.Role2shitutask;
/*      */ 
/*      */ class ShiTuManager
/*      */ {
/*      */   public static int selectApprenticeSize(long roleId)
/*      */   {
/*   57 */     role2ShiTuInfo xRole2ShiTuInfo = Role2shitu.select(Long.valueOf(roleId));
/*   58 */     if (xRole2ShiTuInfo == null)
/*      */     {
/*   60 */       return 0;
/*      */     }
/*      */     
/*   63 */     MasterInfo xMasterInfo = xRole2ShiTuInfo.getMasterinfo();
/*   64 */     return xMasterInfo.getApprentice_graduate().size() + xMasterInfo.getApprentice_now().size();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean checkIsInPunishTime(long masterRoleId, long apprenticeRoleId, MasterInfo xMasterInfo, MasterInfo xApprenticeMasterInfo, String logString, boolean isNeedLog)
/*      */   {
/*   89 */     long punishTime = 3600000L * ShiTuConsts.getInstance().relievePunishTime;
/*      */     
/*   91 */     ShiTuTimeInfo xMasterRelieveTimeInfo = (ShiTuTimeInfo)xMasterInfo.getForce_relieve().get(Long.valueOf(apprenticeRoleId));
/*   92 */     boolean isInPunish = false;
/*   93 */     if (xMasterRelieveTimeInfo != null)
/*      */     {
/*   95 */       isInPunish = DateTimeUtils.getCurrTimeInMillis() - xMasterRelieveTimeInfo.getEndtime() <= punishTime;
/*      */       
/*   97 */       if ((isInPunish) && (isNeedLog))
/*      */       {
/*   99 */         GameServer.logger().error(String.format("[shitu]%s@apprentice is in master's punish time|master_role_id=%d|apprentice_role_id=%d|start_time=%d|end_time=%d|punish_hour=%d", new Object[] { logString, Long.valueOf(masterRoleId), Long.valueOf(apprenticeRoleId), Long.valueOf(xMasterRelieveTimeInfo.getStarttime()), Long.valueOf(xMasterRelieveTimeInfo.getEndtime()), Integer.valueOf(ShiTuConsts.getInstance().relievePunishTime) }));
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  107 */     if (isInPunish) {
/*  108 */       return true;
/*      */     }
/*      */     
/*  111 */     ShiTuTimeInfo xApprenticeRelieveTimeInfo = (ShiTuTimeInfo)xApprenticeMasterInfo.getForce_relieve().get(Long.valueOf(masterRoleId));
/*  112 */     if ((!isInPunish) && (xApprenticeRelieveTimeInfo != null))
/*      */     {
/*  114 */       isInPunish = DateTimeUtils.getCurrTimeInMillis() - xApprenticeRelieveTimeInfo.getEndtime() <= punishTime;
/*  115 */       if ((isInPunish) && (isNeedLog))
/*      */       {
/*  117 */         GameServer.logger().error(String.format("[shitu]%s@master is in apprentice's punish time|master_role_id=%d|apprentice_role_id=%d|start_time=%d|end_time=%d|punish_hour=%d", new Object[] { logString, Long.valueOf(masterRoleId), Long.valueOf(apprenticeRoleId), Long.valueOf(xApprenticeRelieveTimeInfo.getStarttime()), Long.valueOf(xApprenticeRelieveTimeInfo.getEndtime()), Integer.valueOf(ShiTuConsts.getInstance().relievePunishTime) }));
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  124 */     return isInPunish;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean checkIsHasShiTuRelation(long masterRoleId, long apprenticeRoleId, MasterInfo xApprenticeMasterInfo, MasterInfo xMasterInfo, String logString, boolean isNeedLog)
/*      */   {
/*  147 */     Map<Long, ShiTuTimeInfo> xApprenticeNowApprenticeMap = xApprenticeMasterInfo.getApprentice_now();
/*      */     
/*  149 */     if (xApprenticeNowApprenticeMap.containsKey(Long.valueOf(masterRoleId)))
/*      */     {
/*  151 */       if (isNeedLog)
/*      */       {
/*  153 */         GameServer.logger().error(String.format("[shitu]%s@master is apprentice's apprentice now|master_role_id=%d|apprentice_role_id=%d|apprentice_list=%s", new Object[] { logString, Long.valueOf(masterRoleId), Long.valueOf(apprenticeRoleId), xApprenticeNowApprenticeMap.keySet().toString() }));
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  158 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  162 */     Map<Long, ShiTuTimeInfo> xApprenticeGraduateApprenticeMap = xApprenticeMasterInfo.getApprentice_graduate();
/*  163 */     if (xApprenticeGraduateApprenticeMap.containsKey(Long.valueOf(masterRoleId)))
/*      */     {
/*  165 */       if (isNeedLog)
/*      */       {
/*  167 */         GameServer.logger().error(String.format("[shitu]%s@master is apprentice's apprentice once|master_role_id=%d|apprentice_role_id=%d|apprentice_list=%s", new Object[] { logString, Long.valueOf(masterRoleId), Long.valueOf(apprenticeRoleId), xApprenticeGraduateApprenticeMap.keySet().toString() }));
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  172 */       return true;
/*      */     }
/*      */     
/*  175 */     Map<Long, ShiTuTimeInfo> xMasterNowApprenticeMap = xMasterInfo.getApprentice_now();
/*      */     
/*  177 */     if (xMasterNowApprenticeMap.containsKey(Long.valueOf(apprenticeRoleId)))
/*      */     {
/*  179 */       if (isNeedLog)
/*      */       {
/*  181 */         GameServer.logger().error(String.format("[shitu]%s@apprentice is master's apprentice now|master_role_id=%d|apprentice_role_id=%d|apprentice_list=%s", new Object[] { logString, Long.valueOf(masterRoleId), Long.valueOf(apprenticeRoleId), xMasterNowApprenticeMap.keySet().toString() }));
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  186 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  190 */     Map<Long, ShiTuTimeInfo> xMasterGraduateApprenticeMap = xMasterInfo.getApprentice_graduate();
/*  191 */     if (xMasterGraduateApprenticeMap.containsKey(Long.valueOf(apprenticeRoleId)))
/*      */     {
/*  193 */       if (isNeedLog)
/*      */       {
/*  195 */         GameServer.logger().error(String.format("[shitu]%s@apprentice is master's apprentice once|master_role_id=%d|apprentice_role_id=%d|apprentice_list=%s", new Object[] { logString, Long.valueOf(masterRoleId), Long.valueOf(apprenticeRoleId), xMasterGraduateApprenticeMap.keySet().toString() }));
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  200 */       return true;
/*      */     }
/*      */     
/*  203 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isExistShiTuRelation(long roleIdA, long roleIdB)
/*      */   {
/*  218 */     role2ShiTuInfo xRoleIdAShiTuInfo = Role2shitu.get(Long.valueOf(roleIdA));
/*  219 */     if (xRoleIdAShiTuInfo == null)
/*      */     {
/*  221 */       return false;
/*      */     }
/*      */     
/*  224 */     if (xRoleIdAShiTuInfo.getApprenticeinfo().getMasterroleid() == roleIdB)
/*      */     {
/*  226 */       return true;
/*      */     }
/*      */     
/*  229 */     role2ShiTuInfo xRoleIdBShiTuInfo = Role2shitu.get(Long.valueOf(roleIdB));
/*  230 */     if (xRoleIdBShiTuInfo == null)
/*      */     {
/*  232 */       return false;
/*      */     }
/*      */     
/*  235 */     if (xRoleIdBShiTuInfo.getApprenticeinfo().getMasterroleid() == roleIdA)
/*      */     {
/*  237 */       return true;
/*      */     }
/*  239 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean isExistShiTuRelation(long roleId, boolean isRemainRoleLock)
/*      */   {
/*  245 */     role2ShiTuInfo xRoleIdAShiTuInfo = null;
/*  246 */     if (isRemainRoleLock)
/*      */     {
/*  248 */       xRoleIdAShiTuInfo = Role2shitu.get(Long.valueOf(roleId));
/*      */     }
/*      */     else
/*      */     {
/*  252 */       xRoleIdAShiTuInfo = Role2shitu.select(Long.valueOf(roleId));
/*      */     }
/*      */     
/*  255 */     if (xRoleIdAShiTuInfo == null)
/*      */     {
/*  257 */       return false;
/*      */     }
/*      */     
/*  260 */     MasterInfo xMasterInfo = xRoleIdAShiTuInfo.getMasterinfo();
/*  261 */     ApprenticeInfo xApprenticeInfo = xRoleIdAShiTuInfo.getApprenticeinfo();
/*      */     
/*  263 */     if ((xMasterInfo.getApprentice_now().size() > 0) || (xMasterInfo.getApprentice_graduate().size() > 0) || (xApprenticeInfo.getMasterroleid() != 0L))
/*      */     {
/*      */ 
/*  266 */       return true;
/*      */     }
/*  268 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogShiTuRelation(long roleId, long masterRoleId, long apprenticeRoleId, ShiTuRelationTLogEnum tLogEnum)
/*      */   {
/*  286 */     String masterUserId = RoleInterface.getUserId(masterRoleId);
/*  287 */     int masterRoleLevel = RoleInterface.getLevel(masterRoleId);
/*  288 */     String apprenticeUserId = RoleInterface.getUserId(apprenticeRoleId);
/*  289 */     int apprenticeRoleLevel = RoleInterface.getLevel(apprenticeRoleId);
/*      */     
/*  291 */     StringBuilder sbLog = new StringBuilder();
/*  292 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  293 */     sbLog.append(masterUserId).append('|');
/*  294 */     sbLog.append(masterRoleId).append('|');
/*  295 */     sbLog.append(masterRoleLevel).append('|');
/*      */     
/*  297 */     sbLog.append(apprenticeUserId).append('|');
/*  298 */     sbLog.append(apprenticeRoleId).append('|');
/*  299 */     sbLog.append(apprenticeRoleLevel).append('|');
/*  300 */     sbLog.append(tLogEnum.getOperator());
/*      */     
/*  302 */     TLogManager.getInstance().addLog(roleId, "ShiTuRelation", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogShiTuPayRespect(long apprenticeRoleId, String apprenticeUserId, long masterRoleId, String masterUserId, ShiTuPayRespectTLogEnum tLogEnum)
/*      */   {
/*  323 */     int masterRoleLevel = RoleInterface.getLevel(masterRoleId);
/*  324 */     int apprenticeRoleLevel = RoleInterface.getLevel(apprenticeRoleId);
/*      */     
/*  326 */     StringBuilder sbLog = new StringBuilder();
/*  327 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  328 */     sbLog.append(apprenticeUserId).append('|');
/*  329 */     sbLog.append(apprenticeRoleId).append('|');
/*  330 */     sbLog.append(apprenticeRoleLevel).append('|');
/*      */     
/*  332 */     sbLog.append(masterUserId).append('|');
/*  333 */     sbLog.append(masterRoleId).append('|');
/*  334 */     sbLog.append(masterRoleLevel).append('|');
/*  335 */     sbLog.append(tLogEnum.getOperator());
/*      */     
/*  337 */     TLogManager.getInstance().addLog(apprenticeRoleId, "PayRespectStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isShiTuSwitchOpen(long roleId, String logString)
/*      */   {
/*  352 */     if (!OpenInterface.getOpenStatus(53))
/*      */     {
/*  354 */       GameServer.logger().info(String.format("[shitu]%s@shi tu system switch closed|role_id=%d", new Object[] { logString, Long.valueOf(roleId) }));
/*  355 */       return false;
/*      */     }
/*      */     
/*  358 */     if (OpenInterface.isBanPlay(roleId, 53))
/*      */     {
/*  360 */       GameServer.logger().info(String.format("[shitu]%s@shi tu is ban play|role_id=%d", new Object[] { logString, Long.valueOf(roleId) }));
/*      */       
/*  362 */       OpenInterface.sendBanPlayMsg(roleId, 53);
/*  363 */       return false;
/*      */     }
/*      */     
/*  366 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isShiTuPayRespectSwitchOpen(long roleId, String logString)
/*      */   {
/*  381 */     if (!OpenInterface.getOpenStatus(137))
/*      */     {
/*  383 */       GameServer.logger().info(String.format("[shitu]%s@shi tu pay respect system switch closed|role_id=%d", new Object[] { logString, Long.valueOf(roleId) }));
/*      */       
/*  385 */       return false;
/*      */     }
/*      */     
/*  388 */     if (OpenInterface.isBanPlay(roleId, 137))
/*      */     {
/*  390 */       GameServer.logger().info(String.format("[shitu]%s@shi tu pay respect is ban play|role_id=%d", new Object[] { logString, Long.valueOf(roleId) }));
/*      */       
/*  392 */       OpenInterface.sendBanPlayMsg(roleId, 137);
/*  393 */       return false;
/*      */     }
/*      */     
/*  396 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static ShiTuRoleInfo setShiTuRoleInfo(long roleId, ShiTuRoleInfo shiTuRoleInfo)
/*      */   {
/*  411 */     shiTuRoleInfo.gender = RoleInterface.getGender(roleId);
/*  412 */     shiTuRoleInfo.roleid = roleId;
/*  413 */     shiTuRoleInfo.occupationid = RoleInterface.getOccupationId(roleId);
/*  414 */     shiTuRoleInfo.rolename = RoleInterface.getName(roleId);
/*      */     
/*  416 */     return shiTuRoleInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void checkAndInitPayRespectInfo(long apprenticeRoleId, long masterRoleId)
/*      */   {
/*  429 */     Role2PayRespectInfo xApprenticePayRespectInfo = Role2payrespect.get(Long.valueOf(apprenticeRoleId));
/*  430 */     if (xApprenticePayRespectInfo == null)
/*      */     {
/*  432 */       xApprenticePayRespectInfo = Pod.newRole2PayRespectInfo();
/*  433 */       xApprenticePayRespectInfo.setApprentice_is_paying_respect(false);
/*  434 */       xApprenticePayRespectInfo.setMaster_is_paying_respect(false);
/*  435 */       Role2payrespect.add(Long.valueOf(apprenticeRoleId), xApprenticePayRespectInfo);
/*      */     }
/*      */     
/*  438 */     Role2PayRespectInfo xMasterPayRespectInfo = Role2payrespect.get(Long.valueOf(masterRoleId));
/*  439 */     if (xMasterPayRespectInfo == null)
/*      */     {
/*  441 */       xMasterPayRespectInfo = Pod.newRole2PayRespectInfo();
/*  442 */       xMasterPayRespectInfo.setApprentice_is_paying_respect(false);
/*  443 */       xMasterPayRespectInfo.setMaster_is_paying_respect(false);
/*  444 */       Role2payrespect.add(Long.valueOf(masterRoleId), xMasterPayRespectInfo);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*  451 */   private static Set<Integer> graphIds = new HashSet();
/*      */   
/*      */   static void init() throws Exception
/*      */   {
/*  455 */     graphIds.add(Integer.valueOf(SShiTuTaskConsts.getInstance().TASK_GRAPH_ID_1));
/*  456 */     if (!graphIds.add(Integer.valueOf(SShiTuTaskConsts.getInstance().TASK_GRAPH_ID_2)))
/*      */     {
/*  458 */       throw new RuntimeException("师徒任务常量表,配置了相同的任务图ID:" + SShiTuTaskConsts.getInstance().TASK_GRAPH_ID_2);
/*      */     }
/*  460 */     if (!graphIds.add(Integer.valueOf(SShiTuTaskConsts.getInstance().TASK_GRAPH_ID_3)))
/*      */     {
/*  462 */       throw new RuntimeException("师徒任务常量表,配置了相同的任务图ID:" + SShiTuTaskConsts.getInstance().TASK_GRAPH_ID_3);
/*      */     }
/*      */   }
/*      */   
/*      */   static boolean check()
/*      */   {
/*  468 */     for (Iterator i$ = graphIds.iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/*      */       
/*  470 */       if (!TaskInterface.isHaveGraphId(graphId))
/*      */       {
/*  472 */         throw new RuntimeException("师徒任务常量表,配置的任务图ID不存在，ID=:" + graphId);
/*      */       }
/*      */     }
/*      */     
/*  476 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isShiTuTaskGraph(int graphId)
/*      */   {
/*  488 */     return graphIds.contains(Integer.valueOf(graphId));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isShiTuTaskOpen(long roleId)
/*      */   {
/*  498 */     if (!OpenInterface.getOpenStatus(414))
/*      */     {
/*  500 */       return false;
/*      */     }
/*  502 */     if (OpenInterface.isBanPlay(roleId, 414))
/*      */     {
/*  504 */       OpenInterface.sendBanPlayMsg(roleId, 414);
/*  505 */       return false;
/*      */     }
/*  507 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isShiTuActiveOpen(long roleId)
/*      */   {
/*  517 */     if (!OpenInterface.getOpenStatus(415))
/*      */     {
/*  519 */       return false;
/*      */     }
/*  521 */     if (OpenInterface.isBanPlay(roleId, 415))
/*      */     {
/*  523 */       OpenInterface.sendBanPlayMsg(roleId, 415);
/*  524 */       return false;
/*      */     }
/*  526 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isShiTuRecommemdOpen(long roleId)
/*      */   {
/*  536 */     if (!OpenInterface.getOpenStatus(416))
/*      */     {
/*  538 */       return false;
/*      */     }
/*  540 */     if (OpenInterface.isBanPlay(roleId, 416))
/*      */     {
/*  542 */       OpenInterface.sendBanPlayMsg(roleId, 416);
/*  543 */       return false;
/*      */     }
/*  545 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static ShiTuRoleInfoAndModelInfo setShiTuRoleInfoAndModelInfo(long roleId, ShiTuRoleInfoAndModelInfo shiTuRoleInfoAndModelInfo)
/*      */   {
/*  561 */     shiTuRoleInfoAndModelInfo.gender = RoleInterface.getGender(roleId);
/*  562 */     shiTuRoleInfoAndModelInfo.roleid = roleId;
/*  563 */     shiTuRoleInfoAndModelInfo.occupationid = RoleInterface.getOccupationId(roleId);
/*  564 */     shiTuRoleInfoAndModelInfo.rolename = RoleInterface.getName(roleId);
/*  565 */     shiTuRoleInfoAndModelInfo.avatarid = AvatarInterface.getCurrentAvatar(roleId, false);
/*  566 */     shiTuRoleInfoAndModelInfo.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(roleId, false);
/*  567 */     shiTuRoleInfoAndModelInfo.rolelevel = RoleInterface.getLevel(roleId);
/*      */     
/*  569 */     RoleInterface.fillModelInfo(roleId, shiTuRoleInfoAndModelInfo.model);
/*  570 */     return shiTuRoleInfoAndModelInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void synShiTuRoleInfoChange(long roleId)
/*      */   {
/*  583 */     role2ShiTuInfo xRoleIdAShiTuInfo = Role2shitu.get(Long.valueOf(roleId));
/*      */     
/*  585 */     if (xRoleIdAShiTuInfo == null)
/*      */     {
/*  587 */       return;
/*      */     }
/*  589 */     MasterInfo xMasterInfo = xRoleIdAShiTuInfo.getMasterinfo();
/*  590 */     long masterId = getMasterId(xRoleIdAShiTuInfo);
/*      */     
/*      */ 
/*  593 */     if ((xMasterInfo.getApprentice_now().size() <= 0) && (masterId <= 0L))
/*      */     {
/*  595 */       return;
/*      */     }
/*  597 */     List<Long> synRoleIds = new ArrayList(xMasterInfo.getApprentice_now().keySet());
/*  598 */     if (masterId > 0L)
/*      */     {
/*  600 */       synRoleIds.add(Long.valueOf(masterId));
/*      */     }
/*  602 */     SSynShiTuRoleInfoAndModelInfoChange syn = new SSynShiTuRoleInfoAndModelInfoChange();
/*  603 */     syn.changeinfo = setShiTuRoleInfoAndModelInfo(roleId, new ShiTuRoleInfoAndModelInfo());
/*  604 */     OnlineManager.getInstance().sendMulti(syn, synRoleIds);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean refreshShiTuTasks(long roleId, xbean.ShiTuTaskInfo xShiTuTaskInfo)
/*      */   {
/*  617 */     xShiTuTaskInfo.getTask_infos().clear();
/*      */     
/*  619 */     for (Iterator i$ = graphIds.iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/*      */       
/*  621 */       int taskId = TaskInterface.randomOneTaskInGraph(roleId, graphId);
/*  622 */       if (taskId < 0)
/*      */       {
/*  624 */         GameServer.logger().error(String.format("[shitu]ShiTuManager.refreshShiTuTasks@ refresh tasks err!|graphId=%d|roleId=%d", new Object[] { Integer.valueOf(graphId), Long.valueOf(roleId) }));
/*      */         
/*      */ 
/*  627 */         return false;
/*      */       }
/*  629 */       xbean.ShiTuTask xShiTuTask = Pod.newShiTuTask();
/*  630 */       xShiTuTask.setTask_id(taskId);
/*  631 */       xShiTuTask.setTask_state(0);
/*  632 */       xShiTuTaskInfo.getTask_infos().put(Integer.valueOf(graphId), xShiTuTask);
/*      */     }
/*  634 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void sendShiTuTaskReward(long masterId, long apprenticeRoleId, xbean.ShiTuTaskInfo xShiTuTaskInfo)
/*      */   {
/*  646 */     Set<Integer> rewardTaskIdSet = null;
/*      */     
/*      */ 
/*  649 */     for (Map.Entry<Integer, xbean.ShiTuTask> entry : xShiTuTaskInfo.getTask_infos().entrySet())
/*      */     {
/*  651 */       xbean.ShiTuTask xShituTask = (xbean.ShiTuTask)entry.getValue();
/*      */       
/*  653 */       if (xShituTask.getTask_state() == 1)
/*      */       {
/*  655 */         TaskInterface.giveUpTaskImpl(apprenticeRoleId, ((Integer)entry.getKey()).intValue(), xShituTask.getTask_id());
/*      */       }
/*  657 */       if (xShituTask.getTask_state() == 2)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  662 */         xShituTask.setTask_state(4);
/*  663 */         if (rewardTaskIdSet == null)
/*      */         {
/*  665 */           rewardTaskIdSet = new HashSet();
/*      */         }
/*  667 */         rewardTaskIdSet.add(Integer.valueOf(xShituTask.getTask_id()));
/*      */       } }
/*  669 */     if ((rewardTaskIdSet != null) && (rewardTaskIdSet.size() > 0))
/*      */     {
/*      */ 
/*  672 */       new PSendShiTuTaskReward(masterId, rewardTaskIdSet).execute();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static SSynShiTuTaskInfo getAndCheckResetShiTuTaskInfo(long roleId)
/*      */   {
/*  687 */     xbean.ShiTuTaskInfo xShiTuTaskInfo = Role2shitutask.get(Long.valueOf(roleId));
/*  688 */     if (xShiTuTaskInfo == null)
/*      */     {
/*  690 */       xShiTuTaskInfo = Pod.newShiTuTaskInfo();
/*  691 */       Role2shitutask.add(Long.valueOf(roleId), xShiTuTaskInfo);
/*      */     }
/*  693 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  694 */     STimeCommonCfg timeCommonCfg = TimeCommonUtil.getCommonCfg(SShiTuTaskConsts.getInstance().DAILY_REFRESH_TIME);
/*      */     
/*  696 */     if (DateTimeUtils.needDailyReset(xShiTuTaskInfo.getReset_time(), now, timeCommonCfg.activeHour, timeCommonCfg.activeMinute))
/*      */     {
/*      */ 
/*  699 */       sysRefresh(roleId, xShiTuTaskInfo, now);
/*      */     }
/*      */     
/*      */ 
/*  703 */     SSynShiTuTaskInfo syn = new SSynShiTuTaskInfo();
/*  704 */     mzm.gsp.shitu.ShiTuTaskInfo taskInfo = new mzm.gsp.shitu.ShiTuTaskInfo();
/*  705 */     taskInfo.role_id = roleId;
/*  706 */     taskInfo.publish_state = xShiTuTaskInfo.getPublish_state();
/*  707 */     taskInfo.refresh_times = xShiTuTaskInfo.getRefresh_times();
/*  708 */     taskInfo.shitu_task_count = xShiTuTaskInfo.getShitu_task_count();
/*      */     
/*  710 */     for (Map.Entry<Integer, xbean.ShiTuTask> entry : xShiTuTaskInfo.getTask_infos().entrySet())
/*      */     {
/*  712 */       xbean.ShiTuTask shiTuTask = (xbean.ShiTuTask)entry.getValue();
/*  713 */       taskInfo.task_infos.put(entry.getKey(), new mzm.gsp.shitu.ShiTuTask(shiTuTask.getTask_id(), shiTuTask.getTask_state()));
/*      */     }
/*      */     
/*  716 */     syn.shitu_task_info = taskInfo;
/*  717 */     return syn;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void sysRefresh(long roleId, xbean.ShiTuTaskInfo xShiTuTaskInfo, long now)
/*      */   {
/*  730 */     xShiTuTaskInfo.setReset_time(now);
/*  731 */     xShiTuTaskInfo.setRefresh_times(0);
/*      */     
/*  733 */     if (xShiTuTaskInfo.getPublish_state() == 2)
/*      */     {
/*  735 */       long masterId = getMasterId(Role2shitu.get(Long.valueOf(roleId)));
/*  736 */       if (masterId > 0L)
/*      */       {
/*  738 */         sendShiTuTaskReward(masterId, roleId, xShiTuTaskInfo);
/*      */       }
/*      */     }
/*  741 */     xShiTuTaskInfo.setPublish_state(0);
/*      */     
/*  743 */     if (xShiTuTaskInfo.getShitu_task_count() >= SShiTuTaskConsts.getInstance().RECEIVE_MAX_TIMES)
/*      */     {
/*  745 */       xShiTuTaskInfo.setPublish_state(4);
/*      */     }
/*      */     
/*  748 */     if (RoleInterface.getLevel(roleId) > SShiTuTaskConsts.getInstance().RECEIVE_MAX_LEVEL)
/*      */     {
/*  750 */       xShiTuTaskInfo.setPublish_state(3);
/*      */     }
/*  752 */     if (xShiTuTaskInfo.getPublish_state() == 0)
/*      */     {
/*  754 */       refreshShiTuTasks(roleId, xShiTuTaskInfo);
/*      */     }
/*      */     else
/*      */     {
/*  758 */       xShiTuTaskInfo.getTask_infos().clear();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static int getAndCheckResetPublishTimes(MasterInfo xMasterInfo)
/*      */   {
/*  773 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  774 */     STimeCommonCfg timeCommonCfg = TimeCommonUtil.getCommonCfg(SShiTuTaskConsts.getInstance().DAILY_REFRESH_TIME);
/*      */     
/*  776 */     if (DateTimeUtils.needDailyReset(xMasterInfo.getPublish_reset_time(), now, timeCommonCfg.activeHour, timeCommonCfg.activeMinute))
/*      */     {
/*      */ 
/*  779 */       xMasterInfo.setPublish_reset_time(now);
/*  780 */       xMasterInfo.setPublish_times(0);
/*      */     }
/*  782 */     return xMasterInfo.getPublish_times();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isMaxPublishTimes(MasterInfo xMasterInfo)
/*      */   {
/*  793 */     return getAndCheckResetPublishTimes(xMasterInfo) >= SShiTuTaskConsts.getInstance().DAILY_MAX_PUBLISH_TIMES;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static SSynShiTuTaskInfo changeShiTuTaskPublishState(long roleId, int beforeState, int afterState)
/*      */   {
/*  808 */     SSynShiTuTaskInfo syn = getAndCheckResetShiTuTaskInfo(roleId);
/*  809 */     xbean.ShiTuTaskInfo xShiTuTaskInfo = Role2shitutask.get(Long.valueOf(roleId));
/*  810 */     if (xShiTuTaskInfo.getPublish_state() == beforeState)
/*      */     {
/*  812 */       xShiTuTaskInfo.setPublish_state(afterState);
/*  813 */       syn.shitu_task_info.publish_state = afterState;
/*      */       
/*  815 */       ShiTuTLogManager.tlogShiTuTaskApprentice(roleId, RoleInterface.getUserId(roleId), xShiTuTaskInfo);
/*      */     }
/*      */     
/*  818 */     if (afterState == 5)
/*      */     {
/*  820 */       if ((xShiTuTaskInfo.getPublish_state() == 0) || (xShiTuTaskInfo.getPublish_state() == 1) || (xShiTuTaskInfo.getPublish_state() == 7))
/*      */       {
/*      */ 
/*      */ 
/*  824 */         sysRefresh(roleId, xShiTuTaskInfo, DateTimeUtils.getCurrTimeInMillis());
/*  825 */         syn = getAndCheckResetShiTuTaskInfo(roleId);
/*      */       }
/*      */     }
/*  828 */     return syn;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void changeShiTuTaskState(long roleId, int graphid, xbean.ShiTuTask xShiTuTask, int state)
/*      */   {
/*  845 */     if (xShiTuTask == null)
/*      */     {
/*  847 */       return;
/*      */     }
/*  849 */     if (xShiTuTask.getTask_state() == state)
/*      */     {
/*  851 */       return;
/*      */     }
/*  853 */     xShiTuTask.setTask_state(state);
/*      */     
/*      */ 
/*  856 */     SSynShiTuTaskStatus pro = new SSynShiTuTaskStatus();
/*  857 */     pro.role_id = roleId;
/*  858 */     pro.graph_id = graphid;
/*  859 */     pro.task_id = xShiTuTask.getTask_id();
/*  860 */     pro.task_state = state;
/*      */     
/*      */ 
/*  863 */     long masterId = getMasterId(Role2shitu.get(Long.valueOf(roleId)));
/*      */     
/*  865 */     if (masterId > 0L)
/*      */     {
/*  867 */       OnlineManager.getInstance().sendMulti(pro, Arrays.asList(new Long[] { Long.valueOf(roleId), Long.valueOf(masterId) }));
/*      */     }
/*      */     else
/*      */     {
/*  871 */       OnlineManager.getInstance().send(roleId, pro);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getMasterId(role2ShiTuInfo xRoleIdShiTuInfo)
/*      */   {
/*  884 */     if (xRoleIdShiTuInfo == null)
/*      */     {
/*  886 */       return 0L;
/*      */     }
/*  888 */     ApprenticeInfo xApprenticeInfo = xRoleIdShiTuInfo.getApprenticeinfo();
/*  889 */     ShiTuTimeInfo xApprenticeTimeInfo = xApprenticeInfo.getTimeinfo();
/*      */     
/*  891 */     if ((xApprenticeTimeInfo.getStarttime() > 0L) && (xApprenticeTimeInfo.getEndtime() > 0L))
/*      */     {
/*  893 */       return 0L;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  898 */     return xApprenticeInfo.getMasterroleid();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<ShiTuActiveInfo> getAndCheckResetShiTuActiveInfo(long questRoleId, Collection<Long> roleIdSet)
/*      */   {
/*  915 */     List<ShiTuActiveInfo> shiTuActiveInfoList = new ArrayList();
/*      */     
/*  917 */     role2ShiTuInfo xMasterShiTuInfo = Role2shitu.get(Long.valueOf(questRoleId));
/*  918 */     if (xMasterShiTuInfo == null)
/*      */     {
/*  920 */       return Collections.EMPTY_LIST;
/*      */     }
/*      */     
/*  923 */     ShiTuActive xShiTuActive = Role2shituactive.get(Long.valueOf(questRoleId));
/*  924 */     if (xShiTuActive == null)
/*      */     {
/*  926 */       xShiTuActive = Pod.newShiTuActive();
/*  927 */       Role2shituactive.add(Long.valueOf(questRoleId), xShiTuActive);
/*      */     }
/*  929 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  930 */     STimeCommonCfg timeCommonCfg = TimeCommonUtil.getCommonCfg(SShiTuActiveValueConsts.getInstance().DAILY_RESET_TIME);
/*      */     
/*  932 */     Map<Long, AwardIndexIds> awardMap = xShiTuActive.getAward_map();
/*      */     
/*  934 */     if (DateTimeUtils.needDailyReset(xShiTuActive.getReset_time(), now, timeCommonCfg.activeHour, timeCommonCfg.activeMinute))
/*      */     {
/*      */ 
/*  937 */       xShiTuActive.setReset_time(now);
/*      */       
/*  939 */       awardMap = Collections.EMPTY_MAP;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  944 */     long relation_start_time = 0L;
/*  945 */     Map<Long, ShiTuTimeInfo> xNowMasterApprenticeInfoMap = xMasterShiTuInfo.getMasterinfo().getApprentice_now();
/*      */     
/*  947 */     for (Long roleId : roleIdSet)
/*      */     {
/*      */ 
/*  950 */       if (questRoleId == roleId.longValue())
/*      */       {
/*  952 */         ShiTuTimeInfo xApprenticeTimeInfo = xMasterShiTuInfo.getApprenticeinfo().getTimeinfo();
/*  953 */         relation_start_time = xApprenticeTimeInfo.getStarttime();
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*  958 */         ShiTuTimeInfo xMasterTimeInfo = (ShiTuTimeInfo)xNowMasterApprenticeInfoMap.get(roleId);
/*      */         
/*  960 */         if (xMasterTimeInfo == null) {
/*      */           continue;
/*      */         }
/*      */         
/*  964 */         relation_start_time = xMasterTimeInfo.getStarttime();
/*      */       }
/*  966 */       ShiTuActiveInfo shiTuActiveInfo = new ShiTuActiveInfo();
/*  967 */       shiTuActiveInfo.role_id = roleId.longValue();
/*  968 */       shiTuActiveInfo.relation_start_time = ((int)TimeUnit.MILLISECONDS.toSeconds(relation_start_time));
/*  969 */       shiTuActiveInfo.active_value = mzm.gsp.active.main.ActiveInterface.getTotalActiveValue(roleId.longValue());
/*  970 */       AwardIndexIds xAwardIndexIds = (AwardIndexIds)awardMap.get(roleId);
/*  971 */       if (xAwardIndexIds != null)
/*      */       {
/*  973 */         shiTuActiveInfo.award_active_index_id_set.addAll(xAwardIndexIds.getAward_index_id_set());
/*      */       }
/*  975 */       shiTuActiveInfoList.add(shiTuActiveInfo);
/*      */     }
/*      */     
/*  978 */     return shiTuActiveInfoList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void triggerBaishiEvent(long masterRoleId, long apprenticeRoleId, boolean isSuccess)
/*      */   {
/*  990 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.shitu.event.BaiShi(), new mzm.gsp.shitu.event.BaiShiArg(masterRoleId, apprenticeRoleId, isSuccess));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void triggerMasterRecommendEvent(long apprenticeRoleId, Collection<Long> recommendMasterRoleIdList, boolean isSuccess)
/*      */   {
/* 1003 */     TriggerEventsManger.getInstance().triggerEvent(new MasterRecommend(), new MasterRecommendArg(apprenticeRoleId, recommendMasterRoleIdList, isSuccess));
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\ShiTuManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */