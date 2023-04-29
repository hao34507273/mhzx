/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ import mzm.gsp.role.main.RoleOutFightObj;
/*    */ 
/*    */ public class BaseToPropertyReviseEffect extends OutFightEffect
/*    */ {
/*    */   private int baseType;
/*    */   private int propertyType;
/*    */   private int value;
/*    */   
/*    */   public BaseToPropertyReviseEffect(int baseType, int propertyType, int value)
/*    */   {
/* 15 */     this.baseType = baseType;
/* 16 */     this.propertyType = propertyType;
/* 17 */     this.value = value;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean attach(IOutFightObject target)
/*    */   {
/* 23 */     if (!(target instanceof RoleOutFightObj))
/*    */     {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     RoleOutFightObj tmp = (RoleOutFightObj)target;
/* 29 */     float num = this.value * 1.0F / 10000.0F;
/* 30 */     tmp.addRevisePropertyValue(this.baseType, this.propertyType, num);
/* 31 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean detach(IOutFightObject target)
/*    */   {
/* 37 */     if (!(target instanceof RoleOutFightObj))
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     RoleOutFightObj tmp = (RoleOutFightObj)target;
/* 43 */     float num = this.value * 1.0F / 10000.0F;
/* 44 */     tmp.addRevisePropertyValue(this.baseType, this.propertyType, -num);
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\BaseToPropertyReviseEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */