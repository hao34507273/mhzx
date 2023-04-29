/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.HanhunInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2huanhun
/*     */ {
/*     */   public static HanhunInfo get(Long key)
/*     */   {
/*  12 */     return (HanhunInfo)_Tables_.getInstance().role2huanhun.get(key);
/*     */   }
/*     */   
/*     */   public static HanhunInfo get(Long key, HanhunInfo value)
/*     */   {
/*  17 */     return (HanhunInfo)_Tables_.getInstance().role2huanhun.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, HanhunInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2huanhun.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2huanhun.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, HanhunInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2huanhun.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2huanhun.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, HanhunInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2huanhun.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, HanhunInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2huanhun;
/*     */   }
/*     */   
/*     */   public static HanhunInfo select(Long key)
/*     */   {
/*  52 */     (HanhunInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public HanhunInfo get(HanhunInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.ItemInfo> selectIteminfos(Long key)
/*     */   {
/*  63 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.ItemInfo> get(HanhunInfo v)
/*     */       {
/*  67 */         return v.getIteminfosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectStatus(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(HanhunInfo v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getStatus());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectSeekhelpleftcount(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(HanhunInfo v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getSeekhelpleftcount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectHelpotherleftcount(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(HanhunInfo v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getHelpotherleftcount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<Long> selectGuyshelpyou(Long key)
/*     */   {
/* 107 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<Long> get(HanhunInfo v)
/*     */       {
/* 111 */         return v.getGuyshelpyouAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectTimeout(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(HanhunInfo v)
/*     */       {
/* 122 */         return Long.valueOf(v.getTimeout());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.ItemInfo> selectIteminfosnext(Long key)
/*     */   {
/* 129 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.ItemInfo> get(HanhunInfo v)
/*     */       {
/* 133 */         return v.getIteminfosnextAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectAlreadygettask(Long key)
/*     */   {
/* 140 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(HanhunInfo v)
/*     */       {
/* 144 */         return Boolean.valueOf(v.getAlreadygettask());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2huanhun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */