/*     */ package mzm.gsp.crossbattle.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class CrossBattleVoteCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, CrossBattleVoteCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, CrossBattleVoteCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public int activity_cfg_id;
/*     */   public int vote_stage_moduleid;
/*     */   public int vote_level_limit;
/*     */   public int daily_vote_times_limit;
/*     */   public int vote_fix_award_id;
/*     */   public int canvass_trumpet_cfg_id;
/*     */   public int vote_stage_direct_promotion_corps_num;
/*     */   public int round_robin_stage_promotion_corps_num;
/*     */   public int round_robin_max_corps_num;
/*     */   public int vote_stage_direct_promotion_mail_cfg_id;
/*     */   public int vote_stage_most_votes_mail_cfg_id;
/*     */   public int vote_stage_round_robin_notice_mail_cfg_id;
/*     */   public int vote_stage_encourage_mail_cfg_id;
/*     */   public int vote_stage_rank_page_num;
/*     */   public int vote_stage_notice_mail_cfg_id;
/*     */   public int vote_stage_tips_id;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  38 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  39 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  40 */     this.vote_stage_moduleid = Integer.valueOf(rootElement.attributeValue("vote_stage_moduleid")).intValue();
/*  41 */     this.vote_level_limit = Integer.valueOf(rootElement.attributeValue("vote_level_limit")).intValue();
/*  42 */     this.daily_vote_times_limit = Integer.valueOf(rootElement.attributeValue("daily_vote_times_limit")).intValue();
/*  43 */     this.vote_fix_award_id = Integer.valueOf(rootElement.attributeValue("vote_fix_award_id")).intValue();
/*  44 */     this.canvass_trumpet_cfg_id = Integer.valueOf(rootElement.attributeValue("canvass_trumpet_cfg_id")).intValue();
/*  45 */     this.vote_stage_direct_promotion_corps_num = Integer.valueOf(rootElement.attributeValue("vote_stage_direct_promotion_corps_num")).intValue();
/*  46 */     this.round_robin_stage_promotion_corps_num = Integer.valueOf(rootElement.attributeValue("round_robin_stage_promotion_corps_num")).intValue();
/*  47 */     this.round_robin_max_corps_num = Integer.valueOf(rootElement.attributeValue("round_robin_max_corps_num")).intValue();
/*  48 */     this.vote_stage_direct_promotion_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("vote_stage_direct_promotion_mail_cfg_id")).intValue();
/*  49 */     this.vote_stage_most_votes_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("vote_stage_most_votes_mail_cfg_id")).intValue();
/*  50 */     this.vote_stage_round_robin_notice_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("vote_stage_round_robin_notice_mail_cfg_id")).intValue();
/*  51 */     this.vote_stage_encourage_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("vote_stage_encourage_mail_cfg_id")).intValue();
/*  52 */     this.vote_stage_rank_page_num = Integer.valueOf(rootElement.attributeValue("vote_stage_rank_page_num")).intValue();
/*  53 */     this.vote_stage_notice_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("vote_stage_notice_mail_cfg_id")).intValue();
/*  54 */     this.vote_stage_tips_id = Integer.valueOf(rootElement.attributeValue("vote_stage_tips_id")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  59 */     _os_.marshal(this.id);
/*  60 */     _os_.marshal(this.activity_cfg_id);
/*  61 */     _os_.marshal(this.vote_stage_moduleid);
/*  62 */     _os_.marshal(this.vote_level_limit);
/*  63 */     _os_.marshal(this.daily_vote_times_limit);
/*  64 */     _os_.marshal(this.vote_fix_award_id);
/*  65 */     _os_.marshal(this.canvass_trumpet_cfg_id);
/*  66 */     _os_.marshal(this.vote_stage_direct_promotion_corps_num);
/*  67 */     _os_.marshal(this.round_robin_stage_promotion_corps_num);
/*  68 */     _os_.marshal(this.round_robin_max_corps_num);
/*  69 */     _os_.marshal(this.vote_stage_direct_promotion_mail_cfg_id);
/*  70 */     _os_.marshal(this.vote_stage_most_votes_mail_cfg_id);
/*  71 */     _os_.marshal(this.vote_stage_round_robin_notice_mail_cfg_id);
/*  72 */     _os_.marshal(this.vote_stage_encourage_mail_cfg_id);
/*  73 */     _os_.marshal(this.vote_stage_rank_page_num);
/*  74 */     _os_.marshal(this.vote_stage_notice_mail_cfg_id);
/*  75 */     _os_.marshal(this.vote_stage_tips_id);
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  81 */     this.id = _os_.unmarshal_int();
/*  82 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  83 */     this.vote_stage_moduleid = _os_.unmarshal_int();
/*  84 */     this.vote_level_limit = _os_.unmarshal_int();
/*  85 */     this.daily_vote_times_limit = _os_.unmarshal_int();
/*  86 */     this.vote_fix_award_id = _os_.unmarshal_int();
/*  87 */     this.canvass_trumpet_cfg_id = _os_.unmarshal_int();
/*  88 */     this.vote_stage_direct_promotion_corps_num = _os_.unmarshal_int();
/*  89 */     this.round_robin_stage_promotion_corps_num = _os_.unmarshal_int();
/*  90 */     this.round_robin_max_corps_num = _os_.unmarshal_int();
/*  91 */     this.vote_stage_direct_promotion_mail_cfg_id = _os_.unmarshal_int();
/*  92 */     this.vote_stage_most_votes_mail_cfg_id = _os_.unmarshal_int();
/*  93 */     this.vote_stage_round_robin_notice_mail_cfg_id = _os_.unmarshal_int();
/*  94 */     this.vote_stage_encourage_mail_cfg_id = _os_.unmarshal_int();
/*  95 */     this.vote_stage_rank_page_num = _os_.unmarshal_int();
/*  96 */     this.vote_stage_notice_mail_cfg_id = _os_.unmarshal_int();
/*  97 */     this.vote_stage_tips_id = _os_.unmarshal_int();
/*  98 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 103 */     String path = dir + "mzm.gsp.crossbattle.confbean.CrossBattleVoteCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 107 */       all = new java.util.HashMap();
/* 108 */       SAXReader reader = new SAXReader();
/* 109 */       org.dom4j.Document doc = reader.read(new File(path));
/* 110 */       Element root = doc.getRootElement();
/* 111 */       List<?> nodeList = root.elements();
/* 112 */       int len = nodeList.size();
/* 113 */       for (int i = 0; i < len; i++)
/*     */       {
/* 115 */         Element elem = (Element)nodeList.get(i);
/* 116 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.CrossBattleVoteCfgOriginal"))
/*     */         {
/*     */ 
/* 119 */           CrossBattleVoteCfgOriginal obj = new CrossBattleVoteCfgOriginal();
/* 120 */           obj.loadFromXml(elem);
/* 121 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 122 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 127 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, CrossBattleVoteCfgOriginal> all)
/*     */   {
/* 133 */     String path = dir + "mzm.gsp.crossbattle.confbean.CrossBattleVoteCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 137 */       SAXReader reader = new SAXReader();
/* 138 */       org.dom4j.Document doc = reader.read(new File(path));
/* 139 */       Element root = doc.getRootElement();
/* 140 */       List<?> nodeList = root.elements();
/* 141 */       int len = nodeList.size();
/* 142 */       for (int i = 0; i < len; i++)
/*     */       {
/* 144 */         Element elem = (Element)nodeList.get(i);
/* 145 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.CrossBattleVoteCfgOriginal"))
/*     */         {
/*     */ 
/* 148 */           CrossBattleVoteCfgOriginal obj = new CrossBattleVoteCfgOriginal();
/* 149 */           obj.loadFromXml(elem);
/* 150 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 151 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 156 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 162 */     all = new java.util.HashMap();
/*     */     
/* 164 */     String path = dir + "mzm.gsp.crossbattle.confbean.CrossBattleVoteCfgOriginal.bny";
/*     */     try
/*     */     {
/* 167 */       File file = new File(path);
/* 168 */       if (file.exists())
/*     */       {
/* 170 */         byte[] bytes = new byte['Ѐ'];
/* 171 */         FileInputStream fis = new FileInputStream(file);
/* 172 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 173 */         int len = 0;
/* 174 */         while ((len = fis.read(bytes)) > 0)
/* 175 */           baos.write(bytes, 0, len);
/* 176 */         fis.close();
/* 177 */         bytes = baos.toByteArray();
/* 178 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 179 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 181 */           _os_.unmarshal_int();
/* 182 */           _os_.unmarshal_int();
/* 183 */           _os_.unmarshal_int();
/*     */         }
/* 185 */         _os_.unmarshal_int();
/* 186 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 189 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 191 */           CrossBattleVoteCfgOriginal _v_ = new CrossBattleVoteCfgOriginal();
/* 192 */           _v_.unmarshal(_os_);
/* 193 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 194 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 199 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 204 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, CrossBattleVoteCfgOriginal> all)
/*     */   {
/* 211 */     String path = dir + "mzm.gsp.crossbattle.confbean.CrossBattleVoteCfgOriginal.bny";
/*     */     try
/*     */     {
/* 214 */       File file = new File(path);
/* 215 */       if (file.exists())
/*     */       {
/* 217 */         byte[] bytes = new byte['Ѐ'];
/* 218 */         FileInputStream fis = new FileInputStream(file);
/* 219 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 220 */         int len = 0;
/* 221 */         while ((len = fis.read(bytes)) > 0)
/* 222 */           baos.write(bytes, 0, len);
/* 223 */         fis.close();
/* 224 */         bytes = baos.toByteArray();
/* 225 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 226 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 228 */           _os_.unmarshal_int();
/* 229 */           _os_.unmarshal_int();
/* 230 */           _os_.unmarshal_int();
/*     */         }
/* 232 */         _os_.unmarshal_int();
/* 233 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 236 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 238 */           CrossBattleVoteCfgOriginal _v_ = new CrossBattleVoteCfgOriginal();
/* 239 */           _v_.unmarshal(_os_);
/* 240 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 241 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 246 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 251 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static CrossBattleVoteCfgOriginal getOld(int key)
/*     */   {
/* 259 */     return (CrossBattleVoteCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static CrossBattleVoteCfgOriginal get(int key)
/*     */   {
/* 264 */     return (CrossBattleVoteCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, CrossBattleVoteCfgOriginal> getOldAll()
/*     */   {
/* 269 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, CrossBattleVoteCfgOriginal> getAll()
/*     */   {
/* 274 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, CrossBattleVoteCfgOriginal> newAll)
/*     */   {
/* 279 */     oldAll = all;
/* 280 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 285 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\CrossBattleVoteCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */