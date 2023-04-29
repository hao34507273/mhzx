/*     */ package xtable;
/*     */ 
/*     */ import xbean.RoleSessions;
/*     */ import xbean.RoleSingleBattle;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2singlebattle
/*     */ {
/*     */   public static RoleSingleBattle get(Long key)
/*     */   {
/*  12 */     return (RoleSingleBattle)_Tables_.getInstance().role2singlebattle.get(key);
/*     */   }
/*     */   
/*     */   public static RoleSingleBattle get(Long key, RoleSingleBattle value)
/*     */   {
/*  17 */     return (RoleSingleBattle)_Tables_.getInstance().role2singlebattle.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, RoleSingleBattle value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2singlebattle.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2singlebattle.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, RoleSingleBattle value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2singlebattle.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2singlebattle.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, RoleSingleBattle> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2singlebattle.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, RoleSingleBattle> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2singlebattle;
/*     */   }
/*     */   
/*     */   public static RoleSingleBattle select(Long key)
/*     */   {
/*  52 */     (RoleSingleBattle)getTable().select(key, new TField()
/*     */     {
/*     */       public RoleSingleBattle get(RoleSingleBattle v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectBattleid(Long key)
/*     */   {
/*  63 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(RoleSingleBattle v)
/*     */       {
/*  67 */         return Long.valueOf(v.getBattleid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectBattlecfgid(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleSingleBattle v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getBattlecfgid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCampid(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleSingleBattle v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getCampid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectNumber(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleSingleBattle v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getNumber());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectJointime(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(RoleSingleBattle v)
/*     */       {
/* 111 */         return Long.valueOf(v.getJointime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPoint(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleSingleBattle v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getPoint());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static RoleSessions selectRolesessions(Long key)
/*     */   {
/* 129 */     (RoleSessions)getTable().select(key, new TField()
/*     */     {
/*     */       public RoleSessions get(RoleSingleBattle v)
/*     */       {
/* 133 */         return v.getRolesessions().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectKilladdpoint(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleSingleBattle v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getKilladdpoint());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPvpfightcount(Long key)
/*     */   {
/* 151 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleSingleBattle v)
/*     */       {
/* 155 */         return Integer.valueOf(v.getPvpfightcount());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2singlebattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */