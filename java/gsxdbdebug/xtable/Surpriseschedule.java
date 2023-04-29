/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.SurpriseScheduleInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Surpriseschedule
/*    */ {
/*    */   public static SurpriseScheduleInfo get(Long key)
/*    */   {
/* 12 */     return (SurpriseScheduleInfo)_Tables_.getInstance().surpriseschedule.get(key);
/*    */   }
/*    */   
/*    */   public static SurpriseScheduleInfo get(Long key, SurpriseScheduleInfo value)
/*    */   {
/* 17 */     return (SurpriseScheduleInfo)_Tables_.getInstance().surpriseschedule.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, SurpriseScheduleInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().surpriseschedule.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().surpriseschedule.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, SurpriseScheduleInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().surpriseschedule.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().surpriseschedule.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, SurpriseScheduleInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().surpriseschedule.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, SurpriseScheduleInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().surpriseschedule;
/*    */   }
/*    */   
/*    */   public static SurpriseScheduleInfo select(Long key)
/*    */   {
/* 52 */     (SurpriseScheduleInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public SurpriseScheduleInfo get(SurpriseScheduleInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Integer> selectOpenedgraphids(Long key)
/*    */   {
/* 63 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Integer> get(SurpriseScheduleInfo v)
/*    */       {
/* 67 */         return v.getOpenedgraphidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Surpriseschedule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */