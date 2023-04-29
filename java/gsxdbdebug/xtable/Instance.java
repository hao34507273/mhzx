/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import xbean.InstanceCacheBean;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Instance
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().instance.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().instance.getAutoKey(localid);
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
/*     */   public static Long insert(InstanceCacheBean value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, InstanceCacheBean value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static InstanceCacheBean get(Long key)
/*     */   {
/*  46 */     return (InstanceCacheBean)_Tables_.getInstance().instance.get(key);
/*     */   }
/*     */   
/*     */   public static InstanceCacheBean get(Long key, InstanceCacheBean value)
/*     */   {
/*  51 */     return (InstanceCacheBean)_Tables_.getInstance().instance.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, InstanceCacheBean value)
/*     */   {
/*  56 */     _Tables_.getInstance().instance.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, InstanceCacheBean value)
/*     */   {
/*  61 */     _Tables_.getInstance().instance.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().instance.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, InstanceCacheBean value)
/*     */   {
/*  71 */     return _Tables_.getInstance().instance.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, InstanceCacheBean value)
/*     */   {
/*  76 */     return _Tables_.getInstance().instance.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().instance.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, InstanceCacheBean> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().instance.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, InstanceCacheBean> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().instance;
/*     */   }
/*     */   
/*     */   public static InstanceCacheBean select(Long key)
/*     */   {
/*  96 */     (InstanceCacheBean)getTable().select(key, new TField()
/*     */     {
/*     */       public InstanceCacheBean get(InstanceCacheBean v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectInstancecfgid(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(InstanceCacheBean v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getInstancecfgid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectWorldid(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(InstanceCacheBean v)
/*     */       {
/* 122 */         return Long.valueOf(v.getWorldid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectOpentime(Long key)
/*     */   {
/* 129 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(InstanceCacheBean v)
/*     */       {
/* 133 */         return Long.valueOf(v.getOpentime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectRoleids(Long key)
/*     */   {
/* 140 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Long> get(InstanceCacheBean v)
/*     */       {
/* 144 */         return v.getRoleidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectSucroleids(Long key)
/*     */   {
/* 151 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Long> get(InstanceCacheBean v)
/*     */       {
/* 155 */         return v.getSucroleidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Map<Integer, Integer> selectExtra(Long key)
/*     */   {
/* 162 */     (java.util.Map)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Map<Integer, Integer> get(InstanceCacheBean v)
/*     */       {
/* 166 */         return v.getExtraAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Set<Long> selectFinishroleids(Long key)
/*     */   {
/* 173 */     (java.util.Set)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Set<Long> get(InstanceCacheBean v)
/*     */       {
/* 177 */         return v.getFinishroleidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Instance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */