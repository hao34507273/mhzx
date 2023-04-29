/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleTempSkillList;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2tempskill
/*    */ {
/*    */   public static RoleTempSkillList get(Long key)
/*    */   {
/* 12 */     return (RoleTempSkillList)_Tables_.getInstance().role2tempskill.get(key);
/*    */   }
/*    */   
/*    */   public static RoleTempSkillList get(Long key, RoleTempSkillList value)
/*    */   {
/* 17 */     return (RoleTempSkillList)_Tables_.getInstance().role2tempskill.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleTempSkillList value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2tempskill.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2tempskill.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleTempSkillList value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2tempskill.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2tempskill.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleTempSkillList> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2tempskill.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleTempSkillList> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2tempskill;
/*    */   }
/*    */   
/*    */   public static RoleTempSkillList select(Long key)
/*    */   {
/* 52 */     (RoleTempSkillList)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleTempSkillList get(RoleTempSkillList v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectSkilllist(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(RoleTempSkillList v)
/*    */       {
/* 67 */         return v.getSkilllistAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2tempskill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */