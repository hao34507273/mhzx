/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ 
/*    */ public class MMH_TriggerWorldControllerCount extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long worldId;
/*    */   private final int controllerId;
/*    */   private final int count;
/*    */   private final int maxSpawnNum;
/*    */   
/*    */   public MMH_TriggerWorldControllerCount(long worldId, int controllerId, int count)
/*    */   {
/* 15 */     this(worldId, controllerId, count, 0);
/*    */   }
/*    */   
/*    */   public MMH_TriggerWorldControllerCount(long worldId, int controllerId, int count, int maxSpawnNum)
/*    */   {
/* 20 */     this.worldId = worldId;
/* 21 */     this.controllerId = controllerId;
/* 22 */     this.count = count;
/* 23 */     this.maxSpawnNum = maxSpawnNum;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 29 */     WorldInstance instance = WorldManager.getInstance().getWorldInstance(this.worldId);
/* 30 */     if (instance == null)
/*    */     {
/* 32 */       return;
/*    */     }
/* 34 */     instance.triggerController(this.controllerId, this.count, this.maxSpawnNum);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_TriggerWorldControllerCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */