/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.DayTargetInfo;
/*    */ import xbean.TargetInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2daytargetinfo
/*    */ {
/*    */   public static DayTargetInfo get(Long key)
/*    */   {
/* 12 */     return (DayTargetInfo)_Tables_.getInstance().role2daytargetinfo.get(key);
/*    */   }
/*    */   
/*    */   public static DayTargetInfo get(Long key, DayTargetInfo value)
/*    */   {
/* 17 */     return (DayTargetInfo)_Tables_.getInstance().role2daytargetinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, DayTargetInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2daytargetinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2daytargetinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, DayTargetInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2daytargetinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2daytargetinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, DayTargetInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2daytargetinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, DayTargetInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2daytargetinfo;
/*    */   }
/*    */   
/*    */   public static DayTargetInfo select(Long key)
/*    */   {
/* 52 */     (DayTargetInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public DayTargetInfo get(DayTargetInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectLastcleartime(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Long get(DayTargetInfo v)
/*    */       {
/* 67 */         return Long.valueOf(v.getLastcleartime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, TargetInfo> selectTargets(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, TargetInfo> get(DayTargetInfo v)
/*    */       {
/* 78 */         return v.getTargetsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2daytargetinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */