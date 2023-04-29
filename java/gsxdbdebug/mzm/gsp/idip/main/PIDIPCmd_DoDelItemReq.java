/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.DoDelItemReq;
/*     */ import idip.DoDelItemRsp;
/*     */ import idip.IDIPCmd_DoDelItemReq;
/*     */ import idip.IDIPPacket_DoDelItemReq;
/*     */ import idip.IDIPPacket_DoDelItemRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
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
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class PIDIPCmd_DoDelItemReq extends PIDIPCmd<IDIPCmd_DoDelItemReq>
/*     */ {
/*  28 */   private static final Map<Integer, Integer> bagTypeMap = new HashMap();
/*     */   
/*  30 */   private static final Integer ALL = Integer.valueOf(0);
/*  31 */   private static final Integer STORAGE = Integer.valueOf(3);
/*     */   
/*     */   static {
/*  34 */     bagTypeMap.put(Integer.valueOf(1), Integer.valueOf(340600000));
/*  35 */     bagTypeMap.put(Integer.valueOf(2), Integer.valueOf(340600001));
/*  36 */     bagTypeMap.put(Integer.valueOf(3), STORAGE);
/*     */     
/*  38 */     bagTypeMap.put(Integer.valueOf(0), ALL);
/*  39 */     bagTypeMap.put(Integer.valueOf(4), Integer.valueOf(340600005));
/*  40 */     bagTypeMap.put(Integer.valueOf(5), Integer.valueOf(340600006));
/*  41 */     bagTypeMap.put(Integer.valueOf(6), Integer.valueOf(340600007));
/*  42 */     bagTypeMap.put(Integer.valueOf(7), Integer.valueOf(340600008));
/*  43 */     bagTypeMap.put(Integer.valueOf(8), Integer.valueOf(340600009));
/*     */   }
/*     */   
/*     */   public PIDIPCmd_DoDelItemReq(IDIPCmd_DoDelItemReq cmd)
/*     */   {
/*  48 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  54 */     String openId = ((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).OpenId;
/*  55 */     int areaId = ((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).AreaId;
/*  56 */     int partition = ((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Partition;
/*     */     
/*  58 */     String userId = Utils.getUserId(openId, areaId, partition);
/*  59 */     xbean.User xUser = xtable.User.get(userId);
/*  60 */     if (null == xUser)
/*     */     {
/*  62 */       ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result = 1;
/*  63 */       ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  64 */       ((IDIPCmd_DoDelItemReq)this.cmd).sendResponse();
/*     */       
/*  66 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoDelItemReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%s|ware_house_type=%d|item_id=%d|item_num=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).PlatId), ((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).RoleId, Byte.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).WarehouseType), Long.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).ItemId), Integer.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Num), Integer.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Source), ((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  72 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  76 */     if (((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  78 */       ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result = (((DoDelItemRsp)((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).body).Result = 1);
/*  79 */       ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg = (((DoDelItemRsp)((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).body).RetMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) }));
/*     */       
/*  81 */       ((IDIPCmd_DoDelItemReq)this.cmd).sendResponse();
/*     */       
/*  83 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoDelItemReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%s|ware_house_type=%d|item_id=%d|item_num=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).PlatId), ((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).RoleId, Byte.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).WarehouseType), Long.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).ItemId), Integer.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Num), Integer.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Source), ((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     long roleId = 0L;
/*     */     try
/*     */     {
/*  95 */       roleId = Long.parseLong(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  99 */       ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result = (((DoDelItemRsp)((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).body).Result = 1);
/* 100 */       ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg = (((DoDelItemRsp)((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).body).RetMsg = "roleid format error");
/* 101 */       ((IDIPCmd_DoDelItemReq)this.cmd).sendResponse();
/*     */       
/* 103 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoDelItemReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|role_id=%s|ware_house_type=%d|item_id=%d|item_num=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).PlatId), ((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).RoleId, Byte.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).WarehouseType), Long.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).ItemId), Integer.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Num), Integer.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Source), ((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 110 */       return false;
/*     */     }
/*     */     
/* 113 */     if (roleId != 0L)
/*     */     {
/* 115 */       if ((!RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */       {
/* 117 */         ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result = 1;
/* 118 */         ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/* 119 */         ((IDIPCmd_DoDelItemReq)this.cmd).sendResponse();
/*     */         
/* 121 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_DoDelItemReq.handle@role not found|ret=%d|ret_msg=%s|user_id=%s|user_role_list=%s|area_id=%d|plat_id=%d|role_id=%d|ware_house_type=%d|item_id=%d|item_num=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg, userId, xUser.getRoleids().toString(), Integer.valueOf(areaId), Byte.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Byte.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).WarehouseType), Long.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).ItemId), Integer.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Num), Integer.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Source), ((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Serial }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 129 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     else {
/* 135 */       lock(Basic.getTable(), xUser.getRoleids());
/*     */     }
/*     */     
/* 138 */     int deleteItemId = (int)((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).ItemId;
/* 139 */     int deleteItemNum = ((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Num;
/* 140 */     int wareHouseType = ((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).WarehouseType;
/*     */     
/* 142 */     if (deleteItemNum < 0)
/*     */     {
/* 144 */       ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result = 64479;
/* 145 */       ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg = "delete item num invalid";
/* 146 */       ((IDIPCmd_DoDelItemReq)this.cmd).sendResponse();
/*     */       
/* 148 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoDelItemReq.handle@delete item num invalid|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%d|ware_house_type=%d|item_id=%d|item_num=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Integer.valueOf(wareHouseType), Integer.valueOf(deleteItemId), Integer.valueOf(deleteItemNum), Integer.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Source), ((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 155 */       return false;
/*     */     }
/*     */     
/* 158 */     Integer bagType = (Integer)bagTypeMap.get(Integer.valueOf(wareHouseType));
/* 159 */     if (bagType == null)
/*     */     {
/* 161 */       ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result = 64482;
/* 162 */       ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg = "bag type not exist";
/* 163 */       ((IDIPCmd_DoDelItemReq)this.cmd).sendResponse();
/*     */       
/* 165 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoDelItemReq.handle@bag type not exist|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%d|ware_house_type=%d|item_id=%d|item_num=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Integer.valueOf(wareHouseType), Integer.valueOf(deleteItemId), Integer.valueOf(deleteItemNum), Integer.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Source), ((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 171 */       return false;
/*     */     }
/*     */     
/* 174 */     if ((bagType != STORAGE) && (bagType != ALL) && (roleId > 0L))
/*     */     {
/*     */ 
/* 177 */       boolean isBagEnable = ItemInterface.isBagEnable(roleId, bagType.intValue(), true);
/* 178 */       if (!isBagEnable)
/*     */       {
/* 180 */         ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result = 64478;
/* 181 */         ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg = "storage not open";
/* 182 */         ((IDIPCmd_DoDelItemReq)this.cmd).sendResponse();
/*     */         
/* 184 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_DoDelItemReq.handle@storage not open|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%d|ware_house_type=%d|item_id=%d|item_num=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Integer.valueOf(wareHouseType), Integer.valueOf(deleteItemId), Integer.valueOf(deleteItemNum), Integer.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Source), ((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Serial }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 191 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 195 */     SItemCfg itemCfg = ItemInterface.getSItemCfg(deleteItemId);
/* 196 */     if (itemCfg == null)
/*     */     {
/* 198 */       ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result = 64485;
/* 199 */       ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg = "delete item not exist in config";
/* 200 */       ((IDIPCmd_DoDelItemReq)this.cmd).sendResponse();
/* 201 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoDelItemReq.handle@delete item not exist in config|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%d|ware_house_type=%d|item_id=%d|item_num=%d|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Integer.valueOf(wareHouseType), Integer.valueOf(deleteItemId), Integer.valueOf(deleteItemNum), Integer.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Source), ((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Serial }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 207 */       return false;
/*     */     }
/* 209 */     ((DoDelItemRsp)((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).body).ItemName = Utils.urlEncode1738(itemCfg.name);
/*     */     
/*     */ 
/* 212 */     int beginValue = 0;
/* 213 */     if (roleId == 0L)
/*     */     {
/* 215 */       boolean changed = false;
/* 216 */       for (Iterator i$ = xUser.getRoleids().iterator(); i$.hasNext();) { long targetRoleid = ((Long)i$.next()).longValue();
/*     */         
/* 218 */         if (RoleInterface.isRoleExist(targetRoleid, true))
/*     */         {
/*     */ 
/*     */ 
/* 222 */           int value = getNum(targetRoleid, deleteItemId, bagType.intValue());
/* 223 */           beginValue += value;
/* 224 */           if ((value != 0) && (
/*     */           
/*     */ 
/*     */ 
/* 228 */             (deleteItemNum <= 0) || (value >= deleteItemNum)))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 233 */             ItemOperateResult.ItemResultEnum resultEnum = remove(targetRoleid, deleteItemId, deleteItemNum, bagType.intValue());
/* 234 */             if (resultEnum != ItemOperateResult.ItemResultEnum.SUCCESS)
/*     */             {
/* 236 */               return false;
/*     */             }
/* 238 */             changed = true;
/*     */           } } }
/* 240 */       if (!changed)
/*     */       {
/* 242 */         ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result = 64016;
/* 243 */         ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg = "content role not found";
/* 244 */         ((IDIPCmd_DoDelItemReq)this.cmd).sendResponse();
/*     */         
/* 246 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_DoDelItemReq.handle@content role not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%d|item_id=%d|item_num=%d|item_name=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Integer.valueOf(deleteItemId), Integer.valueOf(deleteItemNum), itemCfg.name, Integer.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Source), ((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Serial }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 252 */         return false;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 257 */       beginValue = getNum(roleId, deleteItemId, bagType.intValue());
/* 258 */       if (beginValue == 0)
/*     */       {
/* 260 */         ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result = 64480;
/* 261 */         ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg = "bag not has the item";
/* 262 */         ((IDIPCmd_DoDelItemReq)this.cmd).sendResponse();
/*     */         
/* 264 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_DoDelItemReq.handle@bag not has the item|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%d|item_id=%d|item_num=%d|item_name=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Integer.valueOf(deleteItemId), Integer.valueOf(deleteItemNum), itemCfg.name, Integer.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Source), ((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Serial }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 270 */         return false;
/*     */       }
/*     */       
/* 273 */       if ((deleteItemNum > 0) && (beginValue < deleteItemNum))
/*     */       {
/* 275 */         ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result = 64484;
/* 276 */         ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg = "bag item num not enough";
/* 277 */         ((IDIPCmd_DoDelItemReq)this.cmd).sendResponse();
/*     */         
/* 279 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_DoDelItemReq.handle@bag item num not enough|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%d|item_id=%d|item_num=%d|item_name=%s|source=%d|serial=%s|num=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Integer.valueOf(deleteItemId), Integer.valueOf(deleteItemNum), itemCfg.name, Integer.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Source), ((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Serial, Integer.valueOf(beginValue) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 285 */         return false;
/*     */       }
/*     */       
/* 288 */       ItemOperateResult.ItemResultEnum resultEnum = remove(roleId, deleteItemId, deleteItemNum, bagType.intValue());
/* 289 */       if (resultEnum != ItemOperateResult.ItemResultEnum.SUCCESS)
/*     */       {
/* 291 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 296 */     int endValue = 0;
/* 297 */     Iterator i$; if (roleId == 0L)
/*     */     {
/* 299 */       for (i$ = xUser.getRoleids().iterator(); i$.hasNext();) { long targetRoleid = ((Long)i$.next()).longValue();
/*     */         
/* 301 */         if (RoleInterface.isRoleExist(targetRoleid, true))
/*     */         {
/*     */ 
/*     */ 
/* 305 */           endValue += getNum(targetRoleid, deleteItemId, bagType.intValue());
/*     */         }
/*     */         
/*     */       }
/*     */     } else {
/* 310 */       endValue = getNum(roleId, deleteItemId, bagType.intValue());
/*     */     }
/*     */     
/* 313 */     ((DoDelItemRsp)((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).body).BeginValue = beginValue;
/* 314 */     ((DoDelItemRsp)((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).body).EndValue = endValue;
/* 315 */     ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result = 0;
/* 316 */     ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 317 */     ((IDIPCmd_DoDelItemReq)this.cmd).sendResponse();
/*     */     
/* 319 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DoDelItemReq.handle@delete item success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%d|item_id=%d|item_num=%d|begin_value=%d|end_value=%d|item_name=%s|source=%d|serial=%s", new Object[] { Integer.valueOf(((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Integer.valueOf(deleteItemId), Integer.valueOf(deleteItemNum), Integer.valueOf(((DoDelItemRsp)((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).body).BeginValue), Integer.valueOf(((DoDelItemRsp)((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).body).EndValue), itemCfg.name, Integer.valueOf(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Source), getSerialNo() }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 325 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String getSerialNo()
/*     */   {
/* 331 */     return ((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Serial;
/*     */   }
/*     */   
/*     */   private ItemOperateResult.ItemResultEnum remove(long roleid, int deleteItemid, int deleteItemNum, int bagType)
/*     */   {
/* 336 */     int beginValue = getNum(roleid, deleteItemid, bagType);
/* 337 */     ItemOperateResult.ItemResultEnum result = removeItem(roleid, deleteItemid, deleteItemNum, bagType);
/* 338 */     if (result != ItemOperateResult.ItemResultEnum.SUCCESS)
/*     */     {
/* 340 */       ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.Result = result.ret;
/* 341 */       ((IDIPPacket_DoDelItemRsp)((IDIPCmd_DoDelItemReq)this.cmd).rsp).head.RetErrMsg = result.retMsg;
/* 342 */       ((IDIPCmd_DoDelItemReq)this.cmd).sendResponse();
/* 343 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoDelItemReq.remove@delete item failed|role_id=%d|item_id=%d|item_num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(deleteItemid), Integer.valueOf(deleteItemNum) }));
/*     */       
/*     */ 
/* 346 */       return result;
/*     */     }
/*     */     
/* 349 */     int endValue = getNum(roleid, deleteItemid, bagType);
/*     */     
/* 351 */     StringBuilder logStr = new StringBuilder();
/* 352 */     logStr.append(((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).head.SendTime).append("|");
/* 353 */     logStr.append(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).OpenId).append("|");
/* 354 */     logStr.append(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).AreaId).append("|");
/* 355 */     logStr.append(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Partition).append("|");
/* 356 */     logStr.append(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).ItemId).append("|");
/* 357 */     logStr.append(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Num).append("|");
/* 358 */     logStr.append(((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).head.Cmdid).append("|");
/* 359 */     logStr.append(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Serial).append("|");
/* 360 */     logStr.append(((DoDelItemReq)((IDIPPacket_DoDelItemReq)((IDIPCmd_DoDelItemReq)this.cmd).req).body).Source).append("|");
/* 361 */     logStr.append(beginValue).append("|");
/* 362 */     logStr.append(endValue).append("|");
/* 363 */     logStr.append(result.ret).append("|");
/* 364 */     logStr.append(result.retMsg).append("|");
/* 365 */     logStr.append(roleid);
/* 366 */     TLogManager.getInstance().addLog(roleid, "IDIPDoDelItem", logStr.toString());
/*     */     
/* 368 */     return result;
/*     */   }
/*     */   
/*     */   private ItemOperateResult.ItemResultEnum removeItem(long roleid, int deleteItemId, int deleteNum, int bagType)
/*     */   {
/* 373 */     TLogArg tLogArg = new TLogArg(LogReason.IDIP_REM);
/* 374 */     if (bagType == STORAGE.intValue())
/*     */     {
/* 376 */       return deleteItemFormStorage(roleid, deleteItemId, deleteNum, tLogArg);
/*     */     }
/* 378 */     if (bagType == ALL.intValue())
/*     */     {
/*     */ 
/* 381 */       if (deleteNum == 0)
/*     */       {
/* 383 */         ItemOperateResult.ItemResultEnum resultEnum = deleteItemFormStorage(roleid, deleteItemId, deleteNum, tLogArg);
/* 384 */         if (resultEnum != ItemOperateResult.ItemResultEnum.SUCCESS)
/*     */         {
/* 386 */           return resultEnum;
/*     */         }
/* 388 */         return deleteItemFormBag(roleid, deleteItemId, deleteNum, tLogArg);
/*     */       }
/*     */       
/*     */ 
/* 392 */       int storageNum = getNumFormStorage(roleid, deleteItemId);
/* 393 */       if (storageNum >= deleteNum)
/*     */       {
/* 395 */         return deleteItemFormStorage(roleid, deleteItemId, deleteNum, tLogArg);
/*     */       }
/*     */       
/*     */ 
/* 399 */       if (storageNum != 0)
/*     */       {
/* 401 */         ItemOperateResult.ItemResultEnum resultEnum = deleteItemFormStorage(roleid, deleteItemId, storageNum, tLogArg);
/* 402 */         if (resultEnum != ItemOperateResult.ItemResultEnum.SUCCESS)
/*     */         {
/* 404 */           return resultEnum;
/*     */         }
/*     */       }
/* 407 */       return deleteItemFormBag(roleid, deleteItemId, deleteNum - storageNum, tLogArg);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 413 */     int num = deleteNum;
/* 414 */     if (deleteNum == 0)
/*     */     {
/*     */ 
/* 417 */       num = ItemInterface.getItemNumberById(roleid, bagType, deleteItemId, true);
/*     */     }
/* 419 */     ItemOperateResult result = ItemInterface.removeItemByIdForIdip(roleid, bagType, deleteItemId, num, tLogArg);
/* 420 */     return result.getResultEnum();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private ItemOperateResult.ItemResultEnum deleteItemFormStorage(long roleid, int deleteItemId, int deleteNum, TLogArg tLogArg)
/*     */   {
/* 427 */     int needDeleteNum = deleteNum;
/* 428 */     for (Integer storageid : ItemInterface.getAllStorageids())
/*     */     {
/*     */ 
/* 431 */       if (ItemInterface.isBagEnable(roleid, storageid.intValue(), true))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 437 */         int num = ItemInterface.getItemNumberById(roleid, storageid.intValue(), deleteItemId, true);
/* 438 */         if (num > 0)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 444 */           if (deleteNum == 0)
/*     */           {
/* 446 */             ItemOperateResult result = ItemInterface.removeItemByIdForIdip(roleid, storageid.intValue(), deleteItemId, num, tLogArg);
/*     */             
/* 448 */             if (!result.success())
/*     */             {
/* 450 */               return result.getResultEnum();
/*     */             }
/*     */             
/*     */ 
/*     */           }
/* 455 */           else if (num < needDeleteNum)
/*     */           {
/*     */ 
/* 458 */             needDeleteNum -= num;
/* 459 */             ItemOperateResult result = ItemInterface.removeItemByIdForIdip(roleid, storageid.intValue(), deleteItemId, num, tLogArg);
/*     */             
/* 461 */             if (!result.success())
/*     */             {
/* 463 */               return result.getResultEnum();
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 468 */             ItemOperateResult result = ItemInterface.removeItemByIdForIdip(roleid, storageid.intValue(), deleteItemId, needDeleteNum, tLogArg);
/*     */             
/* 470 */             return result.getResultEnum();
/*     */           } }
/*     */       } }
/* 473 */     if (deleteNum == 0)
/*     */     {
/* 475 */       return ItemOperateResult.ItemResultEnum.SUCCESS;
/*     */     }
/*     */     
/*     */ 
/* 479 */     return ItemOperateResult.ItemResultEnum.WRONG_NUMBER;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private ItemOperateResult.ItemResultEnum deleteItemFormBag(long roleid, int deleteItemId, int deleteNum, TLogArg tLogArg)
/*     */   {
/* 486 */     int needDeleteNum = deleteNum;
/* 487 */     for (Integer bagid : ItemInterface.getAllBagids())
/*     */     {
/*     */ 
/* 490 */       if (ItemInterface.isBagEnable(roleid, bagid.intValue(), true))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 495 */         int num = ItemInterface.getItemNumberById(roleid, bagid.intValue(), deleteItemId, true);
/* 496 */         if (num > 0)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 502 */           if (deleteNum == 0)
/*     */           {
/* 504 */             ItemOperateResult result = ItemInterface.removeItemByIdForIdip(roleid, bagid.intValue(), deleteItemId, num, tLogArg);
/* 505 */             if (!result.success())
/*     */             {
/* 507 */               return result.getResultEnum();
/*     */             }
/*     */             
/*     */ 
/*     */           }
/* 512 */           else if (num < needDeleteNum)
/*     */           {
/* 514 */             needDeleteNum -= num;
/*     */             
/* 516 */             ItemOperateResult result = ItemInterface.removeItemByIdForIdip(roleid, bagid.intValue(), deleteItemId, num, tLogArg);
/* 517 */             if (!result.success())
/*     */             {
/* 519 */               return result.getResultEnum();
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 524 */             ItemOperateResult result = ItemInterface.removeItemByIdForIdip(roleid, bagid.intValue(), deleteItemId, needDeleteNum, tLogArg);
/*     */             
/* 526 */             return result.getResultEnum();
/*     */           } }
/*     */       }
/*     */     }
/* 530 */     if (deleteNum == 0)
/*     */     {
/* 532 */       return ItemOperateResult.ItemResultEnum.SUCCESS;
/*     */     }
/*     */     
/*     */ 
/* 536 */     return ItemOperateResult.ItemResultEnum.WRONG_NUMBER;
/*     */   }
/*     */   
/*     */ 
/*     */   private int getNum(long roleid, int itemId, int bagType)
/*     */   {
/* 542 */     int value = 0;
/* 543 */     if (bagType == STORAGE.intValue())
/*     */     {
/* 545 */       value = getNumFormStorage(roleid, itemId);
/*     */     }
/* 547 */     else if (bagType == ALL.intValue())
/*     */     {
/* 549 */       value = ItemInterface.getTotalItemNumberById(roleid, itemId);
/*     */     }
/*     */     else
/*     */     {
/* 553 */       value = ItemInterface.getItemNumberById(roleid, bagType, itemId, true);
/*     */     }
/* 555 */     return value;
/*     */   }
/*     */   
/*     */   private int getNumFormStorage(long roleid, int itemId)
/*     */   {
/* 560 */     int sum = 0;
/* 561 */     for (Integer storageid : ItemInterface.getAllStorageids())
/*     */     {
/*     */ 
/* 564 */       if (ItemInterface.isBagEnable(roleid, storageid.intValue(), true))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 570 */         int num = ItemInterface.getItemNumberById(roleid, storageid.intValue(), itemId, true);
/* 571 */         if (num > 0)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 576 */           sum += num; }
/*     */       } }
/* 578 */     return sum;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoDelItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */