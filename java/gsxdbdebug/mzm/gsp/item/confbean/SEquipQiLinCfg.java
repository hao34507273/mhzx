/*     */ package mzm.gsp.item.confbean;
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
/*     */ public class SEquipQiLinCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SEquipQiLinCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SEquipQiLinCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int qilinTypeid;
/*     */   public int equipmentLevel;
/*     */   public int strengthLevel;
/*     */   public int equipmentType;
/*     */   public int sucRate;
/*     */   public int failStrengthLevel;
/*     */   public int strengthItemNum;
/*     */   public int strengthSilverNum;
/*     */   public int zhenLinStonNum;
/*     */   public boolean canUseLuckStone;
/*     */   public int strengthAttrA;
/*     */   public int strengthAttrB;
/*     */   public int score2rate;
/*     */   public int fialGetScore;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  36 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  37 */     this.qilinTypeid = Integer.valueOf(rootElement.attributeValue("qilinTypeid")).intValue();
/*  38 */     this.equipmentLevel = Integer.valueOf(rootElement.attributeValue("equipmentLevel")).intValue();
/*  39 */     this.strengthLevel = Integer.valueOf(rootElement.attributeValue("strengthLevel")).intValue();
/*  40 */     this.equipmentType = Integer.valueOf(rootElement.attributeValue("equipmentType")).intValue();
/*  41 */     this.sucRate = Integer.valueOf(rootElement.attributeValue("sucRate")).intValue();
/*  42 */     this.failStrengthLevel = Integer.valueOf(rootElement.attributeValue("failStrengthLevel")).intValue();
/*  43 */     this.strengthItemNum = Integer.valueOf(rootElement.attributeValue("strengthItemNum")).intValue();
/*  44 */     this.strengthSilverNum = Integer.valueOf(rootElement.attributeValue("strengthSilverNum")).intValue();
/*  45 */     this.zhenLinStonNum = Integer.valueOf(rootElement.attributeValue("zhenLinStonNum")).intValue();
/*  46 */     this.canUseLuckStone = Boolean.valueOf(rootElement.attributeValue("canUseLuckStone")).booleanValue();
/*  47 */     this.strengthAttrA = Integer.valueOf(rootElement.attributeValue("strengthAttrA")).intValue();
/*  48 */     this.strengthAttrB = Integer.valueOf(rootElement.attributeValue("strengthAttrB")).intValue();
/*  49 */     this.score2rate = Integer.valueOf(rootElement.attributeValue("score2rate")).intValue();
/*  50 */     this.fialGetScore = Integer.valueOf(rootElement.attributeValue("fialGetScore")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  55 */     _os_.marshal(this.id);
/*  56 */     _os_.marshal(this.qilinTypeid);
/*  57 */     _os_.marshal(this.equipmentLevel);
/*  58 */     _os_.marshal(this.strengthLevel);
/*  59 */     _os_.marshal(this.equipmentType);
/*  60 */     _os_.marshal(this.sucRate);
/*  61 */     _os_.marshal(this.failStrengthLevel);
/*  62 */     _os_.marshal(this.strengthItemNum);
/*  63 */     _os_.marshal(this.strengthSilverNum);
/*  64 */     _os_.marshal(this.zhenLinStonNum);
/*  65 */     _os_.marshal(this.canUseLuckStone);
/*  66 */     _os_.marshal(this.strengthAttrA);
/*  67 */     _os_.marshal(this.strengthAttrB);
/*  68 */     _os_.marshal(this.score2rate);
/*  69 */     _os_.marshal(this.fialGetScore);
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     this.id = _os_.unmarshal_int();
/*  76 */     this.qilinTypeid = _os_.unmarshal_int();
/*  77 */     this.equipmentLevel = _os_.unmarshal_int();
/*  78 */     this.strengthLevel = _os_.unmarshal_int();
/*  79 */     this.equipmentType = _os_.unmarshal_int();
/*  80 */     this.sucRate = _os_.unmarshal_int();
/*  81 */     this.failStrengthLevel = _os_.unmarshal_int();
/*  82 */     this.strengthItemNum = _os_.unmarshal_int();
/*  83 */     this.strengthSilverNum = _os_.unmarshal_int();
/*  84 */     this.zhenLinStonNum = _os_.unmarshal_int();
/*  85 */     this.canUseLuckStone = _os_.unmarshal_boolean();
/*  86 */     this.strengthAttrA = _os_.unmarshal_int();
/*  87 */     this.strengthAttrB = _os_.unmarshal_int();
/*  88 */     this.score2rate = _os_.unmarshal_int();
/*  89 */     this.fialGetScore = _os_.unmarshal_int();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  95 */     String path = dir + "mzm.gsp.item.confbean.SEquipQiLinCfg.xml";
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
/* 108 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SEquipQiLinCfg"))
/*     */         {
/*     */ 
/* 111 */           SEquipQiLinCfg obj = new SEquipQiLinCfg();
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
/*     */   public static void reLoadXml(String dir, Map<Integer, SEquipQiLinCfg> all)
/*     */   {
/* 125 */     String path = dir + "mzm.gsp.item.confbean.SEquipQiLinCfg.xml";
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
/* 137 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SEquipQiLinCfg"))
/*     */         {
/*     */ 
/* 140 */           SEquipQiLinCfg obj = new SEquipQiLinCfg();
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
/* 156 */     String path = dir + "mzm.gsp.item.confbean.SEquipQiLinCfg.bny";
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
/* 183 */           SEquipQiLinCfg _v_ = new SEquipQiLinCfg();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, SEquipQiLinCfg> all)
/*     */   {
/* 203 */     String path = dir + "mzm.gsp.item.confbean.SEquipQiLinCfg.bny";
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
/* 230 */           SEquipQiLinCfg _v_ = new SEquipQiLinCfg();
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
/*     */   public static SEquipQiLinCfg getOld(int key)
/*     */   {
/* 251 */     return (SEquipQiLinCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SEquipQiLinCfg get(int key)
/*     */   {
/* 256 */     return (SEquipQiLinCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SEquipQiLinCfg> getOldAll()
/*     */   {
/* 261 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SEquipQiLinCfg> getAll()
/*     */   {
/* 266 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SEquipQiLinCfg> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SEquipQiLinCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */