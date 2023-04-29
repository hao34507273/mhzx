/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.common.confbean.STPropertyScoreCfg;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ 
/*    */ public class AddValueEffect
/*    */   extends OutFightEffect
/*    */ {
/*    */   private int propType;
/*    */   private int addValue;
/*    */   
/*    */   public AddValueEffect(int propType, int addValue)
/*    */   {
/* 16 */     this.propType = propType;
/* 17 */     this.addValue = addValue;
/*    */   }
/*    */   
/*    */   public boolean attach(IOutFightObject target) {
/* 21 */     target.addPropertyValue(this.propType, this.addValue);
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(IOutFightObject target) {
/* 26 */     target.addPropertyValue(this.propType, -this.addValue);
/* 27 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getScore()
/*    */   {
/* 37 */     return 0;
/*    */   }
/*    */   
/*    */   public int getScore(int occupation)
/*    */   {
/* 42 */     STPropertyScoreCfg cfg = STPropertyScoreCfg.get(this.propType);
/* 43 */     if (cfg == null) {
/* 44 */       return 0;
/*    */     }
/* 46 */     Double factor = (Double)cfg.occ2factor.get(Integer.valueOf(occupation));
/* 47 */     if (factor == null) {
/* 48 */       return 0;
/*    */     }
/* 50 */     return (int)(factor.doubleValue() * this.addValue);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\AddValueEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */