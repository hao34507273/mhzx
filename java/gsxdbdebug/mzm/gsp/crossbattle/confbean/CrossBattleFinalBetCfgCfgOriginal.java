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
/*     */ public class CrossBattleFinalBetCfgCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, CrossBattleFinalBetCfgCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, CrossBattleFinalBetCfgCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public int activity_cfg_id;
/*     */   public int moduleid;
/*     */   public int bet_level_limit;
/*     */   public int tips_id;
/*     */   public int win_notice_mail_cfg_id;
/*     */   public int lose_notice_mail_cfg_id;
/*     */   public int tie_notice_mail_cfg_id;
/*     */   public int bet_fail_notice_mail_cfg_id;
/*     */   public double win_multiple;
/*     */   public int bet_cost_type;
/*     */   public int max_return_money_num;
/*     */   public int sortid;
/*     */   public int money_num;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  35 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  36 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  37 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  38 */     this.bet_level_limit = Integer.valueOf(rootElement.attributeValue("bet_level_limit")).intValue();
/*  39 */     this.tips_id = Integer.valueOf(rootElement.attributeValue("tips_id")).intValue();
/*  40 */     this.win_notice_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("win_notice_mail_cfg_id")).intValue();
/*  41 */     this.lose_notice_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("lose_notice_mail_cfg_id")).intValue();
/*  42 */     this.tie_notice_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("tie_notice_mail_cfg_id")).intValue();
/*  43 */     this.bet_fail_notice_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("bet_fail_notice_mail_cfg_id")).intValue();
/*  44 */     this.win_multiple = Double.valueOf(rootElement.attributeValue("win_multiple")).doubleValue();
/*  45 */     this.bet_cost_type = Integer.valueOf(rootElement.attributeValue("bet_cost_type")).intValue();
/*  46 */     this.max_return_money_num = Integer.valueOf(rootElement.attributeValue("max_return_money_num")).intValue();
/*  47 */     this.sortid = Integer.valueOf(rootElement.attributeValue("sortid")).intValue();
/*  48 */     this.money_num = Integer.valueOf(rootElement.attributeValue("money_num")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  53 */     _os_.marshal(this.id);
/*  54 */     _os_.marshal(this.activity_cfg_id);
/*  55 */     _os_.marshal(this.moduleid);
/*  56 */     _os_.marshal(this.bet_level_limit);
/*  57 */     _os_.marshal(this.tips_id);
/*  58 */     _os_.marshal(this.win_notice_mail_cfg_id);
/*  59 */     _os_.marshal(this.lose_notice_mail_cfg_id);
/*  60 */     _os_.marshal(this.tie_notice_mail_cfg_id);
/*  61 */     _os_.marshal(this.bet_fail_notice_mail_cfg_id);
/*  62 */     _os_.marshal(this.win_multiple);
/*  63 */     _os_.marshal(this.bet_cost_type);
/*  64 */     _os_.marshal(this.max_return_money_num);
/*  65 */     _os_.marshal(this.sortid);
/*  66 */     _os_.marshal(this.money_num);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  72 */     this.id = _os_.unmarshal_int();
/*  73 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  74 */     this.moduleid = _os_.unmarshal_int();
/*  75 */     this.bet_level_limit = _os_.unmarshal_int();
/*  76 */     this.tips_id = _os_.unmarshal_int();
/*  77 */     this.win_notice_mail_cfg_id = _os_.unmarshal_int();
/*  78 */     this.lose_notice_mail_cfg_id = _os_.unmarshal_int();
/*  79 */     this.tie_notice_mail_cfg_id = _os_.unmarshal_int();
/*  80 */     this.bet_fail_notice_mail_cfg_id = _os_.unmarshal_int();
/*  81 */     this.win_multiple = _os_.unmarshal_float();
/*  82 */     this.bet_cost_type = _os_.unmarshal_int();
/*  83 */     this.max_return_money_num = _os_.unmarshal_int();
/*  84 */     this.sortid = _os_.unmarshal_int();
/*  85 */     this.money_num = _os_.unmarshal_int();
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  91 */     String path = dir + "mzm.gsp.crossbattle.confbean.CrossBattleFinalBetCfgCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/*  95 */       all = new java.util.HashMap();
/*  96 */       SAXReader reader = new SAXReader();
/*  97 */       org.dom4j.Document doc = reader.read(new File(path));
/*  98 */       Element root = doc.getRootElement();
/*  99 */       List<?> nodeList = root.elements();
/* 100 */       int len = nodeList.size();
/* 101 */       for (int i = 0; i < len; i++)
/*     */       {
/* 103 */         Element elem = (Element)nodeList.get(i);
/* 104 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.CrossBattleFinalBetCfgCfgOriginal"))
/*     */         {
/*     */ 
/* 107 */           CrossBattleFinalBetCfgCfgOriginal obj = new CrossBattleFinalBetCfgCfgOriginal();
/* 108 */           obj.loadFromXml(elem);
/* 109 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 110 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 115 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, CrossBattleFinalBetCfgCfgOriginal> all)
/*     */   {
/* 121 */     String path = dir + "mzm.gsp.crossbattle.confbean.CrossBattleFinalBetCfgCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 125 */       SAXReader reader = new SAXReader();
/* 126 */       org.dom4j.Document doc = reader.read(new File(path));
/* 127 */       Element root = doc.getRootElement();
/* 128 */       List<?> nodeList = root.elements();
/* 129 */       int len = nodeList.size();
/* 130 */       for (int i = 0; i < len; i++)
/*     */       {
/* 132 */         Element elem = (Element)nodeList.get(i);
/* 133 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.CrossBattleFinalBetCfgCfgOriginal"))
/*     */         {
/*     */ 
/* 136 */           CrossBattleFinalBetCfgCfgOriginal obj = new CrossBattleFinalBetCfgCfgOriginal();
/* 137 */           obj.loadFromXml(elem);
/* 138 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 139 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 144 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 150 */     all = new java.util.HashMap();
/*     */     
/* 152 */     String path = dir + "mzm.gsp.crossbattle.confbean.CrossBattleFinalBetCfgCfgOriginal.bny";
/*     */     try
/*     */     {
/* 155 */       File file = new File(path);
/* 156 */       if (file.exists())
/*     */       {
/* 158 */         byte[] bytes = new byte['Ѐ'];
/* 159 */         FileInputStream fis = new FileInputStream(file);
/* 160 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 161 */         int len = 0;
/* 162 */         while ((len = fis.read(bytes)) > 0)
/* 163 */           baos.write(bytes, 0, len);
/* 164 */         fis.close();
/* 165 */         bytes = baos.toByteArray();
/* 166 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 167 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 169 */           _os_.unmarshal_int();
/* 170 */           _os_.unmarshal_int();
/* 171 */           _os_.unmarshal_int();
/*     */         }
/* 173 */         _os_.unmarshal_int();
/* 174 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 177 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 179 */           CrossBattleFinalBetCfgCfgOriginal _v_ = new CrossBattleFinalBetCfgCfgOriginal();
/* 180 */           _v_.unmarshal(_os_);
/* 181 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 182 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 187 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 192 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, CrossBattleFinalBetCfgCfgOriginal> all)
/*     */   {
/* 199 */     String path = dir + "mzm.gsp.crossbattle.confbean.CrossBattleFinalBetCfgCfgOriginal.bny";
/*     */     try
/*     */     {
/* 202 */       File file = new File(path);
/* 203 */       if (file.exists())
/*     */       {
/* 205 */         byte[] bytes = new byte['Ѐ'];
/* 206 */         FileInputStream fis = new FileInputStream(file);
/* 207 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 208 */         int len = 0;
/* 209 */         while ((len = fis.read(bytes)) > 0)
/* 210 */           baos.write(bytes, 0, len);
/* 211 */         fis.close();
/* 212 */         bytes = baos.toByteArray();
/* 213 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 214 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 216 */           _os_.unmarshal_int();
/* 217 */           _os_.unmarshal_int();
/* 218 */           _os_.unmarshal_int();
/*     */         }
/* 220 */         _os_.unmarshal_int();
/* 221 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 224 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 226 */           CrossBattleFinalBetCfgCfgOriginal _v_ = new CrossBattleFinalBetCfgCfgOriginal();
/* 227 */           _v_.unmarshal(_os_);
/* 228 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 229 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 234 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 239 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static CrossBattleFinalBetCfgCfgOriginal getOld(int key)
/*     */   {
/* 247 */     return (CrossBattleFinalBetCfgCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static CrossBattleFinalBetCfgCfgOriginal get(int key)
/*     */   {
/* 252 */     return (CrossBattleFinalBetCfgCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, CrossBattleFinalBetCfgCfgOriginal> getOldAll()
/*     */   {
/* 257 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, CrossBattleFinalBetCfgCfgOriginal> getAll()
/*     */   {
/* 262 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, CrossBattleFinalBetCfgCfgOriginal> newAll)
/*     */   {
/* 267 */     oldAll = all;
/* 268 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 273 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\CrossBattleFinalBetCfgCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */