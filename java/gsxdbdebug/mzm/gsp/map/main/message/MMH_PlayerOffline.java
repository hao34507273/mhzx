/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MMH_PlayerOffline
/*    */   extends AbstractMapMsgHandler
/*    */ {
/* 13 */   private static final Logger logger = Logger.getLogger(MMH_PlayerOffline.class);
/*    */   
/*    */   private final long roleId;
/*    */   
/*    */   public MMH_PlayerOffline(long roleId)
/*    */   {
/* 19 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 25 */     if (logger.isDebugEnabled())
/*    */     {
/* 27 */       logger.debug("map receive role offline roleId = " + this.roleId);
/*    */     }
/*    */     
/* 30 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleId);
/* 31 */     if (role == null)
/*    */     {
/* 33 */       logger.warn("player offline detected role null roleId = " + this.roleId);
/* 34 */       return;
/*    */     }
/*    */     
/* 37 */     role.destroy();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_PlayerOffline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */