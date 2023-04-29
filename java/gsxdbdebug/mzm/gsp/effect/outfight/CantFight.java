/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.competition.main.CompetitionInterface;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ import mzm.gsp.role.main.RoleOutFightObj;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CantFight
/*    */   extends OutFightEffect
/*    */ {
/*    */   private int mask;
/*    */   
/*    */   public CantFight(int mask)
/*    */   {
/* 22 */     this.mask = mask;
/*    */   }
/*    */   
/*    */   public boolean attach(IOutFightObject target)
/*    */   {
/* 27 */     if (!(target instanceof RoleOutFightObj)) {
/* 28 */       return true;
/*    */     }
/* 30 */     RoleOutFightObj outFightObj = (RoleOutFightObj)target;
/* 31 */     long roleId = outFightObj.getId();
/*    */     
/* 33 */     if ((this.mask & 0x1) == 1) {
/* 34 */       CompetitionInterface.setProtectedStatus(roleId);
/*    */     }
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(IOutFightObject target)
/*    */   {
/* 41 */     if (!(target instanceof RoleOutFightObj)) {
/* 42 */       return true;
/*    */     }
/* 44 */     RoleOutFightObj outFightObj = (RoleOutFightObj)target;
/* 45 */     long roleId = outFightObj.getId();
/*    */     
/* 47 */     if ((this.mask & 0x1) == 1) {
/* 48 */       CompetitionInterface.unsetProtectedStatus(roleId);
/*    */     }
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\CantFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */