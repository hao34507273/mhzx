/*     */ package mzm.gsp.award.gift;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.SGetGiftRep;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AwarGiftInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GlobalGiftManager
/*     */ {
/*  24 */   private static final ReadWriteLock useType2GlobalRwLock = new ReentrantReadWriteLock();
/*  25 */   private static final Map<Integer, Integer> useType2Global = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addAllGlobalInfo(Map<Integer, Integer> _useType2Global)
/*     */   {
/*  36 */     useType2GlobalRwLock.writeLock().lock();
/*     */     try
/*     */     {
/*  39 */       useType2Global.putAll(_useType2Global);
/*     */     }
/*     */     finally
/*     */     {
/*  43 */       useType2GlobalRwLock.writeLock().unlock();
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
/*     */   static void setNewValue(int useType, int newValue)
/*     */   {
/*  56 */     useType2GlobalRwLock.writeLock().lock();
/*     */     try
/*     */     {
/*  59 */       useType2Global.put(Integer.valueOf(useType), Integer.valueOf(newValue));
/*     */     }
/*     */     finally
/*     */     {
/*  63 */       useType2GlobalRwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getUseTypeGlobal(int useType)
/*     */   {
/*  75 */     useType2GlobalRwLock.readLock().lock();
/*     */     try
/*     */     {
/*  78 */       Integer global = (Integer)useType2Global.get(Integer.valueOf(useType));
/*  79 */       return global == null ? -1 : global.intValue();
/*     */     }
/*     */     finally
/*     */     {
/*  83 */       useType2GlobalRwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public static ResetGiftRes initXAwardGlobal(int useType)
/*     */   {
/*  89 */     if (useType <= 0)
/*     */     {
/*  91 */       return new ResetGiftRes(false, ResetGiftRes.ResetRes.ERROR__OTHER);
/*     */     }
/*     */     
/*  94 */     AwarGiftInfo xAwarGiftInfo = GiftManager.getAwarGiftIfNotExist();
/*  95 */     Map<Integer, Integer> xUseType2Global = xAwarGiftInfo.getType2global();
/*  96 */     Integer xGlobal = (Integer)xUseType2Global.get(Integer.valueOf(useType));
/*  97 */     if (xGlobal == null)
/*     */     {
/*  99 */       GameServer.logger().error(String.format("[gift]GlobalGiftManager.modGlobalData@ xGlobal not contains this useType!|useType=%d", new Object[] { Integer.valueOf(useType) }));
/*     */       
/*     */ 
/* 102 */       return new ResetGiftRes(false, ResetGiftRes.ResetRes.ERROR__ILLEGAL_USE_TYPE);
/*     */     }
/* 104 */     int newValue = xGlobal.intValue() + 1;
/* 105 */     xUseType2Global.put(Integer.valueOf(useType), Integer.valueOf(newValue));
/*     */     
/*     */ 
/* 108 */     setNewValue(useType, newValue);
/*     */     
/*     */ 
/* 111 */     SGetGiftRep pro = new SGetGiftRep(useType, 0);
/* 112 */     OnlineManager.getInstance().sendAll(pro);
/*     */     
/* 114 */     return new ResetGiftRes(true);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gift\GlobalGiftManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */