/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.RoleClothes;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Roleclothes
/*     */ {
/*     */   public static RoleClothes get(Long key)
/*     */   {
/*  12 */     return (RoleClothes)_Tables_.getInstance().roleclothes.get(key);
/*     */   }
/*     */   
/*     */   public static RoleClothes get(Long key, RoleClothes value)
/*     */   {
/*  17 */     return (RoleClothes)_Tables_.getInstance().roleclothes.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, RoleClothes value)
/*     */   {
/*  22 */     _Tables_.getInstance().roleclothes.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().roleclothes.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, RoleClothes value)
/*     */   {
/*  32 */     return _Tables_.getInstance().roleclothes.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().roleclothes.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, RoleClothes> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().roleclothes.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, RoleClothes> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().roleclothes;
/*     */   }
/*     */   
/*     */   public static RoleClothes select(Long key)
/*     */   {
/*  52 */     (RoleClothes)getTable().select(key, new TField()
/*     */     {
/*     */       public RoleClothes get(RoleClothes v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectNextid(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleClothes v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getNextid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCurid(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleClothes v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getCurid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectDefid(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleClothes v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getDefid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectMaxcount(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleClothes v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getMaxcount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<xbean.ClothColor> selectClothes(Long key)
/*     */   {
/* 107 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<xbean.ClothColor> get(RoleClothes v)
/*     */       {
/* 111 */         return v.getClothesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectFashion_dress_cloth_map(Long key)
/*     */   {
/* 118 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(RoleClothes v)
/*     */       {
/* 122 */         return v.getFashion_dress_cloth_mapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.TransferOccupationRoleClothes> selectTransfer_occupation_role_clothes(Long key)
/*     */   {
/* 129 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.TransferOccupationRoleClothes> get(RoleClothes v)
/*     */       {
/* 133 */         return v.getTransfer_occupation_role_clothesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Roleclothes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */