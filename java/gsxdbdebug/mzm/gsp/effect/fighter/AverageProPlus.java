/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.effect.fighter.Interface.OpOnce;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class AverageProPlus
/*    */   extends FighterEffect implements OpOnce
/*    */ {
/*    */   private int mask;
/*    */   
/*    */   public AverageProPlus(int paramInt)
/*    */   {
/* 18 */     this.mask = paramInt;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter paramFighter)
/*    */   {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/* 28 */   public boolean detach(Fighter paramFighter) { return true; }
/*    */   
/*    */   public boolean perform(Skill paramSkill, FighterEffectGroup paramFighterEffectGroup, Fighter paramFighter1, Fighter paramFighter2) { Set localSet;
/*    */     double d1;
/*    */     Fighter localFighter1;
/* 33 */     double d2; Iterator localIterator3; if ((this.mask & 0x1) > 0) {
/* 34 */       localSet = paramFighter1.getFriendLiveFighters();
/* 35 */       localSet.add(paramFighter1);
/*    */       
/* 37 */       d1 = 0.0D;
/* 38 */       for (Iterator localIterator1 = localSet.iterator(); localIterator1.hasNext();) { localFighter1 = (Fighter)localIterator1.next();
/* 39 */         d1 += getHpRate(localFighter1);
/*    */       }
/*    */       
/* 42 */       d2 = d1 / localSet.size();
/* 43 */       for (localIterator3 = localSet.iterator(); localIterator3.hasNext();) { localFighter2 = (Fighter)localIterator3.next();
/* 44 */         averageHpRate(localFighter2, d2);
/*    */       } }
/*    */     Fighter localFighter2;
/*    */     double d3;
/* 48 */     if ((this.mask & 0x2) > 0) {
/* 49 */       localSet = paramFighter1.getFriendLiveFighters();
/* 50 */       localSet.add(paramFighter1);
/*    */       
/* 52 */       d1 = 0.0D;
/* 53 */       for (Iterator localIterator2 = localSet.iterator(); localIterator2.hasNext();) { localFighter1 = (Fighter)localIterator2.next();
/* 54 */         d1 += getMpRate(localFighter1);
/*    */       }
/*    */       
/* 57 */       d3 = d1 / localSet.size();
/* 58 */       for (localIterator3 = localSet.iterator(); localIterator3.hasNext();) { localFighter2 = (Fighter)localIterator3.next();
/* 59 */         averageMpRate(localFighter2, d3);
/*    */       }
/*    */     }
/*    */     
/* 63 */     return true;
/*    */   }
/*    */   
/*    */   public double getHpRate(Fighter paramFighter)
/*    */   {
/* 68 */     double d1 = paramFighter.getMaxHp();
/* 69 */     int i = paramFighter.getHp();
/* 70 */     double d2 = i / d1;
/*    */     
/* 72 */     return d2;
/*    */   }
/*    */   
/*    */   public double getMpRate(Fighter paramFighter)
/*    */   {
/* 77 */     double d1 = paramFighter.getMaxMp();
/* 78 */     int i = paramFighter.getMp();
/* 79 */     double d2 = i / d1;
/*    */     
/* 81 */     return d2;
/*    */   }
/*    */   
/*    */   public void averageHpRate(Fighter paramFighter, double paramDouble)
/*    */   {
/* 86 */     double d = paramFighter.getMaxHp();
/* 87 */     int i = (int)(d * paramDouble);
/* 88 */     paramFighter.setHp(i);
/*    */   }
/*    */   
/*    */   public void averageMpRate(Fighter paramFighter, double paramDouble)
/*    */   {
/* 93 */     double d = paramFighter.getMaxMp();
/* 94 */     int i = (int)(d * paramDouble);
/* 95 */     paramFighter.setMp(i);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\AverageProPlus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */