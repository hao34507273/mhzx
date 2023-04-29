/*     */ package mzm.gsp.floplottery.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.awardpool.confbean.FlopLotteryAwardPool;
/*     */ import mzm.gsp.awardpool.confbean.SAwardPoolSum;
/*     */ import mzm.gsp.awardpool.confbean.SFlopLotteryMainCfg;
/*     */ import mzm.gsp.awardpool.confbean.TFlopLotteryAwardPoolCfg;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.floplottery.SFlopLotteryNew;
/*     */ import mzm.gsp.item.confbean.SFlopLotteryItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FlopLotteryEntry;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2floplotteryentry;
/*     */ 
/*     */ public class PCUseFlopLotteryItem extends LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final long itemUUID;
/*     */   
/*     */   public PCUseFlopLotteryItem(long roleId, long itemUUID)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.itemUUID = itemUUID;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     String errorLogHead = "[floplottery]PCUseFlopLotteryItem@processImp ";
/*  41 */     String errorLogTail = String.format("|roleId:%d|itemUUID:%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.itemUUID) });
/*     */     
/*     */ 
/*  44 */     BasicItem basicItem = ItemInterface.getItemByUuid(this.roleId, this.itemUUID);
/*  45 */     if (basicItem == null)
/*     */     {
/*  47 */       String errorLog = "item not exit";
/*  48 */       return FlopLotteryManager.handleError(errorLog + errorLogTail, errorLogHead, this.roleId, -1);
/*     */     }
/*     */     
/*  51 */     if (!basicItem.canUse(this.roleId))
/*     */     {
/*  53 */       String errorLog = "can not use item";
/*  54 */       return FlopLotteryManager.handleError(errorLog + errorLogTail, errorLogHead, this.roleId, -1);
/*     */     }
/*     */     
/*     */ 
/*  58 */     SFlopLotteryItemCfg flopLotteryItemCfg = SFlopLotteryItemCfg.get(basicItem.getCfgId());
/*  59 */     if (flopLotteryItemCfg == null)
/*     */     {
/*  61 */       String errorLog = "item type is not flop";
/*  62 */       return FlopLotteryManager.handleError(errorLog + errorLogTail, errorLogHead, this.roleId, -1);
/*     */     }
/*     */     
/*     */ 
/*  66 */     SFlopLotteryMainCfg flopLotteryMainCfg = SFlopLotteryMainCfg.get(flopLotteryItemCfg.flopLotteryMainCfgId);
/*  67 */     if (!OpenInterface.getOpenStatus(flopLotteryMainCfg.switchId))
/*     */     {
/*  69 */       String errorLog = "switch closed";
/*  70 */       return FlopLotteryManager.handleError(errorLog + errorLogTail, errorLogHead, this.roleId, -1);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  75 */     TFlopLotteryAwardPoolCfg tFlopLotteryAwardPoolCfg = TFlopLotteryAwardPoolCfg.get(flopLotteryMainCfg.typeId);
/*  76 */     Map<Integer, Integer> bagId2TotalNeedGridNum = new HashMap();
/*  77 */     for (FlopLotteryAwardPool flopLotteryAwardPool : tFlopLotteryAwardPoolCfg.flopLotteryAwardPools)
/*     */     {
/*  79 */       Map<Integer, Integer> bagId2NeedGridNum = AwardPoolInterface.getBagId2MaxNeedGridNum(SAwardPoolSum.get(flopLotteryAwardPool.awardPoolSumId).awardTypeId);
/*  80 */       for (Map.Entry<Integer, Integer> entry : bagId2NeedGridNum.entrySet())
/*     */       {
/*  82 */         Integer totalNeedGrid = (Integer)bagId2TotalNeedGridNum.get(entry.getKey());
/*  83 */         if (null == totalNeedGrid)
/*     */         {
/*  85 */           bagId2TotalNeedGridNum.put(entry.getKey(), entry.getValue());
/*     */         }
/*     */         else
/*     */         {
/*  89 */           bagId2TotalNeedGridNum.put(entry.getKey(), Integer.valueOf(((Integer)entry.getValue()).intValue() + totalNeedGrid.intValue()));
/*     */         }
/*     */       }
/*     */     }
/*  93 */     if (AwardPoolInterface.checkGridNum(this.roleId, bagId2TotalNeedGridNum, true, true) > 0)
/*     */     {
/*  95 */       String errorLog = "bag capacity not enough";
/*  96 */       GameServer.logger().error(errorLogHead + errorLog + errorLogTail);
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     FlopLotteryEntry xFlopLotteryEntry = Role2floplotteryentry.get(Long.valueOf(this.roleId));
/* 101 */     if (xFlopLotteryEntry == null)
/*     */     {
/*     */ 
/* 104 */       return handleNewFlopLottery(flopLotteryMainCfg);
/*     */     }
/*     */     
/*     */ 
/* 108 */     if ((xFlopLotteryEntry.getExpiretimestamp() != 0L) && (xFlopLotteryEntry.getExpiretimestamp() < DateTimeUtils.getCurrTimeInMillis()))
/*     */     {
/*     */ 
/*     */ 
/* 112 */       Role2floplotteryentry.delete(Long.valueOf(this.roleId));
/*     */       
/* 114 */       return handleNewFlopLottery(flopLotteryMainCfg);
/*     */     }
/* 116 */     if (xFlopLotteryEntry.getFloplotteryawardpoolresultlist().isEmpty())
/*     */     {
/*     */ 
/* 119 */       Role2floplotteryentry.delete(Long.valueOf(this.roleId));
/*     */       
/* 121 */       return handleNewFlopLottery(flopLotteryMainCfg);
/*     */     }
/* 123 */     return FlopLotteryManager.handleLastFlopLottery(xFlopLotteryEntry, this.roleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean handleNewFlopLottery(SFlopLotteryMainCfg flopLotteryMainCfg)
/*     */   {
/* 130 */     long uid = FlopLotteryManager.getNextUId();
/* 131 */     boolean sendRet = OnlineManager.getInstance().send(this.roleId, new SFlopLotteryNew(uid, flopLotteryMainCfg.id));
/* 132 */     if (!sendRet)
/*     */     {
/* 134 */       return false;
/*     */     }
/* 136 */     FlopLotteryEntry xFlopLotteryEntry = Pod.newFlopLotteryEntry();
/* 137 */     xFlopLotteryEntry.setIsconddone(1);
/*     */     
/* 139 */     xFlopLotteryEntry.setExpiretimestamp(0L);
/* 140 */     xFlopLotteryEntry.setUid(uid);
/* 141 */     xFlopLotteryEntry.setFloplotterymaincfgid(flopLotteryMainCfg.id);
/*     */     
/* 143 */     xFlopLotteryEntry.setFloplotteryhandler(new FlopLotteryItemHandlerImpl(this.itemUUID));
/* 144 */     Role2floplotteryentry.insert(Long.valueOf(this.roleId), xFlopLotteryEntry);
/* 145 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floplottery\main\PCUseFlopLotteryItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */