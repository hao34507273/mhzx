/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.RoleGiveFlowerBean;
/*    */ import xbean.RoleGiveFlowerRank;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Rolegiveflowerrank
/*    */ {
/*    */   public static RoleGiveFlowerRank get(Long key)
/*    */   {
/* 12 */     return (RoleGiveFlowerRank)_Tables_.getInstance().rolegiveflowerrank.get(key);
/*    */   }
/*    */   
/*    */   public static RoleGiveFlowerRank get(Long key, RoleGiveFlowerRank value)
/*    */   {
/* 17 */     return (RoleGiveFlowerRank)_Tables_.getInstance().rolegiveflowerrank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleGiveFlowerRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().rolegiveflowerrank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().rolegiveflowerrank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleGiveFlowerRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().rolegiveflowerrank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().rolegiveflowerrank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleGiveFlowerRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().rolegiveflowerrank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleGiveFlowerRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().rolegiveflowerrank;
/*    */   }
/*    */   
/*    */   public static RoleGiveFlowerRank select(Long key)
/*    */   {
/* 52 */     (RoleGiveFlowerRank)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleGiveFlowerRank get(RoleGiveFlowerRank v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<RoleGiveFlowerBean> selectRankdatas(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<RoleGiveFlowerBean> get(RoleGiveFlowerRank v)
/*    */       {
/* 67 */         return v.getRankdatasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectVersion(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Integer get(RoleGiveFlowerRank v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getVersion());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Rolegiveflowerrank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */