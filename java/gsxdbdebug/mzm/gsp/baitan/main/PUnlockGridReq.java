/*    */ package mzm.gsp.baitan.main;
/*    */ 
/*    */ import mzm.gsp.baitan.SCommonResultRes;
/*    */ import mzm.gsp.baitan.SUnlockGridRes;
/*    */ import mzm.gsp.baitan.confbean.BaiTanConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.qingfu.main.CostResult;
/*    */ import mzm.gsp.qingfu.main.CostType;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.RoleGrid;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2grid;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PUnlockGridReq extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private long yuanBao;
/*    */   
/*    */   public PUnlockGridReq(long roleId, long yuanBao)
/*    */   {
/* 27 */     this.roleId = roleId;
/* 28 */     this.yuanBao = yuanBao;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     if (!BaiTanManager.isRoleStateCanBaiTanBuyOrSell(this.roleId))
/*    */     {
/* 36 */       String logStr = String.format("[baitan]PUnlockGridReq.processImp@role state can not baitan sell or buy|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 38 */       BaiTanManager.logger.info(logStr);
/* 39 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 43 */     String userid = RoleInterface.getUserId(this.roleId);
/* 44 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 46 */     if (this.yuanBao != QingfuInterface.getBalance(userid, true))
/*    */     {
/* 48 */       return false;
/*    */     }
/* 50 */     RoleGrid roleGrid = Role2grid.get(Long.valueOf(this.roleId));
/* 51 */     if (roleGrid == null)
/*    */     {
/* 53 */       return false;
/*    */     }
/* 55 */     if (roleGrid.getMaxgridnum() >= BaiTanConsts.getInstance().MAX_BAITAN_GRID_LIMIT)
/*    */     {
/* 57 */       return false;
/*    */     }
/* 59 */     if (QingfuInterface.costYuanbao(userid, this.roleId, BaiTanConsts.getInstance().EXPEND_TANWEI_NEED_YUANBAO, CostType.COST_BIND_FIRST_BAITAN_UNLOCK_GRID, new TLogArg(LogReason.BAITAN_UNLOCK_GRID_YUANBAO_REM)) != CostResult.Success)
/*    */     {
/*    */ 
/* 62 */       SCommonResultRes res = new SCommonResultRes();
/* 63 */       res.res = 5;
/* 64 */       OnlineManager.getInstance().sendAtOnce(this.roleId, res);
/* 65 */       return false;
/*    */     }
/* 67 */     roleGrid.setMaxgridnum(roleGrid.getMaxgridnum() + 1);
/* 68 */     SUnlockGridRes res = new SUnlockGridRes();
/* 69 */     res.gridsize = roleGrid.getMaxgridnum();
/* 70 */     OnlineManager.getInstance().send(this.roleId, res);
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\PUnlockGridReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */