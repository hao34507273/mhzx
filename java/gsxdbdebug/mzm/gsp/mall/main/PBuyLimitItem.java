/*     */ package mzm.gsp.mall.main;
/*     */ 
/*     */ import java.util.List;
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
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
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
/*     */ 
/*     */ public class PBuyLimitItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private int itemid;
/*     */   private int count;
/*     */   private long clientyuanbao;
/*     */   
/*     */   public PBuyLimitItem(long roleid, int itemid, int count, long clientyuanbao)
/*     */   {
/*  41 */     this.roleid = roleid;
/*  42 */     this.itemid = itemid;
/*  43 */     this.count = count;
/*  44 */     this.clientyuanbao = clientyuanbao;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  51 */     if ((this.itemid <= 0) || (this.count <= 0))
/*     */     {
/*  53 */       String logstr = String.format("[mall]PBuyLimitItem.processImp@param error|roleid=%d|itemid=%d|count=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(this.count) });
/*     */       
/*  55 */       MallManager.logger.info(logstr);
/*  56 */       return false;
/*     */     }
/*  58 */     if (!MallManager.isRoleStateCanOperateMall(this.roleid))
/*     */     {
/*  60 */       String logStr = String.format("[mall]PBuyLimitItem.processImp@role state can not operate mall|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  61 */       MallManager.logger.info(logStr);
/*  62 */       return false;
/*     */     }
/*  64 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.MALL.value, this.itemid))
/*     */     {
/*  66 */       ItemBanTrade.getInstance().sendTipToTole(this.roleid, ItemInterface.getItemName(this.itemid));
/*  67 */       return false;
/*     */     }
/*  69 */     if (!MallManager.isMallSwitchOpenForRole(this.roleid))
/*     */     {
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     int price = MallManager.getLimitItemPrice(2, this.itemid);
/*  75 */     if (price == -1)
/*     */     {
/*  77 */       String logstr = String.format("[mall]PBuyLimitItem.processImp@item price error|roleid=%d|itemid=%d|price=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(price) });
/*     */       
/*  79 */       MallManager.logger.error(logstr);
/*  80 */       MallManager.sendWrongInfo(this.roleid, 3, new String[0]);
/*  81 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  85 */     String userid = RoleInterface.getUserId(this.roleid);
/*  86 */     long yuanbaoBalance = QingfuInterface.getBalance(userid, true);
/*  87 */     if (this.clientyuanbao != yuanbaoBalance)
/*     */     {
/*     */ 
/*  90 */       String logstr = String.format("[mall]PBuyLimitItem.processImp@client yuanbao is not same as server|userid=%s|roleid=%d|itemid=%d|price=%d|clientyuanbao=%d|serveryuanbao=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(price), Long.valueOf(this.clientyuanbao), Long.valueOf(yuanbaoBalance) });
/*     */       
/*     */ 
/*  93 */       MallManager.logger.info(logstr);
/*  94 */       return false;
/*     */     }
/*  96 */     int maxBuycount = MallManager.getLimitItemMaxBuyNum(2, this.itemid);
/*  97 */     int hasbuycount = MallManager.getItemBuyCount(this.roleid, this.itemid);
/*  98 */     if ((maxBuycount != -1) && (this.count + hasbuycount > maxBuycount))
/*     */     {
/*     */ 
/* 101 */       String logstr = String.format("[mall]PBuyLimitItem.processImp@buy count error|userid=%s|roleid=%d|itemid=%d|price=%d|buycount=%d|maxbuycount=%d|hasbuycount=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(price), Integer.valueOf(this.count), Integer.valueOf(maxBuycount), Integer.valueOf(hasbuycount) });
/*     */       
/*     */ 
/* 104 */       MallManager.logger.info(logstr);
/*     */       
/* 106 */       MallManager.sendWrongInfo(this.roleid, 4, new String[0]);
/* 107 */       return false;
/*     */     }
/*     */     
/* 110 */     int yuanbaonum = price * this.count;
/*     */     
/* 112 */     if (yuanbaonum > yuanbaoBalance)
/*     */     {
/*     */ 
/* 115 */       String logstr = String.format("[mall]PBuyLimitItem.processImp@yuanbao not enough|userid=%s|roleid=%d|itemid=%d|count=%d|price=%d|needyuanbao=%d|hasyuanbao=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(this.count), Integer.valueOf(price), Integer.valueOf(yuanbaonum), Long.valueOf(yuanbaoBalance) });
/*     */       
/*     */ 
/* 118 */       MallManager.logger.error(logstr);
/*     */       
/* 120 */       MallManager.sendWrongInfo(this.roleid, 1, new String[0]);
/* 121 */       return false;
/*     */     }
/*     */     
/* 124 */     List<Item> xItems = ItemInterface.createXItem(this.itemid, this.count, null, false);
/*     */     
/* 126 */     TLogArg logArg = new TLogArg(LogReason.LIMIT_MALL, this.itemid);
/* 127 */     logArg.addItem2num(this.itemid, this.count);
/* 128 */     MallManager.fillCurrencyData(userid, this.roleid, logArg, yuanbaonum);
/* 129 */     ItemOperateResult result = ItemInterface.addItem(this.roleid, xItems, true, logArg);
/* 130 */     if (result.isBagFull())
/*     */     {
/* 132 */       ItemInterface.sendSpecificBagGridNotEnough(this.roleid, result.getFullBagId());
/* 133 */       return false;
/*     */     }
/* 135 */     int addcount = result.getItemChangeNum(this.itemid);
/* 136 */     if ((!result.success()) || (addcount <= 0) || (addcount != this.count))
/*     */     {
/* 138 */       String logstr = String.format("[mall]PBuyLimitItem.processImp@buy item failed,bagfull or item to carry max|userid=%s|roleid=%d|itemid=%d|price=%d|needyuanbao=%d|num=%d|addnum=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(price), Integer.valueOf(yuanbaonum), Integer.valueOf(this.count), Integer.valueOf(addcount) });
/*     */       
/*     */ 
/* 141 */       MallManager.logger.error(logstr);
/* 142 */       return false;
/*     */     }
/*     */     
/* 145 */     boolean ret = QingfuInterface.costYuanbao(userid, this.roleid, yuanbaonum, CostType.COST_BIND_FIRST_MALL_BUY_LIMIT_ITEM, logArg) == CostResult.Success;
/*     */     
/* 147 */     if (!ret)
/*     */     {
/* 149 */       MallManager.sendWrongInfo(this.roleid, 1, new String[0]);
/* 150 */       return false;
/*     */     }
/*     */     
/* 153 */     ret = MallManager.addItemBuyCount(this.roleid, this.itemid, addcount);
/* 154 */     if (!ret)
/*     */     {
/* 156 */       return false;
/*     */     }
/*     */     
/* 159 */     SItemNumChangeInfo ch = new SItemNumChangeInfo();
/* 160 */     ch.malltype = 2;
/* 161 */     ch.itemid = this.itemid;
/* 162 */     ch.count = (maxBuycount - MallManager.getItemBuyCount(this.roleid, this.itemid));
/* 163 */     OnlineManager.getInstance().send(this.roleid, ch);
/*     */     
/* 165 */     SBuyItemRes buyItemRes = new SBuyItemRes();
/* 166 */     buyItemRes.malltype = 2;
/* 167 */     buyItemRes.buynum = addcount;
/* 168 */     buyItemRes.itemid = this.itemid;
/* 169 */     OnlineManager.getInstance().send(this.roleid, buyItemRes);
/*     */     
/* 171 */     if (result.success())
/*     */     {
/* 173 */       String logstr = String.format("[mall]PBuyLimitItem.processImp@buy item success|userid=%s|roleid=%d|itemid=%d|price=%d|needyuanbao=%d|num=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(price), Integer.valueOf(yuanbaonum), Integer.valueOf(this.count) });
/*     */       
/*     */ 
/* 176 */       MallManager.logger.info(logstr);
/*     */     }
/* 178 */     TriggerEventsManger.getInstance().triggerEvent(new BuyItem(), new BuyItemArg(this.roleid, this.itemid, addcount, price, 2));
/*     */     
/* 180 */     return result.success();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\main\PBuyLimitItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */