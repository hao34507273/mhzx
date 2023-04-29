/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.item.SBanTradeRes;
/*     */ import mzm.gsp.item.event.BanTradeEvent;
/*     */ import mzm.gsp.item.event.TradeArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.BanTradeItems;
/*     */ import xtable.Tradetype2banitems;
/*     */ 
/*     */ public class ItemBanTrade
/*     */ {
/*  23 */   private static final ItemBanTrade instance = new ItemBanTrade();
/*     */   
/*     */   public static ItemBanTrade getInstance()
/*     */   {
/*  27 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  35 */   private final Map<Integer, Set<Integer>> tradeType2BanIds = new HashMap();
/*     */   
/*  37 */   private final ReadWriteLock locker = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*     */   
/*     */   void initBanData(int tradeType, Set<Integer> banIdSet)
/*     */   {
/*     */     try
/*     */     {
/*  43 */       this.locker.writeLock().lock();
/*     */       
/*  45 */       this.tradeType2BanIds.put(Integer.valueOf(tradeType), banIdSet);
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/*  50 */       this.locker.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   void initFromXdbOnStartUp()
/*     */   {
/*  56 */     for (Iterator i$ = TradeTypeEnum.getTradeTypeSet().iterator(); i$.hasNext();) { int tradeType = ((Integer)i$.next()).intValue();
/*     */       
/*  58 */       new InitFromXdb(tradeType).execute();
/*     */     }
/*     */   }
/*     */   
/*     */   private static class InitFromXdb
/*     */     extends LogicProcedure
/*     */   {
/*     */     private int tradeType;
/*     */     
/*     */     public InitFromXdb(int tradeType)
/*     */     {
/*  69 */       this.tradeType = tradeType;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  75 */       long key = GameServerInfoManager.toGlobalId(this.tradeType);
/*  76 */       BanTradeItems xBanTradeItems = Tradetype2banitems.select(Long.valueOf(key));
/*  77 */       if (xBanTradeItems == null)
/*     */       {
/*  79 */         return false;
/*     */       }
/*     */       
/*  82 */       ItemBanTrade.getInstance().initBanData(this.tradeType, new HashSet(xBanTradeItems.getItemids()));
/*  83 */       return true;
/*     */     }
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
/*     */   public void sendTipToTole(long roleid, String itemName)
/*     */     throws UnsupportedEncodingException
/*     */   {
/*  98 */     SBanTradeRes msg = new SBanTradeRes();
/*  99 */     msg.name.setString(itemName, "UTF-8");
/* 100 */     OnlineManager.getInstance().sendAtOnce(roleid, msg);
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
/*     */ 
/*     */   public boolean isBanTrade(int tradeType, int id)
/*     */   {
/*     */     try
/*     */     {
/* 118 */       this.locker.readLock().lock();
/*     */       
/* 120 */       Set<Integer> itemIdSet = (Set)this.tradeType2BanIds.get(Integer.valueOf(tradeType));
/* 121 */       boolean bool; if (itemIdSet == null)
/*     */       {
/* 123 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 127 */       return itemIdSet.contains(Integer.valueOf(id));
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/*     */ 
/* 133 */       this.locker.readLock().unlock();
/*     */     }
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
/*     */   public Set<Integer> getBanTradeIds(int tradeType)
/*     */   {
/*     */     try
/*     */     {
/* 149 */       this.locker.readLock().lock();
/*     */       
/* 151 */       Set<Integer> itemIdSet = (Set)this.tradeType2BanIds.get(Integer.valueOf(tradeType));
/* 152 */       HashSet localHashSet; if (itemIdSet == null)
/*     */       {
/* 154 */         return new HashSet();
/*     */       }
/*     */       
/*     */ 
/* 158 */       return new HashSet(itemIdSet);
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/*     */ 
/* 164 */       this.locker.readLock().unlock();
/*     */     }
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
/*     */ 
/*     */   public boolean banTrade(int tradeType, int id)
/*     */   {
/* 181 */     BanItemPro pro = new BanItemPro(tradeType, id, true);
/* 182 */     if (!pro.call())
/*     */     {
/* 184 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 188 */       this.locker.writeLock().lock();
/* 189 */       Set<Integer> itemIdSet = (Set)this.tradeType2BanIds.get(Integer.valueOf(tradeType));
/* 190 */       if (itemIdSet == null)
/*     */       {
/* 192 */         itemIdSet = new HashSet();
/* 193 */         this.tradeType2BanIds.put(Integer.valueOf(tradeType), itemIdSet);
/*     */       }
/* 195 */       itemIdSet.add(Integer.valueOf(id));
/*     */       
/* 197 */       return true;
/*     */     }
/*     */     finally
/*     */     {
/* 201 */       this.locker.writeLock().unlock();
/*     */     }
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
/*     */   public boolean unBanTrade(int tradeType, int id)
/*     */   {
/* 217 */     BanItemPro pro = new BanItemPro(tradeType, id, false);
/* 218 */     if (!pro.call())
/*     */     {
/* 220 */       return false;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 225 */       this.locker.writeLock().lock();
/* 226 */       Set<Integer> itemIdSet = (Set)this.tradeType2BanIds.get(Integer.valueOf(tradeType));
/* 227 */       if (itemIdSet != null)
/*     */       {
/* 229 */         itemIdSet.remove(Integer.valueOf(id));
/* 230 */         if (itemIdSet.isEmpty())
/*     */         {
/* 232 */           this.tradeType2BanIds.remove(Integer.valueOf(tradeType));
/*     */         }
/*     */       }
/*     */       
/* 236 */       return true;
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/* 241 */       this.locker.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   private static class BanItemPro
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final int itemId;
/*     */     private final boolean isBanTrade;
/*     */     private final int tradeType;
/*     */     
/*     */     public BanItemPro(int tradeType, int itemId, boolean isBanTrade)
/*     */     {
/* 254 */       this.tradeType = tradeType;
/* 255 */       this.itemId = itemId;
/* 256 */       this.isBanTrade = isBanTrade;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 263 */       long key = GameServerInfoManager.toGlobalId(this.tradeType);
/*     */       
/* 265 */       BanTradeItems xBanTradeItems = Tradetype2banitems.get(Long.valueOf(key));
/* 266 */       if (xBanTradeItems == null)
/*     */       {
/* 268 */         xBanTradeItems = xbean.Pod.newBanTradeItems();
/* 269 */         Tradetype2banitems.insert(Long.valueOf(key), xBanTradeItems);
/*     */       }
/* 271 */       if (this.isBanTrade)
/*     */       {
/* 273 */         xBanTradeItems.getItemids().add(Integer.valueOf(this.itemId));
/* 274 */         TriggerEventsManger.getInstance().triggerEvent(new BanTradeEvent(), new TradeArg(this.itemId, this.tradeType, ItemBanTrade.TradeStateEnum.BANTRADE.value));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 279 */         xBanTradeItems.getItemids().remove(Integer.valueOf(this.itemId));
/* 280 */         TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.item.event.UnBanTradeEvent(), new TradeArg(this.itemId, this.tradeType, ItemBanTrade.TradeStateEnum.NORMAL.value));
/*     */       }
/*     */       
/* 283 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   public static enum TradeTypeEnum
/*     */   {
/* 289 */     BAITAN(1), 
/* 290 */     MALL(2), 
/* 291 */     MARKET_ITEM(3), 
/* 292 */     SHANGHUI(4), 
/* 293 */     JIFEN_EXCHANGE(5), 
/* 294 */     PET_SHOP(6), 
/* 295 */     MARKET_PET(7), 
/* 296 */     NPC_SHOP_ITEM(8);
/*     */     
/*     */     public final int value;
/* 299 */     private static final Set<Integer> typeSet = new HashSet();
/*     */     
/*     */     private TradeTypeEnum(int value)
/*     */     {
/* 303 */       this.value = value;
/*     */     }
/*     */     
/*     */ 
/*     */     public static void checkTradeType()
/*     */     {
/* 309 */       for (TradeTypeEnum type : )
/*     */       {
/* 311 */         if (typeSet.contains(Integer.valueOf(type.value))) {
/* 312 */           throw new RuntimeException(String.format("TradeTypeEnum中定义的常量重复,name=%s,value=%d", new Object[] { type.name(), Integer.valueOf(type.value) }));
/*     */         }
/* 314 */         typeSet.add(Integer.valueOf(type.value));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     public static Set<Integer> getTradeTypeSet()
/*     */     {
/* 321 */       return new HashSet(typeSet);
/*     */     }
/*     */   }
/*     */   
/*     */   public static enum TradeStateEnum
/*     */   {
/* 327 */     BANTRADE(0), 
/* 328 */     NORMAL(1);
/*     */     
/*     */     public final int value;
/*     */     
/*     */     private TradeStateEnum(int value)
/*     */     {
/* 334 */       this.value = value;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\ItemBanTrade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */