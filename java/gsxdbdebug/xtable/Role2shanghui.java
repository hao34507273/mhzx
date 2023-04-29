/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleShangHuiBean;
/*    */ import xbean.RoleShangHuiItem;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2shanghui
/*    */ {
/*    */   public static RoleShangHuiBean get(Long key)
/*    */   {
/* 12 */     return (RoleShangHuiBean)_Tables_.getInstance().role2shanghui.get(key);
/*    */   }
/*    */   
/*    */   public static RoleShangHuiBean get(Long key, RoleShangHuiBean value)
/*    */   {
/* 17 */     return (RoleShangHuiBean)_Tables_.getInstance().role2shanghui.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleShangHuiBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2shanghui.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2shanghui.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleShangHuiBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2shanghui.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2shanghui.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleShangHuiBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2shanghui.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleShangHuiBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2shanghui;
/*    */   }
/*    */   
/*    */   public static RoleShangHuiBean select(Long key)
/*    */   {
/* 52 */     (RoleShangHuiBean)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleShangHuiBean get(RoleShangHuiBean v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, RoleShangHuiItem> selectItemmap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, RoleShangHuiItem> get(RoleShangHuiBean v)
/*    */       {
/* 67 */         return v.getItemmapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectTimestamp(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Long get(RoleShangHuiBean v)
/*    */       {
/* 78 */         return Long.valueOf(v.getTimestamp());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2shanghui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */