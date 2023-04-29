/*      */ package mzm.gsp.online.main;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import gnet.link.Dispatch;
/*      */ import gnet.link.Kick;
/*      */ import gnet.link.Link;
/*      */ import gnet.link.Onlines;
/*      */ import hub.DataTransferReq;
/*      */ import hub.GHubHelper;
/*      */ import hub.ValidateRoamTokenReq;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import mzm.gsp.CGetRoleList;
/*      */ import mzm.gsp.CLoginRole;
/*      */ import mzm.gsp.CReConnect;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.SAccountNumLimit;
/*      */ import mzm.gsp.SLoginQueueInfo;
/*      */ import mzm.gsp.SRoleInCrossServerRes;
/*      */ import mzm.gsp.SSynServerNotTipSignRes;
/*      */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*      */ import mzm.gsp.crossserver.main.ValidateRoamTokenTransferReqXidWrapper;
/*      */ import mzm.gsp.serverconf.confbean.ServerConfigConsts;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.timer.main.Observer;
/*      */ import mzm.gsp.util.LogicProcedure;
/*      */ import mzm.gsp.util.LogicRunnable;
/*      */ import mzm.gsp.util.TaskOneByOne;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.AccountNumBean;
/*      */ import xbean.CrossToken;
/*      */ import xbean.LocalCrossToken;
/*      */ import xbean.Pod;
/*      */ import xdb.Procedure;
/*      */ import xio.Protocol;
/*      */ import xtable.Accountnum;
/*      */ import xtable.Role2properties;
/*      */ import xtable.User2crossstoken;
/*      */ import xtable.User2localcrossstoken;
/*      */ 
/*      */ 
/*      */ public class LoginManager
/*      */ {
/*   52 */   private static final LoginManager instance = new LoginManager();
/*      */   static final int CROSS_DELAY_SEC = 2;
/*      */   
/*   55 */   public static LoginManager getInstance() { return instance; }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static final int CROSS_TOKEN_CHECK_SEC = 60;
/*      */   
/*      */ 
/*   63 */   private int maxPlayerNum = 3000;
/*      */   
/*   65 */   private int intervalLoginNum = 100;
/*   66 */   private int tryLoginInterval = 1000;
/*   67 */   private int notifyLoginInterval = 30;
/*   68 */   private boolean accountNumLimit = true;
/*   69 */   private int accountNum = 4000;
/*   70 */   private int queueCapacity = 1000;
/*   71 */   private volatile int nowUseNum = 0;
/*      */   private int offLineNum;
/*   73 */   private volatile int userNum = 0;
/*      */   
/*   75 */   private Object queueLock = new Object();
/*      */   
/*      */ 
/*   78 */   private LinkedHashMap<String, List<LinkProtocol>> priorQueue = new OnlineRoleSizeExtendMap();
/*      */   
/*   80 */   private LinkedHashMap<String, List<LinkProtocol>> userQueue = new OnlineRoleSizeExtendMap();
/*      */   
/*   82 */   private int DELAY_LEAVE_QUEUE_SEC = 10;
/*      */   
/*   84 */   private Map<String, TaskOneByOne> userLoginTaskMap = new OnlineRoleSizeExtendMap();
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void addLogicRunnable(String userid, LogicRunnable logicRunnable)
/*      */   {
/*   93 */     synchronized (this.userLoginTaskMap) {
/*   94 */       TaskOneByOne taskOneByOne = (TaskOneByOne)this.userLoginTaskMap.get(userid);
/*   95 */       if (taskOneByOne == null) {
/*   96 */         taskOneByOne = new TaskOneByOne(OnlineManager.getInstance().getMaxTaskPerRole());
/*   97 */         this.userLoginTaskMap.put(userid, taskOneByOne);
/*      */       }
/*   99 */       taskOneByOne.add(logicRunnable);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void addLogicProcedure(String userid, LogicProcedure logicProcedure)
/*      */   {
/*  110 */     synchronized (this.userLoginTaskMap) {
/*  111 */       TaskOneByOne taskOneByOne = (TaskOneByOne)this.userLoginTaskMap.get(userid);
/*  112 */       if (taskOneByOne == null) {
/*  113 */         taskOneByOne = new TaskOneByOne(OnlineManager.getInstance().getMaxTaskPerRole());
/*  114 */         this.userLoginTaskMap.put(userid, taskOneByOne);
/*      */       }
/*  116 */       taskOneByOne.add(logicProcedure);
/*      */     }
/*      */   }
/*      */   
/*      */   /* Error */
/*      */   public TaskOneByOne remUserTask(String userid)
/*      */   {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: getfield 4	mzm/gsp/online/main/LoginManager:userLoginTaskMap	Ljava/util/Map;
/*      */     //   4: dup
/*      */     //   5: astore_2
/*      */     //   6: monitorenter
/*      */     //   7: aload_0
/*      */     //   8: getfield 4	mzm/gsp/online/main/LoginManager:userLoginTaskMap	Ljava/util/Map;
/*      */     //   11: aload_1
/*      */     //   12: invokeinterface 13 2 0
/*      */     //   17: checkcast 6	mzm/gsp/util/TaskOneByOne
/*      */     //   20: aload_2
/*      */     //   21: monitorexit
/*      */     //   22: areturn
/*      */     //   23: astore_3
/*      */     //   24: aload_2
/*      */     //   25: monitorexit
/*      */     //   26: aload_3
/*      */     //   27: athrow
/*      */     // Line number table:
/*      */     //   Java source line #126	-> byte code offset #0
/*      */     //   Java source line #127	-> byte code offset #7
/*      */     //   Java source line #128	-> byte code offset #23
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	signature
/*      */     //   0	28	0	this	LoginManager
/*      */     //   0	28	1	userid	String
/*      */     //   5	20	2	Ljava/lang/Object;	Object
/*      */     //   23	4	3	localObject1	Object
/*      */     // Exception table:
/*      */     //   from	to	target	type
/*      */     //   7	22	23	finally
/*      */     //   23	26	23	finally
/*      */   }
/*      */   
/*      */   private class LinkProtocol
/*      */   {
/*      */     public final int linksid;
/*      */     public final int linkid;
/*      */     public final Protocol protocol;
/*      */     
/*      */     public LinkProtocol(int linksid, int linkid, Protocol protocol)
/*      */     {
/*  137 */       this.linkid = linkid;
/*  138 */       this.linksid = linksid;
/*  139 */       this.protocol = protocol;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   void init()
/*      */   {
/*  147 */     initArgs();
/*      */     
/*  149 */     new LoginIntervalObserver(this.tryLoginInterval);
/*  150 */     new LoginNotifyObserver(this.notifyLoginInterval);
/*  151 */     new Observer(ServerConfigConsts.getInstance().OFFLINE_PERSON_IN_TIME_SEC)
/*      */     {
/*      */       public boolean update()
/*      */       {
/*  155 */         LoginManager.this.nowUseNum = LoginManager.this.offLineNum;
/*  156 */         LoginManager.this.offLineNum = 0;
/*  157 */         return true;
/*      */       }
/*      */       
/*  160 */     };
/*  161 */     PLoadAccountNum proc = new PLoadAccountNum(null);
/*  162 */     proc.call();
/*  163 */     this.userNum = proc.getUserNum();
/*      */   }
/*      */   
/*      */   public void addOffLineNum() {
/*  167 */     this.offLineNum += 1;
/*      */   }
/*      */   
/*      */   public int getMaxPlayerNumber() {
/*  171 */     return this.maxPlayerNum;
/*      */   }
/*      */   
/*      */   void setMaxPlayerNumber(int maxNum) {
/*  175 */     this.maxPlayerNum = maxNum;
/*      */   }
/*      */   
/*      */   void setTryLoginInterval(int interval) {
/*  179 */     this.tryLoginInterval = interval;
/*      */   }
/*      */   
/*      */   public int getTryLoginInterval() {
/*  183 */     return this.tryLoginInterval;
/*      */   }
/*      */   
/*      */   void setIntervalLoginNum(int intervalLoginNum) {
/*  187 */     this.intervalLoginNum = intervalLoginNum;
/*      */   }
/*      */   
/*      */   public int getIntervalLoginNum() {
/*  191 */     return this.intervalLoginNum;
/*      */   }
/*      */   
/*      */   void setNotifyLoginInterval(int notifyLoginInterval) {
/*  195 */     this.notifyLoginInterval = notifyLoginInterval;
/*      */   }
/*      */   
/*      */   public int getNotifyLoginInterval() {
/*  199 */     return this.notifyLoginInterval;
/*      */   }
/*      */   
/*      */   void setAccountNumLimit(boolean accountNumLimit) {
/*  203 */     this.accountNumLimit = accountNumLimit;
/*      */   }
/*      */   
/*      */   void setQueueSize(int queueSize) {
/*  207 */     this.queueCapacity = queueSize;
/*      */   }
/*      */   
/*      */   public boolean isAccountNumLimit() {
/*  211 */     return this.accountNumLimit;
/*      */   }
/*      */   
/*      */   void setAccountNum(int accountNum) {
/*  215 */     this.accountNum = accountNum;
/*      */   }
/*      */   
/*      */   public int getAccountNum() {
/*  219 */     return this.accountNum;
/*      */   }
/*      */   
/*      */   public int getMaxQueueSize() {
/*  223 */     return this.queueCapacity;
/*      */   }
/*      */   
/*      */   public void enterPriorQueue(Protocol protocol) {
/*  227 */     Dispatch ctx = (Dispatch)protocol.getContext();
/*  228 */     String userid = ctx.userid.getString("UTF-8");
/*  229 */     int linksid = ctx.linksid;
/*  230 */     Link link = Onlines.getInstance().find(protocol.getConnection());
/*  231 */     if (link == null) {
/*  232 */       return;
/*      */     }
/*  234 */     int linkid = link.getLinkid();
/*  235 */     synchronized (this.queueLock)
/*      */     {
/*  237 */       int loginNum = getLoginNum();
/*      */       
/*  239 */       int queueSize = this.priorQueue.size();
/*  240 */       int totalQueueSize = this.priorQueue.size() + this.userQueue.size();
/*  241 */       int nowTrueQueueSize = totalQueueSize - loginNum;
/*  242 */       if (nowTrueQueueSize > this.queueCapacity)
/*      */       {
/*  244 */         Kick kick = new Kick();
/*  245 */         kick.action = 1;
/*  246 */         kick.error = 2051;
/*  247 */         kick.linksid = ctx.linksid;
/*  248 */         kick.send(protocol.getConnection());
/*  249 */         return;
/*      */       }
/*  251 */       _innerEnterPriQueue(userid, linkid, linksid, protocol);
/*  252 */       if (loginNum < queueSize) {
/*  253 */         int waitNum = queueSize - loginNum + 1;
/*  254 */         sendLoginQueueInfo(protocol, waitNum);
/*      */       }
/*  256 */       if (GameServer.logger().isDebugEnabled()) {
/*  257 */         GameServer.logger().debug(String.format("[Login]LoginManager.enterPriorQueue@now queue size|size=%d|useid=%s|linksid=%d|linkid=%d", new Object[] { Integer.valueOf(totalQueueSize + 1), userid, Integer.valueOf(linksid), Integer.valueOf(linkid) }));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void _innerEnterPriQueue(String userid, int linkid, int linksid, Protocol protocol)
/*      */   {
/*  271 */     List<LinkProtocol> linkProtocols = (List)this.priorQueue.get(userid);
/*  272 */     LinkProtocol linkProtocol = new LinkProtocol(linksid, linkid, protocol);
/*  273 */     if (linkProtocols == null) {
/*  274 */       linkProtocols = new ArrayList();
/*  275 */       this.priorQueue.put(userid, linkProtocols);
/*      */     }
/*  277 */     linkProtocols.add(linkProtocol);
/*      */   }
/*      */   
/*      */   public void enterQueue(CGetRoleList pro) {
/*  281 */     Dispatch ctx = (Dispatch)pro.getContext();
/*  282 */     String userid = ctx.userid.getString("UTF-8");
/*  283 */     int linksid = ctx.linksid;
/*  284 */     Link link = Onlines.getInstance().find(pro.getConnection());
/*  285 */     if (link == null) {
/*  286 */       return;
/*      */     }
/*  288 */     int linkid = link.getLinkid();
/*      */     
/*  290 */     synchronized (this.queueLock)
/*      */     {
/*      */ 
/*  293 */       int loginNum = getLoginNum();
/*      */       
/*  295 */       int totalQueueSize = this.priorQueue.size() + this.userQueue.size();
/*  296 */       int nowTrueQueueSize = totalQueueSize - loginNum;
/*  297 */       if (nowTrueQueueSize >= this.queueCapacity)
/*      */       {
/*  299 */         Kick kick = new Kick();
/*  300 */         kick.action = 1;
/*  301 */         kick.error = 2051;
/*  302 */         kick.linksid = ctx.linksid;
/*  303 */         kick.send(pro.getConnection());
/*  304 */         return;
/*      */       }
/*  306 */       if (loginNum > totalQueueSize) {
/*  307 */         _innerEnterPriQueue(userid, linkid, linksid, pro);
/*      */       } else {
/*  309 */         List<LinkProtocol> linkProtocols = (List)this.userQueue.get(userid);
/*  310 */         LinkProtocol linkProtocol = new LinkProtocol(linksid, linkid, pro);
/*  311 */         if (linkProtocols == null) {
/*  312 */           linkProtocols = new ArrayList();
/*  313 */           this.userQueue.put(userid, linkProtocols);
/*      */         }
/*  315 */         linkProtocols.add(linkProtocol);
/*      */         
/*  317 */         int waitNum = totalQueueSize - loginNum + 1;
/*  318 */         sendLoginQueueInfo(pro, waitNum);
/*      */       }
/*  320 */       if (GameServer.logger().isDebugEnabled()) {
/*  321 */         GameServer.logger().debug(String.format("[Login]LoginManager.enterPriorQueue@now queue size|size=%d|useid=%s|linksid=%d|linkid=%d", new Object[] { Integer.valueOf(totalQueueSize + 1), userid, Integer.valueOf(linksid), Integer.valueOf(linkid) }));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean leaveQueue(String userid, Link link, int linksid, boolean notExistNeedDelay)
/*      */   {
/*  338 */     int linkid = link.getLinkid();
/*  339 */     return leaveQueue(userid, linkid, linksid, notExistNeedDelay);
/*      */   }
/*      */   
/*      */   boolean leaveQueue(String userid, int linkid, int linksid, boolean notExistNeedDelay) {
/*  343 */     boolean remove = false;
/*  344 */     synchronized (this.queueLock) {
/*  345 */       List<LinkProtocol> linkProtocols = (List)this.userQueue.get(userid);
/*  346 */       if (linkProtocols != null) {
/*  347 */         remove = rmLinkProtocol(linksid, linkid, linkProtocols);
/*  348 */         if (linkProtocols.size() <= 0) {
/*  349 */           this.userQueue.remove(userid);
/*      */         }
/*      */       }
/*  352 */       List<LinkProtocol> linkProtocols2 = (List)this.priorQueue.get(userid);
/*  353 */       if (linkProtocols2 != null) {
/*  354 */         boolean tempRet = rmLinkProtocol(linksid, linkid, linkProtocols2);
/*  355 */         if (!remove) {
/*  356 */           remove = tempRet;
/*      */         }
/*  358 */         if (linkProtocols2.size() <= 0) {
/*  359 */           this.priorQueue.remove(userid);
/*      */         }
/*      */       }
/*  362 */       boolean ret = LoginAssistManager.getInstance().removeFormLoginExcuteQueue(userid, linksid, linkid);
/*  363 */       if (!remove) {
/*  364 */         remove = ret;
/*      */       }
/*  366 */       if ((!remove) && (notExistNeedDelay))
/*      */       {
/*  368 */         GameServer.logger().info(String.format("[Login]LoginManager.leaveQueue@do not exist linksid and link|useid=%s|linksid=%d|linkid=%d", new Object[] { userid, Integer.valueOf(linksid), Integer.valueOf(linkid) }));
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  374 */         new DelayLeaveQueueSession(this.DELAY_LEAVE_QUEUE_SEC, userid, linksid, linkid);
/*      */       }
/*  376 */       if (GameServer.logger().isDebugEnabled()) {
/*  377 */         GameServer.logger().debug(String.format("[Login]LoginManager.leaveQueue@now queue size|size=%d|useid=%s|linksid=%d|linkid=%d", new Object[] { Integer.valueOf(this.userQueue.size() + this.priorQueue.size()), userid, Integer.valueOf(linksid), Integer.valueOf(linkid) }));
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  382 */     return remove;
/*      */   }
/*      */   
/*      */   private boolean rmLinkProtocol(int linksid, int linkid, List<LinkProtocol> linkProtocols) {
/*  386 */     boolean ret = false;
/*  387 */     Iterator<LinkProtocol> iterator = linkProtocols.iterator();
/*  388 */     while (iterator.hasNext()) {
/*  389 */       LinkProtocol linkProtocol = (LinkProtocol)iterator.next();
/*  390 */       if ((linkProtocol.linkid == linkid) && (linkProtocol.linksid == linksid)) {
/*  391 */         iterator.remove();
/*  392 */         ret = true;
/*      */       }
/*      */     }
/*  395 */     return ret;
/*      */   }
/*      */   
/*      */   private void sendLoginQueueInfo(Protocol core, int waitNum) {
/*  399 */     Onlines.getInstance().sendResponse(core, new SLoginQueueInfo(waitNum, offlineNumInTime(), queueTotalNum()));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void tryLogin()
/*      */   {
/*  408 */     int loginNum = getLoginNum();
/*      */     
/*  410 */     loginNum = Math.min(loginNum, this.intervalLoginNum);
/*  411 */     synchronized (this.queueLock)
/*      */     {
/*  413 */       Iterator<Map.Entry<String, List<LinkProtocol>>> priorIter = this.priorQueue.entrySet().iterator();
/*  414 */       loginNum = _innerTryLogin(loginNum, priorIter);
/*      */       
/*  416 */       Iterator<Map.Entry<String, List<LinkProtocol>>> iter = this.userQueue.entrySet().iterator();
/*  417 */       loginNum = _innerTryLogin(loginNum, iter);
/*      */       
/*  419 */       if ((GameServer.logger().isDebugEnabled()) && 
/*  420 */         (System.getProperty("Login") != null)) {
/*  421 */         GameServer.logger().debug(String.format("[Login]LoginManager.tryLogin@now data|loginNum=%d|queuesize=%d|excuteSize=%d|loginProtectSize=%d", new Object[] { Integer.valueOf(Onlines.getInstance().getRoleNum()), Integer.valueOf(this.userQueue.size() + this.priorQueue.size()), Integer.valueOf(LoginAssistManager.getInstance().getExcuteLoginSize()), Integer.valueOf(LoginAssistManager.getInstance().getProtectSize()) }));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getLoginNum()
/*      */   {
/*  433 */     return Math.max(0, this.maxPlayerNum - Onlines.getInstance().getRoleNum() - LoginAssistManager.getInstance().getOwnLoginSize());
/*      */   }
/*      */   
/*      */   private void _innerNotify(Iterator<Map.Entry<String, List<LinkProtocol>>> priorIter)
/*      */   {
/*  438 */     int waitNum = 1;
/*  439 */     while (priorIter.hasNext()) {
/*  440 */       List<LinkProtocol> linkProtocols = (List)((Map.Entry)priorIter.next()).getValue();
/*  441 */       int size = linkProtocols.size();
/*  442 */       if (size <= 0) {
/*  443 */         priorIter.remove();
/*      */       }
/*      */       else {
/*  446 */         sendLoginQueueInfo(((LinkProtocol)linkProtocols.get(size - 1)).protocol, waitNum);
/*  447 */         waitNum++;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*  452 */   private int _innerTryLogin(int loginNum, Iterator<Map.Entry<String, List<LinkProtocol>>> priorIter) { while ((loginNum > 0) && 
/*  453 */       (priorIter.hasNext())) {
/*  454 */       Map.Entry<String, List<LinkProtocol>> entry = (Map.Entry)priorIter.next();
/*  455 */       List<LinkProtocol> linkProtocols = (List)entry.getValue();
/*  456 */       int size = linkProtocols.size();
/*  457 */       if (size <= 0) {
/*  458 */         priorIter.remove();
/*      */       }
/*      */       else {
/*  461 */         String userid = (String)entry.getKey();
/*  462 */         LinkProtocol linkProtocol = (LinkProtocol)linkProtocols.get(size - 1);
/*  463 */         if ((linkProtocol.protocol instanceof CGetRoleList)) {
/*  464 */           LoginAssistManager.getInstance().addExcuteLoginMap(userid, linkProtocol.linksid, linkProtocol.linkid);
/*      */           
/*  466 */           CGetRoleList cGetRoleList = (CGetRoleList)linkProtocol.protocol;
/*  467 */           Procedure.execute(new PGetRoleList(cGetRoleList));
/*  468 */           priorIter.remove();
/*  469 */         } else if ((linkProtocol.protocol instanceof CLoginRole)) {
/*  470 */           LoginAssistManager.getInstance().addExcuteLoginMap(userid, linkProtocol.linksid, linkProtocol.linkid);
/*      */           
/*  472 */           CLoginRole cLoginRole = (CLoginRole)linkProtocol.protocol;
/*  473 */           Procedure.execute(new PPlayerLogin(cLoginRole.roleid, cLoginRole));
/*  474 */           priorIter.remove();
/*  475 */         } else if ((linkProtocol.protocol instanceof CReConnect)) {
/*  476 */           LoginAssistManager.getInstance().addExcuteLoginMap(userid, linkProtocol.linksid, linkProtocol.linkid);
/*      */           
/*  478 */           CReConnect reConnect = (CReConnect)linkProtocol.protocol;
/*  479 */           Procedure.execute(new PPlayerLogin(reConnect.roleid, reConnect));
/*  480 */           priorIter.remove();
/*      */         }
/*      */         
/*      */ 
/*      */ 
/*  485 */         loginNum--;
/*      */       } }
/*  487 */     return loginNum;
/*      */   }
/*      */   
/*      */   void notifyLogin() {
/*  491 */     int loginNum = getLoginNum();
/*      */     
/*  493 */     synchronized (this.queueLock)
/*      */     {
/*  495 */       Iterator<Map.Entry<String, List<LinkProtocol>>> priorIter = this.priorQueue.entrySet().iterator();
/*  496 */       int priorNum = loginNum;
/*  497 */       while ((priorNum > 0) && 
/*  498 */         (priorIter.hasNext())) {
/*  499 */         priorIter.next();
/*  500 */         priorNum--;
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  505 */       _innerNotify(priorIter);
/*      */       
/*  507 */       int userQueueNum = loginNum;
/*  508 */       Iterator<Map.Entry<String, List<LinkProtocol>>> iter = this.userQueue.entrySet().iterator();
/*  509 */       while ((userQueueNum > 0) && 
/*  510 */         (iter.hasNext())) {
/*  511 */         iter.next();
/*  512 */         userQueueNum--;
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  517 */       _innerNotify(iter);
/*      */     }
/*      */   }
/*      */   
/*      */   private int offlineNumInTime()
/*      */   {
/*  523 */     if (this.nowUseNum == 0) {
/*  524 */       return this.offLineNum;
/*      */     }
/*  526 */     return this.nowUseNum;
/*      */   }
/*      */   
/*      */   /* Error */
/*      */   private int queueTotalNum()
/*      */   {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: getfield 24	mzm/gsp/online/main/LoginManager:queueLock	Ljava/lang/Object;
/*      */     //   4: dup
/*      */     //   5: astore_1
/*      */     //   6: monitorenter
/*      */     //   7: aload_0
/*      */     //   8: getfield 27	mzm/gsp/online/main/LoginManager:priorQueue	Ljava/util/LinkedHashMap;
/*      */     //   11: invokevirtual 54	java/util/LinkedHashMap:size	()I
/*      */     //   14: aload_0
/*      */     //   15: getfield 28	mzm/gsp/online/main/LoginManager:userQueue	Ljava/util/LinkedHashMap;
/*      */     //   18: invokevirtual 54	java/util/LinkedHashMap:size	()I
/*      */     //   21: iadd
/*      */     //   22: aload_1
/*      */     //   23: monitorexit
/*      */     //   24: ireturn
/*      */     //   25: astore_2
/*      */     //   26: aload_1
/*      */     //   27: monitorexit
/*      */     //   28: aload_2
/*      */     //   29: athrow
/*      */     // Line number table:
/*      */     //   Java source line #531	-> byte code offset #0
/*      */     //   Java source line #532	-> byte code offset #7
/*      */     //   Java source line #533	-> byte code offset #25
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	signature
/*      */     //   0	30	0	this	LoginManager
/*      */     //   5	22	1	Ljava/lang/Object;	Object
/*      */     //   25	4	2	localObject1	Object
/*      */     // Exception table:
/*      */     //   from	to	target	type
/*      */     //   7	24	25	finally
/*      */     //   25	28	25	finally
/*      */   }
/*      */   
/*      */   void initArgs()
/*      */   {
/*  537 */     setIntervalLoginNum(LoginArgs.getInstance().intervalLoginNum);
/*  538 */     setMaxPlayerNumber(LoginArgs.getInstance().maxPlayerNum);
/*  539 */     setNotifyLoginInterval(LoginArgs.getInstance().notifyLoginInterval);
/*  540 */     setTryLoginInterval(LoginArgs.getInstance().tryLoginInterval);
/*  541 */     setAccountNum(LoginArgs.getInstance().accountNum);
/*  542 */     setAccountNumLimit(LoginArgs.getInstance().accountNumLimit);
/*  543 */     this.queueCapacity = LoginArgs.getInstance().queueCapacity;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean checkAccountNum(String userid, boolean retainLock)
/*      */   {
/*  557 */     if (this.accountNumLimit) {
/*  558 */       AccountNumBean xAccountNumBean = null;
/*  559 */       if (retainLock) {
/*  560 */         xAccountNumBean = Accountnum.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*      */       } else {
/*  562 */         xAccountNumBean = Accountnum.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/*      */       }
/*  564 */       if (xAccountNumBean == null) {
/*  565 */         return true;
/*      */       }
/*  567 */       if (xtable.User.selectActivated(userid) != null) {
/*  568 */         return true;
/*      */       }
/*  570 */       int size = xAccountNumBean.getUsernum();
/*  571 */       return size < this.accountNum;
/*      */     }
/*  573 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean insertAccount(String userid)
/*      */   {
/*  585 */     long localId = GameServerInfoManager.getLocalId();
/*  586 */     AccountNumBean xAccountNumBean = Accountnum.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  587 */     if (xAccountNumBean == null) {
/*  588 */       xAccountNumBean = Pod.newAccountNumBean();
/*  589 */       Accountnum.insert(Long.valueOf(localId), xAccountNumBean);
/*      */     }
/*  591 */     int nowNum = xAccountNumBean.getUsernum();
/*  592 */     if ((this.accountNumLimit) && (nowNum >= this.accountNum)) {
/*  593 */       return false;
/*      */     }
/*  595 */     xAccountNumBean.setUsernum(nowNum + 1);
/*      */     
/*      */ 
/*  598 */     this.userNum = xAccountNumBean.getUsernum();
/*      */     
/*  600 */     return true;
/*      */   }
/*      */   
/*      */   public int getUserNum() {
/*  604 */     return this.userNum;
/*      */   }
/*      */   
/*      */   public void onAccountNumMax(Protocol core)
/*      */   {
/*  609 */     Dispatch ctx = (Dispatch)core.getContext();
/*  610 */     SAccountNumLimit accountNumLimit = new SAccountNumLimit();
/*  611 */     Onlines.getInstance().sendResponse(core, accountNumLimit);
/*      */     
/*      */ 
/*  614 */     Kick kick = new Kick();
/*  615 */     kick.action = 1;
/*  616 */     kick.error = 2050;
/*  617 */     kick.linksid = ctx.linksid;
/*  618 */     kick.send(core.getConnection());
/*      */   }
/*      */   
/*      */   public void kickOut(Protocol core, int errorCode)
/*      */   {
/*  623 */     Dispatch ctx = (Dispatch)core.getContext();
/*      */     
/*  625 */     Kick kick = new Kick();
/*  626 */     kick.action = 1;
/*  627 */     kick.error = errorCode;
/*  628 */     kick.linksid = ctx.linksid;
/*  629 */     kick.send(core.getConnection());
/*      */   }
/*      */   
/*      */   private static class PLoadAccountNum extends LogicProcedure {
/*  633 */     private int userNum = 0;
/*      */     
/*      */     public int getUserNum() {
/*  636 */       return this.userNum;
/*      */     }
/*      */     
/*      */     protected boolean processImp() throws Exception
/*      */     {
/*  641 */       AccountNumBean xAccountNumBean = Accountnum.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  642 */       if (xAccountNumBean == null) {
/*  643 */         return true;
/*      */       }
/*      */       
/*  646 */       this.userNum = xAccountNumBean.getUsernum();
/*  647 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static abstract class CheckCrossServer
/*      */     extends LogicProcedure
/*      */   {
/*      */     protected final String userid;
/*      */     
/*      */ 
/*      */ 
/*      */     protected final long loginRoleid;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     CheckCrossServer(String userid, long loginRoleid)
/*      */     {
/*  668 */       this.userid = userid;
/*  669 */       this.loginRoleid = loginRoleid;
/*      */     }
/*      */     
/*      */     public CheckCrossServer(String userid) {
/*  673 */       this(userid, 0L);
/*      */     }
/*      */     
/*      */     protected boolean processImp() throws Exception
/*      */     {
/*  678 */       lock(xtable.User.getTable(), Arrays.asList(new String[] { this.userid }));
/*  679 */       LocalCrossToken xLocalCrossToken = User2localcrossstoken.get(this.userid);
/*  680 */       if (xLocalCrossToken != null) {
/*  681 */         if (GameServerInfoManager.isValidZone(xLocalCrossToken.getZoneid()))
/*      */         {
/*  683 */           if ((this.loginRoleid > 0L) && (this.loginRoleid != xLocalCrossToken.getRoleid())) {
/*  684 */             GameServer.logger().info(String.format("[Login]LoginManager.CheckCrossServer@loginRoleid is wrong|crossRoleid=%d|loginRoleid=%d", new Object[] { Long.valueOf(xLocalCrossToken.getRoleid()), Long.valueOf(this.loginRoleid) }));
/*      */             
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  690 */             Procedure.execute(new LogicProcedure()
/*      */             {
/*      */               protected boolean processImp() throws Exception
/*      */               {
/*  694 */                 LoginManager.CheckCrossServer.this.callBack(true);
/*  695 */                 return true;
/*      */               }
/*      */             });
/*      */           } else {
/*  699 */             Procedure.execute(new LogicProcedure()
/*      */             {
/*      */               protected boolean processImp() throws Exception
/*      */               {
/*  703 */                 LoginManager.CheckCrossServer.this.callBack(false);
/*  704 */                 return true;
/*      */               }
/*      */             });
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/*  711 */           DataTransferReq req = new DataTransferReq();
/*  712 */           req.direction = 0;
/*  713 */           req.data_type = 3;
/*  714 */           req.src_id = GameServerInfoManager.getZoneidFromUserid(this.userid);
/*  715 */           req.dst_id = xLocalCrossToken.getZoneid();
/*  716 */           ValidateRoamTokenReq validateRoamTokenReq = new ValidateRoamTokenReq();
/*  717 */           validateRoamTokenReq.roleid = xLocalCrossToken.getRoleid();
/*  718 */           validateRoamTokenReq.userid.setString(this.userid, "UTF-8");
/*  719 */           validateRoamTokenReq.token = new Octets(xLocalCrossToken.getTokenCopy());
/*  720 */           OctetsStream os = new OctetsStream();
/*  721 */           os.marshal(validateRoamTokenReq);
/*  722 */           req.data = os;
/*  723 */           ValidateRoamTokenTransferReqXidWrapper reqXidWrapper = new ValidateRoamTokenTransferReqXidWrapper(req, this);
/*      */           
/*  725 */           if (!GHubHelper.sendDataTransferReq(reqXidWrapper, true, 2)) {
/*  726 */             addNormalRole(this.userid, xLocalCrossToken.getRoleid(), xLocalCrossToken.getZoneid(), new Octets(xLocalCrossToken.getTokenCopy()));
/*      */             
/*  728 */             return false;
/*      */           }
/*  730 */           return true;
/*      */         }
/*      */       } else {
/*  733 */         Procedure.execute(new LogicProcedure()
/*      */         {
/*      */           protected boolean processImp() throws Exception {
/*  736 */             LoginManager.CheckCrossServer.this.callBack(false);
/*  737 */             return true;
/*      */           }
/*      */         });
/*      */       }
/*      */       
/*  742 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public void addNormalRole(final String userid, final long roleid, int zoneid, final Octets token)
/*      */     {
/*  751 */       GameServer.logger().error("[Login]LoginManager.CheckCrossServer.addNormalRole@server is in crossServer,but crossServer status is error!");
/*      */       
/*      */ 
/*  754 */       Procedure.execute(new LogicProcedure()
/*      */       {
/*      */         protected boolean processImp() throws Exception
/*      */         {
/*  758 */           boolean inCross = true;
/*  759 */           LocalCrossToken xLocalCrossToken = User2localcrossstoken.get(userid);
/*  760 */           if (xLocalCrossToken != null) {
/*  761 */             if ((xLocalCrossToken.getRoleid() == roleid) && (xLocalCrossToken.getZoneid() == token)) {
/*  762 */               Octets octets = new Octets(xLocalCrossToken.getTokenCopy());
/*  763 */               if (octets.equals(this.val$token)) {
/*  764 */                 LoginManager.getInstance().onRoleCrossEnd(userid, roleid);
/*  765 */                 inCross = false;
/*      */               }
/*      */             }
/*      */           }
/*      */           else {
/*  770 */             inCross = false;
/*      */           }
/*  772 */           final boolean cross = inCross;
/*  773 */           Procedure.execute(new LogicProcedure()
/*      */           {
/*      */             protected boolean processImp() throws Exception
/*      */             {
/*  777 */               LoginManager.CheckCrossServer.this.callBack(cross);
/*  778 */               return true;
/*      */             }
/*  780 */           });
/*  781 */           return true;
/*      */         }
/*      */       });
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public void addCrossRole()
/*      */     {
/*  792 */       Procedure.execute(new LogicProcedure()
/*      */       {
/*      */         protected boolean processImp() throws Exception
/*      */         {
/*  796 */           LoginManager.CheckCrossServer.this.callBack(true);
/*  797 */           return true;
/*      */         }
/*      */       });
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     abstract void callBack(boolean paramBoolean);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void onRoleCrossEnd(String userid, long roleid)
/*      */   {
/*  818 */     User2localcrossstoken.remove(userid);
/*  819 */     RoleStatusInterface.unsetStatus(roleid, 41);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Long getCrossRoleid(String userid, boolean retainLock)
/*      */   {
/*  830 */     LocalCrossToken xLocalCrossToken = null;
/*  831 */     if (retainLock) {
/*  832 */       xLocalCrossToken = User2localcrossstoken.get(userid);
/*      */     } else {
/*  834 */       xLocalCrossToken = User2localcrossstoken.select(userid);
/*      */     }
/*  836 */     if (xLocalCrossToken == null) {
/*  837 */       return null;
/*      */     }
/*  839 */     return Long.valueOf(xLocalCrossToken.getRoleid());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void onReturnOrigianServer(String userid, long roleid)
/*      */   {
/*  849 */     Onlines.getInstance().kick(Long.valueOf(roleid), 2057);
/*  850 */     User2crossstoken.remove(userid);
/*      */     
/*  852 */     CrossServerInterface.unsetRoleRoamServerStatus(userid, roleid);
/*      */     
/*  854 */     new PPlayerPreLogout(roleid, 2).call();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean validateRomoteServerToken(String userid, Octets token)
/*      */   {
/*  865 */     CrossToken xCrossToken = User2crossstoken.get(userid);
/*  866 */     if (xCrossToken == null) {
/*  867 */       return false;
/*      */     }
/*  869 */     Octets octets = new Octets(xCrossToken.getTokenCopy());
/*  870 */     return octets.equals(token);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void checkInCrossServer(final String userId, final PGetRoleList pGetRoleList)
/*      */   {
/*  881 */     Procedure.execute(new CheckCrossServer(userId)
/*      */     {
/*      */       void callBack(boolean isInCross)
/*      */       {
/*  885 */         xbean.User xUser = xtable.User.get(userId);
/*  886 */         lock(Role2properties.getTable(), xUser.getRoleids());
/*  887 */         if (isInCross) {
/*  888 */           LocalCrossToken xLocalCrossToken = User2localcrossstoken.get(userId);
/*  889 */           if (xLocalCrossToken == null) {
/*  890 */             pGetRoleList.innerGetRoleList(this.userid, xUser, xUser.getRoleids());
/*      */           } else {
/*  892 */             LoginManager.this.onRoleInCross(xLocalCrossToken, pGetRoleList.getCGetRoleList());
/*      */           }
/*      */         } else {
/*  895 */           pGetRoleList.innerGetRoleList(this.userid, xUser, xUser.getRoleids());
/*      */         }
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */   void fillRoleInCrossMsg(SRoleInCrossServerRes roleInCrossServerRes, LocalCrossToken xCrossToken) {
/*  902 */     roleInCrossServerRes.roleid = xCrossToken.getRoleid();
/*  903 */     roleInCrossServerRes.zoneid = xCrossToken.getZoneid();
/*  904 */     roleInCrossServerRes.token = new Octets(xCrossToken.getTokenCopy());
/*      */   }
/*      */   
/*      */   void onRoleInCross(LocalCrossToken xLocalCrossToken, Protocol protocol) {
/*  908 */     SRoleInCrossServerRes roleInCrossServerRes = new SRoleInCrossServerRes();
/*  909 */     fillRoleInCrossMsg(roleInCrossServerRes, xLocalCrossToken);
/*  910 */     Onlines.getInstance().sendResponse(protocol, roleInCrossServerRes);
/*  911 */     kickOut(protocol, 2056);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void onRoleDataReadySucceed(int remoteZoneid, List<UserCrossToken> userCrossTokens, int delaySec)
/*      */   {
/*  921 */     for (UserCrossToken userCrossToken : userCrossTokens) {
/*  922 */       onRoleDataReadySucceed(remoteZoneid, userCrossToken, delaySec);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void onRoleDataReadySucceed(int remoteZoneid, UserCrossToken userCrossToken, int delaySec)
/*      */   {
/*  933 */     innerSaveLocalCrossToken(remoteZoneid, userCrossToken);
/*  934 */     RoleStatusInterface.setStatus(userCrossToken.roleid, 41, false);
/*  935 */     RoleStatusInterface.setStatus(userCrossToken.roleid, 411, false);
/*      */     
/*  937 */     SSynServerNotTipSignRes synServerNotTipSignRes = new SSynServerNotTipSignRes();
/*  938 */     synServerNotTipSignRes.istip = 0;
/*  939 */     OnlineManager.getInstance().sendAtOnce(userCrossToken.roleid, synServerNotTipSignRes);
/*      */     
/*  941 */     CrossTokenCheckObserver.createCrossTokenCheckObserver(userCrossToken.roleid);
/*  942 */     SRoleInCrossServerRes roleInCrossServerRes = new SRoleInCrossServerRes();
/*  943 */     fillRoleInCrossMsg(roleInCrossServerRes, remoteZoneid, userCrossToken);
/*  944 */     OnlineManager.getInstance().sendAtOnce(userCrossToken.roleid, roleInCrossServerRes);
/*  945 */     new DelayKickSession(delaySec, userCrossToken.roleid);
/*      */   }
/*      */   
/*      */   private static void innerSaveLocalCrossToken(int zoneid, UserCrossToken userCrossToken) {
/*  949 */     LocalCrossToken xLocalCrossToken = User2localcrossstoken.get(userCrossToken.userid);
/*  950 */     if (xLocalCrossToken == null) {
/*  951 */       xLocalCrossToken = Pod.newLocalCrossToken();
/*  952 */       User2localcrossstoken.insert(userCrossToken.userid, xLocalCrossToken);
/*      */     }
/*  954 */     xLocalCrossToken.setRoleid(userCrossToken.roleid);
/*  955 */     xLocalCrossToken.setTokenCopy(userCrossToken.token.getBytes());
/*  956 */     xLocalCrossToken.setZoneid(zoneid);
/*      */   }
/*      */   
/*      */   private void fillRoleInCrossMsg(SRoleInCrossServerRes roleInCrossServerRes, int remoteZoneid, UserCrossToken userCrossToken)
/*      */   {
/*  961 */     roleInCrossServerRes.roleid = userCrossToken.roleid;
/*  962 */     roleInCrossServerRes.zoneid = remoteZoneid;
/*  963 */     roleInCrossServerRes.token = userCrossToken.token;
/*      */   }
/*      */   
/*      */   void checkInCrossServer(String userId, long loginRoleid, final PPlayerLogin playerLogin) {
/*  967 */     Procedure.execute(new CheckCrossServer(userId, loginRoleid)
/*      */     {
/*      */       void callBack(boolean isInCross)
/*      */       {
/*  971 */         xbean.User xUser = xtable.User.get(playerLogin);
/*  972 */         lock(Role2properties.getTable(), xUser.getRoleids());
/*  973 */         if (isInCross) {
/*  974 */           LocalCrossToken xLocalCrossToken = User2localcrossstoken.get(playerLogin);
/*  975 */           if (xLocalCrossToken == null) {
/*  976 */             this.val$playerLogin.innerLogin(this.userid, xUser);
/*      */           } else {
/*  978 */             LoginManager.this.onRoleInCross(xLocalCrossToken, this.val$playerLogin.getProtocol());
/*      */           }
/*      */         } else {
/*  981 */           if (this.loginRoleid > 0L) {
/*  982 */             RoleStatusInterface.unsetStatus(this.loginRoleid, 41);
/*      */           }
/*  984 */           this.val$playerLogin.innerLogin(this.userid, xUser);
/*      */         }
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */   public static class UserCrossToken {
/*      */     public final String userid;
/*      */     public final long roleid;
/*      */     public final Octets token;
/*      */     
/*      */     public UserCrossToken(String userid, long roleid, Octets token) {
/*  996 */       this.userid = userid;
/*  997 */       this.roleid = roleid;
/*  998 */       this.token = token;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void saveCrossToken(List<UserCrossToken> userCrossTokens)
/*      */   {
/* 1008 */     int zoneid = GameServerInfoManager.getZoneId();
/* 1009 */     for (UserCrossToken userCrossToken : userCrossTokens) {
/* 1010 */       innerRemoteSaveCrossToken(zoneid, userCrossToken);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void saveCrossToken(UserCrossToken userCrossToken)
/*      */   {
/* 1020 */     innerRemoteSaveCrossToken(GameServerInfoManager.getZoneId(), userCrossToken);
/*      */   }
/*      */   
/*      */   private static void innerRemoteSaveCrossToken(int zoneid, UserCrossToken userCrossToken) {
/* 1024 */     CrossToken xCrossToken = User2crossstoken.get(userCrossToken.userid);
/* 1025 */     if (xCrossToken == null) {
/* 1026 */       xCrossToken = Pod.newCrossToken();
/* 1027 */       User2crossstoken.insert(userCrossToken.userid, xCrossToken);
/*      */     }
/* 1029 */     xCrossToken.setRoleid(userCrossToken.roleid);
/* 1030 */     xCrossToken.setTokenCopy(userCrossToken.token.getBytes());
/* 1031 */     xCrossToken.setZoneid(zoneid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void remRoamedToken(String userid)
/*      */   {
/* 1040 */     User2crossstoken.remove(userid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isInCrossServer(String userid)
/*      */   {
/* 1051 */     LocalCrossToken xLocalCrossToken = User2localcrossstoken.get(userid);
/* 1052 */     if (xLocalCrossToken == null) {
/* 1053 */       return false;
/*      */     }
/* 1055 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Octets getRoamToken(String userid)
/*      */   {
/* 1066 */     CrossToken xCrossToken = User2crossstoken.get(userid);
/* 1067 */     if (xCrossToken == null) {
/* 1068 */       return null;
/*      */     }
/* 1070 */     return new Octets(xCrossToken.getTokenCopy());
/*      */   }
/*      */   
/*      */   public static Octets getLocalToken(String userid)
/*      */   {
/* 1075 */     LocalCrossToken xLocalCrossToken = User2localcrossstoken.get(userid);
/* 1076 */     if (xLocalCrossToken == null) {
/* 1077 */       return null;
/*      */     }
/* 1079 */     return new Octets(xLocalCrossToken.getTokenCopy());
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\LoginManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */