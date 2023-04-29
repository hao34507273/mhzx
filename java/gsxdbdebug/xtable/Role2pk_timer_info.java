/*    */ package xtable;
/*    */ 
/*    */ import xbean.RolePKTimerInformation;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2pk_timer_info
/*    */ {
/*    */   public static RolePKTimerInformation get(Long key)
/*    */   {
/* 12 */     return (RolePKTimerInformation)_Tables_.getInstance().role2pk_timer_info.get(key);
/*    */   }
/*    */   
/*    */   public static RolePKTimerInformation get(Long key, RolePKTimerInformation value)
/*    */   {
/* 17 */     return (RolePKTimerInformation)_Tables_.getInstance().role2pk_timer_info.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RolePKTimerInformation value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2pk_timer_info.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2pk_timer_info.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RolePKTimerInformation value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2pk_timer_info.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2pk_timer_info.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, RolePKTimerInformation> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2pk_timer_info.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RolePKTimerInformation> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2pk_timer_info;
/*    */   }
/*    */   
/*    */   public static RolePKTimerInformation select(Long key)
/*    */   {
/* 52 */     (RolePKTimerInformation)getTable().select(key, new TField()
/*    */     {
/*    */       public RolePKTimerInformation get(RolePKTimerInformation v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectPk_mode_session_id(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(RolePKTimerInformation v)
/*    */       {
/* 67 */         return Long.valueOf(v.getPk_mode_session_id());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectProtection_session_id(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(RolePKTimerInformation v)
/*    */       {
/* 78 */         return Long.valueOf(v.getProtection_session_id());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectForce_protection_session_id(Long key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(RolePKTimerInformation v)
/*    */       {
/* 89 */         return Long.valueOf(v.getForce_protection_session_id());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2pk_timer_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */