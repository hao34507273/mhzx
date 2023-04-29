/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.DayTargetData;
/*    */ import xbean.TargetData;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2daytargetdata
/*    */ {
/*    */   public static DayTargetData get(Long key)
/*    */   {
/* 12 */     return (DayTargetData)_Tables_.getInstance().role2daytargetdata.get(key);
/*    */   }
/*    */   
/*    */   public static DayTargetData get(Long key, DayTargetData value)
/*    */   {
/* 17 */     return (DayTargetData)_Tables_.getInstance().role2daytargetdata.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, DayTargetData value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2daytargetdata.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2daytargetdata.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, DayTargetData value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2daytargetdata.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2daytargetdata.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, DayTargetData> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2daytargetdata.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, DayTargetData> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2daytargetdata;
/*    */   }
/*    */   
/*    */   public static DayTargetData select(Long key)
/*    */   {
/* 52 */     (DayTargetData)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public DayTargetData get(DayTargetData v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, TargetData> selectTargets(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, TargetData> get(DayTargetData v)
/*    */       {
/* 67 */         return v.getTargetsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2daytargetdata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */