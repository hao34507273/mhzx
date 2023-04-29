/*     */ package xtable;
/*     */ 
/*     */ import xbean.ZhenyaoCount;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.TTableCache;
/*     */ 
/*     */ public class Role2zhenyaocount
/*     */ {
/*     */   public static ZhenyaoCount get(Long key)
/*     */   {
/*  12 */     return (ZhenyaoCount)_Tables_.getInstance().role2zhenyaocount.get(key);
/*     */   }
/*     */   
/*     */   public static ZhenyaoCount get(Long key, ZhenyaoCount value)
/*     */   {
/*  17 */     return (ZhenyaoCount)_Tables_.getInstance().role2zhenyaocount.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, ZhenyaoCount value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2zhenyaocount.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2zhenyaocount.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, ZhenyaoCount value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2zhenyaocount.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2zhenyaocount.remove(key);
/*     */   }
/*     */   
/*     */   public static TTableCache<Long, ZhenyaoCount> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2zhenyaocount.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, ZhenyaoCount> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2zhenyaocount;
/*     */   }
/*     */   
/*     */   public static ZhenyaoCount select(Long key)
/*     */   {
/*  52 */     (ZhenyaoCount)getTable().select(key, new TField()
/*     */     {
/*     */       public ZhenyaoCount get(ZhenyaoCount v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectCleantime(Long key)
/*     */   {
/*  63 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ZhenyaoCount v)
/*     */       {
/*  67 */         return Long.valueOf(v.getCleantime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectZhenyaocount(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ZhenyaoCount v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getZhenyaocount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectReservedexp(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ZhenyaoCount v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getReservedexp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectSinglecount(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ZhenyaoCount v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getSinglecount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectDoublecount(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ZhenyaoCount v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getDoublecount());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2zhenyaocount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */