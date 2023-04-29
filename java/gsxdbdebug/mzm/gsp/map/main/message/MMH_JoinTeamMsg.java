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
/*    */ 
/*    */ public class MMH_JoinTeamMsg
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleId;
/*    */   private final long teamId;
/*    */   private final int multiMountsCfgid;
/*    */   private final List<Long> multiMountsRoles;
/*    */   
/*    */   public MMH_JoinTeamMsg(long teamId, long roleId)
/*    */   {
/* 24 */     this.roleId = roleId;
/* 25 */     this.teamId = teamId;
/*    */     
/* 27 */     this.multiMountsCfgid = 0;
/* 28 */     this.multiMountsRoles = Collections.emptyList();
/*    */   }
/*    */   
/*    */   public MMH_JoinTeamMsg(long teamId, long roleId, int multiMountsCfgid, List<Long> multiMountsRoles)
/*    */   {
/* 33 */     this.roleId = roleId;
/* 34 */     this.teamId = teamId;
/* 35 */     this.multiMountsCfgid = multiMountsCfgid;
/* 36 */     this.multiMountsRoles = multiMountsRoles;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 42 */     MapTeamData teamData = MapTeamManager.getInstance().getTeamById(this.teamId);
/* 43 */     if (teamData == null)
/*    */     {
/* 45 */       GameServer.logger().info(String.format("[map]MMH_JoinTeamMsg.doProcess@team is not exist|roleid=%d|teamid=%d|multi_mounts_cfgid=%d|multi_mounts_roles=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.teamId), Integer.valueOf(this.multiMountsCfgid), this.multiMountsRoles }));
/*    */       
/*    */ 
/*    */ 
/* 49 */       return;
/*    */     }
/*    */     
/* 52 */     teamData.setMultiMountsInfo(this.multiMountsCfgid, this.multiMountsRoles);
/* 53 */     teamData.inTeam(this.roleId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_JoinTeamMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */