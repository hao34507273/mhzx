/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ 
/*    */ 
/*    */ public class AuraEffect
/*    */   extends OutFightEffect
/*    */ {
/*    */   private int auraCfgId;
/*    */   
/*    */   public boolean attach(IOutFightObject target)
/*    */   {
/* 14 */     return false;
/*    */   }
/*    */   
/*    */   public boolean detach(IOutFightObject target)
/*    */   {
/* 19 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public AuraEffect(int auraCfgId)
/*    */   {
/* 25 */     setAuraCfgId(auraCfgId);
/*    */   }
/*    */   
/*    */   public int getAuraCfgId() {
/* 29 */     return this.auraCfgId;
/*    */   }
/*    */   
/*    */   public void setAuraCfgId(int auraCfgId) {
/* 33 */     this.auraCfgId = auraCfgId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\AuraEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */