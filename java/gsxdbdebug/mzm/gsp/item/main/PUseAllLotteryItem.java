/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.item.SResUseNormalLottery;
/*     */ import mzm.gsp.item.confbean.SLotteryItem;
/*     */ import mzm.gsp.item.confbean.SUseAllItemCfg;
/*     */ import mzm.gsp.itembulletin.main.ItemBulletinInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PUseAllLotteryItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long uuid;
/*     */   
/*     */   public PUseAllLotteryItem(long roleId, long uuid)
/*     */   {
/*  34 */     this.roleId = roleId;
/*  35 */     this.uuid = uuid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!ItemModuleSwitchInterface.isUseAllLotteryItemSwitchOpenForRole(this.roleId))
/*  42 */       return false;
/*  43 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 149, true))
/*     */     {
/*  45 */       ItemManager.logger.info(String.format("[item]PUseAllLotteryItem.processImp()@status conflict|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  50 */     String userId = RoleInterface.getUserId(this.roleId);
/*  51 */     if (userId == null)
/*  52 */       return false;
/*  53 */     lock(User.getTable(), Collections.singleton(userId));
/*     */     
/*     */ 
/*  56 */     BasicItem basicItem = ItemInterface.getItemByUuid(this.roleId, this.uuid);
/*  57 */     if (basicItem == null)
/*  58 */       return false;
/*  59 */     SUseAllItemCfg useAllItemCfg = SUseAllItemCfg.get(basicItem.getCfgId());
/*  60 */     if (useAllItemCfg == null)
/*  61 */       return false;
/*  62 */     SLotteryItem lotteryItem = SLotteryItem.get(basicItem.getCfgId());
/*  63 */     if (lotteryItem == null) {
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     SResUseNormalLottery response = new SResUseNormalLottery();
/*  68 */     response.lotteryitemid = lotteryItem.id;
/*  69 */     TLogArg tLogArg = new TLogArg(LogReason.ITEM_LOTTERY_USE, basicItem.getCfgId());
/*  70 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*  71 */     int itemNum = ItemInterface.getItemNumberById(this.roleId, basicItem.getCfgId());
/*  72 */     for (int i = 0; i < itemNum; i++)
/*     */     {
/*  74 */       AwardPoolResultData resultData = AwardPoolInterface.randomResultForNormalLottery(this.roleId, roleLevel, lotteryItem.randomTextId);
/*     */       
/*  76 */       if (resultData == null)
/*     */         break;
/*  78 */       if (!ItemInterface.removeItemById(this.roleId, basicItem.getCfgId(), 1, tLogArg))
/*     */         break;
/*  80 */       AwardPoolInterface.doAward(userId, this.roleId, resultData, tLogArg);
/*  81 */       mergeItemNumberMap(resultData.getItemMap(), response.finalitemid2num);
/*     */     }
/*  83 */     if (response.finalitemid2num.isEmpty()) {
/*  84 */       return false;
/*     */     }
/*  86 */     OnlineManager.getInstance().send(this.roleId, response);
/*  87 */     for (Integer itemId : response.finalitemid2num.keySet())
/*     */     {
/*  89 */       if (ItemBulletinInterface.needBulletin(itemId.intValue()))
/*     */       {
/*  91 */         SBulletinInfo bulletinInfo = new SBulletinInfo();
/*  92 */         bulletinInfo.bulletintype = 14;
/*  93 */         bulletinInfo.params.put(Integer.valueOf(1), RoleInterface.getName(this.roleId));
/*  94 */         bulletinInfo.params.put(Integer.valueOf(12), String.valueOf(lotteryItem.id));
/*  95 */         bulletinInfo.params.put(Integer.valueOf(4), String.valueOf(itemId));
/*  96 */         BulletinInterface.sendBulletin(bulletinInfo);
/*     */       }
/*     */     }
/*  99 */     ItemManager.logger.info(String.format("[item]PUseAllLotteryItem.processImp()@success|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 100 */     return true;
/*     */   }
/*     */   
/*     */   private void mergeItemNumberMap(Map<Integer, Integer> src, Map<Integer, Integer> dst)
/*     */   {
/* 105 */     for (Map.Entry<Integer, Integer> entry : src.entrySet())
/*     */     {
/* 107 */       Integer itemNum = (Integer)dst.get(entry.getKey());
/* 108 */       if (itemNum == null) {
/* 109 */         dst.put(entry.getKey(), entry.getValue());
/*     */       } else {
/* 111 */         dst.put(entry.getKey(), Integer.valueOf(((Integer)entry.getValue()).intValue() + itemNum.intValue()));
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PUseAllLotteryItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */