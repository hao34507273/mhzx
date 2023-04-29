/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.NoneRealTimeSnsRoles;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Nonerealtimesnsroles
/*    */ {
/*    */   public static NoneRealTimeSnsRoles get(Long key)
/*    */   {
/* 12 */     return (NoneRealTimeSnsRoles)_Tables_.getInstance().nonerealtimesnsroles.get(key);
/*    */   }
/*    */   
/*    */   public static NoneRealTimeSnsRoles get(Long key, NoneRealTimeSnsRoles value)
/*    */   {
/* 17 */     return (NoneRealTimeSnsRoles)_Tables_.getInstance().nonerealtimesnsroles.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, NoneRealTimeSnsRoles value)
/*    */   {
/* 22 */     _Tables_.getInstance().nonerealtimesnsroles.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().nonerealtimesnsroles.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, NoneRealTimeSnsRoles value)
/*    */   {
/* 32 */     return _Tables_.getInstance().nonerealtimesnsroles.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().nonerealtimesnsroles.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, NoneRealTimeSnsRoles> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().nonerealtimesnsroles.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, NoneRealTimeSnsRoles> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().nonerealtimesnsroles;
/*    */   }
/*    */   
/*    */   public static NoneRealTimeSnsRoles select(Long key)
/*    */   {
/* 52 */     (NoneRealTimeSnsRoles)getTable().select(key, new TField()
/*    */     {
/*    */       public NoneRealTimeSnsRoles get(NoneRealTimeSnsRoles v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectSavetime(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(NoneRealTimeSnsRoles v)
/*    */       {
/* 67 */         return Long.valueOf(v.getSavetime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Long> selectRoleids(Long key)
/*    */   {
/* 74 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Long> get(NoneRealTimeSnsRoles v)
/*    */       {
/* 78 */         return v.getRoleidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Nonerealtimesnsroles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */