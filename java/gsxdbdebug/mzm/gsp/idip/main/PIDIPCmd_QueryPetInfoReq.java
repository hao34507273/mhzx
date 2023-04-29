/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.IDIPCmd_QueryPetInfoReq;
/*     */ import idip.IDIPPacket_QueryPetInfoReq;
/*     */ import idip.IDIPPacket_QueryPetInfoRsp;
/*     */ import idip.PetInfoDet;
/*     */ import idip.QueryPetInfoReq;
/*     */ import idip.QueryPetInfoRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import idip.core.Utils;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.pet.PetInfo;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_QueryPetInfoReq extends PIDIPCmd<IDIPCmd_QueryPetInfoReq>
/*     */ {
/*     */   public PIDIPCmd_QueryPetInfoReq(IDIPCmd_QueryPetInfoReq cmd)
/*     */   {
/*  23 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean handle()
/*     */     throws Exception
/*     */   {
/*  29 */     String openId = ((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).OpenId;
/*  30 */     int areaId = ((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).AreaId;
/*  31 */     int partition = ((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).Partition;
/*     */     
/*  33 */     String userId = Utils.getUserId(openId, areaId, partition);
/*     */     
/*  35 */     xbean.User xUser = xtable.User.get(userId);
/*  36 */     if (null == xUser)
/*     */     {
/*  38 */       ((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.Result = 1;
/*  39 */       ((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/*  40 */       ((IDIPCmd_QueryPetInfoReq)this.cmd).sendResponse();
/*     */       
/*  42 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryPetInfoReq.handle@query userid empty|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%s|pet_id=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).PlatId), ((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).RoleId, Integer.valueOf(((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).PetModID) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  47 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  51 */     if (((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).RoleId.length() > 32)
/*     */     {
/*  53 */       ((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.Result = 1;
/*  54 */       ((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.RetErrMsg = String.format("roleid length > %d", new Object[] { Integer.valueOf(32) });
/*  55 */       ((IDIPCmd_QueryPetInfoReq)this.cmd).sendResponse();
/*     */       
/*  57 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryPetInfoReq.handle@roleId length > MAX_ROLEID_LEN|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%s|pet_id=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).PlatId), ((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).RoleId, Integer.valueOf(((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).PetModID) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     long roleId = -1L;
/*     */     try
/*     */     {
/*  68 */       roleId = Long.parseLong(((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).RoleId);
/*     */     }
/*     */     catch (NumberFormatException e)
/*     */     {
/*  72 */       ((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.Result = 1;
/*  73 */       ((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.RetErrMsg = "roleid format error";
/*  74 */       ((IDIPCmd_QueryPetInfoReq)this.cmd).sendResponse();
/*     */       
/*  76 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryPetInfoReq.handle@query roleid empty|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|role_id=%s|pet_id=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), ((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).RoleId, Integer.valueOf(((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).PetModID) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     if ((!mzm.gsp.role.main.RoleInterface.isRoleExist(roleId, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleId))))
/*     */     {
/*  86 */       ((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.Result = 1;
/*  87 */       ((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.RetErrMsg = "query roleid empty";
/*  88 */       ((IDIPCmd_QueryPetInfoReq)this.cmd).sendResponse();
/*     */       
/*  90 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryPetInfoReq.handle@query roleid empty|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|role_id=%d|pet_id=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Long.valueOf(roleId), Integer.valueOf(((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).PetModID) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  95 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  99 */     int targetCfgId = ((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).PetModID;
/*     */     
/*     */     List<PetInfo> petInfoList;
/* 102 */     if (targetCfgId != 0)
/*     */     {
/* 104 */       boolean querySignalPetResult = querySinglePetInfo(userId, roleId, targetCfgId);
/* 105 */       if (!querySignalPetResult)
/*     */       {
/* 107 */         return false;
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/* 113 */       petInfoList = PetInterface.getPetListInBagAndDepot(roleId);
/* 114 */       for (PetInfo petInfo : petInfoList)
/*     */       {
/* 116 */         PetInfoDet petInfoDetail = new PetInfoDet();
/* 117 */         fillPetInfoDetail(petInfo, petInfoDetail);
/*     */         
/* 119 */         ((QueryPetInfoRsp)((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).body).PetInfo.add(petInfoDetail);
/* 120 */         ((QueryPetInfoRsp)((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).body).PetInfo_count += 1;
/* 121 */         if (((QueryPetInfoRsp)((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).body).PetInfo_count >= 14)
/*     */         {
/* 123 */           GameServer.logger().warn(String.format("[idip]PIDIPCmd_QueryPetInfoReq.handle@query pet success,but pet size is too many|max_pet_info_num=%d|pet_size=%d|user_id=%s|area_id=%d|plat_id=%d|role_id=%d|pet_id=%d", new Object[] { Integer.valueOf(14), Integer.valueOf(petInfoList.size()), userId, Integer.valueOf(areaId), Byte.valueOf(((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Integer.valueOf(((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).PetModID) }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 128 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 133 */     ((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.Result = 0;
/* 134 */     ((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 135 */     ((IDIPCmd_QueryPetInfoReq)this.cmd).sendResponse();
/*     */     
/* 137 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_QueryPetInfoReq.handle@query pet success|user_id=%s|area_id=%d|plat_id=%d|role_id=%d|pet_id=%d", new Object[] { userId, Integer.valueOf(areaId), Byte.valueOf(((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Integer.valueOf(((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).PetModID) }));
/*     */     
/*     */ 
/*     */ 
/* 141 */     return true;
/*     */   }
/*     */   
/*     */   public boolean querySinglePetInfo(String userId, long roleId, int petCfgId)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 147 */     if (!PetInterface.isPetCfgExist(petCfgId))
/*     */     {
/* 149 */       ((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.Result = 64476;
/* 150 */       ((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.RetErrMsg = "query pet cfg id not exist";
/* 151 */       ((IDIPCmd_QueryPetInfoReq)this.cmd).sendResponse();
/*     */       
/* 153 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryPetInfoReq.querySinglePetInfo@query pet cfg id not exist|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|role_id=%d|pet_id=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).AreaId), Long.valueOf(roleId), Integer.valueOf(((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).PetModID) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 158 */       return false;
/*     */     }
/*     */     
/* 161 */     if (!PetInterface.isPetCfgIdExistInBagAndDepot(roleId, petCfgId))
/*     */     {
/* 163 */       ((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.Result = 64475;
/* 164 */       ((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.RetErrMsg = "role not has the pet";
/* 165 */       ((IDIPCmd_QueryPetInfoReq)this.cmd).sendResponse();
/*     */       
/* 167 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_QueryPetInfoReq.querySinglePetInfo@role not has the pet|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d|role_id=%d|pet_id=%d", new Object[] { Integer.valueOf(((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.Result), ((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).AreaId), Byte.valueOf(((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).PlatId), Long.valueOf(roleId), Integer.valueOf(((QueryPetInfoReq)((IDIPPacket_QueryPetInfoReq)((IDIPCmd_QueryPetInfoReq)this.cmd).req).body).PetModID) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 172 */       return false;
/*     */     }
/*     */     
/* 175 */     PetInfo petInfo = PetInterface.getPetInfoByCfgId(roleId, petCfgId);
/* 176 */     PetInfoDet petInfoDetail = new PetInfoDet();
/* 177 */     fillPetInfoDetail(petInfo, petInfoDetail);
/*     */     
/* 179 */     ((QueryPetInfoRsp)((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).body).PetInfo_count = 1;
/* 180 */     ((QueryPetInfoRsp)((IDIPPacket_QueryPetInfoRsp)((IDIPCmd_QueryPetInfoReq)this.cmd).rsp).body).PetInfo.add(petInfoDetail);
/*     */     
/* 182 */     return true;
/*     */   }
/*     */   
/*     */   private void fillPetInfoDetail(PetInfo petInfo, PetInfoDet petInfoDetail)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 188 */     petInfoDetail.Type = petInfo.typeid;
/* 189 */     petInfoDetail.PetName = Utils.urlEncode1738(petInfo.petname);
/* 190 */     petInfoDetail.Exp = petInfo.exp;
/* 191 */     petInfoDetail.PetModID = petInfo.typeid;
/* 192 */     petInfoDetail.PetExaID = ((int)petInfo.petid);
/* 193 */     petInfoDetail.Level = petInfo.petlevel;
/* 194 */     petInfoDetail.PhysicalDefense = petInfo.phydef;
/* 195 */     petInfoDetail.FaDefense = petInfo.magdef;
/* 196 */     petInfoDetail.blood = petInfo.hp;
/* 197 */     petInfoDetail.Mana = petInfo.mp;
/* 198 */     petInfoDetail.SkillNum = petInfo.skillidlist.size();
/* 199 */     petInfoDetail.Demon = petInfo.yaoli;
/* 200 */     petInfoDetail.Growth = petInfo.grow;
/* 201 */     petInfoDetail.Life = petInfo.life;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_QueryPetInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */