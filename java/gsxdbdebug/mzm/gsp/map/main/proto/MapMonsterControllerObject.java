/*    */ package mzm.gsp.map.main.proto;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.confbean.SMapVisibleMonster;
/*    */ import mzm.gsp.map.main.MapManager;
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ import mzm.gsp.map.main.controller.IControllerObject;
/*    */ import mzm.gsp.map.main.scene.Scene;
/*    */ import mzm.gsp.map.main.scene.TransferType;
/*    */ import mzm.gsp.map.main.scene.object.MapMonster;
/*    */ import mzm.gsp.map.main.scene.object.SceneObject;
/*    */ import mzm.gsp.monster.confbean.SBaseBrightMonster;
/*    */ 
/*    */ public class MapMonsterControllerObject
/*    */   implements IControllerObject
/*    */ {
/*    */   private SMapVisibleMonster mapVisibleMonster;
/*    */   
/*    */   public MapMonsterControllerObject(SMapVisibleMonster mapVisibleMonster)
/*    */   {
/* 23 */     this.mapVisibleMonster = mapVisibleMonster;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<? extends SceneObject> refresh(long worldId, int maxSpawnNum)
/*    */   {
/* 29 */     WorldInstance instance = WorldManager.getInstance().getWorldInstance(worldId);
/* 30 */     Scene scene = instance.nextScene(this.mapVisibleMonster.mapCfgId);
/* 31 */     if (scene == null)
/*    */     {
/* 33 */       return null;
/*    */     }
/*    */     
/* 36 */     SBaseBrightMonster baseBrightMonster = MapManager.getBaseBrightMonster(this.mapVisibleMonster);
/* 37 */     if (baseBrightMonster == null)
/*    */     {
/* 39 */       return null;
/*    */     }
/*    */     
/* 42 */     List<SceneObject> monsters = new ArrayList();
/* 43 */     int num = maxSpawnNum > 0 ? Math.min(maxSpawnNum, this.mapVisibleMonster.num) : this.mapVisibleMonster.num;
/* 44 */     for (int i = 0; i < num; i++)
/*    */     {
/* 46 */       MapMonster monster = new MapMonster(this.mapVisibleMonster, baseBrightMonster);
/* 47 */       monster.setBornSceneId(scene.getId());
/* 48 */       monster.spawnMe(TransferType.SOMMON);
/* 49 */       monsters.add(monster);
/*    */     }
/* 51 */     return monsters;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\proto\MapMonsterControllerObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */