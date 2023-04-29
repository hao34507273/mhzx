/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.TimeFlowInfo;
/*    */ import xbean.TimeFlowInfos;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Timeflows
/*    */ {
/*    */   public static TimeFlowInfos get(Long key)
/*    */   {
/* 12 */     return (TimeFlowInfos)_Tables_.getInstance().timeflows.get(key);
/*    */   }
/*    */   
/*    */   public static TimeFlowInfos get(Long key, TimeFlowInfos value)
/*    */   {
/* 17 */     return (TimeFlowInfos)_Tables_.getInstance().timeflows.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, TimeFlowInfos value)
/*    */   {
/* 22 */     _Tables_.getInstance().timeflows.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().timeflows.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, TimeFlowInfos value)
/*    */   {
/* 32 */     return _Tables_.getInstance().timeflows.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().timeflows.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, TimeFlowInfos> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().timeflows.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, TimeFlowInfos> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().timeflows;
/*    */   }
/*    */   
/*    */   public static TimeFlowInfos select(Long key)
/*    */   {
/* 52 */     (TimeFlowInfos)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public TimeFlowInfos get(TimeFlowInfos v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, TimeFlowInfo> selectFlows(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, TimeFlowInfo> get(TimeFlowInfos v)
/*    */       {
/* 67 */         return v.getFlowsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Timeflows.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */