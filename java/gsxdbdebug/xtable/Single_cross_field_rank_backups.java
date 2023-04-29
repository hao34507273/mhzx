/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.SingleCrossFieldRankBackup;
/*    */ import xbean.SingleCrossFieldSeasonRankBackup;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Single_cross_field_rank_backups
/*    */ {
/*    */   public static SingleCrossFieldRankBackup get(Long key)
/*    */   {
/* 12 */     return (SingleCrossFieldRankBackup)_Tables_.getInstance().single_cross_field_rank_backups.get(key);
/*    */   }
/*    */   
/*    */   public static SingleCrossFieldRankBackup get(Long key, SingleCrossFieldRankBackup value)
/*    */   {
/* 17 */     return (SingleCrossFieldRankBackup)_Tables_.getInstance().single_cross_field_rank_backups.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, SingleCrossFieldRankBackup value)
/*    */   {
/* 22 */     _Tables_.getInstance().single_cross_field_rank_backups.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().single_cross_field_rank_backups.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, SingleCrossFieldRankBackup value)
/*    */   {
/* 32 */     return _Tables_.getInstance().single_cross_field_rank_backups.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().single_cross_field_rank_backups.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, SingleCrossFieldRankBackup> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().single_cross_field_rank_backups.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, SingleCrossFieldRankBackup> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().single_cross_field_rank_backups;
/*    */   }
/*    */   
/*    */   public static SingleCrossFieldRankBackup select(Long key)
/*    */   {
/* 52 */     (SingleCrossFieldRankBackup)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public SingleCrossFieldRankBackup get(SingleCrossFieldRankBackup v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, SingleCrossFieldSeasonRankBackup> selectBackups(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, SingleCrossFieldSeasonRankBackup> get(SingleCrossFieldRankBackup v)
/*    */       {
/* 67 */         return v.getBackupsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Single_cross_field_rank_backups.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */