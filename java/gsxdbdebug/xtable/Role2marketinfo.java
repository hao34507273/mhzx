/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import xbean.RoleMarketInfo;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2marketinfo
/*     */ {
/*     */   public static RoleMarketInfo get(Long key)
/*     */   {
/*  12 */     return (RoleMarketInfo)_Tables_.getInstance().role2marketinfo.get(key);
/*     */   }
/*     */   
/*     */   public static RoleMarketInfo get(Long key, RoleMarketInfo value)
/*     */   {
/*  17 */     return (RoleMarketInfo)_Tables_.getInstance().role2marketinfo.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, RoleMarketInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2marketinfo.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2marketinfo.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, RoleMarketInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2marketinfo.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2marketinfo.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, RoleMarketInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2marketinfo.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, RoleMarketInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2marketinfo;
/*     */   }
/*     */   
/*     */   public static RoleMarketInfo select(Long key)
/*     */   {
/*  52 */     (RoleMarketInfo)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public RoleMarketInfo get(RoleMarketInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectConcern_item_ids(Long key)
/*     */   {
/*  63 */     (List)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public List<Long> get(RoleMarketInfo v)
/*     */       {
/*  67 */         return v.getConcern_item_idsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectConcern_pet_ids(Long key)
/*     */   {
/*  74 */     (List)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public List<Long> get(RoleMarketInfo v)
/*     */       {
/*  78 */         return v.getConcern_pet_idsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectOnshelf_item_ids(Long key)
/*     */   {
/*  85 */     (List)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public List<Long> get(RoleMarketInfo v)
/*     */       {
/*  89 */         return v.getOnshelf_item_idsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectOnshelf_pet_ids(Long key)
/*     */   {
/*  96 */     (List)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public List<Long> get(RoleMarketInfo v)
/*     */       {
/* 100 */         return v.getOnshelf_pet_idsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectSale_gold_num(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Long get(RoleMarketInfo v)
/*     */       {
/* 111 */         return Long.valueOf(v.getSale_gold_num());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.MarketItem> selectMarketid2timeoutorselleditem(Long key)
/*     */   {
/* 118 */     (Map)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Map<Long, xbean.MarketItem> get(RoleMarketInfo v)
/*     */       {
/* 122 */         return v.getMarketid2timeoutorselleditemAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.MarketPet> selectMarketid2timeoutorselledpet(Long key)
/*     */   {
/* 129 */     (Map)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Map<Long, xbean.MarketPet> get(RoleMarketInfo v)
/*     */       {
/* 133 */         return v.getMarketid2timeoutorselledpetAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2marketinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */