/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.util.AutoKey;
/*     */ 
/*     */ public class Corps
/*     */ {
/*     */   public static AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().corps.getAutoKey();
/*     */   }
/*     */   
/*     */   public static AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().corps.getAutoKey(localid);
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
/*     */   public static Long insert(xbean.Corps value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, xbean.Corps value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static xbean.Corps get(Long key)
/*     */   {
/*  46 */     return (xbean.Corps)_Tables_.getInstance().corps.get(key);
/*     */   }
/*     */   
/*     */   public static xbean.Corps get(Long key, xbean.Corps value)
/*     */   {
/*  51 */     return (xbean.Corps)_Tables_.getInstance().corps.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, xbean.Corps value)
/*     */   {
/*  56 */     _Tables_.getInstance().corps.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, xbean.Corps value)
/*     */   {
/*  61 */     _Tables_.getInstance().corps.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().corps.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, xbean.Corps value)
/*     */   {
/*  71 */     return _Tables_.getInstance().corps.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, xbean.Corps value)
/*     */   {
/*  76 */     return _Tables_.getInstance().corps.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().corps.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, xbean.Corps> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().corps.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, xbean.Corps> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().corps;
/*     */   }
/*     */   
/*     */   public static xbean.Corps select(Long key)
/*     */   {
/*  96 */     (xbean.Corps)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.Corps get(xbean.Corps v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectCorpsid(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Corps v)
/*     */       {
/* 111 */         return Long.valueOf(v.getCorpsid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectCorpsname(Long key)
/*     */   {
/* 118 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(xbean.Corps v)
/*     */       {
/* 122 */         return v.getCorpsname();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectCorpsdeclaration(Long key)
/*     */   {
/* 129 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(xbean.Corps v)
/*     */       {
/* 133 */         return v.getCorpsdeclaration();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCorpsbadge(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Corps v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getCorpsbadge());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectCreatetime(Long key)
/*     */   {
/* 151 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Corps v)
/*     */       {
/* 155 */         return Long.valueOf(v.getCreatetime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.CorpsDutyMembers> selectDuty2members(Long key)
/*     */   {
/* 162 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.CorpsDutyMembers> get(xbean.Corps v)
/*     */       {
/* 166 */         return v.getDuty2membersAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<xbean.CorpsHistory> selectHistorylist(Long key)
/*     */   {
/* 173 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<xbean.CorpsHistory> get(xbean.Corps v)
/*     */       {
/* 177 */         return v.getHistorylistAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectNexthistoryid(Long key)
/*     */   {
/* 184 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Corps v)
/*     */       {
/* 188 */         return Integer.valueOf(v.getNexthistoryid());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Corps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */