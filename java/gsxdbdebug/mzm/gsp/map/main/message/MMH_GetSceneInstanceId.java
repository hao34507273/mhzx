/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ import mzm.gsp.map.main.scene.Scene;
/*    */ 
/*    */ public class MMH_GetSceneInstanceId
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private long worldId;
/*    */   private int mapCfgId;
/*    */   private boolean createIfNoExist;
/* 13 */   private int sceneInstanceid = 0;
/*    */   
/*    */   public MMH_GetSceneInstanceId(long worldId, int mapCfgId, boolean createIfNoExist)
/*    */   {
/* 17 */     this.worldId = worldId;
/* 18 */     this.mapCfgId = mapCfgId;
/* 19 */     this.createIfNoExist = createIfNoExist;
/*    */   }
/*    */   
/*    */   public int getSceneInstanceId()
/*    */   {
/* 24 */     return this.sceneInstanceid;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 30 */     WorldInstance instance = WorldManager.getInstance().getWorldInstance(this.worldId);
/* 31 */     if (instance == null)
/*    */     {
/* 33 */       return;
/*    */     }
/*    */     
/* 36 */     Scene scene = null;
/* 37 */     if (this.createIfNoExist)
/*    */     {
/* 39 */       scene = instance.nextScene(this.mapCfgId);
/*    */     }
/*    */     else
/*    */     {
/* 43 */       scene = instance.getSceneByCfgId(this.mapCfgId);
/*    */     }
/*    */     
/* 46 */     if (scene == null)
/*    */     {
/* 48 */       return;
/*    */     }
/* 50 */     this.sceneInstanceid = scene.getId();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GetSceneInstanceId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */