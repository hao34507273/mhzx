/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class HomeReturnHandler implements mzm.gsp.map.main.MapCallback<Boolean>
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public HomeReturnHandler(long roleId)
/*    */   {
/* 12 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 18 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean onResult(Boolean result)
/*    */   {
/* 24 */     if (!result.booleanValue())
/*    */     {
/* 26 */       GameServer.logger().info(String.format("[team]HomeReturnHandler.onResult@ transform failed!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 27 */       return false;
/*    */     }
/* 29 */     return ReturnTeamManager.onReturnTeam(this.roleId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\HomeReturnHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */