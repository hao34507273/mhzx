/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import xbean.Paraselene;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2paraselene
/*     */ {
/*     */   public static Paraselene get(Long key)
/*     */   {
/*  12 */     return (Paraselene)_Tables_.getInstance().role2paraselene.get(key);
/*     */   }
/*     */   
/*     */   public static Paraselene get(Long key, Paraselene value)
/*     */   {
/*  17 */     return (Paraselene)_Tables_.getInstance().role2paraselene.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, Paraselene value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2paraselene.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2paraselene.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, Paraselene value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2paraselene.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2paraselene.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, Paraselene> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2paraselene.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, Paraselene> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2paraselene;
/*     */   }
/*     */   
/*     */   public static Paraselene select(Long key)
/*     */   {
/*  52 */     (Paraselene)getTable().select(key, new TField()
/*     */     {
/*     */       public Paraselene get(Paraselene v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectStarttime(Long key)
/*     */   {
/*  63 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Paraselene v)
/*     */       {
/*  67 */         return Long.valueOf(v.getStarttime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectFinishtime(Long key)
/*     */   {
/*  74 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Paraselene v)
/*     */       {
/*  78 */         return Long.valueOf(v.getFinishtime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectRecentlayer(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Paraselene v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getRecentlayer());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectIsinfuben(Long key)
/*     */   {
/*  96 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(Paraselene v)
/*     */       {
/* 100 */         return Boolean.valueOf(v.getIsinfuben());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Integer> selectLayers(Long key)
/*     */   {
/* 107 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Integer> get(Paraselene v)
/*     */       {
/* 111 */         return v.getLayersAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2paraselene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */