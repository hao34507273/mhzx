/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import xbean.CompetitionTmp;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Competition_tmp
/*    */ {
/*    */   public static CompetitionTmp get(Long key)
/*    */   {
/* 12 */     return (CompetitionTmp)_Tables_.getInstance().competition_tmp.get(key);
/*    */   }
/*    */   
/*    */   public static CompetitionTmp get(Long key, CompetitionTmp value)
/*    */   {
/* 17 */     return (CompetitionTmp)_Tables_.getInstance().competition_tmp.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CompetitionTmp value)
/*    */   {
/* 22 */     _Tables_.getInstance().competition_tmp.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().competition_tmp.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CompetitionTmp value)
/*    */   {
/* 32 */     return _Tables_.getInstance().competition_tmp.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().competition_tmp.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, CompetitionTmp> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().competition_tmp.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CompetitionTmp> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().competition_tmp;
/*    */   }
/*    */   
/*    */   public static CompetitionTmp select(Long key)
/*    */   {
/* 52 */     (CompetitionTmp)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public CompetitionTmp get(CompetitionTmp v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectFights(Long key)
/*    */   {
/* 63 */     (Set)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Set<Long> get(CompetitionTmp v)
/*    */       {
/* 67 */         return v.getFightsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<xbean.CompetitionMatch, xbean.MercenaryFights> selectMercenary_fights(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<xbean.CompetitionMatch, xbean.MercenaryFights> get(CompetitionTmp v)
/*    */       {
/* 78 */         return v.getMercenary_fightsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Competition_tmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */