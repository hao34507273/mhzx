/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.IdipNTimesAwardInfo;
/*    */ import xbean.Role2NTimesAwardInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2ntimesaward
/*    */ {
/*    */   public static Role2NTimesAwardInfo get(Long key)
/*    */   {
/* 12 */     return (Role2NTimesAwardInfo)_Tables_.getInstance().role2ntimesaward.get(key);
/*    */   }
/*    */   
/*    */   public static Role2NTimesAwardInfo get(Long key, Role2NTimesAwardInfo value)
/*    */   {
/* 17 */     return (Role2NTimesAwardInfo)_Tables_.getInstance().role2ntimesaward.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Role2NTimesAwardInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2ntimesaward.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2ntimesaward.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Role2NTimesAwardInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2ntimesaward.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2ntimesaward.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Role2NTimesAwardInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2ntimesaward.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Role2NTimesAwardInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2ntimesaward;
/*    */   }
/*    */   
/*    */   public static Role2NTimesAwardInfo select(Long key)
/*    */   {
/* 52 */     (Role2NTimesAwardInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Role2NTimesAwardInfo get(Role2NTimesAwardInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, IdipNTimesAwardInfo> selectN_times_award_role_map(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, IdipNTimesAwardInfo> get(Role2NTimesAwardInfo v)
/*    */       {
/* 67 */         return v.getN_times_award_role_mapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2ntimesaward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */