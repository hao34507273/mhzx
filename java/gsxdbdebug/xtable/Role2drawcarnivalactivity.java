/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.DrawCarnivalRoleActivityInfo;
/*    */ import xbean.DrawCarnivalRoleInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2drawcarnivalactivity
/*    */ {
/*    */   public static DrawCarnivalRoleInfo get(Long key)
/*    */   {
/* 12 */     return (DrawCarnivalRoleInfo)_Tables_.getInstance().role2drawcarnivalactivity.get(key);
/*    */   }
/*    */   
/*    */   public static DrawCarnivalRoleInfo get(Long key, DrawCarnivalRoleInfo value)
/*    */   {
/* 17 */     return (DrawCarnivalRoleInfo)_Tables_.getInstance().role2drawcarnivalactivity.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, DrawCarnivalRoleInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2drawcarnivalactivity.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2drawcarnivalactivity.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, DrawCarnivalRoleInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2drawcarnivalactivity.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2drawcarnivalactivity.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, DrawCarnivalRoleInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2drawcarnivalactivity.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, DrawCarnivalRoleInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2drawcarnivalactivity;
/*    */   }
/*    */   
/*    */   public static DrawCarnivalRoleInfo select(Long key)
/*    */   {
/* 52 */     (DrawCarnivalRoleInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public DrawCarnivalRoleInfo get(DrawCarnivalRoleInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, DrawCarnivalRoleActivityInfo> selectActivity_id2role_info(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, DrawCarnivalRoleActivityInfo> get(DrawCarnivalRoleInfo v)
/*    */       {
/* 67 */         return v.getActivity_id2role_infoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2drawcarnivalactivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */