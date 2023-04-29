/*    */ package xtable;
/*    */ 
/*    */ import java.util.NavigableMap;
/*    */ import xbean.CrossLadderRank;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Cross_ladder_ranks
/*    */ {
/*    */   public static CrossLadderRank get(Long key)
/*    */   {
/* 12 */     return (CrossLadderRank)_Tables_.getInstance().cross_ladder_ranks.get(key);
/*    */   }
/*    */   
/*    */   public static CrossLadderRank get(Long key, CrossLadderRank value)
/*    */   {
/* 17 */     return (CrossLadderRank)_Tables_.getInstance().cross_ladder_ranks.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CrossLadderRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().cross_ladder_ranks.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().cross_ladder_ranks.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CrossLadderRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().cross_ladder_ranks.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().cross_ladder_ranks.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, CrossLadderRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().cross_ladder_ranks.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CrossLadderRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().cross_ladder_ranks;
/*    */   }
/*    */   
/*    */   public static CrossLadderRank select(Long key)
/*    */   {
/* 52 */     (CrossLadderRank)getTable().select(key, new TField()
/*    */     {
/*    */       public CrossLadderRank get(CrossLadderRank v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectSeason_begin_timestamp(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(CrossLadderRank v)
/*    */       {
/* 67 */         return Long.valueOf(v.getSeason_begin_timestamp());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static NavigableMap<Integer, xbean.CrossLadderRankList> selectLevel_range_ranks(Long key)
/*    */   {
/* 74 */     (NavigableMap)getTable().select(key, new TField()
/*    */     {
/*    */       public NavigableMap<Integer, xbean.CrossLadderRankList> get(CrossLadderRank v)
/*    */       {
/* 78 */         return v.getLevel_range_ranksAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Cross_ladder_ranks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */