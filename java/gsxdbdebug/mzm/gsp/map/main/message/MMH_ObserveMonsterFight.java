/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapMonster;
/*    */ 
/*    */ public class MMH_ObserveMonsterFight extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long obseverRoleid;
/*    */   private final int monsterInstanceid;
/*    */   
/*    */   public MMH_ObserveMonsterFight(long obseverRoleid, int monsterInstanceid)
/*    */   {
/* 13 */     this.obseverRoleid = obseverRoleid;
/* 14 */     this.monsterInstanceid = monsterInstanceid;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 20 */     MapMonster monster = MapObjectInstanceManager.getInstance().getMapMonster(this.monsterInstanceid);
/* 21 */     if (monster == null)
/*    */     {
/* 23 */       return;
/*    */     }
/*    */     
/* 26 */     monster.observeFight(this.obseverRoleid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_ObserveMonsterFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */