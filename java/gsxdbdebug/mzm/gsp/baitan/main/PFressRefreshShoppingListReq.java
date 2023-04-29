/*     */ package mzm.gsp.baitan.main;
/*     */ 
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.baitan.SRefreshShopingListRes;
/*     */ import mzm.gsp.baitan.confbean.BaiTanConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleGrid;
/*     */ import xbean.Subtype2ItemList;
/*     */ import xtable.Role2baitanshoppinglist;
/*     */ import xtable.Role2grid;
/*     */ 
/*     */ public class PFressRefreshShoppingListReq extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int subtype;
/*     */   private int param;
/*     */   
/*     */   public PFressRefreshShoppingListReq(long roleId, int subtype, int param)
/*     */   {
/*  25 */     this.roleId = roleId;
/*  26 */     this.subtype = subtype;
/*  27 */     this.param = param;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     if (!BaiTanManager.isRoleStateCanBaiTanBuyOrSell(this.roleId))
/*     */     {
/*  35 */       String logStr = String.format("[baitan]PFressRefreshShoppingListReq.processImp@role state can not baitan sell or buy|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  37 */       BaiTanManager.logger.info(logStr);
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     if (!BaiTanManager.isSubtyperight(this.subtype))
/*     */     {
/*  43 */       String logStr = String.format("[baitan]PFressRefreshShoppingListReq.processImp@ baitan subtype error|roleid=%d|subtype=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.subtype) });
/*     */       
/*     */ 
/*  46 */       BaiTanManager.logger.error(logStr);
/*  47 */       return false;
/*     */     }
/*  49 */     if (!BaiTanManager.isBaiTanSwitchOpenForRole(this.roleId))
/*     */     {
/*  51 */       return false;
/*     */     }
/*  53 */     int level = RoleInterface.getLevel(this.roleId);
/*  54 */     if (!BaiTanManager.isOpenForLevel(level))
/*     */     {
/*  56 */       String logStr = String.format("[baitan]PFressRefreshShoppingListReq.processImp@ role level not open for baitan|roleid=%d|level=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(level) });
/*     */       
/*     */ 
/*  59 */       BaiTanManager.logger.warn(logStr);
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     int serverlevel = mzm.gsp.server.main.ServerInterface.getCurrentServerLevel();
/*     */     
/*  65 */     RoleGrid roleGrid = Role2grid.get(Long.valueOf(this.roleId));
/*  66 */     if (roleGrid == null)
/*     */     {
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  72 */     Subtype2ItemList subtype2ItemList = Role2baitanshoppinglist.get(Long.valueOf(this.roleId));
/*  73 */     if ((subtype2ItemList != null) && (TimeUnit.MILLISECONDS.toSeconds(now - roleGrid.getLastrefreshtime()) < BaiTanConsts.getInstance().FREE_REFRESH_TIME_COUNTER))
/*     */     {
/*     */ 
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     if (subtype2ItemList == null)
/*     */     {
/*  81 */       subtype2ItemList = Pod.newSubtype2ItemList();
/*  82 */       Role2baitanshoppinglist.insert(Long.valueOf(this.roleId), subtype2ItemList);
/*     */     }
/*     */     
/*  85 */     BaiTanManager.freshRoleShoppingListBySubtype(this.roleId, subtype2ItemList, this.subtype, level, serverlevel, now, roleGrid);
/*     */     
/*  87 */     roleGrid.setLastrefreshtime(now);
/*     */     
/*  89 */     SRefreshShopingListRes res = new SRefreshShopingListRes();
/*  90 */     res.costgold = 0;
/*  91 */     res.lastfreshtime = TimeUnit.MILLISECONDS.toSeconds(roleGrid.getLastrefreshtime());
/*     */     
/*  93 */     if ((BaiTanManager.isEquipSubtype(this.subtype)) && (this.param != 0))
/*     */     {
/*  95 */       BaiTanManager.fillEquipPageInfo(this.roleId, res.pageresult, subtype2ItemList, 1, this.subtype, this.param);
/*     */     }
/*     */     else
/*     */     {
/*  99 */       BaiTanManager.fillPageInfo(this.roleId, res.pageresult, subtype2ItemList, 1, this.subtype);
/*     */     }
/* 101 */     res.pageresult.param = this.param;
/* 102 */     OnlineManager.getInstance().send(this.roleId, res);
/* 103 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\PFressRefreshShoppingListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */