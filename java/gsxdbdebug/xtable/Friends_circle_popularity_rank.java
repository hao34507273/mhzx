/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.PopularityRankData;
/*    */ import xbean.RolePopularityRankData;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Friends_circle_popularity_rank
/*    */ {
/*    */   public static PopularityRankData get(Long key)
/*    */   {
/* 12 */     return (PopularityRankData)_Tables_.getInstance().friends_circle_popularity_rank.get(key);
/*    */   }
/*    */   
/*    */   public static PopularityRankData get(Long key, PopularityRankData value)
/*    */   {
/* 17 */     return (PopularityRankData)_Tables_.getInstance().friends_circle_popularity_rank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, PopularityRankData value)
/*    */   {
/* 22 */     _Tables_.getInstance().friends_circle_popularity_rank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().friends_circle_popularity_rank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, PopularityRankData value)
/*    */   {
/* 32 */     return _Tables_.getInstance().friends_circle_popularity_rank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().friends_circle_popularity_rank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, PopularityRankData> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().friends_circle_popularity_rank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, PopularityRankData> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().friends_circle_popularity_rank;
/*    */   }
/*    */   
/*    */   public static PopularityRankData select(Long key)
/*    */   {
/* 52 */     (PopularityRankData)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public PopularityRankData get(PopularityRankData v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<RolePopularityRankData> selectRank_data_list(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<RolePopularityRankData> get(PopularityRankData v)
/*    */       {
/* 67 */         return v.getRank_data_listAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Friends_circle_popularity_rank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */