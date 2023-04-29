/*     */ package mzm.gsp.baitan.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.baitan.SGetMoneyRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.ModMoneyResult;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xbean.RoleGrid;
/*     */ import xbean.ShoppingInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Channel2shoppingid;
/*     */ import xtable.Item2prices;
/*     */ import xtable.Roleshoppinginfo;
/*     */ 
/*     */ public class PGetMoneyReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int itemid;
/*     */   private long shoppingId;
/*     */   
/*     */   public PGetMoneyReq(long roleId, int itemid, long shoppingId)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.itemid = itemid;
/*  30 */     this.shoppingId = shoppingId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (!BaiTanManager.isRoleStateCanBaiTanBuyOrSell(this.roleId))
/*     */     {
/*  38 */       String logStr = String.format("[baitan]PGetMoneyReq.processImp@role state can not baitan sell or buy|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  40 */       BaiTanManager.logger.info(logStr);
/*  41 */       return false;
/*     */     }
/*  43 */     RoleGrid roleGrid = xtable.Role2grid.get(Long.valueOf(this.roleId));
/*  44 */     if ((roleGrid == null) || (!roleGrid.getShoppingid2channelid().containsKey(Long.valueOf(this.shoppingId))))
/*     */     {
/*  46 */       return false;
/*     */     }
/*  48 */     if (!BaiTanManager.isBaiTanSwitchOpenForRole(this.roleId))
/*     */     {
/*  50 */       return false;
/*     */     }
/*  52 */     long key = GameServerInfoManager.toGlobalId(this.itemid);
/*     */     
/*  54 */     Lockeys.lock(Item2prices.getTable(), Arrays.asList(new Long[] { Long.valueOf(key) }));
/*     */     
/*  56 */     long oldchannelid = ((Long)roleGrid.getShoppingid2channelid().get(Long.valueOf(this.shoppingId))).longValue();
/*  57 */     Lockeys.lock(Channel2shoppingid.getTable(), Arrays.asList(new Long[] { Long.valueOf(oldchannelid) }));
/*     */     
/*  59 */     ShoppingInfo gridInfo = Roleshoppinginfo.get(Long.valueOf(this.shoppingId));
/*     */     
/*  61 */     if (gridInfo == null)
/*     */     {
/*  63 */       String logStr = String.format("[baitan]PGetMoneyReq.processImp@shoppingId error|roleid=%d|shoppingId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.shoppingId) });
/*     */       
/*  65 */       BaiTanManager.logger.error(logStr);
/*     */       
/*  67 */       return false;
/*     */     }
/*  69 */     if ((gridInfo.getRoleid() != this.roleId) || (gridInfo.getItem().getCfgid() != this.itemid))
/*     */     {
/*  71 */       String logStr = String.format("[baitan]PGetMoneyReq.processImp@itemid or roleid error|roleid=%d|itemid=%d|sroleid=%d|sitemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Long.valueOf(gridInfo.getRoleid()), Integer.valueOf(gridInfo.getItem().getCfgid()) });
/*     */       
/*     */ 
/*  74 */       BaiTanManager.logger.error(logStr);
/*     */       
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     int itemid = gridInfo.getItem().getCfgid();
/*  80 */     int itemNum = gridInfo.getItem().getNumber();
/*  81 */     int sellNum = gridInfo.getTotalnum() - itemNum;
/*  82 */     int price = gridInfo.getPrice();
/*  83 */     int tax = BaiTanManager.computeMoney(price);
/*  84 */     long getMoney = sellNum * tax;
/*  85 */     if (!mzm.gsp.role.main.RoleInterface.addSilverWithinMax(this.roleId, getMoney, new TLogArg(mzm.gsp.tlog.LogReason.BAITAN_GET_MONEY_ADD)).isSucceed())
/*     */     {
/*  87 */       String logStr = String.format("[baitan]PGetMoneyReq.processImp@addsilver error|roleid=%d|addsilver=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(getMoney) });
/*     */       
/*  89 */       BaiTanManager.logger.error(logStr);
/*  90 */       BaiTanManager.sendCommonError(this.roleId, 8);
/*  91 */       return false;
/*     */     }
/*  93 */     gridInfo.setTotalnum(itemNum);
/*  94 */     if (itemNum <= 0)
/*     */     {
/*  96 */       long channelid = ((Long)roleGrid.getShoppingid2channelid().remove(Long.valueOf(this.shoppingId))).longValue();
/*  97 */       Roleshoppinginfo.remove(Long.valueOf(this.shoppingId));
/*  98 */       BaiTanManager.removeSCPI(itemid, price, channelid, this.shoppingId);
/*  99 */       roleGrid.getNeedrecycleshoppingids().remove(Long.valueOf(this.shoppingId));
/*     */     }
/*     */     
/* 102 */     SGetMoneyRes res = new SGetMoneyRes();
/* 103 */     res.shoppingid = this.shoppingId;
/* 104 */     res.money = ((int)getMoney);
/* 105 */     OnlineManager.getInstance().send(this.roleId, res);
/* 106 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\PGetMoneyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */