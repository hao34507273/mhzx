/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.PetYaoLiRankData;
/*     */ import mzm.gsp.pet.SGetPetYaoLiRankRes;
/*     */ import mzm.gsp.role.main.Role;
/*     */ 
/*     */ public class PCGetYaoliRankReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private int fromNo;
/*     */   private int toNO;
/*     */   
/*     */   public PCGetYaoliRankReq(long roleid, int fromNo, int toNo)
/*     */   {
/*  21 */     this.roleid = roleid;
/*  22 */     this.fromNo = fromNo;
/*  23 */     this.toNO = toNo;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  29 */     if (this.fromNo <= 0) {
/*  30 */       return false;
/*     */     }
/*  32 */     if (this.fromNo > this.toNO) {
/*  33 */       return false;
/*     */     }
/*  35 */     List<PetYaoLiChart> petYaoLiCharts = NoneRealPetYaoLiRankManager.getInstance().getRankObjs(this.fromNo - 1, this.toNO - 1);
/*     */     
/*  37 */     SGetPetYaoLiRankRes sGetPetYaoLiRankRes = new SGetPetYaoLiRankRes();
/*  38 */     sGetPetYaoLiRankRes.myno = 0;
/*  39 */     Map<Long, Integer> rankChangeMap = NoneRealPetYaoLiRankManager.getInstance().getCacheRankChangeMap();
/*  40 */     for (int i = 0; i < petYaoLiCharts.size(); i++) {
/*  41 */       PetYaoLiChart petYaoLiChart = (PetYaoLiChart)petYaoLiCharts.get(i);
/*  42 */       PetYaoLiRankData petYaoLiRankData = new PetYaoLiRankData();
/*  43 */       Role role = mzm.gsp.role.main.RoleInterface.getRole(petYaoLiChart.getRoleId(), false);
/*  44 */       if (role == null) {
/*  45 */         this.fromNo -= 1;
/*     */       }
/*     */       else {
/*  48 */         Pet pet = PetInterface.getPetById(petYaoLiChart.getRoleId(), petYaoLiChart.getPetId());
/*  49 */         if (pet == null)
/*     */         {
/*  51 */           petYaoLiRankData.isexit = 0;
/*  52 */           petYaoLiRankData.no = (this.fromNo + i);
/*  53 */           sGetPetYaoLiRankRes.ranklist.add(petYaoLiRankData);
/*     */         }
/*     */         else {
/*  56 */           petYaoLiRankData.isexit = 1;
/*  57 */           petYaoLiRankData.no = (this.fromNo + i);
/*  58 */           petYaoLiRankData.roleid = petYaoLiChart.getRoleId();
/*  59 */           petYaoLiRankData.petid = petYaoLiChart.getPetId();
/*  60 */           petYaoLiRankData.petname = pet.getName();
/*  61 */           petYaoLiRankData.rolename = role.getName();
/*  62 */           petYaoLiRankData.yaoli = petYaoLiChart.getYaoLiValue();
/*     */           
/*  64 */           Integer change = (Integer)rankChangeMap.get(petYaoLiChart.getKey());
/*  65 */           if (change != null) {
/*  66 */             petYaoLiRankData.step = change.intValue();
/*     */           }
/*  68 */           petYaoLiRankData.templateid = pet.getCfgId();
/*     */           
/*  70 */           sGetPetYaoLiRankRes.ranklist.add(petYaoLiRankData);
/*     */         }
/*     */       } }
/*  73 */     Set<Long> petlist = PetInterface.getPetList(this.roleid, false);
/*  74 */     if ((null == petlist) || (petlist.size() == 0)) {
/*  75 */       sGetPetYaoLiRankRes.myno = -1;
/*     */     } else {
/*  77 */       int rank = -1;
/*  78 */       int temp = -1;
/*  79 */       for (Iterator i$ = petlist.iterator(); i$.hasNext();) { long peitid = ((Long)i$.next()).longValue();
/*  80 */         temp = NoneRealPetYaoLiRankManager.getInstance().getRank(Long.valueOf(peitid));
/*  81 */         if (temp > -1) {
/*  82 */           if (rank == -1) {
/*  83 */             rank = temp;
/*     */           }
/*  85 */           else if (rank > temp) {
/*  86 */             rank = temp;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  93 */       if (rank != -1) {
/*  94 */         sGetPetYaoLiRankRes.myno = (rank + 1);
/*     */       } else {
/*  96 */         sGetPetYaoLiRankRes.myno = -1;
/*     */       }
/*     */     }
/*     */     
/* 100 */     if (sGetPetYaoLiRankRes.myno == 0) {
/* 101 */       sGetPetYaoLiRankRes.myno = -1;
/*     */     }
/* 103 */     OnlineManager.getInstance().send(this.roleid, sGetPetYaoLiRankRes);
/* 104 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PCGetYaoliRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */