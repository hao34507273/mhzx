/*     */ package mzm.gsp.activity3.confbean;
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
/*     */ public class SFireworkCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SFireworkCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SFireworkCfg> all = null;
/*     */   
/*     */   public int activityId;
/*     */   public int findTime;
/*     */   public int findSucFixAwardId;
/*     */   public int totalCount;
/*     */   public int needCount;
/*     */   public int countDown;
/*     */   public int showMapId;
/*     */   public int fireworkEffectDuration;
/*     */   public int fireworkAwardId;
/*     */   public int showStartBroInterval;
/*     */   public int showStartBroCount;
/*     */   public int awardInterval;
/*     */   public int getAwardRet;
/*     */   public int checkId;
/*     */   public int switchId;
/*     */   public int hitAwardCountMax;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  37 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/*  38 */     this.findTime = Integer.valueOf(rootElement.attributeValue("findTime")).intValue();
/*  39 */     this.findSucFixAwardId = Integer.valueOf(rootElement.attributeValue("findSucFixAwardId")).intValue();
/*  40 */     this.totalCount = Integer.valueOf(rootElement.attributeValue("totalCount")).intValue();
/*  41 */     this.needCount = Integer.valueOf(rootElement.attributeValue("needCount")).intValue();
/*  42 */     this.countDown = Integer.valueOf(rootElement.attributeValue("countDown")).intValue();
/*  43 */     this.showMapId = Integer.valueOf(rootElement.attributeValue("showMapId")).intValue();
/*  44 */     this.fireworkEffectDuration = Integer.valueOf(rootElement.attributeValue("fireworkEffectDuration")).intValue();
/*  45 */     this.fireworkAwardId = Integer.valueOf(rootElement.attributeValue("fireworkAwardId")).intValue();
/*  46 */     this.showStartBroInterval = Integer.valueOf(rootElement.attributeValue("showStartBroInterval")).intValue();
/*  47 */     this.showStartBroCount = Integer.valueOf(rootElement.attributeValue("showStartBroCount")).intValue();
/*  48 */     this.awardInterval = Integer.valueOf(rootElement.attributeValue("awardInterval")).intValue();
/*  49 */     this.getAwardRet = Integer.valueOf(rootElement.attributeValue("getAwardRet")).intValue();
/*  50 */     this.checkId = Integer.valueOf(rootElement.attributeValue("checkId")).intValue();
/*  51 */     this.switchId = Integer.valueOf(rootElement.attributeValue("switchId")).intValue();
/*  52 */     this.hitAwardCountMax = Integer.valueOf(rootElement.attributeValue("hitAwardCountMax")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  57 */     _os_.marshal(this.activityId);
/*  58 */     _os_.marshal(this.findTime);
/*  59 */     _os_.marshal(this.findSucFixAwardId);
/*  60 */     _os_.marshal(this.totalCount);
/*  61 */     _os_.marshal(this.needCount);
/*  62 */     _os_.marshal(this.countDown);
/*  63 */     _os_.marshal(this.showMapId);
/*  64 */     _os_.marshal(this.fireworkEffectDuration);
/*  65 */     _os_.marshal(this.fireworkAwardId);
/*  66 */     _os_.marshal(this.showStartBroInterval);
/*  67 */     _os_.marshal(this.showStartBroCount);
/*  68 */     _os_.marshal(this.awardInterval);
/*  69 */     _os_.marshal(this.getAwardRet);
/*  70 */     _os_.marshal(this.checkId);
/*  71 */     _os_.marshal(this.switchId);
/*  72 */     _os_.marshal(this.hitAwardCountMax);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  78 */     this.activityId = _os_.unmarshal_int();
/*  79 */     this.findTime = _os_.unmarshal_int();
/*  80 */     this.findSucFixAwardId = _os_.unmarshal_int();
/*  81 */     this.totalCount = _os_.unmarshal_int();
/*  82 */     this.needCount = _os_.unmarshal_int();
/*  83 */     this.countDown = _os_.unmarshal_int();
/*  84 */     this.showMapId = _os_.unmarshal_int();
/*  85 */     this.fireworkEffectDuration = _os_.unmarshal_int();
/*  86 */     this.fireworkAwardId = _os_.unmarshal_int();
/*  87 */     this.showStartBroInterval = _os_.unmarshal_int();
/*  88 */     this.showStartBroCount = _os_.unmarshal_int();
/*  89 */     this.awardInterval = _os_.unmarshal_int();
/*  90 */     this.getAwardRet = _os_.unmarshal_int();
/*  91 */     this.checkId = _os_.unmarshal_int();
/*  92 */     this.switchId = _os_.unmarshal_int();
/*  93 */     this.hitAwardCountMax = _os_.unmarshal_int();
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  99 */     String path = dir + "mzm.gsp.activity3.confbean.SFireworkCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 103 */       all = new java.util.HashMap();
/* 104 */       SAXReader reader = new SAXReader();
/* 105 */       org.dom4j.Document doc = reader.read(new File(path));
/* 106 */       Element root = doc.getRootElement();
/* 107 */       List<?> nodeList = root.elements();
/* 108 */       int len = nodeList.size();
/* 109 */       for (int i = 0; i < len; i++)
/*     */       {
/* 111 */         Element elem = (Element)nodeList.get(i);
/* 112 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.SFireworkCfg"))
/*     */         {
/*     */ 
/* 115 */           SFireworkCfg obj = new SFireworkCfg();
/* 116 */           obj.loadFromXml(elem);
/* 117 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 118 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 123 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SFireworkCfg> all)
/*     */   {
/* 129 */     String path = dir + "mzm.gsp.activity3.confbean.SFireworkCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 133 */       SAXReader reader = new SAXReader();
/* 134 */       org.dom4j.Document doc = reader.read(new File(path));
/* 135 */       Element root = doc.getRootElement();
/* 136 */       List<?> nodeList = root.elements();
/* 137 */       int len = nodeList.size();
/* 138 */       for (int i = 0; i < len; i++)
/*     */       {
/* 140 */         Element elem = (Element)nodeList.get(i);
/* 141 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.SFireworkCfg"))
/*     */         {
/*     */ 
/* 144 */           SFireworkCfg obj = new SFireworkCfg();
/* 145 */           obj.loadFromXml(elem);
/* 146 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 147 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 152 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 158 */     all = new java.util.HashMap();
/*     */     
/* 160 */     String path = dir + "mzm.gsp.activity3.confbean.SFireworkCfg.bny";
/*     */     try
/*     */     {
/* 163 */       File file = new File(path);
/* 164 */       if (file.exists())
/*     */       {
/* 166 */         byte[] bytes = new byte['Ѐ'];
/* 167 */         FileInputStream fis = new FileInputStream(file);
/* 168 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 169 */         int len = 0;
/* 170 */         while ((len = fis.read(bytes)) > 0)
/* 171 */           baos.write(bytes, 0, len);
/* 172 */         fis.close();
/* 173 */         bytes = baos.toByteArray();
/* 174 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 175 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 177 */           _os_.unmarshal_int();
/* 178 */           _os_.unmarshal_int();
/* 179 */           _os_.unmarshal_int();
/*     */         }
/* 181 */         _os_.unmarshal_int();
/* 182 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 185 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 187 */           SFireworkCfg _v_ = new SFireworkCfg();
/* 188 */           _v_.unmarshal(_os_);
/* 189 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 190 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 195 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 200 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SFireworkCfg> all)
/*     */   {
/* 207 */     String path = dir + "mzm.gsp.activity3.confbean.SFireworkCfg.bny";
/*     */     try
/*     */     {
/* 210 */       File file = new File(path);
/* 211 */       if (file.exists())
/*     */       {
/* 213 */         byte[] bytes = new byte['Ѐ'];
/* 214 */         FileInputStream fis = new FileInputStream(file);
/* 215 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 216 */         int len = 0;
/* 217 */         while ((len = fis.read(bytes)) > 0)
/* 218 */           baos.write(bytes, 0, len);
/* 219 */         fis.close();
/* 220 */         bytes = baos.toByteArray();
/* 221 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 222 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 224 */           _os_.unmarshal_int();
/* 225 */           _os_.unmarshal_int();
/* 226 */           _os_.unmarshal_int();
/*     */         }
/* 228 */         _os_.unmarshal_int();
/* 229 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 232 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 234 */           SFireworkCfg _v_ = new SFireworkCfg();
/* 235 */           _v_.unmarshal(_os_);
/* 236 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 237 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 242 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 247 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SFireworkCfg getOld(int key)
/*     */   {
/* 255 */     return (SFireworkCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SFireworkCfg get(int key)
/*     */   {
/* 260 */     return (SFireworkCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFireworkCfg> getOldAll()
/*     */   {
/* 265 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFireworkCfg> getAll()
/*     */   {
/* 270 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SFireworkCfg> newAll)
/*     */   {
/* 275 */     oldAll = all;
/* 276 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 281 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity3\confbean\SFireworkCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */