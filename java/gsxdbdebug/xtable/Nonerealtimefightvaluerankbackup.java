/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.NoneRealRoleFightValueBean;
/*    */ import xbean.NoneRealTimeFightValueRankBackUp;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Nonerealtimefightvaluerankbackup
/*    */ {
/*    */   public static NoneRealTimeFightValueRankBackUp get(Long key)
/*    */   {
/* 12 */     return (NoneRealTimeFightValueRankBackUp)_Tables_.getInstance().nonerealtimefightvaluerankbackup.get(key);
/*    */   }
/*    */   
/*    */   public static NoneRealTimeFightValueRankBackUp get(Long key, NoneRealTimeFightValueRankBackUp value)
/*    */   {
/* 17 */     return (NoneRealTimeFightValueRankBackUp)_Tables_.getInstance().nonerealtimefightvaluerankbackup.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, NoneRealTimeFightValueRankBackUp value)
/*    */   {
/* 22 */     _Tables_.getInstance().nonerealtimefightvaluerankbackup.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().nonerealtimefightvaluerankbackup.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, NoneRealTimeFightValueRankBackUp value)
/*    */   {
/* 32 */     return _Tables_.getInstance().nonerealtimefightvaluerankbackup.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().nonerealtimefightvaluerankbackup.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, NoneRealTimeFightValueRankBackUp> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().nonerealtimefightvaluerankbackup.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, NoneRealTimeFightValueRankBackUp> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().nonerealtimefightvaluerankbackup;
/*    */   }
/*    */   
/*    */   public static NoneRealTimeFightValueRankBackUp select(Long key)
/*    */   {
/* 52 */     (NoneRealTimeFightValueRankBackUp)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public NoneRealTimeFightValueRankBackUp get(NoneRealTimeFightValueRankBackUp v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<NoneRealRoleFightValueBean> selectRankdatas(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<NoneRealRoleFightValueBean> get(NoneRealTimeFightValueRankBackUp v)
/*    */       {
/* 67 */         return v.getRankdatasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Nonerealtimefightvaluerankbackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */