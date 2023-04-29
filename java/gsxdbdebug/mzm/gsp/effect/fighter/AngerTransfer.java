/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import mzm.gsp.effect.fighter.Interface.OpOnce;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.AttackResult;
/*    */ import mzm.gsp.fight.AttackResultBean;
/*    */ import mzm.gsp.fight.FighterStatus;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ 
/*    */ public class AngerTransfer
/*    */   extends FighterEffect
/*    */   implements OpOnce
/*    */ {
/*    */   private int maxanger;
/*    */   
/*    */   public AngerTransfer(int paramInt)
/*    */   {
/* 22 */     this.maxanger = paramInt;
/*    */   }
/*    */   
/*    */   public boolean perform(Skill paramSkill, FighterEffectGroup paramFighterEffectGroup, Fighter paramFighter1, Fighter paramFighter2)
/*    */   {
/* 27 */     int i = paramFighter1.getAnger();
/* 28 */     int j = this.maxanger;
/* 29 */     if (i > j)
/*    */     {
/* 31 */       i = j;
/*    */     }
/*    */     
/* 34 */     paramFighter1.addAnger(-i);
/* 35 */     paramFighter2.addAnger(i);
/*    */     
/* 37 */     AttackResult localAttackResult = paramSkill.getAttackResult(paramFighter2.getid());
/* 38 */     AttackResultBean localAttackResultBean = new AttackResultBean();
/* 39 */     localAttackResultBean.targetstatus.angerchange += i;
/* 40 */     localAttackResultBean.attackerstatus.angerchange += -i;
/* 41 */     paramFighter2.fillFighterStatus(localAttackResultBean.targetstatus);
/* 42 */     paramFighter1.fillFighterStatus(localAttackResultBean.attackerstatus);
/* 43 */     localAttackResult.attackresultbeans.add(localAttackResultBean);
/*    */     
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter paramFighter)
/*    */   {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter paramFighter)
/*    */   {
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\AngerTransfer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */