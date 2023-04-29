/*     */ package mzm.gsp.map.main.group;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.SMapGroupDissole;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.SceneManager;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class MapGroupManager
/*     */ {
/*  19 */   private static final MapGroupManager instance = new MapGroupManager();
/*     */   
/*     */   public static MapGroupManager getInstance()
/*     */   {
/*  23 */     return instance;
/*     */   }
/*     */   
/*  26 */   private Map<MapGroupType, Map<Long, MapGroupData>> typeToGroupDataMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public MapGroupData getMapGroupData(MapGroupType groupType, long groupid)
/*     */   {
/*  34 */     Map<Long, MapGroupData> groupDataMap = (Map)this.typeToGroupDataMap.get(groupType);
/*  35 */     if (groupDataMap == null)
/*     */     {
/*  37 */       return null;
/*     */     }
/*     */     
/*  40 */     return (MapGroupData)groupDataMap.get(Long.valueOf(groupid));
/*     */   }
/*     */   
/*     */ 
/*     */   public void addGroupData(MapGroupType groupType, long groupid, List<Long> roleids, int groupSpeed, Map<Integer, Integer> groupExtraInfos)
/*     */   {
/*  46 */     MapGroupData mapGroupData = new MapGroupData(roleids, groupExtraInfos);
/*  47 */     onNewGroupCreate(groupType, groupid, mapGroupData, groupSpeed);
/*     */   }
/*     */   
/*     */ 
/*     */   public void removeGroupData(MapGroupType groupType, long groupid, Map<Long, Integer> nowFlyRoles, Set<Long> offlineRoles)
/*     */   {
/*  53 */     Map<Long, MapGroupData> groupDataMap = (Map)this.typeToGroupDataMap.get(groupType);
/*  54 */     if (groupDataMap == null)
/*     */     {
/*  56 */       return;
/*     */     }
/*     */     
/*  59 */     MapGroupData groupData = (MapGroupData)groupDataMap.remove(Long.valueOf(groupid));
/*  60 */     if (groupData == null)
/*     */     {
/*  62 */       return;
/*     */     }
/*     */     
/*  65 */     onGroupDissilve(groupType, groupid, groupData, nowFlyRoles, offlineRoles);
/*     */   }
/*     */   
/*     */ 
/*     */   public void changeMapGroupExtraInfos(MapGroupType groupType, long groupid, Map<Integer, Integer> replaceExtraInfoEntries, Set<Integer> removeExtraInfoKeys)
/*     */   {
/*  71 */     Map<Long, MapGroupData> groupDataMap = (Map)this.typeToGroupDataMap.get(groupType);
/*  72 */     if (groupDataMap == null)
/*     */     {
/*  74 */       return;
/*     */     }
/*     */     
/*  77 */     MapGroupData groupData = (MapGroupData)groupDataMap.get(Long.valueOf(groupid));
/*  78 */     if (groupData == null)
/*     */     {
/*  80 */       return;
/*     */     }
/*     */     
/*  83 */     groupData.changeExtraInfos(groupType, groupid, replaceExtraInfoEntries, removeExtraInfoKeys);
/*     */   }
/*     */   
/*     */ 
/*     */   private void onGroupDissilve(MapGroupType groupType, long groupid, MapGroupData groupData, Map<Long, Integer> nowFlyRoles, Set<Long> offlineRoles)
/*     */   {
/*  89 */     long leaderRoleid = groupData.getLeaderid();
/*  90 */     MapRole leaderRole = MapObjectInstanceManager.getInstance().getMapRole(leaderRoleid);
/*  91 */     if (leaderRole != null)
/*     */     {
/*  93 */       leaderRole.setGroupType(MapGroupType.UNKNOWN);
/*  94 */       leaderRole.setGroupid(-1L);
/*  95 */       leaderRole.setGroupSpeed(-1);
/*     */       
/*  97 */       Integer flyspeed = nowFlyRoles == null ? null : (Integer)nowFlyRoles.get(Long.valueOf(leaderRole.getRoleId()));
/*  98 */       if (flyspeed == null)
/*     */       {
/* 100 */         leaderRole.setFlySpeed(0);
/*     */       }
/*     */       else
/*     */       {
/* 104 */         leaderRole.setFlySpeed(flyspeed.intValue());
/*     */       }
/*     */       
/* 107 */       SMapGroupDissole mapGroupDissole = new SMapGroupDissole();
/* 108 */       mapGroupDissole.group_type = groupType.ordinal();
/* 109 */       mapGroupDissole.groupid = groupid;
/* 110 */       leaderRole.broadcastProtocolIncludeSelf(mapGroupDissole);
/*     */       
/* 112 */       if ((offlineRoles != null) && (offlineRoles.contains(Long.valueOf(leaderRoleid))))
/*     */       {
/* 114 */         leaderRole.destroy();
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 119 */         leaderRole.tryShowFollower();
/*     */         
/* 121 */         leaderRole.delayUpdateRoleExterior();
/*     */       }
/*     */     }
/*     */     
/* 125 */     for (Iterator i$ = groupData.getOtherMemebersForInner().iterator(); i$.hasNext();) { long followerRoleid = ((Long)i$.next()).longValue();
/*     */       
/* 127 */       MapRole followRole = MapObjectInstanceManager.getInstance().getMapRole(followerRoleid);
/* 128 */       if (followRole != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 133 */         followRole.setGroupType(MapGroupType.UNKNOWN);
/* 134 */         followRole.setGroupid(groupid);
/* 135 */         followRole.setGroupSpeed(-1);
/*     */         
/* 137 */         int flySpeed = 0;
/* 138 */         Integer flySpeedValue = nowFlyRoles == null ? null : (Integer)nowFlyRoles.get(Long.valueOf(followerRoleid));
/* 139 */         if (flySpeedValue == null)
/*     */         {
/* 141 */           flySpeed = 0;
/*     */         }
/*     */         else
/*     */         {
/* 145 */           flySpeed = flySpeedValue.intValue();
/*     */         }
/* 147 */         followRole.setFlySpeed(flySpeed);
/*     */         
/* 149 */         if (leaderRole != null)
/*     */         {
/* 151 */           Position targetPos = null;
/* 152 */           if (flySpeed <= 0)
/*     */           {
/* 154 */             Position currPos = leaderRole.getPositionForInner();
/* 155 */             Scene scene = SceneManager.getInstance().getScene(currPos.getSceneId());
/* 156 */             if (scene != null)
/*     */             {
/* 158 */               targetPos = scene.getFlyLandPositionForInner(currPos);
/*     */             }
/* 160 */             if (targetPos != null)
/*     */             {
/* 162 */               followRole.setTargetPos(targetPos.getX(), targetPos.getY(), targetPos.getZ(), targetPos.getSceneId());
/* 163 */               followRole.setXYZ(targetPos.getX(), targetPos.getY(), targetPos.getZ());
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 168 */             targetPos = leaderRole.getTargetPosForInner();
/* 169 */             followRole.setTargetPos(targetPos.getX(), targetPos.getY(), targetPos.getZ(), targetPos.getSceneId());
/*     */           }
/*     */         }
/*     */         
/* 173 */         if ((offlineRoles != null) && (offlineRoles.contains(Long.valueOf(followerRoleid))))
/*     */         {
/* 175 */           followRole.destroy();
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 180 */           followRole.tryShowFollower();
/*     */           
/*     */ 
/* 183 */           followRole.delayUpdateRoleExterior();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   void onNewGroupCreate(MapGroupType groupType, long groupid, MapGroupData groupData, int groupSpeed) {
/* 190 */     long leaderid = groupData.getLeaderid();
/* 191 */     MapRole leaderRole = MapObjectInstanceManager.getInstance().getMapRole(leaderid);
/* 192 */     if (leaderRole == null)
/*     */     {
/* 194 */       GameServer.logger().error(String.format("[map]MapGroupManager.onNewGroupCreate@leader do not exist|group_type=%d|groupid=%d|leaderid=%d", new Object[] { Integer.valueOf(groupType.ordinal()), Long.valueOf(groupid), Long.valueOf(leaderid) }));
/*     */       
/*     */ 
/*     */ 
/* 198 */       return;
/*     */     }
/*     */     
/* 201 */     if (GameServer.logger().isDebugEnabled())
/*     */     {
/* 203 */       GameServer.logger().debug(String.format("[map]MapGroupManager.onNewGroupCreate@create group|group_type=%d|groupid=%d|leaderid=%d", new Object[] { Integer.valueOf(groupType.ordinal()), Long.valueOf(groupid), Long.valueOf(leaderid) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 208 */     List<MapRole> followerRoles = new java.util.ArrayList();
/* 209 */     for (Iterator i$ = groupData.getOtherMemebersForInner().iterator(); i$.hasNext();) { long followerRoleid = ((Long)i$.next()).longValue();
/*     */       
/* 211 */       MapRole followRole = MapObjectInstanceManager.getInstance().getMapRole(followerRoleid);
/* 212 */       if (followRole == null)
/*     */       {
/* 214 */         GameServer.logger().error(String.format("[map]MapGroupManager.onNewGroupCreate@follower is not exist|group_type=%d|groupid=%d|leaderid=%d|followerid=%d", new Object[] { Integer.valueOf(groupType.ordinal()), Long.valueOf(groupid), Long.valueOf(leaderid), Long.valueOf(followerRoleid) }));
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 221 */         if (!followRole.canJoinTeamOrGroup(leaderRole))
/*     */         {
/* 223 */           GameServer.logger().error(String.format("[map]MapGroupManager.onNewGroupCreate@follower can not join group|group_type=%d|groupid=%d|leaderid=%d|followerid=%d", new Object[] { Integer.valueOf(groupType.ordinal()), Long.valueOf(groupid), Long.valueOf(leaderid), Long.valueOf(followerRoleid) }));
/*     */           
/*     */ 
/*     */ 
/* 227 */           return;
/*     */         }
/*     */         
/* 230 */         followerRoles.add(followRole);
/*     */       }
/*     */     }
/* 233 */     Position position = leaderRole.getTargetPosForInner();
/* 234 */     leaderRole.setTargetPos(position.getX(), position.getY(), 0);
/* 235 */     leaderRole.setXunLuoState(false);
/* 236 */     leaderRole.setGroupSpeed(groupSpeed);
/* 237 */     if (groupType.isFlyable())
/*     */     {
/* 239 */       leaderRole.setFlySpeed(groupSpeed);
/*     */     }
/* 241 */     leaderRole.setGroupType(groupType);
/* 242 */     leaderRole.setGroupid(groupid);
/*     */     
/* 244 */     Position pos = leaderRole.getPositionForInner();
/* 245 */     for (MapRole followRole : followerRoles)
/*     */     {
/* 247 */       followRole.setTargetPos(pos.getX(), pos.getY(), 0);
/* 248 */       followRole.setXunLuoState(false);
/* 249 */       followRole.setGroupSpeed(groupSpeed);
/* 250 */       if (groupType.isFlyable())
/*     */       {
/* 252 */         followRole.setFlySpeed(groupSpeed);
/*     */       }
/*     */       
/* 255 */       if (followRole.getView().getPlayers().contains(leaderRole))
/*     */       {
/* 257 */         followRole.setXYZ(pos.getX(), pos.getY(), 0);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 262 */         followRole.teleportWithProtocol(pos.getX(), pos.getY(), 0, pos.getX(), pos.getY(), pos.getSceneId(), leaderRole.getChannelid(), MapGroupType.getTransferType(groupType));
/*     */       }
/*     */       
/* 265 */       followRole.setGroupType(groupType);
/* 266 */       followRole.setGroupid(groupid);
/*     */     }
/*     */     
/* 269 */     Map<Long, MapGroupData> groupDataMap = (Map)this.typeToGroupDataMap.get(groupType);
/* 270 */     if (groupDataMap == null)
/*     */     {
/* 272 */       groupDataMap = new HashMap();
/* 273 */       this.typeToGroupDataMap.put(groupType, groupDataMap);
/*     */     }
/*     */     
/* 276 */     groupDataMap.put(Long.valueOf(groupid), groupData);
/* 277 */     groupData.broadcastGroupInfo(leaderRole);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\group\MapGroupManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */