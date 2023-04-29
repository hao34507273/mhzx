/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.fighter.Interface.Validate;
/*    */ import mzm.gsp.effect.main.EffectInterface;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.FighterStatus;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class RoundsAdd extends FighterEffect implements mzm.gsp.fight.handle.RoundStartHandle, Validate
/*    */ {
/*    */   private int mask;
/*    */   private int effectid;
/*    */   
/*    */   public RoundsAdd(int mask, int effectid)
/*    */   {
/* 17 */     this.mask = mask;
/* 18 */     this.effectid = effectid;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 23 */     fighter.addRoundStartHandle(this);
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 29 */     fighter.remRoundStartHandle(this);
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public boolean validate()
/*    */   {
/* 35 */     FighterEffectGroup effectGroup = EffectInterface.getEffectGroup(this.effectid);
/* 36 */     if (effectGroup == null) {
/* 37 */       throw new RuntimeException("RoundsAdd中配置的效果组id不存在:效果组id" + this.effectid);
/*    */     }
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   public void onRoundStart(Fighter fighter)
/*    */   {
/* 44 */     if (!fighter.isAlive()) {
/* 45 */       return;
/*    */     }
/* 47 */     int round = fighter.getRound();
/* 48 */     int mod = round % 10;
/* 49 */     int x2y = 1;
/* 50 */     if (mod > 0) {
/* 51 */       x2y = 2 << mod - 1;
/*    */     }
/* 53 */     if ((this.mask & x2y) > 0) {
/* 54 */       FighterEffectGroup addGroup = EffectInterface.getEffectGroup(this.effectid);
/* 55 */       if (addGroup != null) {
/* 56 */         int level = super.getSkillLevel();
/* 57 */         addGroup.run(level, fighter, fighter, fighter.getid());
/* 58 */         FighterStatus fighterStatus = fighter.getAndAddRoundStatus();
/* 59 */         int passiveSkillid = getPassiveSkillid();
/* 60 */         if (passiveSkillid > 0) {
/* 61 */           fighterStatus.triggerpassiveskills.add(Integer.valueOf(passiveSkillid));
/*    */         }
/* 63 */         fighter.fillFighterStatus(fighterStatus);
/*    */       }
/* 65 */       return;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RoundsAdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */