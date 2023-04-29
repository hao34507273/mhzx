/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import xbean.RolePetFightSkill;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2pet_fight_skill
/*    */ {
/*    */   public static RolePetFightSkill get(Long key)
/*    */   {
/* 12 */     return (RolePetFightSkill)_Tables_.getInstance().role2pet_fight_skill.get(key);
/*    */   }
/*    */   
/*    */   public static RolePetFightSkill get(Long key, RolePetFightSkill value)
/*    */   {
/* 17 */     return (RolePetFightSkill)_Tables_.getInstance().role2pet_fight_skill.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RolePetFightSkill value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2pet_fight_skill.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2pet_fight_skill.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RolePetFightSkill value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2pet_fight_skill.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2pet_fight_skill.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RolePetFightSkill> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2pet_fight_skill.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RolePetFightSkill> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2pet_fight_skill;
/*    */   }
/*    */   
/*    */   public static RolePetFightSkill select(Long key)
/*    */   {
/* 52 */     (RolePetFightSkill)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RolePetFightSkill get(RolePetFightSkill v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Integer> selectSkills(Long key)
/*    */   {
/* 63 */     (Set)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Set<Integer> get(RolePetFightSkill v)
/*    */       {
/* 67 */         return v.getSkillsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, Integer> selectPet2skill(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Long, Integer> get(RolePetFightSkill v)
/*    */       {
/* 78 */         return v.getPet2skillAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2pet_fight_skill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */