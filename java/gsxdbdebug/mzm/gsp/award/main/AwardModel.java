/*     */ package mzm.gsp.award.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.award.AwardAddBean;
/*     */ import mzm.gsp.award.ExpAwardBean;
/*     */ import mzm.gsp.award.MoneyAwardBean;
/*     */ import mzm.gsp.award.confbean.SDoubleIItemDropFixAwardIdCfg;
/*     */ import mzm.gsp.award.confbean.SDoubleItemDropAwardIdCfg;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import xio.Protocol;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AwardModel
/*     */ {
/*     */   private long yuanbao;
/*     */   private long gold;
/*     */   private long silver;
/*     */   private long goldIngot;
/*  30 */   private int gang = 0;
/*  31 */   private Map<Integer, Integer> tokenMap = new HashMap();
/*     */   
/*     */   private int roleExp;
/*     */   
/*     */   private int petExp;
/*     */   
/*     */   private int xiuLianExp;
/*     */   
/*  39 */   private Map<Integer, Integer> itemMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  44 */   private Map<Integer, Set<Long>> item2uuids = new HashMap();
/*     */   
/*     */ 
/*  47 */   private Map<Integer, Map<Integer, Integer>> awardAddMap = new HashMap();
/*     */   
/*     */ 
/*     */   private int appellationId;
/*     */   
/*     */ 
/*     */   private int titleId;
/*     */   
/*     */   private List<Protocol> needSendProtocols;
/*     */   
/*  57 */   private AwardCfgValueBean originalValue = new AwardCfgValueBean();
/*     */   
/*     */   private int awardCfgId;
/*     */   
/*     */   private AwardType type;
/*     */   
/*  63 */   private boolean isZeroState = false;
/*     */   
/*     */   private int addEffectId;
/*     */   
/*     */   public AwardModel()
/*     */   {
/*  69 */     this.type = AwardType.DEFAULT;
/*     */   }
/*     */   
/*     */   public AwardModel(int awardCfgId, AwardType type)
/*     */   {
/*  74 */     this.awardCfgId = awardCfgId;
/*  75 */     this.type = type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isItemDoubleAward()
/*     */   {
/*  85 */     switch (getType())
/*     */     {
/*     */     case FIX: 
/*  88 */       return SDoubleIItemDropFixAwardIdCfg.get(getAwardId()) != null;
/*     */     case NORMAL: 
/*  90 */       return SDoubleItemDropAwardIdCfg.get(getAwardId()) != null;
/*     */     }
/*  92 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AwardCfgValueBean getOriginalValue()
/*     */   {
/* 103 */     return this.originalValue;
/*     */   }
/*     */   
/*     */   public static enum AwardType
/*     */   {
/* 108 */     NORMAL,  FIX,  DEFAULT;
/*     */     
/*     */     private AwardType() {}
/*     */   }
/*     */   
/*     */   public boolean isZeroState() {
/* 114 */     return this.isZeroState;
/*     */   }
/*     */   
/*     */   public void setZeroState(boolean isZeroState)
/*     */   {
/* 119 */     this.isZeroState = isZeroState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getAwardId()
/*     */   {
/* 129 */     return this.awardCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void setAwardId(int awardId)
/*     */   {
/* 139 */     this.awardCfgId = awardId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AwardType getType()
/*     */   {
/* 149 */     return this.type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void setType(AwardType type)
/*     */   {
/* 159 */     this.type = type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<Integer, Set<Long>> getAwardItemId2uuids()
/*     */   {
/* 169 */     Map<Integer, Set<Long>> item2uuidsTmp = new HashMap();
/* 170 */     if (this.item2uuids.size() == 0)
/*     */     {
/* 172 */       return item2uuidsTmp;
/*     */     }
/* 174 */     Iterator<Map.Entry<Integer, Set<Long>>> it = this.item2uuids.entrySet().iterator();
/* 175 */     while (it.hasNext())
/*     */     {
/* 177 */       Map.Entry<Integer, Set<Long>> entry = (Map.Entry)it.next();
/* 178 */       item2uuidsTmp.put(entry.getKey(), new HashSet((Collection)entry.getValue()));
/*     */     }
/* 180 */     return item2uuidsTmp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addAwardItemId2uuids(Map<Integer, Set<Long>> item2uuidsTmp)
/*     */   {
/* 190 */     if ((item2uuidsTmp == null) || (item2uuidsTmp.size() == 0))
/*     */     {
/* 192 */       return;
/*     */     }
/* 194 */     Iterator<Map.Entry<Integer, Set<Long>>> it = item2uuidsTmp.entrySet().iterator();
/* 195 */     while (it.hasNext())
/*     */     {
/* 197 */       Map.Entry<Integer, Set<Long>> entry = (Map.Entry)it.next();
/* 198 */       int itemId = ((Integer)entry.getKey()).intValue();
/* 199 */       Set<Long> uuids = (Set)this.item2uuids.get(Integer.valueOf(itemId));
/* 200 */       if (uuids == null)
/*     */       {
/* 202 */         uuids = new HashSet();
/* 203 */         this.item2uuids.put(Integer.valueOf(itemId), uuids);
/*     */       }
/* 205 */       uuids.addAll((Collection)entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   void addItem(List<Integer> items)
/*     */   {
/* 211 */     if ((items == null) || (items.size() == 0))
/*     */     {
/* 213 */       return;
/*     */     }
/* 215 */     for (Iterator i$ = items.iterator(); i$.hasNext();) { int itemId = ((Integer)i$.next()).intValue();
/*     */       
/* 217 */       if (this.itemMap.containsKey(Integer.valueOf(itemId)))
/*     */       {
/* 219 */         int count = ((Integer)this.itemMap.get(Integer.valueOf(itemId))).intValue() + 1;
/* 220 */         this.itemMap.put(Integer.valueOf(itemId), Integer.valueOf(count));
/*     */       }
/*     */       else
/*     */       {
/* 224 */         this.itemMap.put(Integer.valueOf(itemId), Integer.valueOf(1));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   void addToken(Map<Integer, Integer> addedMap)
/*     */   {
/* 231 */     for (Map.Entry<Integer, Integer> tokenEntry : addedMap.entrySet())
/*     */     {
/* 233 */       int value = ((Integer)tokenEntry.getValue()).intValue();
/* 234 */       if (this.tokenMap.containsKey(tokenEntry.getKey()))
/*     */       {
/* 236 */         value += ((Integer)this.tokenMap.get(tokenEntry.getKey())).intValue();
/* 237 */         this.tokenMap.put(tokenEntry.getKey(), Integer.valueOf(value));
/*     */       }
/*     */       else
/*     */       {
/* 241 */         this.tokenMap.put(tokenEntry.getKey(), Integer.valueOf(value));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   void addItem(Map<Integer, Integer> addedMap)
/*     */   {
/* 248 */     if ((addedMap == null) || (addedMap.size() == 0))
/*     */     {
/* 250 */       return;
/*     */     }
/* 252 */     for (Map.Entry<Integer, Integer> itemEntry : addedMap.entrySet())
/*     */     {
/* 254 */       int value = ((Integer)itemEntry.getValue()).intValue();
/* 255 */       if (this.itemMap.containsKey(itemEntry.getKey()))
/*     */       {
/* 257 */         value += ((Integer)this.itemMap.get(itemEntry.getKey())).intValue();
/* 258 */         this.itemMap.put(itemEntry.getKey(), Integer.valueOf(value));
/*     */       }
/*     */       else
/*     */       {
/* 262 */         this.itemMap.put(itemEntry.getKey(), Integer.valueOf(value));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   void add(AwardModel awardModel)
/*     */   {
/* 269 */     this.goldIngot += awardModel.goldIngot;
/* 270 */     this.gold += awardModel.getGold();
/* 271 */     this.silver += awardModel.getSilver();
/* 272 */     this.yuanbao += awardModel.getYuanbao();
/* 273 */     this.gang += awardModel.getGang();
/*     */     
/* 275 */     addToken(awardModel.getTokenMap());
/*     */     
/* 277 */     this.roleExp += awardModel.getRoleExp();
/* 278 */     this.petExp += awardModel.getPetExp();
/* 279 */     this.xiuLianExp += awardModel.getXiuLianExp();
/*     */     
/* 281 */     addItem(awardModel.getItemMap());
/*     */     
/* 283 */     this.appellationId = awardModel.getAppellationId();
/* 284 */     this.titleId = awardModel.getTitleId();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   ExpAwardBean getExpBeanByType(int type)
/*     */   {
/* 296 */     ExpAwardBean expAwardBean = new ExpAwardBean();
/* 297 */     expAwardBean.exptype = type;
/* 298 */     switch (type)
/*     */     {
/*     */     case 1: 
/* 301 */       expAwardBean.num = this.roleExp;
/* 302 */       break;
/*     */     
/*     */     case 3: 
/* 305 */       expAwardBean.num = this.xiuLianExp;
/* 306 */       break;
/*     */     case 2: 
/* 308 */       expAwardBean.num = this.petExp;
/* 309 */       break;
/*     */     default: 
/* 311 */       expAwardBean.num = 0;
/*     */     }
/*     */     
/*     */     
/* 315 */     if (expAwardBean.num == 0)
/*     */     {
/* 317 */       return null;
/*     */     }
/* 319 */     return expAwardBean;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   MoneyAwardBean getMoneybeanByType(int bigType, int littleType)
/*     */   {
/* 331 */     MoneyAwardBean moneyAwardBean = new MoneyAwardBean();
/* 332 */     moneyAwardBean.bigtype = bigType;
/* 333 */     moneyAwardBean.littletype = littleType;
/* 334 */     if (bigType == 1)
/*     */     {
/* 336 */       switch (littleType)
/*     */       {
/*     */       case 1: 
/* 339 */         moneyAwardBean.num = this.yuanbao;
/* 340 */         break;
/*     */       case 2: 
/* 342 */         moneyAwardBean.num = this.gold;
/* 343 */         break;
/*     */       case 3: 
/* 345 */         moneyAwardBean.num = this.silver;
/* 346 */         break;
/*     */       case 4: 
/* 348 */         moneyAwardBean.num = this.gang;
/* 349 */         break;
/*     */       case 5: 
/* 351 */         moneyAwardBean.num = this.goldIngot;
/* 352 */         break;
/*     */       
/*     */       default: 
/* 355 */         moneyAwardBean.num = 0L;
/*     */       }
/*     */       
/*     */       
/* 359 */       if (moneyAwardBean.num == 0L)
/*     */       {
/* 361 */         return null;
/*     */       }
/* 363 */       return moneyAwardBean;
/*     */     }
/*     */     
/* 366 */     if (bigType == 2)
/*     */     {
/* 368 */       Integer tokenNum = (Integer)this.tokenMap.get(Integer.valueOf(littleType));
/* 369 */       if (tokenNum == null)
/*     */       {
/* 371 */         return null;
/*     */       }
/* 373 */       moneyAwardBean.num = tokenNum.intValue();
/* 374 */       return moneyAwardBean;
/*     */     }
/* 376 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void fillAllExpBeans(List<ExpAwardBean> expAwardBeans)
/*     */   {
/* 386 */     addXExp2Beans(expAwardBeans, 1, this.roleExp);
/* 387 */     addXExp2Beans(expAwardBeans, 2, this.petExp);
/* 388 */     addXExp2Beans(expAwardBeans, 3, this.xiuLianExp);
/*     */   }
/*     */   
/*     */   void addXExp2Beans(List<ExpAwardBean> expAwardBeans, int expType, int value)
/*     */   {
/* 393 */     if (value <= 0)
/*     */     {
/* 395 */       return;
/*     */     }
/* 397 */     expAwardBeans.add(new ExpAwardBean(expType, value));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void fillAllCurrencyBeans(List<MoneyAwardBean> moneyAwardBeans)
/*     */   {
/* 407 */     fillMoneyAwardBeans(moneyAwardBeans);
/* 408 */     fillTokenAwardBeans(moneyAwardBeans);
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
/*     */   private void fillCurrencyBeans(List<MoneyAwardBean> moneyAwardBeans, int bigType, int littleType, long num)
/*     */   {
/* 421 */     if (num <= 0L)
/*     */     {
/* 423 */       return;
/*     */     }
/* 425 */     moneyAwardBeans.add(new MoneyAwardBean(bigType, littleType, num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<MoneyAwardBean> getMoneyAwardBeans()
/*     */   {
/* 435 */     List<MoneyAwardBean> moneyAwardBeans = new ArrayList();
/* 436 */     addAllMoney(moneyAwardBeans);
/* 437 */     return moneyAwardBeans;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void fillMoneyAwardBeans(List<MoneyAwardBean> moneyAwardBeans)
/*     */   {
/* 447 */     addAllMoney(moneyAwardBeans);
/*     */   }
/*     */   
/*     */   private void addAllMoney(List<MoneyAwardBean> moneyAwardBeans)
/*     */   {
/* 452 */     fillCurrencyBeans(moneyAwardBeans, 1, 1, this.yuanbao);
/* 453 */     fillCurrencyBeans(moneyAwardBeans, 1, 2, this.gold);
/* 454 */     fillCurrencyBeans(moneyAwardBeans, 1, 3, this.silver);
/* 455 */     fillCurrencyBeans(moneyAwardBeans, 1, 4, this.gang);
/* 456 */     fillCurrencyBeans(moneyAwardBeans, 1, 5, this.goldIngot);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<MoneyAwardBean> getTokenAwardBeans()
/*     */   {
/* 466 */     List<MoneyAwardBean> tokenAwardBeans = new ArrayList();
/* 467 */     fillTokenAwardBeans(tokenAwardBeans);
/* 468 */     return tokenAwardBeans;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void fillTokenAwardBeans(List<MoneyAwardBean> tokenAwardBeans)
/*     */   {
/* 478 */     Iterator<Map.Entry<Integer, Integer>> it = this.tokenMap.entrySet().iterator();
/* 479 */     while (it.hasNext())
/*     */     {
/* 481 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 482 */       fillCurrencyBeans(tokenAwardBeans, 2, ((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue());
/*     */     }
/*     */   }
/*     */   
/*     */   void setRoleExp(int roleExp)
/*     */   {
/* 488 */     this.roleExp = roleExp;
/*     */   }
/*     */   
/*     */   void setPetExp(int petExp)
/*     */   {
/* 493 */     this.petExp = petExp;
/*     */   }
/*     */   
/*     */   void setGold(int gold)
/*     */   {
/* 498 */     this.gold = gold;
/*     */   }
/*     */   
/*     */   void setSilver(int silver)
/*     */   {
/* 503 */     this.silver = silver;
/*     */   }
/*     */   
/*     */   void setYuanBao(int yuanbao)
/*     */   {
/* 508 */     this.yuanbao = yuanbao;
/*     */   }
/*     */   
/*     */   public int getRoleExp()
/*     */   {
/* 513 */     return this.roleExp;
/*     */   }
/*     */   
/*     */   public int getPetExp()
/*     */   {
/* 518 */     return this.petExp;
/*     */   }
/*     */   
/*     */   public int getGang()
/*     */   {
/* 523 */     return this.gang;
/*     */   }
/*     */   
/*     */   public void setGang(int gang)
/*     */   {
/* 528 */     this.gang = gang;
/*     */   }
/*     */   
/*     */   public long getGoldIngot()
/*     */   {
/* 533 */     return this.goldIngot;
/*     */   }
/*     */   
/*     */   public void setGoldIngot(long goldIngot)
/*     */   {
/* 538 */     this.goldIngot = goldIngot;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getItemMap()
/*     */   {
/* 548 */     return this.itemMap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getTokenMap()
/*     */   {
/* 558 */     return this.tokenMap;
/*     */   }
/*     */   
/*     */   public long getYuanbao()
/*     */   {
/* 563 */     return this.yuanbao;
/*     */   }
/*     */   
/*     */   public long getGold()
/*     */   {
/* 568 */     return this.gold;
/*     */   }
/*     */   
/*     */   public long getSilver()
/*     */   {
/* 573 */     return this.silver;
/*     */   }
/*     */   
/*     */   public int getAppellationId()
/*     */   {
/* 578 */     return this.appellationId;
/*     */   }
/*     */   
/*     */   public void setAppellationId(int appellationId)
/*     */   {
/* 583 */     this.appellationId = appellationId;
/*     */   }
/*     */   
/*     */   public int getTitleId()
/*     */   {
/* 588 */     return this.titleId;
/*     */   }
/*     */   
/*     */   public void setTitleId(int titleId)
/*     */   {
/* 593 */     this.titleId = titleId;
/*     */   }
/*     */   
/*     */   public int getXiuLianExp()
/*     */   {
/* 598 */     return this.xiuLianExp;
/*     */   }
/*     */   
/*     */   public void setXiuLianExp(int xiuLianExp)
/*     */   {
/* 603 */     this.xiuLianExp = xiuLianExp;
/*     */   }
/*     */   
/*     */   int getAddEffectId()
/*     */   {
/* 608 */     return this.addEffectId;
/*     */   }
/*     */   
/*     */   void setAddEffectId(int addEffectId)
/*     */   {
/* 613 */     this.addEffectId = addEffectId;
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
/*     */   public int getAwardAddNum(int bigType, int littleType)
/*     */   {
/* 627 */     Map<Integer, Integer> addValues = (Map)this.awardAddMap.get(Integer.valueOf(bigType));
/* 628 */     if ((addValues == null) || (addValues.size() == 0))
/*     */     {
/* 630 */       return 0;
/*     */     }
/* 632 */     Integer num = (Integer)addValues.get(Integer.valueOf(littleType));
/* 633 */     if (num == null)
/*     */     {
/* 635 */       return 0;
/*     */     }
/* 637 */     return num.intValue();
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
/*     */   public void addAwardAddNum(int bigType, int littleType, double value)
/*     */   {
/* 651 */     if (value <= 0.0D)
/*     */     {
/* 653 */       return;
/*     */     }
/* 655 */     Map<Integer, Integer> addValues = (Map)this.awardAddMap.get(Integer.valueOf(bigType));
/* 656 */     if (addValues == null)
/*     */     {
/* 658 */       addValues = new HashMap();
/* 659 */       this.awardAddMap.put(Integer.valueOf(bigType), addValues);
/*     */     }
/* 661 */     addValues.put(Integer.valueOf(littleType), Integer.valueOf(RoleAwardManager.parseDouble(value)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public HashMap<Integer, AwardAddBean> getAwardAddMap()
/*     */   {
/* 671 */     HashMap<Integer, AwardAddBean> awardAddMap = new HashMap();
/*     */     
/* 673 */     if ((this.awardAddMap == null) || (this.awardAddMap.size() == 0))
/*     */     {
/* 675 */       return awardAddMap;
/*     */     }
/*     */     
/* 678 */     Iterator<Map.Entry<Integer, Map<Integer, Integer>>> it = this.awardAddMap.entrySet().iterator();
/*     */     
/* 680 */     while (it.hasNext())
/*     */     {
/* 682 */       Map.Entry<Integer, Map<Integer, Integer>> entry_awardType = (Map.Entry)it.next();
/* 683 */       int bigType = ((Integer)entry_awardType.getKey()).intValue();
/* 684 */       Map<Integer, Integer> addValues = (Map)entry_awardType.getValue();
/* 685 */       if ((addValues != null) && (addValues.size() != 0))
/*     */       {
/*     */ 
/*     */ 
/* 689 */         AwardAddBean awardAddBean = new AwardAddBean();
/* 690 */         for (Map.Entry<Integer, Integer> entry : addValues.entrySet())
/*     */         {
/* 692 */           awardAddBean.addvalues.put(entry.getKey(), entry.getValue());
/*     */         }
/* 694 */         if ((awardAddBean.addvalues != null) && (awardAddBean.addvalues.size() != 0))
/*     */         {
/*     */ 
/*     */ 
/* 698 */           awardAddMap.put(Integer.valueOf(bigType), awardAddBean); }
/*     */       }
/*     */     }
/* 701 */     return awardAddMap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   MailAttachment getMailAttachment(boolean isItemBind)
/*     */   {
/* 711 */     MailAttachment attchMent = new MailAttachment();
/* 712 */     fillMailAttchMent(attchMent, isItemBind);
/* 713 */     return attchMent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void fillMailAttchMent(MailAttachment attchMent, boolean isItemBind)
/*     */   {
/* 724 */     attchMent.setBindYuanBao((int)(attchMent.getBindYuanBao() + this.yuanbao));
/* 725 */     attchMent.setGold((int)(attchMent.getGold() + this.gold));
/* 726 */     attchMent.setGoldIngot((int)(attchMent.getGoldIngot() + this.goldIngot));
/* 727 */     attchMent.setSilver((int)(attchMent.getSilver() + this.silver));
/* 728 */     attchMent.setRoleExp(attchMent.getRoleExp() + this.roleExp);
/* 729 */     attchMent.setPetExp(attchMent.getPetExp() + this.petExp);
/* 730 */     attchMent.setXiuLianExp(attchMent.getXiuLianExp() + this.xiuLianExp);
/* 731 */     attchMent.addItemMap(this.itemMap, isItemBind);
/* 732 */     attchMent.addTokeMap(this.tokenMap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static AwardModel getAwardModel(AwardPoolResultData awardPoolResultData)
/*     */   {
/* 743 */     AwardModel awardModel = new AwardModel();
/* 744 */     awardModel.setYuanBao(awardPoolResultData.getYuanbao());
/* 745 */     awardModel.setGold(awardPoolResultData.getGold());
/* 746 */     awardModel.setSilver(awardPoolResultData.getSilver());
/* 747 */     awardModel.setGang(awardPoolResultData.getGang());
/* 748 */     awardModel.setRoleExp(awardPoolResultData.getRoleExp());
/* 749 */     awardModel.setPetExp(awardPoolResultData.getPetExp());
/* 750 */     awardModel.setXiuLianExp(awardPoolResultData.getXiuLianExp());
/* 751 */     awardModel.addItem(awardPoolResultData.getItemMap());
/* 752 */     return awardModel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void addNeedSendProtocols(List<Protocol> pros)
/*     */   {
/* 762 */     if ((pros == null) || (pros.size() == 0))
/*     */     {
/* 764 */       return;
/*     */     }
/* 766 */     if (this.needSendProtocols == null)
/*     */     {
/* 768 */       this.needSendProtocols = new ArrayList();
/*     */     }
/* 770 */     this.needSendProtocols.addAll(pros);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Protocol> getNeedSendProtocols()
/*     */   {
/* 780 */     return this.needSendProtocols;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void sendAwardExtroProtocols(long roleId)
/*     */   {
/* 790 */     List<Protocol> needSendProtocols = getNeedSendProtocols();
/* 791 */     if ((needSendProtocols == null) || (needSendProtocols.size() == 0))
/*     */     {
/* 793 */       return;
/*     */     }
/* 795 */     for (Protocol protocol : needSendProtocols)
/*     */     {
/* 797 */       OnlineManager.getInstance().send(roleId, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\AwardModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */