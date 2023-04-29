/*     */ package mzm.gsp.indiana.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.grc.event.GetIndianaNumberDoneArg;
/*     */ import mzm.gsp.indiana.SAttendIndianaFail;
/*     */ import mzm.gsp.indiana.SAttendIndianaSuccess;
/*     */ import mzm.gsp.indiana.confbean.SIndianaAwardInfo;
/*     */ import mzm.gsp.indiana.confbean.SIndianaCfg;
/*     */ import mzm.gsp.indiana.confbean.SIndianaConsts;
/*     */ import mzm.gsp.indiana.confbean.SIndianaTurnInfo;
/*     */ import mzm.gsp.indiana.event.RoleAttendIndiana;
/*     */ import mzm.gsp.indiana.event.RoleAttendIndianaArg;
/*     */ import mzm.gsp.item.main.ItemStoreEnum;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.IndianaAwardInfo;
/*     */ import xbean.IndianaInfo;
/*     */ import xbean.IndianaTurnInfo;
/*     */ import xbean.Item;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleIndianaActivityInfo;
/*     */ import xbean.RoleIndianaInfo;
/*     */ import xbean.RoleIndianaNumberInfo;
/*     */ import xbean.RoleIndianaTurnInfo;
/*     */ import xtable.Indiana_infos;
/*     */ import xtable.Indiana_number_infos;
/*     */ 
/*     */ public class POnGetIndianaNumberDone extends mzm.gsp.grc.event.GetIndianaNumberDoneProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  47 */     SIndianaCfg cfg = SIndianaCfg.get(((GetIndianaNumberDoneArg)this.arg).getActivityCfgid());
/*  48 */     if (cfg == null)
/*     */     {
/*     */ 
/*  51 */       onFail(-3, null);
/*  52 */       return false;
/*     */     }
/*  54 */     SIndianaTurnInfo turnInfo = (SIndianaTurnInfo)cfg.turn_infos.get(Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getTurn()));
/*  55 */     if (turnInfo == null)
/*     */     {
/*     */ 
/*  58 */       onFail(-3, null);
/*  59 */       return false;
/*     */     }
/*  61 */     SIndianaAwardInfo awardInfo = (SIndianaAwardInfo)turnInfo.award_infos.get(Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getSortid()));
/*  62 */     if (awardInfo == null)
/*     */     {
/*     */ 
/*  65 */       onFail(-3, null);
/*  66 */       return false;
/*     */     }
/*  68 */     long turnBeginTimestamp = IndianaManager.getTurnBeginTimestamp(((GetIndianaNumberDoneArg)this.arg).getActivityCfgid(), ((GetIndianaNumberDoneArg)this.arg).getTurn());
/*  69 */     long turnEndTimestamp = IndianaManager.getTurnEndTimestamp(((GetIndianaNumberDoneArg)this.arg).getActivityCfgid(), ((GetIndianaNumberDoneArg)this.arg).getTurn());
/*  70 */     if ((turnBeginTimestamp < 0L) || (turnEndTimestamp < 0L))
/*     */     {
/*     */ 
/*  73 */       onFail(-3, null);
/*  74 */       return false;
/*     */     }
/*  76 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(((GetIndianaNumberDoneArg)this.arg).getRoleid());
/*     */     
/*  78 */     lock(xtable.User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  80 */     lock(xtable.Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(((GetIndianaNumberDoneArg)this.arg).getRoleid()) }));
/*     */     
/*  82 */     long globalActivityCfgid = mzm.gsp.GameServerInfoManager.toGlobalId(((GetIndianaNumberDoneArg)this.arg).getActivityCfgid());
/*  83 */     lock(Indiana_infos.getTable(), Arrays.asList(new Long[] { Long.valueOf(globalActivityCfgid) }));
/*  84 */     RoleIndianaInfo xRoleIndianaInfo = xtable.Role_indiana_infos.get(Long.valueOf(((GetIndianaNumberDoneArg)this.arg).getRoleid()));
/*  85 */     if (xRoleIndianaInfo == null)
/*     */     {
/*     */ 
/*  88 */       onFail(-5, null);
/*  89 */       return false;
/*     */     }
/*  91 */     RoleIndianaActivityInfo xRoleIndianaActivityInfo = (RoleIndianaActivityInfo)xRoleIndianaInfo.getActivity_infos().get(Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getActivityCfgid()));
/*     */     
/*  93 */     if (xRoleIndianaActivityInfo == null)
/*     */     {
/*     */ 
/*  96 */       onFail(-5, null);
/*  97 */       return false;
/*     */     }
/*  99 */     RoleIndianaTurnInfo xRoleIndianaTurnInfo = (RoleIndianaTurnInfo)xRoleIndianaActivityInfo.getTurn_infos().get(Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getTurn()));
/* 100 */     if (xRoleIndianaTurnInfo == null)
/*     */     {
/*     */ 
/* 103 */       onFail(-5, null);
/* 104 */       return false;
/*     */     }
/* 106 */     RoleIndianaNumberInfo xRoleIndianaNumberInfo = (RoleIndianaNumberInfo)xRoleIndianaTurnInfo.getNumber_infos().get(Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getSortid()));
/*     */     
/* 108 */     if (xRoleIndianaNumberInfo == null)
/*     */     {
/*     */ 
/* 111 */       onFail(-5, null);
/* 112 */       return false;
/*     */     }
/* 114 */     if (((RoleIndianaNumberInfo)xRoleIndianaTurnInfo.getNumber_infos().get(Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getSortid()))).getNumber() > 0)
/*     */     {
/*     */ 
/* 117 */       onFail(3, null);
/* 118 */       return false;
/*     */     }
/* 120 */     String formatTurnBeginTimestamp = DateTimeUtils.formatTimestamp(turnBeginTimestamp);
/* 121 */     if (!((GetIndianaNumberDoneArg)this.arg).isSucceed())
/*     */     {
/* 123 */       xRoleIndianaTurnInfo.getNumber_infos().remove(Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getSortid()));
/*     */       
/* 125 */       MailAttachment mailAttachment = new MailAttachment();
/* 126 */       switch (awardInfo.cost_money_type)
/*     */       {
/*     */       case 1: 
/* 129 */         mailAttachment.setYuanBao(awardInfo.cost_money_num);
/* 130 */         break;
/*     */       case 2: 
/* 132 */         mailAttachment.setGold(awardInfo.cost_money_num);
/* 133 */         break;
/*     */       case 3: 
/* 135 */         mailAttachment.setSilver(awardInfo.cost_money_num);
/*     */       }
/*     */       
/* 138 */       if (!MailInterface.synBuildAndSendMail(((GetIndianaNumberDoneArg)this.arg).getRoleid(), SIndianaConsts.getInstance().ATTEND_FAIL_MAIL_CFG_ID, new ArrayList(), Arrays.asList(new String[] { formatTurnBeginTimestamp.substring(0, 4), formatTurnBeginTimestamp.substring(4, 6), formatTurnBeginTimestamp.substring(6, 8), String.valueOf(turnInfo.diaplay_turn), String.valueOf(IndianaManager.getFixAwardItemCfgid(((GetIndianaNumberDoneArg)this.arg).getRoleid(), awardInfo.fix_award_id)), String.valueOf(0) }), mailAttachment, new TLogArg(LogReason.ATTEND_INDIANA_FAIL_MAIL, ((GetIndianaNumberDoneArg)this.arg).getActivityCfgid())).isOK())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 149 */         onFail(9, null);
/* 150 */         return false;
/*     */       }
/*     */       
/* 153 */       SAttendIndianaFail protocol = new SAttendIndianaFail();
/* 154 */       protocol.res = (((GetIndianaNumberDoneArg)this.arg).isTimeout() ? 11 : 12);
/* 155 */       OnlineManager.getInstance().send(((GetIndianaNumberDoneArg)this.arg).getRoleid(), protocol);
/*     */       
/* 157 */       GameServer.logger().info(String.format("[indiana]POnGetIndianaNumberDone.processImp@get indiana number done process success, attend fail|roleid=%d|activity_cfg_id=%d|turn=%d|sortid=%d|retcode=%d", new Object[] { Long.valueOf(((GetIndianaNumberDoneArg)this.arg).getRoleid()), Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getActivityCfgid()), Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getTurn()), Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getSortid()), Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getRetCode()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 162 */       IndianaTLogManager.addAttendTLog(((GetIndianaNumberDoneArg)this.arg).getRoleid(), ((GetIndianaNumberDoneArg)this.arg).getActivityCfgid(), ((GetIndianaNumberDoneArg)this.arg).getTurn(), ((GetIndianaNumberDoneArg)this.arg).getSortid(), 0);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 167 */       OctetsStream result = OctetsStream.wrap(((GetIndianaNumberDoneArg)this.arg).getResult());
/* 168 */       int number = result.unmarshal_int();
/* 169 */       int attendNum = result.unmarshal_int();
/*     */       
/* 171 */       xRoleIndianaNumberInfo.setNumber(number);
/*     */       
/* 173 */       IndianaInfo xIndianaInfo = Indiana_infos.get(Long.valueOf(globalActivityCfgid));
/* 174 */       if (xIndianaInfo == null)
/*     */       {
/* 176 */         xIndianaInfo = Pod.newIndianaInfo();
/* 177 */         Indiana_infos.insert(Long.valueOf(globalActivityCfgid), xIndianaInfo);
/*     */       }
/* 179 */       IndianaTurnInfo xIndianaTurnInfo = (IndianaTurnInfo)xIndianaInfo.getTurn_infos().get(Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getTurn()));
/* 180 */       if (xIndianaTurnInfo == null)
/*     */       {
/* 182 */         xIndianaTurnInfo = Pod.newIndianaTurnInfo();
/* 183 */         xIndianaInfo.getTurn_infos().put(Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getTurn()), xIndianaTurnInfo);
/*     */       }
/* 185 */       IndianaAwardInfo xIndianaAwardInfo = (IndianaAwardInfo)xIndianaTurnInfo.getAward_infos().get(Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getSortid()));
/* 186 */       if (xIndianaAwardInfo == null)
/*     */       {
/* 188 */         xIndianaAwardInfo = Pod.newIndianaAwardInfo();
/* 189 */         xIndianaTurnInfo.getAward_infos().put(Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getSortid()), xIndianaAwardInfo);
/*     */       }
/* 191 */       xIndianaAwardInfo.setAttend_role_num(attendNum);
/* 192 */       xIndianaAwardInfo.setAttend_role_num_timestamp(DateTimeUtils.getCurrTimeInMillis());
/*     */       
/*     */ 
/* 195 */       String xNumberKey = IndianaManager.getXNumberKey(((GetIndianaNumberDoneArg)this.arg).getActivityCfgid(), ((GetIndianaNumberDoneArg)this.arg).getTurn(), ((GetIndianaNumberDoneArg)this.arg).getSortid(), number);
/*     */       
/* 197 */       Indiana_number_infos.insert(xNumberKey, Long.valueOf(((GetIndianaNumberDoneArg)this.arg).getRoleid()));
/*     */       
/* 199 */       mzm.gsp.award.main.AwardModel awardModel = null;
/* 200 */       if (awardInfo.attend_fix_award_id > 0)
/*     */       {
/* 202 */         awardModel = AwardInterface.getRoleFixAwardModel(awardInfo.attend_fix_award_id, ((GetIndianaNumberDoneArg)this.arg).getRoleid(), new mzm.gsp.award.main.AwardReason(LogReason.ATTEND_INDIANA_AWARD, ((GetIndianaNumberDoneArg)this.arg).getActivityCfgid()));
/*     */       }
/*     */       
/* 205 */       MailAttachment mailAttachment = null;
/* 206 */       if (awardModel != null)
/*     */       {
/* 208 */         mailAttachment = AwardInterface.getMailAttachmentBy(awardModel);
/*     */       }
/*     */       else
/*     */       {
/* 212 */         mailAttachment = new MailAttachment();
/*     */       }
/* 214 */       Map<Integer, Integer> extraMap = new HashMap();
/* 215 */       extraMap.put(Integer.valueOf(ItemStoreEnum.INDIANA_ACTIVITY_CFG_ID.getStoreType()), Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getActivityCfgid()));
/* 216 */       extraMap.put(Integer.valueOf(ItemStoreEnum.INDIANA_ACTIVITY_TURN.getStoreType()), Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getTurn()));
/* 217 */       extraMap.put(Integer.valueOf(ItemStoreEnum.INDIANA_SORT_ID.getStoreType()), Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getSortid()));
/* 218 */       extraMap.put(Integer.valueOf(ItemStoreEnum.INDIANA_NUMBER.getStoreType()), Integer.valueOf(number));
/* 219 */       extraMap.put(Integer.valueOf(ItemStoreEnum.TIME_ITEM_END_TIME.getStoreType()), Integer.valueOf((int)(turnEndTimestamp / 1000L) + SIndianaConsts.getInstance().LOTTERY_ITEM_DISAPPEAR_DELAY_IN_SECOND));
/*     */       
/* 221 */       java.util.List<Item> xItems = mzm.gsp.item.main.ItemInterface.createXItem(cfg.lottery_item_cfg_id, 1, extraMap, false);
/* 222 */       mailAttachment.addXItem(xItems);
/*     */       
/* 224 */       if (!MailInterface.synBuildAndSendMail(((GetIndianaNumberDoneArg)this.arg).getRoleid(), SIndianaConsts.getInstance().ATTEND_SUCCESS_MAIL_CFG_ID, new ArrayList(), Arrays.asList(new String[] { formatTurnBeginTimestamp.substring(0, 4), formatTurnBeginTimestamp.substring(4, 6), formatTurnBeginTimestamp.substring(6, 8), String.valueOf(turnInfo.diaplay_turn), String.valueOf(IndianaManager.getFixAwardItemCfgid(((GetIndianaNumberDoneArg)this.arg).getRoleid(), awardInfo.fix_award_id)), String.valueOf(0) }), mailAttachment, new TLogArg(LogReason.ATTEND_INDIANA_SUCCESS_MAIL, ((GetIndianaNumberDoneArg)this.arg).getActivityCfgid())).isOK())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 235 */         onFail(9, null);
/* 236 */         return false;
/*     */       }
/*     */       
/* 239 */       SAttendIndianaSuccess protocol = new SAttendIndianaSuccess();
/* 240 */       protocol.activity_cfg_id = ((GetIndianaNumberDoneArg)this.arg).getActivityCfgid();
/* 241 */       protocol.turn = ((GetIndianaNumberDoneArg)this.arg).getTurn();
/* 242 */       protocol.sortid = ((GetIndianaNumberDoneArg)this.arg).getSortid();
/* 243 */       protocol.number = number;
/* 244 */       OnlineManager.getInstance().send(((GetIndianaNumberDoneArg)this.arg).getRoleid(), protocol);
/*     */       
/* 246 */       GameServer.logger().info(String.format("[indiana]POnGetIndianaNumberDone.processImp@get indiana number done process success, attend success|roleid=%d|activity_cfg_id=%d|turn=%d|sortid=%d|number=%d|attend_role_num=%d", new Object[] { Long.valueOf(((GetIndianaNumberDoneArg)this.arg).getRoleid()), Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getActivityCfgid()), Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getTurn()), Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getSortid()), Integer.valueOf(number), Integer.valueOf(attendNum) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 251 */       IndianaTLogManager.addAttendTLog(((GetIndianaNumberDoneArg)this.arg).getRoleid(), ((GetIndianaNumberDoneArg)this.arg).getActivityCfgid(), ((GetIndianaNumberDoneArg)this.arg).getTurn(), ((GetIndianaNumberDoneArg)this.arg).getSortid(), number);
/*     */       
/* 253 */       TriggerEventsManger.getInstance().triggerEvent(new RoleAttendIndiana(), new RoleAttendIndianaArg(((GetIndianaNumberDoneArg)this.arg).getRoleid(), ((GetIndianaNumberDoneArg)this.arg).getActivityCfgid(), ((GetIndianaNumberDoneArg)this.arg).getTurn(), ((GetIndianaNumberDoneArg)this.arg).getSortid(), awardInfo.cost_money_type, awardInfo.cost_money_num));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 258 */       if (!mzm.gsp.grc.main.GrcInterface.confirmIndianaNumber(((GetIndianaNumberDoneArg)this.arg).getActivityCfgid(), ((GetIndianaNumberDoneArg)this.arg).getTurn(), ((GetIndianaNumberDoneArg)this.arg).getSortid(), ((GetIndianaNumberDoneArg)this.arg).getRoleid(), number))
/*     */       {
/*     */ 
/* 261 */         GameServer.logger().error(String.format("[indiana]POnGetIndianaNumberDone.processImp@confirm indiana number communication error|roleid=%d|activity_cfg_id=%d|turn=%d|sortid=%d|number=%d", new Object[] { Long.valueOf(((GetIndianaNumberDoneArg)this.arg).getRoleid()), Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getActivityCfgid()), Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getTurn()), Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getSortid()), Integer.valueOf(number) }));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 268 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 273 */     StringBuilder sb = new StringBuilder();
/* 274 */     sb.append(String.format("[indiana]POnGetIndianaNumberDone.processImp@get indiana number done process fail|roleid=%d|activity_cfg_id=%d|turn=%d|sortid=%d|res=%d", new Object[] { Long.valueOf(((GetIndianaNumberDoneArg)this.arg).getRoleid()), Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getActivityCfgid()), Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getTurn()), Integer.valueOf(((GetIndianaNumberDoneArg)this.arg).getSortid()), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 277 */     if (extraInfo != null)
/*     */     {
/* 279 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 281 */         sb.append("|").append((String)entry.getKey());
/* 282 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 285 */     GameServer.logger().info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\main\POnGetIndianaNumberDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */