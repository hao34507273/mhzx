/*     */ package mzm.gsp.mail.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.mail.confbean.SMailCfg;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import mzm.gsp.util.Pair;
/*     */ import xbean.MailInfo;
/*     */ import xbean.MailMapBean;
/*     */ import xtable.Role2mail;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MailInterface
/*     */ {
/*     */   public static SendMailRet synBuildAndSendMail(long roleId, int mailCfgId, List<String> titleArgs, List<String> contentArgs, MailAttachment mailAttachment, TLogArg tLogArg)
/*     */   {
/*  39 */     return RoleMailManager.buildAndSendCfgContentMail(roleId, mailCfgId, titleArgs, contentArgs, mailAttachment, tLogArg, 0L, "");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void asynBuildAndSendMail(long roleId, int mailCfgId, final List<String> titleArgs, final List<String> contentArgs, final MailAttachment mailAttachment, final TLogArg tLogArg)
/*     */   {
/*  64 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  69 */         return RoleMailManager.buildAndSendCfgContentMail(this.val$roleId, titleArgs, contentArgs, mailAttachment, tLogArg, this.val$tLogArg, 0L, "").isOK();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SendMailRet synBuildAndSendMail(long roleId, int mailCfgId, List<String> titleArgs, List<String> contentArgs, MailAttachment mailAttachment, TLogArg tLogArg, String tagid)
/*     */   {
/*  98 */     return RoleMailManager.buildAndSendCfgContentMail(roleId, mailCfgId, titleArgs, contentArgs, mailAttachment, tLogArg, 0L, tagid != null ? tagid : "");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void asynBuildAndSendMail(long roleId, int mailCfgId, final List<String> titleArgs, final List<String> contentArgs, final MailAttachment mailAttachment, final TLogArg tLogArg, final String tagid)
/*     */   {
/* 124 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 129 */         return RoleMailManager.buildAndSendCfgContentMail(this.val$roleId, titleArgs, contentArgs, mailAttachment, tLogArg, tagid, 0L, this.val$tagid != null ? this.val$tagid : "").isOK();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SendMailRet synBuildAndSendMail(long roleId, int mailCfgId, List<String> titleArgs, List<String> contentArgs, MailAttachment mailAttachment, TLogArg tLogArg, long delTimeMil)
/*     */   {
/* 159 */     return RoleMailManager.buildAndSendCfgContentMail(roleId, mailCfgId, titleArgs, contentArgs, mailAttachment, tLogArg, delTimeMil, "");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void asynBuildAndSendMail(long roleId, int mailCfgId, final List<String> titleArgs, final List<String> contentArgs, final MailAttachment mailAttachment, final TLogArg tLogArg, final long delMailTimeMil)
/*     */   {
/* 187 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 192 */         return RoleMailManager.buildAndSendCfgContentMail(this.val$roleId, titleArgs, contentArgs, mailAttachment, tLogArg, delMailTimeMil, this.val$delMailTimeMil, "").isOK();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SendMailRet synBuildAndSendMail(long roleId, int mailCfgId, List<String> titleArgs, List<String> contentArgs, MailAttachment mailAttachment, TLogArg tLogArg, long delTimeMil, String tagid)
/*     */   {
/* 224 */     return RoleMailManager.buildAndSendCfgContentMail(roleId, mailCfgId, titleArgs, contentArgs, mailAttachment, tLogArg, delTimeMil, tagid != null ? tagid : "");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void asynBuildAndSendMail(long roleId, int mailCfgId, final List<String> titleArgs, final List<String> contentArgs, final MailAttachment mailAttachment, final TLogArg tLogArg, final long delMailTimeMil, final String tagid)
/*     */   {
/* 254 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 259 */         return RoleMailManager.buildAndSendCfgContentMail(this.val$roleId, titleArgs, contentArgs, mailAttachment, tLogArg, delMailTimeMil, tagid, this.val$tagid != null ? this.val$tagid : "").isOK();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SendMailRet synBuildAndSendMail(long roleId, int mailCfgId, List<String> titleArgs, List<String> contentArgs, TLogArg tLogArg)
/*     */   {
/* 283 */     return RoleMailManager.buildAndSendCfgMail(roleId, mailCfgId, titleArgs, contentArgs, tLogArg, 0L, "");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void asynBuildAndSendMail(long roleId, int mailCfgId, final List<String> titleArgs, final List<String> contentArgs, final TLogArg tLogArg)
/*     */   {
/* 306 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 311 */         return RoleMailManager.buildAndSendCfgMail(this.val$roleId, titleArgs, contentArgs, tLogArg, this.val$tLogArg, 0L, "").isOK();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SendMailRet synBuildAndSendMail(long roleId, int mailCfgId, List<String> titleArgs, List<String> contentArgs, TLogArg tLogArg, String tagid)
/*     */   {
/* 335 */     return RoleMailManager.buildAndSendCfgMail(roleId, mailCfgId, titleArgs, contentArgs, tLogArg, 0L, tagid != null ? tagid : "");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void asynBuildAndSendMail(long roleId, int mailCfgId, final List<String> titleArgs, final List<String> contentArgs, final TLogArg tLogArg, final String tagid)
/*     */   {
/* 360 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 365 */         return RoleMailManager.buildAndSendCfgMail(this.val$roleId, titleArgs, contentArgs, tLogArg, tagid, 0L, this.val$tagid != null ? this.val$tagid : "").isOK();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SendMailRet synBuildAndSendMail(long roleId, int mailCfgId, List<String> titleArgs, List<String> contentArgs, TLogArg tLogArg, long delMailTimeMil)
/*     */   {
/* 390 */     return RoleMailManager.buildAndSendCfgMail(roleId, mailCfgId, titleArgs, contentArgs, tLogArg, delMailTimeMil, "");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void asynBuildAndSendMail(long roleId, int mailCfgId, final List<String> titleArgs, final List<String> contentArgs, final TLogArg tLogArg, final long delMailTimeMil)
/*     */   {
/* 414 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 419 */         return RoleMailManager.buildAndSendCfgMail(this.val$roleId, titleArgs, contentArgs, tLogArg, delMailTimeMil, this.val$delMailTimeMil, "").isOK();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SendMailRet synBuildAndSendMail(long roleId, int mailCfgId, List<String> titleArgs, List<String> contentArgs, TLogArg tLogArg, long delMailTimeMil, String tagid)
/*     */   {
/* 446 */     return RoleMailManager.buildAndSendCfgMail(roleId, mailCfgId, titleArgs, contentArgs, tLogArg, delMailTimeMil, tagid != null ? tagid : "");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void asynBuildAndSendMail(long roleId, int mailCfgId, final List<String> titleArgs, final List<String> contentArgs, final TLogArg tLogArg, final long delMailTimeMil, final String tagid)
/*     */   {
/* 473 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 478 */         return RoleMailManager.buildAndSendCfgMail(this.val$roleId, titleArgs, contentArgs, tLogArg, delMailTimeMil, tagid, this.val$tagid != null ? this.val$tagid : "").isOK();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SendMailRet synBuildAndSendMail(long roleId, int mailType, String title, String content, MailAttachment mailAttachment, TLogArg tLogArg)
/*     */   {
/* 505 */     return RoleMailManager.buildAndSendAutoMail(roleId, mailType, title, content, mailAttachment, tLogArg, 0L, "");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void asynBuildAndSendMail(long roleId, int mailType, final String title, final String content, final MailAttachment mailAttachment, final TLogArg tLogArg)
/*     */   {
/* 528 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 534 */         return RoleMailManager.buildAndSendAutoMail(this.val$roleId, title, content, mailAttachment, tLogArg, this.val$tLogArg, 0L, "").isOK();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SendMailRet synBuildAndSendMail(long roleId, int mailType, String title, String content, MailAttachment mailAttachment, TLogArg tLogArg, String tagid)
/*     */   {
/* 562 */     return RoleMailManager.buildAndSendAutoMail(roleId, mailType, title, content, mailAttachment, tLogArg, 0L, tagid != null ? tagid : "");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void asynBuildAndSendMail(long roleId, int mailType, final String title, final String content, final MailAttachment mailAttachment, final TLogArg tLogArg, final String tagid)
/*     */   {
/* 588 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 594 */         return RoleMailManager.buildAndSendAutoMail(this.val$roleId, title, content, mailAttachment, tLogArg, tagid, 0L, this.val$tagid != null ? this.val$tagid : "").isOK();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SendMailRet synBuildAndSendMail(long roleId, int mailType, String title, String content, MailAttachment mailAttachment, TLogArg tLogArg, long delMailTimeMil)
/*     */   {
/* 623 */     return RoleMailManager.buildAndSendAutoMail(roleId, mailType, title, content, mailAttachment, tLogArg, delMailTimeMil, "");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void asynBuildAndSendMail(long roleId, int mailType, final String title, final String content, final MailAttachment mailAttachment, final TLogArg tLogArg, final long delMailTimeMil)
/*     */   {
/* 649 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 655 */         return RoleMailManager.buildAndSendAutoMail(this.val$roleId, title, content, mailAttachment, tLogArg, delMailTimeMil, this.val$delMailTimeMil, "").isOK();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SendMailRet synBuildAndSendMail(long roleId, int mailType, String title, String content, MailAttachment mailAttachment, TLogArg tLogArg, long delMailTimeMil, String tagid)
/*     */   {
/* 686 */     return RoleMailManager.buildAndSendAutoMail(roleId, mailType, title, content, mailAttachment, tLogArg, delMailTimeMil, tagid != null ? tagid : "");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void asynBuildAndSendMail(long roleId, int mailType, final String title, final String content, final MailAttachment mailAttachment, final TLogArg tLogArg, final long delMailTimeMil, final String tagid)
/*     */   {
/* 714 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 720 */         return RoleMailManager.buildAndSendAutoMail(this.val$roleId, title, content, mailAttachment, tLogArg, delMailTimeMil, tagid, this.val$tagid != null ? this.val$tagid : "").isOK();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static MailAttachment createMailAttachment()
/*     */   {
/* 733 */     return new MailAttachment();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SMailCfg getMailCfgById(int mailId)
/*     */   {
/* 744 */     return SMailCfg.get(mailId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isHasMailCfg(int mailId)
/*     */   {
/* 755 */     return SMailCfg.getAll().containsKey(Integer.valueOf(mailId));
/*     */   }
/*     */   
/*     */ 
/*     */   public static Pair<Map<Integer, MailInfo>, Integer> queryMail(long roleid, int pageNo, int pageSize, boolean retainLock)
/*     */   {
/* 761 */     Map<Integer, MailInfo> mailInfos = new HashMap();
/* 762 */     Pair<Map<Integer, MailInfo>, Integer> result = new Pair(mailInfos, Integer.valueOf(0));
/* 763 */     MailMapBean xMailMapBean = null;
/* 764 */     if (retainLock)
/*     */     {
/* 766 */       xMailMapBean = Role2mail.get(Long.valueOf(roleid));
/*     */     }
/*     */     else
/*     */     {
/* 770 */       xMailMapBean = Role2mail.select(Long.valueOf(roleid));
/*     */     }
/* 772 */     if (xMailMapBean == null)
/*     */     {
/* 774 */       return result;
/*     */     }
/* 776 */     Map<Integer, MailInfo> xMails = xMailMapBean.getMailinfomap();
/* 777 */     if (xMails.isEmpty())
/*     */     {
/* 779 */       return result;
/*     */     }
/*     */     
/* 782 */     Integer[] keys = (Integer[])xMails.keySet().toArray(new Integer[0]);
/* 783 */     int length = keys.length;
/* 784 */     result.second = Integer.valueOf(length);
/* 785 */     int fromIndex = pageSize * (pageNo - 1);
/* 786 */     if (fromIndex >= length)
/*     */     {
/* 788 */       return result;
/*     */     }
/* 790 */     int endIndex = fromIndex + pageSize;
/* 791 */     if (endIndex > length)
/*     */     {
/* 793 */       endIndex = length;
/*     */     }
/* 795 */     for (int i = fromIndex; i < endIndex; i++)
/*     */     {
/* 797 */       Integer key = keys[i];
/* 798 */       mailInfos.put(key, xMails.get(key));
/*     */     }
/* 800 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   public static Pair<Map<Integer, MailInfo>, Integer> queryMail(long roleid, String tagid, int pageNo, int pageSize, boolean retainLock)
/*     */   {
/* 806 */     Map<Integer, MailInfo> mailInfos = new HashMap();
/* 807 */     Pair<Map<Integer, MailInfo>, Integer> result = new Pair(mailInfos, Integer.valueOf(0));
/* 808 */     MailMapBean xMailMapBean = null;
/* 809 */     if (retainLock)
/*     */     {
/* 811 */       xMailMapBean = Role2mail.get(Long.valueOf(roleid));
/*     */     }
/*     */     else
/*     */     {
/* 815 */       xMailMapBean = Role2mail.select(Long.valueOf(roleid));
/*     */     }
/* 817 */     if (xMailMapBean == null)
/*     */     {
/* 819 */       return result;
/*     */     }
/* 821 */     Map<Integer, MailInfo> xMails = xMailMapBean.getMailinfomap();
/* 822 */     if (xMails.isEmpty())
/*     */     {
/* 824 */       return result;
/*     */     }
/*     */     
/* 827 */     Integer[] keys = new Integer[xMails.size()];
/* 828 */     int size = 0;
/* 829 */     for (Map.Entry<Integer, MailInfo> entry : xMails.entrySet())
/*     */     {
/* 831 */       MailInfo xMailInfo = (MailInfo)entry.getValue();
/* 832 */       if (xMailInfo.getTagid().equals(tagid))
/*     */       {
/*     */ 
/*     */ 
/* 836 */         keys[(size++)] = ((Integer)entry.getKey());
/*     */       }
/*     */     }
/* 839 */     result.second = Integer.valueOf(size);
/* 840 */     int fromIndex = pageSize * (pageNo - 1);
/* 841 */     if (fromIndex >= size)
/*     */     {
/* 843 */       return result;
/*     */     }
/* 845 */     int endIndex = fromIndex + pageSize;
/* 846 */     if (endIndex > size)
/*     */     {
/* 848 */       endIndex = size;
/*     */     }
/* 850 */     for (int i = fromIndex; i < endIndex; i++)
/*     */     {
/* 852 */       Integer key = keys[i];
/* 853 */       mailInfos.put(key, xMails.get(key));
/*     */     }
/* 855 */     return result;
/*     */   }
/*     */   
/*     */   public static boolean delMailForIdip(long roleid, int mailid, String tagid)
/*     */   {
/* 860 */     MailMapBean xMailMapBean = Role2mail.get(Long.valueOf(roleid));
/* 861 */     if (xMailMapBean == null)
/*     */     {
/* 863 */       return false;
/*     */     }
/*     */     
/* 866 */     if (mailid > 0)
/*     */     {
/* 868 */       MailInfo xMailInfo = (MailInfo)xMailMapBean.getMailinfomap().get(Integer.valueOf(mailid));
/* 869 */       if (xMailInfo == null)
/*     */       {
/* 871 */         return false;
/*     */       }
/* 873 */       if (!tagid.isEmpty())
/*     */       {
/* 875 */         if (xMailInfo.getTagid().equals(tagid))
/*     */         {
/* 877 */           xMailMapBean.getMailinfomap().remove(Integer.valueOf(mailid));
/* 878 */           RoleMailManager.sendDelMailMsg(roleid, mailid);
/* 879 */           return true;
/*     */         }
/*     */         
/*     */ 
/* 883 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 888 */       xMailMapBean.getMailinfomap().remove(Integer.valueOf(mailid));
/* 889 */       RoleMailManager.sendDelMailMsg(roleid, mailid);
/* 890 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 895 */     if (!tagid.isEmpty())
/*     */     {
/* 897 */       boolean changed = false;
/* 898 */       Iterator<Map.Entry<Integer, MailInfo>> xIt = xMailMapBean.getMailinfomap().entrySet().iterator();
/* 899 */       while (xIt.hasNext())
/*     */       {
/* 901 */         Map.Entry<Integer, MailInfo> xEntry = (Map.Entry)xIt.next();
/* 902 */         if (((MailInfo)xEntry.getValue()).getTagid().equals(tagid))
/*     */         {
/* 904 */           changed = true;
/* 905 */           xIt.remove();
/* 906 */           RoleMailManager.sendDelMailMsg(roleid, ((Integer)xEntry.getKey()).intValue());
/*     */         }
/*     */       }
/* 909 */       return changed;
/*     */     }
/*     */     
/*     */ 
/* 913 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mail\main\MailInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */