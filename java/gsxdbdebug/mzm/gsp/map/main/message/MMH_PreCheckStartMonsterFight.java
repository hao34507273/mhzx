/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.confbean.SMapVisibleMonster;
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapMonster;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ 
/*    */ public class MMH_PreCheckStartMonsterFight
/*    */   extends AbstractMapMsgHandler
/*    */   implements MapMsgHandlerDone<MMH_PreCheckStartMonsterFight>
/*    */ {
/*    */   private final long roleid;
/*    */   private final int monsterInstanceId;
/*    */   private MapCallback<SMapVisibleMonster> callback;
/* 17 */   private SMapVisibleMonster mapVisibleMonster = null;
/*    */   
/*    */ 
/*    */   public MMH_PreCheckStartMonsterFight(long roleid, int monsterInstanceId, MapCallback<SMapVisibleMonster> callback)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.monsterInstanceId = monsterInstanceId;
/* 24 */     this.callback = callback;
/*    */   }
/*    */   
/*    */   public SMapVisibleMonster getMapVisibleMonster()
/*    */   {
/* 29 */     return this.mapVisibleMonster;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 35 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 36 */     if (role == null)
/*    */     {
/* 38 */       return;
/*    */     }
/*    */     
/* 41 */     MapMonster monster = MapObjectInstanceManager.getInstance().getMapMonster(this.monsterInstanceId);
/* 42 */     if (monster == null)
/*    */     {
/* 44 */       return;
/*    */     }
/*    */     
/*    */ 
/* 48 */     if (role.isFollower())
/*    */     {
/* 50 */       return;
/*    */     }
/*    */     
/* 53 */     this.mapVisibleMonster = monster.getMapVisibleMonster();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public MapMsgHandlerDone<MMH_PreCheckStartMonsterFight> getMapMsgHandlerDone()
/*    */   {
/* 60 */     if (this.callback == null)
/*    */     {
/* 62 */       return null;
/*    */     }
/*    */     
/* 65 */     return this;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 71 */     return this.callback.isCallInProcedure();
/*    */   }
/*    */   
/*    */   public boolean onMapMsgHandlerDone(MMH_PreCheckStartMonsterFight mmh)
/*    */     throws Exception
/*    */   {
/* 77 */     return this.callback.onResult(mmh.getMapVisibleMonster());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_PreCheckStartMonsterFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */