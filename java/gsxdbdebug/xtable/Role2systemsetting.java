/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.SystemSetting;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2systemsetting
/*    */ {
/*    */   public static SystemSetting get(Long key)
/*    */   {
/* 12 */     return (SystemSetting)_Tables_.getInstance().role2systemsetting.get(key);
/*    */   }
/*    */   
/*    */   public static SystemSetting get(Long key, SystemSetting value)
/*    */   {
/* 17 */     return (SystemSetting)_Tables_.getInstance().role2systemsetting.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, SystemSetting value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2systemsetting.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2systemsetting.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, SystemSetting value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2systemsetting.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2systemsetting.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, SystemSetting> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2systemsetting.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, SystemSetting> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2systemsetting;
/*    */   }
/*    */   
/*    */   public static SystemSetting select(Long key)
/*    */   {
/* 52 */     (SystemSetting)getTable().select(key, new TField()
/*    */     {
/*    */       public SystemSetting get(SystemSetting v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectSettingmap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(SystemSetting v)
/*    */       {
/* 67 */         return v.getSettingmapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectConformsettings(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(SystemSetting v)
/*    */       {
/* 78 */         return v.getConformsettingsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2systemsetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */