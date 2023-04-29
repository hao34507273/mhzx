/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import xbean.PetArenaRank;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Petarenarank
/*    */ {
/*    */   public static PetArenaRank get(Long key)
/*    */   {
/* 12 */     return (PetArenaRank)_Tables_.getInstance().petarenarank.get(key);
/*    */   }
/*    */   
/*    */   public static PetArenaRank get(Long key, PetArenaRank value)
/*    */   {
/* 17 */     return (PetArenaRank)_Tables_.getInstance().petarenarank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, PetArenaRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().petarenarank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().petarenarank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, PetArenaRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().petarenarank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().petarenarank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, PetArenaRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().petarenarank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, PetArenaRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().petarenarank;
/*    */   }
/*    */   
/*    */   public static PetArenaRank select(Long key)
/*    */   {
/* 52 */     (PetArenaRank)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public PetArenaRank get(PetArenaRank v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static java.util.List<xbean.PetArenaRankInfo> selectRanks(Long key)
/*    */   {
/* 63 */     (java.util.List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public java.util.List<xbean.PetArenaRankInfo> get(PetArenaRank v)
/*    */       {
/* 67 */         return v.getRanksAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, Integer> selectRoles(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Long, Integer> get(PetArenaRank v)
/*    */       {
/* 78 */         return v.getRolesAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectMerged_roles(Long key)
/*    */   {
/* 85 */     (Set)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Set<Long> get(PetArenaRank v)
/*    */       {
/* 89 */         return v.getMerged_rolesAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Petarenarank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */