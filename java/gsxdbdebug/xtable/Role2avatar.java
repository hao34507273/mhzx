/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleAvatar;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2avatar
/*    */ {
/*    */   public static RoleAvatar get(Long key)
/*    */   {
/* 12 */     return (RoleAvatar)_Tables_.getInstance().role2avatar.get(key);
/*    */   }
/*    */   
/*    */   public static RoleAvatar get(Long key, RoleAvatar value)
/*    */   {
/* 17 */     return (RoleAvatar)_Tables_.getInstance().role2avatar.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleAvatar value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2avatar.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2avatar.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleAvatar value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2avatar.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2avatar.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleAvatar> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2avatar.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleAvatar> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2avatar;
/*    */   }
/*    */   
/*    */   public static RoleAvatar select(Long key)
/*    */   {
/* 52 */     (RoleAvatar)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleAvatar get(RoleAvatar v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer select_current_avatar(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RoleAvatar v)
/*    */       {
/* 67 */         return Integer.valueOf(v.get_current_avatar());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer select_active_avatar(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RoleAvatar v)
/*    */       {
/* 78 */         return Integer.valueOf(v.get_active_avatar());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> select_avatars(Long key)
/*    */   {
/* 85 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(RoleAvatar v)
/*    */       {
/* 89 */         return v.get_avatarsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2avatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */