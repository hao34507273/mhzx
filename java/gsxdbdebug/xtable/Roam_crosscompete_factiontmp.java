/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.RoamCrossCompeteFactionTmp;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Roam_crosscompete_factiontmp
/*    */ {
/*    */   public static RoamCrossCompeteFactionTmp get(Long key)
/*    */   {
/* 12 */     return (RoamCrossCompeteFactionTmp)_Tables_.getInstance().roam_crosscompete_factiontmp.get(key);
/*    */   }
/*    */   
/*    */   public static RoamCrossCompeteFactionTmp get(Long key, RoamCrossCompeteFactionTmp value)
/*    */   {
/* 17 */     return (RoamCrossCompeteFactionTmp)_Tables_.getInstance().roam_crosscompete_factiontmp.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoamCrossCompeteFactionTmp value)
/*    */   {
/* 22 */     _Tables_.getInstance().roam_crosscompete_factiontmp.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().roam_crosscompete_factiontmp.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoamCrossCompeteFactionTmp value)
/*    */   {
/* 32 */     return _Tables_.getInstance().roam_crosscompete_factiontmp.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().roam_crosscompete_factiontmp.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoamCrossCompeteFactionTmp> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().roam_crosscompete_factiontmp.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoamCrossCompeteFactionTmp> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().roam_crosscompete_factiontmp;
/*    */   }
/*    */   
/*    */   public static RoamCrossCompeteFactionTmp select(Long key)
/*    */   {
/* 52 */     (RoamCrossCompeteFactionTmp)getTable().select(key, new TField()
/*    */     {
/*    */       public RoamCrossCompeteFactionTmp get(RoamCrossCompeteFactionTmp v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectWorld(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(RoamCrossCompeteFactionTmp v)
/*    */       {
/* 67 */         return Long.valueOf(v.getWorld());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectRoles(Long key)
/*    */   {
/* 74 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Long> get(RoamCrossCompeteFactionTmp v)
/*    */       {
/* 78 */         return v.getRolesAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectFights(Long key)
/*    */   {
/* 85 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Long> get(RoamCrossCompeteFactionTmp v)
/*    */       {
/* 89 */         return v.getFightsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectMapid(Long key)
/*    */   {
/* 96 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RoamCrossCompeteFactionTmp v)
/*    */       {
/* :0 */         return Integer.valueOf(v.getMapid());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Roam_crosscompete_factiontmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */