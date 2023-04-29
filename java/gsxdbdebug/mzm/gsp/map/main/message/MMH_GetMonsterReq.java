/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.MonsterLocation;
/*    */ import mzm.gsp.map.SGetMonsterLocationRes;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import mzm.gsp.map.main.scene.Scene;
/*    */ import mzm.gsp.map.main.scene.SceneManager;
/*    */ import mzm.gsp.map.main.scene.object.MapMonster;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MMH_GetMonsterReq
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleId;
/*    */   private final int targetMapCfgid;
/*    */   private final int monsterCfgid;
/*    */   
/*    */   public MMH_GetMonsterReq(long roleid, int targetMapCfgid, int monsterCfgid)
/*    */   {
/* 34 */     this.roleId = roleid;
/* 35 */     this.targetMapCfgid = targetMapCfgid;
/* 36 */     this.monsterCfgid = monsterCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 42 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleId);
/* 43 */     if (role == null)
/*    */     {
/* 45 */       return;
/*    */     }
/* 47 */     Scene scene = SceneManager.getInstance().getScene(role.getSceneId());
/* 48 */     if (scene == null)
/*    */     {
/* 50 */       return;
/*    */     }
/* 52 */     WorldInstance instance = scene.getWorld();
/* 53 */     Scene targetScene = instance.nextScene(this.targetMapCfgid);
/* 54 */     if (targetScene == null)
/*    */     {
/* 56 */       return;
/*    */     }
/* 58 */     List<MapMonster> monsters = targetScene.getMonsterByCfgId(this.monsterCfgid);
/* 59 */     SGetMonsterLocationRes res = new SGetMonsterLocationRes();
/* 60 */     for (MapMonster monster : monsters)
/*    */     {
/* 62 */       MonsterLocation ml = new MonsterLocation();
/* 63 */       Scene s = SceneManager.getInstance().getScene(monster.getSceneId());
/* 64 */       if (s == null)
/*    */       {
/* 66 */         return;
/*    */       }
/*    */       
/* 69 */       ml.mapid = s.getCfgId();
/* 70 */       ml.monstercfgid = this.monsterCfgid;
/* 71 */       ml.monsterinstanceid = s.getId();
/* 72 */       Position pos = monster.getPositionForInner();
/* 73 */       ml.x = pos.getX();
/* 74 */       ml.y = pos.getY();
/* 75 */       res.monsterlist.add(ml);
/*    */     }
/* 77 */     MapProtocolSendQueue.getInstance().send(this.roleId, res);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GetMonsterReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */