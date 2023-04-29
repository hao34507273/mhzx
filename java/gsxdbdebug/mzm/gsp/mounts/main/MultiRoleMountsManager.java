/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mounts.SSyncRolesOnMultiRoleMounts;
/*     */ import mzm.gsp.mounts.confbean.SMountsCfg;
/*     */ import mzm.gsp.mounts.event.MultiRoleMountsChange;
/*     */ import mzm.gsp.mounts.event.MultiRoleMountsChangeArg;
/*     */ import mzm.gsp.mounts.event.MultiRoleMountsChangeArg.ChangeReason;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.team.main.TeamEventOneByOne;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MultiRoleMounts;
/*     */ import xbean.Pod;
/*     */ import xtable.Team2multirolemounts;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class MultiRoleMountsManager
/*     */ {
/*     */   static boolean isMultiRoleMountsSwitchOpen(long roleId, String logString)
/*     */   {
/*  32 */     if (!OpenInterface.getOpenStatus(409))
/*     */     {
/*  34 */       GameServer.logger().info(String.format("[mounts]%s@multi role mounts system switch closed|role_id=%d", new Object[] { logString, Long.valueOf(roleId) }));
/*     */       
/*  36 */       return false;
/*     */     }
/*  38 */     if (OpenInterface.isBanPlay(roleId, 409))
/*     */     {
/*  40 */       GameServer.logger().info(String.format("[mounts]%s@multi role mounts system is ban play|role_id=%d", new Object[] { logString, Long.valueOf(roleId) }));
/*     */       
/*  42 */       OpenInterface.sendBanPlayMsg(roleId, 409);
/*  43 */       return false;
/*     */     }
/*  45 */     return true;
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
/*     */   static MultiRoleMounts newMultiRoleMounts(long teamId)
/*     */   {
/*  58 */     if (null != Team2multirolemounts.get(Long.valueOf(teamId)))
/*     */     {
/*  60 */       GameServer.logger().error(String.format("[mounts]MultiRoleMountsManager.getNewMultiRoleMounts@MultiRoleMounts already exist!|teamId=%d,roleIds=%s", new Object[] { Long.valueOf(teamId) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  65 */     MultiRoleMounts xMultiRoleMounts = Pod.newMultiRoleMounts();
/*  66 */     Team2multirolemounts.add(Long.valueOf(teamId), xMultiRoleMounts);
/*  67 */     return xMultiRoleMounts;
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
/*     */   static void triggerMultiRoleMountsChangeViaTeam(long teamId, int mountsCfgId, List<Long> roleIds, MultiRoleMountsChangeArg.ChangeReason changeReason)
/*     */   {
/*  81 */     MultiRoleMountsChangeArg arg = new MultiRoleMountsChangeArg(teamId, mountsCfgId, new ArrayList(roleIds), changeReason);
/*  82 */     TriggerEventsManger.getInstance().triggerEvent(new MultiRoleMountsChange(), arg, TeamEventOneByOne.getInstance().getOneByOne());
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
/*     */   static void triggerMultiRoleMountsChangeViaRole(long roleId, long teamId, int mountsCfgId, List<Long> roleIds, MultiRoleMountsChangeArg.ChangeReason changeReason)
/*     */   {
/*  97 */     MultiRoleMountsChangeArg arg = new MultiRoleMountsChangeArg(teamId, mountsCfgId, new ArrayList(roleIds), changeReason);
/*  98 */     TriggerEventsManger.getInstance().triggerEvent(new MultiRoleMountsChange(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
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
/*     */   static SSyncRolesOnMultiRoleMounts getRolesOnMultiRoleProto(long teamId, int mountsCfgId, List<Long> roleIds)
/*     */   {
/* 112 */     SSyncRolesOnMultiRoleMounts protocol = new SSyncRolesOnMultiRoleMounts();
/* 113 */     protocol.team_id = teamId;
/* 114 */     protocol.mounts_cfg_id = mountsCfgId;
/* 115 */     for (int i = 0; i < roleIds.size(); i++)
/*     */     {
/* 117 */       if (((Long)roleIds.get(i)).longValue() > 0L)
/*     */       {
/* 119 */         protocol.on_mounts_role_id_map.put(Integer.valueOf(i + 1), roleIds.get(i));
/*     */       }
/*     */     }
/* 122 */     return protocol;
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
/*     */   static void onRoleRideMounts(long roleId, int mountsCfgId)
/*     */   {
/* 136 */     Long teamId = TeamInterface.getTeamidByRoleid(roleId, true);
/* 137 */     if (null == teamId)
/*     */     {
/* 139 */       return;
/*     */     }
/* 141 */     long leaderId = TeamInterface.getTeamLeaderByTeamid(teamId.longValue(), true);
/* 142 */     if (leaderId < 0L)
/*     */     {
/* 144 */       return;
/*     */     }
/*     */     
/*     */ 
/* 148 */     if (roleId != leaderId)
/*     */     {
/* 150 */       return;
/*     */     }
/*     */     
/* 153 */     MultiRoleMounts xMultiRoleMounts = Team2multirolemounts.get(teamId);
/*     */     
/* 155 */     if (null == xMultiRoleMounts)
/*     */     {
/* 157 */       GameServer.logger().warn(String.format("[mounts]MultiRoleMountsManager.onRoleRideMounts@MultiRoleMounts not exist!|roleId=%d,teamId=%d", new Object[] { Long.valueOf(roleId), teamId }));
/*     */       
/*     */ 
/*     */ 
/* 161 */       xMultiRoleMounts = newMultiRoleMounts(teamId.longValue());
/*     */     }
/*     */     
/* 164 */     List<Long> roleIds = xMultiRoleMounts.getRole_ids();
/* 165 */     roleIds.clear();
/*     */     
/*     */ 
/* 168 */     roleIds.add(Long.valueOf(roleId));
/*     */     
/* 170 */     xMultiRoleMounts.setMounts_cfg_id(mountsCfgId);
/*     */     
/*     */ 
/* 173 */     if (!OpenInterface.getOpenStatus(409))
/*     */     {
/* 175 */       return;
/*     */     }
/*     */     
/*     */ 
/* 179 */     triggerMultiRoleMountsChangeViaRole(roleId, teamId.longValue(), mountsCfgId, xMultiRoleMounts.getRole_ids(), MultiRoleMountsChangeArg.ChangeReason.LEADER_MOUNTS_CHANGE);
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
/*     */   static void onRoleUnrideMounts(long roleId, int mountsCfgId)
/*     */   {
/* 192 */     Long teamId = TeamInterface.getTeamidByRoleid(roleId, true);
/* 193 */     if (null == teamId)
/*     */     {
/* 195 */       return;
/*     */     }
/* 197 */     long leaderId = TeamInterface.getTeamLeaderByTeamid(teamId.longValue(), true);
/* 198 */     if (leaderId < 0L)
/*     */     {
/* 200 */       return;
/*     */     }
/*     */     
/*     */ 
/* 204 */     if (roleId != leaderId)
/*     */     {
/* 206 */       return;
/*     */     }
/*     */     
/* 209 */     MultiRoleMounts xMultiRoleMounts = Team2multirolemounts.get(teamId);
/*     */     
/* 211 */     if (null == xMultiRoleMounts)
/*     */     {
/* 213 */       GameServer.logger().warn(String.format("[mounts]MultiRoleMountsManager.onRoleUnrideMounts@MultiRoleMounts not exist!|roleId=%d,teamId=%d", new Object[] { Long.valueOf(roleId), teamId }));
/*     */       
/*     */ 
/*     */ 
/* 217 */       xMultiRoleMounts = newMultiRoleMounts(teamId.longValue());
/*     */     }
/*     */     
/*     */ 
/* 221 */     xMultiRoleMounts.getRole_ids().clear();
/*     */     
/* 223 */     xMultiRoleMounts.setMounts_cfg_id(0);
/*     */     
/*     */ 
/* 226 */     if (!OpenInterface.getOpenStatus(409))
/*     */     {
/* 228 */       return;
/*     */     }
/*     */     
/*     */ 
/* 232 */     triggerMultiRoleMountsChangeViaRole(roleId, teamId.longValue(), mountsCfgId, xMultiRoleMounts.getRole_ids(), MultiRoleMountsChangeArg.ChangeReason.LEADER_MOUNTS_CHANGE);
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
/*     */   static boolean removeUnmountRole(MultiRoleMounts xMultiRoleMounts, long roleId)
/*     */   {
/* 245 */     List<Long> mountRoleIds = xMultiRoleMounts.getRole_ids();
/* 246 */     for (int i = 0; i < mountRoleIds.size(); i++)
/*     */     {
/* 248 */       if (((Long)mountRoleIds.get(i)).longValue() == roleId)
/*     */       {
/* 250 */         mountRoleIds.set(i, Long.valueOf(-1L));
/* 251 */         return true;
/*     */       }
/*     */     }
/* 254 */     return false;
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
/*     */   static AddMountRoleResult addMountRole(MultiRoleMounts xMultiRoleMounts, long leaderId, long roleId)
/*     */   {
/* 269 */     if (leaderId == roleId)
/*     */     {
/* 271 */       return new AddMountRoleResult(false, MultiRoleMountsManager.AddMountRoleResult.FailReason.ROLE_IS_LEADER);
/*     */     }
/*     */     
/* 274 */     int mountsCfgId = xMultiRoleMounts.getMounts_cfg_id();
/* 275 */     if (mountsCfgId == 0)
/*     */     {
/* 277 */       return new AddMountRoleResult(false, MultiRoleMountsManager.AddMountRoleResult.FailReason.LEADER_NOT_RIDE);
/*     */     }
/* 279 */     int maxMountRoleNum = SMountsCfg.get(mountsCfgId).maxMountRoleNum;
/*     */     
/* 281 */     List<Long> mountRoleIds = xMultiRoleMounts.getRole_ids();
/* 282 */     int firstEmptyPosition = -1;
/* 283 */     for (int i = 0; i < mountRoleIds.size(); i++)
/*     */     {
/* 285 */       long curRoleId = ((Long)mountRoleIds.get(i)).longValue();
/*     */       
/* 287 */       if (curRoleId == roleId)
/*     */       {
/* 289 */         return new AddMountRoleResult(false, MultiRoleMountsManager.AddMountRoleResult.FailReason.ALREADY_RIDE);
/*     */       }
/*     */       
/* 292 */       if ((curRoleId == -1L) && (firstEmptyPosition == -1))
/*     */       {
/* 294 */         firstEmptyPosition = i;
/*     */       }
/*     */     }
/*     */     
/* 298 */     if (firstEmptyPosition != -1)
/*     */     {
/* 300 */       mountRoleIds.set(firstEmptyPosition, Long.valueOf(roleId));
/* 301 */       return new AddMountRoleResult(true);
/*     */     }
/*     */     
/* 304 */     if (mountRoleIds.size() < maxMountRoleNum)
/*     */     {
/* 306 */       mountRoleIds.add(Long.valueOf(roleId));
/* 307 */       return new AddMountRoleResult(true);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 312 */     return new AddMountRoleResult(false, MultiRoleMountsManager.AddMountRoleResult.FailReason.NO_POSITION);
/*     */   }
/*     */   
/*     */ 
/*     */   static class AddMountRoleResult
/*     */   {
/*     */     public boolean success;
/*     */     
/*     */     public FailReason failReason;
/*     */     
/*     */     public static enum FailReason
/*     */     {
/* 324 */       ALREADY_RIDE,  NO_POSITION,  LEADER_NOT_RIDE,  ROLE_IS_LEADER;
/*     */       
/*     */ 
/*     */       private FailReason() {}
/*     */     }
/*     */     
/*     */     public AddMountRoleResult(boolean success)
/*     */     {
/* 332 */       this.success = success;
/*     */     }
/*     */     
/*     */     public AddMountRoleResult(boolean success, FailReason failReason)
/*     */     {
/* 337 */       this.success = success;
/* 338 */       this.failReason = failReason;
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
/*     */   static MultiRoleMountsInfo getMultiRoleMountsInfo(long teamId, boolean retainLock)
/*     */   {
/* 353 */     MultiRoleMounts xMultiRoleMounts = Team2multirolemounts.select(Long.valueOf(teamId));
/*     */     
/* 355 */     if (null == xMultiRoleMounts)
/*     */     {
/* 357 */       return null;
/*     */     }
/* 359 */     int mountsCfgId = xMultiRoleMounts.getMounts_cfg_id();
/* 360 */     MultiRoleMountsInfo info = new MultiRoleMountsInfo(teamId, mountsCfgId, new ArrayList(xMultiRoleMounts.getRole_ids()));
/* 361 */     return info;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\MultiRoleMountsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */