/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ import mzm.gsp.map.main.controller.Controller;
/*    */ 
/*    */ public class MMH_TriggerOrRespawn extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long worldId;
/*    */   private final int controllerId;
/*    */   private final int triggerCount;
/*    */   
/*    */   public MMH_TriggerOrRespawn(long worldId, int controllerId, int triggerCount)
/*    */   {
/* 15 */     this.worldId = worldId;
/* 16 */     this.controllerId = controllerId;
/* 17 */     this.triggerCount = triggerCount;
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
/*    */     
/* 29 */     Controller controller = instance.getController(this.controllerId);
/* 30 */     controller.respawnOrRefresh(this.triggerCount);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_TriggerOrRespawn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */