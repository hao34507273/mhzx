/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import xbean.InviteConfirmBean;
/*     */ import xdb.TTable;
/*     */ import xdb.util.AutoKey;
/*     */ 
/*     */ public class Inviteconfirm_info
/*     */ {
/*     */   public static AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().inviteconfirm_info.getAutoKey();
/*     */   }
/*     */   
/*     */   public static AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().inviteconfirm_info.getAutoKey(localid);
/*     */   }
/*     */   
/*     */   public static Long nextKey()
/*     */   {
/*  22 */     return (Long)getAutoKey().next();
/*     */   }
/*     */   
/*     */   public static Long nextKey(int localid)
/*     */   {
/*  27 */     return (Long)getAutoKey(localid).next();
/*     */   }
/*     */   
/*     */   public static Long insert(InviteConfirmBean value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, InviteConfirmBean value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static InviteConfirmBean get(Long key)
/*     */   {
/*  46 */     return (InviteConfirmBean)_Tables_.getInstance().inviteconfirm_info.get(key);
/*     */   }
/*     */   
/*     */   public static InviteConfirmBean get(Long key, InviteConfirmBean value)
/*     */   {
/*  51 */     return (InviteConfirmBean)_Tables_.getInstance().inviteconfirm_info.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, InviteConfirmBean value)
/*     */   {
/*  56 */     _Tables_.getInstance().inviteconfirm_info.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, InviteConfirmBean value)
/*     */   {
/*  61 */     _Tables_.getInstance().inviteconfirm_info.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().inviteconfirm_info.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, InviteConfirmBean value)
/*     */   {
/*  71 */     return _Tables_.getInstance().inviteconfirm_info.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, InviteConfirmBean value)
/*     */   {
/*  76 */     return _Tables_.getInstance().inviteconfirm_info.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().inviteconfirm_info.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, InviteConfirmBean> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().inviteconfirm_info.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, InviteConfirmBean> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().inviteconfirm_info;
/*     */   }
/*     */   
/*     */   public static Long selectSessionid(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Long get(InviteConfirmBean v)
/*     */       {
/* 100 */         return Long.valueOf(v.getSessionid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectInvitetype(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Integer get(InviteConfirmBean v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getInvitetype());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectAllroles(Long key)
/*     */   {
/* 118 */     (List)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public List<Long> get(InviteConfirmBean v)
/*     */       {
/* 122 */         return v.getAllrolesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Inviteconfirm_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */