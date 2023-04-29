/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapMonster;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_StartMonsterFight extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/*    */   private final int monsterInstanceId;
/*    */   
/*    */   public MMH_StartMonsterFight(long roleid, int monsterInstanceId)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.monsterInstanceId = monsterInstanceId;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 21 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 22 */     if (role == null)
/*    */     {
/* 24 */       return;
/*    */     }
/*    */     
/* 27 */     MapMonster monster = MapObjectInstanceManager.getInstance().getMapMonster(this.monsterInstanceId);
/* 28 */     if (monster == null)
/*    */     {
/* 30 */       return;
/*    */     }
/*    */     
/* 33 */     if (role.isFollower())
/*    */     {
/* 35 */       return;
/*    */     }
/*    */     
/* 38 */     monster.tryStartFight(role);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_StartMonsterFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */