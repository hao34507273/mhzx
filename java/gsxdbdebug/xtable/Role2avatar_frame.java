/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleAvatarFrame;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2avatar_frame
/*    */ {
/*    */   public static RoleAvatarFrame get(Long key)
/*    */   {
/* 12 */     return (RoleAvatarFrame)_Tables_.getInstance().role2avatar_frame.get(key);
/*    */   }
/*    */   
/*    */   public static RoleAvatarFrame get(Long key, RoleAvatarFrame value)
/*    */   {
/* 17 */     return (RoleAvatarFrame)_Tables_.getInstance().role2avatar_frame.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleAvatarFrame value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2avatar_frame.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2avatar_frame.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleAvatarFrame value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2avatar_frame.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2avatar_frame.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleAvatarFrame> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2avatar_frame.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleAvatarFrame> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2avatar_frame;
/*    */   }
/*    */   
/*    */   public static RoleAvatarFrame select(Long key)
/*    */   {
/* 52 */     (RoleAvatarFrame)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleAvatarFrame get(RoleAvatarFrame v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectCurrent_avatar_frame(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RoleAvatarFrame v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getCurrent_avatar_frame());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectAvatar_frames(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(RoleAvatarFrame v)
/*    */       {
/* 78 */         return v.getAvatar_framesAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2avatar_frame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */