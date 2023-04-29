/*     */ package mzm.gsp.role.multirank;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Nonerealtimefightvaluerankbackup;
/*     */ import xtable.Nonerealtimemultifightvaluerankbackup;
/*     */ import xtable.Nonerealtimeoccmfvrankbackup;
/*     */ 
/*     */ public class MergeRankBackUp
/*     */ {
/*  13 */   private static final Logger logger = Logger.getLogger(MergeRankBackUp.class);
/*     */   
/*  15 */   private static final MergeRankBackUp instance = new MergeRankBackUp();
/*     */   
/*     */   public static MergeRankBackUp getInstance()
/*     */   {
/*  19 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean mergeRoleRankBackUp()
/*     */   {
/*  29 */     boolean res = false;
/*  30 */     res = MergeRoleLvRankBackUp();
/*  31 */     res = MergeRoleFVRankBackUp();
/*  32 */     res = MergeRoleMFVRankBackUp();
/*  33 */     res = MergeRoleOccMFVRankBackUp();
/*  34 */     return res;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean MergeRoleLvRankBackUp()
/*     */   {
/*  44 */     boolean res = new MergeRoleLvRankBackUp(null).call();
/*  45 */     if (!res)
/*     */     {
/*  47 */       logger.error(String.format("[rank]MergeRankBackUp.MergeRoleLvRankBackUp@ MergeRoleLvRankBackUp err!", new Object[0]));
/*     */     }
/*  49 */     return res;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean MergeRoleFVRankBackUp()
/*     */   {
/*  59 */     boolean res = new MergeRoleFVRankBackUp(null).call();
/*  60 */     if (!res)
/*     */     {
/*  62 */       logger.error(String.format("[rank]MergeRankBackUp.MergeRoleFVRankBackUp@ MergeRoleFVRankBackUp err!", new Object[0]));
/*     */     }
/*  64 */     return res;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean MergeRoleMFVRankBackUp()
/*     */   {
/*  74 */     boolean res = new MergeRoleMFVRankBackUp(null).call();
/*  75 */     if (!res)
/*     */     {
/*  77 */       logger.error(String.format("[rank]MergeRankBackUp.MergeRoleMFVRankBackUp@ MergeRoleMFVRankBackUp err!", new Object[0]));
/*     */     }
/*  79 */     return res;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean MergeRoleOccMFVRankBackUp()
/*     */   {
/*  89 */     boolean res = new MergeRoleOccMFVRankBackUp(null).call();
/*  90 */     if (!res)
/*     */     {
/*  92 */       logger.error(String.format("[rank]MergeRankBackUp.MergeRoleOccMFVRankBackUp@merge role occ mfv rank backup err", new Object[0]));
/*     */     }
/*  94 */     return res;
/*     */   }
/*     */   
/*     */   private class MergeRoleLvRankBackUp extends LogicProcedure
/*     */   {
/*     */     private MergeRoleLvRankBackUp() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 103 */       long mainKey = MergeMain.getMainZoneid();
/* 104 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/* 106 */       lock(Nonerealtimefightvaluerankbackup.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/* 108 */       Nonerealtimefightvaluerankbackup.remove(Long.valueOf(viceKey));
/* 109 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private class MergeRoleFVRankBackUp
/*     */     extends LogicProcedure
/*     */   {
/*     */     private MergeRoleFVRankBackUp() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 120 */       long mainKey = MergeMain.getMainZoneid();
/* 121 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/* 123 */       lock(Nonerealtimefightvaluerankbackup.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/* 125 */       Nonerealtimefightvaluerankbackup.remove(Long.valueOf(viceKey));
/* 126 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private class MergeRoleMFVRankBackUp
/*     */     extends LogicProcedure
/*     */   {
/*     */     private MergeRoleMFVRankBackUp() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 137 */       long mainKey = MergeMain.getMainZoneid();
/* 138 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/* 140 */       lock(Nonerealtimemultifightvaluerankbackup.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/* 142 */       Nonerealtimemultifightvaluerankbackup.remove(Long.valueOf(viceKey));
/* 143 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private class MergeRoleOccMFVRankBackUp extends LogicProcedure
/*     */   {
/*     */     private MergeRoleOccMFVRankBackUp() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 153 */       long mainKey = MergeMain.getMainZoneid();
/* 154 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/* 156 */       lock(Nonerealtimeoccmfvrankbackup.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/* 158 */       Nonerealtimeoccmfvrankbackup.remove(Long.valueOf(viceKey));
/* 159 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\MergeRankBackUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */