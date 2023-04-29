/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.map.main.team.MapTeamData;
/*    */ import mzm.gsp.map.main.team.MapTeamManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class MMH_TeamMemberStateChange
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long memberId;
/*    */   private final int status;
/*    */   private final long teamId;
/*    */   private final int flySpeed;
/*    */   private final int multiMountsCfgid;
/*    */   private final List<Long> multiMountsRoles;
/*    */   
/*    */   public MMH_TeamMemberStateChange(long teamId, long memberId, int status, int flySpeed)
/*    */   {
/* 24 */     this.memberId = memberId;
/* 25 */     this.status = status;
/* 26 */     this.flySpeed = flySpeed;
/* 27 */     this.teamId = teamId;
/* 28 */     this.multiMountsCfgid = 0;
/* 29 */     this.multiMountsRoles = Collections.emptyList();
/*    */   }
/*    */   
/*    */ 
/*    */   public MMH_TeamMemberStateChange(long teamId, long memberId, int status, int flySpeed, int multiMountsCfgid, List<Long> multiMountsRoles)
/*    */   {
/* 35 */     this.memberId = memberId;
/* 36 */     this.status = status;
/* 37 */     this.flySpeed = flySpeed;
/* 38 */     this.teamId = teamId;
/* 39 */     this.multiMountsCfgid = multiMountsCfgid;
/* 40 */     this.multiMountsRoles = multiMountsRoles;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 46 */     MapTeamData teamData = MapTeamManager.getInstance().getTeamById(this.teamId);
/*    */     
/* 48 */     if (teamData == null)
/*    */     {
/* 50 */       GameServer.logger().info(String.format("[map]MMH_TeamMemberStateChange.doProcess@team data is null|teamid=%d|roleid=%d|status=%d|fly_speed=%d|multi_mounts_cfgid=%d|multi_mounts_roles=%s", new Object[] { Long.valueOf(this.teamId), Long.valueOf(this.memberId), Integer.valueOf(this.status), Integer.valueOf(this.flySpeed), Integer.valueOf(this.multiMountsCfgid), this.multiMountsRoles }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 55 */       return;
/*    */     }
/*    */     
/* 58 */     if (GameServer.logger().isDebugEnabled())
/*    */     {
/* 60 */       GameServer.logger().debug(String.format("[map]MMH_TeamMemberStateChange.doProcess@team member state change info|teamid=%d|roleid=%d|status=%d|fly_speed=%d|multi_mounts_cfgid=%d|multi_mounts_roles=%s", new Object[] { Long.valueOf(this.teamId), Long.valueOf(this.memberId), Integer.valueOf(this.status), Integer.valueOf(this.flySpeed), Integer.valueOf(this.multiMountsCfgid), this.multiMountsRoles }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 67 */     teamData.setMultiMountsInfo(this.multiMountsCfgid, this.multiMountsRoles);
/*    */     
/* 69 */     switch (this.status)
/*    */     {
/*    */     case 0: 
/* 72 */       teamData.inTeam(this.memberId);
/* 73 */       break;
/*    */     
/*    */     case 1: 
/* 76 */       teamData.notInTeam(this.memberId, this.flySpeed);
/* 77 */       break;
/*    */     
/*    */ 
/*    */     case 2: 
/* 81 */       if (!teamData.isLeader(this.memberId))
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 86 */         teamData.offlineTeam(this.memberId); }
/* 87 */       break;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_TeamMemberStateChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */