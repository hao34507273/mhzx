/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.LoginAward;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2loginaward
/*    */ {
/*    */   public static LoginAward get(Long key)
/*    */   {
/* 12 */     return (LoginAward)_Tables_.getInstance().role2loginaward.get(key);
/*    */   }
/*    */   
/*    */   public static LoginAward get(Long key, LoginAward value)
/*    */   {
/* 17 */     return (LoginAward)_Tables_.getInstance().role2loginaward.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, LoginAward value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2loginaward.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2loginaward.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, LoginAward value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2loginaward.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2loginaward.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, LoginAward> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2loginaward.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, LoginAward> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2loginaward;
/*    */   }
/*    */   
/*    */   public static LoginAward select(Long key)
/*    */   {
/* 52 */     (LoginAward)getTable().select(key, new TField()
/*    */     {
/*    */       public LoginAward get(LoginAward v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectLogintime(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(LoginAward v)
/*    */       {
/* 67 */         return Long.valueOf(v.getLogintime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectLoginday(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(LoginAward v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getLoginday());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Integer> selectDayawardlist(Long key)
/*    */   {
/* 85 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Integer> get(LoginAward v)
/*    */       {
/* 89 */         return v.getDayawardlistAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2loginaward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */