/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.ChildrenRatingRankInfo;
/*    */ import xbean.SingleChildRatingRankInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Childrenratingrank
/*    */ {
/*    */   public static ChildrenRatingRankInfo get(Long key)
/*    */   {
/* 12 */     return (ChildrenRatingRankInfo)_Tables_.getInstance().childrenratingrank.get(key);
/*    */   }
/*    */   
/*    */   public static ChildrenRatingRankInfo get(Long key, ChildrenRatingRankInfo value)
/*    */   {
/* 17 */     return (ChildrenRatingRankInfo)_Tables_.getInstance().childrenratingrank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ChildrenRatingRankInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().childrenratingrank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().childrenratingrank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ChildrenRatingRankInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().childrenratingrank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().childrenratingrank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ChildrenRatingRankInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().childrenratingrank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ChildrenRatingRankInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().childrenratingrank;
/*    */   }
/*    */   
/*    */   public static ChildrenRatingRankInfo select(Long key)
/*    */   {
/* 52 */     (ChildrenRatingRankInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public ChildrenRatingRankInfo get(ChildrenRatingRankInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<SingleChildRatingRankInfo> selectRanklist(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<SingleChildRatingRankInfo> get(ChildrenRatingRankInfo v)
/*    */       {
/* 67 */         return v.getRanklistAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Childrenratingrank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */