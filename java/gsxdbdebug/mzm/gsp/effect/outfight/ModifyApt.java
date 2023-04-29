/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModifyApt
/*    */   extends OutFightEffect
/*    */ {
/*    */   private int apttype;
/*    */   private int atpvalue;
/*    */   
/*    */   public ModifyApt(int apttype, int atpvalue)
/*    */   {
/* 18 */     this.apttype = apttype;
/* 19 */     this.atpvalue = atpvalue;
/*    */   }
/*    */   
/*    */   public boolean attach(IOutFightObject target)
/*    */   {
/* 24 */     return false;
/*    */   }
/*    */   
/*    */   public boolean detach(IOutFightObject target)
/*    */   {
/* 29 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\ModifyApt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */