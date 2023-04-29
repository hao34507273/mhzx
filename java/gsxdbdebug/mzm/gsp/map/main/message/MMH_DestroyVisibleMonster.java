/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapMonster;
/*    */ 
/*    */ public class MMH_DestroyVisibleMonster
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final int monsterInstanceId;
/* 10 */   private boolean result = false;
/*    */   
/*    */   public MMH_DestroyVisibleMonster(int monsterInstanceId)
/*    */   {
/* 14 */     this.monsterInstanceId = monsterInstanceId;
/*    */   }
/*    */   
/*    */   public boolean getResult()
/*    */   {
/* 19 */     return this.result;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 25 */     MapMonster mapMonster = MapObjectInstanceManager.getInstance().getMapMonster(this.monsterInstanceId);
/* 26 */     if (mapMonster == null)
/*    */     {
/* 28 */       return;
/*    */     }
/* 30 */     mapMonster.destroy();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_DestroyVisibleMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */