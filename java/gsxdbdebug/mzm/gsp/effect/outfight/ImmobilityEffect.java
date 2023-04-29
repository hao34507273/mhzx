/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.role.main.RoleOutFightObj;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ImmobilityEffect
/*    */   extends OutFightEffect
/*    */ {
/*    */   public ImmobilityEffect(int ignore) {}
/*    */   
/*    */   public boolean attach(IOutFightObject target)
/*    */   {
/* 18 */     if (!(target instanceof RoleOutFightObj))
/*    */     {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     RoleOutFightObj tmp = (RoleOutFightObj)target;
/* 24 */     return MapInterface.setLimitMovementStatus(tmp.getId(), true);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean detach(IOutFightObject target)
/*    */   {
/* 30 */     if (!(target instanceof RoleOutFightObj))
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     RoleOutFightObj tmp = (RoleOutFightObj)target;
/* 36 */     return MapInterface.setLimitMovementStatus(tmp.getId(), false);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\ImmobilityEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */