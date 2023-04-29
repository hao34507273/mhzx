/*     */ package xtable;
/*     */ 
/*     */ import xbean.CountInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.TTableCache;
/*     */ 
/*     */ public class Award2countinfo
/*     */ {
/*     */   public static CountInfo get(Integer key)
/*     */   {
/*  12 */     return (CountInfo)_Tables_.getInstance().award2countinfo.get(key);
/*     */   }
/*     */   
/*     */   public static CountInfo get(Integer key, CountInfo value)
/*     */   {
/*  17 */     return (CountInfo)_Tables_.getInstance().award2countinfo.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Integer key, CountInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().award2countinfo.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Integer key)
/*     */   {
/*  27 */     _Tables_.getInstance().award2countinfo.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Integer key, CountInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().award2countinfo.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Integer key)
/*     */   {
/*  37 */     return _Tables_.getInstance().award2countinfo.remove(key);
/*     */   }
/*     */   
/*     */   public static TTableCache<Integer, CountInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().award2countinfo.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Integer, CountInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().award2countinfo;
/*     */   }
/*     */   
/*     */   public static CountInfo select(Integer key)
/*     */   {
/*  52 */     (CountInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public CountInfo get(CountInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCount(Integer key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(CountInfo v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getCount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectIsawarded(Integer key)
/*     */   {
/*  74 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(CountInfo v)
/*     */       {
/*  78 */         return Boolean.valueOf(v.getIsawarded());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectAwardnum(Integer key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(CountInfo v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getAwardnum());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectStarttime(Integer key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(CountInfo v)
/*     */       {
/* 100 */         return Long.valueOf(v.getStarttime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCurcircle(Integer key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(CountInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getCurcircle());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Award2countinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */