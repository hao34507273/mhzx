/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.RolekejuRank;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Rolekejurank
/*    */ {
/*    */   public static RolekejuRank get(Long key)
/*    */   {
/* 12 */     return (RolekejuRank)_Tables_.getInstance().rolekejurank.get(key);
/*    */   }
/*    */   
/*    */   public static RolekejuRank get(Long key, RolekejuRank value)
/*    */   {
/* 17 */     return (RolekejuRank)_Tables_.getInstance().rolekejurank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RolekejuRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().rolekejurank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().rolekejurank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RolekejuRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().rolekejurank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().rolekejurank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RolekejuRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().rolekejurank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RolekejuRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().rolekejurank;
/*    */   }
/*    */   
/*    */   public static RolekejuRank select(Long key)
/*    */   {
/* 52 */     (RolekejuRank)getTable().select(key, new TField()
/*    */     {
/*    */       public RolekejuRank get(RolekejuRank v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Long> selectRankdatas(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Long> get(RolekejuRank v)
/*    */       {
/* 67 */         return v.getRankdatasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Rolekejurank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */