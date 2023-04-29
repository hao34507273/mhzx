/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.RoleLevelBean;
/*    */ import xbean.RoleLevelRank;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Rolelevelrank
/*    */ {
/*    */   public static RoleLevelRank get(Long key)
/*    */   {
/* 12 */     return (RoleLevelRank)_Tables_.getInstance().rolelevelrank.get(key);
/*    */   }
/*    */   
/*    */   public static RoleLevelRank get(Long key, RoleLevelRank value)
/*    */   {
/* 17 */     return (RoleLevelRank)_Tables_.getInstance().rolelevelrank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleLevelRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().rolelevelrank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().rolelevelrank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleLevelRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().rolelevelrank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().rolelevelrank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleLevelRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().rolelevelrank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleLevelRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().rolelevelrank;
/*    */   }
/*    */   
/*    */   public static RoleLevelRank select(Long key)
/*    */   {
/* 52 */     (RoleLevelRank)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleLevelRank get(RoleLevelRank v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<RoleLevelBean> selectRankdatas(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<RoleLevelBean> get(RoleLevelRank v)
/*    */       {
/* 67 */         return v.getRankdatasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Rolelevelrank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */