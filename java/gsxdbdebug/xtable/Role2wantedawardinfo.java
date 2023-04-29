/*    */ package xtable;
/*    */ 
/*    */ import xbean.WantedAwardInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2wantedawardinfo
/*    */ {
/*    */   public static WantedAwardInfo get(Long key)
/*    */   {
/* 12 */     return (WantedAwardInfo)_Tables_.getInstance().role2wantedawardinfo.get(key);
/*    */   }
/*    */   
/*    */   public static WantedAwardInfo get(Long key, WantedAwardInfo value)
/*    */   {
/* 17 */     return (WantedAwardInfo)_Tables_.getInstance().role2wantedawardinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, WantedAwardInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2wantedawardinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2wantedawardinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, WantedAwardInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2wantedawardinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2wantedawardinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, WantedAwardInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2wantedawardinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, WantedAwardInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2wantedawardinfo;
/*    */   }
/*    */   
/*    */   public static WantedAwardInfo select(Long key)
/*    */   {
/* 52 */     (WantedAwardInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public WantedAwardInfo get(WantedAwardInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectCount(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(WantedAwardInfo v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getCount());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectTimestamp(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(WantedAwardInfo v)
/*    */       {
/* 78 */         return Long.valueOf(v.getTimestamp());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2wantedawardinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */