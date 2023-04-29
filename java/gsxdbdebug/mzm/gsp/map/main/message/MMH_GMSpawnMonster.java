/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.confbean.SMapVisibleMonster;
/*    */ import mzm.gsp.map.main.MapManager;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.proto.MapPrototype;
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import mzm.gsp.map.main.scene.Scene;
/*    */ import mzm.gsp.map.main.scene.SceneManager;
/*    */ import mzm.gsp.map.main.scene.TransferType;
/*    */ import mzm.gsp.map.main.scene.object.MapMonster;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ import mzm.gsp.monster.confbean.SBaseBrightMonster;
/*    */ 
/*    */ public class MMH_GMSpawnMonster
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private long roleId;
/*    */   private int monsterId;
/*    */   private int num;
/*    */   
/*    */   public MMH_GMSpawnMonster(long roleId, int monsterId, int num)
/*    */   {
/* 25 */     this.roleId = roleId;
/* 26 */     this.monsterId = monsterId;
/* 27 */     this.num = num;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 33 */     MapRole mapRole = MapObjectInstanceManager.getInstance().getMapRole(this.roleId);
/* 34 */     if (mapRole == null)
/*    */     {
/* 36 */       return;
/*    */     }
/*    */     
/* 39 */     Position pos = mapRole.getPositionForInner();
/* 40 */     Scene scene = SceneManager.getInstance().getScene(pos);
/* 41 */     SMapVisibleMonster mapVisibleMonster = scene.getMapPrototype().getVisibleMonster(this.monsterId);
/* 42 */     if (mapVisibleMonster == null)
/*    */     {
/* 44 */       return;
/*    */     }
/* 46 */     SBaseBrightMonster baseBrightMonster = MapManager.getBaseBrightMonster(mapVisibleMonster);
/* 47 */     if (baseBrightMonster == null)
/*    */     {
/* 49 */       return;
/*    */     }
/*    */     
/* 52 */     List<Position> positionList = scene.getPositionsInRect(pos.getX() - 450, pos.getY() - 450, 900, 900, this.num);
/* 53 */     for (int i = 0; i < this.num; i++)
/*    */     {
/* 55 */       MapMonster monster = new MapMonster(mapVisibleMonster, baseBrightMonster);
/* 56 */       monster.initializeAi(0, null);
/* 57 */       Position monsterPosition = (Position)positionList.get(i);
/* 58 */       monster.setTargetPos(new Position(monsterPosition));
/* 59 */       monster.spawnMe(monsterPosition.getX(), monsterPosition.getY(), monsterPosition.getZ(), monsterPosition.getSceneId(), TransferType.TRANSPOS);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GMSpawnMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */