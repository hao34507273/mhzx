/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import xbean.Role2FashionDressInfo;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2fashiondress
/*     */ {
/*     */   public static Role2FashionDressInfo get(Long key)
/*     */   {
/*  12 */     return (Role2FashionDressInfo)_Tables_.getInstance().role2fashiondress.get(key);
/*     */   }
/*     */   
/*     */   public static Role2FashionDressInfo get(Long key, Role2FashionDressInfo value)
/*     */   {
/*  17 */     return (Role2FashionDressInfo)_Tables_.getInstance().role2fashiondress.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, Role2FashionDressInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2fashiondress.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2fashiondress.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, Role2FashionDressInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2fashiondress.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2fashiondress.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, Role2FashionDressInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2fashiondress.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, Role2FashionDressInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2fashiondress;
/*     */   }
/*     */   
/*     */   public static Role2FashionDressInfo select(Long key)
/*     */   {
/*  52 */     (Role2FashionDressInfo)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Role2FashionDressInfo get(Role2FashionDressInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCurrent_fashion_dress_cfg_id(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Integer get(Role2FashionDressInfo v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getCurrent_fashion_dress_cfg_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.FashionDressInfo> selectFashion_dress_map(Long key)
/*     */   {
/*  74 */     (Map)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Map<Integer, xbean.FashionDressInfo> get(Role2FashionDressInfo v)
/*     */       {
/*  78 */         return v.getFashion_dress_mapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Set<Integer> selectActivate_property_set(Long key)
/*     */   {
/*  85 */     (Set)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Set<Integer> get(Role2FashionDressInfo v)
/*     */       {
/*  89 */         return v.getActivate_property_setAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.TransferOccupationFashionDress> selectTransfer_occupation_fashion_dress_map(Long key)
/*     */   {
/*  96 */     (Map)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Map<Integer, xbean.TransferOccupationFashionDress> get(Role2FashionDressInfo v)
/*     */       {
/* 100 */         return v.getTransfer_occupation_fashion_dress_mapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectNew_year_fashion_dress_is_repaired(Long key)
/*     */   {
/* 107 */     (Boolean)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Boolean get(Role2FashionDressInfo v)
/*     */       {
/* 111 */         return Boolean.valueOf(v.getNew_year_fashion_dress_is_repaired());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Set<Integer> selectOwn_unlock_theme_fashion_dress_type_set(Long key)
/*     */   {
/* 118 */     (Set)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Set<Integer> get(Role2FashionDressInfo v)
/*     */       {
/* 122 */         return v.getOwn_unlock_theme_fashion_dress_type_setAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2fashiondress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */