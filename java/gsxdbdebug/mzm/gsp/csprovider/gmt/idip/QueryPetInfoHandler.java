/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import idip.PetInfoDet;
/*     */ import idip.QueryPetInfoRsp;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.pet.PetInfo;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class QueryPetInfoHandler implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*     */   {
/*  21 */     String userid = (String)params.get(0);
/*  22 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(1));
/*  23 */     int targetPetCfgid = Integer.parseInt((String)params.get(2));
/*     */     
/*  25 */     xbean.User xUser = xtable.User.get(userid);
/*  26 */     if (null == xUser)
/*     */     {
/*  28 */       int retcode = Retcode.ACCOUNT_NOT_EXIST.value;
/*  29 */       rsp.retcode = retcode;
/*  30 */       Response response = IdipGmtUtil.getResponse(retcode, "user not found");
/*  31 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  33 */       GameServer.logger().error(String.format("[gmt]QueryPetInfoHandler.execute@user not found|userid=%s|roleid=%d|target_pet_cfgid=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(targetPetCfgid) }));
/*     */       
/*     */ 
/*  36 */       return;
/*     */     }
/*     */     
/*  39 */     if ((!mzm.gsp.role.main.RoleInterface.isRoleExist(roleid, true)) || (!xUser.getRoleids().contains(Long.valueOf(roleid))))
/*     */     {
/*  41 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  42 */       rsp.retcode = retcode;
/*  43 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  44 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  46 */       GameServer.logger().error(String.format("[gmt]QueryPetInfoHandler.execute@role not found|userid=%s|roleid=%d|target_pet_cfgid=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(targetPetCfgid) }));
/*     */       
/*     */ 
/*  49 */       return;
/*     */     }
/*     */     
/*  52 */     if (targetPetCfgid != 0)
/*     */     {
/*     */ 
/*  55 */       querySinglePetInfo(userid, roleid, targetPetCfgid, rsp);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  60 */       queryAllPetInfo(userid, roleid, rsp);
/*     */     }
/*     */     
/*  63 */     GameServer.logger().info(String.format("[gmt]QueryPetInfoHandler.execute@query pet info success|userid=%s|roleid=%d|target_pet_cfgid=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(targetPetCfgid) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean queryAllPetInfo(String userid, long roleid, DataBetweenCspAndGame_Re rsp)
/*     */     throws UnsupportedEncodingException
/*     */   {
/*  72 */     QueryPetInfoRsp queryPetInfoRsp = new QueryPetInfoRsp();
/*  73 */     List<PetInfo> petInfoList = PetInterface.getPetListInBagAndDepot(roleid);
/*  74 */     for (PetInfo petInfo : petInfoList)
/*     */     {
/*  76 */       PetInfoDet petInfoDetail = new PetInfoDet();
/*  77 */       fillPetInfoDetail(petInfo, petInfoDetail);
/*  78 */       queryPetInfoRsp.PetInfo.add(petInfoDetail);
/*  79 */       queryPetInfoRsp.PetInfo_count += 1;
/*  80 */       if (queryPetInfoRsp.PetInfo_count >= 14)
/*     */       {
/*  82 */         GameServer.logger().warn(String.format("[gmt]QueryPetInfoHandler.queryAllPetInfo@pet size >= MAX_PETINFO_NUM|pet_size=%d|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(roleid) }));
/*     */         
/*     */ 
/*     */ 
/*  86 */         break;
/*     */       }
/*     */     }
/*     */     
/*  90 */     rsp.retcode = Retcode.SUCCESS.value;
/*  91 */     Response response = new Response();
/*  92 */     response.data = queryPetInfoRsp;
/*  93 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/*  95 */     return true;
/*     */   }
/*     */   
/*     */   public boolean querySinglePetInfo(String userid, long roleid, int petCfgId, DataBetweenCspAndGame_Re rsp)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 101 */     if (!PetInterface.isPetCfgExist(petCfgId))
/*     */     {
/* 103 */       rsp.retcode = Retcode.QUERY_PET_CFG_NOT_EXIST.value;
/* 104 */       rsp.repdata.setString("query pet cfg id not exist");
/*     */       
/* 106 */       GameServer.logger().error(String.format("[gmt]QueryPetInfoHandler.querySinglePetInfo@query pet cfg id not exist|userid=%s|roleid=%d|pet_cfgid=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(petCfgId) }));
/*     */       
/*     */ 
/*     */ 
/* 110 */       return false;
/*     */     }
/*     */     
/* 113 */     if (!PetInterface.isPetCfgIdExistInBagAndDepot(roleid, petCfgId))
/*     */     {
/* 115 */       rsp.retcode = Retcode.QUERY_PET_NOT_HAS_THE_PET.value;
/* 116 */       rsp.repdata.setString("role not has the pet");
/*     */       
/* 118 */       GameServer.logger().error(String.format("[gmt]QueryPetInfoHandler.querySinglePetInfo@role not has the pet|userid=%s|roleid=%d|pet_cfgid=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(petCfgId) }));
/*     */       
/*     */ 
/*     */ 
/* 122 */       return false;
/*     */     }
/*     */     
/* 125 */     QueryPetInfoRsp queryPetInfoRsp = new QueryPetInfoRsp();
/* 126 */     PetInfo petInfo = PetInterface.getPetInfoByCfgId(roleid, petCfgId);
/* 127 */     PetInfoDet petInfoDetail = new PetInfoDet();
/* 128 */     fillPetInfoDetail(petInfo, petInfoDetail);
/* 129 */     queryPetInfoRsp.PetInfo_count = 1;
/* 130 */     queryPetInfoRsp.PetInfo.add(petInfoDetail);
/*     */     
/* 132 */     rsp.retcode = Retcode.SUCCESS.value;
/* 133 */     Response response = new Response();
/* 134 */     response.data = queryPetInfoRsp;
/* 135 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 137 */     return true;
/*     */   }
/*     */   
/*     */   private void fillPetInfoDetail(PetInfo petInfo, PetInfoDet petInfoDetail)
/*     */   {
/* 142 */     petInfoDetail.Type = petInfo.typeid;
/* 143 */     petInfoDetail.PetName = petInfo.petname;
/* 144 */     petInfoDetail.Exp = petInfo.exp;
/* 145 */     petInfoDetail.PetModID = petInfo.typeid;
/* 146 */     petInfoDetail.PetExaID = ((int)petInfo.petid);
/* 147 */     petInfoDetail.Level = petInfo.petlevel;
/* 148 */     petInfoDetail.PhysicalDefense = petInfo.phydef;
/* 149 */     petInfoDetail.FaDefense = petInfo.magdef;
/* 150 */     petInfoDetail.blood = petInfo.hp;
/* 151 */     petInfoDetail.Mana = petInfo.mp;
/* 152 */     petInfoDetail.SkillNum = petInfo.skillidlist.size();
/* 153 */     petInfoDetail.Demon = petInfo.yaoli;
/* 154 */     petInfoDetail.Growth = petInfo.grow;
/* 155 */     petInfoDetail.Life = petInfo.life;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\QueryPetInfoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */