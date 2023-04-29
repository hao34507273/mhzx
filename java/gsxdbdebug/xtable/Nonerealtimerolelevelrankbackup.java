/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.NoneRealRoleLevelBean;
/*    */ import xbean.NoneRealTimeRoleLevelRankBackUp;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Nonerealtimerolelevelrankbackup
/*    */ {
/*    */   public static NoneRealTimeRoleLevelRankBackUp get(Long key)
/*    */   {
/* 12 */     return (NoneRealTimeRoleLevelRankBackUp)_Tables_.getInstance().nonerealtimerolelevelrankbackup.get(key);
/*    */   }
/*    */   
/*    */   public static NoneRealTimeRoleLevelRankBackUp get(Long key, NoneRealTimeRoleLevelRankBackUp value)
/*    */   {
/* 17 */     return (NoneRealTimeRoleLevelRankBackUp)_Tables_.getInstance().nonerealtimerolelevelrankbackup.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, NoneRealTimeRoleLevelRankBackUp value)
/*    */   {
/* 22 */     _Tables_.getInstance().nonerealtimerolelevelrankbackup.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().nonerealtimerolelevelrankbackup.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, NoneRealTimeRoleLevelRankBackUp value)
/*    */   {
/* 32 */     return _Tables_.getInstance().nonerealtimerolelevelrankbackup.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().nonerealtimerolelevelrankbackup.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, NoneRealTimeRoleLevelRankBackUp> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().nonerealtimerolelevelrankbackup.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, NoneRealTimeRoleLevelRankBackUp> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().nonerealtimerolelevelrankbackup;
/*    */   }
/*    */   
/*    */   public static NoneRealTimeRoleLevelRankBackUp select(Long key)
/*    */   {
/* 52 */     (NoneRealTimeRoleLevelRankBackUp)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public NoneRealTimeRoleLevelRankBackUp get(NoneRealTimeRoleLevelRankBackUp v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<NoneRealRoleLevelBean> selectRankdatas(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<NoneRealRoleLevelBean> get(NoneRealTimeRoleLevelRankBackUp v)
/*    */       {
/* 67 */         return v.getRankdatasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Nonerealtimerolelevelrankbackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */