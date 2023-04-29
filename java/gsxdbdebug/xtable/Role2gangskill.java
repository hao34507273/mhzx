/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleGangSkill;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2gangskill
/*    */ {
/*    */   public static RoleGangSkill get(Long key)
/*    */   {
/* 12 */     return (RoleGangSkill)_Tables_.getInstance().role2gangskill.get(key);
/*    */   }
/*    */   
/*    */   public static RoleGangSkill get(Long key, RoleGangSkill value)
/*    */   {
/* 17 */     return (RoleGangSkill)_Tables_.getInstance().role2gangskill.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleGangSkill value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2gangskill.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2gangskill.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleGangSkill value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2gangskill.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2gangskill.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleGangSkill> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2gangskill.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleGangSkill> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2gangskill;
/*    */   }
/*    */   
/*    */   public static RoleGangSkill select(Long key)
/*    */   {
/* 52 */     (RoleGangSkill)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleGangSkill get(RoleGangSkill v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectGangskillbagmap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(RoleGangSkill v)
/*    */       {
/* 67 */         return v.getGangskillbagmapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2gangskill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */