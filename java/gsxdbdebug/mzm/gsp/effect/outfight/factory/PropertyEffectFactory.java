/*    */ package mzm.gsp.effect.outfight.factory;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ 
/*    */ public class PropertyEffectFactory extends AbstractEffectFactory
/*    */ {
/*    */   private int propertyType;
/*    */   private Class<OutFightEffect> effectClass;
/*    */   
/*    */   public PropertyEffectFactory(int propertyType, Class<OutFightEffect> effectClass)
/*    */   {
/* 13 */     this.propertyType = propertyType;
/* 14 */     this.effectClass = effectClass;
/*    */   }
/*    */   
/*    */   public OutFightEffect createEffect(List<?> param)
/*    */     throws Exception
/*    */   {
/* 20 */     return (OutFightEffect)this.effectClass.getConstructors()[0].newInstance(new Object[] { Integer.valueOf(this.propertyType), param.get(0) });
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean checkParam(List<?> param)
/*    */   {
/* 26 */     return param.size() == 1;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\factory\PropertyEffectFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */