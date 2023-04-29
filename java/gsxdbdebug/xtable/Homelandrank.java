/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.HomelandRankList;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Homelandrank
/*    */ {
/*    */   public static HomelandRankList get(Long key)
/*    */   {
/* 12 */     return (HomelandRankList)_Tables_.getInstance().homelandrank.get(key);
/*    */   }
/*    */   
/*    */   public static HomelandRankList get(Long key, HomelandRankList value)
/*    */   {
/* 17 */     return (HomelandRankList)_Tables_.getInstance().homelandrank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, HomelandRankList value)
/*    */   {
/* 22 */     _Tables_.getInstance().homelandrank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().homelandrank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, HomelandRankList value)
/*    */   {
/* 32 */     return _Tables_.getInstance().homelandrank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().homelandrank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, HomelandRankList> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().homelandrank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, HomelandRankList> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().homelandrank;
/*    */   }
/*    */   
/*    */   public static HomelandRankList select(Long key)
/*    */   {
/* 52 */     (HomelandRankList)getTable().select(key, new TField()
/*    */     {
/*    */       public HomelandRankList get(HomelandRankList v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Long> selectRanklist(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Long> get(HomelandRankList v)
/*    */       {
/* 67 */         return v.getRanklistAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectAwardtime(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(HomelandRankList v)
/*    */       {
/* 78 */         return Long.valueOf(v.getAwardtime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Homelandrank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */