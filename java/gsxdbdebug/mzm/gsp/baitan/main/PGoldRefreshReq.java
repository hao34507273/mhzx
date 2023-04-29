/*    */ package mzm.gsp.baitan.main;
/*    */ 
/*    */ import mzm.gsp.baitan.SRefreshShopingListRes;
/*    */ import mzm.gsp.baitan.confbean.BaiTanConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Pod;
/*    */ import xbean.RoleGrid;
/*    */ import xbean.Subtype2ItemList;
/*    */ import xtable.Role2baitanshoppinglist;
/*    */ import xtable.Role2grid;
/*    */ 
/*    */ public class PGoldRefreshReq extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int subtype;
/*    */   private int param;
/*    */   
/*    */   public PGoldRefreshReq(long roleId, int subtype, int param)
/*    */   {
/* 25 */     this.roleId = roleId;
/* 26 */     this.subtype = subtype;
/* 27 */     this.param = param;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     if (!BaiTanManager.isRoleStateCanBaiTanBuyOrSell(this.roleId))
/*    */     {
/* 35 */       String logStr = String.format("[baitan]PGoldRefreshReq.processImp@role state can not baitan sell or buy|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 37 */       BaiTanManager.logger.info(logStr);
/* 38 */       return false;
/*    */     }
/* 40 */     if (!BaiTanManager.isSubtyperight(this.subtype))
/*    */     {
/* 42 */       String logStr = String.format("[baitan]PGoldRefreshReq.processImp@ baitan subtype error|roleid=%d|subtype=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.subtype) });
/*    */       
/* 44 */       BaiTanManager.logger.error(logStr);
/* 45 */       return false;
/*    */     }
/* 47 */     if (!BaiTanManager.isBaiTanSwitchOpenForRole(this.roleId))
/*    */     {
/* 49 */       return false;
/*    */     }
/* 51 */     int level = RoleInterface.getLevel(this.roleId);
/* 52 */     if (!BaiTanManager.isOpenForLevel(level))
/*    */     {
/* 54 */       String logStr = String.format("[baitan]PGoldRefreshReq.processImp@ role level not open for baitan|roleid=%d|level=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(level) });
/*    */       
/* 56 */       BaiTanManager.logger.warn(logStr);
/* 57 */       return false;
/*    */     }
/* 59 */     int serverlevel = mzm.gsp.server.main.ServerInterface.getCurrentServerLevel();
/* 60 */     RoleGrid roleGrid = Role2grid.get(Long.valueOf(this.roleId));
/* 61 */     if (roleGrid == null)
/*    */     {
/* 63 */       return false;
/*    */     }
/*    */     
/* 66 */     if (!RoleInterface.cutGold(this.roleId, BaiTanConsts.getInstance().SELF_REFRESH_NEED_GOLD, new TLogArg(LogReason.BAITAN_REFRESH_GOLD_REM)))
/*    */     {
/*    */ 
/* 69 */       return false;
/*    */     }
/*    */     
/* 72 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 73 */     Subtype2ItemList subtype2ItemList = Role2baitanshoppinglist.get(Long.valueOf(this.roleId));
/*    */     
/* 75 */     if (subtype2ItemList == null)
/*    */     {
/* 77 */       subtype2ItemList = Pod.newSubtype2ItemList();
/* 78 */       Role2baitanshoppinglist.insert(Long.valueOf(this.roleId), subtype2ItemList);
/*    */     }
/*    */     
/* 81 */     BaiTanManager.freshRoleShoppingListBySubtype(this.roleId, subtype2ItemList, this.subtype, level, serverlevel, now, roleGrid);
/*    */     
/* 83 */     roleGrid.setLastrefreshtime(now);
/*    */     
/* 85 */     SRefreshShopingListRes res = new SRefreshShopingListRes();
/* 86 */     res.costgold = BaiTanConsts.getInstance().SELF_REFRESH_NEED_GOLD;
/* 87 */     res.lastfreshtime = (roleGrid.getLastrefreshtime() / 1000L);
/*    */     
/* 89 */     if ((BaiTanManager.isEquipSubtype(this.subtype)) && (this.param != 0))
/*    */     {
/* 91 */       BaiTanManager.fillEquipPageInfo(this.roleId, res.pageresult, subtype2ItemList, 1, this.subtype, this.param);
/*    */     }
/*    */     else
/*    */     {
/* 95 */       BaiTanManager.fillPageInfo(this.roleId, res.pageresult, subtype2ItemList, 1, this.subtype);
/*    */     }
/* 97 */     res.pageresult.param = this.param;
/* 98 */     OnlineManager.getInstance().send(this.roleId, res);
/* 99 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\PGoldRefreshReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */