/*     */ package mzm.gsp.banquest.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.homeland.confbean.STBRankCalCfg;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BanquestInfo;
/*     */ import xbean.BanquestSessionInfo;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Procedure;
/*     */ import xtable.Role2banquestinfo;
/*     */ import xtable.Role2banqustsession;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PBanquestSession extends Session
/*     */ {
/*     */   private final long banquestStartTime;
/*     */   private final String startTimeStr;
/*     */   
/*     */   public PBanquestSession(long interval, long roleId, long banquestStartTime)
/*     */   {
/*  32 */     super(interval, roleId);
/*  33 */     this.banquestStartTime = banquestStartTime;
/*  34 */     this.startTimeStr = BanquestManager.getFormatDate(banquestStartTime);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  40 */     Procedure.execute(new POfferDishes(null));
/*     */   }
/*     */   
/*     */   public long getBanquestStartTime()
/*     */   {
/*  45 */     return this.banquestStartTime;
/*     */   }
/*     */   
/*     */   public String getStartTimeStr()
/*     */   {
/*  50 */     return this.startTimeStr;
/*     */   }
/*     */   
/*     */ 
/*     */   private class POfferDishes
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private long roleId;
/*     */     
/*     */     private STBRankCalCfg cfg;
/*     */     
/*     */     private int guyNum;
/*     */     
/*     */     private long homeWorldId;
/*     */     private int fengshuiValue;
/*     */     
/*     */     private POfferDishes() {}
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  71 */       if (!BanquestManager.isBanquestOpen(this.roleId, true))
/*     */       {
/*  73 */         return false;
/*     */       }
/*  75 */       if (!init())
/*     */       {
/*  77 */         return false;
/*     */       }
/*     */       
/*  80 */       String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  81 */       lock(Lockeys.get(User.getTable(), userId));
/*     */       
/*  83 */       BanquestInfo xBanquestInfo = Role2banquestinfo.get(Long.valueOf(this.roleId));
/*  84 */       if (xBanquestInfo == null)
/*     */       {
/*  86 */         GameServer.logger().error(String.format("[banquest]POfferDishes.processImp@ xBanquestInfo is null!|roleId=%d|startTime=%s", new Object[] { Long.valueOf(this.roleId), PBanquestSession.this.startTimeStr }));
/*     */         
/*     */ 
/*  89 */         return false;
/*     */       }
/*  91 */       BanquestSessionInfo xBanquestSessionInfo = Role2banqustsession.get(Long.valueOf(this.roleId));
/*  92 */       if (xBanquestSessionInfo == null)
/*     */       {
/*     */ 
/*  95 */         GameServer.logger().error(String.format("[banquest]POfferDishes.processImp@ xBanquestSessionInfo is null!|roleId=%d|startTime=%s", new Object[] { Long.valueOf(this.roleId), PBanquestSession.this.startTimeStr }));
/*     */         
/*     */ 
/*     */ 
/*  99 */         return false;
/*     */       }
/*     */       
/* 102 */       int dishCount = xBanquestInfo.getDishescount();
/* 103 */       if (dishCount >= BanquestManager.getDishesMax())
/*     */       {
/* 105 */         GameServer.logger().info(String.format("[banquest]POfferDishes.processImp@ all dishes finished!|roleId=%d|startTime=%s", new Object[] { Long.valueOf(this.roleId), PBanquestSession.this.startTimeStr }));
/*     */         
/*     */ 
/* 108 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 112 */       offerDishes(xBanquestInfo, xBanquestSessionInfo, dishCount);
/*     */       
/* 114 */       GameServer.logger().info(String.format("[banquest]POfferDishes.processImp@ new dishes!@ masterId=%d|worldId=%d|rank=%d|dishCount=%d|startTime=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.homeWorldId), Integer.valueOf(this.cfg.rank), Integer.valueOf(xBanquestInfo.getDishescount()), PBanquestSession.this.startTimeStr }));
/*     */       
/*     */ 
/*     */ 
/* 118 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private void offerDishes(BanquestInfo xBanquestInfo, BanquestSessionInfo xBanquestSessionInfo, int dishCount)
/*     */     {
/* 130 */       this.homeWorldId = BanquestManager.getHomeLandWorldId(this.roleId);
/*     */       
/* 132 */       Map<Integer, Integer> controllerInfo = triggerDishes(this.homeWorldId);
/*     */       
/* 134 */       xBanquestInfo.setDishescount(dishCount + 1);
/*     */       
/* 136 */       PClearControllerSession clearSession = new PClearControllerSession(BanquestManager.getClearControllerInterval(), this.roleId);
/*     */       
/* 138 */       xBanquestSessionInfo.setClearcontrollersessionid(clearSession.getSessionId());
/*     */       
/* 140 */       if (xBanquestInfo.getDishescount() >= BanquestManager.getDishesMax())
/*     */       {
/* 142 */         GameServer.logger().info(String.format("[banquest]POfferDishes.procofferDishesessImp@ all dishes finished, no next dish!|roleId=%d|startTimeStr=%s", new Object[] { Long.valueOf(this.roleId), PBanquestSession.this.startTimeStr }));
/*     */         
/*     */ 
/*     */ 
/* 146 */         return;
/*     */       }
/* 148 */       PBanquestSession pBanquestSession = new PBanquestSession(BanquestManager.getDishesInterval(), this.roleId, PBanquestSession.this.banquestStartTime);
/*     */       
/* 150 */       xBanquestSessionInfo.setBanquestsessionid(pBanquestSession.getSessionId());
/*     */       
/* 152 */       BanquestTlogManager.tlogOfferDishes(this.roleId, controllerInfo, xBanquestInfo.getDishescount(), this.cfg.rank, PBanquestSession.this.banquestStartTime);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private Map<Integer, Integer> triggerDishes(long homeWorldId)
/*     */     {
/* 165 */       if (homeWorldId <= 0L)
/*     */       {
/* 167 */         GameServer.logger().warn(String.format("[banquest]POfferDishes.triggerDishes@ no homeLand world!|roleId=%d|startTimeStr=%s", new Object[] { Long.valueOf(this.roleId), PBanquestSession.this.startTimeStr }));
/*     */         
/*     */ 
/* 170 */         return new HashMap();
/*     */       }
/* 172 */       if (this.guyNum <= 0)
/*     */       {
/* 174 */         GameServer.logger().warn(String.format("[banquest]POfferDishes.triggerDishes@ no guys!|roleId=%d|startTimeStr=%s", new Object[] { Long.valueOf(this.roleId), PBanquestSession.this.startTimeStr }));
/*     */         
/*     */ 
/* 177 */         return new HashMap();
/*     */       }
/* 179 */       Map<Integer, Integer> controllerInfo = offerDishes(homeWorldId, this.guyNum);
/* 180 */       GameServer.logger().info(String.format("[banquest]POfferDishes.triggerDishes@ trigger dishes!@ masterId=%d|worldId=%d|guyNum=%d|controllerInfo=%s|rank=%d|startTimeStr=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(homeWorldId), Integer.valueOf(this.guyNum), controllerInfo.toString(), Integer.valueOf(this.cfg.rank), PBanquestSession.this.startTimeStr }));
/*     */       
/*     */ 
/*     */ 
/* 184 */       return controllerInfo;
/*     */     }
/*     */     
/*     */ 
/*     */     Map<Integer, Integer> offerDishes(long homeWorldId, int needNum)
/*     */     {
/* 190 */       needNum = Math.min(needNum, BanquestManager.getBanqustGuyUpLimit());
/* 191 */       List<Integer> controllers = new ArrayList();
/* 192 */       controllers.addAll(this.cfg.controllerIds);
/* 193 */       if ((controllers.size() == 0) || (needNum <= 0))
/*     */       {
/* 195 */         return new HashMap();
/*     */       }
/* 197 */       Map<Integer, Integer> controllerInfo = getControllerInfo(needNum, controllers);
/* 198 */       if ((controllerInfo == null) || (controllerInfo.size() == 0))
/*     */       {
/* 200 */         return new HashMap();
/*     */       }
/* 202 */       Iterator<Map.Entry<Integer, Integer>> it = controllerInfo.entrySet().iterator();
/* 203 */       while (it.hasNext())
/*     */       {
/* 205 */         Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 206 */         int controllerId = ((Integer)entry.getKey()).intValue();
/* 207 */         int count = ((Integer)entry.getValue()).intValue();
/* 208 */         ControllerInterface.triggerWorldControllerWithMaxSpawnNum(homeWorldId, controllerId, count);
/*     */       }
/* 210 */       return controllerInfo;
/*     */     }
/*     */     
/*     */     private Map<Integer, Integer> getControllerInfo(int needNum, List<Integer> controllers)
/*     */     {
/* 215 */       Map<Integer, Integer> controllerInfo = new HashMap();
/* 216 */       int tempNum = needNum;
/* 217 */       int num = needNum / controllers.size();
/* 218 */       Iterator i$; if (num > 0)
/*     */       {
/* 220 */         for (i$ = controllers.iterator(); i$.hasNext();) { int controllerId = ((Integer)i$.next()).intValue();
/*     */           
/* 222 */           tempNum -= num;
/* 223 */           addCount(controllerInfo, controllerId, num);
/*     */         }
/*     */       }
/* 226 */       if (tempNum > 0)
/*     */       {
/* 228 */         Collections.shuffle(controllers);
/* 229 */         for (int i = 0; i < tempNum; i++)
/*     */         {
/* 231 */           addCount(controllerInfo, ((Integer)controllers.get(i)).intValue(), 1);
/*     */         }
/*     */       }
/* 234 */       return controllerInfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     Map<Integer, Integer> trrigerController(long homeWorldId, int needNum)
/*     */     {
/* 241 */       needNum = Math.min(needNum, BanquestManager.getBanqustGuyUpLimit());
/* 242 */       List<Integer> controllers = new ArrayList(this.cfg.controllerIds);
/* 243 */       if ((controllers.size() == 0) || (needNum <= 0))
/*     */       {
/* 245 */         return new HashMap();
/*     */       }
/* 247 */       Map<Integer, Integer> controllerInfo = new HashMap();
/* 248 */       Collections.shuffle(controllers);
/*     */       
/* 250 */       int count = needNum / controllers.size();
/* 251 */       int remainder = needNum % controllers.size();
/*     */       
/* 253 */       for (int i = 0; i < controllers.size(); i++)
/*     */       {
/* 255 */         if (i >= needNum) {
/*     */           break;
/*     */         }
/*     */         
/* 259 */         int triggerCount = getTriggerCount(i, remainder, count);
/* 260 */         if (triggerCount > 0)
/*     */         {
/*     */ 
/*     */ 
/* 264 */           ControllerInterface.triggerWorldControllerWithMaxSpawnNum(homeWorldId, ((Integer)controllers.get(i)).intValue(), triggerCount);
/* 265 */           addCount(controllerInfo, ((Integer)controllers.get(i)).intValue(), triggerCount);
/*     */         } }
/* 267 */       return controllerInfo;
/*     */     }
/*     */     
/*     */     int getTriggerCount(int index, int remainder, int count)
/*     */     {
/* 272 */       if (remainder <= 0)
/*     */       {
/* 274 */         return count;
/*     */       }
/* 276 */       if (index >= remainder)
/*     */       {
/* 278 */         return count;
/*     */       }
/* 280 */       return count + 1;
/*     */     }
/*     */     
/*     */     void addCount(Map<Integer, Integer> controllerInfo, int controllerId, int num)
/*     */     {
/* 285 */       Integer orgNum = (Integer)controllerInfo.get(Integer.valueOf(controllerId));
/* 286 */       if (orgNum == null)
/*     */       {
/* 288 */         orgNum = new Integer(0);
/*     */       }
/* 290 */       controllerInfo.put(Integer.valueOf(controllerId), Integer.valueOf(orgNum.intValue() + num));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private boolean init()
/*     */     {
/* 302 */       this.roleId = PBanquestSession.this.getOwerId();
/* 303 */       this.cfg = BanquestManager.getSTBRankCalCfgBy(this.roleId);
/*     */       
/* 305 */       this.guyNum = BanquestManager.getBanquestGuyNum(this.roleId);
/* 306 */       this.fengshuiValue = HomelandInterface.getFengshui(this.roleId);
/* 307 */       if (this.cfg != null)
/*     */       {
/* 309 */         return true;
/*     */       }
/* 311 */       GameServer.logger().error(String.format("[banquest]POfferDishes.processImp@ STBRankCalCfg is null!|roleId=%d|startTimeStr=%s", new Object[] { Long.valueOf(this.roleId), PBanquestSession.this.startTimeStr }));
/*     */       
/*     */ 
/* 314 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\banquest\main\PBanquestSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */