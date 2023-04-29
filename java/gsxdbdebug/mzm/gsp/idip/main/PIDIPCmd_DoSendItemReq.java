/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.DoSendItemReq;
/*     */ import idip.DoSendItemRsp;
/*     */ import idip.IDIPCmd_DoSendItemReq;
/*     */ import idip.IDIPPacket_DoSendItemReq;
/*     */ import idip.IDIPPacket_DoSendItemRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
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
/*     */ public class PIDIPCmd_DoSendItemReq
/*     */   extends PIDIPCmd<IDIPCmd_DoSendItemReq>
/*     */ {
/*  27 */   private static final Map<Integer, Integer> bagTypeMap = new HashMap();
/*     */   
/*     */   static {
/*  30 */     int i = 1;
/*  31 */     bagTypeMap.put(Integer.valueOf(i++), Integer.valueOf(340600000));
/*  32 */     bagTypeMap.put(Integer.valueOf(i++), Integer.valueOf(340600001));
/*  33 */     for (Integer storageid : ItemInterface.getAllStorageids())
/*     */     {
/*  35 */       bagTypeMap.put(Integer.valueOf(i++), storageid);
/*     */     }
/*     */   }
/*     */   
/*     */   public PIDIPCmd_DoSendItemReq(IDIPCmd_DoSendItemReq cmd)
/*     */   {
/*  41 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  47 */     String openId = ((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).OpenId;
/*  48 */     int areaId = ((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).AreaId;
/*  49 */     int partition = ((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Partition;
/*     */     
/*  51 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  52 */     xbean.User xUser = xtable.User.get(userId);
/*  53 */     if (null == xUser)
/*     */     {
/*  55 */       ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.Result = 1;
/*  56 */       ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  57 */       ((IDIPCmd_DoSendItemReq)this.cmd).sendResponse();
/*     */       
/*  59 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendItemReq.handle@query userid empty|ret=%d|ret_msg=%s|user_id=%s|ared_id=%d|plat_id=%d|role_id=%s|ware_house_type=%d|item_id=%d|item_num=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).PlatId), ((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).RoleId, Byte.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).WarehouseType), Long.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).ItemId), Integer.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Num), Integer.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Source), ((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  66 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  70 */     if (((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  72 */       ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.Result = (((DoSendItemRsp)((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).body).Result = 1);
/*  73 */       ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.RetErrMsg = (((DoSendItemRsp)((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  75 */       ((IDIPCmd_DoSendItemReq)this.cmd).sendResponse();
/*     */       
/*  77 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendItemReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|ared_id=%d|plat_id=%d|role_id=%s|ware_house_type=%d|item_id=%d|item_num=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).PlatId), ((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).RoleId, Byte.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).WarehouseType), Long.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).ItemId), Integer.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Num), Integer.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Source), ((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     long roleId = -1L;
/*     */     try
/*     */     {
/*  90 */       roleId = Long.parseLong(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  94 */       ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.Result = (((DoSendItemRsp)((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).body).Result = 1);
/*  95 */       ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.RetErrMsg = (((DoSendItemRsp)((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/*  96 */       ((IDIPCmd_DoSendItemReq)this.cmd).sendResponse();
/*     */       
/*  98 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendItemReq.handle@query roleid empty|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|plat_id=%d|ared_id=%d|role_id=%s|ware_house_type=%d|item_id=%d|item_num=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Byte.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).PlatId), Integer.valueOf(areaId), ((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).RoleId, Byte.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).WarehouseType), Long.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).ItemId), Integer.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Num), Integer.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Source), ((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     if ((!RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/* 109 */       ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.Result = 1;
/* 110 */       ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/* 111 */       ((IDIPCmd_DoSendItemReq)this.cmd).sendResponse();
/*     */       
/* 113 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendItemReq.handle@query roleid empty|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|plat_id=%d|ared_id=%d|role_id=%d|ware_house_type=%d|item_id=%d|item_num=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Byte.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).PlatId), Integer.valueOf(areaId), Long.valueOf(roleId), Byte.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).WarehouseType), Long.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).ItemId), Integer.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Num), Integer.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Source), ((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 119 */       return false;
/*     */     }
/*     */     
/* 122 */     int addItemNum = ((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Num;
/*     */     
/* 124 */     if (addItemNum <= 0)
/*     */     {
/* 126 */       ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.Result = 64479;
/* 127 */       ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.RetErrMsg = "send item num must > 0";
/* 128 */       ((IDIPCmd_DoSendItemReq)this.cmd).sendResponse();
/*     */       
/* 130 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendItemReq.handle@send item num must > 0|ret=%d|ret_msg=%s|user_id=%s|ared_id=%d|plat_id=%d|role_id=%d|ware_house_type=%d|item_id=%d|item_num=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Byte.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).WarehouseType), Long.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).ItemId), Integer.valueOf(addItemNum), Integer.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Source), ((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 136 */       return false;
/*     */     }
/*     */     
/* 139 */     int addItemId = (int)((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).ItemId;
/* 140 */     int wareHouseType = ((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).WarehouseType;
/* 141 */     Integer bagType = (Integer)bagTypeMap.get(Integer.valueOf(wareHouseType));
/* 142 */     if (bagType == null)
/*     */     {
/* 144 */       ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.Result = 64482;
/* 145 */       ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.RetErrMsg = "bag type not exist";
/* 146 */       ((IDIPCmd_DoSendItemReq)this.cmd).sendResponse();
/*     */       
/* 148 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendItemReq.handle@bag type not exist|ret=%d|ret_msg=%s|user_id=%s|ared_id=%d|plat_id=%d|role_id=%d|ware_house_type=%d|item_id=%d|item_num=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Integer.valueOf(wareHouseType), Integer.valueOf(addItemId), Integer.valueOf(addItemNum), Integer.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Source), ((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 153 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 157 */     if (bagType.intValue() == 340600001)
/*     */     {
/* 159 */       ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.Result = 64481;
/* 160 */       ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.RetErrMsg = "equip bag can not add item";
/* 161 */       ((IDIPCmd_DoSendItemReq)this.cmd).sendResponse();
/*     */       
/* 163 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendItemReq.handle@equip bag not allow send item|ret=%d|ret_msg=%s|user_id=%s|ared_id=%d|plat_id=%d|role_id=%d|ware_house_type=%d|item_id=%d|item_num=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Integer.valueOf(wareHouseType), Integer.valueOf(addItemId), Integer.valueOf(addItemNum), Integer.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Source), ((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 168 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 172 */     boolean isBagEnable = ItemInterface.isBagEnable(roleId, bagType.intValue(), true);
/* 173 */     if (!isBagEnable)
/*     */     {
/* 175 */       ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.Result = 64478;
/* 176 */       ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.RetErrMsg = "storage not open";
/* 177 */       ((IDIPCmd_DoSendItemReq)this.cmd).sendResponse();
/*     */       
/* 179 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendItemReq.handle@storage not open|ret=%d|ret_msg=%s|user_id=%s|ared_id=%d|plat_id=%d|role_id=%d|ware_house_type=%d|item_id=%d|item_num=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Integer.valueOf(wareHouseType), Integer.valueOf(addItemId), Integer.valueOf(addItemNum), Integer.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Source), ((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 184 */       return false;
/*     */     }
/* 186 */     SItemCfg itemCfg = ItemInterface.getSItemCfg(addItemId);
/* 187 */     if (itemCfg == null)
/*     */     {
/* 189 */       ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.Result = 64485;
/* 190 */       ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.RetErrMsg = "send item not exist";
/* 191 */       ((IDIPCmd_DoSendItemReq)this.cmd).sendResponse();
/*     */       
/* 193 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendItemReq.handle@send item not exist in config|ret=%d|ret_msg=%s|user_id=%s|ared_id=%d|plat_id=%d|role_id=%d|ware_house_type=%d|item_id=%d|item_num=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Integer.valueOf(wareHouseType), Integer.valueOf(addItemId), Integer.valueOf(addItemNum), Integer.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Source), ((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 198 */       return false;
/*     */     }
/* 200 */     ((DoSendItemRsp)((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).body).ItemName = Utils.urlEncode1738(itemCfg.name);
/*     */     
/* 202 */     int beginValue = ItemInterface.getItemNumberById(roleId, bagType.intValue(), addItemId, true);
/*     */     
/* 204 */     TLogArg tLogArg = new TLogArg(LogReason.IDIP_ADD);
/* 205 */     ItemOperateResult result = ItemInterface.addItemForIdip(roleId, bagType.intValue(), addItemId, addItemNum, false, tLogArg);
/*     */     
/*     */ 
/* 208 */     if ((!result.success()) && (!result.isBagFull()))
/*     */     {
/* 210 */       ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.Result = result.getResultEnum().ret;
/* 211 */       ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.RetErrMsg = result.getResultEnum().retMsg;
/* 212 */       ((IDIPCmd_DoSendItemReq)this.cmd).sendResponse();
/*     */       
/* 214 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoSendItemReq.handle@send item failed|ret=%d|ret_msg=%s|user_id=%s|ared_id=%d|plat_id=%d|source=%d|role_id=%d|ware_house_type=%d|item_id=%d|item_num=%d|item_name=%s|serial=%s|begin_value=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(wareHouseType), Integer.valueOf(addItemId), Integer.valueOf(addItemNum), itemCfg.name, ((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Serial, Integer.valueOf(beginValue) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 220 */       return false;
/*     */     }
/*     */     
/* 223 */     ((DoSendItemRsp)((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).body).BeginValue = beginValue;
/* 224 */     ((DoSendItemRsp)((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).body).EndValue = ItemInterface.getItemNumberById(roleId, bagType.intValue(), addItemId, true);
/* 225 */     ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.Result = 0;
/* 226 */     ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.RetErrMsg = (!result.isBagFull() ? "ok" : result.getResultEnum().retMsg);
/* 227 */     ((IDIPCmd_DoSendItemReq)this.cmd).sendResponse();
/*     */     
/* 229 */     StringBuilder logStr = new StringBuilder();
/*     */     
/* 231 */     logStr.append(((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).head.SendTime).append("|");
/* 232 */     logStr.append(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).OpenId).append("|");
/* 233 */     logStr.append(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).AreaId).append("|");
/* 234 */     logStr.append(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Partition).append("|");
/* 235 */     logStr.append(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).ItemId).append("|");
/* 236 */     logStr.append(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Num).append("|");
/* 237 */     logStr.append(((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).head.Cmdid).append("|");
/* 238 */     logStr.append(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Serial).append("|");
/* 239 */     logStr.append(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Source).append("|");
/* 240 */     logStr.append(((DoSendItemRsp)((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).body).BeginValue).append("|");
/* 241 */     logStr.append(((DoSendItemRsp)((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).body).EndValue).append("|");
/* 242 */     logStr.append(result.getResultEnum().ret).append("|");
/* 243 */     logStr.append(result.getResultEnum().retMsg).append("|");
/* 244 */     logStr.append(roleId);
/*     */     
/* 246 */     TLogManager.getInstance().addLog(roleId, "IDIPDoSendItem", logStr.toString());
/*     */     
/* 248 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DoSendItemReq.handle@send item success|ret=%d|ret_msg=%s|user_id=%s|ared_id=%d|plat_id=%d|source=%d|role_id=%d|ware_house_type=%d|item_id=%d|item_num=%d|item_name=%s|begin_value=%d|end_value=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Source), Long.valueOf(roleId), Integer.valueOf(wareHouseType), Integer.valueOf(addItemId), Integer.valueOf(addItemNum), itemCfg.name, Integer.valueOf(((DoSendItemRsp)((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).body).BeginValue), Integer.valueOf(((DoSendItemRsp)((IDIPPacket_DoSendItemRsp)((IDIPCmd_DoSendItemReq)this.cmd).rsp).body).EndValue), ((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Serial }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 254 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 260 */     return ((DoSendItemReq)((IDIPPacket_DoSendItemReq)((IDIPCmd_DoSendItemReq)this.cmd).req).body).Serial;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoSendItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */