/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.fighter.Interface.ReliveType;
/*    */ import mzm.gsp.effect.fighter.Interface.Validate;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.BeKilledHandle;
/*    */ import mzm.gsp.fight.handle.BeKilledHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeKilledHandle.OutPutObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.fight.main.FighterMonster;
/*    */ import mzm.gsp.monster.confbean.SMonsterGroupCfg;
/*    */ 
/*    */ public class MonsterRelive extends FighterEffect implements BeKilledHandle, ReliveType, Validate
/*    */ {
/*    */   private int monstergroupid;
/*    */   private int number;
/*    */   private int hprate;
/*    */   
/*    */   public MonsterRelive(int monstergroupid, int number, int hprate)
/*    */   {
/* 22 */     this.monstergroupid = monstergroupid;
/* 23 */     this.number = number;
/* 24 */     this.hprate = hprate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 29 */     fighter.addBeKilledHandle(this);
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 35 */     fighter.remBeKilledHandle(this);
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   public void handleOnBeKilled(BeKilledHandle.InputObj inputObj, BeKilledHandle.OutPutObj outPutObj)
/*    */   {
/* 41 */     if (inputObj.target == null) {
/* 42 */       return;
/*    */     }
/* 44 */     Fighter target = inputObj.target;
/* 45 */     int liveNum = 0;
/* 46 */     SMonsterGroupCfg sMonsterGroupCfg = SMonsterGroupCfg.get(this.monstergroupid);
/* 47 */     if ((target instanceof FighterMonster)) {
/* 48 */       for (Fighter fighterFriend : target.getFriendLiveFighters()) {
/* 49 */         if ((fighterFriend instanceof FighterMonster)) {
/* 50 */           FighterMonster monster = (FighterMonster)fighterFriend;
/* 51 */           if (sMonsterGroupCfg.monsterids.contains(Integer.valueOf(monster.getMonsterid()))) {
/* 52 */             liveNum++;
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 58 */     if (liveNum < this.number) {
/* 59 */       return;
/*    */     }
/* 61 */     int hpchange = (int)(target.getMaxHp() * (this.hprate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 62 */     target.addHp(hpchange);
/* 63 */     if (target.getHp() > 0) {
/* 64 */       target.setAlive();
/* 65 */       target.onRelive();
/* 66 */       target.addActionCount();
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean validate()
/*    */   {
/* 72 */     SMonsterGroupCfg sMonsterGroupCfg = SMonsterGroupCfg.get(this.monstergroupid);
/* 73 */     if (sMonsterGroupCfg == null) {
/* 74 */       throw new RuntimeException("MonsterRelive效果中配置的怪物组id不存在!!monstergroupid:" + this.monstergroupid);
/*    */     }
/* 76 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\MonsterRelive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */