/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import xbean.SwornBuilder;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Swornbuilder
/*     */ {
/*     */   public static SwornBuilder get(Long key)
/*     */   {
/*  12 */     return (SwornBuilder)_Tables_.getInstance().swornbuilder.get(key);
/*     */   }
/*     */   
/*     */   public static SwornBuilder get(Long key, SwornBuilder value)
/*     */   {
/*  17 */     return (SwornBuilder)_Tables_.getInstance().swornbuilder.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, SwornBuilder value)
/*     */   {
/*  22 */     _Tables_.getInstance().swornbuilder.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().swornbuilder.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, SwornBuilder value)
/*     */   {
/*  32 */     return _Tables_.getInstance().swornbuilder.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().swornbuilder.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, SwornBuilder> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().swornbuilder.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, SwornBuilder> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().swornbuilder;
/*     */   }
/*     */   
/*     */   public static Integer selectStatus(Long key)
/*     */   {
/*  52 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(SwornBuilder v)
/*     */       {
/*  56 */         return Integer.valueOf(v.getStatus());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLeaderid(Long key)
/*     */   {
/*  63 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(SwornBuilder v)
/*     */       {
/*  67 */         return Long.valueOf(v.getLeaderid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectRoleids(Long key)
/*     */   {
/*  74 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Long> get(SwornBuilder v)
/*     */       {
/*  78 */         return v.getRoleidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectAgreeids(Long key)
/*     */   {
/*  85 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Long> get(SwornBuilder v)
/*     */       {
/*  89 */         return v.getAgreeidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectConfirmtime(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(SwornBuilder v)
/*     */       {
/* 100 */         return Long.valueOf(v.getConfirmtime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectName1(Long key)
/*     */   {
/* 107 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(SwornBuilder v)
/*     */       {
/* 111 */         return v.getName1();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectName2(Long key)
/*     */   {
/* 118 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(SwornBuilder v)
/*     */       {
/* 122 */         return v.getName2();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Map<Long, String> selectTitles(Long key)
/*     */   {
/* 129 */     (java.util.Map)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Map<Long, String> get(SwornBuilder v)
/*     */       {
/* 133 */         return v.getTitlesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Swornbuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */