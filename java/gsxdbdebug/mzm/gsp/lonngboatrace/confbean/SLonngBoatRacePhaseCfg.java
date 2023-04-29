/*     */ package mzm.gsp.lonngboatrace.confbean;
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
/*     */ public class SLonngBoatRacePhaseCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SLonngBoatRacePhaseCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SLonngBoatRacePhaseCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int raceId;
/*     */   public int phaseNo;
/*     */   public int roundCount;
/*     */   public int timesCount;
/*     */   public int commandTime;
/*     */   public int tipTime;
/*     */   public int commandCount;
/*     */   public double speedUpUnit;
/*     */   public double maxSpeed;
/*     */   public double speedDownUnit;
/*     */   public double minSpeed;
/*     */   public int aIAccuracy;
/*     */   public int prepareTime;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  35 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  36 */     this.raceId = Integer.valueOf(rootElement.attributeValue("raceId")).intValue();
/*  37 */     this.phaseNo = Integer.valueOf(rootElement.attributeValue("phaseNo")).intValue();
/*  38 */     this.roundCount = Integer.valueOf(rootElement.attributeValue("roundCount")).intValue();
/*  39 */     this.timesCount = Integer.valueOf(rootElement.attributeValue("timesCount")).intValue();
/*  40 */     this.commandTime = Integer.valueOf(rootElement.attributeValue("commandTime")).intValue();
/*  41 */     this.tipTime = Integer.valueOf(rootElement.attributeValue("tipTime")).intValue();
/*  42 */     this.commandCount = Integer.valueOf(rootElement.attributeValue("commandCount")).intValue();
/*  43 */     this.speedUpUnit = Double.valueOf(rootElement.attributeValue("speedUpUnit")).doubleValue();
/*  44 */     this.maxSpeed = Double.valueOf(rootElement.attributeValue("maxSpeed")).doubleValue();
/*  45 */     this.speedDownUnit = Double.valueOf(rootElement.attributeValue("speedDownUnit")).doubleValue();
/*  46 */     this.minSpeed = Double.valueOf(rootElement.attributeValue("minSpeed")).doubleValue();
/*  47 */     this.aIAccuracy = Integer.valueOf(rootElement.attributeValue("aIAccuracy")).intValue();
/*  48 */     this.prepareTime = Integer.valueOf(rootElement.attributeValue("prepareTime")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  53 */     _os_.marshal(this.id);
/*  54 */     _os_.marshal(this.raceId);
/*  55 */     _os_.marshal(this.phaseNo);
/*  56 */     _os_.marshal(this.roundCount);
/*  57 */     _os_.marshal(this.timesCount);
/*  58 */     _os_.marshal(this.commandTime);
/*  59 */     _os_.marshal(this.tipTime);
/*  60 */     _os_.marshal(this.commandCount);
/*  61 */     _os_.marshal(this.speedUpUnit);
/*  62 */     _os_.marshal(this.maxSpeed);
/*  63 */     _os_.marshal(this.speedDownUnit);
/*  64 */     _os_.marshal(this.minSpeed);
/*  65 */     _os_.marshal(this.aIAccuracy);
/*  66 */     _os_.marshal(this.prepareTime);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  72 */     this.id = _os_.unmarshal_int();
/*  73 */     this.raceId = _os_.unmarshal_int();
/*  74 */     this.phaseNo = _os_.unmarshal_int();
/*  75 */     this.roundCount = _os_.unmarshal_int();
/*  76 */     this.timesCount = _os_.unmarshal_int();
/*  77 */     this.commandTime = _os_.unmarshal_int();
/*  78 */     this.tipTime = _os_.unmarshal_int();
/*  79 */     this.commandCount = _os_.unmarshal_int();
/*  80 */     this.speedUpUnit = _os_.unmarshal_float();
/*  81 */     this.maxSpeed = _os_.unmarshal_float();
/*  82 */     this.speedDownUnit = _os_.unmarshal_float();
/*  83 */     this.minSpeed = _os_.unmarshal_float();
/*  84 */     this.aIAccuracy = _os_.unmarshal_int();
/*  85 */     this.prepareTime = _os_.unmarshal_int();
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  91 */     String path = dir + "mzm.gsp.lonngboatrace.confbean.SLonngBoatRacePhaseCfg.xml";
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
/* 104 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.lonngboatrace.confbean.SLonngBoatRacePhaseCfg"))
/*     */         {
/*     */ 
/* 107 */           SLonngBoatRacePhaseCfg obj = new SLonngBoatRacePhaseCfg();
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
/*     */   public static void reLoadXml(String dir, Map<Integer, SLonngBoatRacePhaseCfg> all)
/*     */   {
/* 121 */     String path = dir + "mzm.gsp.lonngboatrace.confbean.SLonngBoatRacePhaseCfg.xml";
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
/* 133 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.lonngboatrace.confbean.SLonngBoatRacePhaseCfg"))
/*     */         {
/*     */ 
/* 136 */           SLonngBoatRacePhaseCfg obj = new SLonngBoatRacePhaseCfg();
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
/* 152 */     String path = dir + "mzm.gsp.lonngboatrace.confbean.SLonngBoatRacePhaseCfg.bny";
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
/* 179 */           SLonngBoatRacePhaseCfg _v_ = new SLonngBoatRacePhaseCfg();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, SLonngBoatRacePhaseCfg> all)
/*     */   {
/* 199 */     String path = dir + "mzm.gsp.lonngboatrace.confbean.SLonngBoatRacePhaseCfg.bny";
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
/* 226 */           SLonngBoatRacePhaseCfg _v_ = new SLonngBoatRacePhaseCfg();
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
/*     */   public static SLonngBoatRacePhaseCfg getOld(int key)
/*     */   {
/* 247 */     return (SLonngBoatRacePhaseCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SLonngBoatRacePhaseCfg get(int key)
/*     */   {
/* 252 */     return (SLonngBoatRacePhaseCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SLonngBoatRacePhaseCfg> getOldAll()
/*     */   {
/* 257 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SLonngBoatRacePhaseCfg> getAll()
/*     */   {
/* 262 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SLonngBoatRacePhaseCfg> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\confbean\SLonngBoatRacePhaseCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */