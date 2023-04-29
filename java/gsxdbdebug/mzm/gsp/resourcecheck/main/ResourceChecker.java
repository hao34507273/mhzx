/*     */ package mzm.gsp.resourcecheck.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.resourcecheck.confbean.STypeId2Logreasons;
/*     */ import mzm.gsp.resourcecheck.confbean.SWatchItemCfg;
/*     */ import mzm.gsp.resourcecheck.confbean.SWatchTypeCfg;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Reason2Resource;
/*     */ import xbean.ResourceId2Num;
/*     */ import xtable.Role2resource;
/*     */ 
/*     */ public class ResourceChecker
/*     */ {
/*  17 */   private static final Logger logger = Logger.getLogger("resourcecheck");
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static ResourceId2Num getItemId2NumXBean(long roleId, int logReason, long now)
/*     */   {
/*  26 */     Reason2Resource xReason2Resource = Role2resource.get(Long.valueOf(roleId));
/*  27 */     if (xReason2Resource == null)
/*     */     {
/*  29 */       xReason2Resource = xbean.Pod.newReason2Resource();
/*  30 */       Role2resource.insert(Long.valueOf(roleId), xReason2Resource);
/*     */     }
/*  32 */     if (mzm.gsp.util.DateTimeUtils.needDailyReset(xReason2Resource.getItemupdatetime(), now, 0))
/*     */     {
/*  34 */       xReason2Resource.setItemupdatetime(now);
/*  35 */       xReason2Resource.getReason2item().clear();
/*     */     }
/*  37 */     ResourceId2Num xResourceId2Num = (ResourceId2Num)xReason2Resource.getReason2item().get(Integer.valueOf(logReason));
/*     */     
/*  39 */     if (xResourceId2Num == null)
/*     */     {
/*  41 */       xResourceId2Num = xbean.Pod.newResourceId2Num();
/*  42 */       xReason2Resource.getReason2item().put(Integer.valueOf(logReason), xResourceId2Num);
/*     */     }
/*     */     
/*  45 */     return xResourceId2Num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean addItemNumAndTriggerWarn(long roleId, LogReason logReason, int itemId, int addNum)
/*     */   {
/*  60 */     int maxWarnNum = getMaxItemWarnNum(logReason.value, itemId);
/*  61 */     if (maxWarnNum <= 0)
/*     */     {
/*  63 */       String logStr = String.format("[resourcecheck]ResourceChecker.addItemNumAndTriggerWarn@maxWarnNum is zero|roleId=%d|itemid=%d|logReason=%d|maxWarnNum=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(itemId), Integer.valueOf(logReason.value), Integer.valueOf(maxWarnNum) });
/*     */       
/*     */ 
/*  66 */       logger.info(logStr);
/*  67 */       return false;
/*     */     }
/*  69 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  70 */     ResourceId2Num xResourceId2Num = getItemId2NumXBean(roleId, logReason.value, now);
/*     */     
/*  72 */     Long num = (Long)xResourceId2Num.getId2num().get(Integer.valueOf(itemId));
/*  73 */     if (num == null)
/*     */     {
/*  75 */       num = Long.valueOf(0L);
/*     */     }
/*  77 */     long totalNum = num.longValue() + addNum;
/*  78 */     xResourceId2Num.getId2num().put(Integer.valueOf(itemId), Long.valueOf(totalNum));
/*     */     
/*  80 */     if (totalNum >= maxWarnNum)
/*     */     {
/*  82 */       if (isItemCheckSwitchOpen())
/*     */       {
/*  84 */         triggerItemWarnReport(roleId, logReason.value, itemId, totalNum, maxWarnNum);
/*  85 */         String logStr = String.format("[resourcecheck]ResourceChecker.addItemNumAndTriggerWarn@trigger warn report|roleId=%d|itemid=%d|logReason=%d|maxWarnNum=%d|totalNum=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(itemId), Integer.valueOf(logReason.value), Integer.valueOf(maxWarnNum), Long.valueOf(totalNum) });
/*     */         
/*     */ 
/*  88 */         logger.info(logStr);
/*     */         
/*  90 */         return true;
/*     */       }
/*     */       
/*     */ 
/*  94 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 100 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getMaxItemWarnNum(int logReason, int itemId)
/*     */   {
/* 113 */     SWatchTypeCfg sWatchTypeCfg = SWatchTypeCfg.get(logReason);
/* 114 */     if (sWatchTypeCfg == null)
/*     */     {
/* 116 */       return 0;
/*     */     }
/* 118 */     SWatchItemCfg sWatchItemCfg = SWatchItemCfg.get(sWatchTypeCfg.typeId);
/* 119 */     if (sWatchItemCfg == null)
/*     */     {
/* 121 */       return 0;
/*     */     }
/* 123 */     Integer maxNum = (Integer)sWatchItemCfg.itemId2MaxNum.get(Integer.valueOf(itemId));
/* 124 */     if (maxNum == null)
/*     */     {
/* 126 */       return 0;
/*     */     }
/*     */     
/*     */ 
/* 130 */     return maxNum.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void triggerItemWarnReport(long roleId, int logReason, int itemId, long totalNum, int maxNum)
/*     */   {
/* 138 */     int typeId = 0;
/* 139 */     SWatchTypeCfg sWatchTypeCfg = SWatchTypeCfg.get(logReason);
/* 140 */     if (sWatchTypeCfg != null)
/*     */     {
/* 142 */       typeId = sWatchTypeCfg.typeId;
/*     */     }
/* 144 */     String logStr = String.format("ItemAbnormal|roleid=%d|typeid=%d|itemid=%d|total_num=%d|max_num=%d|left_num=%d|log_reason=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(typeId), Integer.valueOf(itemId), Long.valueOf(totalNum), Integer.valueOf(maxNum), Integer.valueOf(mzm.gsp.item.main.ItemInterface.getTotalItemNumberById(roleId, itemId)), Integer.valueOf(logReason) });
/*     */     
/*     */ 
/*     */ 
/* 148 */     GameServer.surveillanceLogger().fatal(logStr);
/*     */     
/* 150 */     STypeId2Logreasons sTypeId2Logreasons = STypeId2Logreasons.get(typeId);
/* 151 */     Reason2Resource xReason2Resource; Iterator i$; if (sTypeId2Logreasons != null)
/*     */     {
/* 153 */       xReason2Resource = Role2resource.get(Long.valueOf(roleId));
/* 154 */       if (xReason2Resource != null)
/*     */       {
/* 156 */         for (i$ = sTypeId2Logreasons.logReasons.iterator(); i$.hasNext();) { int reason = ((Integer)i$.next()).intValue();
/*     */           
/* 158 */           ResourceId2Num xResourceId2Num = (ResourceId2Num)xReason2Resource.getReason2item().get(Integer.valueOf(reason));
/* 159 */           if (xResourceId2Num != null)
/*     */           {
/*     */ 
/*     */ 
/* 163 */             Long num = (Long)xResourceId2Num.getId2num().get(Integer.valueOf(itemId));
/* 164 */             if (num == null)
/*     */             {
/* 166 */               num = Long.valueOf(0L);
/*     */             }
/* 168 */             String detail = String.format("AllItemDetail|roleid=%d|typeid=%d|log_reason=%d|itemid=%d|num=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(typeId), Integer.valueOf(reason), Integer.valueOf(itemId), num });
/*     */             
/* 170 */             GameServer.surveillanceLogger().fatal(detail);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static void checkLogreasonPostInit()
/*     */   {
/* 180 */     for (Iterator i$ = SWatchTypeCfg.getAll().keySet().iterator(); i$.hasNext();) { int logreason = ((Integer)i$.next()).intValue();
/*     */       
/*     */ 
/* 183 */       LogReason reason = LogReason.getReason(logreason);
/* 184 */       if (reason == null)
/*     */       {
/* 186 */         throw new RuntimeException("7400_监控模块类型.xlsx 资源获取途径 LogReason 中不存在 reason=" + logreason);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean isItemCheckSwitchOpen()
/*     */   {
/* 193 */     return mzm.gsp.open.main.OpenInterface.getOpenStatus(151);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\resourcecheck\main\ResourceChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */