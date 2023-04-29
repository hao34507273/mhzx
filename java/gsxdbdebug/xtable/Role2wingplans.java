/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.AllWingPlans;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2wingplans
/*     */ {
/*     */   public static AllWingPlans get(Long key)
/*     */   {
/*  12 */     return (AllWingPlans)_Tables_.getInstance().role2wingplans.get(key);
/*     */   }
/*     */   
/*     */   public static AllWingPlans get(Long key, AllWingPlans value)
/*     */   {
/*  17 */     return (AllWingPlans)_Tables_.getInstance().role2wingplans.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, AllWingPlans value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2wingplans.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2wingplans.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, AllWingPlans value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2wingplans.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2wingplans.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, AllWingPlans> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2wingplans.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, AllWingPlans> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2wingplans;
/*     */   }
/*     */   
/*     */   public static AllWingPlans select(Long key)
/*     */   {
/*  52 */     (AllWingPlans)getTable().select(key, new TField()
/*     */     {
/*     */       public AllWingPlans get(AllWingPlans v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.WingPlan> selectWings(Long key)
/*     */   {
/*  63 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.WingPlan> get(AllWingPlans v)
/*     */       {
/*  67 */         return v.getWingsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCurplan(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(AllWingPlans v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getCurplan());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.TransferOccupationWing> selectTransfer_occupation_wing_map(Long key)
/*     */   {
/*  85 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.TransferOccupationWing> get(AllWingPlans v)
/*     */       {
/*  89 */         return v.getTransfer_occupation_wing_mapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectEffectwingoccid(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(AllWingPlans v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getEffectwingoccid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectOcc2lastplanoccid(Long key)
/*     */   {
/* 107 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(AllWingPlans v)
/*     */       {
/* 111 */         return v.getOcc2lastplanoccidAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<Integer> selectNewoccplans(Long key)
/*     */   {
/* 118 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<Integer> get(AllWingPlans v)
/*     */       {
/* 122 */         return v.getNewoccplansAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2wingplans.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */