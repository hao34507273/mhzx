/*     */ package xtable;
/*     */ 
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.TTableCache;
/*     */ 
/*     */ 
/*     */ public class Basic
/*     */ {
/*     */   public static xbean.Basic get(Long key)
/*     */   {
/*  12 */     return (xbean.Basic)_Tables_.getInstance().basic.get(key);
/*     */   }
/*     */   
/*     */   public static xbean.Basic get(Long key, xbean.Basic value)
/*     */   {
/*  17 */     return (xbean.Basic)_Tables_.getInstance().basic.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, xbean.Basic value)
/*     */   {
/*  22 */     _Tables_.getInstance().basic.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().basic.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, xbean.Basic value)
/*     */   {
/*  32 */     return _Tables_.getInstance().basic.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().basic.remove(key);
/*     */   }
/*     */   
/*     */   public static TTableCache<Long, xbean.Basic> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().basic.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, xbean.Basic> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().basic;
/*     */   }
/*     */   
/*     */   public static xbean.Basic select(Long key)
/*     */   {
/*  52 */     (xbean.Basic)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.Basic get(xbean.Basic v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectUser_id(Long key)
/*     */   {
/*  63 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(xbean.Basic v)
/*     */       {
/*  67 */         return v.getUser_id();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectQqid(Long key)
/*     */   {
/*  74 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Basic v)
/*     */       {
/*  78 */         return Long.valueOf(v.getQqid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectName(Long key)
/*     */   {
/*  85 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(xbean.Basic v)
/*     */       {
/*  89 */         return v.getName();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectGender(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Basic v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getGender());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectOccupationid(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Basic v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getOccupationid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectCreatetime(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Basic v)
/*     */       {
/* 122 */         return Long.valueOf(v.getCreatetime());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Basic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */