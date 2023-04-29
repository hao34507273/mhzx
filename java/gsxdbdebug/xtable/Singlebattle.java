/*     */ package xtable;
/*     */ 
/*     */ import xbean.GlobalSingleBattleData;
/*     */ import xbean.SingleBattleSessions;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Singlebattle
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().singlebattle.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().singlebattle.getAutoKey(localid);
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
/*     */   public static Long insert(GlobalSingleBattleData value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, GlobalSingleBattleData value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static GlobalSingleBattleData get(Long key)
/*     */   {
/*  46 */     return (GlobalSingleBattleData)_Tables_.getInstance().singlebattle.get(key);
/*     */   }
/*     */   
/*     */   public static GlobalSingleBattleData get(Long key, GlobalSingleBattleData value)
/*     */   {
/*  51 */     return (GlobalSingleBattleData)_Tables_.getInstance().singlebattle.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, GlobalSingleBattleData value)
/*     */   {
/*  56 */     _Tables_.getInstance().singlebattle.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, GlobalSingleBattleData value)
/*     */   {
/*  61 */     _Tables_.getInstance().singlebattle.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().singlebattle.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, GlobalSingleBattleData value)
/*     */   {
/*  71 */     return _Tables_.getInstance().singlebattle.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, GlobalSingleBattleData value)
/*     */   {
/*  76 */     return _Tables_.getInstance().singlebattle.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().singlebattle.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, GlobalSingleBattleData> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().singlebattle.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, GlobalSingleBattleData> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().singlebattle;
/*     */   }
/*     */   
/*     */   public static GlobalSingleBattleData select(Long key)
/*     */   {
/*  96 */     (GlobalSingleBattleData)getTable().select(key, new TField()
/*     */     {
/*     */       public GlobalSingleBattleData get(GlobalSingleBattleData v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectWorld(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(GlobalSingleBattleData v)
/*     */       {
/* 111 */         return Long.valueOf(v.getWorld());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectStarttime(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(GlobalSingleBattleData v)
/*     */       {
/* 122 */         return Long.valueOf(v.getStarttime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Map<Integer, xbean.CampInfo> selectCampinfos(Long key)
/*     */   {
/* 129 */     (java.util.Map)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Map<Integer, xbean.CampInfo> get(GlobalSingleBattleData v)
/*     */       {
/* 133 */         return v.getCampinfosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectContextid(Long key)
/*     */   {
/* 140 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(GlobalSingleBattleData v)
/*     */       {
/* 144 */         return Long.valueOf(v.getContextid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static xbean.BattleFightRecord selectFightrecord(Long key)
/*     */   {
/* 151 */     (xbean.BattleFightRecord)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.BattleFightRecord get(GlobalSingleBattleData v)
/*     */       {
/* 155 */         return v.getFightrecord().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectBattlecfgid(Long key)
/*     */   {
/* 162 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(GlobalSingleBattleData v)
/*     */       {
/* 166 */         return Integer.valueOf(v.getBattlecfgid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static xbean.SingleBattleResult selectResult(Long key)
/*     */   {
/* 173 */     (xbean.SingleBattleResult)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.SingleBattleResult get(GlobalSingleBattleData v)
/*     */       {
/* 177 */         return v.getResult().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectStage(Long key)
/*     */   {
/* 184 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(GlobalSingleBattleData v)
/*     */       {
/* 188 */         return Integer.valueOf(v.getStage());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static SingleBattleSessions selectSessions(Long key)
/*     */   {
/* 195 */     (SingleBattleSessions)getTable().select(key, new TField()
/*     */     {
/*     */       public SingleBattleSessions get(GlobalSingleBattleData v)
/*     */       {
/* 199 */         return v.getSessions().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Set<Long> selectAllfightids(Long key)
/*     */   {
/* 206 */     (java.util.Set)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Set<Long> get(GlobalSingleBattleData v)
/*     */       {
/* 210 */         return v.getAllfightidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Singlebattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */