/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.LonngBoatRaceMatch;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Lonngboatrace
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().lonngboatrace.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().lonngboatrace.getAutoKey(localid);
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
/*     */   public static Long insert(LonngBoatRaceMatch value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, LonngBoatRaceMatch value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static LonngBoatRaceMatch get(Long key)
/*     */   {
/*  46 */     return (LonngBoatRaceMatch)_Tables_.getInstance().lonngboatrace.get(key);
/*     */   }
/*     */   
/*     */   public static LonngBoatRaceMatch get(Long key, LonngBoatRaceMatch value)
/*     */   {
/*  51 */     return (LonngBoatRaceMatch)_Tables_.getInstance().lonngboatrace.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, LonngBoatRaceMatch value)
/*     */   {
/*  56 */     _Tables_.getInstance().lonngboatrace.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, LonngBoatRaceMatch value)
/*     */   {
/*  61 */     _Tables_.getInstance().lonngboatrace.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().lonngboatrace.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, LonngBoatRaceMatch value)
/*     */   {
/*  71 */     return _Tables_.getInstance().lonngboatrace.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, LonngBoatRaceMatch value)
/*     */   {
/*  76 */     return _Tables_.getInstance().lonngboatrace.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().lonngboatrace.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, LonngBoatRaceMatch> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().lonngboatrace.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, LonngBoatRaceMatch> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().lonngboatrace;
/*     */   }
/*     */   
/*     */   public static LonngBoatRaceMatch select(Long key)
/*     */   {
/*  96 */     (LonngBoatRaceMatch)getTable().select(key, new TField()
/*     */     {
/*     */       public LonngBoatRaceMatch get(LonngBoatRaceMatch v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectMatchbegintimestamp(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(LonngBoatRaceMatch v)
/*     */       {
/* 111 */         return Long.valueOf(v.getMatchbegintimestamp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectActivityid(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(LonngBoatRaceMatch v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getActivityid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectRaceid(Long key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(LonngBoatRaceMatch v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getRaceid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPhaseno(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(LonngBoatRaceMatch v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getPhaseno());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectRoundno(Long key)
/*     */   {
/* 151 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(LonngBoatRaceMatch v)
/*     */       {
/* 155 */         return Integer.valueOf(v.getRoundno());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectTimesno(Long key)
/*     */   {
/* 162 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(LonngBoatRaceMatch v)
/*     */       {
/* 166 */         return Integer.valueOf(v.getTimesno());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<Integer> selectCommandlist(Long key)
/*     */   {
/* 173 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<Integer> get(LonngBoatRaceMatch v)
/*     */       {
/* 177 */         return v.getCommandlistAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectEndtimestamp(Long key)
/*     */   {
/* 184 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(LonngBoatRaceMatch v)
/*     */       {
/* 188 */         return Long.valueOf(v.getEndtimestamp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectState(Long key)
/*     */   {
/* 195 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(LonngBoatRaceMatch v)
/*     */       {
/* 199 */         return Integer.valueOf(v.getState());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.LonngBoatRaceTeamStat> selectTeamid2teamstat(Long key)
/*     */   {
/* 206 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.LonngBoatRaceTeamStat> get(LonngBoatRaceMatch v)
/*     */       {
/* 210 */         return v.getTeamid2teamstatAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, Integer> selectTeamid2isallright(Long key)
/*     */   {
/* 217 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, Integer> get(LonngBoatRaceMatch v)
/*     */       {
/* 221 */         return v.getTeamid2isallrightAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, Integer> selectRoleid2israndom(Long key)
/*     */   {
/* 228 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, Integer> get(LonngBoatRaceMatch v)
/*     */       {
/* 232 */         return v.getRoleid2israndomAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Lonngboatrace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */