/*    */ package xtable;
/*    */ 
/*    */ import xbean.Role2PetBean;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Role2petoutfightbean
/*    */ {
/*    */   public static Role2PetBean get(Long key)
/*    */   {
/* 12 */     return (Role2PetBean)_Tables_.getInstance().role2petoutfightbean.get(key);
/*    */   }
/*    */   
/*    */   public static Role2PetBean get(Long key, Role2PetBean value)
/*    */   {
/* 17 */     return (Role2PetBean)_Tables_.getInstance().role2petoutfightbean.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Role2PetBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2petoutfightbean.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2petoutfightbean.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Role2PetBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2petoutfightbean.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2petoutfightbean.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, Role2PetBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2petoutfightbean.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Role2PetBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2petoutfightbean;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2petoutfightbean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */