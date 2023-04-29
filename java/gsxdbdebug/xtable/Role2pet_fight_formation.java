/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.PetFightFormationInfo;
/*    */ import xbean.RolePetFightFormation;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2pet_fight_formation
/*    */ {
/*    */   public static RolePetFightFormation get(Long key)
/*    */   {
/* 12 */     return (RolePetFightFormation)_Tables_.getInstance().role2pet_fight_formation.get(key);
/*    */   }
/*    */   
/*    */   public static RolePetFightFormation get(Long key, RolePetFightFormation value)
/*    */   {
/* 17 */     return (RolePetFightFormation)_Tables_.getInstance().role2pet_fight_formation.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RolePetFightFormation value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2pet_fight_formation.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2pet_fight_formation.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RolePetFightFormation value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2pet_fight_formation.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2pet_fight_formation.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RolePetFightFormation> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2pet_fight_formation.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RolePetFightFormation> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2pet_fight_formation;
/*    */   }
/*    */   
/*    */   public static RolePetFightFormation select(Long key)
/*    */   {
/* 52 */     (RolePetFightFormation)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RolePetFightFormation get(RolePetFightFormation v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, PetFightFormationInfo> selectFormation_info(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, PetFightFormationInfo> get(RolePetFightFormation v)
/*    */       {
/* 67 */         return v.getFormation_infoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2pet_fight_formation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */