/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.NoneRealRoleMultiFightValueBean;
/*    */ import xbean.NoneRealTimeMultiFightValueRankBackUp;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Nonerealtimemultifightvaluerankbackup
/*    */ {
/*    */   public static NoneRealTimeMultiFightValueRankBackUp get(Long key)
/*    */   {
/* 12 */     return (NoneRealTimeMultiFightValueRankBackUp)_Tables_.getInstance().nonerealtimemultifightvaluerankbackup.get(key);
/*    */   }
/*    */   
/*    */   public static NoneRealTimeMultiFightValueRankBackUp get(Long key, NoneRealTimeMultiFightValueRankBackUp value)
/*    */   {
/* 17 */     return (NoneRealTimeMultiFightValueRankBackUp)_Tables_.getInstance().nonerealtimemultifightvaluerankbackup.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, NoneRealTimeMultiFightValueRankBackUp value)
/*    */   {
/* 22 */     _Tables_.getInstance().nonerealtimemultifightvaluerankbackup.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().nonerealtimemultifightvaluerankbackup.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, NoneRealTimeMultiFightValueRankBackUp value)
/*    */   {
/* 32 */     return _Tables_.getInstance().nonerealtimemultifightvaluerankbackup.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().nonerealtimemultifightvaluerankbackup.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, NoneRealTimeMultiFightValueRankBackUp> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().nonerealtimemultifightvaluerankbackup.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, NoneRealTimeMultiFightValueRankBackUp> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().nonerealtimemultifightvaluerankbackup;
/*    */   }
/*    */   
/*    */   public static NoneRealTimeMultiFightValueRankBackUp select(Long key)
/*    */   {
/* 52 */     (NoneRealTimeMultiFightValueRankBackUp)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public NoneRealTimeMultiFightValueRankBackUp get(NoneRealTimeMultiFightValueRankBackUp v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<NoneRealRoleMultiFightValueBean> selectRankdatas(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<NoneRealRoleMultiFightValueBean> get(NoneRealTimeMultiFightValueRankBackUp v)
/*    */       {
/* 67 */         return v.getRankdatasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Nonerealtimemultifightvaluerankbackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */