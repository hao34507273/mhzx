/*     */ package xtable;
/*     */ 
/*     */ import xbean.FightRecordInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.util.AutoKey;
/*     */ 
/*     */ public class Fightreord
/*     */ {
/*     */   public static AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().fightreord.getAutoKey();
/*     */   }
/*     */   
/*     */   public static AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().fightreord.getAutoKey(localid);
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
/*     */   public static Long insert(FightRecordInfo value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, FightRecordInfo value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static FightRecordInfo get(Long key)
/*     */   {
/*  46 */     return (FightRecordInfo)_Tables_.getInstance().fightreord.get(key);
/*     */   }
/*     */   
/*     */   public static FightRecordInfo get(Long key, FightRecordInfo value)
/*     */   {
/*  51 */     return (FightRecordInfo)_Tables_.getInstance().fightreord.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, FightRecordInfo value)
/*     */   {
/*  56 */     _Tables_.getInstance().fightreord.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, FightRecordInfo value)
/*     */   {
/*  61 */     _Tables_.getInstance().fightreord.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().fightreord.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, FightRecordInfo value)
/*     */   {
/*  71 */     return _Tables_.getInstance().fightreord.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, FightRecordInfo value)
/*     */   {
/*  76 */     return _Tables_.getInstance().fightreord.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().fightreord.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, FightRecordInfo> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().fightreord.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, FightRecordInfo> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().fightreord;
/*     */   }
/*     */   
/*     */   public static FightRecordInfo select(Long key)
/*     */   {
/*  96 */     (FightRecordInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public FightRecordInfo get(FightRecordInfo v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectVersion(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FightRecordInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getVersion());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static byte[] selectEnter_fight(Long key)
/*     */   {
/* 118 */     (byte[])getTable().select(key, new TField()
/*     */     {
/*     */       public byte[] get(FightRecordInfo v)
/*     */       {
/* 122 */         return v.getEnter_fightCopy();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<byte[]> selectRounds(Long key)
/*     */   {
/* 129 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<byte[]> get(FightRecordInfo v)
/*     */       {
/* 133 */         return v.getRoundsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static byte[] selectFight_end(Long key)
/*     */   {
/* 140 */     (byte[])getTable().select(key, new TField()
/*     */     {
/*     */       public byte[] get(FightRecordInfo v)
/*     */       {
/* 144 */         return v.getFight_endCopy();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Fightreord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */