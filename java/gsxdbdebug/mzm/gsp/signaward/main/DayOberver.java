/*     */ package mzm.gsp.signaward.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.timer.main.DateObserver;
/*     */ import mzm.gsp.timer.main.DateObserver.MyDate;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.OnlineAward;
/*     */ import xbean.Sign;
/*     */ import xdb.Executor;
/*     */ import xtable.Role2sign;
/*     */ 
/*     */ class DayOberver extends DateObserver
/*     */ {
/*     */   public DayOberver(DateObserver.MyDate myDate)
/*     */   {
/*  21 */     super(myDate);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean onTimeOut()
/*     */   {
/*  28 */     xdb.Xdb.executor().execute(new DayObserverTimeoutRunnable(null));
/*  29 */     return true;
/*     */   }
/*     */   
/*     */   private static class DayObserverTimeoutRunnable
/*     */     extends mzm.gsp.util.LogicRunnable
/*     */   {
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/*  38 */       long now = DateTimeUtils.getCurrTimeInMillis();
/*     */       
/*  40 */       String logstr = String.format("[loginaward]DayObserverTimeoutRunnable.process@Day observer time out|nowtime=%s|now=%d", new Object[] { DateTimeUtils.formatTimestamp(now), Long.valueOf(now) });
/*     */       
/*     */ 
/*  43 */       SignAwardManager.logger.info(logstr);
/*  44 */       long currenttime = now + TimeUnit.MINUTES.toMillis(1L);
/*  45 */       List<Long> roleList = OnlineManager.getInstance().getAllRolesInWorld();
/*  46 */       Iterator<Long> iterator = roleList.iterator();
/*  47 */       while (iterator.hasNext())
/*     */       {
/*  49 */         long roleid = ((Long)iterator.next()).longValue();
/*     */         
/*  51 */         new DayOberver.SignProcedure(roleid, currenttime).call();
/*     */         
/*     */ 
/*  54 */         new DayOberver.LoginDayProcedure(roleid, currenttime).call();
/*     */         
/*  56 */         new DayOberver.OnlinetimeProcedure(roleid, currenttime).call();
/*     */         
/*  58 */         iterator.remove();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class SignProcedure
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     
/*     */     private final long currenttime;
/*     */     
/*     */     public SignProcedure(long roleid, long currenttime)
/*     */     {
/*  73 */       this.roleid = roleid;
/*  74 */       this.currenttime = currenttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  82 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*  83 */       lock(xdb.Lockeys.get(xtable.User.getTable(), userid));
/*  84 */       Sign xSign = Role2sign.get(Long.valueOf(this.roleid));
/*  85 */       if (DateTimeUtils.getDay(this.currenttime) != 1)
/*     */       {
/*  87 */         SignAwardManager.sendSSignInRes(this.roleid, xSign, this.currenttime, 0, 0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/*  93 */       else if (xSign != null)
/*     */       {
/*  95 */         long taotalcash = mzm.gsp.qingfu.main.QingfuInterface.getSaveAmt(userid, true);
/*  96 */         int canawardfillcount = SignAwardManager.getAwardfillcount(taotalcash);
/*  97 */         xSign.setAwardedfillincount(canawardfillcount);
/*  98 */         xSign.setFillincount(canawardfillcount);
/*  99 */         xSign.setSigncount(0);
/* 100 */         xSign.setSigntime(0L);
/* 101 */         xSign.setSignday(0);
/* 102 */         xSign.setCurrent_precious_cell_num(0);
/* 103 */         xSign.setCurrent_precious_box_buff_id(0);
/* 104 */         xSign.setLucky_box_sign_box_buff_id(0);
/* 105 */         xSign.setLucky_box_gold_precious_cfg_id(0);
/*     */         
/* 107 */         String logstr = String.format("[sign]SignProcedure.processImp@role init sign count success|userid=%s|roleid=%d|addnum=%d|taotalcash=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(canawardfillcount), Long.valueOf(taotalcash) });
/*     */         
/*     */ 
/* 110 */         SignAwardManager.logger.info(logstr);
/*     */         
/* 112 */         SignAwardManager.sendSSignInRes(this.roleid, xSign, this.currenttime, 0, 0);
/*     */       }
/*     */       
/*     */ 
/* 116 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class LoginDayProcedure extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final long currenttime;
/*     */     
/*     */     public LoginDayProcedure(long roleid, long currenttime)
/*     */     {
/* 127 */       this.roleid = roleid;
/* 128 */       this.currenttime = currenttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 136 */       long logintime = SignAwardManager.getLoginTime(this.roleid);
/* 137 */       if ((!DateTimeUtils.isInSameDay(this.currenttime, logintime)) && (this.currenttime > logintime))
/*     */       {
/* 139 */         SignAwardManager.addLoginDay(this.roleid, DateTimeUtils.getTimeInToday(this.currenttime, 0, 0, 0));
/* 140 */         SignAwardManager.sendSLoginAwardRes(this.roleid, null);
/*     */       }
/*     */       else
/*     */       {
/* 144 */         String logstr = String.format("[loginaward]LoginDayProcedure.processImp@should not run to here|roleid=%d|now=%s|currenttime=%d|logintime=%d", new Object[] { Long.valueOf(this.roleid), DateTimeUtils.formatTimestamp(this.currenttime), Long.valueOf(this.currenttime), Long.valueOf(logintime) });
/*     */         
/*     */ 
/* 147 */         SignAwardManager.logger.error(logstr);
/*     */       }
/* 149 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class OnlinetimeProcedure extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final long currenttime;
/*     */     
/*     */     public OnlinetimeProcedure(long roleid, long currenttime)
/*     */     {
/* 160 */       this.roleid = roleid;
/* 161 */       this.currenttime = currenttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 169 */       OnlineAward xOnlineAward = xtable.Role2onlineaward.get(Long.valueOf(this.roleid));
/* 170 */       if (xOnlineAward == null)
/*     */       {
/*     */ 
/* 173 */         String logstr = String.format("[onlineaward]OnlinetimeProcedure.processImp@day observer time out,xOnlineAward null,should not run to here|roleid=%d|now=%s", new Object[] { Long.valueOf(this.roleid), DateTimeUtils.formatTimestamp(this.currenttime) });
/*     */         
/*     */ 
/* 176 */         SignAwardManager.logger.error(logstr);
/* 177 */         return false;
/*     */       }
/* 179 */       if ((!DateTimeUtils.isInSameDay(this.currenttime, xOnlineAward.getLogintime())) && (this.currenttime > xOnlineAward.getLogintime()))
/*     */       {
/*     */ 
/*     */ 
/* 183 */         SignAwardManager.resetOnlineAward(xOnlineAward, DateTimeUtils.getTimeInToday(this.currenttime, 0, 0, 0));
/*     */         
/* 185 */         SignAwardManager.sendSSynOnlineTimeRes(this.roleid, 0);
/* 186 */         SignAwardManager.sendSSynAwardedRes(this.roleid, xOnlineAward, null);
/*     */       }
/*     */       else
/*     */       {
/* 190 */         String logstr = String.format("[onlineaward]OnlinetimeProcedure.processImp@should not run to here|roleid=%d|now=%s|currenttime=%d|logintime=%d", new Object[] { Long.valueOf(this.roleid), DateTimeUtils.formatTimestamp(this.currenttime), Long.valueOf(this.currenttime), Long.valueOf(xOnlineAward.getLogintime()) });
/*     */         
/*     */ 
/* 193 */         SignAwardManager.logger.error(logstr);
/*     */       }
/* 195 */       String logstr = String.format("[onlineaward]OnlinetimeProcedure.processImp@day observer time out,reset role online time|roleid=%d|logintime=%s|totaltime=%d", new Object[] { Long.valueOf(this.roleid), DateTimeUtils.formatTimestamp(xOnlineAward.getLogintime()), Long.valueOf(xOnlineAward.getOnlinetime()) });
/*     */       
/*     */ 
/* 198 */       SignAwardManager.logger.info(logstr);
/* 199 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\main\DayOberver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */