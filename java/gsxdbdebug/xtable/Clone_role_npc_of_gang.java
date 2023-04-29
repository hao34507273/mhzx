/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.CloneRoleNpcs;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Clone_role_npc_of_gang
/*    */ {
/*    */   public static CloneRoleNpcs get(Long key)
/*    */   {
/* 12 */     return (CloneRoleNpcs)_Tables_.getInstance().clone_role_npc_of_gang.get(key);
/*    */   }
/*    */   
/*    */   public static CloneRoleNpcs get(Long key, CloneRoleNpcs value)
/*    */   {
/* 17 */     return (CloneRoleNpcs)_Tables_.getInstance().clone_role_npc_of_gang.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CloneRoleNpcs value)
/*    */   {
/* 22 */     _Tables_.getInstance().clone_role_npc_of_gang.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().clone_role_npc_of_gang.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CloneRoleNpcs value)
/*    */   {
/* 32 */     return _Tables_.getInstance().clone_role_npc_of_gang.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().clone_role_npc_of_gang.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, CloneRoleNpcs> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().clone_role_npc_of_gang.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CloneRoleNpcs> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().clone_role_npc_of_gang;
/*    */   }
/*    */   
/*    */   public static CloneRoleNpcs select(Long key)
/*    */   {
/* 52 */     (CloneRoleNpcs)getTable().select(key, new TField()
/*    */     {
/*    */       public CloneRoleNpcs get(CloneRoleNpcs v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Long> selectNpc_map(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Long> get(CloneRoleNpcs v)
/*    */       {
/* 67 */         return v.getNpc_mapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Clone_role_npc_of_gang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */