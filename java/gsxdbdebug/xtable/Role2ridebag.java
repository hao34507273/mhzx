/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RideInfo;
/*    */ import xbean.RoleRideBag;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2ridebag
/*    */ {
/*    */   public static RoleRideBag get(Long key)
/*    */   {
/* 12 */     return (RoleRideBag)_Tables_.getInstance().role2ridebag.get(key);
/*    */   }
/*    */   
/*    */   public static RoleRideBag get(Long key, RoleRideBag value)
/*    */   {
/* 17 */     return (RoleRideBag)_Tables_.getInstance().role2ridebag.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleRideBag value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2ridebag.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2ridebag.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleRideBag value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2ridebag.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2ridebag.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleRideBag> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2ridebag.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleRideBag> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2ridebag;
/*    */   }
/*    */   
/*    */   public static RoleRideBag select(Long key)
/*    */   {
/* 52 */     (RoleRideBag)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleRideBag get(RoleRideBag v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectMountid(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Integer get(RoleRideBag v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getMountid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, RideInfo> selectRidemap(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, RideInfo> get(RoleRideBag v)
/*    */       {
/* 78 */         return v.getRidemapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2ridebag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */