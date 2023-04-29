/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import idip.DoSendItemRsp;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.ItemOperateResult.ItemResultEnum;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class DoSendItemHandler
/*     */   implements IdipHandler
/*     */ {
/*  25 */   private static final Map<Integer, Integer> bagTypeMap = new HashMap();
/*     */   
/*     */   static {
/*  28 */     int i = 1;
/*  29 */     bagTypeMap.put(Integer.valueOf(i++), Integer.valueOf(340600000));
/*  30 */     bagTypeMap.put(Integer.valueOf(i++), Integer.valueOf(340600001));
/*  31 */     for (Integer storageid : ItemInterface.getAllStorageids())
/*     */     {
/*  33 */       bagTypeMap.put(Integer.valueOf(i++), storageid);
/*     */     }
/*     */   }
/*     */   
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp)
/*     */     throws Exception
/*     */   {
/*  40 */     String userid = (String)params.get(0);
/*  41 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*  42 */     int type = Integer.valueOf((String)params.get(2)).intValue();
/*  43 */     int addItemId = Integer.valueOf((String)params.get(3)).intValue();
/*  44 */     int addItemNum = Integer.valueOf((String)params.get(4)).intValue();
/*     */     
/*  46 */     xbean.User xUser = xtable.User.get(userid);
/*  47 */     if (null == xUser)
/*     */     {
/*  49 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/*  50 */       rsp.retcode = retcode;
/*  51 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/*  52 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  54 */       GameServer.logger().error(String.format("[gmt]DoSendItemHandler.execute@query userid empty|userid=%s|roleid=%d|bag_type=%d|item_id=%d|item_num=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(addItemId), Integer.valueOf(addItemNum) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  59 */       return;
/*     */     }
/*     */     
/*  62 */     if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*     */     {
/*  64 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  65 */       rsp.retcode = retcode;
/*  66 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  67 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  69 */       GameServer.logger().error(String.format("[gmt]DoSendItemHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|bag_type=%d|item_id=%d|item_num=%d", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(addItemId), Integer.valueOf(addItemNum) }));
/*     */       
/*     */ 
/*     */ 
/*  73 */       return;
/*     */     }
/*     */     
/*     */ 
/*  77 */     if (addItemNum <= 0)
/*     */     {
/*  79 */       int retcode = Retcode.SEND_ITEM_NUM_LESS_THAN_ZERO.value;
/*  80 */       rsp.retcode = retcode;
/*  81 */       Response response = IdipGmtUtil.getResponse(retcode, "send item num must > 0");
/*  82 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  84 */       GameServer.logger().error(String.format("[gmt]DoSendItemHandler.execute@send item num must > 0|userid=%s|roleid=%d|bag_type=%d|item_id=%d|item_num=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(addItemId), Integer.valueOf(addItemNum) }));
/*     */       
/*     */ 
/*     */ 
/*  88 */       return;
/*     */     }
/*     */     
/*  91 */     Integer bagType = (Integer)bagTypeMap.get(Integer.valueOf(type));
/*  92 */     if (bagType == null)
/*     */     {
/*  94 */       int retcode = Retcode.SEND_ITEM_BAG_TYPE_NOT_EXIST.value;
/*  95 */       rsp.retcode = retcode;
/*  96 */       Response response = IdipGmtUtil.getResponse(retcode, "bag type not exist");
/*  97 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  99 */       GameServer.logger().error(String.format("[gmt]DoSendItemHandler.execute@bag type not exist|userid=%s|roleid=%d|bag_type=%d|item_id=%d|item_num=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(addItemId), Integer.valueOf(addItemNum) }));
/*     */       
/*     */ 
/*     */ 
/* 103 */       return;
/*     */     }
/*     */     
/*     */ 
/* 107 */     if (bagType.intValue() == 340600001)
/*     */     {
/* 109 */       int retcode = Retcode.SEND_ITEM_EQUIP_BAG_INVALID.value;
/* 110 */       rsp.retcode = retcode;
/* 111 */       Response response = IdipGmtUtil.getResponse(retcode, "equip bag can not add item");
/* 112 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 114 */       GameServer.logger().error(String.format("[gmt]DoSendItemHandler.execute@equip bag not allow send item|userid=%s|roleid=%d|bag_type=%d|item_id=%d|item_num=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(addItemId), Integer.valueOf(addItemNum) }));
/*     */       
/*     */ 
/*     */ 
/* 118 */       return;
/*     */     }
/*     */     
/*     */ 
/* 122 */     boolean isBagEnable = ItemInterface.isBagEnable(roleid, bagType.intValue(), true);
/* 123 */     if (!isBagEnable)
/*     */     {
/* 125 */       int retcode = Retcode.SEND_ITEM_ERROR_BAG_STORAGE_NOT_OPEN.value;
/* 126 */       rsp.retcode = retcode;
/* 127 */       Response response = IdipGmtUtil.getResponse(retcode, "storage not open");
/* 128 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 130 */       GameServer.logger().error(String.format("[gmt]DoSendItemHandler.execute@storage not open|userid=%s|roleid=%d|bag_type=%d|item_id=%d|item_num=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(addItemId), Integer.valueOf(addItemNum) }));
/*     */       
/*     */ 
/*     */ 
/* 134 */       return;
/*     */     }
/*     */     
/* 137 */     SItemCfg itemCfg = ItemInterface.getSItemCfg(addItemId);
/* 138 */     if (itemCfg == null)
/*     */     {
/* 140 */       int retcode = Retcode.SEND_ITEM_ERROR_ITEM_CFG.value;
/* 141 */       rsp.retcode = retcode;
/* 142 */       Response response = IdipGmtUtil.getResponse(retcode, "send item not exist");
/* 143 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 145 */       GameServer.logger().error(String.format("[gmt]DoSendItemHandler.execute@send item not exist in config|userid=%s|roleid=%d|bag_type=%d|item_id=%d|item_num=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(addItemId), Integer.valueOf(addItemNum) }));
/*     */       
/*     */ 
/*     */ 
/* 149 */       return;
/*     */     }
/*     */     
/* 152 */     int beginValue = ItemInterface.getItemNumberById(roleid, bagType.intValue(), addItemId, true);
/* 153 */     TLogArg tLogArg = new TLogArg(LogReason.GMT_ADD_ITEM);
/* 154 */     ItemOperateResult result = ItemInterface.addItemForIdip(roleid, bagType.intValue(), addItemId, addItemNum, false, tLogArg);
/*     */     
/* 156 */     if ((!result.success()) && (!result.isBagFull()))
/*     */     {
/* 158 */       int retcode = Retcode.SEND_ITEM_FAILED.value;
/* 159 */       rsp.retcode = retcode;
/* 160 */       Response response = IdipGmtUtil.getResponse(retcode, result.getResultEnum().retMsg);
/* 161 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 163 */       GameServer.logger().error(String.format("[gmt]DoSendItemHandler.execute@send item failed|ret=%d|ret_msg=%s|userid=%s|roleid=%d|bag_type=%d|item_id=%d|item_num=%d", new Object[] { Integer.valueOf(result.getResultEnum().ret), result.getResultEnum().retMsg, userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(addItemId), Integer.valueOf(addItemNum) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 168 */       return;
/*     */     }
/*     */     
/* 171 */     int endValue = ItemInterface.getItemNumberById(roleid, bagType.intValue(), addItemId, true);
/*     */     
/* 173 */     DoSendItemRsp sendItemRsp = new DoSendItemRsp();
/* 174 */     sendItemRsp.BeginValue = beginValue;
/* 175 */     sendItemRsp.EndValue = endValue;
/* 176 */     sendItemRsp.ItemName = itemCfg.name;
/* 177 */     sendItemRsp.Result = result.getResultEnum().ret;
/* 178 */     sendItemRsp.RetMsg = result.getResultEnum().retMsg;
/*     */     
/* 180 */     rsp.retcode = Retcode.SUCCESS.value;
/* 181 */     Response response = new Response();
/* 182 */     response.data = sendItemRsp;
/* 183 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 185 */     TLogManager.getInstance().addLog(userid, "GMTDoSendItem", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(addItemId), Integer.valueOf(addItemNum), Integer.valueOf(type), Integer.valueOf(beginValue), Integer.valueOf(endValue) });
/*     */     
/*     */ 
/* 188 */     GameServer.logger().info(String.format("[gmt]DoSendItemHandler.execute@send item success|ret=%d|ret_msg=%s|userid=%s|roleid=%d|bag_type=%d|item_id=%d|item_num=%d|begin_value=%d|end_value=%d", new Object[] { Integer.valueOf(result.getResultEnum().ret), result.getResultEnum().retMsg, userid, Long.valueOf(roleid), Integer.valueOf(type), Integer.valueOf(addItemId), Integer.valueOf(addItemNum), Integer.valueOf(beginValue), Integer.valueOf(endValue) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\DoSendItemHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */