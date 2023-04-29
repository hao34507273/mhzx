/*     */ package mzm.gsp.map.main.team;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.map.SMapLeaveTeam;
/*     */ import mzm.gsp.map.SMapTeamEnterView;
/*     */ import mzm.gsp.map.SMapTeamInfo;
/*     */ import mzm.gsp.map.SMapTeamLeaveView;
/*     */ import mzm.gsp.map.SMapTeamSyncPos;
/*     */ import mzm.gsp.map.SMapTeamTransferPos;
/*     */ import mzm.gsp.map.TeamMember;
/*     */ import mzm.gsp.map.main.MapManager;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.message.MapProtocolSendQueue;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.SceneManager;
/*     */ import mzm.gsp.map.main.scene.TransferType;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import mzm.gsp.map.main.scene.view.IView;
/*     */ import org.apache.log4j.Logger;
/*     */ import xio.Protocol;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MapTeamData
/*     */ {
/*  35 */   private static final Logger logger = Logger.getLogger(MapTeamData.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private final long id;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  45 */   private long leaderId = -1L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  50 */   private LinkedList<Long> inTeamMember = new LinkedList()
/*     */   {
/*     */ 
/*     */     public boolean add(Long roleid)
/*     */     {
/*     */ 
/*  56 */       if (contains(roleid))
/*     */       {
/*  58 */         if (MapTeamData.logger.isDebugEnabled())
/*     */         {
/*  60 */           MapTeamData.logger.debug("duplicate add to in team queue");
/*     */         }
/*  62 */         return false;
/*     */       }
/*  64 */       return super.add(roleid);
/*     */     }
/*     */   };
/*     */   
/*  68 */   private int multiMountsCfgid = 0;
/*  69 */   private List<Long> multiMountsRoles = new ArrayList();
/*     */   
/*  71 */   private volatile boolean isValid = true;
/*     */   
/*     */   public MapTeamData(long id, long leaderId)
/*     */   {
/*  75 */     this.id = id;
/*  76 */     this.leaderId = leaderId;
/*  77 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(leaderId);
/*  78 */     role.setTeamId(id);
/*     */   }
/*     */   
/*     */   public boolean isValid()
/*     */   {
/*  83 */     return this.isValid;
/*     */   }
/*     */   
/*     */   public void setValid(boolean isValid)
/*     */   {
/*  88 */     this.isValid = isValid;
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
/*     */   public void changeLeader(long newLeaderid, int flySpeed, long oldLeaderid, boolean oldLeaveTeam, boolean oldOffline)
/*     */   {
/* 104 */     if (!this.isValid)
/*     */     {
/* 106 */       logger.debug(String.format("[map]MapTeamData.changeLeader@team data invalid|teamid=%d|new_leaderid=%d|fly_speed=%d|old_leaderid=%d|old_leave_team=%b|old_offline=%b", new Object[] { Long.valueOf(this.id), Long.valueOf(newLeaderid), Integer.valueOf(flySpeed), Long.valueOf(oldLeaderid), Boolean.valueOf(oldLeaveTeam), Boolean.valueOf(oldOffline) }));
/*     */       
/*     */ 
/* 109 */       return;
/*     */     }
/*     */     
/* 112 */     MapRole newLeader = MapObjectInstanceManager.getInstance().getMapRole(newLeaderid);
/* 113 */     if (newLeader == null)
/*     */     {
/* 115 */       logger.error(String.format("[map]MapTeamData.changeLeader@map new leader is null|teamid=%d|new_leaderid=%d|fly_speed=%d|old_leaderid=%d|old_leave_team=%b|old_offline=%b", new Object[] { Long.valueOf(this.id), Long.valueOf(newLeaderid), Integer.valueOf(flySpeed), Long.valueOf(oldLeaderid), Boolean.valueOf(oldLeaveTeam), Boolean.valueOf(oldOffline) }));
/*     */       
/*     */ 
/* 118 */       return;
/*     */     }
/*     */     
/* 121 */     if (logger.isDebugEnabled())
/*     */     {
/* 123 */       logger.debug(String.format("[map]MapTeamData.changeLeader@检测到更换队长请求,新队长是%s|teamid=%d|new_leaderid=%d|fly_speed=%d|old_leaderid=%d|old_leave_team=%b|old_offline=%b", new Object[] { newLeader.getName(), Long.valueOf(this.id), Long.valueOf(newLeaderid), Integer.valueOf(flySpeed), Long.valueOf(oldLeaderid), Boolean.valueOf(oldLeaveTeam), Boolean.valueOf(oldOffline) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 128 */     newLeader.setTeamId(this.id);
/*     */     
/* 130 */     this.inTeamMember.remove(Long.valueOf(newLeaderid));
/* 131 */     this.leaderId = newLeaderid;
/*     */     
/* 133 */     Position pos = newLeader.getPositionForInner();
/* 134 */     newLeader.setTargetPos(pos.getX(), pos.getY(), pos.getZ());
/* 135 */     if (flySpeed <= 0)
/*     */     {
/* 137 */       newLeader.setFlySpeed(0);
/*     */     }
/*     */     else
/*     */     {
/* 141 */       newLeader.setFlySpeed(flySpeed);
/*     */     }
/*     */     
/* 144 */     MapRole oldLeader = MapObjectInstanceManager.getInstance().getMapRole(oldLeaderid);
/* 145 */     if (oldLeader != null)
/*     */     {
/* 147 */       oldLeader.updateMovePath(Collections.emptyList());
/*     */       
/* 149 */       this.inTeamMember.add(Long.valueOf(oldLeaderid));
/* 150 */       if (oldLeaveTeam)
/*     */       {
/* 152 */         if (oldOffline)
/*     */         {
/* 154 */           offlineTeam(oldLeaderid);
/*     */         }
/*     */         else
/*     */         {
/* 158 */           notInTeam(oldLeaderid, oldLeader.getFlySpeed());
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 163 */     for (Iterator i$ = this.inTeamMember.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 165 */       MapRole memeber = MapObjectInstanceManager.getInstance().getMapRole(roleid);
/* 166 */       if (memeber != null)
/*     */       {
/* 168 */         if (flySpeed <= 0)
/*     */         {
/* 170 */           memeber.setFlySpeed(0);
/*     */         }
/*     */         else
/*     */         {
/* 174 */           memeber.setFlySpeed(flySpeed);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 179 */     SMapTeamInfo mapTeamInfo = buildTeamInfo();
/* 180 */     newLeader.broadcastProtocolIncludeSelf(mapTeamInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void inTeam(long roleId)
/*     */   {
/* 190 */     if (logger.isDebugEnabled())
/*     */     {
/* 192 */       logger.debug(String.format("[map]MapTeamData.inTeam@member enter team info|teamid=%d|leaderid=%d|roleid=%d", new Object[] { Long.valueOf(this.id), Long.valueOf(this.leaderId), Long.valueOf(roleId) }));
/*     */     }
/*     */     
/*     */ 
/* 196 */     if (!this.isValid)
/*     */     {
/* 198 */       logger.info(String.format("[map]MapTeamData.inTeam@team data invalid|teamid=%d|leaderid=%d|roleid=%d", new Object[] { Long.valueOf(this.id), Long.valueOf(this.leaderId), Long.valueOf(roleId) }));
/*     */       
/* 200 */       return;
/*     */     }
/*     */     
/* 203 */     if (this.inTeamMember.contains(Long.valueOf(roleId)))
/*     */     {
/* 205 */       logger.info(String.format("[map]MapTeamData.inTeam@role already in team|teamid=%d|leaderid=%d|roleid=%d", new Object[] { Long.valueOf(this.id), Long.valueOf(this.leaderId), Long.valueOf(roleId) }));
/*     */       
/* 207 */       return;
/*     */     }
/*     */     
/* 210 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(roleId);
/* 211 */     if (role == null)
/*     */     {
/* 213 */       logger.info(String.format("[map]MapTeamData.inTeam@map role is null|teamid=%d|leaderid=%d|roleid=%d", new Object[] { Long.valueOf(this.id), Long.valueOf(this.leaderId), Long.valueOf(roleId) }));
/*     */       
/* 215 */       return;
/*     */     }
/*     */     
/* 218 */     MapRole leader = MapObjectInstanceManager.getInstance().getMapRole(this.leaderId);
/* 219 */     if (leader == null)
/*     */     {
/* 221 */       logger.info(String.format("[map]MapTeamData.inTeam@map leader is null|teamid=%d|leaderid=%d|roleid=%d", new Object[] { Long.valueOf(this.id), Long.valueOf(this.leaderId), Long.valueOf(roleId) }));
/*     */       
/* 223 */       return;
/*     */     }
/*     */     
/* 226 */     if (logger.isDebugEnabled())
/*     */     {
/* 228 */       logger.debug(String.format("[map]MapTeamData.inTeam@%s加入队伍,当前队长是%s|teamid=%d|leaderid=%d|roleid=%d", new Object[] { role.getName(), leader.getName(), Long.valueOf(this.id), Long.valueOf(this.leaderId), Long.valueOf(roleId) }));
/*     */     }
/*     */     
/*     */ 
/* 232 */     if (!role.canJoinTeamOrGroup(leader))
/*     */     {
/* 234 */       logger.info(String.format("[map]MapTeamData.inTeam@can not join team|teamid=%d|leaderid=%d|roleid=%d", new Object[] { role.getName(), leader.getName(), Long.valueOf(this.id), Long.valueOf(this.leaderId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*     */ 
/* 238 */       MapManager.forceTmpLeaveTeam(roleId);
/*     */       
/* 240 */       return;
/*     */     }
/*     */     
/* 243 */     afterMemberInTeam(leader, role);
/*     */     
/* 245 */     SMapTeamInfo mapTeamInfo = buildTeamInfo();
/* 246 */     leader.broadcastProtocolIncludeSelf(mapTeamInfo);
/*     */   }
/*     */   
/*     */   public void afterMemberInTeam(MapRole leaderRole, MapRole memberRole)
/*     */   {
/* 251 */     Position pos = leaderRole.getPositionForInner();
/* 252 */     memberRole.setTargetPos(pos.getX(), pos.getY(), pos.getZ());
/* 253 */     memberRole.setXunLuoState(false);
/*     */     
/*     */ 
/* 256 */     if (!memberRole.getView().getPlayers().contains(leaderRole))
/*     */     {
/* 258 */       memberRole.teleportWithProtocol(pos.getX(), pos.getY(), pos.getZ(), pos.getX(), pos.getY(), pos.getSceneId(), leaderRole.getChannelid(), TransferType.TEAM);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 263 */       memberRole.setXYZ(pos.getX(), pos.getY(), pos.getZ());
/*     */     }
/*     */     
/* 266 */     if (leaderRole.isFlyState())
/*     */     {
/* 268 */       memberRole.setFlySpeed(leaderRole.getFlySpeed());
/* 269 */       Position targetPos = memberRole.getTargetPosForInner();
/* 270 */       memberRole.setTargetPos(targetPos.getX(), targetPos.getY(), 0);
/*     */     }
/*     */     
/* 273 */     this.inTeamMember.add(Long.valueOf(memberRole.getRoleId()));
/* 274 */     memberRole.setTeamId(this.id);
/*     */     
/* 276 */     Protocol protocol = createTeamMoveProtocol(leaderRole);
/* 277 */     memberRole.sendMapProtocol(protocol);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void notInTeam(long roleId, int flySpeed)
/*     */   {
/* 288 */     if (logger.isDebugEnabled())
/*     */     {
/* 290 */       logger.debug(String.format("[map]MapTeamData.notInTeam@member not in team|teamid=%d|leaderid=%d|roleid=%d|fly_speed=%d", new Object[] { Long.valueOf(this.id), Long.valueOf(this.leaderId), Long.valueOf(roleId), Integer.valueOf(flySpeed) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 295 */     if (!this.isValid)
/*     */     {
/* 297 */       logger.info(String.format("[map]MapTeamData.notInTeam@team data invalid|teamid=%d|leaderid=%d|roleid=%d|fly_speed=%d", new Object[] { Long.valueOf(this.id), Long.valueOf(this.leaderId), Long.valueOf(roleId), Integer.valueOf(flySpeed) }));
/*     */       
/*     */ 
/*     */ 
/* 301 */       return;
/*     */     }
/*     */     
/* 304 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(roleId);
/*     */     
/* 306 */     if (role == null)
/*     */     {
/* 308 */       logger.info(String.format("[map]MapTeamData.notInTeam@map role is null|teamid=%d|leaderid=%d|roleid=%d|fly_speed=%d", new Object[] { Long.valueOf(this.id), Long.valueOf(this.leaderId), Long.valueOf(roleId), Integer.valueOf(flySpeed) }));
/*     */       
/*     */ 
/*     */ 
/* 312 */       return;
/*     */     }
/*     */     
/*     */ 
/* 316 */     if (isLeader(roleId))
/*     */     {
/* 318 */       logger.info(String.format("[map]MapTeamData.notInTeam@%s取消跟随,检测到是队长|teamid=%d|leaderid=%d|roleid=%d|fly_speed=%d", new Object[] { role.getName(), Long.valueOf(this.id), Long.valueOf(this.leaderId), Long.valueOf(roleId), Integer.valueOf(flySpeed) }));
/*     */       
/* 320 */       return;
/*     */     }
/*     */     
/* 323 */     MapRole leader = MapObjectInstanceManager.getInstance().getMapRole(this.leaderId);
/* 324 */     if (leader == null)
/*     */     {
/* 326 */       logger.info(String.format("[map]MapTeamData.notInTeam@map leader is null|teamid=%d|leaderid=%d|roleid=%d|fly_speed=%d", new Object[] { Long.valueOf(this.id), Long.valueOf(this.leaderId), Long.valueOf(roleId), Integer.valueOf(flySpeed) }));
/*     */       
/*     */ 
/*     */ 
/* 330 */       return;
/*     */     }
/*     */     
/* 333 */     if (logger.isDebugEnabled())
/*     */     {
/* 335 */       logger.debug(String.format("[map]MapTeamData.notInTeam@%s取消跟随%s|teamid=%d|leaderid=%d|roleid=%d|fly_speed=%d", new Object[] { role.getName(), leader.getName(), Long.valueOf(this.id), Long.valueOf(this.leaderId), Long.valueOf(roleId), Integer.valueOf(flySpeed) }));
/*     */     }
/*     */     
/*     */ 
/* 339 */     role.setTeamId(-1L);
/* 340 */     if (!this.inTeamMember.remove(Long.valueOf(roleId)))
/*     */     {
/* 342 */       logger.info(String.format("[map]MapTeamData.notInTeam@not team member|teamid=%d|leaderid=%d|roleid=%d|fly_speed=%d", new Object[] { Long.valueOf(this.id), Long.valueOf(this.leaderId), Long.valueOf(roleId), Integer.valueOf(flySpeed) }));
/*     */       
/*     */ 
/* 345 */       return;
/*     */     }
/*     */     
/* 348 */     role.setFlySpeed(flySpeed);
/* 349 */     role.setXunLuoState(false);
/*     */     
/* 351 */     brocadcastLeaveTeamProtocol(role);
/*     */     
/*     */ 
/* 354 */     role.tryShowFollower();
/*     */     
/* 356 */     adjustTeamMemberPos(leader, role);
/*     */   }
/*     */   
/*     */   public static void adjustTeamMemberPos(MapRole leader, MapRole role)
/*     */   {
/* 361 */     if ((leader == null) || (role == null) || (leader == role))
/*     */     {
/* 363 */       return;
/*     */     }
/*     */     
/* 366 */     Position targetPos = null;
/* 367 */     if (role.getFlySpeed() <= 0)
/*     */     {
/* 369 */       Position currPos = leader.getPositionForInner();
/* 370 */       Scene scene = SceneManager.getInstance().getScene(currPos.getSceneId());
/* 371 */       if (scene != null)
/*     */       {
/* 373 */         targetPos = scene.getFlyLandPositionForInner(currPos);
/*     */       }
/* 375 */       if (targetPos != null)
/*     */       {
/* 377 */         role.setTargetPos(targetPos.getX(), targetPos.getY(), targetPos.getZ(), targetPos.getSceneId());
/* 378 */         role.setXYZ(targetPos.getX(), targetPos.getY(), targetPos.getZ());
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 383 */       targetPos = leader.getTargetPosForInner();
/* 384 */       role.setTargetPos(targetPos.getX(), targetPos.getY(), targetPos.getZ(), targetPos.getSceneId());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void offlineTeam(long roleId)
/*     */   {
/* 396 */     if (logger.isDebugEnabled())
/*     */     {
/* 398 */       logger.debug(String.format("[map]MapTeamData.offlineTeam@offline team info|teamid=%d|leaderid=%d|roleid=%d", new Object[] { Long.valueOf(this.id), Long.valueOf(this.leaderId), Long.valueOf(roleId) }));
/*     */     }
/*     */     
/*     */ 
/* 402 */     if (!this.isValid)
/*     */     {
/* 404 */       logger.info(String.format("[map]MapTeamData.offlineTeam@team data invalid|teamid=%d|leaderid=%d|roleid=%d", new Object[] { Long.valueOf(this.id), Long.valueOf(this.leaderId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/* 407 */       return;
/*     */     }
/*     */     
/*     */ 
/* 411 */     if (isLeader(roleId))
/*     */     {
/* 413 */       logger.info(String.format("[map]MapTeamData.offlineTeam@leader offline|teamid=%d|leaderid=%d|roleid=%d", new Object[] { Long.valueOf(this.id), Long.valueOf(this.leaderId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/* 416 */       return;
/*     */     }
/*     */     
/* 419 */     notInTeam(roleId, 0);
/*     */     
/* 421 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(roleId);
/* 422 */     if (role != null)
/*     */     {
/* 424 */       role.destroy();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void leaveTeam(long roleId, int flyspeed)
/*     */   {
/* 435 */     notInTeam(roleId, flyspeed);
/*     */   }
/*     */   
/*     */   public void setMultiMountsInfo(int multiMountsCfgid, List<Long> multiMountsRoles)
/*     */   {
/* 440 */     if (!this.isValid)
/*     */     {
/* 442 */       return;
/*     */     }
/*     */     
/* 445 */     this.multiMountsCfgid = multiMountsCfgid;
/*     */     
/* 447 */     if (!this.multiMountsRoles.isEmpty())
/*     */     {
/* 449 */       this.multiMountsRoles.clear();
/*     */     }
/* 451 */     if (!multiMountsRoles.isEmpty())
/*     */     {
/* 453 */       this.multiMountsRoles.addAll(multiMountsRoles);
/*     */     }
/*     */   }
/*     */   
/*     */   void brocadcastLeaveTeamProtocol(MapRole role)
/*     */   {
/* 459 */     SMapLeaveTeam leaveTeam = new SMapLeaveTeam();
/* 460 */     leaveTeam.teamid = this.id;
/* 461 */     leaveTeam.roleid = role.getRoleId();
/* 462 */     role.broadcastProtocolIncludeSelf(leaveTeam);
/*     */     
/*     */ 
/* 465 */     if (this.leaderId == -1L)
/*     */     {
/* 467 */       return;
/*     */     }
/*     */     
/* 470 */     SMapTeamInfo mapTeamInfo = buildTeamInfo();
/* 471 */     role.broadcastProtocolIncludeSelf(mapTeamInfo);
/*     */   }
/*     */   
/*     */   public SMapTeamInfo buildTeamInfo()
/*     */   {
/* 476 */     SMapTeamInfo mapTeamInfo = new SMapTeamInfo();
/* 477 */     mapTeamInfo.teamid = this.id;
/* 478 */     mapTeamInfo.teamleader = getLeaderId();
/* 479 */     mapTeamInfo.followerids.addAll(getInTeamMember());
/* 480 */     mapTeamInfo.memnum = (this.inTeamMember.size() + 1);
/* 481 */     mapTeamInfo.multimountsid = this.multiMountsCfgid;
/* 482 */     mapTeamInfo.multimountsrolelist.addAll(this.multiMountsRoles);
/*     */     
/* 484 */     return mapTeamInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void broadcastTeamInfo(MapRole role)
/*     */   {
/* 494 */     SMapTeamInfo mapTeamInfo = buildTeamInfo();
/* 495 */     role.broadcastProtocolIncludeSelf(mapTeamInfo);
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
/*     */   public boolean teamTeleportWithProtocol(long transferId, int x, int y, int z, int targetX, int targetY, int sceneId, int channelid, TransferType type)
/*     */   {
/* 511 */     if (transferId != this.leaderId)
/*     */     {
/* 513 */       return false;
/*     */     }
/*     */     
/* 516 */     MapRole leader = MapObjectInstanceManager.getInstance().getMapRole(this.leaderId);
/* 517 */     if (leader == null)
/*     */     {
/* 519 */       return false;
/*     */     }
/* 521 */     if (!leader.isCanTransfer(sceneId, type))
/*     */     {
/* 523 */       return false;
/*     */     }
/*     */     
/* 526 */     Scene scene = SceneManager.getInstance().getScene(sceneId);
/* 527 */     if (scene == null)
/*     */     {
/* 529 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 533 */     SMapTeamTransferPos mapTeamTransferPos = new SMapTeamTransferPos();
/* 534 */     mapTeamTransferPos.teamid = this.id;
/* 535 */     mapTeamTransferPos.direction = leader.getDirection();
/* 536 */     mapTeamTransferPos.mapid = scene.getCfgId();
/* 537 */     mapTeamTransferPos.mapinstanceid = sceneId;
/* 538 */     mapTeamTransferPos.pos.x = x;
/* 539 */     mapTeamTransferPos.pos.y = y;
/* 540 */     mapTeamTransferPos.targetpos.x = targetX;
/* 541 */     mapTeamTransferPos.targetpos.y = targetY;
/* 542 */     brocadcastInTeam(mapTeamTransferPos);
/*     */     
/* 544 */     if (!leader.teleToLocation(x, y, z, sceneId, channelid, type))
/*     */     {
/* 546 */       return false;
/*     */     }
/* 548 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void brocadcastInTeam(Protocol protocol)
/*     */   {
/* 558 */     Set<Long> roleIdSet = new HashSet();
/* 559 */     roleIdSet.add(Long.valueOf(this.leaderId));
/* 560 */     roleIdSet.addAll(this.inTeamMember);
/* 561 */     MapProtocolSendQueue.getInstance().sendMulti(roleIdSet, protocol);
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
/*     */   public void setXYZ(MapRole role, int x, int y, int z, boolean isDirty)
/*     */   {
/* 574 */     if (role.getRoleId() != this.leaderId)
/*     */     {
/* 576 */       return;
/*     */     }
/*     */     
/* 579 */     MapRole leader = MapObjectInstanceManager.getInstance().getMapRole(this.leaderId);
/* 580 */     if (leader == null)
/*     */     {
/* 582 */       return;
/*     */     }
/*     */     
/* 585 */     Scene scene = SceneManager.getInstance().getScene(leader.getSceneId());
/* 586 */     if (scene == null)
/*     */     {
/* 588 */       return;
/*     */     }
/*     */     
/* 591 */     if (isDirty)
/*     */     {
/* 593 */       SMapTeamSyncPos mapTeamSyncPos = new SMapTeamSyncPos();
/* 594 */       mapTeamSyncPos.teamid = this.id;
/* 595 */       mapTeamSyncPos.direction = leader.getDirection();
/* 596 */       mapTeamSyncPos.mapid = scene.getCfgId();
/* 597 */       mapTeamSyncPos.mapinstanceid = scene.getId();
/* 598 */       mapTeamSyncPos.keypointpath.addAll(leader.getKeyPointPath());
/* 599 */       MapProtocolSendQueue.getInstance().sendMulti(this.inTeamMember, mapTeamSyncPos);
/*     */     }
/*     */     
/* 602 */     for (Iterator i$ = this.inTeamMember.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 604 */       MapRole member = MapObjectInstanceManager.getInstance().getMapRole(roleId);
/* 605 */       member.follow(x, y, z, scene.getId(), leader.getChannelid());
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isLeader(long roleId)
/*     */   {
/* 611 */     return this.leaderId == roleId;
/*     */   }
/*     */   
/*     */   public Collection<Long> getInTeamMember()
/*     */   {
/* 616 */     return this.inTeamMember;
/*     */   }
/*     */   
/*     */   public long getId()
/*     */   {
/* 621 */     return this.id;
/*     */   }
/*     */   
/*     */   public long getLeaderId()
/*     */   {
/* 626 */     return this.leaderId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Protocol createEnterView(MapRole leader)
/*     */   {
/* 637 */     if (leader.getRoleId() != getLeaderId())
/*     */     {
/* 639 */       return null;
/*     */     }
/*     */     
/* 642 */     SMapTeamEnterView teamEnterView = new SMapTeamEnterView();
/* 643 */     teamEnterView.teamid = this.id;
/* 644 */     teamEnterView.memnum = (this.inTeamMember.size() + 1);
/* 645 */     teamEnterView.keypointpath.addAll(leader.getKeyPointPath());
/* 646 */     Position curPos = leader.getPositionForInner();
/* 647 */     teamEnterView.curpos.x = curPos.getX();
/* 648 */     teamEnterView.curpos.y = curPos.getY();
/* 649 */     teamEnterView.direction = leader.getDirection();
/* 650 */     fillTeamMember(teamEnterView.leaderinfo, leader);
/*     */     
/* 652 */     if (logger.isDebugEnabled())
/*     */     {
/* 654 */       Position pos = leader.getPositionForInner();
/* 655 */       Position targetPos = leader.getTargetPosForInner();
/* 656 */       logger.debug(String.format("mapteam member name:%s go : x: %d, y: %d; tx: %d, ty: %d", new Object[] { leader.getName(), Integer.valueOf(pos.getX()), Integer.valueOf(pos.getY()), Integer.valueOf(targetPos.getX()), Integer.valueOf(targetPos.getY()) }));
/*     */     }
/*     */     
/*     */ 
/* 660 */     for (Long roleId : getInTeamMember())
/*     */     {
/* 662 */       MapRole role = MapObjectInstanceManager.getInstance().getMapRole(roleId.longValue());
/*     */       
/* 664 */       if (role != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 669 */         TeamMember tm = new TeamMember();
/* 670 */         fillTeamMember(tm, role);
/* 671 */         teamEnterView.memberinfo.add(tm);
/*     */       }
/*     */     }
/* 674 */     teamEnterView.multimountsid = this.multiMountsCfgid;
/* 675 */     teamEnterView.multimountsrolelist.addAll(this.multiMountsRoles);
/*     */     
/* 677 */     return teamEnterView;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Protocol createLeaveView(MapRole role)
/*     */   {
/* 687 */     SMapTeamLeaveView teamLeaveView = new SMapTeamLeaveView();
/* 688 */     teamLeaveView.teamid = this.id;
/* 689 */     return teamLeaveView;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Protocol createTeamMoveProtocol(MapRole leader)
/*     */   {
/* 700 */     if (leader.getRoleId() != getLeaderId())
/*     */     {
/* 702 */       return null;
/*     */     }
/*     */     
/* 705 */     Scene scene = SceneManager.getInstance().getScene(leader.getSceneId());
/* 706 */     if (scene == null)
/*     */     {
/* 708 */       return null;
/*     */     }
/*     */     
/* 711 */     SMapTeamSyncPos mapTeamSyncPos = new SMapTeamSyncPos();
/* 712 */     mapTeamSyncPos.teamid = this.id;
/* 713 */     mapTeamSyncPos.direction = leader.getDirection();
/* 714 */     mapTeamSyncPos.mapid = scene.getCfgId();
/* 715 */     mapTeamSyncPos.mapinstanceid = scene.getId();
/* 716 */     mapTeamSyncPos.keypointpath.addAll(leader.getKeyPointPath());
/* 717 */     return mapTeamSyncPos;
/*     */   }
/*     */   
/*     */   private void fillTeamMember(TeamMember tm, MapRole role)
/*     */   {
/* 722 */     tm.roleid = role.getRoleId();
/* 723 */     tm.modelinfo = role.getRoleModelCache();
/* 724 */     if (role.getPetModel() != null)
/*     */     {
/* 726 */       tm.models.put(Integer.valueOf(1), role.getPetModelCache());
/*     */     }
/* 728 */     else if (role.getChildrenModel() != null)
/*     */     {
/* 730 */       tm.models.put(Integer.valueOf(2), role.getChildrenModelCache());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\team\MapTeamData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */