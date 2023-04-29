/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ 
/*    */ public class NoEffect extends OutFightEffect
/*    */ {
/*    */   public boolean attach(IOutFightObject target)
/*    */   {
/* 10 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(IOutFightObject target)
/*    */   {
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\NoEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */