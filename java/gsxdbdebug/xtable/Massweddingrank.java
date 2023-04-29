/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import xbean.MassWeddingRankInfos;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Massweddingrank
/*    */ {
/*    */   public static MassWeddingRankInfos get(Long key)
/*    */   {
/* 12 */     return (MassWeddingRankInfos)_Tables_.getInstance().massweddingrank.get(key);
/*    */   }
/*    */   
/*    */   public static MassWeddingRankInfos get(Long key, MassWeddingRankInfos value)
/*    */   {
/* 17 */     return (MassWeddingRankInfos)_Tables_.getInstance().massweddingrank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MassWeddingRankInfos value)
/*    */   {
/* 22 */     _Tables_.getInstance().massweddingrank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().massweddingrank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MassWeddingRankInfos value)
/*    */   {
/* 32 */     return _Tables_.getInstance().massweddingrank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().massweddingrank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MassWeddingRankInfos> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().massweddingrank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MassWeddingRankInfos> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().massweddingrank;
/*    */   }
/*    */   
/*    */   public static MassWeddingRankInfos select(Long key)
/*    */   {
/* 52 */     (MassWeddingRankInfos)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public MassWeddingRankInfos get(MassWeddingRankInfos v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static java.util.List<xbean.MassWeddingRankInfo> selectMassweddingrankinfos(Long key)
/*    */   {
/* 63 */     (java.util.List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public java.util.List<xbean.MassWeddingRankInfo> get(MassWeddingRankInfos v)
/*    */       {
/* 67 */         return v.getMassweddingrankinfosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, Integer> selectRoleid2index(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Long, Integer> get(MassWeddingRankInfos v)
/*    */       {
/* 78 */         return v.getRoleid2indexAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectNotbackcoinsroleids(Long key)
/*    */   {
/* 85 */     (Set)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Set<Long> get(MassWeddingRankInfos v)
/*    */       {
/* 89 */         return v.getNotbackcoinsroleidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Massweddingrank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */