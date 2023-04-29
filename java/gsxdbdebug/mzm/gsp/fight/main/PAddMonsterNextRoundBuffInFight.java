/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class PAddMonsterNextRoundBuffInFight extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long fightid;
/*    */   private final Map<Integer, List<Integer>> monsterid2Buffid;
/*    */   
/*    */   public PAddMonsterNextRoundBuffInFight(long fightid, Map<Integer, List<Integer>> monsterid2Buffid)
/*    */   {
/* 15 */     this.fightid = fightid;
/* 16 */     this.monsterid2Buffid = monsterid2Buffid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     Fight fight = FightManager.getFight(this.fightid);
/* 23 */     if (fight == null) {
/* 24 */       return false;
/*    */     }
/* 26 */     Set<Long> lockRoles = fight.getLockRoles();
/*    */     
/* 28 */     lock(Basic.getTable(), lockRoles);
/* 29 */     for (Fighter fighter : fight.getPassiveTeam().getExistedFighters()) {
/* 30 */       if ((fighter instanceof FighterMonster)) {
/* 31 */         FighterMonster fighterMonster = (FighterMonster)fighter;
/* 32 */         List<Integer> buffids = (List)this.monsterid2Buffid.get(Integer.valueOf(fighterMonster.getMonsterid()));
/* 33 */         if (buffids != null) {
/* 34 */           fighterMonster.addNextRoundBuff(buffids);
/*    */         }
/*    */       }
/*    */     }
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PAddMonsterNextRoundBuffInFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */