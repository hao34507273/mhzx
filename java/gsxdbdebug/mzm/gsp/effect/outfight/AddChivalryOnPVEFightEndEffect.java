/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.chivalry.main.ChivalryInterface;
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ import mzm.gsp.role.main.RoleOutFightObj;
/*    */ 
/*    */ public class AddChivalryOnPVEFightEndEffect
/*    */   extends OutFightEffect
/*    */ {
/*    */   private final int chivalryGainType;
/*    */   
/*    */   public AddChivalryOnPVEFightEndEffect(int chivalryGainType)
/*    */   {
/* 15 */     this.chivalryGainType = chivalryGainType;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean attach(IOutFightObject target)
/*    */   {
/* 21 */     if (!(target instanceof RoleOutFightObj)) {
/* 22 */       return true;
/*    */     }
/* 24 */     RoleOutFightObj outFightObj = (RoleOutFightObj)target;
/* 25 */     long roleId = outFightObj.getId();
/*    */     
/*    */ 
/* 28 */     ChivalryInterface.addPVEChivalryAddInfo(roleId, this.chivalryGainType, 1);
/*    */     
/* 30 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean detach(IOutFightObject target)
/*    */   {
/* 36 */     if (!(target instanceof RoleOutFightObj)) {
/* 37 */       return true;
/*    */     }
/* 39 */     RoleOutFightObj outFightObj = (RoleOutFightObj)target;
/* 40 */     long roleId = outFightObj.getId();
/*    */     
/*    */ 
/* 43 */     ChivalryInterface.removePVEChivalryAddInfo(roleId, this.chivalryGainType, 1);
/*    */     
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\AddChivalryOnPVEFightEndEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */