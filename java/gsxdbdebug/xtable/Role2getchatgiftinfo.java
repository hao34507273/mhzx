/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.ChatGiftRoleGetInfo;
/*    */ import xbean.ChatGiftTimeList;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2getchatgiftinfo
/*    */ {
/*    */   public static ChatGiftRoleGetInfo get(Long key)
/*    */   {
/* 12 */     return (ChatGiftRoleGetInfo)_Tables_.getInstance().role2getchatgiftinfo.get(key);
/*    */   }
/*    */   
/*    */   public static ChatGiftRoleGetInfo get(Long key, ChatGiftRoleGetInfo value)
/*    */   {
/* 17 */     return (ChatGiftRoleGetInfo)_Tables_.getInstance().role2getchatgiftinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ChatGiftRoleGetInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2getchatgiftinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2getchatgiftinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ChatGiftRoleGetInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2getchatgiftinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2getchatgiftinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ChatGiftRoleGetInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2getchatgiftinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ChatGiftRoleGetInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2getchatgiftinfo;
/*    */   }
/*    */   
/*    */   public static ChatGiftRoleGetInfo select(Long key)
/*    */   {
/* 52 */     (ChatGiftRoleGetInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public ChatGiftRoleGetInfo get(ChatGiftRoleGetInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, ChatGiftTimeList> selectChatgiftrolegetinfo(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, ChatGiftTimeList> get(ChatGiftRoleGetInfo v)
/*    */       {
/* 67 */         return v.getChatgiftrolegetinfoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2getchatgiftinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */