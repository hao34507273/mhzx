/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import idip.DoDelItemRsp;
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
/*     */ 
/*     */ public class DoDelItemHandler
/*     */   implements IdipHandler
/*     */ {
/*  26 */   private static final Map<Integer, Integer> bagTypeMap = new HashMap();
/*  27 */   private static final Integer STORAGE = Integer.valueOf(3);
/*     */   
/*     */   static
/*     */   {
/*  31 */     bagTypeMap.put(Integer.valueOf(1), Integer.valueOf(340600000));
/*  32 */     bagTypeMap.put(Integer.valueOf(2), Integer.valueOf(340600001));
/*  33 */     bagTypeMap.put(Integer.valueOf(3), STORAGE);
/*     */   }
/*     */   
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp)
/*     */     throws Exception
/*     */   {
/*  39 */     String userid = (String)params.get(0);
/*  40 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*  41 */     int type = Integer.parseInt((String)params.get(2));
/*  42 */     int itemCfgid = Integer.parseInt((String)params.get(3));
/*  43 */     int num = Integer.parseInt((String)params.get(4));
/*     */     
/*  45 */     xbean.User xUser = xtable.User.get(userid);
/*  46 */     if (null == xUser)
/*     */     {
/*  48 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/*  49 */       rsp.retcode = retcode;
/*  50 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/*  51 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  53 */       GameServer.logger().error(String.format("[gmt]DoDelItemHandler.execute@user not found|userid=%s|roleid=%d|item_cfgid=%d|num=%d|type=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(itemCfgid), Integer.valueOf(num), Integer.valueOf(type) }));
/*     */       
/*     */ 
/*     */ 
/*  57 */       return;
/*     */     }
/*     */     
/*  60 */     if ((!RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*     */     {
/*  62 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  63 */       rsp.retcode = retcode;
/*  64 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  65 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  67 */       GameServer.logger().error(String.format("[gmt]DoDelItemHandler.execute@role not found|userid=%s|user_role_list=%s|roleid=%d|item_cfgid=%d|num=%d|type=%d", new Object[] { userid, xUser.getRoleids().toString(), Long.valueOf(roleid), Integer.valueOf(itemCfgid), Integer.valueOf(num), Integer.valueOf(type) }));
/*     */       
/*     */ 
/*     */ 
/*  71 */       return;
/*     */     }
/*     */     
/*  74 */     if (num <= 0)
/*     */     {
/*  76 */       int retcode = Retcode.DEL_ITEM_NUM_INVALID.value;
/*  77 */       rsp.retcode = retcode;
/*  78 */       Response response = IdipGmtUtil.getResponse(retcode, "num <= 0");
/*  79 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  81 */       GameServer.logger().error(String.format("[gmt]DoDelItemHandler.execute@num <= 0|userid=%s|roleid=%d|item_cfgid=%d|num=%d|type=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(itemCfgid), Integer.valueOf(num), Integer.valueOf(type) }));
/*     */       
/*     */ 
/*  84 */       return;
/*     */     }
/*     */     
/*  87 */     Integer bagType = (Integer)bagTypeMap.get(Integer.valueOf(type));
/*  88 */     if (bagType == null)
/*     */     {
/*  90 */       int retcode = Retcode.DEL_TEM_BAG_TYPE_INVALID.value;
/*  91 */       rsp.retcode = retcode;
/*  92 */       Response response = IdipGmtUtil.getResponse(retcode, "bag type not exist");
/*  93 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  95 */       GameServer.logger().error(String.format("[gmt]DoDelItemHandler.execute@bag type not exist|userid=%s|roleid=%d|item_cfgid=%d|num=%d|type=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(itemCfgid), Integer.valueOf(num), Integer.valueOf(type) }));
/*     */       
/*     */ 
/*     */ 
/*  99 */       return;
/*     */     }
/*     */     
/* 102 */     if (bagType != STORAGE)
/*     */     {
/*     */ 
/* 105 */       boolean isBagEnable = ItemInterface.isBagEnable(roleid, bagType.intValue(), true);
/* 106 */       if (!isBagEnable)
/*     */       {
/* 108 */         int retcode = Retcode.DEL_TEM_BAG_TYPE_NOT_ENABLE.value;
/* 109 */         rsp.retcode = retcode;
/* 110 */         Response response = IdipGmtUtil.getResponse(retcode, "bag not open");
/* 111 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */         
/* 113 */         GameServer.logger().error(String.format("[gmt]DoDelItemHandler.execute@bag not open|userid=%s|roleid=%d|item_cfgid=%d|num=%d|type=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(itemCfgid), Integer.valueOf(num), Integer.valueOf(type) }));
/*     */         
/*     */ 
/*     */ 
/* 117 */         return;
/*     */       }
/*     */     }
/*     */     
/* 121 */     SItemCfg itemCfg = ItemInterface.getSItemCfg(itemCfgid);
/* 122 */     if (itemCfg == null)
/*     */     {
/* 124 */       int retcode = Retcode.DEL_ITEM_CFG_NOT_EXIST.value;
/* 125 */       rsp.retcode = retcode;
/* 126 */       Response response = IdipGmtUtil.getResponse(retcode, "item not exist");
/* 127 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 129 */       GameServer.logger().error(String.format("[gmt]DoDelItemHandler.execute@item not exist|userid=%s|roleid=%d|item_cfgid=%d|num=%d|type=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(itemCfgid), Integer.valueOf(num), Integer.valueOf(type) }));
/*     */       
/*     */ 
/*     */ 
/* 133 */       return;
/*     */     }
/*     */     
/*     */ 
/* 137 */     int beginValue = getNum(roleid, itemCfgid, bagType.intValue());
/* 138 */     if (beginValue == 0)
/*     */     {
/* 140 */       int retcode = Retcode.DEL_ITEM_NOT_IN_BAG.value;
/* 141 */       rsp.retcode = retcode;
/* 142 */       Response response = IdipGmtUtil.getResponse(retcode, "bag not has the item");
/* 143 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 145 */       GameServer.logger().error(String.format("[gmt]DoDelItemHandler.execute@bag not has the item|userid=%s|roleid=%d|item_cfgid=%d|num=%d|type=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(itemCfgid), Integer.valueOf(num), Integer.valueOf(type) }));
/*     */       
/*     */ 
/*     */ 
/* 149 */       return;
/*     */     }
/*     */     
/* 152 */     if (beginValue < num)
/*     */     {
/* 154 */       int retcode = Retcode.DEL_ITEM_NUM_NOT_ENOUGH.value;
/* 155 */       rsp.retcode = retcode;
/* 156 */       Response response = IdipGmtUtil.getResponse(retcode, "bag item num not enough");
/* 157 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 159 */       GameServer.logger().error(String.format("[gmt]DoDelItemHandler.execute@bag item num not enough|userid=%s|roleid=%d|item_cfgid=%d|num=%d|type=%d|begin_value=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(itemCfgid), Integer.valueOf(num), Integer.valueOf(type), Integer.valueOf(beginValue) }));
/*     */       
/*     */ 
/*     */ 
/* 163 */       return;
/*     */     }
/*     */     
/* 166 */     ItemOperateResult.ItemResultEnum result = removeItem(roleid, itemCfgid, num, bagType.intValue());
/* 167 */     if (result != ItemOperateResult.ItemResultEnum.SUCCESS)
/*     */     {
/* 169 */       int retcode = Retcode.DEL_ITEM_FAILED.value;
/* 170 */       rsp.retcode = retcode;
/* 171 */       Response response = IdipGmtUtil.getResponse(retcode, result.retMsg);
/* 172 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 174 */       GameServer.logger().error(String.format("[gmt]DoDelItemHandler.execute@delete item failed|ret=%d|ret_msg=%s|userid=%s|roleid=%d|item_cfgid=%d|num=%d|type=%d", new Object[] { Integer.valueOf(result.ret), result.retMsg, userid, Long.valueOf(roleid), Integer.valueOf(itemCfgid), Integer.valueOf(num), Integer.valueOf(type) }));
/*     */       
/*     */ 
/*     */ 
/* 178 */       return;
/*     */     }
/*     */     
/* 181 */     int endValue = ItemInterface.getItemNumberById(roleid, bagType.intValue(), itemCfgid, true);
/* 182 */     DoDelItemRsp delItemRsp = new DoDelItemRsp();
/* 183 */     delItemRsp.Result = 0;
/* 184 */     delItemRsp.RetMsg = result.retMsg;
/* 185 */     delItemRsp.BeginValue = beginValue;
/* 186 */     delItemRsp.EndValue = endValue;
/* 187 */     delItemRsp.ItemName = itemCfg.name;
/*     */     
/* 189 */     rsp.retcode = Retcode.SUCCESS.value;
/* 190 */     Response response = new Response();
/* 191 */     response.data = delItemRsp;
/* 192 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 194 */     TLogManager.getInstance().addLog(userid, "GMTDoDelItem", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(itemCfgid), Integer.valueOf(num), Integer.valueOf(type), Integer.valueOf(beginValue), Integer.valueOf(endValue) });
/*     */     
/* 196 */     GameServer.logger().info(String.format("[gmt]DoDelItemHandler.execute@delete item success|userid=%s|roleid=%d|item_cfgid=%d|num=%d|type=%d|begin_value=%d|end_value=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(itemCfgid), Integer.valueOf(num), Integer.valueOf(type), Integer.valueOf(beginValue), Integer.valueOf(endValue) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private ItemOperateResult.ItemResultEnum removeItem(long roleid, int deleteItemId, int deleteNum, int bagType)
/*     */   {
/* 204 */     TLogArg tLogArg = new TLogArg(LogReason.IDIP_REM);
/* 205 */     if (bagType == STORAGE.intValue())
/*     */     {
/* 207 */       return deleteItemFormStorage(roleid, deleteItemId, deleteNum, tLogArg);
/*     */     }
/*     */     
/*     */ 
/* 211 */     ItemOperateResult result = ItemInterface.removeItemByIdForIdip(roleid, bagType, deleteItemId, deleteNum, tLogArg);
/*     */     
/* 213 */     return result.getResultEnum();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private ItemOperateResult.ItemResultEnum deleteItemFormStorage(long roleid, int deleteItemId, int deleteNum, TLogArg tLogArg)
/*     */   {
/* 220 */     int needDeleteNum = deleteNum;
/* 221 */     for (Integer storageid : ItemInterface.getAllStorageids())
/*     */     {
/*     */ 
/* 224 */       if (ItemInterface.isBagEnable(roleid, storageid.intValue(), true))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 230 */         int num = ItemInterface.getItemNumberById(roleid, storageid.intValue(), deleteItemId, true);
/* 231 */         if (num > 0)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 236 */           if (num < needDeleteNum)
/*     */           {
/*     */ 
/* 239 */             needDeleteNum -= num;
/* 240 */             ItemOperateResult result = ItemInterface.removeItemByIdForIdip(roleid, storageid.intValue(), deleteItemId, num, tLogArg);
/*     */             
/* 242 */             if (!result.success())
/*     */             {
/* 244 */               return result.getResultEnum();
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 249 */             ItemOperateResult result = ItemInterface.removeItemByIdForIdip(roleid, storageid.intValue(), deleteItemId, needDeleteNum, tLogArg);
/*     */             
/* 251 */             return result.getResultEnum();
/*     */           } }
/*     */       } }
/* 254 */     return ItemOperateResult.ItemResultEnum.WRONG_NUMBER;
/*     */   }
/*     */   
/*     */   private int getNum(long roleid, int itemId, int bagType)
/*     */   {
/* 259 */     int value = 0;
/* 260 */     if (bagType == STORAGE.intValue())
/*     */     {
/* 262 */       value = getNumFormStorage(roleid, itemId);
/*     */     }
/*     */     else
/*     */     {
/* 266 */       value = ItemInterface.getItemNumberById(roleid, bagType, itemId, true);
/*     */     }
/* 268 */     return value;
/*     */   }
/*     */   
/*     */   private int getNumFormStorage(long roleid, int itemId)
/*     */   {
/* 273 */     int sum = 0;
/* 274 */     for (Integer storageid : ItemInterface.getAllStorageids())
/*     */     {
/*     */ 
/* 277 */       if (ItemInterface.isBagEnable(roleid, storageid.intValue(), true))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 283 */         int num = ItemInterface.getItemNumberById(roleid, storageid.intValue(), itemId, true);
/* 284 */         if (num > 0)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 289 */           sum += num; }
/*     */       } }
/* 291 */     return sum;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\DoDelItemHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */