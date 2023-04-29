/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.fighter.Interface.HealType;
/*    */ import mzm.gsp.effect.fighter.Interface.OpOnce;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HealHPRateOnce
/*    */   extends FighterEffect
/*    */   implements OpOnce, HealType
/*    */ {
/*    */   private int hprate;
/*    */   private int maxlimit;
/*    */   
/*    */   public HealHPRateOnce(int paramInt1, int paramInt2)
/*    */   {
/* 22 */     this.hprate = paramInt1;
/* 23 */     if (this.hprate >= paramInt2) {
/* 24 */       this.hprate = paramInt2;
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean perform(Skill paramSkill, FighterEffectGroup paramFighterEffectGroup, Fighter paramFighter1, Fighter paramFighter2)
/*    */   {
/* 30 */     int i = (int)(paramFighter2.getMaxHp() * (this.hprate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 31 */     paramFighter2.handleHeal(i);
/* 32 */     paramSkill.addHealHpRet(paramFighter1, paramFighter2, i, false);
/*    */     
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter paramFighter)
/*    */   {
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter paramFighter)
/*    */   {
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\HealHPRateOnce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */