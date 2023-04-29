/*     */ package mzm.gsp.baitan.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.baitan.SGetSellItemRes;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xbean.RoleGrid;
/*     */ import xbean.ShoppingInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Channel2shoppingid;
/*     */ import xtable.Item2prices;
/*     */ import xtable.Roleshoppinginfo;
/*     */ 
/*     */ public class PGetSellItemReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long shoppingId;
/*     */   private int itemid;
/*     */   
/*     */   public PGetSellItemReq(long roleId, long shoppingId, int itemid)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.shoppingId = shoppingId;
/*  30 */     this.itemid = itemid;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!BaiTanManager.isRoleStateCanBaiTanBuyOrSell(this.roleId))
/*     */     {
/*  39 */       String logStr = String.format("[baitan]PGetSellItemReq.processImp@role state can not baitan sell or buy|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  41 */       BaiTanManager.logger.info(logStr);
/*  42 */       return false;
/*     */     }
/*  44 */     RoleGrid roleGrid = xtable.Role2grid.get(Long.valueOf(this.roleId));
/*  45 */     if ((roleGrid == null) || (!roleGrid.getShoppingid2channelid().containsKey(Long.valueOf(this.shoppingId))))
/*     */     {
/*  47 */       return false;
/*     */     }
/*  49 */     if (!BaiTanManager.isBaiTanSwitchOpenForRole(this.roleId))
/*     */     {
/*  51 */       return false;
/*     */     }
/*  53 */     long channelid = ((Long)roleGrid.getShoppingid2channelid().remove(Long.valueOf(this.shoppingId))).longValue();
/*     */     
/*  55 */     long key = mzm.gsp.GameServerInfoManager.toGlobalId(this.itemid);
/*  56 */     Lockeys.lock(Item2prices.getTable(), Arrays.asList(new Long[] { Long.valueOf(key) }));
/*  57 */     Lockeys.lock(Channel2shoppingid.getTable(), Arrays.asList(new Long[] { Long.valueOf(channelid) }));
/*  58 */     ShoppingInfo gridInfo = Roleshoppinginfo.get(Long.valueOf(this.shoppingId));
/*  59 */     if (gridInfo == null)
/*     */     {
/*  61 */       String logStr = String.format("[baitan]PGetMoneyReq.processImp@shoppingId error|roleid=%d|shoppingId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.shoppingId) });
/*     */       
/*  63 */       BaiTanManager.logger.error(logStr);
/*     */       
/*  65 */       return false;
/*     */     }
/*  67 */     if ((gridInfo.getRoleid() != this.roleId) || (gridInfo.getItem().getCfgid() != this.itemid))
/*     */     {
/*  69 */       String logStr = String.format("[baitan]PGetMoneyReq.processImp@itemid or roleid error|roleid=%d|itemid=%d|sroleid=%d|sitemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Long.valueOf(gridInfo.getRoleid()), Integer.valueOf(gridInfo.getItem().getCfgid()) });
/*     */       
/*     */ 
/*  72 */       BaiTanManager.logger.error(logStr);
/*     */       
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     if (gridInfo.getItem().getNumber() <= 0)
/*     */     {
/*  79 */       BaiTanManager.sendCommonError(this.roleId, 1);
/*  80 */       return false;
/*     */     }
/*  82 */     int itemId = gridInfo.getItem().getCfgid();
/*     */     
/*  84 */     Item xItem = BaiTanManager.separateItem(gridInfo.getItem(), gridInfo.getItem().getNumber());
/*  85 */     if (!ItemInterface.addItem(this.roleId, xItem, new TLogArg(mzm.gsp.tlog.LogReason.BAITAN_XIAJIA_ADD, itemId)))
/*     */     {
/*  87 */       BaiTanManager.sendCommonError(this.roleId, 0);
/*     */       
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     BaiTanManager.removeSCPI(itemId, gridInfo.getPrice(), channelid, this.shoppingId);
/*  93 */     Roleshoppinginfo.remove(Long.valueOf(this.shoppingId));
/*     */     
/*  95 */     if (gridInfo.getExpire() > DateTimeUtils.getCurrTimeInMillis())
/*     */     {
/*  97 */       BaiTanManager.decItemGridnum(itemId);
/*     */     }
/*  99 */     roleGrid.getNeedrecycleshoppingids().remove(Long.valueOf(this.shoppingId));
/*     */     
/* 101 */     SGetSellItemRes res = new SGetSellItemRes();
/* 102 */     res.shoppingid = this.shoppingId;
/* 103 */     OnlineManager.getInstance().send(this.roleId, res);
/* 104 */     BaiTanManager.stopObserver(this.roleId, this.shoppingId);
/* 105 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\PGetSellItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */