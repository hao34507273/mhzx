/*    */ package mzm.gsp.yuanbao.main;
/*    */ 
/*    */ import mzm.gsp.qingfu.main.PresentResult;
/*    */ import mzm.gsp.qingfu.main.PresentType;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_AddBuyYuanBao
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long yuanbaoNum;
/*    */   
/*    */   public PGM_AddBuyYuanBao(long roleId, long yuanbaoNum)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.yuanbaoNum = yuanbaoNum;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     String userid = RoleInterface.getUserId(this.roleId);
/* 29 */     TLogArg tLogArg = new TLogArg(LogReason.GM_ADD);
/* 30 */     return QingfuInterface.presentYuanbao(userid, this.roleId, (int)this.yuanbaoNum, PresentType.PRESENT_GM, tLogArg) == PresentResult.Success;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\yuanbao\main\PGM_AddBuyYuanBao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */