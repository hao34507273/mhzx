/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleAvatarFrameSessionInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2avatar_frame_session
/*    */ {
/*    */   public static RoleAvatarFrameSessionInfo get(Long key)
/*    */   {
/* 12 */     return (RoleAvatarFrameSessionInfo)_Tables_.getInstance().role2avatar_frame_session.get(key);
/*    */   }
/*    */   
/*    */   public static RoleAvatarFrameSessionInfo get(Long key, RoleAvatarFrameSessionInfo value)
/*    */   {
/* 17 */     return (RoleAvatarFrameSessionInfo)_Tables_.getInstance().role2avatar_frame_session.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleAvatarFrameSessionInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2avatar_frame_session.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2avatar_frame_session.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleAvatarFrameSessionInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2avatar_frame_session.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2avatar_frame_session.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleAvatarFrameSessionInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2avatar_frame_session.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleAvatarFrameSessionInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2avatar_frame_session;
/*    */   }
/*    */   
/*    */   public static RoleAvatarFrameSessionInfo select(Long key)
/*    */   {
/* 52 */     (RoleAvatarFrameSessionInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleAvatarFrameSessionInfo get(RoleAvatarFrameSessionInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Long> selectSessions(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Long> get(RoleAvatarFrameSessionInfo v)
/*    */       {
/* 67 */         return v.getSessionsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2avatar_frame_session.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */