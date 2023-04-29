/*    */ package xtable;
/*    */ 
/*    */ import xbean.RoleVoipRoom;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2voip_room
/*    */ {
/*    */   public static RoleVoipRoom get(Long key)
/*    */   {
/* 12 */     return (RoleVoipRoom)_Tables_.getInstance().role2voip_room.get(key);
/*    */   }
/*    */   
/*    */   public static RoleVoipRoom get(Long key, RoleVoipRoom value)
/*    */   {
/* 17 */     return (RoleVoipRoom)_Tables_.getInstance().role2voip_room.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleVoipRoom value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2voip_room.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2voip_room.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleVoipRoom value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2voip_room.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2voip_room.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, RoleVoipRoom> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2voip_room.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleVoipRoom> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2voip_room;
/*    */   }
/*    */   
/*    */   public static RoleVoipRoom select(Long key)
/*    */   {
/* 52 */     (RoleVoipRoom)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleVoipRoom get(RoleVoipRoom v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectVoip_room_type(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RoleVoipRoom v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getVoip_room_type());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectOwner_id(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(RoleVoipRoom v)
/*    */       {
/* 78 */         return Long.valueOf(v.getOwner_id());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2voip_room.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */