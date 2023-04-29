/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.AttackResultBean;
/*    */ import mzm.gsp.fight.FighterStatus;
/*    */ import mzm.gsp.fight.handle.BeforeHealHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeHealHandle.OutputObj;
/*    */ import mzm.gsp.fight.handle.RoundEndHandle;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.FightFormulaHelp;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.fight.main.FighterBuff;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ 
/*    */ public class ForceBirth
/*    */   extends FighterEffect
/*    */   implements RoundEndHandle
/*    */ {
/*    */   private int rebirthwithphrate;
/*    */   private int ratemax;
/*    */   
/*    */   public ForceBirth(int paramInt1, int paramInt2)
/*    */   {
/* 27 */     if (paramInt1 > paramInt2) {
/* 28 */       this.rebirthwithphrate = paramInt2;
/*    */     } else {
/* 30 */       this.rebirthwithphrate = paramInt1;
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter paramFighter)
/*    */   {
/* 36 */     paramFighter.addRoundEndHandle(this);
/* 37 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter paramFighter)
/*    */   {
/* 42 */     paramFighter.remRoundEndHandle(this);
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public void onRoundEnd(Fighter paramFighter)
/*    */   {
/* 48 */     int i = getLeftRound();
/* 49 */     FighterEffectGroup localFighterEffectGroup = getGroup().getFighterEffectGroup();
/* 50 */     Skill localSkill = getGroup().getSkill();
/* 51 */     Fighter localFighter1 = getGroup().getReleaser(paramFighter);
/* 52 */     Fighter localFighter2 = paramFighter;
/* 53 */     if (i == 1)
/*    */     {
/* 55 */       if ((localFighter2.isExisted()) && ((localFighter2.isFakeDead()) || (localFighter2.isDead())))
/*    */       {
/*    */ 
/* 58 */         BeforeHealHandle.OutputObj localOutputObj1 = localFighter1.handleBeforeHeal(new BeforeHealHandle.InputObj(localFighter1, localFighter2, localSkill, localFighterEffectGroup));
/*    */         
/* 60 */         BeforeHealHandle.OutputObj localOutputObj2 = localFighter2.handleBeforeHeal(new BeforeHealHandle.InputObj(localFighter1, localFighter2, localSkill, localFighterEffectGroup));
/*    */         
/* 62 */         boolean bool1 = FightFormulaHelp.isHealCrt(localFighter1.getMAGCRTRate(), localFighter1, localFighter2);
/* 63 */         int j = FightFormulaHelp.calHealOnce(localFighter1, localFighter2, bool1, localOutputObj1, localOutputObj2);
/* 64 */         j = (int)(j + localFighter2.getMaxHp() * (this.rebirthwithphrate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*    */         
/* 66 */         localFighter2.addHp(j);
/* 67 */         localFighter2.setAlive();
/* 68 */         localFighter2.addActionCount();
/* 69 */         localFighter2.onRelive();
/*    */         
/* 71 */         FighterStatus localFighterStatus1 = paramFighter.getAndAddRoundStatus();
/*    */         
/* 73 */         localFighterStatus1.hpchange += j;
/* 74 */         localFighterStatus1.status_set.add(Integer.valueOf(23));
/* 75 */         paramFighter.fillFighterStatus(localFighterStatus1);
/*    */       }
/* 77 */       else if (localFighter2.isExisted())
/*    */       {
/* 79 */         double d = localFighter2.getMaxHp() * (this.rebirthwithphrate * 1.0D / FightArgs.getInstance().getDefaultRate());
/* 80 */         BeforeHealHandle.OutputObj localOutputObj3 = localFighter1.handleBeforeHeal(new BeforeHealHandle.InputObj(localFighter1, localFighter2, localSkill, localFighterEffectGroup));
/*    */         
/* 82 */         BeforeHealHandle.OutputObj localOutputObj4 = localFighter2.handleBeforeHeal(new BeforeHealHandle.InputObj(localFighter1, localFighter2, localSkill, localFighterEffectGroup));
/* 83 */         localOutputObj3.baseHeal = ((int)(localOutputObj3.baseHeal + d));
/* 84 */         boolean bool2 = FightFormulaHelp.isHealCrt(localFighter1.getMAGCRTRate(), localFighter1, localFighter2);
/* 85 */         int k = FightFormulaHelp.calHealOnce(localFighter1, localFighter2, bool2, localOutputObj3, localOutputObj4);
/* 86 */         int m = localFighter2.handleHeal(k);
/*    */         
/* 88 */         AttackResultBean localAttackResultBean = localSkill.addHealHpRet(localFighter1, localFighter2, m, bool2);
/* 89 */         localAttackResultBean.attackerstatus.triggerpassiveskills.addAll(localOutputObj3.releaserPassiveSkills);
/* 90 */         localAttackResultBean.targetstatus.triggerpassiveskills.addAll(localOutputObj4.targetPassiveSkills);
/*    */         
/* 92 */         FighterStatus localFighterStatus2 = paramFighter.getAndAddRoundStatus();
/* 93 */         localFighterStatus2.hpchange += m;
/* 94 */         paramFighter.fillFighterStatus(localFighterStatus2);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ForceBirth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */