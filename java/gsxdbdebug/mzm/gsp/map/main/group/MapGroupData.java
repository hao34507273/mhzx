/*     */ package mzm.gsp.map.main.group;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.map.MapGroupMemberInfo;
/*     */ import mzm.gsp.map.SMapGroupEnterView;
/*     */ import mzm.gsp.map.SMapGroupInfo;
/*     */ import mzm.gsp.map.SMapGroupLeaveView;
/*     */ import mzm.gsp.map.SMapGroupSyncPos;
/*     */ import mzm.gsp.map.SMapGroupTransferPos;
/*     */ import mzm.gsp.map.SSyncMapGroupExtraInfoChange;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.message.MapProtocolSendQueue;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.SceneManager;
/*     */ import mzm.gsp.map.main.scene.TransferType;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import xio.Protocol;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MapGroupData
/*     */ {
/*     */   private long leaderid;
/*  35 */   private List<Long> otherMemebers = new ArrayList();
/*     */   
/*     */ 
/*     */   private Map<Integer, Integer> extraInfos;
/*     */   
/*     */ 
/*     */ 
/*     */   public MapGroupData(List<Long> members, Map<Integer, Integer> extraInfos)
/*     */   {
/*  44 */     int size = members.size();
/*  45 */     if (size < 1)
/*     */     {
/*  47 */       throw new IllegalArgumentException(String.format("[map]MapGroupData.MapGroupData@memebers is empty", new Object[0]));
/*     */     }
/*  49 */     this.leaderid = ((Long)members.get(0)).longValue();
/*  50 */     if (size > 1)
/*     */     {
/*  52 */       this.otherMemebers.addAll(members.subList(1, size));
/*     */     }
/*  54 */     if (extraInfos == null)
/*     */     {
/*  56 */       this.extraInfos = null;
/*     */     }
/*     */     else
/*     */     {
/*  60 */       this.extraInfos = new HashMap(extraInfos);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getLeaderid()
/*     */   {
/*  71 */     return this.leaderid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Long> getOtherMemebersForInner()
/*     */   {
/*  81 */     return this.otherMemebers;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SMapGroupInfo createGroupInfoProtocol(MapGroupType groupType, long groupid, int groupSpeed)
/*     */   {
/*  93 */     SMapGroupInfo groupInfo = new SMapGroupInfo();
/*  94 */     groupInfo.group_type = groupType.ordinal();
/*  95 */     groupInfo.groupid = groupid;
/*  96 */     groupInfo.group_velocity = groupSpeed;
/*  97 */     if (this.extraInfos != null)
/*     */     {
/*  99 */       groupInfo.extra_infos.putAll(this.extraInfos);
/*     */     }
/* 101 */     groupInfo.leader = this.leaderid;
/* 102 */     groupInfo.other_members.addAll(this.otherMemebers);
/*     */     
/* 104 */     MapRole leader = MapObjectInstanceManager.getInstance().getMapRole(this.leaderid);
/* 105 */     if (leader != null)
/*     */     {
/* 107 */       groupInfo.key_point_path.addAll(leader.getKeyPointPath());
/*     */     }
/*     */     
/* 110 */     return groupInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void broadcastGroupInfo(MapRole role)
/*     */   {
/* 120 */     SMapGroupInfo groupInfo = createGroupInfoProtocol(role.getGroupType(), role.getGroupid(), role.getGroupSpeed());
/* 121 */     role.broadcastProtocolIncludeSelf(groupInfo);
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
/*     */   public void changeExtraInfos(MapGroupType groupType, long groupid, Map<Integer, Integer> replaceExtraInfoEntries, Set<Integer> removeExtraInfoKeys)
/*     */   {
/* 137 */     SSyncMapGroupExtraInfoChange core = new SSyncMapGroupExtraInfoChange();
/* 138 */     core.group_type = groupType.ordinal();
/* 139 */     core.groupid = groupid;
/* 140 */     if ((replaceExtraInfoEntries != null) && (!replaceExtraInfoEntries.isEmpty()))
/*     */     {
/* 142 */       if (this.extraInfos == null)
/*     */       {
/* 144 */         this.extraInfos = new HashMap(replaceExtraInfoEntries);
/*     */       }
/*     */       else
/*     */       {
/* 148 */         this.extraInfos.putAll(replaceExtraInfoEntries);
/*     */       }
/* 150 */       core.extra_infos.putAll(replaceExtraInfoEntries);
/*     */     }
/*     */     
/* 153 */     if ((removeExtraInfoKeys != null) && (!removeExtraInfoKeys.isEmpty()))
/*     */     {
/* 155 */       if (this.extraInfos != null)
/*     */       {
/* 157 */         for (Integer extraInfoType : removeExtraInfoKeys)
/*     */         {
/* 159 */           if (this.extraInfos.remove(extraInfoType) != null)
/*     */           {
/* 161 */             core.remove_extra_info_keys.add(extraInfoType);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 167 */     if ((core.extra_infos.isEmpty()) && (core.remove_extra_info_keys.isEmpty()))
/*     */     {
/* 169 */       return;
/*     */     }
/*     */     
/* 172 */     MapRole leader = MapObjectInstanceManager.getInstance().getMapRole(this.leaderid);
/* 173 */     if (leader == null)
/*     */     {
/* 175 */       return;
/*     */     }
/*     */     
/* 178 */     leader.broadcastProtocolIncludeSelf(core);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void brocadcastInGroup(Protocol protocol)
/*     */   {
/* 188 */     Set<Long> roleids = new HashSet();
/* 189 */     roleids.add(Long.valueOf(this.leaderid));
/* 190 */     roleids.addAll(this.otherMemebers);
/* 191 */     MapProtocolSendQueue.getInstance().sendMulti(roleids, protocol);
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
/*     */   public boolean groupTeleportWithProtocol(long transferId, int x, int y, int z, int targetX, int targetY, int sceneId, int channelid, TransferType type)
/*     */   {
/* 211 */     if (transferId != this.leaderid)
/*     */     {
/* 213 */       return false;
/*     */     }
/*     */     
/* 216 */     MapRole leader = MapObjectInstanceManager.getInstance().getMapRole(this.leaderid);
/* 217 */     if (!leader.isCanTransfer(sceneId, type))
/*     */     {
/* 219 */       return false;
/*     */     }
/*     */     
/* 222 */     Scene scene = SceneManager.getInstance().getScene(sceneId);
/* 223 */     if (scene == null)
/*     */     {
/* 225 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 229 */     SMapGroupTransferPos groupTransferPos = new SMapGroupTransferPos();
/* 230 */     groupTransferPos.group_type = leader.getGroupType().ordinal();
/* 231 */     groupTransferPos.groupid = leader.getGroupid();
/* 232 */     groupTransferPos.map_cfgid = scene.getCfgId();
/* 233 */     groupTransferPos.map_instance_id = sceneId;
/* 234 */     groupTransferPos.pos.x = x;
/* 235 */     groupTransferPos.pos.y = y;
/* 236 */     groupTransferPos.target_pos.x = targetX;
/* 237 */     groupTransferPos.target_pos.y = targetY;
/* 238 */     brocadcastInGroup(groupTransferPos);
/*     */     
/* 240 */     if (!leader.teleToLocation(x, y, z, sceneId, channelid, type))
/*     */     {
/* 242 */       return false;
/*     */     }
/*     */     
/* 245 */     return true;
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
/*     */   public void setXYZ(MapRole leader, int x, int y, int z, boolean isDirty)
/*     */   {
/* 259 */     if (leader.getRoleId() != this.leaderid)
/*     */     {
/* 261 */       return;
/*     */     }
/*     */     
/* 264 */     Scene scene = SceneManager.getInstance().getScene(leader.getSceneId());
/* 265 */     if (scene == null)
/*     */     {
/* 267 */       return;
/*     */     }
/*     */     
/* 270 */     if (isDirty)
/*     */     {
/* 272 */       SMapGroupSyncPos groupSyncPos = createGroupSyncPosProtocol(leader, scene);
/* 273 */       brocadcastInGroup(groupSyncPos);
/*     */     }
/*     */     
/* 276 */     for (Iterator i$ = this.otherMemebers.iterator(); i$.hasNext();) { long followerRoleid = ((Long)i$.next()).longValue();
/*     */       
/* 278 */       MapRole follower = MapObjectInstanceManager.getInstance().getMapRole(followerRoleid);
/* 279 */       follower.follow(x, y, z, scene.getId(), leader.getChannelid());
/*     */     }
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
/* 291 */     if (leader.getRoleId() != this.leaderid)
/*     */     {
/* 293 */       return null;
/*     */     }
/*     */     
/* 296 */     SMapGroupEnterView groupEnterView = new SMapGroupEnterView();
/* 297 */     groupEnterView.group_type = leader.getGroupType().ordinal();
/* 298 */     groupEnterView.groupid = leader.getGroupid();
/* 299 */     groupEnterView.group_velocity = leader.getGroupSpeed();
/* 300 */     if (this.extraInfos != null)
/*     */     {
/* 302 */       groupEnterView.extra_infos.putAll(this.extraInfos);
/*     */     }
/* 304 */     Position curPos = leader.getPositionForInner();
/* 305 */     groupEnterView.direction = leader.getDirection();
/* 306 */     groupEnterView.cur_pos.x = curPos.getX();
/* 307 */     groupEnterView.cur_pos.y = curPos.getY();
/* 308 */     groupEnterView.key_point_path.addAll(leader.getKeyPointPath());
/* 309 */     MapRole leaderRole = MapObjectInstanceManager.getInstance().getMapRole(this.leaderid);
/* 310 */     if (leaderRole != null)
/*     */     {
/* 312 */       boxGroupMemberInfo(groupEnterView.leader_info, this.leaderid, leaderRole);
/*     */     }
/* 314 */     for (Iterator i$ = this.otherMemebers.iterator(); i$.hasNext();) { long followerRoleid = ((Long)i$.next()).longValue();
/*     */       
/* 316 */       MapRole mapRole = MapObjectInstanceManager.getInstance().getMapRole(followerRoleid);
/* 317 */       if (mapRole != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 322 */         makeGroupOtherMemberInfo(groupEnterView, followerRoleid, mapRole);
/*     */       }
/*     */     }
/* 325 */     return groupEnterView;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Protocol createLeaveView(MapRole role)
/*     */   {
/* 335 */     SMapGroupLeaveView groupLeaveView = new SMapGroupLeaveView();
/* 336 */     groupLeaveView.group_type = role.getGroupType().ordinal();
/* 337 */     groupLeaveView.groupid = role.getGroupid();
/* 338 */     return groupLeaveView;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Protocol createMoveProtocol(MapRole leader)
/*     */   {
/* 349 */     long leaderid = getLeaderid();
/* 350 */     if (leader.getRoleId() != leaderid)
/*     */     {
/* 352 */       return null;
/*     */     }
/* 354 */     Scene scene = SceneManager.getInstance().getScene(leader.getSceneId());
/* 355 */     if (scene == null)
/*     */     {
/* 357 */       return null;
/*     */     }
/* 359 */     return createGroupSyncPosProtocol(leader, scene);
/*     */   }
/*     */   
/*     */   private SMapGroupSyncPos createGroupSyncPosProtocol(MapRole leader, Scene scene)
/*     */   {
/* 364 */     SMapGroupSyncPos groupSyncPos = new SMapGroupSyncPos();
/* 365 */     groupSyncPos.group_type = leader.getGroupType().ordinal();
/* 366 */     groupSyncPos.groupid = leader.getGroupid();
/* 367 */     groupSyncPos.key_point_path.addAll(leader.getKeyPointPath());
/* 368 */     groupSyncPos.map_cfgid = scene.getCfgId();
/* 369 */     groupSyncPos.map_instance_id = scene.getId();
/* 370 */     return groupSyncPos;
/*     */   }
/*     */   
/*     */   private void boxGroupMemberInfo(MapGroupMemberInfo groupMemberInfo, long roleid, MapRole mapRole)
/*     */   {
/* 375 */     groupMemberInfo.roleid = mapRole.getRoleId();
/* 376 */     groupMemberInfo.model_info = mapRole.getRoleModelCache();
/*     */   }
/*     */   
/*     */   private void makeGroupOtherMemberInfo(SMapGroupEnterView groupEnterView, long roleid, MapRole mapRole)
/*     */   {
/* 381 */     MapGroupMemberInfo groupMemberInfo = new MapGroupMemberInfo();
/* 382 */     boxGroupMemberInfo(groupMemberInfo, roleid, mapRole);
/* 383 */     groupEnterView.other_member_infos.add(groupMemberInfo);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\group\MapGroupData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */