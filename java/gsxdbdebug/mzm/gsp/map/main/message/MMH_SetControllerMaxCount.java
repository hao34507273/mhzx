/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ import mzm.gsp.map.main.controller.Controller;
/*    */ 
/*    */ public class MMH_SetControllerMaxCount extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long worldId;
/*    */   private final int controllerId;
/*    */   private final int maxCount;
/*    */   
/*    */   public MMH_SetControllerMaxCount(long worldId, int controllerId, int maxCount)
/*    */   {
/* 15 */     this.worldId = worldId;
/* 16 */     this.controllerId = controllerId;
/* 17 */     this.maxCount = maxCount;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 23 */     WorldInstance instance = WorldManager.getInstance().getWorldInstance(this.worldId);
/* 24 */     if (instance == null)
/*    */     {
/* 26 */       return;
/*    */     }
/* 28 */     Controller controller = instance.getController(this.controllerId);
/* 29 */     if (controller != null)
/*    */     {
/* 31 */       controller.setMaxCount(this.maxCount);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_SetControllerMaxCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */