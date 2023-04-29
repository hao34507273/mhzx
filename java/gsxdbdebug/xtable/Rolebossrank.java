/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.RoleBossBean;
/*    */ import xbean.RoleBossRank;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Rolebossrank
/*    */ {
/*    */   public static RoleBossRank get(Long key)
/*    */   {
/* 12 */     return (RoleBossRank)_Tables_.getInstance().rolebossrank.get(key);
/*    */   }
/*    */   
/*    */   public static RoleBossRank get(Long key, RoleBossRank value)
/*    */   {
/* 17 */     return (RoleBossRank)_Tables_.getInstance().rolebossrank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleBossRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().rolebossrank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().rolebossrank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleBossRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().rolebossrank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().rolebossrank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleBossRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().rolebossrank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleBossRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().rolebossrank;
/*    */   }
/*    */   
/*    */   public static RoleBossRank select(Long key)
/*    */   {
/* 52 */     (RoleBossRank)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleBossRank get(RoleBossRank v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<RoleBossBean> selectRankdatas(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<RoleBossBean> get(RoleBossRank v)
/*    */       {
/* 67 */         return v.getRankdatasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Rolebossrank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */