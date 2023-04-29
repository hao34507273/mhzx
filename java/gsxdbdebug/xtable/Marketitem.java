/*     */ package xtable;
/*     */ 
/*     */ import xbean.Item;
/*     */ import xbean.MarketItem;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Marketitem
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().marketitem.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().marketitem.getAutoKey(localid);
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
/*     */   public static Long insert(MarketItem value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, MarketItem value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static MarketItem get(Long key)
/*     */   {
/*  46 */     return (MarketItem)_Tables_.getInstance().marketitem.get(key);
/*     */   }
/*     */   
/*     */   public static MarketItem get(Long key, MarketItem value)
/*     */   {
/*  51 */     return (MarketItem)_Tables_.getInstance().marketitem.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, MarketItem value)
/*     */   {
/*  56 */     _Tables_.getInstance().marketitem.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, MarketItem value)
/*     */   {
/*  61 */     _Tables_.getInstance().marketitem.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().marketitem.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, MarketItem value)
/*     */   {
/*  71 */     return _Tables_.getInstance().marketitem.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, MarketItem value)
/*     */   {
/*  76 */     return _Tables_.getInstance().marketitem.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().marketitem.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, MarketItem> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().marketitem.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, MarketItem> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().marketitem;
/*     */   }
/*     */   
/*     */   public static MarketItem select(Long key)
/*     */   {
/*  96 */     (MarketItem)getTable().select(key, new TField()
/*     */     {
/*     */       public MarketItem get(MarketItem v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectRest_num(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(MarketItem v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getRest_num());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Item selectItem(Long key)
/*     */   {
/* 118 */     (Item)getTable().select(key, new TField()
/*     */     {
/*     */       public Item get(MarketItem v)
/*     */       {
/* 122 */         return v.getItem().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectRoleid(Long key)
/*     */   {
/* 129 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(MarketItem v)
/*     */       {
/* 133 */         return Long.valueOf(v.getRoleid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPrice(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(MarketItem v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getPrice());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectState(Long key)
/*     */   {
/* 151 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(MarketItem v)
/*     */       {
/* 155 */         return Integer.valueOf(v.getState());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectOnshelf_time(Long key)
/*     */   {
/* 162 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(MarketItem v)
/*     */       {
/* 166 */         return Long.valueOf(v.getOnshelf_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectConcern_role_num(Long key)
/*     */   {
/* 173 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(MarketItem v)
/*     */       {
/* 177 */         return Integer.valueOf(v.getConcern_role_num());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectChannel_id(Long key)
/*     */   {
/* 184 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(MarketItem v)
/*     */       {
/* 188 */         return Long.valueOf(v.getChannel_id());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Marketitem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */