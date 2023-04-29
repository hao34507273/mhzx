/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.CrossLadderRankBackup;
/*    */ import xbean.CrossLadderSeasonRankBackup;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Cross_ladder_rank_backups
/*    */ {
/*    */   public static CrossLadderRankBackup get(Long key)
/*    */   {
/* 12 */     return (CrossLadderRankBackup)_Tables_.getInstance().cross_ladder_rank_backups.get(key);
/*    */   }
/*    */   
/*    */   public static CrossLadderRankBackup get(Long key, CrossLadderRankBackup value)
/*    */   {
/* 17 */     return (CrossLadderRankBackup)_Tables_.getInstance().cross_ladder_rank_backups.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CrossLadderRankBackup value)
/*    */   {
/* 22 */     _Tables_.getInstance().cross_ladder_rank_backups.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().cross_ladder_rank_backups.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CrossLadderRankBackup value)
/*    */   {
/* 32 */     return _Tables_.getInstance().cross_ladder_rank_backups.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().cross_ladder_rank_backups.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, CrossLadderRankBackup> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().cross_ladder_rank_backups.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CrossLadderRankBackup> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().cross_ladder_rank_backups;
/*    */   }
/*    */   
/*    */   public static CrossLadderRankBackup select(Long key)
/*    */   {
/* 52 */     (CrossLadderRankBackup)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public CrossLadderRankBackup get(CrossLadderRankBackup v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, CrossLadderSeasonRankBackup> selectBackups(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Long, CrossLadderSeasonRankBackup> get(CrossLadderRankBackup v)
/*    */       {
/* 67 */         return v.getBackupsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectInit_season_begin_timestamp(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Long get(CrossLadderRankBackup v)
/*    */       {
/* 78 */         return Long.valueOf(v.getInit_season_begin_timestamp());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Cross_ladder_rank_backups.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */