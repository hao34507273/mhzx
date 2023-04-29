/*     */ package mzm.gsp.cookiecake.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.award.AwardBean;
/*     */ import mzm.gsp.award.SSendDefaultAwardInfo;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.midautumnholiday.confbean.SCreateCostInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CookieCakeManager
/*     */ {
/*     */   static boolean isFunOpen(long roleid, int openId)
/*     */   {
/*  28 */     if (!OpenInterface.getOpenStatus(openId))
/*     */     {
/*  30 */       return false;
/*     */     }
/*  32 */     if (OpenInterface.isBanPlay(roleid, openId))
/*     */     {
/*  34 */       OpenInterface.sendBanPlayMsg(roleid, openId);
/*  35 */       return false;
/*     */     }
/*  37 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getMaxCreateNum(long roleid, SCreateCostInfo sCreateCostInfo)
/*     */   {
/*  49 */     if (sCreateCostInfo.costItemId2costItemNum.size() <= 0)
/*     */     {
/*  51 */       return 0;
/*     */     }
/*  53 */     int maxCreateNum = Integer.MAX_VALUE;
/*  54 */     for (Map.Entry<Integer, Integer> entry : sCreateCostInfo.costItemId2costItemNum.entrySet())
/*     */     {
/*  56 */       maxCreateNum = Math.min(maxCreateNum, ItemInterface.getItemNumberById(roleid, ((Integer)entry.getKey()).intValue()) / ((Integer)entry.getValue()).intValue());
/*     */     }
/*  58 */     return maxCreateNum;
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
/*     */   static boolean createItem(long roleid, SCreateCostInfo sCreateCostInfo, int createNum)
/*     */   {
/*  71 */     if (deleteStuffItems(roleid, sCreateCostInfo, createNum))
/*     */     {
/*  73 */       return addCreateItem(roleid, sCreateCostInfo, createNum);
/*     */     }
/*  75 */     return false;
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
/*     */   static boolean deleteStuffItems(long roleid, SCreateCostInfo sCreateCostInfo, int createNum)
/*     */   {
/*  90 */     if (sCreateCostInfo.costItemId2costItemNum.size() <= 0)
/*     */     {
/*  92 */       return false;
/*     */     }
/*     */     ItemOperateResult itemOperateResult;
/*  95 */     if (createNum > 1)
/*     */     {
/*  97 */       Map<Integer, Integer> costItemId2costItemNum = new HashMap(sCreateCostInfo.costItemId2costItemNum.size());
/*     */       
/*  99 */       for (Map.Entry<Integer, Integer> entry : sCreateCostInfo.costItemId2costItemNum.entrySet())
/*     */       {
/* 101 */         costItemId2costItemNum.put(entry.getKey(), Integer.valueOf(((Integer)entry.getValue()).intValue() * createNum));
/*     */       }
/* 103 */       itemOperateResult = ItemInterface.removeItemById(roleid, costItemId2costItemNum, new TLogArg(LogReason.CREATE_ITEM_REMOVE));
/*     */     }
/*     */     else {
/*     */       ItemOperateResult itemOperateResult;
/* 107 */       if (createNum == 1)
/*     */       {
/* 109 */         itemOperateResult = ItemInterface.removeItemById(roleid, sCreateCostInfo.costItemId2costItemNum, new TLogArg(LogReason.CREATE_ITEM_REMOVE));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 114 */         return false; } }
/*     */     ItemOperateResult itemOperateResult;
/* 116 */     if (!itemOperateResult.success())
/*     */     {
/* 118 */       return false;
/*     */     }
/* 120 */     return true;
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
/*     */   static boolean addCreateItem(long roleid, SCreateCostInfo sCreateCostInfo, int createNum)
/*     */   {
/* 135 */     ItemOperateResult itemOperateResult = ItemInterface.addItem(roleid, sCreateCostInfo.createItemId, sCreateCostInfo.createItemNum * createNum, sCreateCostInfo.isBind == 1, new TLogArg(LogReason.CREATE_ITEM_ADD));
/*     */     
/*     */ 
/* 138 */     if ((!itemOperateResult.success()) && (!itemOperateResult.isBagFull()))
/*     */     {
/* 140 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 145 */     SSendDefaultAwardInfo protocol = new SSendDefaultAwardInfo();
/* 146 */     protocol.awardinfo.itemmap.put(Integer.valueOf(sCreateCostInfo.createItemId), Integer.valueOf(sCreateCostInfo.createItemNum * createNum));
/* 147 */     OnlineManager.getInstance().send(roleid, protocol);
/*     */     
/* 149 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cookiecake\main\CookieCakeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */