/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.BigBoss;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2bigboss
/*     */ {
/*     */   public static BigBoss get(Long key)
/*     */   {
/*  12 */     return (BigBoss)_Tables_.getInstance().role2bigboss.get(key);
/*     */   }
/*     */   
/*     */   public static BigBoss get(Long key, BigBoss value)
/*     */   {
/*  17 */     return (BigBoss)_Tables_.getInstance().role2bigboss.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, BigBoss value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2bigboss.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2bigboss.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, BigBoss value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2bigboss.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2bigboss.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, BigBoss> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2bigboss.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, BigBoss> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2bigboss;
/*     */   }
/*     */   
/*     */   public static BigBoss select(Long key)
/*     */   {
/*  52 */     (BigBoss)getTable().select(key, new TField()
/*     */     {
/*     */       public BigBoss get(BigBoss v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectDamagepoint(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(BigBoss v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getDamagepoint());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectRank(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(BigBoss v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getRank());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectBuycount(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(BigBoss v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getBuycount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectRestbuycount(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(BigBoss v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getRestbuycount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectChallengecount(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(BigBoss v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getChallengecount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectFightcount(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(BigBoss v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getFightcount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectStarttime(Long key)
/*     */   {
/* 129 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(BigBoss v)
/*     */       {
/* 133 */         return Long.valueOf(v.getStarttime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectIsawarded(Long key)
/*     */   {
/* 140 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(BigBoss v)
/*     */       {
/* 144 */         return Boolean.valueOf(v.getIsawarded());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectIskilledmonster(Long key)
/*     */   {
/* 151 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(BigBoss v)
/*     */       {
/* 155 */         return Boolean.valueOf(v.getIskilledmonster());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectReserved(Long key)
/*     */   {
/* 162 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(BigBoss v)
/*     */       {
/* 166 */         return Integer.valueOf(v.getReserved());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectOcp2damagepoint(Long key)
/*     */   {
/* 173 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(BigBoss v)
/*     */       {
/* 177 */         return v.getOcp2damagepointAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2bigboss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */