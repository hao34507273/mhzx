/*    */ package xtable;
/*    */ 
/*    */ import xbean.CoupleQuestionInfo;
/*    */ import xbean.Role2CoupleDailyInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2coupledaily
/*    */ {
/*    */   public static Role2CoupleDailyInfo get(Long key)
/*    */   {
/* 12 */     return (Role2CoupleDailyInfo)_Tables_.getInstance().role2coupledaily.get(key);
/*    */   }
/*    */   
/*    */   public static Role2CoupleDailyInfo get(Long key, Role2CoupleDailyInfo value)
/*    */   {
/* 17 */     return (Role2CoupleDailyInfo)_Tables_.getInstance().role2coupledaily.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Role2CoupleDailyInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2coupledaily.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2coupledaily.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Role2CoupleDailyInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2coupledaily.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2coupledaily.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Role2CoupleDailyInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2coupledaily.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Role2CoupleDailyInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2coupledaily;
/*    */   }
/*    */   
/*    */   public static Role2CoupleDailyInfo select(Long key)
/*    */   {
/* 52 */     (Role2CoupleDailyInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public Role2CoupleDailyInfo get(Role2CoupleDailyInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static java.util.List<xbean.TaskInfo> selectTasklist(Long key)
/*    */   {
/* 63 */     (java.util.List)getTable().select(key, new TField()
/*    */     {
/*    */       public java.util.List<xbean.TaskInfo> get(Role2CoupleDailyInfo v)
/*    */       {
/* 67 */         return v.getTasklistAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectIsawarded(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(Role2CoupleDailyInfo v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getIsawarded());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectPartnerroleid(Long key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(Role2CoupleDailyInfo v)
/*    */       {
/* 89 */         return Long.valueOf(v.getPartnerroleid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static CoupleQuestionInfo selectCouplequestioninfo(Long key)
/*    */   {
/* 96 */     (CoupleQuestionInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public CoupleQuestionInfo get(Role2CoupleDailyInfo v)
/*    */       {
/* :0 */         return v.getCouplequestioninfo().toData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2coupledaily.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */