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
/*    */ 
/*    */ public class MMH_TeamLeaderChange
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long teamId;
/*    */   private final long newLeaderId;
/*    */   private final int flySpeed;
/*    */   private final long oldLeaderid;
/*    */   private final boolean oldLeaveTeam;
/*    */   private final boolean oldOffline;
/*    */   private final int multiMountsCfgid;
/*    */   private final List<Long> multiMountsRoles;
/*    */   
/*    */   public MMH_TeamLeaderChange(long teamid, long newLeader, int flySpeed, long oldLeader, boolean oldLeaveTeam, boolean oldOffline)
/*    */   {
/* 27 */     this.teamId = teamid;
/* 28 */     this.newLeaderId = newLeader;
/* 29 */     this.flySpeed = flySpeed;
/* 30 */     this.oldLeaderid = oldLeader;
/* 31 */     this.oldLeaveTeam = oldLeaveTeam;
/* 32 */     this.oldOffline = oldOffline;
/* 33 */     this.multiMountsCfgid = 0;
/* 34 */     this.multiMountsRoles = Collections.emptyList();
/*    */   }
/*    */   
/*    */ 
/*    */   public MMH_TeamLeaderChange(long teamid, long newLeader, int flySpeed, long oldLeader, boolean oldLeaveTeam, boolean oldOffline, int multiMountsCfgid, List<Long> multiMountsRoles)
/*    */   {
/* 40 */     this.teamId = teamid;
/* 41 */     this.newLeaderId = newLeader;
/* 42 */     this.flySpeed = flySpeed;
/* 43 */     this.oldLeaderid = oldLeader;
/* 44 */     this.oldLeaveTeam = oldLeaveTeam;
/* 45 */     this.oldOffline = oldOffline;
/* 46 */     this.multiMountsCfgid = multiMountsCfgid;
/* 47 */     this.multiMountsRoles = multiMountsRoles;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 53 */     MapTeamData teamData = MapTeamManager.getInstance().getTeamById(this.teamId);
/* 54 */     if (teamData == null)
/*    */     {
/* 56 */       GameServer.logger().info(String.format("[map]MMH_TeamLeaderChange.doProcess@team data is null|teamid=%d|new_leaderid=%d|fly_speed=%d|old_leaderid=%d|old_leave_team=%b|old_offline=%b|multi_mounts_cfgid=%d|multi_mounts_roles=%s", new Object[] { Long.valueOf(this.teamId), Long.valueOf(this.newLeaderId), Integer.valueOf(this.flySpeed), Long.valueOf(this.oldLeaderid), Boolean.valueOf(this.oldLeaveTeam), Boolean.valueOf(this.oldOffline), Integer.valueOf(this.multiMountsCfgid), this.multiMountsRoles }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 61 */       return;
/*    */     }
/*    */     
/* 64 */     teamData.setMultiMountsInfo(this.multiMountsCfgid, this.multiMountsRoles);
/* 65 */     teamData.changeLeader(this.newLeaderId, this.flySpeed, this.oldLeaderid, this.oldLeaveTeam, this.oldOffline);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_TeamLeaderChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */