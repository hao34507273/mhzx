/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.MarriageFriendInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Marriage
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().marriage.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().marriage.getAutoKey(localid);
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
/*     */   public static Long insert(xbean.Marriage value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, xbean.Marriage value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static xbean.Marriage get(Long key)
/*     */   {
/*  46 */     return (xbean.Marriage)_Tables_.getInstance().marriage.get(key);
/*     */   }
/*     */   
/*     */   public static xbean.Marriage get(Long key, xbean.Marriage value)
/*     */   {
/*  51 */     return (xbean.Marriage)_Tables_.getInstance().marriage.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, xbean.Marriage value)
/*     */   {
/*  56 */     _Tables_.getInstance().marriage.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, xbean.Marriage value)
/*     */   {
/*  61 */     _Tables_.getInstance().marriage.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().marriage.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, xbean.Marriage value)
/*     */   {
/*  71 */     return _Tables_.getInstance().marriage.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, xbean.Marriage value)
/*     */   {
/*  76 */     return _Tables_.getInstance().marriage.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().marriage.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, xbean.Marriage> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().marriage.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, xbean.Marriage> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().marriage;
/*     */   }
/*     */   
/*     */   public static xbean.Marriage select(Long key)
/*     */   {
/*  96 */     (xbean.Marriage)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.Marriage get(xbean.Marriage v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectRoleida(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Marriage v)
/*     */       {
/* 111 */         return Long.valueOf(v.getRoleida());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectRoleidb(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Marriage v)
/*     */       {
/* 122 */         return Long.valueOf(v.getRoleidb());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, MarriageFriendInfo> selectFriendainfos(Long key)
/*     */   {
/* 129 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, MarriageFriendInfo> get(xbean.Marriage v)
/*     */       {
/* 133 */         return v.getFriendainfosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, MarriageFriendInfo> selectFriendbinfos(Long key)
/*     */   {
/* 140 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, MarriageFriendInfo> get(xbean.Marriage v)
/*     */       {
/* 144 */         return v.getFriendbinfosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectMarrytime(Long key)
/*     */   {
/* 151 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Marriage v)
/*     */       {
/* 155 */         return Long.valueOf(v.getMarrytime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectLevel(Long key)
/*     */   {
/* 162 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Marriage v)
/*     */       {
/* 166 */         return Integer.valueOf(v.getLevel());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectMarriagetitle(Long key)
/*     */   {
/* 173 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Marriage v)
/*     */       {
/* 177 */         return Integer.valueOf(v.getMarriagetitle());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectParammap(Long key)
/*     */   {
/* 184 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(xbean.Marriage v)
/*     */       {
/* 188 */         return v.getParammapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPrepare_pregnant_score(Long key)
/*     */   {
/* 195 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Marriage v)
/*     */       {
/* 199 */         return Integer.valueOf(v.getPrepare_pregnant_score());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectChild_belong_role_id(Long key)
/*     */   {
/* 206 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Marriage v)
/*     */       {
/* 210 */         return Long.valueOf(v.getChild_belong_role_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectGive_birth_score(Long key)
/*     */   {
/* 217 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Marriage v)
/*     */       {
/* 221 */         return Integer.valueOf(v.getGive_birth_score());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectGive_birth_score_enough_time(Long key)
/*     */   {
/* 228 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Marriage v)
/*     */       {
/* 232 */         return Long.valueOf(v.getGive_birth_score_enough_time());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Marriage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */