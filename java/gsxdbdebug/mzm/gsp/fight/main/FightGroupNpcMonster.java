/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.fight.confbean.SFightCfg;
/*    */ import mzm.gsp.monster.main.Monster;
/*    */ import xbean.FightGroup;
/*    */ 
/*    */ class FightGroupNpcMonster extends FightGroupMonster
/*    */ {
/*    */   FightGroupNpcMonster(int groupid, FightGroup xGroup, FightTeam fightTeam)
/*    */   {
/* 12 */     super(groupid, xGroup, fightTeam);
/*    */   }
/*    */   
/*    */   void init(int id, java.util.Map<Integer, Monster> pos2Monster)
/*    */   {
/* 17 */     setCfgID(id);
/* 18 */     SFightCfg fightCfg = SFightCfg.get(id);
/* 19 */     this.xGroup.setGroupai(new GroupAI(fightCfg.npcGroupAiName).getGroupAI());
/* 20 */     for (Map.Entry<Integer, Monster> entry : pos2Monster.entrySet()) {
/* 21 */       int pos = ((Integer)entry.getKey()).intValue();
/* 22 */       Monster m = (Monster)entry.getValue();
/* 23 */       FighterMonster fm = generateFighterNpcMonster();
/* 24 */       fm.init(m, pos);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FightGroupNpcMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */