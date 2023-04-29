/*    */ package xtable;
/*    */ 
/*    */ import xbean.MondayFree;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2mondayfree
/*    */ {
/*    */   public static MondayFree get(Long key)
/*    */   {
/* 12 */     return (MondayFree)_Tables_.getInstance().role2mondayfree.get(key);
/*    */   }
/*    */   
/*    */   public static MondayFree get(Long key, MondayFree value)
/*    */   {
/* 17 */     return (MondayFree)_Tables_.getInstance().role2mondayfree.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MondayFree value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2mondayfree.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2mondayfree.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MondayFree value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2mondayfree.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2mondayfree.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, MondayFree> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2mondayfree.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MondayFree> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2mondayfree;
/*    */   }
/*    */   
/*    */   public static MondayFree select(Long key)
/*    */   {
/* 52 */     (MondayFree)getTable().select(key, new TField()
/*    */     {
/*    */       public MondayFree get(MondayFree v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectSunday_award_time(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(MondayFree v)
/*    */       {
/* 67 */         return Long.valueOf(v.getSunday_award_time());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectMonday_award_time(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(MondayFree v)
/*    */       {
/* 78 */         return Long.valueOf(v.getMonday_award_time());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectFinish_shimen_time(Long key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(MondayFree v)
/*    */       {
/* 89 */         return Long.valueOf(v.getFinish_shimen_time());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectFinish_baotu_time(Long key)
/*    */   {
/* 96 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(MondayFree v)
/*    */       {
/* :0 */         return Long.valueOf(v.getFinish_baotu_time());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2mondayfree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */