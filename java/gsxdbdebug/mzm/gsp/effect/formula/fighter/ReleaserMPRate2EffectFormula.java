/*    */ package mzm.gsp.effect.formula.fighter;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ReleaserMPRate2EffectFormula
/*    */   implements EffectFormula
/*    */ {
/*    */   private double param1;
/*    */   private double param2;
/*    */   private double param3;
/*    */   
/*    */   public ReleaserMPRate2EffectFormula(double param1, double param2, double param3)
/*    */   {
/* 20 */     this.param1 = param1;
/* 21 */     this.param2 = param2;
/* 22 */     this.param3 = param3;
/*    */   }
/*    */   
/*    */   public int calc(Skill skill, Fighter realser, Fighter targert)
/*    */   {
/* 27 */     double mpRate = realser.getMp() * 1.0D / realser.getMaxMp();
/* 28 */     if (mpRate == 0.0D) {
/* 29 */       GameServer.logger().error("气血值为0,使用公式 ReleaserPHRate1EffectFormula 出错");
/* 30 */       return Integer.MAX_VALUE;
/*    */     }
/* 32 */     double ret = this.param1 / (mpRate * mpRate) + this.param2 / mpRate + this.param3;
/* 33 */     return (int)ret;
/*    */   }
/*    */   
/*    */   public int getParamConst()
/*    */   {
/* 38 */     return (int)this.param3;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\formula\fighter\ReleaserMPRate2EffectFormula.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */