/*    */ package xtable;
/*    */ 
/*    */ import xbean.RoleMysteryVisitorInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role_mystery_visitor_infos
/*    */ {
/*    */   public static RoleMysteryVisitorInfo get(Long key)
/*    */   {
/* 12 */     return (RoleMysteryVisitorInfo)_Tables_.getInstance().role_mystery_visitor_infos.get(key);
/*    */   }
/*    */   
/*    */   public static RoleMysteryVisitorInfo get(Long key, RoleMysteryVisitorInfo value)
/*    */   {
/* 17 */     return (RoleMysteryVisitorInfo)_Tables_.getInstance().role_mystery_visitor_infos.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleMysteryVisitorInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role_mystery_visitor_infos.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role_mystery_visitor_infos.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleMysteryVisitorInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role_mystery_visitor_infos.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role_mystery_visitor_infos.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, RoleMysteryVisitorInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role_mystery_visitor_infos.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleMysteryVisitorInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role_mystery_visitor_infos;
/*    */   }
/*    */   
/*    */   public static RoleMysteryVisitorInfo select(Long key)
/*    */   {
/* 52 */     (RoleMysteryVisitorInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleMysteryVisitorInfo get(RoleMysteryVisitorInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectMystery_visitor_cfg_id(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RoleMysteryVisitorInfo v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getMystery_visitor_cfg_id());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role_mystery_visitor_infos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */