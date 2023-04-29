/*     */ package mzm.gsp.partneryuanshen.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.item.confbean.IdTypeValueBean;
/*     */ import mzm.gsp.item.confbean.SItemSiftCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.partneryuanshen.SImproveFail;
/*     */ import mzm.gsp.partneryuanshen.SImproveSuccess;
/*     */ import mzm.gsp.partneryuanshen.confbean.SPartnerYuanshenImproveBean;
/*     */ import mzm.gsp.partneryuanshen.confbean.SPartnerYuanshenImproveCfg;
/*     */ import mzm.gsp.partneryuanshen.event.PartnerYuanshenImproved;
/*     */ import mzm.gsp.partneryuanshen.event.PartnerYuanshenImprovedArg;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.Pair;
/*     */ import xbean.PartnerYuanshenPositionInfo;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PImproveYuanshen extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final boolean useYuanbao;
/*     */   private final long roleId;
/*     */   private final int position;
/*     */   private final long currentYuanbao;
/*     */   private final int propertyNumToImprove;
/*     */   
/*     */   public PImproveYuanshen(long roleId, int position, int propertyNumToImprove)
/*     */   {
/*  41 */     this.useYuanbao = false;
/*  42 */     this.roleId = roleId;
/*  43 */     this.position = position;
/*  44 */     this.currentYuanbao = 0L;
/*  45 */     this.propertyNumToImprove = propertyNumToImprove;
/*     */   }
/*     */   
/*     */   public PImproveYuanshen(long roleId, int position, long currentYuanbao, int propertyNumToImprove)
/*     */   {
/*  50 */     this.useYuanbao = true;
/*  51 */     this.roleId = roleId;
/*  52 */     this.position = position;
/*  53 */     this.currentYuanbao = currentYuanbao;
/*  54 */     this.propertyNumToImprove = propertyNumToImprove;
/*     */   }
/*     */   
/*     */   private void triggerPartnerYuanshenImproved(int attachedPartnerId, int level, int propertyNum)
/*     */   {
/*  59 */     PartnerYuanshenImprovedArg arg = new PartnerYuanshenImprovedArg(this.roleId, this.position, attachedPartnerId, level, propertyNum);
/*     */     
/*  61 */     TriggerEventsManger.getInstance().triggerEvent(new PartnerYuanshenImproved(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean processImp()
/*     */     throws Exception
/*     */   {
/*  69 */     if (PartnerYuanshenManager.isNotEnable())
/*     */     {
/*  71 */       return false;
/*     */     }
/*  73 */     if (PartnerYuanshenManager.notMeetOpenLevel(this.roleId))
/*     */     {
/*  75 */       return false;
/*     */     }
/*  77 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1692, true))
/*     */     {
/*  79 */       return false;
/*     */     }
/*  81 */     if (this.propertyNumToImprove < 1)
/*     */     {
/*  83 */       return false;
/*     */     }
/*  85 */     SPartnerYuanshenImproveCfg cfg = SPartnerYuanshenImproveCfg.get(this.position);
/*  86 */     if (cfg == null)
/*     */     {
/*  88 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  92 */     if (this.useYuanbao)
/*     */     {
/*  94 */       String userId = RoleInterface.getUserId(this.roleId);
/*  95 */       if (userId == null)
/*     */       {
/*  97 */         return false;
/*     */       }
/*  99 */       xdb.Lockeys.lock(User.getTable(), java.util.Collections.singleton(userId));
/*     */     }
/*     */     
/* 102 */     PartnerYuanshenPositionInfo xPartnerYuanshenPositionInfo = PartnerYuanshenManager.getOrCreatePartnerYuanshenPositionInfo(this.roleId, this.position);
/*     */     
/*     */ 
/*     */ 
/* 106 */     ImproveProgressAndCost improveProgressAndCost = calculateFinalImproveProgressAndCost(xPartnerYuanshenPositionInfo, cfg);
/*     */     
/* 108 */     if (improveProgressAndCost == null)
/*     */     {
/* 110 */       if (this.propertyNumToImprove == 1)
/*     */       {
/* 112 */         notifyFail(4);
/*     */       }
/*     */       else
/*     */       {
/* 116 */         notifyFail(5);
/*     */       }
/* 118 */       PartnerYuanshenLogger.error("PImproveYuanshen.processImp()@cannot improve anymore|roleid=%d|position=%d|num_to_improve=%d|level=%d|property_num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.position), Integer.valueOf(this.propertyNumToImprove), Integer.valueOf(xPartnerYuanshenPositionInfo.getLevel()), Integer.valueOf(xPartnerYuanshenPositionInfo.getProperty_num()) });
/*     */       
/*     */ 
/*     */ 
/* 122 */       return false;
/*     */     }
/*     */     
/* 125 */     return improveYuanshen(xPartnerYuanshenPositionInfo, improveProgressAndCost);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private ImproveProgressAndCost calculateFinalImproveProgressAndCost(PartnerYuanshenPositionInfo xPartnerYuanshenPositionInfo, SPartnerYuanshenImproveCfg cfg)
/*     */   {
/* 135 */     int level = xPartnerYuanshenPositionInfo.getLevel();
/* 136 */     int propertyNum = xPartnerYuanshenPositionInfo.getProperty_num();
/* 137 */     Map<Integer, Integer> siftCfgId2Num = new HashMap();
/*     */     
/* 139 */     SPartnerYuanshenImproveBean bean = (SPartnerYuanshenImproveBean)cfg.level2bean.get(Integer.valueOf(level));
/* 140 */     if (bean == null)
/*     */     {
/* 142 */       PartnerYuanshenLogger.error("PImproveYuanshen.calculateFinalImproveProgressAndCost()@potential corrupted data|roleid=%d|position=%d|level=%d|property_num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.position), Integer.valueOf(level), Integer.valueOf(propertyNum) });
/*     */       
/*     */ 
/* 145 */       return null;
/*     */     }
/*     */     
/* 148 */     for (int i = 0; i < this.propertyNumToImprove; i++)
/*     */     {
/*     */ 
/* 151 */       if (propertyNum < bean.propertyTypes.size())
/*     */       {
/*     */ 
/* 154 */         propertyNum++;
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 159 */         bean = (SPartnerYuanshenImproveBean)cfg.level2bean.get(Integer.valueOf(level + 1));
/* 160 */         if (bean == null)
/*     */         {
/* 162 */           return null;
/*     */         }
/* 164 */         level++;
/* 165 */         propertyNum = 1;
/*     */       }
/*     */       
/*     */ 
/* 169 */       Integer itemNum = (Integer)siftCfgId2Num.get(Integer.valueOf(bean.improveRequiredItemSiftId));
/* 170 */       if (itemNum == null)
/*     */       {
/* 172 */         siftCfgId2Num.put(Integer.valueOf(bean.improveRequiredItemSiftId), Integer.valueOf(bean.improveRequiredItemNum));
/*     */       }
/*     */       else
/*     */       {
/* 176 */         siftCfgId2Num.put(Integer.valueOf(bean.improveRequiredItemSiftId), Integer.valueOf(bean.improveRequiredItemNum + itemNum.intValue()));
/*     */       }
/*     */     }
/* 179 */     ImproveProgressAndCost improveProgressAndCost = new ImproveProgressAndCost(null);
/* 180 */     improveProgressAndCost.level = level;
/* 181 */     improveProgressAndCost.propertyNum = propertyNum;
/* 182 */     improveProgressAndCost.siftCfgId2Num = siftCfgId2Num;
/* 183 */     return improveProgressAndCost;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean improveYuanshen(PartnerYuanshenPositionInfo xPartnerYuanshenPositionInfo, ImproveProgressAndCost improveProgressAndCost)
/*     */   {
/* 194 */     String userId = RoleInterface.getUserId(this.roleId);
/* 195 */     if (this.useYuanbao)
/*     */     {
/* 197 */       if (userId == null)
/* 198 */         return false;
/* 199 */       long currentYuanbao = QingfuInterface.getBalance(userId, true);
/* 200 */       if (currentYuanbao != this.currentYuanbao)
/*     */       {
/* 202 */         notifyFail(3);
/* 203 */         PartnerYuanshenLogger.error("PImproveYuanshen.improveYuanshen()@current yuanbao mismatch|roleid=%d|client_yuanbao=%d|server_yuanbao=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.currentYuanbao), Long.valueOf(currentYuanbao) });
/*     */         
/*     */ 
/* 206 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 211 */     Map<Integer, Integer> siftCfgId2LackedNum = new HashMap();
/* 212 */     TLogArg tLogArg = new TLogArg(LogReason.PARTNER_YUANSHEN_IMPROVE);
/* 213 */     for (Map.Entry<Integer, Integer> entry : improveProgressAndCost.siftCfgId2Num.entrySet())
/*     */     {
/* 215 */       SItemSiftCfg siftCfg = SItemSiftCfg.get(((Integer)entry.getKey()).intValue());
/* 216 */       if (siftCfg == null) {
/* 217 */         return false;
/*     */       }
/*     */       
/* 220 */       int removedNum = 0;
/* 221 */       List<Pair<Integer, BasicItem>> itemList = new ArrayList();
/* 222 */       for (IdTypeValueBean idTypeValueBean : siftCfg.idTypeValueBeans)
/*     */       {
/* 224 */         int itemId = idTypeValueBean.idvalue;
/* 225 */         Map<Integer, BasicItem> grid2item = ItemInterface.getItemByItemId(this.roleId, itemId, true);
/* 226 */         if (grid2item != null)
/*     */         {
/* 228 */           for (Map.Entry<Integer, BasicItem> e : grid2item.entrySet())
/* 229 */             itemList.add(new Pair(e.getKey(), e.getValue())); }
/*     */       }
/* 231 */       List<Pair<Integer, BasicItem>> bindedItemList = new ArrayList();
/* 232 */       List<Pair<Integer, BasicItem>> nonBindedItemList = new ArrayList();
/* 233 */       for (Pair<Integer, BasicItem> pair : itemList)
/*     */       {
/* 235 */         if (((BasicItem)pair.second).isBind()) {
/* 236 */           bindedItemList.add(pair);
/*     */         } else
/* 238 */           nonBindedItemList.add(pair);
/*     */       }
/* 240 */       itemList.clear();
/* 241 */       itemList.addAll(bindedItemList);
/* 242 */       itemList.addAll(nonBindedItemList);
/* 243 */       for (Pair<Integer, BasicItem> pair : itemList)
/*     */       {
/* 245 */         int grid = ((Integer)pair.first).intValue();
/* 246 */         int number = Math.min(((Integer)entry.getValue()).intValue() - removedNum, ((BasicItem)pair.second).getNumber());
/* 247 */         boolean result = ItemInterface.removeItemByGrid(this.roleId, 340600000, grid, number, tLogArg);
/* 248 */         if (!result)
/*     */         {
/* 250 */           notifyFail(1);
/* 251 */           PartnerYuanshenLogger.error("PImproveYuanshen.improveYuanshen()@remove item failed|roleid=%d|item_cfgid=%d|cost_num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(((BasicItem)pair.second).getCfgId()), Integer.valueOf(number) });
/*     */           
/*     */ 
/* 254 */           return false;
/*     */         }
/* 256 */         removedNum += number;
/* 257 */         if (removedNum == ((Integer)entry.getValue()).intValue()) {
/*     */           break;
/*     */         }
/*     */       }
/*     */       
/* 262 */       if (removedNum < ((Integer)entry.getValue()).intValue())
/*     */       {
/* 264 */         if (this.useYuanbao)
/*     */         {
/* 266 */           siftCfgId2LackedNum.put(entry.getKey(), Integer.valueOf(((Integer)entry.getValue()).intValue() - removedNum));
/*     */         }
/*     */         else
/*     */         {
/* 270 */           notifyFail(1);
/* 271 */           PartnerYuanshenLogger.error("PImproveYuanshen.improveYuanshen()@insufficient item|roleid=%d|sift_cfgid=%d|required_num=%d", new Object[] { Long.valueOf(this.roleId), entry.getKey(), entry.getValue() });
/*     */           
/*     */ 
/* 274 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 280 */     if (!siftCfgId2LackedNum.isEmpty())
/*     */     {
/*     */ 
/* 283 */       long requiredYuanbao = 0L;
/* 284 */       for (Map.Entry<Integer, Integer> entry : siftCfgId2LackedNum.entrySet())
/*     */       {
/* 286 */         SItemSiftCfg siftCfg = SItemSiftCfg.get(((Integer)entry.getKey()).intValue());
/* 287 */         if (siftCfg == null) {
/* 288 */           return false;
/*     */         }
/* 290 */         requiredYuanbao += getYuanbaoPriceFromSiftCfg(siftCfg) * ((Integer)entry.getValue()).intValue();
/*     */       }
/*     */       
/*     */ 
/* 294 */       if (requiredYuanbao == 0L)
/*     */       {
/* 296 */         PartnerYuanshenLogger.error("PImproveYuanshen.improveWithYuanbao()@zero yuanbao cost|position=%d", new Object[] { Integer.valueOf(this.position) });
/* 297 */         return false;
/*     */       }
/* 299 */       if (this.currentYuanbao < requiredYuanbao)
/*     */       {
/* 301 */         notifyFail(2);
/* 302 */         PartnerYuanshenLogger.error("PImproveYuanshen.improveYuanshen()@insufficient yuanbao|roleid=%d|position=%d|required_yuanbao=%d|current_yuanbao=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.position), Long.valueOf(requiredYuanbao), Long.valueOf(this.currentYuanbao) });
/*     */         
/*     */ 
/* 305 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 309 */       CostResult costResult = QingfuInterface.costYuanbao(userId, this.roleId, (int)requiredYuanbao, CostType.COST_BIND_FIRST_IMPROVE_PARTNER_YUANSHEN, new TLogArg(LogReason.PARTNER_YUANSHEN_IMPROVE));
/*     */       
/* 311 */       if (costResult != CostResult.Success)
/*     */       {
/* 313 */         notifyFail(2);
/* 314 */         PartnerYuanshenLogger.error("PImproveYuanshen.improveYuanshen()@charge yuanbao failed|roleid=%d|position=%d|required_yuanbao=%d|current_yuanbao=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.position), Long.valueOf(requiredYuanbao), Long.valueOf(this.currentYuanbao) });
/*     */         
/*     */ 
/* 317 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 322 */     xPartnerYuanshenPositionInfo.setLevel(improveProgressAndCost.level);
/* 323 */     xPartnerYuanshenPositionInfo.setProperty_num(improveProgressAndCost.propertyNum);
/*     */     
/* 325 */     notifySuccess(improveProgressAndCost.level, improveProgressAndCost.propertyNum);
/* 326 */     triggerPartnerYuanshenImproved(xPartnerYuanshenPositionInfo.getAttached_partner_id(), xPartnerYuanshenPositionInfo.getLevel(), xPartnerYuanshenPositionInfo.getProperty_num());
/*     */     
/*     */ 
/*     */ 
/* 330 */     PartnerYuanshenLogger.tlogImproveYuanshen(this.roleId, this.position, improveProgressAndCost.level, improveProgressAndCost.propertyNum);
/*     */     
/* 332 */     PartnerYuanshenLogger.info("PImproveYuanshen.improveYuanshen()@done|roleid=%d|position=%d|level=%d|propertyNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.position), Integer.valueOf(improveProgressAndCost.level), Integer.valueOf(improveProgressAndCost.propertyNum) });
/*     */     
/*     */ 
/* 335 */     return true;
/*     */   }
/*     */   
/*     */   private void notifySuccess(int level, int propertyNum)
/*     */   {
/* 340 */     SImproveSuccess sImproveSuccess = new SImproveSuccess();
/* 341 */     sImproveSuccess.position = this.position;
/* 342 */     sImproveSuccess.level = level;
/* 343 */     sImproveSuccess.property = propertyNum;
/* 344 */     OnlineManager.getInstance().send(this.roleId, sImproveSuccess);
/*     */   }
/*     */   
/*     */   private void notifyFail(int retcode)
/*     */   {
/* 349 */     SImproveFail sImproveFail = new SImproveFail();
/* 350 */     sImproveFail.retcode = retcode;
/* 351 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sImproveFail);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getYuanbaoPriceFromSiftCfg(SItemSiftCfg siftCfg)
/*     */   {
/* 359 */     int lastIndex = siftCfg.idTypeValueBeans.size() - 1;
/* 360 */     return ItemInterface.getItemYuanBaoPrice(((IdTypeValueBean)siftCfg.idTypeValueBeans.get(lastIndex)).idvalue);
/*     */   }
/*     */   
/*     */   private class ImproveProgressAndCost
/*     */   {
/*     */     int level;
/*     */     int propertyNum;
/*     */     Map<Integer, Integer> siftCfgId2Num;
/*     */     
/*     */     private ImproveProgressAndCost() {}
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partneryuanshen\main\PImproveYuanshen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */