/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.TitleAppellation;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2titleappellation
/*     */ {
/*     */   public static TitleAppellation get(Long key)
/*     */   {
/*  12 */     return (TitleAppellation)_Tables_.getInstance().role2titleappellation.get(key);
/*     */   }
/*     */   
/*     */   public static TitleAppellation get(Long key, TitleAppellation value)
/*     */   {
/*  17 */     return (TitleAppellation)_Tables_.getInstance().role2titleappellation.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, TitleAppellation value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2titleappellation.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2titleappellation.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, TitleAppellation value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2titleappellation.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2titleappellation.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, TitleAppellation> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2titleappellation.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, TitleAppellation> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2titleappellation;
/*     */   }
/*     */   
/*     */   public static TitleAppellation select(Long key)
/*     */   {
/*  52 */     (TitleAppellation)getTable().select(key, new TField()
/*     */     {
/*     */       public TitleAppellation get(TitleAppellation v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<xbean.TitleInfo> selectOwntitle(Long key)
/*     */   {
/*  63 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<xbean.TitleInfo> get(TitleAppellation v)
/*     */       {
/*  67 */         return v.getOwntitleAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectActivetitle(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(TitleAppellation v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getActivetitle());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectActiveappellation(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(TitleAppellation v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getActiveappellation());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPro2appellationid(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(TitleAppellation v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getPro2appellationid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.AppellationInfo> selectAppellations(Long key)
/*     */   {
/* 107 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.AppellationInfo> get(TitleAppellation v)
/*     */       {
/* 111 */         return v.getAppellationsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2titleappellation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */