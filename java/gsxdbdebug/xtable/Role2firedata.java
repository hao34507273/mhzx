/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.ActivityFireData;
/*    */ import xbean.RoleFireData;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2firedata
/*    */ {
/*    */   public static RoleFireData get(Long key)
/*    */   {
/* 12 */     return (RoleFireData)_Tables_.getInstance().role2firedata.get(key);
/*    */   }
/*    */   
/*    */   public static RoleFireData get(Long key, RoleFireData value)
/*    */   {
/* 17 */     return (RoleFireData)_Tables_.getInstance().role2firedata.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleFireData value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2firedata.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2firedata.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleFireData value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2firedata.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2firedata.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleFireData> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2firedata.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleFireData> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2firedata;
/*    */   }
/*    */   
/*    */   public static RoleFireData select(Long key)
/*    */   {
/* 52 */     (RoleFireData)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleFireData get(RoleFireData v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, ActivityFireData> selectActivitydata(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, ActivityFireData> get(RoleFireData v)
/*    */       {
/* 67 */         return v.getActivitydataAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2firedata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */