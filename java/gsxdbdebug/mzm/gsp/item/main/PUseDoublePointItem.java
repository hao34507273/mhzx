/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import mzm.gsp.guaji.confbean.DoublePointOfferCfgConsts;
/*     */ import mzm.gsp.guaji.main.GuajiInterface;
/*     */ import mzm.gsp.item.SResUseDoublePoint;
/*     */ import mzm.gsp.item.confbean.SDoublePointItem;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PUseDoublePointItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long uuid;
/*     */   
/*     */   public PUseDoublePointItem(long roleid, long uuid)
/*     */   {
/*  27 */     this.roleid = roleid;
/*  28 */     this.uuid = uuid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (!ItemModuleSwitchInterface.isUseDoubleItemSwitchOpenForRole(this.roleid))
/*     */     {
/*  36 */       return false;
/*     */     }
/*  38 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  40 */       String logStr = String.format("[item]PUseDoublePointItem.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  42 */       ItemManager.logger.info(logStr);
/*  43 */       return false;
/*     */     }
/*  45 */     int usecount = GuajiInterface.getItemUseCount(this.roleid);
/*  46 */     SResUseDoublePoint resUseDoublePoint = new SResUseDoublePoint();
/*  47 */     if (usecount >= DoublePointOfferCfgConsts.getInstance().ITEM_MAX_USE_COUNT)
/*     */     {
/*  49 */       ItemManager.sendWrongInfo(this.roleid, 800, new String[0]);
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     BasicItem item = ItemInterface.getItemByUuid(this.roleid, this.uuid);
/*  54 */     if (item == null)
/*     */     {
/*  56 */       return false;
/*     */     }
/*  58 */     SDoublePointItem doublePointItem = SDoublePointItem.get(item.getCfgId());
/*  59 */     if (doublePointItem == null)
/*     */     {
/*  61 */       ItemManager.sendWrongInfo(this.roleid, 101, new String[0]);
/*  62 */       return false;
/*     */     }
/*  64 */     int todayusecount = ItemInterface.getItemUseCount(this.roleid, item.getCfgId());
/*  65 */     if (todayusecount >= doublePointItem.maxUseCount)
/*     */     {
/*  67 */       ItemInterface.sendWrongInfo(this.roleid, 103, new String[] { String.valueOf(item.getCfgId()), String.valueOf(doublePointItem.maxUseCount) });
/*     */       
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     int gettingpoolnum = GuajiInterface.getGetingpoolDoublePoint(this.roleid);
/*  73 */     if (gettingpoolnum >= DoublePointOfferCfgConsts.getInstance().REST_POINT_MAX_NUM)
/*     */     {
/*  75 */       ItemManager.sendWrongInfo(this.roleid, 801, new String[0]);
/*  76 */       return false;
/*     */     }
/*  78 */     boolean ret = GuajiInterface.addItemUseCount(this.roleid);
/*  79 */     boolean ret2 = ItemInterface.addItemUseCount(this.roleid, item.getCfgId(), 1);
/*  80 */     if ((!ret2) || (!ret))
/*     */     {
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     int addPointNum = doublePointItem.addPointNum;
/*     */     
/*  87 */     if (addPointNum + gettingpoolnum > DoublePointOfferCfgConsts.getInstance().REST_POINT_MAX_NUM)
/*     */     {
/*  89 */       addPointNum = DoublePointOfferCfgConsts.getInstance().REST_POINT_MAX_NUM - gettingpoolnum;
/*     */     }
/*  91 */     TLogArg logArg = new TLogArg(LogReason.ITEM_USE_DOUBLE_POINT_REM, item.getCfgId());
/*  92 */     ret = GuajiInterface.addGetingpoolDoublePoint(this.roleid, addPointNum, logArg);
/*  93 */     if (!ret)
/*     */     {
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     boolean r = ItemInterface.removeItemByUuid(this.roleid, this.uuid, 1, logArg);
/*  99 */     if (!r)
/*     */     {
/* 101 */       ItemManager.sendWrongInfo(this.roleid, 102, new String[0]);
/* 102 */       return false;
/*     */     }
/* 104 */     resUseDoublePoint.itemid = item.getCfgId();
/* 105 */     resUseDoublePoint.result = addPointNum;
/* 106 */     resUseDoublePoint.canusecount = (DoublePointOfferCfgConsts.getInstance().ITEM_MAX_USE_COUNT - GuajiInterface.getItemUseCount(this.roleid));
/*     */     
/* 108 */     resUseDoublePoint.daycanusecount = (doublePointItem.maxUseCount - (todayusecount + 1));
/* 109 */     OnlineManager.getInstance().send(this.roleid, resUseDoublePoint);
/* 110 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PUseDoublePointItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */