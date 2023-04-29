/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.ChatBubbleInfo;
/*    */ import xbean.RoleChatBubbleInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2chatbubbleinfo
/*    */ {
/*    */   public static RoleChatBubbleInfo get(Long key)
/*    */   {
/* 12 */     return (RoleChatBubbleInfo)_Tables_.getInstance().role2chatbubbleinfo.get(key);
/*    */   }
/*    */   
/*    */   public static RoleChatBubbleInfo get(Long key, RoleChatBubbleInfo value)
/*    */   {
/* 17 */     return (RoleChatBubbleInfo)_Tables_.getInstance().role2chatbubbleinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleChatBubbleInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2chatbubbleinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2chatbubbleinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleChatBubbleInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2chatbubbleinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2chatbubbleinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleChatBubbleInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2chatbubbleinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleChatBubbleInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2chatbubbleinfo;
/*    */   }
/*    */   
/*    */   public static RoleChatBubbleInfo select(Long key)
/*    */   {
/* 52 */     (RoleChatBubbleInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleChatBubbleInfo get(RoleChatBubbleInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectCurchatbubblecfgid(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Integer get(RoleChatBubbleInfo v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getCurchatbubblecfgid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, ChatBubbleInfo> selectCfgid2info(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, ChatBubbleInfo> get(RoleChatBubbleInfo v)
/*    */       {
/* 78 */         return v.getCfgid2infoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2chatbubbleinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */