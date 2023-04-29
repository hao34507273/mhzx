/*    */ package xtable;
/*    */ 
/*    */ import xbean.FlopLotteryEntry;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2floplotteryentry
/*    */ {
/*    */   public static FlopLotteryEntry get(Long key)
/*    */   {
/* 12 */     return (FlopLotteryEntry)_Tables_.getInstance().role2floplotteryentry.get(key);
/*    */   }
/*    */   
/*    */   public static FlopLotteryEntry get(Long key, FlopLotteryEntry value)
/*    */   {
/* 17 */     return (FlopLotteryEntry)_Tables_.getInstance().role2floplotteryentry.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, FlopLotteryEntry value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2floplotteryentry.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2floplotteryentry.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, FlopLotteryEntry value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2floplotteryentry.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2floplotteryentry.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, FlopLotteryEntry> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2floplotteryentry.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, FlopLotteryEntry> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2floplotteryentry;
/*    */   }
/*    */   
/*    */   public static Long selectUid(Long key)
/*    */   {
/* 52 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(FlopLotteryEntry v)
/*    */       {
/* 56 */         return Long.valueOf(v.getUid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectFloplotterymaincfgid(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(FlopLotteryEntry v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getFloplotterymaincfgid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectIsconddone(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(FlopLotteryEntry v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getIsconddone());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectExpiretimestamp(Long key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(FlopLotteryEntry v)
/*    */       {
/* 89 */         return Long.valueOf(v.getExpiretimestamp());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2floplotteryentry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */