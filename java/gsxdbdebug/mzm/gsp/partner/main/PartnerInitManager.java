/*    */ package mzm.gsp.partner.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.partner.confbean.SPartnerCfg;
/*    */ import mzm.gsp.partner.confbean.SPartnerLoveCfg;
/*    */ import mzm.gsp.partner.confbean.SPartnerSkillCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PartnerInitManager
/*    */ {
/* 17 */   private static PartnerInitManager instance = new PartnerInitManager();
/*    */   
/*    */   static PartnerInitManager getInstance()
/*    */   {
/* 21 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 28 */   private Map<Integer, PartnerCfg> partnerCfgMap = new HashMap();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 34 */   private Map<Integer, Love2RateCfg> LoveCfgMap = new HashMap();
/*    */   
/*    */ 
/*    */   public void init(Map<String, String> envs)
/*    */   {
/* 39 */     Map<Integer, SPartnerCfg> map = SPartnerCfg.getAll();
/* 40 */     Iterator<SPartnerCfg> it = map.values().iterator();
/* 41 */     while (it.hasNext())
/*    */     {
/* 43 */       SPartnerCfg partnerCfg = (SPartnerCfg)it.next();
/* 44 */       PartnerCfg cfg = new PartnerCfg(partnerCfg.templateId);
/* 45 */       this.partnerCfgMap.put(Integer.valueOf(cfg.getId()), cfg);
/*    */     }
/*    */     
/* 48 */     Map<Integer, SPartnerLoveCfg> sPartnerLoveCfg = SPartnerLoveCfg.getAll();
/* 49 */     Iterator<SPartnerLoveCfg> it_SPartnerLoveCfg = sPartnerLoveCfg.values().iterator();
/* 50 */     while (it_SPartnerLoveCfg.hasNext())
/*    */     {
/* 52 */       SPartnerLoveCfg partnerLoveCfg = (SPartnerLoveCfg)it_SPartnerLoveCfg.next();
/* 53 */       if (this.LoveCfgMap.containsKey(Integer.valueOf(partnerLoveCfg.id)))
/*    */       {
/* 55 */         throw new RuntimeException(" 1404_伙伴情缘表 id:包含了相同的id[" + partnerLoveCfg.id + "]");
/*    */       }
/*    */       
/*    */ 
/* 59 */       Love2RateCfg love2RateCfg = new Love2RateCfg(partnerLoveCfg.id);
/* 60 */       this.LoveCfgMap.put(Integer.valueOf(partnerLoveCfg.id), love2RateCfg);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getRealSkillId(int partnerSkillId)
/*    */   {
/* 75 */     SPartnerSkillCfg sPartnerSkillCfg = SPartnerSkillCfg.get(partnerSkillId);
/* 76 */     if (sPartnerSkillCfg == null)
/*    */     {
/* 78 */       return -1;
/*    */     }
/* 80 */     return sPartnerSkillCfg.skillId;
/*    */   }
/*    */   
/*    */   public Map<Integer, Love2RateCfg> getLoveCfgMap()
/*    */   {
/* 85 */     return this.LoveCfgMap;
/*    */   }
/*    */   
/*    */   public Map<Integer, PartnerCfg> getPartnerCfgMap()
/*    */   {
/* 90 */     return this.partnerCfgMap;
/*    */   }
/*    */   
/*    */   public PartnerCfg getPartnerCfg(int partnerId)
/*    */   {
/* 95 */     return (PartnerCfg)getPartnerCfgMap().get(Integer.valueOf(partnerId));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\PartnerInitManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */