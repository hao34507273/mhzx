/*    */ package mzm.gsp.effect.outfight.factory;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.util.List;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ 
/*    */ public class SpecialEffectFactory
/*    */   extends AbstractEffectFactory
/*    */ {
/*    */   private Constructor<OutFightEffect> effectConstructor;
/*    */   
/*    */   public SpecialEffectFactory(Class<OutFightEffect> effectClass)
/*    */   {
/* 14 */     this.effectConstructor = effectClass.getConstructors()[0];
/*    */   }
/*    */   
/*    */   public OutFightEffect createEffect(List<?> param) throws Exception
/*    */   {
/* 19 */     return (OutFightEffect)this.effectConstructor.newInstance(param.toArray());
/*    */   }
/*    */   
/*    */   public boolean checkParam(List<?> param)
/*    */   {
/* 24 */     return this.effectConstructor.getParameterTypes().length == param.size();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\factory\SpecialEffectFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */