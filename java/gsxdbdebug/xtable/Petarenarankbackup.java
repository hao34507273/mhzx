/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.PetArenaRankBackup;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Petarenarankbackup
/*    */ {
/*    */   public static PetArenaRankBackup get(Long key)
/*    */   {
/* 12 */     return (PetArenaRankBackup)_Tables_.getInstance().petarenarankbackup.get(key);
/*    */   }
/*    */   
/*    */   public static PetArenaRankBackup get(Long key, PetArenaRankBackup value)
/*    */   {
/* 17 */     return (PetArenaRankBackup)_Tables_.getInstance().petarenarankbackup.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, PetArenaRankBackup value)
/*    */   {
/* 22 */     _Tables_.getInstance().petarenarankbackup.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().petarenarankbackup.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, PetArenaRankBackup value)
/*    */   {
/* 32 */     return _Tables_.getInstance().petarenarankbackup.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().petarenarankbackup.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, PetArenaRankBackup> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().petarenarankbackup.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, PetArenaRankBackup> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().petarenarankbackup;
/*    */   }
/*    */   
/*    */   public static PetArenaRankBackup select(Long key)
/*    */   {
/* 52 */     (PetArenaRankBackup)getTable().select(key, new TField()
/*    */     {
/*    */       public PetArenaRankBackup get(PetArenaRankBackup v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, Integer> selectRole_ranks(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, Integer> get(PetArenaRankBackup v)
/*    */       {
/* 67 */         return v.getRole_ranksAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, Integer> selectAwards(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, Integer> get(PetArenaRankBackup v)
/*    */       {
/* 78 */         return v.getAwardsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectAward_time(Long key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(PetArenaRankBackup v)
/*    */       {
/* 89 */         return Long.valueOf(v.getAward_time());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Petarenarankbackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */