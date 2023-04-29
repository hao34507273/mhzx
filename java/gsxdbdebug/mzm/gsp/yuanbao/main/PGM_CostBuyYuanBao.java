/*    */ package mzm.gsp.yuanbao.main;
/*    */ 
/*    */ import mzm.gsp.qingfu.main.CostType;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_CostBuyYuanBao extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long yuanbaoNum;
/*    */   
/*    */   public PGM_CostBuyYuanBao(long roleId, long yuanbaoNum)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.yuanbaoNum = yuanbaoNum;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 22 */     String userid = RoleInterface.getUserId(this.roleId);
/* 23 */     TLogArg tLogArg = new TLogArg(mzm.gsp.tlog.LogReason.GM_ADD);
/* 24 */     return QingfuInterface.costYuanbao(userid, this.roleId, (int)this.yuanbaoNum, CostType.CostBindFirstTest, tLogArg) == mzm.gsp.qingfu.main.CostResult.Success;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\yuanbao\main\PGM_CostBuyYuanBao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */