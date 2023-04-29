/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnRoleLogoff extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     long roleId = ((Long)this.arg).longValue();
/* 12 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(roleId);
/* 13 */     if (homeInfoWrapper == null)
/*    */     {
/* 15 */       String logString = String.format("[home]POnRoleLogoff.processImp@homeInfoWrapper is null|roleId=%d", new Object[] { Long.valueOf(roleId) });
/*    */       
/* 17 */       HomelandManager.logger.info(logString);
/*    */       
/* 19 */       return false;
/*    */     }
/* 21 */     long worldId = homeInfoWrapper.getHomeWorldId();
/*    */     
/* 23 */     if (!MapInterface.hasRole(worldId))
/*    */     {
/* 25 */       HomelandManager.forceDestroyHomeWorld(homeInfoWrapper.getOwnerRoleId(), homeInfoWrapper.getPartnerRoleId(), homeInfoWrapper.getHomeWorldId());
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */