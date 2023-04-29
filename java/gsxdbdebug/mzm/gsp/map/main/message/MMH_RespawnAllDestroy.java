/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ import mzm.gsp.map.main.controller.Controller;
/*    */ 
/*    */ public class MMH_RespawnAllDestroy extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long worldId;
/*    */   private final int controllerId;
/*    */   
/*    */   public MMH_RespawnAllDestroy(long worldId, int controllerId)
/*    */   {
/* 14 */     this.worldId = worldId;
/* 15 */     this.controllerId = controllerId;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 21 */     WorldInstance instance = WorldManager.getInstance().getWorldInstance(this.worldId);
/* 22 */     if (instance == null)
/*    */     {
/* 24 */       return;
/*    */     }
/*    */     
/* 27 */     Controller controller = instance.getController(this.controllerId);
/* 28 */     controller.respawnAll();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_RespawnAllDestroy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */