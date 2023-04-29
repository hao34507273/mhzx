/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleSkillBags;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2skillbag
/*    */ {
/*    */   public static RoleSkillBags get(Long key)
/*    */   {
/* 12 */     return (RoleSkillBags)_Tables_.getInstance().role2skillbag.get(key);
/*    */   }
/*    */   
/*    */   public static RoleSkillBags get(Long key, RoleSkillBags value)
/*    */   {
/* 17 */     return (RoleSkillBags)_Tables_.getInstance().role2skillbag.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleSkillBags value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2skillbag.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2skillbag.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleSkillBags value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2skillbag.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2skillbag.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleSkillBags> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2skillbag.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleSkillBags> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2skillbag;
/*    */   }
/*    */   
/*    */   public static RoleSkillBags select(Long key)
/*    */   {
/* 52 */     (RoleSkillBags)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleSkillBags get(RoleSkillBags v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectMenpai(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(RoleSkillBags v)
/*    */       {
/* 67 */         return v.getMenpaiAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2skillbag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */