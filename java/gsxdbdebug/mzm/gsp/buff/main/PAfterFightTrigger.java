/*    */ package mzm.gsp.buff.main;
/*    */ 
/*    */ import mzm.gsp.buff.confbean.SBuffCfg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.role.main.RoleOutFightObj;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PAfterFightTrigger
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PAfterFightTrigger(long roleId)
/*    */   {
/* 18 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     boolean isTrigger = BuffManager.triggerBuff(this.roleId, new ITriggerCondition()
/*    */     {
/*    */       public boolean isCanTrigger(long roleId, int buffId) {
/* 26 */         SBuffCfg buffCfg = SBuffCfg.get(buffId);
/* 27 */         if (buffCfg == null) {
/* 28 */           return false;
/*    */         }
/* 30 */         return buffCfg.effectType == 1;
/*    */       }
/*    */     });
/* 33 */     if (isTrigger) {
/* 34 */       RoleOutFightObj role = RoleInterface.getRoleOutFightObject(this.roleId);
/* 35 */       role.syncClientRoleProperty();
/*    */     }
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\PAfterFightTrigger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */