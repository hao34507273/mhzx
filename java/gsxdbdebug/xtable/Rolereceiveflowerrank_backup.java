/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.RoleReceivceFlowerRank;
/*    */ import xbean.RoleReceiveFlowerBean;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Rolereceiveflowerrank_backup
/*    */ {
/*    */   public static RoleReceivceFlowerRank get(Long key)
/*    */   {
/* 12 */     return (RoleReceivceFlowerRank)_Tables_.getInstance().rolereceiveflowerrank_backup.get(key);
/*    */   }
/*    */   
/*    */   public static RoleReceivceFlowerRank get(Long key, RoleReceivceFlowerRank value)
/*    */   {
/* 17 */     return (RoleReceivceFlowerRank)_Tables_.getInstance().rolereceiveflowerrank_backup.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleReceivceFlowerRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().rolereceiveflowerrank_backup.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().rolereceiveflowerrank_backup.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleReceivceFlowerRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().rolereceiveflowerrank_backup.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().rolereceiveflowerrank_backup.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleReceivceFlowerRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().rolereceiveflowerrank_backup.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleReceivceFlowerRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().rolereceiveflowerrank_backup;
/*    */   }
/*    */   
/*    */   public static RoleReceivceFlowerRank select(Long key)
/*    */   {
/* 52 */     (RoleReceivceFlowerRank)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleReceivceFlowerRank get(RoleReceivceFlowerRank v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<RoleReceiveFlowerBean> selectRankdatas(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<RoleReceiveFlowerBean> get(RoleReceivceFlowerRank v)
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
/*    */       public Integer get(RoleReceivceFlowerRank v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getVersion());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Rolereceiveflowerrank_backup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */