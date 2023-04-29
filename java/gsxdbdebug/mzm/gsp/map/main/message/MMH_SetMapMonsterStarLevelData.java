/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.main.MapObjectManager;
/*    */ import mzm.gsp.map.main.StarLevelWrapper;
/*    */ import mzm.gsp.map.main.proto.MapMonsterStarLevelPrototype;
/*    */ 
/*    */ public class MMH_SetMapMonsterStarLevelData
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final int monsterCfgid;
/*    */   private final List<StarLevelWrapper> starLevelWrappers;
/*    */   
/*    */   public MMH_SetMapMonsterStarLevelData(int monsterCfgid, List<StarLevelWrapper> starLevelWrappers)
/*    */   {
/* 16 */     this.monsterCfgid = monsterCfgid;
/* 17 */     this.starLevelWrappers = starLevelWrappers;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 23 */     MapMonsterStarLevelPrototype prototype = MapObjectManager.getInstance().getMonsterStarLevelPrototype(this.monsterCfgid);
/* 24 */     if (prototype == null)
/*    */     {
/* 26 */       prototype = new MapMonsterStarLevelPrototype();
/* 27 */       prototype.setMonsterCfgid(this.monsterCfgid);
/*    */     }
/* 29 */     prototype.setStarLevelWrappers(this.starLevelWrappers);
/* 30 */     MapObjectManager.getInstance().addMonsterStarLevelPrototype(prototype);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_SetMapMonsterStarLevelData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */