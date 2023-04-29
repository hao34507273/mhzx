/*    */ package mzm.gsp.baotu.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.BaoTuActivityCfgConsts;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import mzm.gsp.map.main.IMonsterFightHandler;
/*    */ import mzm.gsp.map.main.MapFightContext;
/*    */ import mzm.gsp.monster.main.MonsterInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BaoTuFightHandler
/*    */   implements IMonsterFightHandler
/*    */ {
/*    */   public int startFight(long roleId, int fightId, MapFightContext context)
/*    */   {
/* 20 */     int monsterID = FightInterface.getFightFirstMonsterid(fightId);
/* 21 */     if (MonsterInterface.getMonsterCategoryId(monsterID) == BaoTuActivityCfgConsts.getInstance().MONSTER_TYPE_ID)
/*    */     {
/* 23 */       FightInterface.startPVEFight(roleId, fightId, context, FightReason.BAOTU_FIGHT);
/* 24 */       return 1;
/*    */     }
/* 26 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baotu\main\BaoTuFightHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */