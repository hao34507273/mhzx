/*     */ package mzm.gsp.compensate.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.Properties;
/*     */ import xbean.SystemCompensateInfo;
/*     */ import xtable.Role2properties;
/*     */ import xtable.Systemcompensate;
/*     */ 
/*     */ public class CompensateManager
/*     */ {
/*  26 */   static final ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
/*  27 */   static final Map<Long, CompensateInfo> compensates = new java.util.HashMap();
/*     */   
/*     */   static final void postInit()
/*     */   {
/*  31 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  36 */         long localId = GameServerInfoManager.getLocalId();
/*     */         
/*  38 */         SystemCompensateInfo xSystemCompensateInfo = Systemcompensate.get(Long.valueOf(localId));
/*  39 */         Iterator i$; if (xSystemCompensateInfo == null)
/*     */         {
/*  41 */           xSystemCompensateInfo = xbean.Pod.newSystemCompensateInfo();
/*  42 */           Systemcompensate.add(Long.valueOf(localId), xSystemCompensateInfo);
/*     */         }
/*     */         else
/*     */         {
/*  46 */           long currTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  47 */           List<Long> expiredIds = new LinkedList();
/*  48 */           for (Map.Entry<Long, xbean.CompensateInfo> entry : xSystemCompensateInfo.getCompensates().entrySet())
/*     */           {
/*  50 */             long id = ((Long)entry.getKey()).longValue();
/*  51 */             xbean.CompensateInfo xCompensateInfo = (xbean.CompensateInfo)entry.getValue();
/*  52 */             if (xCompensateInfo.getEnd_time() < currTime)
/*     */             {
/*  54 */               expiredIds.add(Long.valueOf(id));
/*     */             }
/*     */             else
/*     */             {
/*  58 */               CompensateInfo compensateInfo = new CompensateInfo(id, xCompensateInfo);
/*  59 */               CompensateManager.compensates.put(Long.valueOf(id), compensateInfo);
/*  60 */               compensateInfo.trySendCompensate();
/*     */             }
/*     */           }
/*     */           
/*     */ 
/*  65 */           for (i$ = expiredIds.iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/*     */             
/*  67 */             xSystemCompensateInfo.getCompensates().remove(Long.valueOf(id));
/*     */           }
/*     */         }
/*     */         
/*  71 */         return true;
/*     */       }
/*     */     }.call();
/*     */   }
/*     */   
/*     */   static final boolean addCompensate(CompensateInfo compensateInfo)
/*     */   {
/*  78 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  83 */         long localId = GameServerInfoManager.getLocalId();
/*  84 */         SystemCompensateInfo xSystemCompensateInfo = Systemcompensate.get(Long.valueOf(localId));
/*  85 */         int autoIncId = xSystemCompensateInfo.getNextid();
/*  86 */         long id = GameServerInfoManager.toGlobalId(autoIncId);
/*  87 */         xSystemCompensateInfo.getCompensates().put(Long.valueOf(id), this.val$compensateInfo.toXBean());
/*  88 */         xSystemCompensateInfo.setNextid(autoIncId + 1);
/*     */         
/*  90 */         CompensateManager.rwlock.writeLock().lock();
/*     */         try
/*     */         {
/*  93 */           this.val$compensateInfo.id = id;
/*  94 */           CompensateManager.compensates.put(Long.valueOf(id), this.val$compensateInfo);
/*     */         }
/*     */         finally
/*     */         {
/*  98 */           CompensateManager.rwlock.writeLock().unlock();
/*     */         }
/*     */         
/* 101 */         this.val$compensateInfo.trySendCompensate();
/*     */         
/* 103 */         GameServer.logger().info(String.format("[compensate]CompensateManager.addCompensate.LogicProcedure.processImp@add compensate done|id=%d|mode=%d|min_level=%d|max_level=%d|start_time=%d|end_time=%d|mail_title=%s|mail_content=%s|items=%s|currencies=%s", new Object[] { Long.valueOf(id), Integer.valueOf(this.val$compensateInfo.mode), Integer.valueOf(this.val$compensateInfo.minLevel), Integer.valueOf(this.val$compensateInfo.maxLevel), Long.valueOf(this.val$compensateInfo.startTime), Long.valueOf(this.val$compensateInfo.endTime), this.val$compensateInfo.mailTitle, this.val$compensateInfo.mailContent, this.val$compensateInfo.items.toString(), this.val$compensateInfo.currencies.toString() }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 111 */         return true;
/*     */       }
/*     */     }.call();
/*     */   }
/*     */   
/*     */   static final boolean removeCompensate(long id, int tag)
/*     */   {
/* 118 */     long localId = GameServerInfoManager.getLocalId();
/* 119 */     SystemCompensateInfo xSystemCompensateInfo = Systemcompensate.get(Long.valueOf(localId));
/* 120 */     if (xSystemCompensateInfo == null)
/*     */     {
/* 122 */       return false;
/*     */     }
/* 124 */     xbean.CompensateInfo xCompensateInfo = (xbean.CompensateInfo)xSystemCompensateInfo.getCompensates().get(Long.valueOf(id));
/* 125 */     if (xCompensateInfo == null)
/*     */     {
/* 127 */       return false;
/*     */     }
/* 129 */     if (tag > 0)
/*     */     {
/* 131 */       if (xCompensateInfo.getTagid() != tag)
/*     */       {
/* 133 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 137 */     xSystemCompensateInfo.getCompensates().remove(Long.valueOf(id));
/*     */     
/* 139 */     removeCompensateCache(id);
/*     */     
/* 141 */     return true;
/*     */   }
/*     */   
/*     */   static final boolean removeCompensate(int tag)
/*     */   {
/* 146 */     if (tag <= 0)
/*     */     {
/* 148 */       return false;
/*     */     }
/*     */     
/* 151 */     long localId = GameServerInfoManager.getLocalId();
/* 152 */     SystemCompensateInfo xSystemCompensateInfo = Systemcompensate.get(Long.valueOf(localId));
/* 153 */     Iterator<Map.Entry<Long, xbean.CompensateInfo>> itr = xSystemCompensateInfo.getCompensates().entrySet().iterator();
/* 154 */     boolean changed = false;
/* 155 */     while (itr.hasNext())
/*     */     {
/* 157 */       Map.Entry<Long, xbean.CompensateInfo> entry = (Map.Entry)itr.next();
/*     */       
/* 159 */       xbean.CompensateInfo xCompensateInfo = (xbean.CompensateInfo)entry.getValue();
/* 160 */       if (xCompensateInfo.getTagid() == tag)
/*     */       {
/* 162 */         itr.remove();
/*     */         
/* 164 */         removeCompensateCache(((Long)entry.getKey()).longValue());
/*     */         
/* 166 */         changed = true;
/*     */       }
/*     */     }
/*     */     
/* 170 */     return changed;
/*     */   }
/*     */   
/*     */   static final void removeCompensateCache(long id)
/*     */   {
/* 175 */     CompensateInfo compensateInfo = null;
/* 176 */     rwlock.writeLock().lock();
/*     */     try
/*     */     {
/* 179 */       compensateInfo = (CompensateInfo)compensates.remove(Long.valueOf(id));
/*     */     }
/*     */     finally
/*     */     {
/* 183 */       rwlock.writeLock().unlock();
/*     */     }
/*     */     
/* 186 */     if (compensateInfo != null)
/*     */     {
/* 188 */       compensateInfo.onRemove();
/*     */     }
/*     */   }
/*     */   
/*     */   static final List<CompensateInfo> getCompensates()
/*     */   {
/* 194 */     rwlock.readLock().lock();
/*     */     try
/*     */     {
/* 197 */       return new LinkedList(compensates.values());
/*     */     }
/*     */     finally
/*     */     {
/* 201 */       rwlock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   static final boolean trySendCompensateMail(String userid, long roleid, CompensateInfo compensateInfo)
/*     */   {
/* 207 */     long compensateId = compensateInfo.id;
/* 208 */     if (compensateInfo.mode == 1)
/*     */     {
/* 210 */       xbean.User xUser = xtable.User.get(userid);
/* 211 */       if (xUser.getCompensates().contains(Long.valueOf(compensateId)))
/*     */       {
/* 213 */         return false;
/*     */       }
/*     */       
/* 216 */       xUser.getCompensates().add(Long.valueOf(compensateId));
/*     */     }
/*     */     else
/*     */     {
/* 220 */       Properties xProperties = Role2properties.get(Long.valueOf(roleid));
/* 221 */       if (xProperties.getCompensates().contains(Long.valueOf(compensateId)))
/*     */       {
/* 223 */         return false;
/*     */       }
/*     */       
/* 226 */       xProperties.getCompensates().add(Long.valueOf(compensateId));
/*     */     }
/*     */     
/* 229 */     MailAttachment mailAttachment = MailInterface.createMailAttachment();
/*     */     
/* 231 */     if (compensateInfo.items.size() > 0)
/*     */     {
/* 233 */       mailAttachment.addItemMap(compensateInfo.items);
/*     */     }
/*     */     
/* 236 */     if (compensateInfo.currencies.size() > 0)
/*     */     {
/* 238 */       mzm.gsp.idip.main.IDIPCurrencyType.fillMailCurrencyAttachment(mailAttachment, compensateInfo.currencies);
/*     */     }
/* 240 */     TLogArg logArg = new TLogArg(mzm.gsp.tlog.LogReason.IDIP_COMPENSATE);
/* 241 */     String tag = String.format("G_%d", new Object[] { Integer.valueOf(compensateInfo.tag) });
/* 242 */     MailInterface.asynBuildAndSendMail(roleid, 1, compensateInfo.mailTitle, compensateInfo.mailContent, mailAttachment, logArg, tag);
/*     */     
/*     */ 
/* 245 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static final void cleanCompensateIds(String userid, long roleid, Set<Long> remainUserCompensateIds, Set<Long> remainRoleCompensateIds)
/*     */   {
/* 251 */     xbean.User xUser = xtable.User.get(userid);
/* 252 */     Set<Long> allUserCompensateIds = new HashSet(xUser.getCompensates());
/* 253 */     if (allUserCompensateIds.size() > 0)
/*     */     {
/* 255 */       for (Long id : allUserCompensateIds)
/*     */       {
/* 257 */         if (!remainUserCompensateIds.contains(id))
/*     */         {
/* 259 */           xUser.getCompensates().remove(id);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 264 */     Properties xProperties = Role2properties.get(Long.valueOf(roleid));
/* 265 */     Set<Long> allRoleCompensateIds = new HashSet(xProperties.getCompensates());
/* 266 */     if (allRoleCompensateIds.size() > 0)
/*     */     {
/* 268 */       for (Long id : allRoleCompensateIds)
/*     */       {
/* 270 */         if (!remainRoleCompensateIds.contains(id))
/*     */         {
/* 272 */           xProperties.getCompensates().remove(id);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\compensate\main\CompensateManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */