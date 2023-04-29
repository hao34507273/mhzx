/*     */ package mzm.gsp.pet.confbean;
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
/*     */ public class SPetJinJieCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SPetJinJieCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SPetJinJieCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int petCfgId;
/*     */   public int stage;
/*     */   public int upStageNeedLevel;
/*     */   public int itemType;
/*     */   public int priceItemId;
/*     */   public int itemNum;
/*     */   public int growAddRate;
/*     */   public int hpAptAdd;
/*     */   public int phyAtkAptAdd;
/*     */   public int magAtkAptAdd;
/*     */   public int phyDefAptAdd;
/*     */   public int magDefAptAdd;
/*     */   public int speedAptAdd;
/*     */   public int petJinJieSkillCfgId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  36 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  37 */     this.petCfgId = Integer.valueOf(rootElement.attributeValue("petCfgId")).intValue();
/*  38 */     this.stage = Integer.valueOf(rootElement.attributeValue("stage")).intValue();
/*  39 */     this.upStageNeedLevel = Integer.valueOf(rootElement.attributeValue("upStageNeedLevel")).intValue();
/*  40 */     this.itemType = Integer.valueOf(rootElement.attributeValue("itemType")).intValue();
/*  41 */     this.priceItemId = Integer.valueOf(rootElement.attributeValue("priceItemId")).intValue();
/*  42 */     this.itemNum = Integer.valueOf(rootElement.attributeValue("itemNum")).intValue();
/*  43 */     this.growAddRate = Integer.valueOf(rootElement.attributeValue("growAddRate")).intValue();
/*  44 */     this.hpAptAdd = Integer.valueOf(rootElement.attributeValue("hpAptAdd")).intValue();
/*  45 */     this.phyAtkAptAdd = Integer.valueOf(rootElement.attributeValue("phyAtkAptAdd")).intValue();
/*  46 */     this.magAtkAptAdd = Integer.valueOf(rootElement.attributeValue("magAtkAptAdd")).intValue();
/*  47 */     this.phyDefAptAdd = Integer.valueOf(rootElement.attributeValue("phyDefAptAdd")).intValue();
/*  48 */     this.magDefAptAdd = Integer.valueOf(rootElement.attributeValue("magDefAptAdd")).intValue();
/*  49 */     this.speedAptAdd = Integer.valueOf(rootElement.attributeValue("speedAptAdd")).intValue();
/*  50 */     this.petJinJieSkillCfgId = Integer.valueOf(rootElement.attributeValue("petJinJieSkillCfgId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  55 */     _os_.marshal(this.id);
/*  56 */     _os_.marshal(this.petCfgId);
/*  57 */     _os_.marshal(this.stage);
/*  58 */     _os_.marshal(this.upStageNeedLevel);
/*  59 */     _os_.marshal(this.itemType);
/*  60 */     _os_.marshal(this.priceItemId);
/*  61 */     _os_.marshal(this.itemNum);
/*  62 */     _os_.marshal(this.growAddRate);
/*  63 */     _os_.marshal(this.hpAptAdd);
/*  64 */     _os_.marshal(this.phyAtkAptAdd);
/*  65 */     _os_.marshal(this.magAtkAptAdd);
/*  66 */     _os_.marshal(this.phyDefAptAdd);
/*  67 */     _os_.marshal(this.magDefAptAdd);
/*  68 */     _os_.marshal(this.speedAptAdd);
/*  69 */     _os_.marshal(this.petJinJieSkillCfgId);
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     this.id = _os_.unmarshal_int();
/*  76 */     this.petCfgId = _os_.unmarshal_int();
/*  77 */     this.stage = _os_.unmarshal_int();
/*  78 */     this.upStageNeedLevel = _os_.unmarshal_int();
/*  79 */     this.itemType = _os_.unmarshal_int();
/*  80 */     this.priceItemId = _os_.unmarshal_int();
/*  81 */     this.itemNum = _os_.unmarshal_int();
/*  82 */     this.growAddRate = _os_.unmarshal_int();
/*  83 */     this.hpAptAdd = _os_.unmarshal_int();
/*  84 */     this.phyAtkAptAdd = _os_.unmarshal_int();
/*  85 */     this.magAtkAptAdd = _os_.unmarshal_int();
/*  86 */     this.phyDefAptAdd = _os_.unmarshal_int();
/*  87 */     this.magDefAptAdd = _os_.unmarshal_int();
/*  88 */     this.speedAptAdd = _os_.unmarshal_int();
/*  89 */     this.petJinJieSkillCfgId = _os_.unmarshal_int();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  95 */     String path = dir + "mzm.gsp.pet.confbean.SPetJinJieCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  99 */       all = new java.util.HashMap();
/* 100 */       SAXReader reader = new SAXReader();
/* 101 */       org.dom4j.Document doc = reader.read(new File(path));
/* 102 */       Element root = doc.getRootElement();
/* 103 */       List<?> nodeList = root.elements();
/* 104 */       int len = nodeList.size();
/* 105 */       for (int i = 0; i < len; i++)
/*     */       {
/* 107 */         Element elem = (Element)nodeList.get(i);
/* 108 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.pet.confbean.SPetJinJieCfg"))
/*     */         {
/*     */ 
/* 111 */           SPetJinJieCfg obj = new SPetJinJieCfg();
/* 112 */           obj.loadFromXml(elem);
/* 113 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 114 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 119 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SPetJinJieCfg> all)
/*     */   {
/* 125 */     String path = dir + "mzm.gsp.pet.confbean.SPetJinJieCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 129 */       SAXReader reader = new SAXReader();
/* 130 */       org.dom4j.Document doc = reader.read(new File(path));
/* 131 */       Element root = doc.getRootElement();
/* 132 */       List<?> nodeList = root.elements();
/* 133 */       int len = nodeList.size();
/* 134 */       for (int i = 0; i < len; i++)
/*     */       {
/* 136 */         Element elem = (Element)nodeList.get(i);
/* 137 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.pet.confbean.SPetJinJieCfg"))
/*     */         {
/*     */ 
/* 140 */           SPetJinJieCfg obj = new SPetJinJieCfg();
/* 141 */           obj.loadFromXml(elem);
/* 142 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 143 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 148 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 154 */     all = new java.util.HashMap();
/*     */     
/* 156 */     String path = dir + "mzm.gsp.pet.confbean.SPetJinJieCfg.bny";
/*     */     try
/*     */     {
/* 159 */       File file = new File(path);
/* 160 */       if (file.exists())
/*     */       {
/* 162 */         byte[] bytes = new byte['Ѐ'];
/* 163 */         FileInputStream fis = new FileInputStream(file);
/* 164 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 165 */         int len = 0;
/* 166 */         while ((len = fis.read(bytes)) > 0)
/* 167 */           baos.write(bytes, 0, len);
/* 168 */         fis.close();
/* 169 */         bytes = baos.toByteArray();
/* 170 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 171 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 173 */           _os_.unmarshal_int();
/* 174 */           _os_.unmarshal_int();
/* 175 */           _os_.unmarshal_int();
/*     */         }
/* 177 */         _os_.unmarshal_int();
/* 178 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 181 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 183 */           SPetJinJieCfg _v_ = new SPetJinJieCfg();
/* 184 */           _v_.unmarshal(_os_);
/* 185 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 186 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 191 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 196 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SPetJinJieCfg> all)
/*     */   {
/* 203 */     String path = dir + "mzm.gsp.pet.confbean.SPetJinJieCfg.bny";
/*     */     try
/*     */     {
/* 206 */       File file = new File(path);
/* 207 */       if (file.exists())
/*     */       {
/* 209 */         byte[] bytes = new byte['Ѐ'];
/* 210 */         FileInputStream fis = new FileInputStream(file);
/* 211 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 212 */         int len = 0;
/* 213 */         while ((len = fis.read(bytes)) > 0)
/* 214 */           baos.write(bytes, 0, len);
/* 215 */         fis.close();
/* 216 */         bytes = baos.toByteArray();
/* 217 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 218 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 220 */           _os_.unmarshal_int();
/* 221 */           _os_.unmarshal_int();
/* 222 */           _os_.unmarshal_int();
/*     */         }
/* 224 */         _os_.unmarshal_int();
/* 225 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 228 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 230 */           SPetJinJieCfg _v_ = new SPetJinJieCfg();
/* 231 */           _v_.unmarshal(_os_);
/* 232 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 233 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 238 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 243 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SPetJinJieCfg getOld(int key)
/*     */   {
/* 251 */     return (SPetJinJieCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SPetJinJieCfg get(int key)
/*     */   {
/* 256 */     return (SPetJinJieCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPetJinJieCfg> getOldAll()
/*     */   {
/* 261 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPetJinJieCfg> getAll()
/*     */   {
/* 266 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SPetJinJieCfg> newAll)
/*     */   {
/* 271 */     oldAll = all;
/* 272 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 277 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\confbean\SPetJinJieCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */