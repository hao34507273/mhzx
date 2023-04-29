/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.PetFightTeamInfo;
/*    */ import xbean.RolePetFightTeam;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2pet_fight_team
/*    */ {
/*    */   public static RolePetFightTeam get(Long key)
/*    */   {
/* 12 */     return (RolePetFightTeam)_Tables_.getInstance().role2pet_fight_team.get(key);
/*    */   }
/*    */   
/*    */   public static RolePetFightTeam get(Long key, RolePetFightTeam value)
/*    */   {
/* 17 */     return (RolePetFightTeam)_Tables_.getInstance().role2pet_fight_team.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RolePetFightTeam value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2pet_fight_team.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2pet_fight_team.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RolePetFightTeam value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2pet_fight_team.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2pet_fight_team.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RolePetFightTeam> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2pet_fight_team.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RolePetFightTeam> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2pet_fight_team;
/*    */   }
/*    */   
/*    */   public static RolePetFightTeam select(Long key)
/*    */   {
/* 52 */     (RolePetFightTeam)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RolePetFightTeam get(RolePetFightTeam v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectDefense_team(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Integer get(RolePetFightTeam v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getDefense_team());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, PetFightTeamInfo> selectTeam_info(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, PetFightTeamInfo> get(RolePetFightTeam v)
/*    */       {
/* 78 */         return v.getTeam_infoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2pet_fight_team.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */