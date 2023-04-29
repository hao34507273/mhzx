/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.CompetitionMatch;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Competition
/*    */ {
/*    */   public static xbean.Competition get(Long key)
/*    */   {
/* 12 */     return (xbean.Competition)_Tables_.getInstance().competition.get(key);
/*    */   }
/*    */   
/*    */   public static xbean.Competition get(Long key, xbean.Competition value)
/*    */   {
/* 17 */     return (xbean.Competition)_Tables_.getInstance().competition.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, xbean.Competition value)
/*    */   {
/* 22 */     _Tables_.getInstance().competition.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().competition.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, xbean.Competition value)
/*    */   {
/* 32 */     return _Tables_.getInstance().competition.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().competition.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, xbean.Competition> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().competition.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, xbean.Competition> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().competition;
/*    */   }
/*    */   
/*    */   public static xbean.Competition select(Long key)
/*    */   {
/* 52 */     (xbean.Competition)getTable().select(key, new TField()
/*    */     {
/*    */       public xbean.Competition get(xbean.Competition v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<CompetitionMatch, Integer> selectMatch2times(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<CompetitionMatch, Integer> get(xbean.Competition v)
/*    */       {
/* 67 */         return v.getMatch2timesAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectMatchtimes(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(xbean.Competition v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getMatchtimes());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<CompetitionMatch, xbean.CompetitionAgainst> selectAgainsts(Long key)
/*    */   {
/* 85 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<CompetitionMatch, xbean.CompetitionAgainst> get(xbean.Competition v)
/*    */       {
/* 89 */         return v.getAgainstsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, xbean.MissTurn> selectMiss_turns(Long key)
/*    */   {
/* 96 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, xbean.MissTurn> get(xbean.Competition v)
/*    */       {
/* :0 */         return v.getMiss_turnsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Competition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */