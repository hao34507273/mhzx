/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ import mzm.gsp.map.main.scene.Scene;
/*    */ import mzm.gsp.map.main.scene.SceneManager;
/*    */ 
/*    */ 
/*    */ public class MMH_SpawnVisibleMonster
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long worldid;
/*    */   private final int mapCfgIdOrSceneid;
/*    */   private final int visibleMonsterCfgid;
/* 15 */   private int result = -1;
/*    */   
/*    */   public MMH_SpawnVisibleMonster(int sceneid, int visibleMonsterCfgid)
/*    */   {
/* 19 */     this(-1L, sceneid, visibleMonsterCfgid);
/*    */   }
/*    */   
/*    */   public MMH_SpawnVisibleMonster(long worldid, int mapCfgid, int visibleMonsterCfgid)
/*    */   {
/* 24 */     this.worldid = worldid;
/* 25 */     this.mapCfgIdOrSceneid = mapCfgid;
/* 26 */     this.visibleMonsterCfgid = visibleMonsterCfgid;
/*    */   }
/*    */   
/*    */   public int getResult()
/*    */   {
/* 31 */     return this.result;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 37 */     Scene scene = null;
/* 38 */     if (this.worldid > -1L)
/*    */     {
/* 40 */       WorldInstance instance = WorldManager.getInstance().getWorldInstance(this.worldid);
/* 41 */       if (instance == null)
/*    */       {
/* 43 */         return;
/*    */       }
/*    */       
/* 46 */       scene = instance.nextScene(this.mapCfgIdOrSceneid);
/*    */     }
/*    */     else
/*    */     {
/* 50 */       scene = SceneManager.getInstance().getScene(this.mapCfgIdOrSceneid);
/*    */     }
/*    */     
/* 53 */     if (scene == null)
/*    */     {
/* 55 */       return;
/*    */     }
/*    */     
/* 58 */     this.result = scene.spawnMonster(this.visibleMonsterCfgid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_SpawnVisibleMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */