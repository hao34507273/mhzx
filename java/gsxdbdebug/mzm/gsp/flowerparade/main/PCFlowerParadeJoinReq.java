/*     */ package mzm.gsp.flowerparade.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity4.confbean.SFlowerParadeCfg;
/*     */ import mzm.gsp.activity4.confbean.SFlowerParadeOcpCfg;
/*     */ import mzm.gsp.activity4.confbean.SFlowerParadeOcpGroupCfg;
/*     */ import mzm.gsp.flowerparade.SFlowerParadeJoinFailedRep;
/*     */ import mzm.gsp.flowerparade.SFlowerParadeJoinSuccessRep;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FlowerParade;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCFlowerParadeJoinReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int activityId;
/*     */   
/*     */   public PCFlowerParadeJoinReq(long roleId, int activityId)
/*     */   {
/*  36 */     this.roleId = roleId;
/*  37 */     this.activityId = activityId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if (!ActivityInterface.isActivityOpen(this.activityId))
/*     */     {
/*  46 */       return false;
/*     */     }
/*  48 */     if (!FlowerParadeManager.isOpen(this.roleId))
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     long localid = GameServerInfoManager.getLocalId();
/*     */     
/*  55 */     FlowerParade xFlowerParade = xtable.Flowerparade.select(Long.valueOf(localid));
/*  56 */     if (xFlowerParade == null)
/*     */     {
/*  58 */       long nextStart = FlowerParadeManager.getNextParadeStartTime();
/*  59 */       sendError(1, nextStart);
/*  60 */       GameServer.logger().info(String.format("[flowerparade]PCFlowerParadeJoinReq.processImp@parade not start|activityid=%d|nextstartsec=%d", new Object[] { Integer.valueOf(this.activityId), Long.valueOf(nextStart) }));
/*     */       
/*     */ 
/*     */ 
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     Position mapPos = MapInterface.getMapEntityPos(MapEntityType.MET_FLOAT_PARADE, xFlowerParade.getFlowerinstanceid());
/*     */     
/*  69 */     if (mapPos == null)
/*     */     {
/*  71 */       GameServer.logger().info(String.format("[flowerparade]PCFlowerParadeJoinReq.processImp@get instance pos null|paradeinstance=%d|activityid=%d", new Object[] { Long.valueOf(xFlowerParade.getFlowerinstanceid()), Integer.valueOf(this.activityId) }));
/*     */       
/*     */ 
/*     */ 
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     SFlowerParadeCfg cfg = SFlowerParadeCfg.get(this.activityId);
/*  79 */     SFlowerParadeOcpGroupCfg ocpCfg = SFlowerParadeOcpGroupCfg.get(cfg.ocpGroupId);
/*  80 */     int radius = ((SFlowerParadeOcpCfg)ocpCfg.ocpPradCfg.get(Integer.valueOf(xFlowerParade.getOcpid()))).radius;
/*  81 */     Collection<Long> currentRoleIdCollection = MapInterface.getRoleListNearbyMapEntity(MapEntityType.MET_FLOAT_PARADE, xFlowerParade.getFlowerinstanceid(), radius);
/*     */     
/*  83 */     if ((null != currentRoleIdCollection) && (currentRoleIdCollection.contains(Long.valueOf(this.roleId))))
/*     */     {
/*  85 */       GameServer.logger().info(String.format("[flowerparade]PCFlowerParadeJoinReq.processImp@already around flowerparade,do not transfer|paradeinstance=%d|activityid=%d|roleid=%d", new Object[] { Long.valueOf(xFlowerParade.getFlowerinstanceid()), Integer.valueOf(this.activityId), Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/*     */ 
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     int x = mapPos.getX();
/*  93 */     int y = mapPos.getY();
/*  94 */     int mapId = xFlowerParade.getMapid();
/*     */     
/*  96 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, false);
/*  97 */     if (null == teamId)
/*     */     {
/*     */ 
/*     */ 
/* 101 */       List<Long> roleList = new ArrayList();
/* 102 */       roleList.add(Long.valueOf(this.roleId));
/*     */       
/* 104 */       if (!RoleStatusInterface.checkCansetStatus(roleList, 1771, true, true))
/*     */       {
/* 106 */         return false;
/*     */       }
/*     */       
/* 109 */       MapInterface.transferAllRole(roleList, MapInterface.getBigWorldid(), mapId, x, y);
/* 110 */       SFlowerParadeJoinSuccessRep protocol = new SFlowerParadeJoinSuccessRep(this.activityId);
/* 111 */       OnlineManager.getInstance().send(this.roleId, protocol);
/* 112 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 116 */     List<Long> roleIds = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/* 117 */     Map<Long, String> roleId2Userid = new HashMap();
/* 118 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*     */       
/* 120 */       roleId2Userid.put(Long.valueOf(tmpRoleId), mzm.gsp.role.main.RoleInterface.getUserId(tmpRoleId));
/*     */     }
/*     */     
/* 123 */     lock(User.getTable(), roleId2Userid.values());
/* 124 */     lock(Basic.getTable(), roleIds);
/*     */     
/*     */ 
/* 127 */     if (!RoleStatusInterface.checkCansetStatus(roleIds, 1771, true, true))
/*     */     {
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), true);
/* 133 */     if (null == teamInfo)
/*     */     {
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     if (teamInfo.isLeader(this.roleId))
/*     */     {
/* 140 */       List<Long> roleList = TeamInterface.getNormalRoleList(this.roleId);
/* 141 */       MapInterface.transferAllRole(roleList, MapInterface.getBigWorldid(), mapId, x, y);
/*     */     }
/*     */     else
/*     */     {
/* 145 */       int roleInTeamState = TeamInterface.getTeamMemberStatus(this.roleId);
/* 146 */       if (roleInTeamState == 0)
/*     */       {
/* 148 */         sendError(2);
/* 149 */         return false;
/*     */       }
/* 151 */       List<Long> roleList = new ArrayList();
/* 152 */       roleList.add(Long.valueOf(this.roleId));
/* 153 */       MapInterface.transferAllRole(roleList, MapInterface.getBigWorldid(), mapId, x, y);
/*     */     }
/*     */     
/* 156 */     SFlowerParadeJoinSuccessRep protocol = new SFlowerParadeJoinSuccessRep(this.activityId);
/* 157 */     OnlineManager.getInstance().send(this.roleId, protocol);
/*     */     
/*     */ 
/* 160 */     return true;
/*     */   }
/*     */   
/*     */   protected void sendError(int code)
/*     */   {
/* 165 */     SFlowerParadeJoinFailedRep protocol = new SFlowerParadeJoinFailedRep(code, this.activityId, 0L);
/* 166 */     OnlineManager.getInstance().sendAtOnce(this.roleId, protocol);
/*     */   }
/*     */   
/*     */   protected void sendError(int code, long param)
/*     */   {
/* 171 */     SFlowerParadeJoinFailedRep protocol = new SFlowerParadeJoinFailedRep(code, this.activityId, param);
/* 172 */     OnlineManager.getInstance().sendAtOnce(this.roleId, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\PCFlowerParadeJoinReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */