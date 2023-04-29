/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ import mzm.gsp.map.main.scene.Scene;
/*    */ 
/*    */ public class MMH_GetMonsterNumInWorld
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long worldId;
/*    */   private final int mapCfgid;
/* 12 */   private int result = 0;
/*    */   
/*    */   public MMH_GetMonsterNumInWorld(long worldId)
/*    */   {
/* 16 */     this(worldId, -1);
/*    */   }
/*    */   
/*    */   public MMH_GetMonsterNumInWorld(long worldId, int mapCfgid)
/*    */   {
/* 21 */     this.worldId = worldId;
/* 22 */     this.mapCfgid = mapCfgid;
/*    */   }
/*    */   
/*    */   public int getMonsterNum()
/*    */   {
/* 27 */     return this.result;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 33 */     WorldInstance instance = WorldManager.getInstance().getWorldInstance(this.worldId);
/* 34 */     if (instance == null)
/*    */     {
/* 36 */       return;
/*    */     }
/*    */     
/* 39 */     if (this.mapCfgid == -1)
/*    */     {
/* 41 */       this.result = instance.getMonsterNumInWorld();
/* 42 */       return;
/*    */     }
/*    */     
/* 45 */     Scene scene = instance.getSceneByCfgId(this.mapCfgid);
/* 46 */     if (scene == null)
/*    */     {
/* 48 */       return;
/*    */     }
/* 50 */     this.result = scene.getMonsterCount();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GetMonsterNumInWorld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */