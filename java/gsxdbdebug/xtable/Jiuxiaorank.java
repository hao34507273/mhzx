/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.JiuXiaoRank;
/*    */ import xbean.JiuXiaoRankRole;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Jiuxiaorank
/*    */ {
/*    */   public static JiuXiaoRank get(Long key)
/*    */   {
/* 12 */     return (JiuXiaoRank)_Tables_.getInstance().jiuxiaorank.get(key);
/*    */   }
/*    */   
/*    */   public static JiuXiaoRank get(Long key, JiuXiaoRank value)
/*    */   {
/* 17 */     return (JiuXiaoRank)_Tables_.getInstance().jiuxiaorank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, JiuXiaoRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().jiuxiaorank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().jiuxiaorank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, JiuXiaoRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().jiuxiaorank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().jiuxiaorank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, JiuXiaoRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().jiuxiaorank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, JiuXiaoRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().jiuxiaorank;
/*    */   }
/*    */   
/*    */   public static JiuXiaoRank select(Long key)
/*    */   {
/* 52 */     (JiuXiaoRank)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public JiuXiaoRank get(JiuXiaoRank v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<JiuXiaoRankRole> selectRanklist(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<JiuXiaoRankRole> get(JiuXiaoRank v)
/*    */       {
/* 67 */         return v.getRanklistAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Jiuxiaorank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */