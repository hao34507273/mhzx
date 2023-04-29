/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.CrossBattleBetRankBackup;
/*    */ import xbean.CrossBattleBetSeasonRankBackup;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Cross_battle_bet_rank_backups
/*    */ {
/*    */   public static CrossBattleBetRankBackup get(Long key)
/*    */   {
/* 12 */     return (CrossBattleBetRankBackup)_Tables_.getInstance().cross_battle_bet_rank_backups.get(key);
/*    */   }
/*    */   
/*    */   public static CrossBattleBetRankBackup get(Long key, CrossBattleBetRankBackup value)
/*    */   {
/* 17 */     return (CrossBattleBetRankBackup)_Tables_.getInstance().cross_battle_bet_rank_backups.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CrossBattleBetRankBackup value)
/*    */   {
/* 22 */     _Tables_.getInstance().cross_battle_bet_rank_backups.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().cross_battle_bet_rank_backups.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CrossBattleBetRankBackup value)
/*    */   {
/* 32 */     return _Tables_.getInstance().cross_battle_bet_rank_backups.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().cross_battle_bet_rank_backups.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, CrossBattleBetRankBackup> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().cross_battle_bet_rank_backups.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CrossBattleBetRankBackup> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().cross_battle_bet_rank_backups;
/*    */   }
/*    */   
/*    */   public static CrossBattleBetRankBackup select(Long key)
/*    */   {
/* 52 */     (CrossBattleBetRankBackup)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public CrossBattleBetRankBackup get(CrossBattleBetRankBackup v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, CrossBattleBetSeasonRankBackup> selectBackups(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, CrossBattleBetSeasonRankBackup> get(CrossBattleBetRankBackup v)
/*    */       {
/* 67 */         return v.getBackupsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Cross_battle_bet_rank_backups.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */