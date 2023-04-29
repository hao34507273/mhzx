/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.JingJiDailyRank;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Jingjidailytrankbackup
/*    */ {
/*    */   public static JingJiDailyRank get(Long key)
/*    */   {
/* 12 */     return (JingJiDailyRank)_Tables_.getInstance().jingjidailytrankbackup.get(key);
/*    */   }
/*    */   
/*    */   public static JingJiDailyRank get(Long key, JingJiDailyRank value)
/*    */   {
/* 17 */     return (JingJiDailyRank)_Tables_.getInstance().jingjidailytrankbackup.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, JingJiDailyRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().jingjidailytrankbackup.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().jingjidailytrankbackup.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, JingJiDailyRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().jingjidailytrankbackup.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().jingjidailytrankbackup.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, JingJiDailyRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().jingjidailytrankbackup.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, JingJiDailyRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().jingjidailytrankbackup;
/*    */   }
/*    */   
/*    */   public static JingJiDailyRank select(Long key)
/*    */   {
/* 52 */     (JingJiDailyRank)getTable().select(key, new TField()
/*    */     {
/*    */       public JingJiDailyRank get(JingJiDailyRank v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static java.util.List<xbean.RoleJingJiBean> selectRank_datas(Long key)
/*    */   {
/* 63 */     (java.util.List)getTable().select(key, new TField()
/*    */     {
/*    */       public java.util.List<xbean.RoleJingJiBean> get(JingJiDailyRank v)
/*    */       {
/* 67 */         return v.getRank_datasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectTime(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(JingJiDailyRank v)
/*    */       {
/* 78 */         return Long.valueOf(v.getTime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, Integer> selectRole_ranks(Long key)
/*    */   {
/* 85 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, Integer> get(JingJiDailyRank v)
/*    */       {
/* 89 */         return v.getRole_ranksAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Jingjidailytrankbackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */