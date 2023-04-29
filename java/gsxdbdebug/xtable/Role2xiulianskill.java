/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleXiuLian;
/*    */ import xbean.XiuLianSkill;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2xiulianskill
/*    */ {
/*    */   public static RoleXiuLian get(Long key)
/*    */   {
/* 12 */     return (RoleXiuLian)_Tables_.getInstance().role2xiulianskill.get(key);
/*    */   }
/*    */   
/*    */   public static RoleXiuLian get(Long key, RoleXiuLian value)
/*    */   {
/* 17 */     return (RoleXiuLian)_Tables_.getInstance().role2xiulianskill.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleXiuLian value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2xiulianskill.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2xiulianskill.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleXiuLian value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2xiulianskill.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2xiulianskill.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleXiuLian> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2xiulianskill.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleXiuLian> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2xiulianskill;
/*    */   }
/*    */   
/*    */   public static RoleXiuLian select(Long key)
/*    */   {
/* 52 */     (RoleXiuLian)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleXiuLian get(RoleXiuLian v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, XiuLianSkill> selectSkillmap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, XiuLianSkill> get(RoleXiuLian v)
/*    */       {
/* 67 */         return v.getSkillmapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectDefaultskillid(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Integer get(RoleXiuLian v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getDefaultskillid());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2xiulianskill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */