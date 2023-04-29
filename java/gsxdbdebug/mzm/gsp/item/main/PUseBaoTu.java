/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.awardpool.confbean.SControllerPoolSub;
/*     */ import mzm.gsp.awardpool.confbean.SExpPoolSub;
/*     */ import mzm.gsp.awardpool.confbean.SItemPoolSub;
/*     */ import mzm.gsp.awardpool.confbean.SMoneyPoolSub;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.baotu.RewardItem;
/*     */ import mzm.gsp.baotu.SUseResultRes;
/*     */ import mzm.gsp.item.confbean.SItemCangBaoTuCfg;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PUseBaoTu
/*     */   extends LogicProcedure
/*     */   implements MapCallback<Map<Long, Position>>
/*     */ {
/*     */   private final long uuid;
/*     */   private final long roleId;
/*     */   
/*     */   public PUseBaoTu(long uuid, long roleId)
/*     */   {
/*  44 */     this.uuid = uuid;
/*  45 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  51 */     String log = String.format("[wabao]PUseBaoTu.processImp@receive wa bao req|roleid=%d|rolelevel=%d|uuid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(RoleInterface.getLevel(this.roleId)), Long.valueOf(this.uuid) });
/*     */     
/*  53 */     ItemManager.logger.info(log);
/*     */     
/*  55 */     if (!ItemModuleSwitchInterface.isUseBaotuSwitchOpenForRole(this.roleId))
/*     */     {
/*  57 */       return false;
/*     */     }
/*  59 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 150, true))
/*     */     {
/*  61 */       String logStr = String.format("[item]PUseBaoTu.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  62 */       ItemManager.logger.info(logStr);
/*  63 */       return false;
/*     */     }
/*  65 */     MapInterface.getRolePosition(this.roleId, this);
/*  66 */     return true;
/*     */   }
/*     */   
/*     */   private int random(int max, int min)
/*     */   {
/*  71 */     if (max == min)
/*     */     {
/*  73 */       return min;
/*     */     }
/*  75 */     return Xdb.random().nextInt(max - min) + min;
/*     */   }
/*     */   
/*     */   private void fillPrepareResult(List<Integer> prepareAwardList, SUseResultRes resultProtocol)
/*     */   {
/*  80 */     for (Iterator i$ = prepareAwardList.iterator(); i$.hasNext();) { int awardSubId = ((Integer)i$.next()).intValue();
/*     */       
/*  82 */       RewardItem ri = new RewardItem();
/*  83 */       if (AwardPoolInterface.isSItemPoolSub(awardSubId))
/*     */       {
/*  85 */         SItemPoolSub sItemPoolSub = SItemPoolSub.get(awardSubId);
/*  86 */         ri.rewardtype = 0;
/*  87 */         ri.parammap.put(Integer.valueOf(0), Integer.valueOf(sItemPoolSub.itemId));
/*  88 */         ri.parammap.put(Integer.valueOf(1), Integer.valueOf(sItemPoolSub.itemNum));
/*     */       }
/*  90 */       else if (AwardPoolInterface.isSControllerPoolSub(awardSubId))
/*     */       {
/*  92 */         SControllerPoolSub controllerPoolSub = SControllerPoolSub.get(awardSubId);
/*  93 */         ri.rewardtype = 7;
/*     */         
/*  95 */         ri.parammap.put(Integer.valueOf(5), Integer.valueOf(controllerPoolSub.controllerId));
/*     */ 
/*     */       }
/*  98 */       else if (AwardPoolInterface.isSExpPoolSub(awardSubId))
/*     */       {
/* 100 */         SExpPoolSub expPoolSub = SExpPoolSub.get(awardSubId);
/* 101 */         switch (expPoolSub.expType)
/*     */         {
/*     */         case 2: 
/* 104 */           ri.rewardtype = 2;
/* 105 */           break;
/*     */         case 1: 
/* 107 */           ri.rewardtype = 1;
/* 108 */           break;
/*     */         case 3: 
/* 110 */           ri.rewardtype = 3;
/*     */         }
/*     */         
/* 113 */         int expNum = random(expPoolSub.maxExpNum, expPoolSub.minExpNum);
/* 114 */         ri.parammap.put(Integer.valueOf(2), Integer.valueOf(expNum));
/*     */       }
/* 116 */       else if (AwardPoolInterface.isSMoneyPoolSub(awardSubId))
/*     */       {
/* 118 */         SMoneyPoolSub sMoneyPoolSub = SMoneyPoolSub.get(awardSubId);
/* 119 */         switch (sMoneyPoolSub.moneyType)
/*     */         {
/*     */         case 2: 
/* 122 */           ri.rewardtype = 5;
/* 123 */           break;
/*     */         case 3: 
/* 125 */           ri.rewardtype = 4;
/* 126 */           break;
/*     */         case 4: 
/* 128 */           ri.rewardtype = 6;
/* 129 */           break;
/*     */         case 1: 
/* 131 */           ri.rewardtype = 8;
/*     */         }
/*     */         
/*     */         
/* 135 */         int rewardMoney = random(sMoneyPoolSub.maxMoneyNum, sMoneyPoolSub.minMoneyNum);
/* 136 */         ri.parammap.put(Integer.valueOf(3), Integer.valueOf(rewardMoney));
/*     */       }
/* 138 */       else if (AwardPoolInterface.isSReplaceMoneyTypeSub(awardSubId))
/*     */       {
/* 140 */         throw new UnsupportedOperationException("baotu no support replace money");
/*     */       }
/* 142 */       resultProtocol.awardidlist.add(ri);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean fillFinalResult(AwardPoolResultData resultData, SUseResultRes resultProtocol)
/*     */   {
/* 148 */     RewardItem reward = new RewardItem();
/* 149 */     if (resultData.getControllerId() > 0)
/*     */     {
/*     */ 
/* 152 */       ControllerInterface.triggerController(resultData.getControllerId());
/*     */       
/* 154 */       List<Integer> mapList = ControllerInterface.getControllerMapList(resultData.getControllerId());
/* 155 */       if (mapList.size() == 0)
/*     */       {
/*     */ 
/* 158 */         String logStr = String.format("[item]PUseBaoTu.fillFinalResult@controller map  error|roleid=%d|controllerid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(resultData.getControllerId()) });
/*     */         
/*     */ 
/* 161 */         ItemManager.logger.error(logStr);
/* 162 */         mapList.add(Integer.valueOf(MapInterface.getRoleMapId(this.roleId)));
/*     */       }
/*     */       
/* 165 */       reward.rewardtype = 7;
/*     */       
/* 167 */       reward.parammap.put(Integer.valueOf(5), Integer.valueOf(resultData.getControllerId()));
/* 168 */       reward.parammap.put(Integer.valueOf(4), mapList.get(0));
/*     */ 
/*     */     }
/* 171 */     else if (resultData.getRoleExp() > 0)
/*     */     {
/* 173 */       reward.rewardtype = 1;
/* 174 */       reward.parammap.put(Integer.valueOf(2), Integer.valueOf(resultData.getRoleExp()));
/*     */     }
/* 176 */     else if (resultData.getPetExp() > 0)
/*     */     {
/* 178 */       reward.rewardtype = 2;
/* 179 */       reward.parammap.put(Integer.valueOf(2), Integer.valueOf(resultData.getPetExp()));
/*     */     }
/* 181 */     else if (resultData.getXiuLianExp() > 0)
/*     */     {
/* 183 */       reward.rewardtype = 3;
/* 184 */       reward.parammap.put(Integer.valueOf(3), Integer.valueOf(resultData.getXiuLianExp()));
/*     */     }
/* 186 */     else if (resultData.getSilver() > 0)
/*     */     {
/* 188 */       reward.rewardtype = 4;
/* 189 */       reward.parammap.put(Integer.valueOf(3), Integer.valueOf(resultData.getSilver()));
/*     */     }
/* 191 */     else if (resultData.getGold() > 0)
/*     */     {
/* 193 */       reward.rewardtype = 5;
/* 194 */       reward.parammap.put(Integer.valueOf(3), Integer.valueOf(resultData.getGold()));
/*     */     }
/* 196 */     else if (resultData.getGang() > 0)
/*     */     {
/* 198 */       reward.rewardtype = 6;
/* 199 */       reward.parammap.put(Integer.valueOf(3), Integer.valueOf(resultData.getGang()));
/*     */     }
/* 201 */     else if (!resultData.getItemMap().isEmpty())
/*     */     {
/* 203 */       reward.rewardtype = 0;
/* 204 */       for (Map.Entry<Integer, Integer> entry : resultData.getItemMap().entrySet())
/*     */       {
/* 206 */         reward.parammap.put(Integer.valueOf(0), entry.getKey());
/* 207 */         reward.parammap.put(Integer.valueOf(1), entry.getValue());
/*     */       }
/*     */     }
/* 210 */     resultProtocol.awardidlist.add(0, reward);
/* 211 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCallInProcedure()
/*     */   {
/* 217 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean onResult(Map<Long, Position> result)
/*     */   {
/* 223 */     if (result == null)
/*     */     {
/* 225 */       return false;
/*     */     }
/*     */     
/* 228 */     Position curPos = (Position)result.get(Long.valueOf(this.roleId));
/*     */     
/* 230 */     if (curPos == null)
/*     */     {
/* 232 */       return false;
/*     */     }
/*     */     
/* 235 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/* 236 */     BasicItem item = ItemInterface.getItemByUuid(this.roleId, 340600000, this.uuid, true);
/* 237 */     if (!(item instanceof BaoTuItem))
/*     */     {
/* 239 */       return false;
/*     */     }
/*     */     
/* 242 */     BaoTuItem baotu = (BaoTuItem)item;
/* 243 */     int cfgId = baotu.getCfgId();
/* 244 */     SItemCangBaoTuCfg cfg = SItemCangBaoTuCfg.get(cfgId);
/* 245 */     if (cfg.useLevel > roleLevel)
/*     */     {
/* 247 */       return false;
/*     */     }
/* 249 */     String log = String.format("[wabao]PUseBaoTu.onResult@receive wa bao req|roleid=%d|rolelevel=%d|uuid=%d|itemid=%d|awardpoolid=%d|mapid=%d|x=%d|y=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Long.valueOf(this.uuid), Integer.valueOf(item.getCfgId()), Integer.valueOf(cfg.awardPoolId), baotu.getMapId(), baotu.getX(), baotu.getY() });
/*     */     
/*     */ 
/* 252 */     ItemManager.logger.info(log);
/*     */     
/* 254 */     int curX = curPos.getX() >> 4;
/* 255 */     int curY = curPos.getY() >> 4;
/* 256 */     if ((curPos.getSceneId() != baotu.getMapId().intValue()) || (curX != baotu.getX().intValue() >> 4) || (curY != baotu.getY().intValue() >> 4))
/*     */     {
/* 258 */       String logStr = String.format("[wabao]PUseBaoTu.onResult@use baotu not in specify cell|roleid=%d|mapid=%d|curX=%d|curY=%d|baotuX=%d|baotuY=%d", new Object[] { Long.valueOf(this.roleId), baotu.getMapId(), Integer.valueOf(curX), Integer.valueOf(curY), Integer.valueOf(baotu.getX().intValue() >> 4), Integer.valueOf(baotu.getY().intValue() >> 4) });
/*     */       
/*     */ 
/* 261 */       ItemManager.logger.error(logStr);
/* 262 */       return false;
/*     */     }
/* 264 */     TLogArg logArg = new TLogArg(LogReason.ITEM_USE_BAOTU, baotu.getCfgId());
/* 265 */     int hasnum = item.getNumber();
/* 266 */     boolean ret = ItemInterface.removeItemByUuid(this.roleId, this.uuid, 1, logArg);
/* 267 */     if ((ret) && (hasnum > 1))
/*     */     {
/* 269 */       baotu.onCreateItem();
/*     */     }
/* 271 */     if (!ret)
/*     */     {
/* 273 */       String logStr = String.format("[wabao]PUseBaoTu.onResult@remove baotu error|roleid=%d|itmeid=%d|uuid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(cfgId), Long.valueOf(this.uuid) });
/*     */       
/* 275 */       ItemManager.logger.error(logStr);
/* 276 */       return false;
/*     */     }
/*     */     
/* 279 */     AwardPoolResultData awardResult = AwardPoolInterface.randomResultForNormalLottery(this.roleId, roleLevel, cfg.awardPoolId);
/*     */     
/*     */ 
/*     */ 
/* 283 */     if (awardResult == null)
/*     */     {
/* 285 */       return false;
/*     */     }
/*     */     
/* 288 */     List<Integer> awardList = awardResult.getPrepareSubPoolIds();
/* 289 */     if ((awardList == null) || (awardList.isEmpty()))
/*     */     {
/* 291 */       String logStr = String.format("[wabao]PUseBaoTu.onResult@awardpool prepare result error|roleid=%d|itemid=%d|awardPoolId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(cfgId), Integer.valueOf(cfg.awardPoolId) });
/*     */       
/*     */ 
/* 294 */       ItemManager.logger.error(logStr);
/* 295 */       return false;
/*     */     }
/* 297 */     int oldPrepareSize = awardList.size();
/* 298 */     List<Integer> finalAward = awardResult.getFinalSubPoolIds();
/*     */     
/* 300 */     if ((finalAward == null) || (finalAward.isEmpty()) || (finalAward.size() > 1))
/*     */     {
/* 302 */       String logStr = String.format("[wabao]PUseBaoTu.onResult@awardpool final result error|roleid=%d|itemid=%d|awardPoolId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(cfgId), Integer.valueOf(cfg.awardPoolId) });
/*     */       
/*     */ 
/* 305 */       ItemManager.logger.error(logStr);
/* 306 */       return false;
/*     */     }
/*     */     
/* 309 */     Integer fa = (Integer)finalAward.get(0);
/* 310 */     int idx = awardList.lastIndexOf(fa);
/* 311 */     awardList.remove(idx);
/*     */     
/* 313 */     log = String.format("[wabao]PUseBaoTu.onResult@random result success|roleid=%d|rolelevel=%d|uuid=%d|itemid=%d|awardpoolid=%d|oldpreparesize=%d|preparesize=%d|finalsize=%d|fa=%d|idx=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Long.valueOf(this.uuid), Integer.valueOf(item.getCfgId()), Integer.valueOf(cfg.awardPoolId), Integer.valueOf(oldPrepareSize), Integer.valueOf(awardList.size()), Integer.valueOf(finalAward.size()), fa, Integer.valueOf(idx) });
/*     */     
/*     */ 
/*     */ 
/* 317 */     ItemManager.logger.info(log);
/*     */     
/* 319 */     SUseResultRes resultProtocol = new SUseResultRes();
/* 320 */     fillPrepareResult(awardList, resultProtocol);
/* 321 */     ret = fillFinalResult(awardResult, resultProtocol);
/* 322 */     if (!ret)
/*     */     {
/* 324 */       log = String.format("[wabao]PUseBaoTu.onResult@fill final result error|roleid=%d|rolelevel=%d|uuid=%d|itemid=%d|awardpoolid=%d|preparesize=%d|finalsize=%d|fa=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Long.valueOf(this.uuid), Integer.valueOf(item.getCfgId()), Integer.valueOf(cfg.awardPoolId), Integer.valueOf(awardList.size()), Integer.valueOf(finalAward.size()), fa });
/*     */       
/*     */ 
/* 327 */       ItemManager.logger.error(log);
/* 328 */       return false;
/*     */     }
/*     */     
/* 331 */     ret = LotteryManager.addLottery(this.roleId, 0, item.getCfgId(), awardResult, logArg);
/* 332 */     if (!ret)
/*     */     {
/* 334 */       log = String.format("[wabao]PUseBaoTu.onResult@addLottery error|roleid=%d|rolelevel=%d|uuid=%d|itemid=%d|awardpoolid=%d|preparesize=%d|finalsize=%d|fa=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Long.valueOf(this.uuid), Integer.valueOf(item.getCfgId()), Integer.valueOf(cfg.awardPoolId), Integer.valueOf(awardList.size()), Integer.valueOf(finalAward.size()), fa });
/*     */       
/*     */ 
/* 337 */       ItemManager.logger.error(log);
/* 338 */       return false;
/*     */     }
/* 340 */     OnlineManager.getInstance().send(this.roleId, resultProtocol);
/* 341 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PUseBaoTu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */