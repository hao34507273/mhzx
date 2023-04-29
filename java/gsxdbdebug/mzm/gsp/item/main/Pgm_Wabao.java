/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.awardpool.confbean.SControllerPoolSub;
/*     */ import mzm.gsp.awardpool.confbean.SExpPoolSub;
/*     */ import mzm.gsp.awardpool.confbean.SItemPoolSub;
/*     */ import mzm.gsp.awardpool.confbean.SMoneyPoolSub;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.baotu.RewardItem;
/*     */ import mzm.gsp.baotu.SUseResultRes;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ 
/*     */ public class Pgm_Wabao extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private int awardpoolid;
/*     */   private long roleId;
/*     */   
/*     */   public Pgm_Wabao(int awardpoolid, long roleId)
/*     */   {
/*  27 */     this.awardpoolid = awardpoolid;
/*  28 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception {
/*  32 */     AwardPoolResultData result = AwardPoolInterface.getAwardPoolData(this.awardpoolid, this.roleId, mzm.gsp.role.main.RoleInterface.getLevel(this.roleId));
/*     */     
/*  34 */     if (result == null)
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  40 */     List<Integer> awardList = result.getPrepareSubPoolIds();
/*  41 */     List<Integer> finalAward = result.getFinalSubPoolIds();
/*  42 */     if ((finalAward == null) || (finalAward.isEmpty()) || (finalAward.size() > 1)) {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     Integer fa = (Integer)finalAward.get(0);
/*  47 */     int idx = awardList.lastIndexOf(fa);
/*  48 */     awardList.remove(idx);
/*     */     
/*  50 */     SUseResultRes resultProtocol = new SUseResultRes();
/*     */     
/*  52 */     fillPrepareResult(awardList, resultProtocol);
/*     */     
/*  54 */     boolean ret = fillFinalResult(result, resultProtocol);
/*     */     
/*     */ 
/*     */ 
/*  58 */     OnlineManager.getInstance().send(this.roleId, resultProtocol);
/*  59 */     return ret;
/*     */   }
/*     */   
/*     */   private int random(int max, int min)
/*     */   {
/*  64 */     if (max == min) {
/*  65 */       return min;
/*     */     }
/*  67 */     return xdb.Xdb.random().nextInt(max - min) + min;
/*     */   }
/*     */   
/*     */   private void fillPrepareResult(List<Integer> prepareAwardList, SUseResultRes resultProtocol) {
/*  71 */     for (Iterator i$ = prepareAwardList.iterator(); i$.hasNext();) { int awardSubId = ((Integer)i$.next()).intValue();
/*  72 */       RewardItem ri = new RewardItem();
/*  73 */       if (AwardPoolInterface.isSItemPoolSub(awardSubId)) {
/*  74 */         SItemPoolSub sItemPoolSub = SItemPoolSub.get(awardSubId);
/*  75 */         ri.rewardtype = 0;
/*  76 */         ri.parammap.put(Integer.valueOf(0), Integer.valueOf(sItemPoolSub.itemId));
/*  77 */         ri.parammap.put(Integer.valueOf(1), Integer.valueOf(sItemPoolSub.itemNum));
/*  78 */       } else if (AwardPoolInterface.isSControllerPoolSub(awardSubId)) {
/*  79 */         SControllerPoolSub controllerPoolSub = SControllerPoolSub.get(awardSubId);
/*  80 */         ri.rewardtype = 7;
/*  81 */         ri.parammap.put(Integer.valueOf(5), Integer.valueOf(controllerPoolSub.controllerId));
/*     */       }
/*  83 */       else if (AwardPoolInterface.isSExpPoolSub(awardSubId)) {
/*  84 */         SExpPoolSub expPoolSub = SExpPoolSub.get(awardSubId);
/*  85 */         switch (expPoolSub.expType)
/*     */         {
/*     */         case 2: 
/*  88 */           ri.rewardtype = 2;
/*  89 */           break;
/*     */         case 1: 
/*  91 */           ri.rewardtype = 1;
/*  92 */           break;
/*     */         case 3: 
/*  94 */           ri.rewardtype = 3;
/*     */         }
/*     */         
/*  97 */         int expNum = random(expPoolSub.maxExpNum, expPoolSub.minExpNum);
/*  98 */         ri.parammap.put(Integer.valueOf(2), Integer.valueOf(expNum));
/*  99 */       } else if (AwardPoolInterface.isSMoneyPoolSub(awardSubId)) {
/* 100 */         SMoneyPoolSub sMoneyPoolSub = SMoneyPoolSub.get(awardSubId);
/* 101 */         switch (sMoneyPoolSub.moneyType)
/*     */         {
/*     */         case 2: 
/* 104 */           ri.rewardtype = 5;
/* 105 */           break;
/*     */         case 3: 
/* 107 */           ri.rewardtype = 4;
/* 108 */           break;
/*     */         case 4: 
/* 110 */           ri.rewardtype = 6;
/* 111 */           break;
/*     */         case 1: 
/* 113 */           ri.rewardtype = 8;
/*     */         }
/*     */         
/*     */         
/* 117 */         int rewardMoney = random(sMoneyPoolSub.maxMoneyNum, sMoneyPoolSub.minMoneyNum);
/* 118 */         ri.parammap.put(Integer.valueOf(3), Integer.valueOf(rewardMoney));
/* 119 */       } else if (AwardPoolInterface.isSReplaceMoneyTypeSub(awardSubId)) {
/* 120 */         throw new UnsupportedOperationException("baotu no support replace money");
/*     */       }
/* 122 */       resultProtocol.awardidlist.add(ri);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean fillFinalResult(AwardPoolResultData resultData, SUseResultRes resultProtocol) {
/* 127 */     RewardItem reward = new RewardItem();
/* 128 */     if (resultData.getControllerId() > 0)
/*     */     {
/* 130 */       ControllerInterface.triggerController(resultData.getControllerId());
/*     */       
/* 132 */       List<Integer> mapList = ControllerInterface.getControllerMapList(resultData.getControllerId());
/* 133 */       if (mapList.size() == 0) {
/* 134 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 139 */       reward.rewardtype = 7;
/*     */       
/* 141 */       reward.parammap.put(Integer.valueOf(5), Integer.valueOf(resultData.getControllerId()));
/* 142 */       reward.parammap.put(Integer.valueOf(4), mapList.get(0));
/*     */     }
/* 144 */     else if (resultData.getRoleExp() > 0) {
/* 145 */       reward.rewardtype = 1;
/* 146 */       reward.parammap.put(Integer.valueOf(2), Integer.valueOf(resultData.getRoleExp()));
/* 147 */     } else if (resultData.getPetExp() > 0) {
/* 148 */       reward.rewardtype = 2;
/* 149 */       reward.parammap.put(Integer.valueOf(2), Integer.valueOf(resultData.getPetExp()));
/* 150 */     } else if (resultData.getXiuLianExp() > 0) {
/* 151 */       reward.rewardtype = 3;
/* 152 */       reward.parammap.put(Integer.valueOf(3), Integer.valueOf(resultData.getXiuLianExp()));
/* 153 */     } else if (resultData.getSilver() > 0) {
/* 154 */       reward.rewardtype = 4;
/* 155 */       reward.parammap.put(Integer.valueOf(3), Integer.valueOf(resultData.getSilver()));
/* 156 */     } else if (resultData.getGold() > 0) {
/* 157 */       reward.rewardtype = 5;
/* 158 */       reward.parammap.put(Integer.valueOf(3), Integer.valueOf(resultData.getGold()));
/* 159 */     } else if (resultData.getGang() > 0) {
/* 160 */       reward.rewardtype = 6;
/* 161 */       reward.parammap.put(Integer.valueOf(3), Integer.valueOf(resultData.getGang()));
/* 162 */     } else if (!resultData.getItemMap().isEmpty()) {
/* 163 */       reward.rewardtype = 0;
/* 164 */       for (Map.Entry<Integer, Integer> entry : resultData.getItemMap().entrySet()) {
/* 165 */         reward.parammap.put(Integer.valueOf(0), entry.getKey());
/* 166 */         reward.parammap.put(Integer.valueOf(1), entry.getValue());
/*     */       }
/*     */     }
/* 169 */     resultProtocol.awardidlist.add(0, reward);
/* 170 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\Pgm_Wabao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */