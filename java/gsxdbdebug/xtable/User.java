/*     */ package xtable;
/*     */ 
/*     */ import java.util.Set;
/*     */ import xbean.RecallFriendBackGame;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class User
/*     */ {
/*     */   public static xbean.User get(String key)
/*     */   {
/*  12 */     return (xbean.User)_Tables_.getInstance().user.get(key);
/*     */   }
/*     */   
/*     */   public static xbean.User get(String key, xbean.User value)
/*     */   {
/*  17 */     return (xbean.User)_Tables_.getInstance().user.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(String key, xbean.User value)
/*     */   {
/*  22 */     _Tables_.getInstance().user.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(String key)
/*     */   {
/*  27 */     _Tables_.getInstance().user.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(String key, xbean.User value)
/*     */   {
/*  32 */     return _Tables_.getInstance().user.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(String key)
/*     */   {
/*  37 */     return _Tables_.getInstance().user.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<String, xbean.User> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().user.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<String, xbean.User> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().user;
/*     */   }
/*     */   
/*     */   public static xbean.User select(String key)
/*     */   {
/*  52 */     (xbean.User)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.User get(xbean.User v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<Long> selectRoleids(String key)
/*     */   {
/*  63 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<Long> get(xbean.User v)
/*     */       {
/*  67 */         return v.getRoleidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectActivated(String key)
/*     */   {
/*  74 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(xbean.User v)
/*     */       {
/*  78 */         return Boolean.valueOf(v.getActivated());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLastlogintime(String key)
/*     */   {
/*  85 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.User v)
/*     */       {
/*  89 */         return Long.valueOf(v.getLastlogintime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLast_login_roleid(String key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.User v)
/*     */       {
/* 100 */         return Long.valueOf(v.getLast_login_roleid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectMax_fighting_capacity(String key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.User v)
/*     */       {
/* 111 */         return Long.valueOf(v.getMax_fighting_capacity());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectMax_fighting_capacity_roleid(String key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.User v)
/*     */       {
/* 122 */         return Long.valueOf(v.getMax_fighting_capacity_roleid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectGrc_friends_count(String key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.User v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getGrc_friends_count());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectGrc_friends_count_award_serial_no(String key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.User v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getGrc_friends_count_award_serial_no());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectSn(String key)
/*     */   {
/* 151 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.User v)
/*     */       {
/* 155 */         return Integer.valueOf(v.getSn());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectFinal_success_order_id(String key)
/*     */   {
/* 162 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(xbean.User v)
/*     */       {
/* 166 */         return v.getFinal_success_order_id();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectFinal_transfer_success_time(String key)
/*     */   {
/* 173 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.User v)
/*     */       {
/* 177 */         return Long.valueOf(v.getFinal_transfer_success_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Set<Long> selectCompensates(String key)
/*     */   {
/* 184 */     (Set)getTable().select(key, new TField()
/*     */     {
/*     */       public Set<Long> get(xbean.User v)
/*     */       {
/* 188 */         return v.getCompensatesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Map<Integer, xbean.PrivilegeAwardInfo> selectPrivilege_award_infos(String key)
/*     */   {
/* 195 */     (java.util.Map)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Map<Integer, xbean.PrivilegeAwardInfo> get(xbean.User v)
/*     */       {
/* 199 */         return v.getPrivilege_award_infosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectInvitee_status(String key)
/*     */   {
/* 206 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.User v)
/*     */       {
/* 210 */         return Integer.valueOf(v.getInvitee_status());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectInvitee_code(String key)
/*     */   {
/* 217 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(xbean.User v)
/*     */       {
/* 221 */         return v.getInvitee_code();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectInvitee_total_present_rebate_bind_yuanbao(String key)
/*     */   {
/* 228 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.User v)
/*     */       {
/* 232 */         return Long.valueOf(v.getInvitee_total_present_rebate_bind_yuanbao());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectInviter_code(String key)
/*     */   {
/* 239 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(xbean.User v)
/*     */       {
/* 243 */         return v.getInviter_code();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectInviter_total_rebate_bind_yuanbao(String key)
/*     */   {
/* 250 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.User v)
/*     */       {
/* 254 */         return Long.valueOf(v.getInviter_total_rebate_bind_yuanbao());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectInviter_total_gift_times(String key)
/*     */   {
/* 261 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.User v)
/*     */       {
/* 265 */         return Long.valueOf(v.getInviter_total_gift_times());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectInvitee_save_amt(String key)
/*     */   {
/* 272 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.User v)
/*     */       {
/* 276 */         return Long.valueOf(v.getInvitee_save_amt());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectRegister_time(String key)
/*     */   {
/* 283 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.User v)
/*     */       {
/* 287 */         return Long.valueOf(v.getRegister_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectInvitee_confirm_total_present_rebate_bind_yuanbao(String key)
/*     */   {
/* 294 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.User v)
/*     */       {
/* 298 */         return Long.valueOf(v.getInvitee_confirm_total_present_rebate_bind_yuanbao());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectInvitee_done_shimen_total_days(String key)
/*     */   {
/* 305 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.User v)
/*     */       {
/* 309 */         return Integer.valueOf(v.getInvitee_done_shimen_total_days());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectInvitee_done_shimen_timestamp(String key)
/*     */   {
/* 316 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.User v)
/*     */       {
/* 320 */         return Long.valueOf(v.getInvitee_done_shimen_timestamp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static RecallFriendBackGame selectRecall_friend_back_game(String key)
/*     */   {
/* 327 */     (RecallFriendBackGame)getTable().select(key, new TField()
/*     */     {
/*     */       public RecallFriendBackGame get(xbean.User v)
/*     */       {
/* 331 */         return v.getRecall_friend_back_game().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectFigure_url(String key)
/*     */   {
/* 338 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(xbean.User v)
/*     */       {
/* 342 */         return v.getFigure_url();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectNick_name(String key)
/*     */   {
/* 349 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(xbean.User v)
/*     */       {
/* 353 */         return v.getNick_name();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\User.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */