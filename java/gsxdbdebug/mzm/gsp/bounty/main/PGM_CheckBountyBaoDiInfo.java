/*    */ package mzm.gsp.bounty.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.BountyInfo;
/*    */ import xtable.Role2bounty;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_CheckBountyBaoDiInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_CheckBountyBaoDiInfo(long roleId)
/*    */   {
/* 20 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     BountyInfo xBountyInfo = Role2bounty.get(Long.valueOf(this.roleId));
/* 28 */     if (xBountyInfo == null)
/*    */     {
/* 30 */       GmManager.getInstance().sendResultToGM(this.roleId, "没有赏金任务信息！");
/* 31 */       return false;
/*    */     }
/* 33 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("使用黄金鸟个数=%d |免费刷新次数=%d|前期已保底数=%d", new Object[] { Integer.valueOf(xBountyInfo.getUsedbirdnum()), Integer.valueOf(xBountyInfo.getFreerefreshcount()), Integer.valueOf(xBountyInfo.getPreguaranteecount()) }));
/*    */     
/*    */ 
/*    */ 
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bounty\main\PGM_CheckBountyBaoDiInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */