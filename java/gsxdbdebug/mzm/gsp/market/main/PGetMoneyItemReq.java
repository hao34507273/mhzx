/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.role.main.ModMoneyResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleModuleManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xbean.MarketItem;
/*     */ import xbean.RoleMarketInfo;
/*     */ import xtable.Role2marketinfo;
/*     */ 
/*     */ public class PGetMoneyItemReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private long marketid;
/*     */   
/*     */   public PGetMoneyItemReq(long roleId, long marketid)
/*     */   {
/*  23 */     this.roleId = roleId;
/*  24 */     this.marketid = marketid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception {
/*  28 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId)) {
/*  29 */       String logStr = String.format("[market]PGetMoneyItemReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  30 */       MarketManager.logger.info(logStr);
/*  31 */       return false; }
/*  32 */     if (!MarketManager.isMarketSwitchOpenForRole(this.roleId)) {
/*  33 */       return false;
/*     */     }
/*  35 */     RoleMarketInfo xRoleMarketInfo = Role2marketinfo.get(Long.valueOf(this.roleId));
/*  36 */     if (xRoleMarketInfo == null)
/*  37 */       return false;
/*  38 */     if (!xRoleMarketInfo.getOnshelf_item_ids().contains(Long.valueOf(this.marketid))) {
/*  39 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  46 */     if (xRoleMarketInfo.getMarketid2timeoutorselleditem().containsKey(Long.valueOf(this.marketid))) {
/*  47 */       MarketItem xMarketItem = (MarketItem)xRoleMarketInfo.getMarketid2timeoutorselleditem().get(Long.valueOf(this.marketid));
/*  48 */       int num = xMarketItem.getItem().getNumber() - xMarketItem.getRest_num();
/*  49 */       if (num <= 0)
/*  50 */         return false;
/*  51 */       if (!MarketManager.hasState(xMarketItem.getState(), 4)) {
/*  52 */         return false;
/*     */       }
/*  54 */       int afterTax = MarketManager.computeGoldAfterCutTax(xMarketItem.getPrice());
/*  55 */       int getMoney = num * afterTax;
/*  56 */       if (!RoleModuleManager.addGoldIngotInAll(this.roleId, getMoney, new TLogArg(LogReason.MARKET_SELL, xMarketItem.getItem().getCfgid()), true).isSucceed()) {
/*  57 */         String logStr = String.format("[market]PGetMoneyItemReq.processImp@add gold error|roleid=%d|gold=%d|hasgold=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(getMoney), Long.valueOf(RoleInterface.getGold(this.roleId)) });
/*  58 */         MarketManager.logger.info(logStr);
/*  59 */         MarketManager.sendCommonError(this.roleId, 11);
/*  60 */         return false;
/*     */       }
/*  62 */       MarketManager.sendSGetMoneyItemRes(this.roleId, this.marketid, xMarketItem.getItem().getCfgid(), getMoney);
/*  63 */       xMarketItem.setState(xMarketItem.getState() & 0xFFFFFFFB);
/*  64 */       String logStr = String.format("[market]PGetMoneyItemReq.processImp@add gold success|roleid=%d|gold=%d|marketId=%d|itemId=%d|num=%d|price=%d|total_num=%d|rest_num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(getMoney), Long.valueOf(this.marketid), Integer.valueOf(xMarketItem.getItem().getCfgid()), Integer.valueOf(num), Integer.valueOf(xMarketItem.getPrice()), Integer.valueOf(xMarketItem.getItem().getNumber()), Integer.valueOf(xMarketItem.getRest_num()) });
/*  65 */       MarketManager.logger.info(logStr);
/*  66 */       if (xMarketItem.getRest_num() > 0) {
/*  67 */         xMarketItem.getItem().setNumber(xMarketItem.getRest_num());
/*     */       } else {
/*  69 */         xRoleMarketInfo.getOnshelf_item_ids().remove(Long.valueOf(this.marketid));
/*  70 */         xRoleMarketInfo.getMarketid2timeoutorselleditem().remove(Long.valueOf(this.marketid));
/*     */       }
/*     */       
/*  73 */       return true;
/*     */     }
/*     */     
/*     */ 
/*  77 */     MarketItem xMarketItem = xtable.Marketitem.get(Long.valueOf(this.marketid));
/*  78 */     if (xMarketItem == null)
/*  79 */       return false;
/*  80 */     if (!MarketManager.hasState(xMarketItem.getState(), 4))
/*  81 */       return false;
/*  82 */     if (xMarketItem.getRoleid() != this.roleId) {
/*  83 */       return false;
/*     */     }
/*  85 */     int num = xMarketItem.getItem().getNumber() - xMarketItem.getRest_num();
/*  86 */     if (num <= 0) {
/*  87 */       return false;
/*     */     }
/*  89 */     int afterTax = MarketManager.computeGoldAfterCutTax(xMarketItem.getPrice());
/*  90 */     int getMoney = num * afterTax;
/*  91 */     if (!RoleModuleManager.addGoldIngotInAll(this.roleId, getMoney, new TLogArg(LogReason.MARKET_SELL, xMarketItem.getItem().getCfgid()), true).isSucceed()) {
/*  92 */       String logStr = String.format("[market]PGetMoneyItemReq.processImp@add gold error|roleid=%d|gold=%d|hasgold=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(getMoney), Long.valueOf(RoleInterface.getGold(this.roleId)) });
/*  93 */       MarketManager.logger.info(logStr);
/*  94 */       MarketManager.sendCommonError(this.roleId, 11);
/*  95 */       return false;
/*     */     }
/*  97 */     if (num == xMarketItem.getItem().getNumber()) {
/*  98 */       xRoleMarketInfo.getOnshelf_item_ids().remove(Long.valueOf(this.marketid));
/*     */     } else {
/* 100 */       xMarketItem.getItem().setNumber(xMarketItem.getRest_num());
/* 101 */       xMarketItem.setState(xMarketItem.getState() & 0xFFFFFFFB);
/*     */     }
/*     */     
/* 104 */     MarketManager.sendSGetMoneyItemRes(this.roleId, this.marketid, xMarketItem.getItem().getCfgid(), getMoney);
/* 105 */     String logStr = String.format("[market]PGetMoneyItemReq.processImp@add gold success|roleid=%d|gold=%d|marketId=%d|itemId=%d|num=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(getMoney), Long.valueOf(this.marketid), Integer.valueOf(xMarketItem.getItem().getCfgid()), Integer.valueOf(num), Integer.valueOf(xMarketItem.getPrice()) });
/* 106 */     MarketManager.logger.info(logStr);
/* 107 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PGetMoneyItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */