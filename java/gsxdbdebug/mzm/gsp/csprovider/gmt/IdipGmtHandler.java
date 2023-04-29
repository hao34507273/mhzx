/*     */ package mzm.gsp.csprovider.gmt;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import jsonio.JsonStream;
/*     */ import mzm.gsp.csprovider.gmt.idip.AqDoBanAddFriendHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.AqDoBanAssignPlayHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.AqDoBanJoinRankHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.AqDoBanUsrHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.AqDoClearSayHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.AqDoInitAccountHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.AqDoMaskChatHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.AqDoRelievePunishHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.AqDoRoleListDataHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.AqDoSendMsgHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.AqDoSetUsrInfoHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.AqDoUpdateCashHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.AqDoUpdateMoneyHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.AqDoUpdateOtherCashHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.AqDoZeroProfitHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.AqQueryUsrInfoHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.ChannelSignLimitFunHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.DeleteGlobalMailHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.DeleteMarqueeHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.DeleteNoticeHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.DeleteRoleMailHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.DoActiveUserHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.DoDelItemHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.DoSendItemBySystemMailHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.DoSendItemHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.DoUpdateCashHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.DoUpdateChivalrousHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.DoUpdateCompetitivePointHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.DoUpdateExpHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.DoUpdateGangContributionHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.DoUpdateGoldIngotHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.DoUpdateHisContributionHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.DoUpdateMoneyHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.DoUpdateReputationHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.DoUpdateSilverHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.DoUpdateVitalityHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.GeneralCmdHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.MailSendWholeGiftHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.QueryFunctionSwitchHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.QueryGlobalMailHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.QueryGuildInfoHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.QueryGuildMemberInfoHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.QueryMarqueeHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.QueryNoticeHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.QueryOwnXianLvHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.QueryPetInfoHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.QueryRoleActivityParticipationHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.QueryRoleInfoHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.QueryRoleListInfoHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.QueryRoleMailHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.QueryRoleSocialHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.QuerySXianLvNumHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.QueryUsrInfoHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.Response;
/*     */ import mzm.gsp.csprovider.gmt.idip.SendMarqueeHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.SendNoticeHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.SysFunSwitchHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.Text;
/*     */ import mzm.gsp.csprovider.gmt.idip.UnbanUserHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.UpdateMarqueeHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.UpdateNoticeHandler;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ public class IdipGmtHandler
/*     */   implements GmtHandler
/*     */ {
/*  79 */   private static final Map<Integer, IdipHandler> handlers = new HashMap();
/*     */   
/*     */   static
/*     */   {
/*  83 */     handlers.put(Integer.valueOf(1), new AqDoBanAddFriendHandler());
/*  84 */     handlers.put(Integer.valueOf(2), new AqDoBanJoinRankHandler());
/*  85 */     handlers.put(Integer.valueOf(3), new AqDoBanUsrHandler());
/*  86 */     handlers.put(Integer.valueOf(4), new AqDoClearSayHandler());
/*  87 */     handlers.put(Integer.valueOf(5), new AqDoInitAccountHandler());
/*  88 */     handlers.put(Integer.valueOf(6), new AqDoMaskChatHandler());
/*  89 */     handlers.put(Integer.valueOf(7), new AqDoRelievePunishHandler());
/*  90 */     handlers.put(Integer.valueOf(8), new AqDoRoleListDataHandler());
/*  91 */     handlers.put(Integer.valueOf(9), new UnbanUserHandler());
/*  92 */     handlers.put(Integer.valueOf(10), new AqDoSendMsgHandler());
/*  93 */     handlers.put(Integer.valueOf(11), new AqDoSetUsrInfoHandler());
/*  94 */     handlers.put(Integer.valueOf(12), new AqDoUpdateCashHandler());
/*  95 */     handlers.put(Integer.valueOf(13), new AqDoUpdateMoneyHandler());
/*  96 */     handlers.put(Integer.valueOf(14), new AqDoUpdateOtherCashHandler());
/*  97 */     handlers.put(Integer.valueOf(15), new AqDoZeroProfitHandler());
/*  98 */     handlers.put(Integer.valueOf(16), new AqQueryUsrInfoHandler());
/*  99 */     handlers.put(Integer.valueOf(17), new AqDoBanAssignPlayHandler());
/* 100 */     handlers.put(Integer.valueOf(18), new ChannelSignLimitFunHandler());
/* 101 */     handlers.put(Integer.valueOf(19), new SendMarqueeHandler());
/* 102 */     handlers.put(Integer.valueOf(20), new DeleteMarqueeHandler());
/* 103 */     handlers.put(Integer.valueOf(21), new QueryMarqueeHandler());
/* 104 */     handlers.put(Integer.valueOf(22), new UpdateMarqueeHandler());
/* 105 */     handlers.put(Integer.valueOf(23), new DoSendItemHandler());
/* 106 */     handlers.put(Integer.valueOf(24), new DoDelItemHandler());
/* 107 */     handlers.put(Integer.valueOf(25), new DoActiveUserHandler());
/* 108 */     handlers.put(Integer.valueOf(26), new DoSendItemBySystemMailHandler());
/* 109 */     handlers.put(Integer.valueOf(27), new DoUpdateCashHandler());
/* 110 */     handlers.put(Integer.valueOf(28), new DoUpdateChivalrousHandler());
/* 111 */     handlers.put(Integer.valueOf(29), new DoUpdateCompetitivePointHandler());
/* 112 */     handlers.put(Integer.valueOf(30), new DoUpdateExpHandler());
/* 113 */     handlers.put(Integer.valueOf(31), new DoUpdateGangContributionHandler());
/* 114 */     handlers.put(Integer.valueOf(32), new DoUpdateGoldIngotHandler());
/* 115 */     handlers.put(Integer.valueOf(33), new DoUpdateHisContributionHandler());
/* 116 */     handlers.put(Integer.valueOf(34), new DoUpdateMoneyHandler());
/* 117 */     handlers.put(Integer.valueOf(35), new DoUpdateReputationHandler());
/* 118 */     handlers.put(Integer.valueOf(36), new DoUpdateSilverHandler());
/* 119 */     handlers.put(Integer.valueOf(37), new DoUpdateVitalityHandler());
/* 120 */     handlers.put(Integer.valueOf(38), new GeneralCmdHandler());
/* 121 */     handlers.put(Integer.valueOf(39), new MailSendWholeGiftHandler());
/* 122 */     handlers.put(Integer.valueOf(40), new QueryGuildInfoHandler());
/* 123 */     handlers.put(Integer.valueOf(41), new QueryGuildMemberInfoHandler());
/* 124 */     handlers.put(Integer.valueOf(42), new QueryOwnXianLvHandler());
/* 125 */     handlers.put(Integer.valueOf(43), new QueryPetInfoHandler());
/* 126 */     handlers.put(Integer.valueOf(44), new QueryRoleActivityParticipationHandler());
/* 127 */     handlers.put(Integer.valueOf(45), new QueryRoleInfoHandler());
/* 128 */     handlers.put(Integer.valueOf(46), new QueryRoleListInfoHandler());
/* 129 */     handlers.put(Integer.valueOf(47), new QueryRoleSocialHandler());
/* 130 */     handlers.put(Integer.valueOf(48), new QuerySXianLvNumHandler());
/* 131 */     handlers.put(Integer.valueOf(49), new QueryUsrInfoHandler());
/* 132 */     handlers.put(Integer.valueOf(50), new SysFunSwitchHandler());
/* 133 */     handlers.put(Integer.valueOf(51), new SendNoticeHandler());
/* 134 */     handlers.put(Integer.valueOf(52), new UpdateNoticeHandler());
/* 135 */     handlers.put(Integer.valueOf(53), new DeleteNoticeHandler());
/* 136 */     handlers.put(Integer.valueOf(54), new QueryNoticeHandler());
/*     */     
/* 138 */     handlers.put(Integer.valueOf(55), new QueryFunctionSwitchHandler());
/* 139 */     handlers.put(Integer.valueOf(56), new QueryRoleMailHandler());
/* 140 */     handlers.put(Integer.valueOf(57), new DeleteRoleMailHandler());
/* 141 */     handlers.put(Integer.valueOf(58), new QueryGlobalMailHandler());
/* 142 */     handlers.put(Integer.valueOf(59), new DeleteGlobalMailHandler());
/*     */   }
/*     */   
/*     */ 
/*     */   public void handle(JSONObject jsonObj, DataBetweenCspAndGame_Re rsp)
/*     */     throws Exception
/*     */   {
/* 149 */     JsonStream js = new JsonStream(jsonObj);
/* 150 */     Text text = new Text();
/* 151 */     text.unmarshal(js);
/*     */     
/* 153 */     int operType = Integer.parseInt(text.opertype);
/* 154 */     IdipHandler idipHandler = (IdipHandler)handlers.get(Integer.valueOf(operType));
/* 155 */     if (idipHandler == null)
/*     */     {
/* 157 */       rsp.retcode = Retcode.IDIP_HANDLER_NOT_EXIST.value;
/* 158 */       Response response = new Response();
/* 159 */       response.retcode = rsp.retcode;
/* 160 */       response.msg = "operate not supprt";
/* 161 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/* 162 */       return;
/*     */     }
/*     */     
/* 165 */     List<String> params = new ArrayList();
/* 166 */     params.add(text.oper_params1);
/* 167 */     params.add(text.oper_params2);
/* 168 */     params.add(text.oper_params3);
/* 169 */     params.add(text.oper_params4);
/* 170 */     params.add(text.oper_params5);
/* 171 */     params.add(text.oper_params6);
/* 172 */     params.add(text.oper_params7);
/* 173 */     params.add(text.oper_params8);
/* 174 */     params.add(text.oper_params9);
/* 175 */     params.add(text.oper_params10);
/* 176 */     params.add(text.oper_params11);
/* 177 */     params.add(text.oper_params12);
/* 178 */     params.add(text.oper_params13);
/* 179 */     params.add(text.oper_params14);
/* 180 */     params.add(text.oper_params15);
/* 181 */     params.add(text.oper_params16);
/* 182 */     params.add(text.oper_params17);
/* 183 */     params.add(text.oper_params18);
/* 184 */     params.add(text.oper_params19);
/* 185 */     params.add(text.oper_params20);
/* 186 */     params.add(text.oper_params21);
/* 187 */     params.add(text.oper_params22);
/* 188 */     params.add(text.oper_params23);
/* 189 */     params.add(text.oper_params24);
/* 190 */     params.add(text.oper_params25);
/* 191 */     idipHandler.execute(params, rsp);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\IdipGmtHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */