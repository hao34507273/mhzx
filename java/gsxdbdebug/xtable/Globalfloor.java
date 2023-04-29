/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.GlobalFloorActivityInfo;
/*    */ import xbean.GlobalFloorInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Globalfloor
/*    */ {
/*    */   public static GlobalFloorActivityInfo get(Long key)
/*    */   {
/* 12 */     return (GlobalFloorActivityInfo)_Tables_.getInstance().globalfloor.get(key);
/*    */   }
/*    */   
/*    */   public static GlobalFloorActivityInfo get(Long key, GlobalFloorActivityInfo value)
/*    */   {
/* 17 */     return (GlobalFloorActivityInfo)_Tables_.getInstance().globalfloor.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GlobalFloorActivityInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().globalfloor.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().globalfloor.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GlobalFloorActivityInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().globalfloor.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().globalfloor.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, GlobalFloorActivityInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().globalfloor.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GlobalFloorActivityInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().globalfloor;
/*    */   }
/*    */   
/*    */   public static GlobalFloorActivityInfo select(Long key)
/*    */   {
/* 52 */     (GlobalFloorActivityInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public GlobalFloorActivityInfo get(GlobalFloorActivityInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, GlobalFloorInfo> selectActivityinfo(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, GlobalFloorInfo> get(GlobalFloorActivityInfo v)
/*    */       {
/* 67 */         return v.getActivityinfoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Globalfloor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */