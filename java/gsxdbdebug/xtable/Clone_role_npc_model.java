/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.CloneRoleNPCMap;
/*    */ import xbean.CloneRoleNPCModel;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Clone_role_npc_model
/*    */ {
/*    */   public static CloneRoleNPCMap get(Long key)
/*    */   {
/* 12 */     return (CloneRoleNPCMap)_Tables_.getInstance().clone_role_npc_model.get(key);
/*    */   }
/*    */   
/*    */   public static CloneRoleNPCMap get(Long key, CloneRoleNPCMap value)
/*    */   {
/* 17 */     return (CloneRoleNPCMap)_Tables_.getInstance().clone_role_npc_model.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CloneRoleNPCMap value)
/*    */   {
/* 22 */     _Tables_.getInstance().clone_role_npc_model.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().clone_role_npc_model.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CloneRoleNPCMap value)
/*    */   {
/* 32 */     return _Tables_.getInstance().clone_role_npc_model.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().clone_role_npc_model.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, CloneRoleNPCMap> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().clone_role_npc_model.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CloneRoleNPCMap> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().clone_role_npc_model;
/*    */   }
/*    */   
/*    */   public static CloneRoleNPCMap select(Long key)
/*    */   {
/* 52 */     (CloneRoleNPCMap)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public CloneRoleNPCMap get(CloneRoleNPCMap v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, CloneRoleNPCModel> selectNpc_map(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, CloneRoleNPCModel> get(CloneRoleNPCMap v)
/*    */       {
/* 67 */         return v.getNpc_mapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Clone_role_npc_model.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */