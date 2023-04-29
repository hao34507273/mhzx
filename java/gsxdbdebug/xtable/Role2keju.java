/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import xbean.KeJuInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2keju
/*     */ {
/*     */   public static KeJuInfo get(Long key)
/*     */   {
/*  12 */     return (KeJuInfo)_Tables_.getInstance().role2keju.get(key);
/*     */   }
/*     */   
/*     */   public static KeJuInfo get(Long key, KeJuInfo value)
/*     */   {
/*  17 */     return (KeJuInfo)_Tables_.getInstance().role2keju.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, KeJuInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2keju.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2keju.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, KeJuInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2keju.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2keju.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, KeJuInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2keju.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, KeJuInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2keju;
/*     */   }
/*     */   
/*     */   public static KeJuInfo select(Long key)
/*     */   {
/*  52 */     (KeJuInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public KeJuInfo get(KeJuInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Integer> selectQuestionlist(Long key)
/*     */   {
/*  63 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Integer> get(KeJuInfo v)
/*     */       {
/*  67 */         return v.getQuestionlistAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectState(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(KeJuInfo v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getState());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectRightnum(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(KeJuInfo v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getRightnum());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectAnswernum(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(KeJuInfo v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getAnswernum());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectIspasshuishi(Long key)
/*     */   {
/* 107 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(KeJuInfo v)
/*     */       {
/* 111 */         return Boolean.valueOf(v.getIspasshuishi());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectStarttime(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(KeJuInfo v)
/*     */       {
/* 122 */         return Long.valueOf(v.getStarttime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectFinishtime(Long key)
/*     */   {
/* 129 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(KeJuInfo v)
/*     */       {
/* 133 */         return Long.valueOf(v.getFinishtime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPunishtime(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(KeJuInfo v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getPunishtime());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2keju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */