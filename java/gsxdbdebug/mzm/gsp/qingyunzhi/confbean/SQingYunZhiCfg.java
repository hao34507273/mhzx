/*     */ package mzm.gsp.qingyunzhi.confbean;
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
/*     */ public class SQingYunZhiCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SQingYunZhiCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SQingYunZhiCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templatename;
/*     */   public int chapterNum;
/*     */   public String chapterName;
/*     */   public int openLevel;
/*     */   public int reLevelHigh;
/*     */   public int reLevellow;
/*     */   public int challengeType;
/*     */   public int sectionNum;
/*     */   public String sectionName;
/*     */   public int reFightValue;
/*     */   public int fightCfgId;
/*     */   public int fixAwardId;
/*     */   public boolean isAwardAccessTip;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  35 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  36 */     this.templatename = rootElement.attributeValue("templatename");
/*  37 */     this.chapterNum = Integer.valueOf(rootElement.attributeValue("chapterNum")).intValue();
/*  38 */     this.chapterName = rootElement.attributeValue("chapterName");
/*  39 */     this.openLevel = Integer.valueOf(rootElement.attributeValue("openLevel")).intValue();
/*  40 */     this.reLevelHigh = Integer.valueOf(rootElement.attributeValue("reLevelHigh")).intValue();
/*  41 */     this.reLevellow = Integer.valueOf(rootElement.attributeValue("reLevellow")).intValue();
/*  42 */     this.challengeType = Integer.valueOf(rootElement.attributeValue("challengeType")).intValue();
/*  43 */     this.sectionNum = Integer.valueOf(rootElement.attributeValue("sectionNum")).intValue();
/*  44 */     this.sectionName = rootElement.attributeValue("sectionName");
/*  45 */     this.reFightValue = Integer.valueOf(rootElement.attributeValue("reFightValue")).intValue();
/*  46 */     this.fightCfgId = Integer.valueOf(rootElement.attributeValue("fightCfgId")).intValue();
/*  47 */     this.fixAwardId = Integer.valueOf(rootElement.attributeValue("fixAwardId")).intValue();
/*  48 */     this.isAwardAccessTip = Boolean.valueOf(rootElement.attributeValue("isAwardAccessTip")).booleanValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  53 */     _os_.marshal(this.id);
/*  54 */     _os_.marshal(this.templatename, "UTF-8");
/*  55 */     _os_.marshal(this.chapterNum);
/*  56 */     _os_.marshal(this.chapterName, "UTF-8");
/*  57 */     _os_.marshal(this.openLevel);
/*  58 */     _os_.marshal(this.reLevelHigh);
/*  59 */     _os_.marshal(this.reLevellow);
/*  60 */     _os_.marshal(this.challengeType);
/*  61 */     _os_.marshal(this.sectionNum);
/*  62 */     _os_.marshal(this.sectionName, "UTF-8");
/*  63 */     _os_.marshal(this.reFightValue);
/*  64 */     _os_.marshal(this.fightCfgId);
/*  65 */     _os_.marshal(this.fixAwardId);
/*  66 */     _os_.marshal(this.isAwardAccessTip);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  72 */     this.id = _os_.unmarshal_int();
/*  73 */     this.templatename = _os_.unmarshal_String("UTF-8");
/*  74 */     this.chapterNum = _os_.unmarshal_int();
/*  75 */     this.chapterName = _os_.unmarshal_String("UTF-8");
/*  76 */     this.openLevel = _os_.unmarshal_int();
/*  77 */     this.reLevelHigh = _os_.unmarshal_int();
/*  78 */     this.reLevellow = _os_.unmarshal_int();
/*  79 */     this.challengeType = _os_.unmarshal_int();
/*  80 */     this.sectionNum = _os_.unmarshal_int();
/*  81 */     this.sectionName = _os_.unmarshal_String("UTF-8");
/*  82 */     this.reFightValue = _os_.unmarshal_int();
/*  83 */     this.fightCfgId = _os_.unmarshal_int();
/*  84 */     this.fixAwardId = _os_.unmarshal_int();
/*  85 */     this.isAwardAccessTip = _os_.unmarshal_boolean();
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  91 */     String path = dir + "mzm.gsp.qingyunzhi.confbean.SQingYunZhiCfg.xml";
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
/* 104 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.qingyunzhi.confbean.SQingYunZhiCfg"))
/*     */         {
/*     */ 
/* 107 */           SQingYunZhiCfg obj = new SQingYunZhiCfg();
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
/*     */   public static void reLoadXml(String dir, Map<Integer, SQingYunZhiCfg> all)
/*     */   {
/* 121 */     String path = dir + "mzm.gsp.qingyunzhi.confbean.SQingYunZhiCfg.xml";
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
/* 133 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.qingyunzhi.confbean.SQingYunZhiCfg"))
/*     */         {
/*     */ 
/* 136 */           SQingYunZhiCfg obj = new SQingYunZhiCfg();
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
/* 152 */     String path = dir + "mzm.gsp.qingyunzhi.confbean.SQingYunZhiCfg.bny";
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
/* 179 */           SQingYunZhiCfg _v_ = new SQingYunZhiCfg();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, SQingYunZhiCfg> all)
/*     */   {
/* 199 */     String path = dir + "mzm.gsp.qingyunzhi.confbean.SQingYunZhiCfg.bny";
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
/* 226 */           SQingYunZhiCfg _v_ = new SQingYunZhiCfg();
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
/*     */   public static SQingYunZhiCfg getOld(int key)
/*     */   {
/* 247 */     return (SQingYunZhiCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SQingYunZhiCfg get(int key)
/*     */   {
/* 252 */     return (SQingYunZhiCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SQingYunZhiCfg> getOldAll()
/*     */   {
/* 257 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SQingYunZhiCfg> getAll()
/*     */   {
/* 262 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SQingYunZhiCfg> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyunzhi\confbean\SQingYunZhiCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */