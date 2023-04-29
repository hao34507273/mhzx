/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.util.AtomicRangeInteger;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.Pair;
/*     */ import xbean.Pod;
/*     */ import xtable.User2exchange_data_handler_info;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReturnFromRoamServerHandlerManager
/*     */ {
/*  19 */   private static final AtomicRangeInteger autoIncrement = new AtomicRangeInteger(0, 524288);
/*  20 */   private static final List<ExchangeDataHandler<?>> handlers = new LinkedList();
/*     */   
/*     */   static
/*     */   {
/*  24 */     handlers.add(new ExchangeDataTreasureBagHandler());
/*     */   }
/*     */   
/*     */   private static long getSN()
/*     */   {
/*  29 */     return DateTimeUtils.getCurrTimeInMillis() / 1000L << 32 & 0xFFFFFFFF00000000 | GameServerInfoManager.getLocalId() << 20 | autoIncrement.getAndIncrement();
/*     */   }
/*     */   
/*     */ 
/*     */   public static boolean boxData(List<Pair<String, Long>> userToRoleList, List<hub.ExchangeDataHandlerInfo> data)
/*     */   {
/*  35 */     int size = userToRoleList.size();
/*  36 */     for (int i = 0; i < size; i++)
/*     */     {
/*  38 */       Pair<String, Long> pair = (Pair)userToRoleList.get(i);
/*  39 */       hub.ExchangeDataHandlerInfo handlerInfo = new hub.ExchangeDataHandlerInfo();
/*  40 */       if (!boxData((String)pair.first, ((Long)pair.second).longValue(), handlerInfo))
/*     */       {
/*  42 */         return false;
/*     */       }
/*  44 */       data.add(handlerInfo);
/*     */     }
/*     */     
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean boxData(String userid, long roleid, hub.ExchangeDataHandlerInfo handlerInfo)
/*     */   {
/*  52 */     ArrayList<Octets> dataList = handlerInfo.data_list;
/*  53 */     int size = handlers.size();
/*  54 */     for (int i = 0; i < size; i++)
/*     */     {
/*  56 */       ExchangeDataHandler<?> handler = (ExchangeDataHandler)handlers.get(i);
/*  57 */       OctetsStream os = new OctetsStream();
/*  58 */       if (!handler.boxData(userid, roleid, os))
/*     */       {
/*  60 */         return false;
/*     */       }
/*  62 */       dataList.add(os);
/*     */     }
/*     */     
/*  65 */     handlerInfo.sn = getSN();
/*     */     
/*  67 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean unboxData(List<Pair<String, Long>> userToRoleList, List<hub.ExchangeDataHandlerInfo> data)
/*     */   {
/*  72 */     int size = userToRoleList.size();
/*  73 */     for (int i = 0; i < size; i++)
/*     */     {
/*  75 */       Pair<String, Long> pair = (Pair)userToRoleList.get(i);
/*  76 */       hub.ExchangeDataHandlerInfo handlerInfo = (hub.ExchangeDataHandlerInfo)data.get(i);
/*  77 */       if (!unboxData((String)pair.first, ((Long)pair.second).longValue(), handlerInfo))
/*     */       {
/*  79 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  83 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean unboxData(String userid, long roleid, hub.ExchangeDataHandlerInfo handlerInfo)
/*     */   {
/*  88 */     xbean.ExchangeDataHandlerInfo xExchangeDataHandlerInfo = User2exchange_data_handler_info.get(userid);
/*  89 */     if (xExchangeDataHandlerInfo == null)
/*     */     {
/*  91 */       xExchangeDataHandlerInfo = Pod.newExchangeDataHandlerInfo();
/*  92 */       User2exchange_data_handler_info.insert(userid, xExchangeDataHandlerInfo);
/*     */     }
/*  94 */     List<Long> xSNList = xExchangeDataHandlerInfo.getSn_list();
/*  95 */     if (xSNList.contains(Long.valueOf(handlerInfo.sn)))
/*     */     {
/*  97 */       return true;
/*     */     }
/*  99 */     xSNList.add(Long.valueOf(handlerInfo.sn));
/* 100 */     if (xSNList.size() > 5)
/*     */     {
/* 102 */       xSNList.remove(0);
/*     */     }
/*     */     
/* 105 */     ArrayList<Octets> dataList = handlerInfo.data_list;
/* 106 */     int size = handlers.size();
/* 107 */     for (int i = 0; i < size; i++)
/*     */     {
/* 109 */       ExchangeDataHandler<?> handler = (ExchangeDataHandler)handlers.get(i);
/* 110 */       if (!handler.unboxData(userid, roleid, (Octets)dataList.get(i)))
/*     */       {
/* 112 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 116 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\ReturnFromRoamServerHandlerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */