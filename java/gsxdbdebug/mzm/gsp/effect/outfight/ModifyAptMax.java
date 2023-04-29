/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModifyAptMax
/*    */   extends OutFightEffect
/*    */ {
/*    */   private int apttype;
/*    */   private int maxapt;
/*    */   
/*    */   public ModifyAptMax(int apttype, int maxapt)
/*    */   {
/* 18 */     this.apttype = apttype;
/* 19 */     this.maxapt = maxapt;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean attach(IOutFightObject target)
/*    */   {
/* 25 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean detach(IOutFightObject target)
/*    */   {
/* 31 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\ModifyAptMax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */