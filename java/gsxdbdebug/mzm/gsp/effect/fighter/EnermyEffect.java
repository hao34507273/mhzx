/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.Random;
/*    */ import mzm.gsp.effect.main.EffectInterface;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.fight.main.FighterMonster;
/*    */ import mzm.gsp.monster.confbean.SMonsterGroupCfg;
/*    */ 
/*    */ public class EnermyEffect extends FighterEffect implements mzm.gsp.fight.handle.EnterFightHandle, mzm.gsp.effect.fighter.Interface.Validate
/*    */ {
/*    */   private int monsterGroupid;
/*    */   private int buffid;
/*    */   private int addrate;
/*    */   
/*    */   public EnermyEffect(int monsterGroupid, int buffid, int addrate)
/*    */   {
/* 20 */     this.monsterGroupid = monsterGroupid;
/* 21 */     this.buffid = buffid;
/* 22 */     this.addrate = addrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 27 */     fighter.addEnterFightHandle(this);
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 33 */     fighter.remEnterFightHandle(this);
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public boolean validate()
/*    */   {
/* 39 */     FighterEffectGroup effectGroup = EffectInterface.getEffectGroup(this.buffid);
/* 40 */     if (effectGroup == null) {
/* 41 */       throw new RuntimeException("EnermyEffect中配置的效果组id不存在:效果组id" + this.buffid);
/*    */     }
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public void onEnterFight(Fighter fighter)
/*    */   {
/* 48 */     int rate = xdb.Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 49 */     SMonsterGroupCfg sMonsterGroupCfg; FighterEffectGroup fighterEffectGroup; if (this.addrate > rate) {
/* 50 */       sMonsterGroupCfg = SMonsterGroupCfg.get(this.monsterGroupid);
/* 51 */       fighterEffectGroup = EffectInterface.getEffectGroup(this.buffid);
/* 52 */       if (sMonsterGroupCfg == null) {
/* 53 */         for (Fighter fighterEnermy : fighter.getEnermyLiveFighters()) {
/* 54 */           int level = super.getSkillLevel();
/* 55 */           fighterEffectGroup.run(level, fighter, fighterEnermy, fighterEnermy.getid());
/*    */         }
/*    */       } else {
/* 58 */         for (Fighter fighterEnermy : fighter.getEnermyLiveFighters()) {
/* 59 */           if ((fighterEnermy instanceof FighterMonster)) {
/* 60 */             FighterMonster monster = (FighterMonster)fighterEnermy;
/* 61 */             if (sMonsterGroupCfg.monsterids.contains(Integer.valueOf(monster.getid()))) {
/* 62 */               int level = super.getSkillLevel();
/* 63 */               fighterEffectGroup.run(level, fighter, fighterEnermy, fighterEnermy.getid());
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\EnermyEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */