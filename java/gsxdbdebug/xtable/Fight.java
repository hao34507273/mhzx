/*     */ package xtable;
/*     */ 
/*     */ import java.util.Set;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.util.AutoKey;
/*     */ 
/*     */ public class Fight
/*     */ {
/*     */   public static AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().fight.getAutoKey();
/*     */   }
/*     */   
/*     */   public static AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().fight.getAutoKey(localid);
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
/*     */   public static Long insert(xbean.Fight value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, xbean.Fight value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static xbean.Fight get(Long key)
/*     */   {
/*  46 */     return (xbean.Fight)_Tables_.getInstance().fight.get(key);
/*     */   }
/*     */   
/*     */   public static xbean.Fight get(Long key, xbean.Fight value)
/*     */   {
/*  51 */     return (xbean.Fight)_Tables_.getInstance().fight.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, xbean.Fight value)
/*     */   {
/*  56 */     _Tables_.getInstance().fight.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, xbean.Fight value)
/*     */   {
/*  61 */     _Tables_.getInstance().fight.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().fight.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, xbean.Fight value)
/*     */   {
/*  71 */     return _Tables_.getInstance().fight.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, xbean.Fight value)
/*     */   {
/*  76 */     return _Tables_.getInstance().fight.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().fight.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, xbean.Fight> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().fight.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, xbean.Fight> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().fight;
/*     */   }
/*     */   
/*     */   public static Integer selectType(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Fight v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getType());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCfgtype(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Fight v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getCfgtype());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectFightreason(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Fight v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getFightreason());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectRound(Long key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Fight v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getRound());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectStarttime(Long key)
/*     */   {
/* 140 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Fight v)
/*     */       {
/* 144 */         return Long.valueOf(v.getStarttime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectNextid(Long key)
/*     */   {
/* 151 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Fight v)
/*     */       {
/* 155 */         return Integer.valueOf(v.getNextid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Set<Long> selectCurroundendroles(Long key)
/*     */   {
/* 162 */     (Set)getTable().select(key, new TField()
/*     */     {
/*     */       public Set<Long> get(xbean.Fight v)
/*     */       {
/* 166 */         return v.getCurroundendrolesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectIscurroundend(Long key)
/*     */   {
/* 173 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(xbean.Fight v)
/*     */       {
/* 177 */         return Boolean.valueOf(v.getIscurroundend());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectFlow(Long key)
/*     */   {
/* 184 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Fight v)
/*     */       {
/* 188 */         return Integer.valueOf(v.getFlow());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<xbean.FightCmd> selectCmds(Long key)
/*     */   {
/* 195 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<xbean.FightCmd> get(xbean.Fight v)
/*     */       {
/* 199 */         return v.getCmdsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Map<Integer, Integer> selectExtra(Long key)
/*     */   {
/* 206 */     (java.util.Map)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Map<Integer, Integer> get(xbean.Fight v)
/*     */       {
/* 210 */         return v.getExtraAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectNexttimermillsec(Long key)
/*     */   {
/* 217 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Fight v)
/*     */       {
/* 221 */         return Long.valueOf(v.getNexttimermillsec());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectActiontotalcount(Long key)
/*     */   {
/* 228 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Fight v)
/*     */       {
/* 232 */         return Integer.valueOf(v.getActiontotalcount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectActionroundmaxcount(Long key)
/*     */   {
/* 239 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Fight v)
/*     */       {
/* 243 */         return Integer.valueOf(v.getActionroundmaxcount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectActioncountcurround(Long key)
/*     */   {
/* 250 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Fight v)
/*     */       {
/* 254 */         return Integer.valueOf(v.getActioncountcurround());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectGenresultatonce(Long key)
/*     */   {
/* 261 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(xbean.Fight v)
/*     */       {
/* 265 */         return Boolean.valueOf(v.getGenresultatonce());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Fight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */