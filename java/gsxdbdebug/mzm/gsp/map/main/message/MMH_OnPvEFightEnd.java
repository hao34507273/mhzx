/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapMonster;
/*    */ 
/*    */ public class MMH_OnPvEFightEnd extends AbstractMapMsgHandler
/*    */ {
/*    */   private final int monsterInstanceId;
/*    */   private final boolean isPlayerWin;
/*    */   
/*    */   public MMH_OnPvEFightEnd(int monsterInstanceId, boolean isPlayerWin)
/*    */   {
/* 13 */     this.monsterInstanceId = monsterInstanceId;
/* 14 */     this.isPlayerWin = isPlayerWin;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 20 */     MapMonster monster = MapObjectInstanceManager.getInstance().getMapMonster(this.monsterInstanceId);
/* 21 */     if (monster != null)
/*    */     {
/* 23 */       if (this.isPlayerWin)
/*    */       {
/* 25 */         monster.onMonsterLose();
/*    */       }
/*    */       else
/*    */       {
/* 29 */         monster.onMonsterWin();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_OnPvEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */