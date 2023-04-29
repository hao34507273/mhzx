/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.AuctionActivityInfo;
/*    */ import xbean.AuctionPeriodInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Auctionactivityinfo
/*    */ {
/*    */   public static AuctionActivityInfo get(Long key)
/*    */   {
/* 12 */     return (AuctionActivityInfo)_Tables_.getInstance().auctionactivityinfo.get(key);
/*    */   }
/*    */   
/*    */   public static AuctionActivityInfo get(Long key, AuctionActivityInfo value)
/*    */   {
/* 17 */     return (AuctionActivityInfo)_Tables_.getInstance().auctionactivityinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, AuctionActivityInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().auctionactivityinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().auctionactivityinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, AuctionActivityInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().auctionactivityinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().auctionactivityinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, AuctionActivityInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().auctionactivityinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, AuctionActivityInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().auctionactivityinfo;
/*    */   }
/*    */   
/*    */   public static AuctionActivityInfo select(Long key)
/*    */   {
/* 52 */     (AuctionActivityInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public AuctionActivityInfo get(AuctionActivityInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static AuctionPeriodInfo selectLastperiodinfo(Long key)
/*    */   {
/* 63 */     (AuctionPeriodInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public AuctionPeriodInfo get(AuctionActivityInfo v)
/*    */       {
/* 67 */         return v.getLastperiodinfo().toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static AuctionPeriodInfo selectCurrentperiodinfo(Long key)
/*    */   {
/* 74 */     (AuctionPeriodInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public AuctionPeriodInfo get(AuctionActivityInfo v)
/*    */       {
/* 78 */         return v.getCurrentperiodinfo().toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, xbean.AuctionMergeInfo> selectRoleid2mergeinfo(Long key)
/*    */   {
/* 85 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Long, xbean.AuctionMergeInfo> get(AuctionActivityInfo v)
/*    */       {
/* 89 */         return v.getRoleid2mergeinfoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Auctionactivityinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */