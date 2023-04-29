/*     */ package xtable;
/*     */ 
/*     */ import xbean.RolePKInformation;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.TTableCache;
/*     */ 
/*     */ public class Role2pk_info
/*     */ {
/*     */   public static RolePKInformation get(Long key)
/*     */   {
/*  12 */     return (RolePKInformation)_Tables_.getInstance().role2pk_info.get(key);
/*     */   }
/*     */   
/*     */   public static RolePKInformation get(Long key, RolePKInformation value)
/*     */   {
/*  17 */     return (RolePKInformation)_Tables_.getInstance().role2pk_info.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, RolePKInformation value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2pk_info.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2pk_info.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, RolePKInformation value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2pk_info.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2pk_info.remove(key);
/*     */   }
/*     */   
/*     */   public static TTableCache<Long, RolePKInformation> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2pk_info.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, RolePKInformation> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2pk_info;
/*     */   }
/*     */   
/*     */   public static RolePKInformation select(Long key)
/*     */   {
/*  52 */     (RolePKInformation)getTable().select(key, new TField()
/*     */     {
/*     */       public RolePKInformation get(RolePKInformation v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectUpdate_time(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RolePKInformation v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getUpdate_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPk_mode_expire_time(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RolePKInformation v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getPk_mode_expire_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectProtection_expire_time(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RolePKInformation v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getProtection_expire_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectForce_protection_expire_time(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RolePKInformation v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getForce_protection_expire_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectActive_pk_times(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RolePKInformation v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getActive_pk_times());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPk_death_times(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RolePKInformation v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getPk_death_times());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectBought_moral_value(Long key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RolePKInformation v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getBought_moral_value());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2pk_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */