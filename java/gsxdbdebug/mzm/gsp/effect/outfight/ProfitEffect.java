/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.confbean.SProfitEffectCfg;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ 
/*    */ public class ProfitEffect extends OutFightEffect
/*    */ {
/*    */   private int profitCfg;
/*    */   private int buffId;
/*    */   private SProfitEffectCfg sProfitEffectCfg;
/*    */   
/*    */   public boolean attach(IOutFightObject target)
/*    */   {
/* 15 */     return false;
/*    */   }
/*    */   
/*    */   public boolean detach(IOutFightObject target)
/*    */   {
/* 20 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getBuffId()
/*    */   {
/* 28 */     return this.buffId;
/*    */   }
/*    */   
/*    */   public void setBuffId(int buffId) {
/* 32 */     this.buffId = buffId;
/*    */   }
/*    */   
/*    */   public int getProfitCfg() {
/* 36 */     return this.profitCfg;
/*    */   }
/*    */   
/*    */   public void setProfitCfg(int profitCfg) {
/* 40 */     this.profitCfg = profitCfg;
/* 41 */     this.sProfitEffectCfg = SProfitEffectCfg.get(profitCfg);
/*    */   }
/*    */   
/*    */   public ProfitEffect(int profitCfg) {
/* 45 */     setProfitCfg(profitCfg);
/*    */   }
/*    */   
/*    */   public boolean checkPorfitCfgEffect(int maskType) {
/* 49 */     if (this.sProfitEffectCfg != null) {
/* 50 */       return true;
/*    */     }
/* 52 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\ProfitEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */