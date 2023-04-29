/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.ParaseleneRank;
/*    */ import xbean.ParaseleneRankRole;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Paraselenerank
/*    */ {
/*    */   public static ParaseleneRank get(Long key)
/*    */   {
/* 12 */     return (ParaseleneRank)_Tables_.getInstance().paraselenerank.get(key);
/*    */   }
/*    */   
/*    */   public static ParaseleneRank get(Long key, ParaseleneRank value)
/*    */   {
/* 17 */     return (ParaseleneRank)_Tables_.getInstance().paraselenerank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ParaseleneRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().paraselenerank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().paraselenerank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ParaseleneRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().paraselenerank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().paraselenerank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ParaseleneRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().paraselenerank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ParaseleneRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().paraselenerank;
/*    */   }
/*    */   
/*    */   public static ParaseleneRank select(Long key)
/*    */   {
/* 52 */     (ParaseleneRank)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public ParaseleneRank get(ParaseleneRank v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<ParaseleneRankRole> selectRanklist(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<ParaseleneRankRole> get(ParaseleneRank v)
/*    */       {
/* 67 */         return v.getRanklistAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Paraselenerank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */