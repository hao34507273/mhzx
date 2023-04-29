/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.ReportInfo;
/*    */ import xbean.ReportRecord;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2report
/*    */ {
/*    */   public static ReportInfo get(Long key)
/*    */   {
/* 12 */     return (ReportInfo)_Tables_.getInstance().role2report.get(key);
/*    */   }
/*    */   
/*    */   public static ReportInfo get(Long key, ReportInfo value)
/*    */   {
/* 17 */     return (ReportInfo)_Tables_.getInstance().role2report.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ReportInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2report.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2report.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ReportInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2report.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2report.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ReportInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2report.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ReportInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2report;
/*    */   }
/*    */   
/*    */   public static ReportInfo select(Long key)
/*    */   {
/* 52 */     (ReportInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public ReportInfo get(ReportInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, ReportRecord> selectReport_records(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Long, ReportRecord> get(ReportInfo v)
/*    */       {
/* 67 */         return v.getReport_recordsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectReport_timestamp(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Long get(ReportInfo v)
/*    */       {
/* 78 */         return Long.valueOf(v.getReport_timestamp());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2report.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */