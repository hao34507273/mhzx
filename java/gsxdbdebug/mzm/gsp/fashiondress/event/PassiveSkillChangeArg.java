/*    */ package mzm.gsp.fashiondress.event;
/*    */ 
/*    */ import mzm.gsp.fashiondress.main.FashionDressChangeReasonEnum;
/*    */ 
/*    */ public class PassiveSkillChangeArg
/*    */ {
/*    */   private final long roleId;
/*    */   private final FashionDressChangeReasonEnum changeReason;
/*    */   
/*    */   public PassiveSkillChangeArg(long roleId)
/*    */   {
/* 12 */     this.roleId = roleId;
/* 13 */     this.changeReason = FashionDressChangeReasonEnum.NORMAL;
/*    */   }
/*    */   
/*    */   public PassiveSkillChangeArg(long roleId, FashionDressChangeReasonEnum changeReason)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.changeReason = changeReason;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRoleId()
/*    */   {
/* 29 */     return this.roleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public FashionDressChangeReasonEnum getChangeReason()
/*    */   {
/* 37 */     return this.changeReason;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\event\PassiveSkillChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */