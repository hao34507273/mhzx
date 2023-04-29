/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.ChatGiftIdList;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2chatgiftinfolist
/*    */ {
/*    */   public static ChatGiftIdList get(Long key)
/*    */   {
/* 12 */     return (ChatGiftIdList)_Tables_.getInstance().role2chatgiftinfolist.get(key);
/*    */   }
/*    */   
/*    */   public static ChatGiftIdList get(Long key, ChatGiftIdList value)
/*    */   {
/* 17 */     return (ChatGiftIdList)_Tables_.getInstance().role2chatgiftinfolist.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ChatGiftIdList value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2chatgiftinfolist.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2chatgiftinfolist.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ChatGiftIdList value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2chatgiftinfolist.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2chatgiftinfolist.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ChatGiftIdList> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2chatgiftinfolist.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ChatGiftIdList> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2chatgiftinfolist;
/*    */   }
/*    */   
/*    */   public static ChatGiftIdList select(Long key)
/*    */   {
/* 52 */     (ChatGiftIdList)getTable().select(key, new TField()
/*    */     {
/*    */       public ChatGiftIdList get(ChatGiftIdList v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Long> selectChatgiftlist(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Long> get(ChatGiftIdList v)
/*    */       {
/* 67 */         return v.getChatgiftlistAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2chatgiftinfolist.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */