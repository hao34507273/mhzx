/*     */ package mzm.gsp.qingyuan.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingyuan.SQingYuanNormalFail;
/*     */ import mzm.gsp.qingyuan.confbean.QingYuanConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.TeamMember;
/*     */ import mzm.gsp.title.main.TitleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2QingYuanInfo;
/*     */ import xtable.Role2qingyuan;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class QingYuanManager
/*     */ {
/*     */   static void setQingYuanRoleInfo(long qingYuanRoleId, mzm.gsp.qingyuan.QingYuanRoleInfo qingYuanRoleInfo)
/*     */   {
/*  36 */     qingYuanRoleInfo.gender = RoleInterface.getGender(qingYuanRoleId);
/*  37 */     qingYuanRoleInfo.occupation_id = RoleInterface.getOccupationId(qingYuanRoleId);
/*  38 */     qingYuanRoleInfo.role_id = qingYuanRoleId;
/*  39 */     qingYuanRoleInfo.role_level = RoleInterface.getLevel(qingYuanRoleId);
/*  40 */     qingYuanRoleInfo.role_name = RoleInterface.getName(qingYuanRoleId);
/*  41 */     if (!OnlineManager.getInstance().isOnlineOrInProtect(qingYuanRoleId))
/*     */     {
/*  43 */       qingYuanRoleInfo.offline_time = RoleInterface.getLastLogoffTime(qingYuanRoleId);
/*     */     }
/*     */     else
/*     */     {
/*  47 */       qingYuanRoleInfo.offline_time = -1L;
/*     */     }
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void clearQingYuanRelation(long activeRoleId, long passiveRoleId, List<Long> xActiveRoleQingYuanList, List<Long> xPassiveRoleQingYuanList, Role2QingYuanInfo xActiveRole2QingYuanInfo, Role2QingYuanInfo xPassiveRole2QingYuanInfo)
/*     */   {
/*  77 */     xActiveRoleQingYuanList.remove(Long.valueOf(passiveRoleId));
/*  78 */     xbean.QingYuanRoleInfo xActiveQingYuanRoleInfo = (xbean.QingYuanRoleInfo)xActiveRole2QingYuanInfo.getQing_yuan_map_info().remove(Long.valueOf(passiveRoleId));
/*     */     
/*  80 */     xActiveRole2QingYuanInfo.getAleardy_used_appellation_cfg_id_set().remove(Integer.valueOf(xActiveQingYuanRoleInfo.getAppellation_cfg_id()));
/*     */     
/*  82 */     TitleInterface.removeAppllation(activeRoleId, xActiveQingYuanRoleInfo.getAppellation_cfg_id());
/*     */     
/*     */ 
/*  85 */     xPassiveRoleQingYuanList.remove(Long.valueOf(activeRoleId));
/*  86 */     xbean.QingYuanRoleInfo xPassiveQingYuanRoleInfo = (xbean.QingYuanRoleInfo)xPassiveRole2QingYuanInfo.getQing_yuan_map_info().remove(Long.valueOf(activeRoleId));
/*     */     
/*  88 */     xPassiveRole2QingYuanInfo.getAleardy_used_appellation_cfg_id_set().remove(Integer.valueOf(xPassiveQingYuanRoleInfo.getAppellation_cfg_id()));
/*     */     
/*  90 */     TitleInterface.removeAppllation(passiveRoleId, xPassiveQingYuanRoleInfo.getAppellation_cfg_id());
/*     */     
/*  92 */     BuffInterface.uninstallBuf(activeRoleId, QingYuanConsts.getInstance().qingYuanRelationTeamBuffId);
/*  93 */     BuffInterface.uninstallBuf(passiveRoleId, QingYuanConsts.getInstance().qingYuanRelationTeamBuffId);
/*     */     
/*  95 */     GameServer.logger().info(String.format("[qingyuan]QingYuanManager.clearQingYuanRelation@qing yuan relation relieve|active_role_id=%d|passive_role_id=%d", new Object[] { Long.valueOf(activeRoleId), Long.valueOf(passiveRoleId) }));
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onQingYuanFail(long receiveRoleId, int result, List<String> params)
/*     */   {
/* 113 */     SQingYuanNormalFail sQingYuanNormalFail = new SQingYuanNormalFail();
/* 114 */     sQingYuanNormalFail.result = result;
/* 115 */     sQingYuanNormalFail.params.addAll(params);
/*     */     
/* 117 */     OnlineManager.getInstance().sendAtOnce(receiveRoleId, sQingYuanNormalFail);
/*     */   }
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
/*     */ 
/*     */   static boolean isQingYuanSwitchOpen(long roleId, String logString)
/*     */   {
/* 132 */     if (!OpenInterface.getOpenStatus(150))
/*     */     {
/* 134 */       GameServer.logger().info(String.format("[qingyuan]%s@qing yuan system switch closed|role_id=%d", new Object[] { logString, Long.valueOf(roleId) }));
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     if (OpenInterface.isBanPlay(roleId, 150))
/*     */     {
/* 140 */       GameServer.logger().info(String.format("[qingyuan]%s@qing yuan is ban play|role_id=%d", new Object[] { logString, Long.valueOf(roleId) }));
/*     */       
/* 142 */       OpenInterface.sendBanPlayMsg(roleId, 150);
/* 143 */       return false;
/*     */     }
/*     */     
/* 146 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void tlogQingYuanRelation(long activeRoleId, long passiveRoleId, String activeUserId, String passiveUserId, QingYuanRelationTLogEnum tLogEnum)
/*     */   {
/* 158 */     int activeRoleLevel = RoleInterface.getLevel(activeRoleId);
/* 159 */     int passiveRoleLevel = RoleInterface.getLevel(passiveRoleId);
/*     */     
/* 161 */     StringBuilder sbLog = new StringBuilder();
/* 162 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 163 */     sbLog.append(activeUserId).append('|');
/* 164 */     sbLog.append(activeRoleId).append('|');
/* 165 */     sbLog.append(activeRoleLevel).append('|');
/*     */     
/* 167 */     sbLog.append(passiveUserId).append('|');
/* 168 */     sbLog.append(passiveRoleId).append('|');
/* 169 */     sbLog.append(passiveRoleLevel).append('|');
/* 170 */     sbLog.append(tLogEnum.getOperator());
/*     */     
/* 172 */     TLogManager.getInstance().addLog(activeRoleId, "QingYuanStatis", sbLog.toString());
/*     */   }
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
/*     */   static void updateQingYuanTeamBuff(Set<Long> uninstallBuffRoleIdSet, List<TeamMember> teamMembers)
/*     */   {
/* 186 */     for (Iterator i$ = uninstallBuffRoleIdSet.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 188 */       BuffInterface.uninstallBuf(roleId, QingYuanConsts.getInstance().qingYuanRelationTeamBuffId);
/*     */     }
/*     */     
/*     */ 
/* 192 */     Map<Long, List<Long>> qingYuanRelationMap = new HashMap();
/*     */     
/* 194 */     for (TeamMember teamMember : teamMembers)
/*     */     {
/* 196 */       if (teamMember.status == 0)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 201 */         long roleId = teamMember.roleid;
/* 202 */         Role2QingYuanInfo xRole2QingYuanInfo = Role2qingyuan.get(Long.valueOf(roleId));
/* 203 */         if (xRole2QingYuanInfo != null)
/*     */         {
/* 205 */           List<Long> xQingYuanRoleList = xRole2QingYuanInfo.getQing_yuan_role_list();
/* 206 */           qingYuanRelationMap.put(Long.valueOf(roleId), xQingYuanRoleList);
/*     */         }
/*     */       }
/*     */     }
/* 210 */     if (qingYuanRelationMap.isEmpty())
/*     */     {
/* 212 */       return;
/*     */     }
/*     */     
/* 215 */     Set<Long> installBuffRoleIdSet = new HashSet();
/* 216 */     for (Iterator i$ = qingYuanRelationMap.entrySet().iterator(); i$.hasNext();) { entry = (Map.Entry)i$.next();
/*     */       
/* 218 */       List<Long> qingYuanRoleList = (List)entry.getValue();
/* 219 */       for (i$ = qingYuanRoleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/* 221 */         if (qingYuanRelationMap.containsKey(Long.valueOf(roleId)))
/*     */         {
/* 223 */           installBuffRoleIdSet.add(Long.valueOf(roleId));
/* 224 */           installBuffRoleIdSet.add(entry.getKey());
/*     */         } } }
/*     */     Map.Entry<Long, List<Long>> entry;
/*     */     Iterator i$;
/* 228 */     for (Iterator i$ = installBuffRoleIdSet.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 230 */       BuffInterface.installBuff(roleId, QingYuanConsts.getInstance().qingYuanRelationTeamBuffId);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\main\QingYuanManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */