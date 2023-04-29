/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleBuff;
/*    */ import xbean.RoleBuffList;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2buff
/*    */ {
/*    */   public static RoleBuffList get(Long key)
/*    */   {
/* 12 */     return (RoleBuffList)_Tables_.getInstance().role2buff.get(key);
/*    */   }
/*    */   
/*    */   public static RoleBuffList get(Long key, RoleBuffList value)
/*    */   {
/* 17 */     return (RoleBuffList)_Tables_.getInstance().role2buff.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleBuffList value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2buff.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2buff.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleBuffList value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2buff.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2buff.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleBuffList> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2buff.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleBuffList> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2buff;
/*    */   }
/*    */   
/*    */   public static RoleBuffList select(Long key)
/*    */   {
/* 52 */     (RoleBuffList)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleBuffList get(RoleBuffList v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, RoleBuff> selectBuffmap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, RoleBuff> get(RoleBuffList v)
/*    */       {
/* 67 */         return v.getBuffmapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2buff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */