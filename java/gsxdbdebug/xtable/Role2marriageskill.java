/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.MarriageSkill;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2marriageskill
/*    */ {
/*    */   public static MarriageSkill get(Long key)
/*    */   {
/* 12 */     return (MarriageSkill)_Tables_.getInstance().role2marriageskill.get(key);
/*    */   }
/*    */   
/*    */   public static MarriageSkill get(Long key, MarriageSkill value)
/*    */   {
/* 17 */     return (MarriageSkill)_Tables_.getInstance().role2marriageskill.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MarriageSkill value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2marriageskill.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2marriageskill.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MarriageSkill value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2marriageskill.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2marriageskill.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MarriageSkill> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2marriageskill.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MarriageSkill> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2marriageskill;
/*    */   }
/*    */   
/*    */   public static MarriageSkill select(Long key)
/*    */   {
/* 52 */     (MarriageSkill)getTable().select(key, new TField()
/*    */     {
/*    */       public MarriageSkill get(MarriageSkill v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectSkills(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(MarriageSkill v)
/*    */       {
/* 67 */         return v.getSkillsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2marriageskill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */