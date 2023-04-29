/*     */ package mzm.gsp.mail.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import xbean.Item;
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
/*     */ 
/*     */ public class MailAttachment
/*     */ {
/*     */   private int bindYuanBao;
/*     */   private int yuanBao;
/*     */   private int gold;
/*     */   private int goldIngot;
/*     */   private int silver;
/*     */   private int roleExp;
/*     */   private int petExp;
/*     */   private int xiuLianExp;
/*     */   private int storeExp;
/*     */   private int vigor;
/*  46 */   private Map<Integer, Integer> itemMap = new HashMap();
/*     */   
/*  48 */   private Set<Integer> bindingItems = new HashSet();
/*     */   
/*  50 */   private List<Item> xitems = new ArrayList();
/*     */   
/*  52 */   private Map<Integer, Integer> tokenMap = new HashMap();
/*     */   
/*     */ 
/*     */   public MailAttachment(MailAttachment mailAttachment)
/*     */   {
/*  57 */     if (mailAttachment != null) {
/*  58 */       this.yuanBao = mailAttachment.getYuanBao();
/*  59 */       this.bindYuanBao = mailAttachment.getBindYuanBao();
/*  60 */       this.gold = mailAttachment.getGold();
/*  61 */       this.goldIngot = mailAttachment.getGoldIngot();
/*  62 */       this.silver = mailAttachment.getSilver();
/*  63 */       this.vigor = mailAttachment.getVigor();
/*  64 */       this.roleExp = mailAttachment.getRoleExp();
/*  65 */       this.petExp = mailAttachment.getPetExp();
/*  66 */       this.xiuLianExp = mailAttachment.getXiuLianExp();
/*  67 */       this.storeExp = mailAttachment.getStoreExp();
/*  68 */       this.itemMap.putAll(mailAttachment.getItemMap());
/*  69 */       this.bindingItems.addAll(mailAttachment.getBindItems());
/*  70 */       this.xitems.addAll(mailAttachment.getXitems());
/*  71 */       this.tokenMap.putAll(mailAttachment.getTokenMap());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public MailAttachment() {}
/*     */   
/*     */   public int getGold()
/*     */   {
/*  80 */     return this.gold;
/*     */   }
/*     */   
/*     */   public void setGoldIngot(int goldIngot) {
/*  84 */     this.goldIngot = goldIngot;
/*     */   }
/*     */   
/*     */   public int getGoldIngot() {
/*  88 */     return this.goldIngot;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getBindYuanBao()
/*     */   {
/*  96 */     return this.bindYuanBao;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBindYuanBao(int bindYuanBao)
/*     */   {
/* 105 */     this.bindYuanBao = bindYuanBao;
/*     */   }
/*     */   
/*     */   public int getYuanBao() {
/* 109 */     return this.yuanBao;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setYuanBao(int yuanBao)
/*     */   {
/* 118 */     this.yuanBao = yuanBao;
/*     */   }
/*     */   
/*     */   public int getSilver() {
/* 122 */     return this.silver;
/*     */   }
/*     */   
/*     */   public void setSilver(int silver) {
/* 126 */     this.silver = silver;
/*     */   }
/*     */   
/*     */   public void setGold(int gold) {
/* 130 */     this.gold = gold;
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
/*     */   Map<Integer, Integer> getItemMap()
/*     */   {
/* 143 */     return this.itemMap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void setItemMap(Map<Integer, Integer> itemMap)
/*     */   {
/* 152 */     this.itemMap = itemMap;
/*     */   }
/*     */   
/*     */   List<Item> getXitems() {
/* 156 */     return this.xitems;
/*     */   }
/*     */   
/*     */   Map<Integer, Integer> getTokenMap() {
/* 160 */     return this.tokenMap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void setTokenMap(Map<Integer, Integer> tokenMap)
/*     */   {
/* 169 */     this.tokenMap = tokenMap;
/*     */   }
/*     */   
/*     */   public int getRoleExp() {
/* 173 */     return this.roleExp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRoleExp(int roleExp)
/*     */   {
/* 182 */     this.roleExp = roleExp;
/*     */   }
/*     */   
/*     */   public int getPetExp() {
/* 186 */     return this.petExp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPetExp(int petExp)
/*     */   {
/* 195 */     this.petExp = petExp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getXiuLianExp()
/*     */   {
/* 204 */     return this.xiuLianExp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setXiuLianExp(int xiuLianExp)
/*     */   {
/* 213 */     this.xiuLianExp = xiuLianExp;
/*     */   }
/*     */   
/*     */   public int getStoreExp() {
/* 217 */     return this.storeExp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setStoreExp(int storeExp)
/*     */   {
/* 226 */     this.storeExp = storeExp;
/*     */   }
/*     */   
/*     */   public int getVigor() {
/* 230 */     return this.vigor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVigor(int vigor)
/*     */   {
/* 239 */     this.vigor = vigor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addItemMap(Map<Integer, Integer> addItemMap)
/*     */   {
/* 248 */     addItemMap(addItemMap, false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addItemMap(Map<Integer, Integer> addItemMap, boolean bind)
/*     */   {
/* 258 */     for (Map.Entry<Integer, Integer> itemEntry : addItemMap.entrySet()) {
/* 259 */       int itemid = ((Integer)itemEntry.getKey()).intValue();
/* 260 */       if (this.itemMap.containsKey(Integer.valueOf(itemid))) {
/* 261 */         int itemCount = ((Integer)itemEntry.getValue()).intValue() + ((Integer)this.itemMap.get(Integer.valueOf(itemid))).intValue();
/* 262 */         this.itemMap.put(Integer.valueOf(itemid), Integer.valueOf(itemCount));
/*     */       } else {
/* 264 */         this.itemMap.put(Integer.valueOf(itemid), itemEntry.getValue());
/*     */       }
/*     */     }
/* 267 */     if (bind) {
/* 268 */       this.bindingItems.addAll(addItemMap.keySet());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addItem(int itemId, int count)
/*     */   {
/* 279 */     if (this.itemMap.containsKey(Integer.valueOf(itemId))) {
/* 280 */       int itemCount = count + ((Integer)this.itemMap.get(Integer.valueOf(itemId))).intValue();
/* 281 */       this.itemMap.put(Integer.valueOf(itemId), Integer.valueOf(itemCount));
/*     */     } else {
/* 283 */       this.itemMap.put(Integer.valueOf(itemId), Integer.valueOf(count));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addItem(int itemId, int count, boolean bind)
/*     */   {
/* 295 */     if (this.itemMap.containsKey(Integer.valueOf(itemId))) {
/* 296 */       int itemCount = count + ((Integer)this.itemMap.get(Integer.valueOf(itemId))).intValue();
/* 297 */       this.itemMap.put(Integer.valueOf(itemId), Integer.valueOf(itemCount));
/*     */     } else {
/* 299 */       this.itemMap.put(Integer.valueOf(itemId), Integer.valueOf(count));
/*     */     }
/* 301 */     if (bind) {
/* 302 */       this.bindingItems.add(Integer.valueOf(itemId));
/*     */     }
/*     */   }
/*     */   
/*     */   public Set<Integer> getBindItems() {
/* 307 */     return this.bindingItems;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addXItem(Item xItem)
/*     */   {
/* 316 */     this.xitems.add(xItem);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addXItem(List<Item> xItems)
/*     */   {
/* 325 */     this.xitems.addAll(xItems);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isHasItem()
/*     */   {
/* 334 */     return (this.xitems.size() > 0) || (this.itemMap.size() > 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isHasCurrency()
/*     */   {
/* 343 */     return (this.gold > 0) || (this.goldIngot > 0) || (this.bindYuanBao > 0) || (this.silver > 0) || (this.yuanBao > 0) || (this.tokenMap.size() > 0) || (this.vigor > 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addTokeMap(Map<Integer, Integer> addTokenMap)
/*     */   {
/* 354 */     for (Map.Entry<Integer, Integer> tokenEntry : addTokenMap.entrySet()) {
/* 355 */       if (this.tokenMap.containsKey(tokenEntry.getKey())) {
/* 356 */         int tokenCount = ((Integer)tokenEntry.getValue()).intValue() + ((Integer)this.tokenMap.get(tokenEntry.getKey())).intValue();
/* 357 */         this.tokenMap.put(tokenEntry.getKey(), Integer.valueOf(tokenCount));
/*     */       } else {
/* 359 */         this.tokenMap.put(tokenEntry.getKey(), tokenEntry.getValue());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addToken(int tokenType, int count)
/*     */   {
/* 372 */     if (this.tokenMap.containsKey(Integer.valueOf(tokenType))) {
/* 373 */       int tokenCount = count + ((Integer)this.tokenMap.get(Integer.valueOf(tokenType))).intValue();
/* 374 */       this.tokenMap.put(Integer.valueOf(tokenType), Integer.valueOf(tokenCount));
/*     */     } else {
/* 376 */       this.tokenMap.put(Integer.valueOf(tokenType), Integer.valueOf(count));
/*     */     }
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 382 */     StringBuilder _sb_ = new StringBuilder();
/* 383 */     _sb_.append("(");
/* 384 */     _sb_.append(this.yuanBao);
/* 385 */     _sb_.append("|");
/* 386 */     _sb_.append(this.bindYuanBao);
/* 387 */     _sb_.append("|");
/* 388 */     _sb_.append(this.gold);
/* 389 */     _sb_.append("|");
/* 390 */     _sb_.append(this.goldIngot);
/* 391 */     _sb_.append("|");
/* 392 */     _sb_.append(this.silver);
/* 393 */     _sb_.append("|");
/* 394 */     _sb_.append(this.vigor);
/* 395 */     _sb_.append("|");
/* 396 */     _sb_.append(this.roleExp);
/* 397 */     _sb_.append("|");
/* 398 */     _sb_.append(this.petExp);
/* 399 */     _sb_.append("|");
/* 400 */     _sb_.append(this.xiuLianExp);
/* 401 */     _sb_.append("|");
/* 402 */     _sb_.append(this.storeExp);
/* 403 */     _sb_.append("|");
/* 404 */     _sb_.append(this.itemMap);
/* 405 */     _sb_.append("|");
/* 406 */     _sb_.append(this.bindingItems);
/* 407 */     _sb_.append("|");
/* 408 */     _sb_.append(this.xitems);
/* 409 */     _sb_.append("|");
/* 410 */     _sb_.append(this.tokenMap);
/* 411 */     _sb_.append(")");
/* 412 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mail\main\MailAttachment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */