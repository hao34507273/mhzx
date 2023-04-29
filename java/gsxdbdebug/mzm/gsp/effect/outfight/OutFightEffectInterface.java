/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ import mzm.gsp.effect.main.OutFightEffectManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OutFightEffectInterface
/*    */ {
/*    */   public static OutFightEffect createOutFightEffect(int effectId, List<Integer> paramList)
/*    */   {
/* 21 */     return OutFightEffectManager.getInstance().getEffect(effectId, paramList);
/*    */   }
/*    */   
/*    */   public static boolean isOutFightEffect(int effectId) {
/* 25 */     return OutFightEffectManager.getInstance().isOutFightEffect(effectId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\OutFightEffectInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */