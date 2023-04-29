/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.QMHWRank;
/*    */ import xbean.QMHWRankRole;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Qmhwrank
/*    */ {
/*    */   public static QMHWRank get(Long key)
/*    */   {
/* 12 */     return (QMHWRank)_Tables_.getInstance().qmhwrank.get(key);
/*    */   }
/*    */   
/*    */   public static QMHWRank get(Long key, QMHWRank value)
/*    */   {
/* 17 */     return (QMHWRank)_Tables_.getInstance().qmhwrank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, QMHWRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().qmhwrank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().qmhwrank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, QMHWRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().qmhwrank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().qmhwrank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, QMHWRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().qmhwrank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, QMHWRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().qmhwrank;
/*    */   }
/*    */   
/*    */   public static QMHWRank select(Long key)
/*    */   {
/* 52 */     (QMHWRank)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public QMHWRank get(QMHWRank v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<QMHWRankRole> selectRanklist(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<QMHWRankRole> get(QMHWRank v)
/*    */       {
/* 67 */         return v.getRanklistAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Qmhwrank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */