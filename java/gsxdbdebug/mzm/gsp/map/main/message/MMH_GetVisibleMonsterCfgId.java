/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapMonster;
/*    */ 
/*    */ public class MMH_GetVisibleMonsterCfgId
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final int monsterInstanceId;
/* 10 */   private int result = 0;
/*    */   
/*    */   public MMH_GetVisibleMonsterCfgId(int monsterInstanceId)
/*    */   {
/* 14 */     this.monsterInstanceId = monsterInstanceId;
/*    */   }
/*    */   
/*    */   public int getResult()
/*    */   {
/* 19 */     return this.result;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 25 */     MapMonster monster = MapObjectInstanceManager.getInstance().getMapMonster(this.monsterInstanceId);
/* 26 */     if (monster == null)
/*    */     {
/* 28 */       return;
/*    */     }
/* 30 */     this.result = monster.getCfgId().intValue();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GetVisibleMonsterCfgId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */