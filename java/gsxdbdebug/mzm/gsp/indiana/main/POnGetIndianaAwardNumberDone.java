/*     */ package mzm.gsp.indiana.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.grc.event.GetIndianaAwardNumberDoneArg;
/*     */ import mzm.gsp.indiana.confbean.SIndianaAwardInfo;
/*     */ import mzm.gsp.indiana.confbean.SIndianaCfg;
/*     */ import mzm.gsp.indiana.confbean.SIndianaTurnInfo;
/*     */ import mzm.gsp.util.TaskOneByOne;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.IndianaAwardInfo;
/*     */ import xbean.IndianaAwardRoleInfo;
/*     */ import xbean.IndianaInfo;
/*     */ import xbean.IndianaTurnInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Indiana_infos;
/*     */ 
/*     */ public class POnGetIndianaAwardNumberDone extends mzm.gsp.grc.event.GetIndianaAwardNumberDoneProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  29 */     SIndianaCfg cfg = SIndianaCfg.get(((GetIndianaAwardNumberDoneArg)this.arg).getActivityCfgid());
/*  30 */     if (cfg == null)
/*     */     {
/*     */ 
/*  33 */       onFail(-3, null);
/*  34 */       return false;
/*     */     }
/*  36 */     SIndianaTurnInfo turnInfo = (SIndianaTurnInfo)cfg.turn_infos.get(Integer.valueOf(((GetIndianaAwardNumberDoneArg)this.arg).getTurn()));
/*  37 */     if (turnInfo == null)
/*     */     {
/*     */ 
/*  40 */       onFail(-3, null);
/*  41 */       return false;
/*     */     }
/*  43 */     SIndianaAwardInfo awardInfo = (SIndianaAwardInfo)turnInfo.award_infos.get(Integer.valueOf(((GetIndianaAwardNumberDoneArg)this.arg).getSortid()));
/*  44 */     if (awardInfo == null)
/*     */     {
/*     */ 
/*  47 */       onFail(-3, null);
/*  48 */       return false;
/*     */     }
/*  50 */     if (!((GetIndianaAwardNumberDoneArg)this.arg).isSucceed())
/*     */     {
/*     */ 
/*  53 */       GameServer.logger().info(String.format("[indiana]POnGetIndianaAwardNumberDone.processImp@get indiana award number done process success, get fail|activity_cfg_id=%d|turn=%d|sortid=%d|retcode=%d", new Object[] { Integer.valueOf(((GetIndianaAwardNumberDoneArg)this.arg).getActivityCfgid()), Integer.valueOf(((GetIndianaAwardNumberDoneArg)this.arg).getTurn()), Integer.valueOf(((GetIndianaAwardNumberDoneArg)this.arg).getSortid()), Integer.valueOf(((GetIndianaAwardNumberDoneArg)this.arg).getRetCode()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  58 */       new GetAwardNumberSession(IndianaManager.GRC_MIN_DELAY_IN_SECOND + xdb.Xdb.random().nextInt(IndianaManager.GRC_MAX_DELAY_IN_SECOND - IndianaManager.GRC_MIN_DELAY_IN_SECOND), ((GetIndianaAwardNumberDoneArg)this.arg).getActivityCfgid(), ((GetIndianaAwardNumberDoneArg)this.arg).getTurn(), ((GetIndianaAwardNumberDoneArg)this.arg).getSortid());
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(((GetIndianaAwardNumberDoneArg)this.arg).getActivityCfgid());
/*  68 */     lock(Indiana_infos.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(globalActivityCfgid) }));
/*  69 */     IndianaInfo xIndianaInfo = Indiana_infos.get(Long.valueOf(globalActivityCfgid));
/*  70 */     if (xIndianaInfo == null)
/*     */     {
/*  72 */       xIndianaInfo = Pod.newIndianaInfo();
/*  73 */       Indiana_infos.insert(Long.valueOf(globalActivityCfgid), xIndianaInfo);
/*     */     }
/*  75 */     IndianaTurnInfo xIndianaTurnInfo = (IndianaTurnInfo)xIndianaInfo.getTurn_infos().get(Integer.valueOf(((GetIndianaAwardNumberDoneArg)this.arg).getTurn()));
/*  76 */     if (xIndianaTurnInfo == null)
/*     */     {
/*  78 */       xIndianaTurnInfo = Pod.newIndianaTurnInfo();
/*  79 */       xIndianaInfo.getTurn_infos().put(Integer.valueOf(((GetIndianaAwardNumberDoneArg)this.arg).getTurn()), xIndianaTurnInfo);
/*     */     }
/*  81 */     IndianaAwardInfo xIndianaAwardInfo = (IndianaAwardInfo)xIndianaTurnInfo.getAward_infos().get(Integer.valueOf(((GetIndianaAwardNumberDoneArg)this.arg).getSortid()));
/*  82 */     if (xIndianaAwardInfo == null)
/*     */     {
/*  84 */       xIndianaAwardInfo = Pod.newIndianaAwardInfo();
/*  85 */       xIndianaTurnInfo.getAward_infos().put(Integer.valueOf(((GetIndianaAwardNumberDoneArg)this.arg).getSortid()), xIndianaAwardInfo);
/*     */     }
/*  87 */     if (xIndianaAwardInfo.getGot_award_number())
/*     */     {
/*     */ 
/*  90 */       onFail(-6, null);
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     OctetsStream result = OctetsStream.wrap(((GetIndianaAwardNumberDoneArg)this.arg).getResult());
/*  95 */     List<Integer> awardNumbers = new java.util.ArrayList();
/*  96 */     Map<Integer, Long> awardNumberInfo = new HashMap();
/*  97 */     parseGrcResult(result, awardNumbers, awardNumberInfo);
/*     */     
/*  99 */     xIndianaAwardInfo.setGot_award_number(true);
/* 100 */     for (Iterator i$ = awardNumbers.iterator(); i$.hasNext();) { int number = ((Integer)i$.next()).intValue();
/*     */       
/* 102 */       IndianaAwardRoleInfo xIndianaAwardRoleInfo = (IndianaAwardRoleInfo)xIndianaAwardInfo.getAward_number_infos().get(Integer.valueOf(number));
/* 103 */       if (xIndianaAwardRoleInfo == null)
/*     */       {
/*     */ 
/*     */ 
/* 107 */         Long roleid = (Long)awardNumberInfo.get(Integer.valueOf(number));
/* 108 */         xIndianaAwardRoleInfo = Pod.newIndianaAwardRoleInfo();
/* 109 */         if (roleid != null)
/*     */         {
/* 111 */           xIndianaAwardRoleInfo.setRoleid(roleid.longValue());
/*     */         }
/* 113 */         xIndianaAwardInfo.getAward_number_infos().put(Integer.valueOf(number), xIndianaAwardRoleInfo);
/*     */       }
/*     */     }
/* 116 */     boolean needBrd = false;
/* 117 */     for (Map.Entry<Integer, IndianaAwardRoleInfo> entry : xIndianaAwardInfo.getAward_number_infos().entrySet())
/*     */     {
/* 119 */       int number = ((Integer)entry.getKey()).intValue();
/* 120 */       IndianaAwardRoleInfo xIndianaAwardRoleInfo = (IndianaAwardRoleInfo)entry.getValue();
/* 121 */       if (xIndianaAwardRoleInfo.getAward_state() == 0)
/*     */       {
/* 123 */         if (xIndianaAwardRoleInfo.getRoleid() > 0L)
/*     */         {
/* 125 */           if (GameServerInfoManager.isRoleInOwnServer(xIndianaAwardRoleInfo.getRoleid()))
/*     */           {
/* 127 */             IndianaOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(((GetIndianaAwardNumberDoneArg)this.arg).getActivityCfgid())).add(new PSendAwardAndBulletin(xIndianaAwardRoleInfo.getRoleid(), ((GetIndianaAwardNumberDoneArg)this.arg).getActivityCfgid(), ((GetIndianaAwardNumberDoneArg)this.arg).getTurn(), ((GetIndianaAwardNumberDoneArg)this.arg).getSortid(), number));
/*     */             
/*     */ 
/* 130 */             needBrd = true;
/*     */           }
/*     */           else
/*     */           {
/* 134 */             xIndianaAwardRoleInfo.setAward_state(2);
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 139 */           String xNumberKey = IndianaManager.getXNumberKey(((GetIndianaAwardNumberDoneArg)this.arg).getActivityCfgid(), ((GetIndianaAwardNumberDoneArg)this.arg).getTurn(), ((GetIndianaAwardNumberDoneArg)this.arg).getSortid(), number);
/*     */           
/* 141 */           Long roleid = xtable.Indiana_number_infos.select(xNumberKey);
/* 142 */           if (roleid != null)
/*     */           {
/* 144 */             xIndianaAwardRoleInfo.setRoleid(roleid.longValue());
/* 145 */             IndianaOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(((GetIndianaAwardNumberDoneArg)this.arg).getActivityCfgid())).add(new PSendAwardAndBulletin(xIndianaAwardRoleInfo.getRoleid(), ((GetIndianaAwardNumberDoneArg)this.arg).getActivityCfgid(), ((GetIndianaAwardNumberDoneArg)this.arg).getTurn(), ((GetIndianaAwardNumberDoneArg)this.arg).getSortid(), number));
/*     */             
/*     */ 
/* 148 */             needBrd = true;
/*     */           }
/*     */           else
/*     */           {
/* 152 */             xIndianaAwardRoleInfo.setAward_state(2);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 157 */     if (needBrd)
/*     */     {
/* 159 */       IndianaOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(((GetIndianaAwardNumberDoneArg)this.arg).getActivityCfgid())).add(new PBrdAwardRoleInfo(((GetIndianaAwardNumberDoneArg)this.arg).getActivityCfgid(), ((GetIndianaAwardNumberDoneArg)this.arg).getTurn(), ((GetIndianaAwardNumberDoneArg)this.arg).getSortid()));
/*     */     }
/*     */     
/*     */ 
/* 163 */     GameServer.logger().info(String.format("[indiana]POnGetIndianaAwardNumberDone.processImp@get indiana award number done process success, get success|activity_cfg_id=%d|turn=%d|sortid=%d", new Object[] { Integer.valueOf(((GetIndianaAwardNumberDoneArg)this.arg).getActivityCfgid()), Integer.valueOf(((GetIndianaAwardNumberDoneArg)this.arg).getTurn()), Integer.valueOf(((GetIndianaAwardNumberDoneArg)this.arg).getSortid()) }));
/*     */     
/*     */ 
/*     */ 
/* 167 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 172 */     StringBuilder sb = new StringBuilder();
/* 173 */     sb.append(String.format("[indiana]POnGetIndianaAwardNumberDone.processImp@get indiana award number done process fail|activity_cfg_id=%d|turn=%d|sortid=%d|res=%d", new Object[] { Integer.valueOf(((GetIndianaAwardNumberDoneArg)this.arg).getActivityCfgid()), Integer.valueOf(((GetIndianaAwardNumberDoneArg)this.arg).getTurn()), Integer.valueOf(((GetIndianaAwardNumberDoneArg)this.arg).getSortid()), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 176 */     if (extraInfo != null)
/*     */     {
/* 178 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 180 */         sb.append("|").append((String)entry.getKey());
/* 181 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 184 */     GameServer.logger().info(sb.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   private void parseGrcResult(OctetsStream os, List<Integer> awardNumbers, Map<Integer, Long> awardNumberInfo)
/*     */   {
/*     */     try
/*     */     {
/* 192 */       for (int size = os.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 194 */         awardNumbers.add(Integer.valueOf(os.unmarshal_int()));
/*     */       }
/* 196 */       for (int size = os.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 198 */         awardNumberInfo.put(Integer.valueOf(os.unmarshal_int()), Long.valueOf(os.unmarshal_long()));
/*     */       }
/*     */     }
/*     */     catch (MarshalException e) {}
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\main\POnGetIndianaAwardNumberDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */