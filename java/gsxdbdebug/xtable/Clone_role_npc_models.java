/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.CloneRoleNPCModel;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Clone_role_npc_models
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().clone_role_npc_models.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().clone_role_npc_models.getAutoKey(localid);
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
/*     */   public static Long insert(CloneRoleNPCModel value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, CloneRoleNPCModel value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static CloneRoleNPCModel get(Long key)
/*     */   {
/*  46 */     return (CloneRoleNPCModel)_Tables_.getInstance().clone_role_npc_models.get(key);
/*     */   }
/*     */   
/*     */   public static CloneRoleNPCModel get(Long key, CloneRoleNPCModel value)
/*     */   {
/*  51 */     return (CloneRoleNPCModel)_Tables_.getInstance().clone_role_npc_models.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, CloneRoleNPCModel value)
/*     */   {
/*  56 */     _Tables_.getInstance().clone_role_npc_models.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, CloneRoleNPCModel value)
/*     */   {
/*  61 */     _Tables_.getInstance().clone_role_npc_models.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().clone_role_npc_models.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, CloneRoleNPCModel value)
/*     */   {
/*  71 */     return _Tables_.getInstance().clone_role_npc_models.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, CloneRoleNPCModel value)
/*     */   {
/*  76 */     return _Tables_.getInstance().clone_role_npc_models.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().clone_role_npc_models.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, CloneRoleNPCModel> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().clone_role_npc_models.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, CloneRoleNPCModel> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().clone_role_npc_models;
/*     */   }
/*     */   
/*     */   public static CloneRoleNPCModel select(Long key)
/*     */   {
/*  96 */     (CloneRoleNPCModel)getTable().select(key, new TField()
/*     */     {
/*     */       public CloneRoleNPCModel get(CloneRoleNPCModel v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectRoleid(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(CloneRoleNPCModel v)
/*     */       {
/* 111 */         return Long.valueOf(v.getRoleid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, String> selectString_prop_map(Long key)
/*     */   {
/* 118 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, String> get(CloneRoleNPCModel v)
/*     */       {
/* 122 */         return v.getString_prop_mapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectInt_prop_map(Long key)
/*     */   {
/* 129 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(CloneRoleNPCModel v)
/*     */       {
/* 133 */         return v.getInt_prop_mapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectModelid(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(CloneRoleNPCModel v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getModelid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectColorid(Long key)
/*     */   {
/* 151 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(CloneRoleNPCModel v)
/*     */       {
/* 155 */         return Integer.valueOf(v.getColorid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectModel_info(Long key)
/*     */   {
/* 162 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(CloneRoleNPCModel v)
/*     */       {
/* 166 */         return v.getModel_infoAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Clone_role_npc_models.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */