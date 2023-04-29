/*     */ package xtable;
/*     */ 
/*     */ import xbean.ChildGrowthDiaryInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.util.AutoKey;
/*     */ 
/*     */ public class Childrengrowthdiary
/*     */ {
/*     */   public static AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().childrengrowthdiary.getAutoKey();
/*     */   }
/*     */   
/*     */   public static AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().childrengrowthdiary.getAutoKey(localid);
/*     */   }
/*     */   
/*     */   public static Long nextKey()
/*     */   {
/*  22 */     return (Long)getAutoKey().next();
/*     */   }
/*     */   
/*     */   public static Long nextKey(int localid)
/*     */   {
/*  27 */     return (Long)getAutoKey(localid).next();
/*     */   }
/*     */   
/*     */   public static Long insert(ChildGrowthDiaryInfo value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, ChildGrowthDiaryInfo value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static ChildGrowthDiaryInfo get(Long key)
/*     */   {
/*  46 */     return (ChildGrowthDiaryInfo)_Tables_.getInstance().childrengrowthdiary.get(key);
/*     */   }
/*     */   
/*     */   public static ChildGrowthDiaryInfo get(Long key, ChildGrowthDiaryInfo value)
/*     */   {
/*  51 */     return (ChildGrowthDiaryInfo)_Tables_.getInstance().childrengrowthdiary.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, ChildGrowthDiaryInfo value)
/*     */   {
/*  56 */     _Tables_.getInstance().childrengrowthdiary.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, ChildGrowthDiaryInfo value)
/*     */   {
/*  61 */     _Tables_.getInstance().childrengrowthdiary.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().childrengrowthdiary.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, ChildGrowthDiaryInfo value)
/*     */   {
/*  71 */     return _Tables_.getInstance().childrengrowthdiary.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, ChildGrowthDiaryInfo value)
/*     */   {
/*  76 */     return _Tables_.getInstance().childrengrowthdiary.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().childrengrowthdiary.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, ChildGrowthDiaryInfo> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().childrengrowthdiary.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, ChildGrowthDiaryInfo> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().childrengrowthdiary;
/*     */   }
/*     */   
/*     */   public static ChildGrowthDiaryInfo select(Long key)
/*     */   {
/*  96 */     (ChildGrowthDiaryInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public ChildGrowthDiaryInfo get(ChildGrowthDiaryInfo v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectGive_birth_time(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ChildGrowthDiaryInfo v)
/*     */       {
/* 111 */         return Long.valueOf(v.getGive_birth_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectChildhood_begin_time(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ChildGrowthDiaryInfo v)
/*     */       {
/* 122 */         return Long.valueOf(v.getChildhood_begin_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectAdult_begin_time(Long key)
/*     */   {
/* 129 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ChildGrowthDiaryInfo v)
/*     */       {
/* 133 */         return Long.valueOf(v.getAdult_begin_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<xbean.ChildGrowthInfo> selectGrowth_info_list(Long key)
/*     */   {
/* 140 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<xbean.ChildGrowthInfo> get(ChildGrowthDiaryInfo v)
/*     */       {
/* 144 */         return v.getGrowth_info_listAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectAnother_give_birth_parent_role_id(Long key)
/*     */   {
/* 151 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ChildGrowthDiaryInfo v)
/*     */       {
/* 155 */         return Long.valueOf(v.getAnother_give_birth_parent_role_id());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Childrengrowthdiary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */