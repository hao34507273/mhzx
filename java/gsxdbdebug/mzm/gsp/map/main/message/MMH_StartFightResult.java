/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapMonster;
/*    */ 
/*    */ public class MMH_StartFightResult extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/*    */   private final int monsterInstanceId;
/*    */   private final int retcode;
/*    */   private final long fightid;
/*    */   
/*    */   public MMH_StartFightResult(long roleid, int monsterInstanceId, int retcode)
/*    */   {
/* 15 */     this(roleid, monsterInstanceId, retcode, -1L);
/*    */   }
/*    */   
/*    */   public MMH_StartFightResult(long roleid, int monsterInstanceId, int retcode, long fightid)
/*    */   {
/* 20 */     this.roleid = roleid;
/* 21 */     this.monsterInstanceId = monsterInstanceId;
/* 22 */     this.retcode = retcode;
/* 23 */     this.fightid = fightid;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 29 */     MapMonster monster = MapObjectInstanceManager.getInstance().getMapMonster(this.monsterInstanceId);
/* 30 */     if (monster == null)
/*    */     {
/* 32 */       return;
/*    */     }
/*    */     
/* 35 */     monster.onStartFightResult(this.roleid, this.retcode, this.fightid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_StartFightResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */