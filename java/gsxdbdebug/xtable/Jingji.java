/*    */ package xtable;
/*    */ 
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Jingji
/*    */ {
/*    */   public static xbean.Jingji get(Long key)
/*    */   {
/* 12 */     return (xbean.Jingji)_Tables_.getInstance().jingji.get(key);
/*    */   }
/*    */   
/*    */   public static xbean.Jingji get(Long key, xbean.Jingji value)
/*    */   {
/* 17 */     return (xbean.Jingji)_Tables_.getInstance().jingji.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, xbean.Jingji value)
/*    */   {
/* 22 */     _Tables_.getInstance().jingji.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().jingji.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, xbean.Jingji value)
/*    */   {
/* 32 */     return _Tables_.getInstance().jingji.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().jingji.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, xbean.Jingji> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().jingji.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, xbean.Jingji> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().jingji;
/*    */   }
/*    */   
/*    */   public static xbean.Jingji select(Long key)
/*    */   {
/* 52 */     (xbean.Jingji)getTable().select(key, new TField()
/*    */     {
/*    */       public xbean.Jingji get(xbean.Jingji v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectSeasonstarttime(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(xbean.Jingji v)
/*    */       {
/* 67 */         return Long.valueOf(v.getSeasonstarttime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectRankrefreshtime(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(xbean.Jingji v)
/*    */       {
/* 78 */         return Long.valueOf(v.getRankrefreshtime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectTotalcount(Long key)
/*    */   {
/* 85 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(xbean.Jingji v)
/*    */       {
/* 89 */         return Integer.valueOf(v.getTotalcount());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectMerge_clear(Long key)
/*    */   {
/* 96 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(xbean.Jingji v)
/*    */       {
/* :0 */         return Integer.valueOf(v.getMerge_clear());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Jingji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */