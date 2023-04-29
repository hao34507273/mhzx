/*     */ package xtable;
/*     */ 
/*     */ import xbean.FlowerPoint;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.TTableCache;
/*     */ 
/*     */ public class Role2flowerpoint
/*     */ {
/*     */   public static FlowerPoint get(Long key)
/*     */   {
/*  12 */     return (FlowerPoint)_Tables_.getInstance().role2flowerpoint.get(key);
/*     */   }
/*     */   
/*     */   public static FlowerPoint get(Long key, FlowerPoint value)
/*     */   {
/*  17 */     return (FlowerPoint)_Tables_.getInstance().role2flowerpoint.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, FlowerPoint value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2flowerpoint.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2flowerpoint.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, FlowerPoint value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2flowerpoint.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2flowerpoint.remove(key);
/*     */   }
/*     */   
/*     */   public static TTableCache<Long, FlowerPoint> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2flowerpoint.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, FlowerPoint> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2flowerpoint;
/*     */   }
/*     */   
/*     */   public static FlowerPoint select(Long key)
/*     */   {
/*  52 */     (FlowerPoint)getTable().select(key, new TField()
/*     */     {
/*     */       public FlowerPoint get(FlowerPoint v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectReceivepoint(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FlowerPoint v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getReceivepoint());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectGivepoint(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FlowerPoint v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getGivepoint());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectCleartime(Long key)
/*     */   {
/*  85 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(FlowerPoint v)
/*     */       {
/*  89 */         return Long.valueOf(v.getCleartime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectVersion(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FlowerPoint v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getVersion());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectTotal_receive_point(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FlowerPoint v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getTotal_receive_point());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectTotal_give_point(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FlowerPoint v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getTotal_give_point());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2flowerpoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */