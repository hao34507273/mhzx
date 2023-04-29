/*     */ package mzm.gsp.mall.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.mall.SBuyItemRes;
/*     */ import mzm.gsp.mall.SItemNumChangeInfo;
/*     */ import mzm.gsp.mall.event.BuyItem;
/*     */ import mzm.gsp.mall.event.BuyItemArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PBuyCurrentLimitItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private int malltype;
/*     */   private int itemid;
/*     */   private int count;
/*     */   private long clientyuanbao;
/*     */   
/*     */   public PBuyCurrentLimitItem(long roleid, int malltype, int itemid, int count, long clientyuanbao)
/*     */   {
/*  40 */     this.roleid = roleid;
/*  41 */     this.malltype = malltype;
/*  42 */     this.itemid = itemid;
/*  43 */     this.count = count;
/*  44 */     this.clientyuanbao = clientyuanbao;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  51 */     if (!MallManager.CURRENT_LIMIT_SHOP.containsKey(Integer.valueOf(this.malltype)))
/*     */     {
/*  53 */       String logstr = String.format("[mall]PBuyCurrentLimitItem.processImp@param error|roleid=%d|malltype=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.malltype) });
/*     */       
/*  55 */       MallManager.logger.info(logstr);
/*  56 */       return false;
/*     */     }
/*  58 */     if ((this.itemid <= 0) || (this.count <= 0))
/*     */     {
/*  60 */       String logstr = String.format("[mall]PBuyCurrentLimitItem.processImp@param error|roleid=%d|itemid=%d|count=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(this.count) });
/*     */       
/*  62 */       MallManager.logger.info(logstr);
/*  63 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  68 */     if (!MallManager.isRoleStateCanOperateMall(this.roleid))
/*     */     {
/*  70 */       String logStr = String.format("[mall]PBuyCurrentLimitItem.processImp@role state can not operate mall|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  72 */       MallManager.logger.info(logStr);
/*  73 */       return false;
/*     */     }
/*  75 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.MALL.value, this.itemid))
/*     */     {
/*  77 */       ItemBanTrade.getInstance().sendTipToTole(this.roleid, ItemInterface.getItemName(this.itemid));
/*  78 */       return false;
/*     */     }
/*  80 */     if (!MallManager.isCurrentLimitMallSwitchOpenForRole(this.roleid, this.malltype))
/*     */     {
/*  82 */       String logStr = String.format("[mall]PBuyCurrentLimitItem.processImp@switch not opened|roleid=%d|malltype=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.malltype) });
/*     */       
/*  84 */       MallManager.logger.info(logStr);
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     int price = MallManager.getLimitItemPrice(this.malltype, this.itemid);
/*  89 */     if (price == -1)
/*     */     {
/*  91 */       String logstr = String.format("[mall]PBuyCurrentLimitItem.processImp@item price error|roleid=%d|itemid=%d|price=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(price) });
/*     */       
/*     */ 
/*  94 */       MallManager.logger.error(logstr);
/*  95 */       MallManager.sendWrongInfo(this.roleid, 3, new String[0]);
/*  96 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 102 */     String userid = RoleInterface.getUserId(this.roleid);
/* 103 */     long yuanbaoBalance = QingfuInterface.getBalance(userid, true);
/* 104 */     if (this.clientyuanbao != yuanbaoBalance)
/*     */     {
/*     */ 
/* 107 */       String logstr = String.format("[mall]PBuyCurrentLimitItem.processImp@client yuanbao is not same as server|userid=%s|roleid=%d|itemid=%d|price=%d|clientyuanbao=%d|serveryuanbao=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(price), Long.valueOf(this.clientyuanbao), Long.valueOf(yuanbaoBalance) });
/*     */       
/*     */ 
/* 110 */       MallManager.logger.info(logstr);
/* 111 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 118 */     MallManager.checkAndResetCurrentLimitMall(this.roleid, this.malltype);
/*     */     
/* 120 */     int maxBuycount = MallManager.getLimitItemMaxBuyNum(this.malltype, this.itemid);
/* 121 */     int hasbuycount = MallManager.getCurrentLimitMallItemBuyCount(this.roleid, this.malltype, this.itemid);
/* 122 */     if ((maxBuycount != -1) && (this.count + hasbuycount > maxBuycount))
/*     */     {
/*     */ 
/* 125 */       String logstr = String.format("[mall]PBuyCurrentLimitItem.processImp@buy count error|userid=%s|roleid=%d|itemid=%d|price=%d|buycount=%d|maxbuycount=%d|hasbuycount=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(price), Integer.valueOf(this.count), Integer.valueOf(maxBuycount), Integer.valueOf(hasbuycount) });
/*     */       
/*     */ 
/* 128 */       MallManager.logger.info(logstr);
/*     */       
/* 130 */       MallManager.sendWrongInfo(this.roleid, 4, new String[0]);
/* 131 */       return false;
/*     */     }
/*     */     
/* 134 */     int yuanbaonum = price * this.count;
/*     */     
/* 136 */     if ((yuanbaonum <= 0) || (yuanbaonum > yuanbaoBalance))
/*     */     {
/*     */ 
/* 139 */       String logstr = String.format("[mall]PBuyCurrentLimitItem.processImp@yuanbao not enough|userid=%s|roleid=%d|itemid=%d|count=%d|price=%d|needyuanbao=%d|hasyuanbao=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(this.count), Integer.valueOf(price), Integer.valueOf(yuanbaonum), Long.valueOf(yuanbaoBalance) });
/*     */       
/*     */ 
/* 142 */       MallManager.logger.error(logstr);
/*     */       
/* 144 */       MallManager.sendWrongInfo(this.roleid, 1, new String[0]);
/* 145 */       return false;
/*     */     }
/*     */     
/* 148 */     List<Item> xItems = ItemInterface.createXItem(this.itemid, this.count, null, false);
/*     */     
/* 150 */     TLogArg logArg = new TLogArg(((CurrentLimitShopRelation)MallManager.CURRENT_LIMIT_SHOP.get(Integer.valueOf(this.malltype))).logReason, this.itemid);
/* 151 */     logArg.addItem2num(this.itemid, this.count);
/* 152 */     MallManager.fillCurrencyData(userid, this.roleid, logArg, yuanbaonum);
/* 153 */     ItemOperateResult result = ItemInterface.addItem(this.roleid, xItems, true, logArg);
/* 154 */     if (result.isBagFull())
/*     */     {
/* 156 */       ItemInterface.sendSpecificBagGridNotEnough(this.roleid, result.getFullBagId());
/* 157 */       return false;
/*     */     }
/* 159 */     int addcount = result.getItemChangeNum(this.itemid);
/* 160 */     if ((!result.success()) || (addcount <= 0) || (addcount != this.count))
/*     */     {
/* 162 */       String logstr = String.format("[mall]PBuyCurrentLimitItem.processImp@buy item failed,bagfull or item to carry max|userid=%s|roleid=%d|itemid=%d|price=%d|needyuanbao=%d|num=%d|addnum=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(price), Integer.valueOf(yuanbaonum), Integer.valueOf(this.count), Integer.valueOf(addcount) });
/*     */       
/*     */ 
/* 165 */       MallManager.logger.error(logstr);
/* 166 */       return false;
/*     */     }
/*     */     
/* 169 */     boolean ret = QingfuInterface.costYuanbao(userid, this.roleid, yuanbaonum, ((CurrentLimitShopRelation)MallManager.CURRENT_LIMIT_SHOP.get(Integer.valueOf(this.malltype))).costType, logArg) == CostResult.Success;
/*     */     
/* 171 */     if (!ret)
/*     */     {
/* 173 */       MallManager.sendWrongInfo(this.roleid, 1, new String[0]);
/* 174 */       return false;
/*     */     }
/*     */     
/* 177 */     ret = MallManager.addCurrentLimitMallItemBuyCount(this.roleid, this.malltype, this.itemid, addcount);
/* 178 */     if (!ret)
/*     */     {
/* 180 */       return false;
/*     */     }
/*     */     
/* 183 */     SItemNumChangeInfo ch = new SItemNumChangeInfo();
/* 184 */     ch.malltype = this.malltype;
/* 185 */     ch.itemid = this.itemid;
/* 186 */     ch.count = (maxBuycount - MallManager.getCurrentLimitMallItemBuyCount(this.roleid, this.malltype, this.itemid));
/* 187 */     OnlineManager.getInstance().send(this.roleid, ch);
/*     */     
/* 189 */     SBuyItemRes buyItemRes = new SBuyItemRes();
/* 190 */     buyItemRes.malltype = this.malltype;
/* 191 */     buyItemRes.buynum = addcount;
/* 192 */     buyItemRes.itemid = this.itemid;
/* 193 */     OnlineManager.getInstance().send(this.roleid, buyItemRes);
/*     */     
/* 195 */     if (result.success())
/*     */     {
/* 197 */       String logstr = String.format("[mall]PBuyCurrentLimitItem.processImp@buy item success|userid=%s|roleid=%d|itemid=%d|price=%d|needyuanbao=%d|num=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(price), Integer.valueOf(yuanbaonum), Integer.valueOf(this.count) });
/*     */       
/*     */ 
/* 200 */       MallManager.logger.info(logstr);
/*     */     }
/* 202 */     TriggerEventsManger.getInstance().triggerEvent(new BuyItem(), new BuyItemArg(this.roleid, this.itemid, addcount, price, this.malltype));
/*     */     
/* 204 */     return result.success();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\main\PBuyCurrentLimitItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */