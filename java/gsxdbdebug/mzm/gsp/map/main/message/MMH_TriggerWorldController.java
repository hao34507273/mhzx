/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ 
/*    */ public class MMH_TriggerWorldController extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long worldId;
/*    */   private final int controllerId;
/*    */   private final int maxSpawnNum;
/*    */   
/*    */   public MMH_TriggerWorldController(long worldId, int controllerId)
/*    */   {
/* 14 */     this(worldId, controllerId, 0);
/*    */   }
/*    */   
/*    */   public MMH_TriggerWorldController(long worldId, int controllerId, int maxSpawnNum)
/*    */   {
/* 19 */     this.worldId = worldId;
/* 20 */     this.controllerId = controllerId;
/* 21 */     this.maxSpawnNum = maxSpawnNum;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 27 */     WorldInstance instance = WorldManager.getInstance().getWorldInstance(this.worldId);
/* 28 */     if (instance == null)
/*    */     {
/* 30 */       return;
/*    */     }
/*    */     
/* 33 */     instance.triggerController(this.controllerId, this.maxSpawnNum);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_TriggerWorldController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */