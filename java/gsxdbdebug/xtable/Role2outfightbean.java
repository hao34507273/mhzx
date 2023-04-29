/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.RoleOutFightBean;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2outfightbean
/*     */ {
/*     */   public static RoleOutFightBean get(Long key)
/*     */   {
/*  12 */     return (RoleOutFightBean)_Tables_.getInstance().role2outfightbean.get(key);
/*     */   }
/*     */   
/*     */   public static RoleOutFightBean get(Long key, RoleOutFightBean value)
/*     */   {
/*  17 */     return (RoleOutFightBean)_Tables_.getInstance().role2outfightbean.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, RoleOutFightBean value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2outfightbean.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2outfightbean.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, RoleOutFightBean value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2outfightbean.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2outfightbean.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, RoleOutFightBean> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2outfightbean.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, RoleOutFightBean> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2outfightbean;
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectEffectaddpropmap(Long key)
/*     */   {
/*  52 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(RoleOutFightBean v)
/*     */       {
/*  56 */         return v.getEffectaddpropmapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectEquipstaticaddpropmap(Long key)
/*     */   {
/*  63 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(RoleOutFightBean v)
/*     */       {
/*  67 */         return v.getEquipstaticaddpropmapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectWingstaticaddpropmap(Long key)
/*     */   {
/*  74 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(RoleOutFightBean v)
/*     */       {
/*  78 */         return v.getWingstaticaddpropmapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectAppellationaddpropmap(Long key)
/*     */   {
/*  85 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(RoleOutFightBean v)
/*     */       {
/*  89 */         return v.getAppellationaddpropmapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectFabaoaddpropmap(Long key)
/*     */   {
/*  96 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(RoleOutFightBean v)
/*     */       {
/* 100 */         return v.getFabaoaddpropmapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.RoleProBean> selectExtroprop(Long key)
/*     */   {
/* 107 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.RoleProBean> get(RoleOutFightBean v)
/*     */       {
/* 111 */         return v.getExtropropAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static xbean.RoleReviseProBean selectExtro_revise_pro(Long key)
/*     */   {
/* 118 */     (xbean.RoleReviseProBean)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.RoleReviseProBean get(RoleOutFightBean v)
/*     */       {
/* 122 */         return v.getExtro_revise_pro().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2outfightbean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */