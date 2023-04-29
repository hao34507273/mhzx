/*     */ package mzm.gsp.map.main.message;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.SMapTeamInfo;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import mzm.gsp.map.main.team.MapTeamData;
/*     */ import mzm.gsp.map.main.team.MapTeamManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MMH_CreateTeam
/*     */   extends AbstractMapMsgHandler
/*     */ {
/*     */   private final long leaderid;
/*     */   private final long teamid;
/*     */   private final List<Long> normalRoles;
/*     */   private final int flySpeed;
/*     */   private final int multiMountsCfgid;
/*     */   private final List<Long> multiMountsRoles;
/*     */   
/*     */   public MMH_CreateTeam(long leaderid, long teamid, List<Long> normalRoles, int flySpeed)
/*     */   {
/*  31 */     this.leaderid = leaderid;
/*  32 */     this.normalRoles = normalRoles;
/*  33 */     this.teamid = teamid;
/*  34 */     this.flySpeed = flySpeed;
/*  35 */     this.multiMountsCfgid = 0;
/*  36 */     this.multiMountsRoles = Collections.emptyList();
/*     */   }
/*     */   
/*     */ 
/*     */   public MMH_CreateTeam(long leaderid, long teamid, List<Long> normalRoles, int flySpeed, int multiMountsCfgid, List<Long> multiMountsRoles)
/*     */   {
/*  42 */     this.leaderid = leaderid;
/*  43 */     this.normalRoles = normalRoles;
/*  44 */     this.teamid = teamid;
/*  45 */     this.flySpeed = flySpeed;
/*  46 */     this.multiMountsCfgid = multiMountsCfgid;
/*  47 */     this.multiMountsRoles = multiMountsRoles;
/*     */   }
/*     */   
/*     */ 
/*     */   public void doProcess()
/*     */   {
/*  53 */     MapRole leaderRole = MapObjectInstanceManager.getInstance().getMapRole(this.leaderid);
/*  54 */     if (leaderRole == null)
/*     */     {
/*  56 */       GameServer.logger().info(String.format("[map]MMH_CreateTeam.doProcess@leader map role is not exist|leaderid=%d|teamid=%d|normal_roles=%s|fly_speed=%d|multi_mounts_cfgid=%d|multi_mounts_roles=%s", new Object[] { Long.valueOf(this.leaderid), Long.valueOf(this.teamid), this.normalRoles, Integer.valueOf(this.flySpeed), Integer.valueOf(this.multiMountsCfgid), this.multiMountsRoles }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  61 */       return;
/*     */     }
/*     */     
/*  64 */     List<MapRole> normalMapRoles = new ArrayList();
/*     */     
/*  66 */     for (Iterator i$ = this.normalRoles.iterator(); i$.hasNext();) { long memberid = ((Long)i$.next()).longValue();
/*     */       
/*  68 */       MapRole memberRole = MapObjectInstanceManager.getInstance().getMapRole(memberid);
/*  69 */       if (memberRole == null)
/*     */       {
/*  71 */         GameServer.logger().info(String.format("[map]MMH_CreateTeam.doProcess@member map role is not exist|leaderid=%d|teamid=%d|normal_roles=%s|fly_speed=%d|multi_mounts_cfgid=%d|multi_mounts_roles=%s", new Object[] { Long.valueOf(this.leaderid), Long.valueOf(this.teamid), this.normalRoles, Integer.valueOf(this.flySpeed), Integer.valueOf(this.multiMountsCfgid), this.multiMountsRoles }));
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*     */ 
/*  79 */         if (!memberRole.canJoinTeamOrGroup(leaderRole))
/*     */         {
/*  81 */           GameServer.logger().error(String.format("[map]MMH_CreateTeam.doProcess@can not join team|leaderid=%d|teamid=%d|normal_roles=%s|fly_speed=%d|multi_mounts_cfgid=%d|multi_mounts_roles=%s", new Object[] { Long.valueOf(this.leaderid), Long.valueOf(this.teamid), this.normalRoles, Integer.valueOf(this.flySpeed), Integer.valueOf(this.multiMountsCfgid), this.multiMountsRoles }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  87 */           return;
/*     */         }
/*     */         
/*  90 */         normalMapRoles.add(memberRole);
/*     */       }
/*     */     }
/*  93 */     MapTeamData teamData = MapTeamManager.getInstance().createTeam(this.teamid, this.leaderid);
/*  94 */     leaderRole.setTeamId(this.teamid);
/*  95 */     leaderRole.setFlySpeed(this.flySpeed);
/*     */     
/*  97 */     for (MapRole memberRole : normalMapRoles)
/*     */     {
/*  99 */       teamData.afterMemberInTeam(leaderRole, memberRole);
/*     */     }
/*     */     
/* 102 */     teamData.setMultiMountsInfo(this.multiMountsCfgid, this.multiMountsRoles);
/* 103 */     SMapTeamInfo mapTeamInfo = teamData.buildTeamInfo();
/* 104 */     leaderRole.broadcastProtocolIncludeSelf(mapTeamInfo);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_CreateTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */