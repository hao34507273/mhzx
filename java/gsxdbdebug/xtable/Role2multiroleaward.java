/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.MultiRoleAwards;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2multiroleaward
/*    */ {
/*    */   public static MultiRoleAwards get(Long key)
/*    */   {
/* 12 */     return (MultiRoleAwards)_Tables_.getInstance().role2multiroleaward.get(key);
/*    */   }
/*    */   
/*    */   public static MultiRoleAwards get(Long key, MultiRoleAwards value)
/*    */   {
/* 17 */     return (MultiRoleAwards)_Tables_.getInstance().role2multiroleaward.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MultiRoleAwards value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2multiroleaward.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2multiroleaward.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MultiRoleAwards value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2multiroleaward.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2multiroleaward.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MultiRoleAwards> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2multiroleaward.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MultiRoleAwards> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2multiroleaward;
/*    */   }
/*    */   
/*    */   public static MultiRoleAwards select(Long key)
/*    */   {
/* 52 */     (MultiRoleAwards)getTable().select(key, new TField()
/*    */     {
/*    */       public MultiRoleAwards get(MultiRoleAwards v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Long> selectAwards(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Long> get(MultiRoleAwards v)
/*    */       {
/* 67 */         return v.getAwardsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2multiroleaward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */