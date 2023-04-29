/*     */ package mzm.gsp.mall.main;
/*     */ 
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.mall.SExchangeItemRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TlogUtil;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PExchangeItemUseJifen
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private int jifenType;
/*     */   private int itemid;
/*     */   private int count;
/*     */   
/*     */   public PExchangeItemUseJifen(long roleid, int itemid, int count, int jifenType)
/*     */   {
/*  30 */     this.roleid = roleid;
/*  31 */     this.itemid = itemid;
/*  32 */     this.count = count;
/*  33 */     this.jifenType = jifenType;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if ((this.itemid <= 0) || (this.count <= 0))
/*     */     {
/*  42 */       String logstr = String.format("[mall]PExchangeItemUseJifen.processImp@num exceed pixnum|roleid=%d|itemid=%d|count=%d|jifenType=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(this.count), Integer.valueOf(this.jifenType) });
/*     */       
/*     */ 
/*  45 */       MallManager.logger.info(logstr);
/*  46 */       return false;
/*     */     }
/*  48 */     if (!MallManager.isRoleStateCanOperateMall(this.roleid))
/*     */     {
/*  50 */       String logStr = String.format("[mall]PExchangeItemUseJifen.processImp@role state can not operate mall|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  52 */       MallManager.logger.info(logStr);
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     int pixNum = ItemInterface.getPileMaxCount(this.itemid);
/*  57 */     if (pixNum <= 0)
/*     */     {
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     if (this.count > pixNum)
/*     */     {
/*  64 */       String logstr = String.format("[mall]PExchangeItemUseJifen.processImp@num exceed pixnum|roleid=%d|itemid=%d|count=%d|pixnum=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(this.count), Integer.valueOf(pixNum) });
/*     */       
/*     */ 
/*  67 */       MallManager.logger.info(logstr);
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.JIFEN_EXCHANGE.value, this.itemid))
/*     */     {
/*  73 */       ItemBanTrade.getInstance().sendTipToTole(this.roleid, ItemInterface.getItemName(this.itemid));
/*  74 */       return false;
/*     */     }
/*  76 */     if (!MallManager.isJifenExchangeSwitchOpenForRole(this.roleid))
/*     */     {
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     int price = MallManager.getJifenItemPrice(this.jifenType, this.itemid);
/*  82 */     if (price == -1)
/*     */     {
/*  84 */       String logstr = String.format("[mall]PExchangeItemUseJifen.processImp@item price error|roleid=%d|itemid=%d|price=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(price) });
/*     */       
/*     */ 
/*  87 */       MallManager.logger.error(logstr);
/*     */       
/*  89 */       MallManager.sendWrongInfo(this.roleid, 3, new String[0]);
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     long jifennum = price * this.count;
/*  94 */     if (jifennum <= 0L)
/*     */     {
/*  96 */       return false;
/*     */     }
/*  98 */     TLogArg logArg = new TLogArg(LogReason.TOKEN_EXCHANGE_REM, this.itemid);
/*  99 */     logArg.addItem2num(this.itemid, this.count);
/* 100 */     logArg.addCurrencytype2num(TlogUtil.getCurrencyTypeByTokentype(this.jifenType), Integer.valueOf(-price * this.count));
/* 101 */     boolean ret = MallInterface.cutJifen(this.roleid, jifennum, this.jifenType, logArg).isSuccess();
/* 102 */     if (!ret)
/*     */     {
/* 104 */       String logstr = String.format("[mall]PExchangeItemUseJifen.processImp@jifen not enough|roleid=%d|itemid=%d|count=%d|price=%d|needjifen=%d|hasjifen=%d|jifentype=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(this.count), Integer.valueOf(price), Long.valueOf(jifennum), Long.valueOf(MallManager.getJifen(this.roleid, this.jifenType)), Integer.valueOf(this.jifenType) });
/*     */       
/*     */ 
/* 107 */       MallManager.logger.error(logstr);
/*     */       
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     ItemOperateResult result = ItemInterface.addItemActive(this.roleid, this.itemid, this.count, false, false, logArg);
/* 113 */     if (result.isBagFull())
/*     */     {
/* 115 */       ItemInterface.sendSpecificBagFull(this.roleid, result.getFullBagId());
/* 116 */       return false;
/*     */     }
/* 118 */     SExchangeItemRes res = new SExchangeItemRes();
/* 119 */     res.jifentype = this.jifenType;
/* 120 */     res.itemid = this.itemid;
/* 121 */     res.num = this.count;
/* 122 */     OnlineManager.getInstance().send(this.roleid, res);
/*     */     
/* 124 */     if (result.success())
/*     */     {
/* 126 */       String logstr = String.format("[mall]PExchangeItemUseJifen.processImp@exchange item success|roleid=%d|itemid=%d|price=%d|needjifen=%d|num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(price), Long.valueOf(jifennum), Integer.valueOf(this.count) });
/*     */       
/*     */ 
/* 129 */       MallManager.logger.info(logstr);
/*     */     }
/* 131 */     return result.success();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\main\PExchangeItemUseJifen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */