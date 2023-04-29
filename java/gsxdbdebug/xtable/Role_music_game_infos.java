/*    */ package xtable;
/*    */ 
/*    */ import xbean.RoleMusicGameInfo;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Role_music_game_infos
/*    */ {
/*    */   public static RoleMusicGameInfo get(Long key)
/*    */   {
/* 12 */     return (RoleMusicGameInfo)_Tables_.getInstance().role_music_game_infos.get(key);
/*    */   }
/*    */   
/*    */   public static RoleMusicGameInfo get(Long key, RoleMusicGameInfo value)
/*    */   {
/* 17 */     return (RoleMusicGameInfo)_Tables_.getInstance().role_music_game_infos.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleMusicGameInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role_music_game_infos.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role_music_game_infos.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleMusicGameInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role_music_game_infos.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role_music_game_infos.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, RoleMusicGameInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role_music_game_infos.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleMusicGameInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role_music_game_infos;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role_music_game_infos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */