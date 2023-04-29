/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.SystemAwardBean;
/*    */ import xbean.SystemAwards;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Systemaward
/*    */ {
/*    */   public static SystemAwards get(Long key)
/*    */   {
/* 12 */     return (SystemAwards)_Tables_.getInstance().systemaward.get(key);
/*    */   }
/*    */   
/*    */   public static SystemAwards get(Long key, SystemAwards value)
/*    */   {
/* 17 */     return (SystemAwards)_Tables_.getInstance().systemaward.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, SystemAwards value)
/*    */   {
/* 22 */     _Tables_.getInstance().systemaward.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().systemaward.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, SystemAwards value)
/*    */   {
/* 32 */     return _Tables_.getInstance().systemaward.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().systemaward.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, SystemAwards> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().systemaward.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, SystemAwards> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().systemaward;
/*    */   }
/*    */   
/*    */   public static SystemAwards select(Long key)
/*    */   {
/* 52 */     (SystemAwards)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public SystemAwards get(SystemAwards v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectSequence(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Long get(SystemAwards v)
/*    */       {
/* 67 */         return Long.valueOf(v.getSequence());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, SystemAwardBean> selectAwards(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Long, SystemAwardBean> get(SystemAwards v)
/*    */       {
/* 78 */         return v.getAwardsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Systemaward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */