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
/*    */ public class MMH_LeaveTeam
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleId;
/*    */   private final long teamId;
/*    */   private final int memberFlySpeed;
/*    */   private final int multiMountsCfgid;
/*    */   private final List<Long> multiMountsRoles;
/*    */   
/*    */   public MMH_LeaveTeam(long roleId, long teamId, int memberFlySpeed)
/*    */   {
/* 23 */     this.roleId = roleId;
/* 24 */     this.teamId = teamId;
/* 25 */     this.memberFlySpeed = memberFlySpeed;
/* 26 */     this.multiMountsCfgid = 0;
/* 27 */     this.multiMountsRoles = Collections.emptyList();
/*    */   }
/*    */   
/*    */ 
/*    */   public MMH_LeaveTeam(long roleId, long teamId, int memberFlySpeed, int multiMountsCfgid, List<Long> multiMountsRoles)
/*    */   {
/* 33 */     this.roleId = roleId;
/* 34 */     this.teamId = teamId;
/* 35 */     this.memberFlySpeed = memberFlySpeed;
/* 36 */     this.multiMountsCfgid = multiMountsCfgid;
/* 37 */     this.multiMountsRoles = multiMountsRoles;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 43 */     MapTeamData teamData = MapTeamManager.getInstance().getTeamById(this.teamId);
/* 44 */     if (teamData == null)
/*    */     {
/* 46 */       GameServer.logger().info(String.format("[map]MMH_LeaveTeam.doProcess@team data is null|teamid=%d|roleid=%d|fly_speed=%d|multi_mounts_cfgid=%d|multi_mounts_roles=%s", new Object[] { Long.valueOf(this.teamId), Long.valueOf(this.roleId), Integer.valueOf(this.memberFlySpeed), Integer.valueOf(this.multiMountsCfgid), this.multiMountsRoles }));
/*    */       
/*    */ 
/*    */ 
/* 50 */       return;
/*    */     }
/*    */     
/* 53 */     teamData.setMultiMountsInfo(this.multiMountsCfgid, this.multiMountsRoles);
/* 54 */     teamData.leaveTeam(this.roleId, this.memberFlySpeed);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_LeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */