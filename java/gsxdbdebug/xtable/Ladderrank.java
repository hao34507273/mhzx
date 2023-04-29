/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.LadderRank;
/*    */ import xbean.LadderRankRole;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Ladderrank
/*    */ {
/*    */   public static LadderRank get(Long key)
/*    */   {
/* 12 */     return (LadderRank)_Tables_.getInstance().ladderrank.get(key);
/*    */   }
/*    */   
/*    */   public static LadderRank get(Long key, LadderRank value)
/*    */   {
/* 17 */     return (LadderRank)_Tables_.getInstance().ladderrank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, LadderRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().ladderrank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().ladderrank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, LadderRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().ladderrank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().ladderrank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, LadderRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().ladderrank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, LadderRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().ladderrank;
/*    */   }
/*    */   
/*    */   public static LadderRank select(Long key)
/*    */   {
/* 52 */     (LadderRank)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public LadderRank get(LadderRank v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<LadderRankRole> selectRanklist(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<LadderRankRole> get(LadderRank v)
/*    */       {
/* 67 */         return v.getRanklistAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectInittime(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Long get(LadderRank v)
/*    */       {
/* 78 */         return Long.valueOf(v.getInittime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Ladderrank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */