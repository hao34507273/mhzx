/*    */ package xtable;
/*    */ 
/*    */ import xbean.LevelTimeBean;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Level2time
/*    */ {
/*    */   public static LevelTimeBean get(Long key)
/*    */   {
/* 12 */     return (LevelTimeBean)_Tables_.getInstance().level2time.get(key);
/*    */   }
/*    */   
/*    */   public static LevelTimeBean get(Long key, LevelTimeBean value)
/*    */   {
/* 17 */     return (LevelTimeBean)_Tables_.getInstance().level2time.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, LevelTimeBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().level2time.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().level2time.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, LevelTimeBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().level2time.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().level2time.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, LevelTimeBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().level2time.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, LevelTimeBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().level2time;
/*    */   }
/*    */   
/*    */   public static LevelTimeBean select(Long key)
/*    */   {
/* 52 */     (LevelTimeBean)getTable().select(key, new TField()
/*    */     {
/*    */       public LevelTimeBean get(LevelTimeBean v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectServerlevel(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(LevelTimeBean v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getServerlevel());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectStarttime(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(LevelTimeBean v)
/*    */       {
/* 78 */         return Long.valueOf(v.getStarttime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectUpgradetime(Long key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(LevelTimeBean v)
/*    */       {
/* 89 */         return Long.valueOf(v.getUpgradetime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Level2time.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */