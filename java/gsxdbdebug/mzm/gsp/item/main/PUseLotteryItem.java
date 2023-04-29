/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.awardpool.confbean.SLotteryViewRandomCfg;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.baotu.main.BaoTuInterface;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.item.SResUseNormalLottery;
/*     */ import mzm.gsp.item.SResUseTurntableItemLottery;
/*     */ import mzm.gsp.item.SResUseTurntableTypeLottery;
/*     */ import mzm.gsp.item.confbean.SLotteryItem;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PUseLotteryItem extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private long uuid;
/*     */   
/*     */   public PUseLotteryItem(long roleid, long uuid)
/*     */   {
/*  36 */     this.uuid = uuid;
/*  37 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     if (!ItemModuleSwitchInterface.isUseLotteryItemSwitchOpenForRole(this.roleid))
/*     */     {
/*  45 */       return false;
/*     */     }
/*  47 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 149, true))
/*     */     {
/*  49 */       String logStr = String.format("[item]PUseLotteryItem.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  50 */       ItemManager.logger.info(logStr);
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     String userid = RoleInterface.getUserId(this.roleid);
/*  55 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  57 */     BasicItem basicItem = ItemInterface.getItemByUuid(this.roleid, this.uuid);
/*  58 */     if (basicItem == null)
/*     */     {
/*  60 */       return false;
/*     */     }
/*  62 */     SLotteryItem lotteryItem = SLotteryItem.get(basicItem.getCfgId());
/*  63 */     if (lotteryItem == null)
/*     */     {
/*  65 */       return false;
/*     */     }
/*  67 */     TLogArg logArg = new TLogArg(LogReason.ITEM_LOTTERY_USE, basicItem.getCfgId());
/*  68 */     if (lotteryItem.lotteryType == 1)
/*     */     {
/*     */ 
/*  71 */       int roleLevel = RoleInterface.getLevel(this.roleid);
/*     */       
/*  73 */       if (ItemInterface.removeItemByUuid(this.roleid, this.uuid, 1, logArg))
/*     */       {
/*  75 */         AwardPoolResultData result = AwardPoolInterface.randomResultForNormalLottery(this.roleid, roleLevel, lotteryItem.randomTextId);
/*     */         
/*  77 */         if (result != null)
/*     */         {
/*  79 */           AwardPoolInterface.doAward(userid, this.roleid, result, logArg);
/*     */           
/*  81 */           SResUseNormalLottery res = new SResUseNormalLottery();
/*  82 */           res.finalitemid2num.putAll(result.getItemMap());
/*     */           
/*  84 */           res.lotteryitemid = lotteryItem.id;
/*  85 */           OnlineManager.getInstance().send(this.roleid, res);
/*     */           
/*  87 */           for (Iterator i$ = result.getItemMap().keySet().iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/*     */             
/*  89 */             if (BaoTuInterface.needBulletin(itemid))
/*     */             {
/*  91 */               SBulletinInfo bulletinInfo = new SBulletinInfo();
/*  92 */               bulletinInfo.bulletintype = 14;
/*  93 */               bulletinInfo.params.put(Integer.valueOf(1), RoleInterface.getName(this.roleid));
/*  94 */               bulletinInfo.params.put(Integer.valueOf(12), String.valueOf(res.lotteryitemid));
/*  95 */               bulletinInfo.params.put(Integer.valueOf(4), String.valueOf(itemid));
/*  96 */               BulletinInterface.sendBulletin(bulletinInfo);
/*     */             }
/*     */           }
/*     */           
/* 100 */           return true;
/*     */         }
/*     */         
/*     */       }
/*     */       
/*     */     }
/* 106 */     else if (lotteryItem.lotteryType == 2)
/*     */     {
/* 108 */       int roleLevel = RoleInterface.getLevel(this.roleid);
/*     */       
/* 110 */       if (ItemInterface.removeItemByUuid(this.roleid, this.uuid, 1, logArg))
/*     */       {
/* 112 */         AwardPoolResultData result = AwardPoolInterface.randomResultForNormalLottery(this.roleid, roleLevel, lotteryItem.randomTextId);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 122 */         if (result != null)
/*     */         {
/*     */ 
/* 125 */           boolean ret = LotteryManager.addLottery(this.roleid, 1, basicItem.getCfgId(), result, logArg);
/*     */           
/* 127 */           if (!ret)
/*     */           {
/* 129 */             return false;
/*     */           }
/*     */           
/* 132 */           SResUseTurntableItemLottery res = new SResUseTurntableItemLottery();
/* 133 */           res.finalindex = (result.getPrepareSubPoolIds().indexOf(result.getFinalSubPoolIds().get(0)) + 1);
/* 134 */           res.lotteryitemid = lotteryItem.id;
/* 135 */           res.itemids.addAll(AwardPoolInterface.getItemId2NumMap(result.getPrepareSubPoolIds()));
/* 136 */           OnlineManager.getInstance().send(this.roleid, res);
/*     */           
/* 138 */           return true;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/* 143 */     else if (lotteryItem.lotteryType == 3)
/*     */     {
/* 145 */       SLotteryViewRandomCfg lotteryViewRandomCfg = SLotteryViewRandomCfg.get(lotteryItem.randomTextId);
/* 146 */       if (lotteryViewRandomCfg == null)
/*     */       {
/* 148 */         return false;
/*     */       }
/* 150 */       if (ItemInterface.removeItemByUuid(this.roleid, this.uuid, 1, logArg))
/*     */       {
/* 152 */         Map<Integer, Integer> bagId2MaxNeedGrid = AwardPoolInterface.getBagId2LotteryNeedGrid(lotteryViewRandomCfg.id);
/* 153 */         if (AwardPoolInterface.checkGridNum(this.roleid, bagId2MaxNeedGrid, true, true) > 0)
/*     */         {
/* 155 */           return false;
/*     */         }
/* 157 */         AwardPoolResultData result = AwardPoolInterface.getLotteryResultData(this.roleid, lotteryViewRandomCfg.id);
/* 158 */         if (result == null)
/*     */         {
/* 160 */           return false;
/*     */         }
/* 162 */         boolean ret = LotteryManager.addLottery(this.roleid, 1, basicItem.getCfgId(), result, logArg);
/*     */         
/* 164 */         if (!ret)
/*     */         {
/* 166 */           return false;
/*     */         }
/*     */         
/* 169 */         SResUseTurntableTypeLottery res = new SResUseTurntableTypeLottery();
/* 170 */         res.finalindex = (result.getIndex() + 1);
/* 171 */         res.lotteryitemid = lotteryItem.id;
/* 172 */         if (result.getItemMap().size() > 0)
/*     */         {
/* 174 */           res.itemid = ((Integer)result.getItemMap().keySet().iterator().next()).intValue();
/* 175 */           res.itemnum = ((Integer)result.getItemMap().get(Integer.valueOf(res.itemid))).intValue();
/*     */         }
/* 177 */         if (result.getGold() > 0)
/*     */         {
/* 179 */           res.moneytype = 2;
/* 180 */           res.moneynum = result.getGold();
/*     */         }
/* 182 */         if (result.getSilver() > 0)
/*     */         {
/* 184 */           res.moneytype = 3;
/* 185 */           res.moneynum = result.getSilver();
/*     */         }
/* 187 */         if (result.getGang() > 0)
/*     */         {
/* 189 */           res.moneytype = 4;
/* 190 */           res.moneynum = result.getGang();
/*     */         }
/*     */         
/* 193 */         if (result.getPetExp() > 0)
/*     */         {
/*     */ 
/* 196 */           res.exptype = 2;
/* 197 */           res.expnum = result.getPetExp();
/*     */         }
/* 199 */         if (result.getRoleExp() > 0)
/*     */         {
/*     */ 
/* 202 */           res.exptype = 1;
/* 203 */           res.expnum = result.getRoleExp();
/*     */         }
/*     */         
/* 206 */         if (result.getXiuLianExp() > 0)
/*     */         {
/* 208 */           res.exptype = 3;
/* 209 */           res.expnum = result.getXiuLianExp();
/*     */         }
/*     */         
/* 212 */         OnlineManager.getInstance().send(this.roleid, res);
/*     */         
/* 214 */         return true;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 219 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PUseLotteryItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */