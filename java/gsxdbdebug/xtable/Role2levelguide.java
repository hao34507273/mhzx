/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.LevelGuideInfo;
/*    */ import xbean.RoleLevelGuidesInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2levelguide
/*    */ {
/*    */   public static RoleLevelGuidesInfo get(Long key)
/*    */   {
/* 12 */     return (RoleLevelGuidesInfo)_Tables_.getInstance().role2levelguide.get(key);
/*    */   }
/*    */   
/*    */   public static RoleLevelGuidesInfo get(Long key, RoleLevelGuidesInfo value)
/*    */   {
/* 17 */     return (RoleLevelGuidesInfo)_Tables_.getInstance().role2levelguide.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleLevelGuidesInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2levelguide.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2levelguide.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleLevelGuidesInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2levelguide.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2levelguide.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleLevelGuidesInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2levelguide.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleLevelGuidesInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2levelguide;
/*    */   }
/*    */   
/*    */   public static RoleLevelGuidesInfo select(Long key)
/*    */   {
/* 52 */     (RoleLevelGuidesInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleLevelGuidesInfo get(RoleLevelGuidesInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, LevelGuideInfo> selectTargets(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, LevelGuideInfo> get(RoleLevelGuidesInfo v)
/*    */       {
/* 67 */         return v.getTargetsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2levelguide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */