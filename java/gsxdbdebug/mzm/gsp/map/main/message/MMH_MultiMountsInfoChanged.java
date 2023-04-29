/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ import mzm.gsp.map.main.team.MapTeamData;
/*    */ import mzm.gsp.map.main.team.MapTeamManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class MMH_MultiMountsInfoChanged extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long teamId;
/*    */   private final int multiMountsCfgid;
/*    */   private final List<Long> multiMountsRoles;
/*    */   
/*    */   public MMH_MultiMountsInfoChanged(long teamid, int multiMountsCfgid, List<Long> multiMountsRoles)
/*    */   {
/* 19 */     this.teamId = teamid;
/* 20 */     this.multiMountsCfgid = multiMountsCfgid;
/* 21 */     this.multiMountsRoles = multiMountsRoles;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 27 */     MapTeamData teamData = MapTeamManager.getInstance().getTeamById(this.teamId);
/* 28 */     if (teamData == null)
/*    */     {
/* 30 */       GameServer.logger().info(String.format("[map]MMH_MultiMountsInfoChanged.doProcess@team data is null|teamid=%d|multi_mounts_cfgid=%d|multi_mounts_roles=%s", new Object[] { Long.valueOf(this.teamId), Integer.valueOf(this.multiMountsCfgid), this.multiMountsRoles }));
/*    */       
/*    */ 
/*    */ 
/* 34 */       return;
/*    */     }
/*    */     
/* 37 */     teamData.setMultiMountsInfo(this.multiMountsCfgid, this.multiMountsRoles);
/*    */     
/* 39 */     long leaderid = teamData.getLeaderId();
/* 40 */     MapRole leader = MapObjectInstanceManager.getInstance().getMapRole(leaderid);
/* 41 */     if (leader == null)
/*    */     {
/* 43 */       GameServer.logger().info(String.format("[map]MMH_MultiMountsInfoChanged.doProcess@team leader is null|teamid=%d|multi_mounts_cfgid=%d|multi_mounts_roles=%s|leaderid=%d", new Object[] { Long.valueOf(this.teamId), Integer.valueOf(this.multiMountsCfgid), this.multiMountsRoles, Long.valueOf(leaderid) }));
/*    */       
/*    */ 
/*    */ 
/* 47 */       return;
/*    */     }
/*    */     
/* 50 */     teamData.broadcastTeamInfo(leader);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_MultiMountsInfoChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */