/*    */ package mzm.gsp.bounty.main;
/*    */ 
/*    */ import mzm.gsp.bounty.SResetBountyCount;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.BountyInfo;
/*    */ import xtable.Role2bounty;
/*    */ 
/*    */ public class PGM_ClearBounty extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_ClearBounty(long roleId)
/*    */   {
/* 15 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     BountyInfo xBountyInfo = Role2bounty.get(Long.valueOf(this.roleId));
/* 23 */     if (xBountyInfo != null)
/*    */     {
/* 25 */       xBountyInfo.setBountycount(0);
/*    */       
/* 27 */       OnlineManager.getInstance().send(this.roleId, new SResetBountyCount());
/*    */     }
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bounty\main\PGM_ClearBounty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */