/*     */ package xtable;
/*     */ 
/*     */ import xbean.MarketPet;
/*     */ import xbean.Pet;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Marketpet
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().marketpet.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().marketpet.getAutoKey(localid);
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
/*     */   public static Long insert(MarketPet value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, MarketPet value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static MarketPet get(Long key)
/*     */   {
/*  46 */     return (MarketPet)_Tables_.getInstance().marketpet.get(key);
/*     */   }
/*     */   
/*     */   public static MarketPet get(Long key, MarketPet value)
/*     */   {
/*  51 */     return (MarketPet)_Tables_.getInstance().marketpet.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, MarketPet value)
/*     */   {
/*  56 */     _Tables_.getInstance().marketpet.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, MarketPet value)
/*     */   {
/*  61 */     _Tables_.getInstance().marketpet.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().marketpet.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, MarketPet value)
/*     */   {
/*  71 */     return _Tables_.getInstance().marketpet.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, MarketPet value)
/*     */   {
/*  76 */     return _Tables_.getInstance().marketpet.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().marketpet.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, MarketPet> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().marketpet.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, MarketPet> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().marketpet;
/*     */   }
/*     */   
/*     */   public static MarketPet select(Long key)
/*     */   {
/*  96 */     (MarketPet)getTable().select(key, new TField()
/*     */     {
/*     */       public MarketPet get(MarketPet v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Pet selectPet(Long key)
/*     */   {
/* 107 */     (Pet)getTable().select(key, new TField()
/*     */     {
/*     */       public Pet get(MarketPet v)
/*     */       {
/* 111 */         return v.getPet().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectRoleid(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(MarketPet v)
/*     */       {
/* 122 */         return Long.valueOf(v.getRoleid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPrice(Long key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(MarketPet v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getPrice());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectState(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(MarketPet v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getState());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectOnshelf_time(Long key)
/*     */   {
/* 151 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(MarketPet v)
/*     */       {
/* 155 */         return Long.valueOf(v.getOnshelf_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectConcern_role_num(Long key)
/*     */   {
/* 162 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(MarketPet v)
/*     */       {
/* 166 */         return Integer.valueOf(v.getConcern_role_num());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectChannel_id(Long key)
/*     */   {
/* 173 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(MarketPet v)
/*     */       {
/* 177 */         return Long.valueOf(v.getChannel_id());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Marketpet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */