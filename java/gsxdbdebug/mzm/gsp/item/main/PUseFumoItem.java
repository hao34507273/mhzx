/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.item.SResUseFumoItem;
/*     */ import mzm.gsp.item.confbean.SItemDrugOutFightCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PUseFumoItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private Long uuid;
/*     */   private Integer itemId;
/*     */   
/*     */   public PUseFumoItem(long roleid, Integer itemId)
/*     */   {
/*  28 */     this.roleid = roleid;
/*  29 */     this.itemId = itemId;
/*  30 */     this.uuid = null;
/*     */   }
/*     */   
/*     */   public PUseFumoItem(long roleid, Long uuid)
/*     */   {
/*  35 */     this.roleid = roleid;
/*  36 */     this.uuid = uuid;
/*  37 */     this.itemId = null;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if (!ItemModuleSwitchInterface.isUseFumoItemSwitchOpenForRole(this.roleid))
/*     */     {
/*  46 */       return false;
/*     */     }
/*  48 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  50 */       String logStr = String.format("[item]PUseFumoItem.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  51 */       ItemManager.logger.info(logStr);
/*  52 */       return false;
/*     */     }
/*  54 */     if (this.itemId == null)
/*     */     {
/*  56 */       BasicItem item = ItemInterface.getItemByUuid(this.roleid, this.uuid.longValue());
/*  57 */       if (item == null)
/*     */       {
/*  59 */         return false;
/*     */       }
/*  61 */       this.itemId = Integer.valueOf(item.getCfgId());
/*     */     }
/*  63 */     SItemDrugOutFightCfg fumoItem = SItemDrugOutFightCfg.get(this.itemId.intValue());
/*  64 */     if (fumoItem == null)
/*     */     {
/*     */ 
/*  67 */       return false;
/*     */     }
/*  69 */     BasicItem basicItem = ItemInterface.getItem(this.roleid, 340600001, fumoItem.wearPos, true);
/*  70 */     if ((basicItem == null) || (!(basicItem instanceof EquipmentItem)))
/*     */     {
/*  72 */       return false;
/*     */     }
/*  74 */     EquipmentItem equipmentItem = (EquipmentItem)basicItem;
/*  75 */     if (!equipmentItem.isUsePointNormal())
/*     */     {
/*  77 */       ItemManager.sendWrongInfo(this.roleid, 614, new String[0]);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     int randomAttriAValue = Xdb.random().nextInt(10000);
/*  82 */     int value = (int)((fumoItem.maxProNum - fumoItem.minProNum) * randomAttriAValue * 1.0F / 10000.0F + fumoItem.minProNum);
/*     */     
/*  84 */     TLogArg logArg = new TLogArg(LogReason.ITEM_USE_FUMO_REM);
/*  85 */     if (this.uuid != null)
/*     */     {
/*  87 */       boolean ret = ItemInterface.removeItemByUuid(this.roleid, this.uuid.longValue(), 1, logArg);
/*  88 */       if (!ret)
/*     */       {
/*  90 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  94 */     long timeout = DateTimeUtils.getCurrTimeInMillis() / 1000L + fumoItem.bufftime;
/*  95 */     equipmentItem.setFumoValue(fumoItem.extraProperty, value, timeout);
/*     */     
/*  97 */     SResUseFumoItem res = new SResUseFumoItem();
/*     */     
/*  99 */     res.equipfumoinfo.addvalue = value;
/* 100 */     res.equipfumoinfo.propertytype = fumoItem.extraProperty;
/* 101 */     res.equipfumoinfo.bagid = 340600001;
/* 102 */     res.equipfumoinfo.expirationtime = timeout;
/* 103 */     res.equipfumoinfo.uuid = ((Long)equipmentItem.getUuid().iterator().next()).longValue();
/* 104 */     res.equipfumoinfo.itemid = equipmentItem.getCfgId();
/* 105 */     OnlineManager.getInstance().send(this.roleid, res);
/*     */     
/* 107 */     new FumoItemObserver(fumoItem.bufftime, this.roleid, ((Long)equipmentItem.getUuid().iterator().next()).longValue(), fumoItem.extraProperty);
/*     */     
/* 109 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PUseFumoItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */