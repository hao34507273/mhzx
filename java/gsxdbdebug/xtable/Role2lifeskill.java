/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleLifeSkill;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2lifeskill
/*    */ {
/*    */   public static RoleLifeSkill get(Long key)
/*    */   {
/* 12 */     return (RoleLifeSkill)_Tables_.getInstance().role2lifeskill.get(key);
/*    */   }
/*    */   
/*    */   public static RoleLifeSkill get(Long key, RoleLifeSkill value)
/*    */   {
/* 17 */     return (RoleLifeSkill)_Tables_.getInstance().role2lifeskill.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleLifeSkill value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2lifeskill.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2lifeskill.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleLifeSkill value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2lifeskill.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2lifeskill.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleLifeSkill> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2lifeskill.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleLifeSkill> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2lifeskill;
/*    */   }
/*    */   
/*    */   public static RoleLifeSkill select(Long key)
/*    */   {
/* 52 */     (RoleLifeSkill)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleLifeSkill get(RoleLifeSkill v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectLifeskillbagmap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(RoleLifeSkill v)
/*    */       {
/* 67 */         return v.getLifeskillbagmapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2lifeskill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */