/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.fight.confbean.SFightCfg;
/*    */ import mzm.gsp.monster.main.Monster;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class FightGroupMonster
/*    */   extends FightGroup
/*    */ {
/*    */   private static final int GROUP_MONSTER_NPC = 1;
/*    */   
/*    */   FightGroupMonster(int groupid, xbean.FightGroup xGroup, FightTeam fightTeam)
/*    */   {
/* 19 */     super(groupid, xGroup, fightTeam);
/*    */   }
/*    */   
/*    */   void init(int id, Map<Integer, Monster> pos2Monster)
/*    */   {
/* 24 */     setCfgID(id);
/* 25 */     SFightCfg fightCfg = SFightCfg.get(id);
/*    */     
/* 27 */     this.xGroup.setGroupai(new GroupAI(fightCfg.groupAiName).getGroupAI());
/* 28 */     initMonster(pos2Monster);
/*    */   }
/*    */   
/*    */   private void initMonster(Map<Integer, Monster> pos2Monster) {
/* 32 */     for (Map.Entry<Integer, Monster> entry : pos2Monster.entrySet()) {
/* 33 */       int pos = ((Integer)entry.getKey()).intValue();
/* 34 */       Monster m = (Monster)entry.getValue();
/* 35 */       FighterMonster fm = generateFighterMonster();
/* 36 */       fm.init(m, pos);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   void initInvincibleMonter(int id, Map<Integer, Monster> pos2Monster, int hprate)
/*    */   {
/* 43 */     setCfgID(id);
/* 44 */     SFightCfg fightCfg = SFightCfg.get(id);
/*    */     
/* 46 */     this.xGroup.setGroupai(new GroupAI(fightCfg.groupAiName).getGroupAI());
/*    */     
/* 48 */     for (Map.Entry<Integer, Monster> entry : pos2Monster.entrySet()) {
/* 49 */       int pos = ((Integer)entry.getKey()).intValue();
/* 50 */       Monster m = (Monster)entry.getValue();
/* 51 */       FighterMonster fm = generateFighterInvincibleMonster();
/* 52 */       fm.init(m, pos, hprate);
/*    */     }
/*    */   }
/*    */   
/*    */   protected int getCfgID()
/*    */   {
/* 58 */     return getExtra(FightGroupExtra.Monster_Cfg_ID);
/*    */   }
/*    */   
/*    */   protected void setCfgID(int id) {
/* 62 */     setExtra(FightGroupExtra.Monster_Cfg_ID, id);
/*    */   }
/*    */   
/*    */   protected GroupAI getGroupAI() {
/* 66 */     return this.xGroup.getGroupai();
/*    */   }
/*    */   
/*    */   protected void setNpcMonsterGroup() {
/* 70 */     setExtra(FightGroupExtra.Monster_Group_Mini_Type, 1);
/*    */   }
/*    */   
/*    */   protected boolean isNpcMonsterGroup() {
/* 74 */     int mini_type = getExtra(FightGroupExtra.Monster_Group_Mini_Type);
/* 75 */     return mini_type == 1;
/*    */   }
/*    */   
/*    */   static boolean isNpcMonsterGroup(xbean.FightGroup xGroup) {
/* 79 */     Integer value = (Integer)xGroup.getExtra().get(Integer.valueOf(FightGroupExtra.Monster_Group_Mini_Type.ordinal()));
/* 80 */     if (value == null) {
/* 81 */       return false;
/*    */     }
/* 83 */     return value.intValue() == 1;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FightGroupMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */