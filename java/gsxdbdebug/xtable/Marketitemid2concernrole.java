/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.ConcernRoleIdSet;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Marketitemid2concernrole
/*    */ {
/*    */   public static ConcernRoleIdSet get(Long key)
/*    */   {
/* 12 */     return (ConcernRoleIdSet)_Tables_.getInstance().marketitemid2concernrole.get(key);
/*    */   }
/*    */   
/*    */   public static ConcernRoleIdSet get(Long key, ConcernRoleIdSet value)
/*    */   {
/* 17 */     return (ConcernRoleIdSet)_Tables_.getInstance().marketitemid2concernrole.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ConcernRoleIdSet value)
/*    */   {
/* 22 */     _Tables_.getInstance().marketitemid2concernrole.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().marketitemid2concernrole.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ConcernRoleIdSet value)
/*    */   {
/* 32 */     return _Tables_.getInstance().marketitemid2concernrole.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().marketitemid2concernrole.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ConcernRoleIdSet> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().marketitemid2concernrole.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ConcernRoleIdSet> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().marketitemid2concernrole;
/*    */   }
/*    */   
/*    */   public static ConcernRoleIdSet select(Long key)
/*    */   {
/* 52 */     (ConcernRoleIdSet)getTable().select(key, new TField()
/*    */     {
/*    */       public ConcernRoleIdSet get(ConcernRoleIdSet v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Long> selectRoleids(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Long> get(ConcernRoleIdSet v)
/*    */       {
/* 67 */         return v.getRoleidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Marketitemid2concernrole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */