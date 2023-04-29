/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.RoleJingJiBean;
/*    */ import xbean.RoleJingJiRank;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Rolejingjirank
/*    */ {
/*    */   public static RoleJingJiRank get(Long key)
/*    */   {
/* 12 */     return (RoleJingJiRank)_Tables_.getInstance().rolejingjirank.get(key);
/*    */   }
/*    */   
/*    */   public static RoleJingJiRank get(Long key, RoleJingJiRank value)
/*    */   {
/* 17 */     return (RoleJingJiRank)_Tables_.getInstance().rolejingjirank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleJingJiRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().rolejingjirank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().rolejingjirank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleJingJiRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().rolejingjirank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().rolejingjirank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleJingJiRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().rolejingjirank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleJingJiRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().rolejingjirank;
/*    */   }
/*    */   
/*    */   public static RoleJingJiRank select(Long key)
/*    */   {
/* 52 */     (RoleJingJiRank)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleJingJiRank get(RoleJingJiRank v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<RoleJingJiBean> selectRankdatas(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<RoleJingJiBean> get(RoleJingJiRank v)
/*    */       {
/* 67 */         return v.getRankdatasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Rolejingjirank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */