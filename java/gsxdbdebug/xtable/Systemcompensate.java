/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.CompensateInfo;
/*    */ import xbean.SystemCompensateInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Systemcompensate
/*    */ {
/*    */   public static SystemCompensateInfo get(Long key)
/*    */   {
/* 12 */     return (SystemCompensateInfo)_Tables_.getInstance().systemcompensate.get(key);
/*    */   }
/*    */   
/*    */   public static SystemCompensateInfo get(Long key, SystemCompensateInfo value)
/*    */   {
/* 17 */     return (SystemCompensateInfo)_Tables_.getInstance().systemcompensate.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, SystemCompensateInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().systemcompensate.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().systemcompensate.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, SystemCompensateInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().systemcompensate.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().systemcompensate.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, SystemCompensateInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().systemcompensate.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, SystemCompensateInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().systemcompensate;
/*    */   }
/*    */   
/*    */   public static SystemCompensateInfo select(Long key)
/*    */   {
/* 52 */     (SystemCompensateInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public SystemCompensateInfo get(SystemCompensateInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectNextid(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Integer get(SystemCompensateInfo v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getNextid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, CompensateInfo> selectCompensates(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Long, CompensateInfo> get(SystemCompensateInfo v)
/*    */       {
/* 78 */         return v.getCompensatesAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Systemcompensate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */