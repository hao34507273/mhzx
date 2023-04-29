/*    */ package mzm.gsp.award.main;
/*    */ 
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCheckFixAwardInfoReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int fixAwardId;
/*    */   private final int itemIndex;
/*    */   
/*    */   public PCheckFixAwardInfoReq(long roleId, int fixAwardId, int itemIndex)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.fixAwardId = fixAwardId;
/* 17 */     this.itemIndex = itemIndex;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     AwardReason reason = new AwardReason(LogReason.ROLE_CHECK_FIX_AWARD);
/* 24 */     return RoleAwardManager.onCheckFixAwardInfoReq(this.roleId, this.fixAwardId, this.itemIndex, reason);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\PCheckFixAwardInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */