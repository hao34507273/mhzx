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
/*     */ public class LonngBoatRaceActivityCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, LonngBoatRaceActivityCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, LonngBoatRaceActivityCfg> all = null;
/*     */   
/*     */   public int activityId;
/*     */   public int raceId;
/*     */   public int awardTimeThreshold;
/*     */   public int bestAwardId;
/*     */   public int middleAwardId;
/*     */   public int minAwardId;
/*     */   public int npcId;
/*     */   public int joinActivityServiceId;
/*     */   public int previewActivityServiceId;
/*     */   public int switchId;
/*     */   public int awardCount;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  32 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/*  33 */     this.raceId = Integer.valueOf(rootElement.attributeValue("raceId")).intValue();
/*  34 */     this.awardTimeThreshold = Integer.valueOf(rootElement.attributeValue("awardTimeThreshold")).intValue();
/*  35 */     this.bestAwardId = Integer.valueOf(rootElement.attributeValue("bestAwardId")).intValue();
/*  36 */     this.middleAwardId = Integer.valueOf(rootElement.attributeValue("middleAwardId")).intValue();
/*  37 */     this.minAwardId = Integer.valueOf(rootElement.attributeValue("minAwardId")).intValue();
/*  38 */     this.npcId = Integer.valueOf(rootElement.attributeValue("npcId")).intValue();
/*  39 */     this.joinActivityServiceId = Integer.valueOf(rootElement.attributeValue("joinActivityServiceId")).intValue();
/*  40 */     this.previewActivityServiceId = Integer.valueOf(rootElement.attributeValue("previewActivityServiceId")).intValue();
/*  41 */     this.switchId = Integer.valueOf(rootElement.attributeValue("switchId")).intValue();
/*  42 */     this.awardCount = Integer.valueOf(rootElement.attributeValue("awardCount")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  47 */     _os_.marshal(this.activityId);
/*  48 */     _os_.marshal(this.raceId);
/*  49 */     _os_.marshal(this.awardTimeThreshold);
/*  50 */     _os_.marshal(this.bestAwardId);
/*  51 */     _os_.marshal(this.middleAwardId);
/*  52 */     _os_.marshal(this.minAwardId);
/*  53 */     _os_.marshal(this.npcId);
/*  54 */     _os_.marshal(this.joinActivityServiceId);
/*  55 */     _os_.marshal(this.previewActivityServiceId);
/*  56 */     _os_.marshal(this.switchId);
/*  57 */     _os_.marshal(this.awardCount);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  63 */     this.activityId = _os_.unmarshal_int();
/*  64 */     this.raceId = _os_.unmarshal_int();
/*  65 */     this.awardTimeThreshold = _os_.unmarshal_int();
/*  66 */     this.bestAwardId = _os_.unmarshal_int();
/*  67 */     this.middleAwardId = _os_.unmarshal_int();
/*  68 */     this.minAwardId = _os_.unmarshal_int();
/*  69 */     this.npcId = _os_.unmarshal_int();
/*  70 */     this.joinActivityServiceId = _os_.unmarshal_int();
/*  71 */     this.previewActivityServiceId = _os_.unmarshal_int();
/*  72 */     this.switchId = _os_.unmarshal_int();
/*  73 */     this.awardCount = _os_.unmarshal_int();
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  79 */     String path = dir + "mzm.gsp.lonngboatrace.confbean.LonngBoatRaceActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  83 */       all = new java.util.HashMap();
/*  84 */       SAXReader reader = new SAXReader();
/*  85 */       org.dom4j.Document doc = reader.read(new File(path));
/*  86 */       Element root = doc.getRootElement();
/*  87 */       List<?> nodeList = root.elements();
/*  88 */       int len = nodeList.size();
/*  89 */       for (int i = 0; i < len; i++)
/*     */       {
/*  91 */         Element elem = (Element)nodeList.get(i);
/*  92 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.lonngboatrace.confbean.LonngBoatRaceActivityCfg"))
/*     */         {
/*     */ 
/*  95 */           LonngBoatRaceActivityCfg obj = new LonngBoatRaceActivityCfg();
/*  96 */           obj.loadFromXml(elem);
/*  97 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/*  98 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 103 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, LonngBoatRaceActivityCfg> all)
/*     */   {
/* 109 */     String path = dir + "mzm.gsp.lonngboatrace.confbean.LonngBoatRaceActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 113 */       SAXReader reader = new SAXReader();
/* 114 */       org.dom4j.Document doc = reader.read(new File(path));
/* 115 */       Element root = doc.getRootElement();
/* 116 */       List<?> nodeList = root.elements();
/* 117 */       int len = nodeList.size();
/* 118 */       for (int i = 0; i < len; i++)
/*     */       {
/* 120 */         Element elem = (Element)nodeList.get(i);
/* 121 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.lonngboatrace.confbean.LonngBoatRaceActivityCfg"))
/*     */         {
/*     */ 
/* 124 */           LonngBoatRaceActivityCfg obj = new LonngBoatRaceActivityCfg();
/* 125 */           obj.loadFromXml(elem);
/* 126 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 127 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 132 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 138 */     all = new java.util.HashMap();
/*     */     
/* 140 */     String path = dir + "mzm.gsp.lonngboatrace.confbean.LonngBoatRaceActivityCfg.bny";
/*     */     try
/*     */     {
/* 143 */       File file = new File(path);
/* 144 */       if (file.exists())
/*     */       {
/* 146 */         byte[] bytes = new byte['Ѐ'];
/* 147 */         FileInputStream fis = new FileInputStream(file);
/* 148 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 149 */         int len = 0;
/* 150 */         while ((len = fis.read(bytes)) > 0)
/* 151 */           baos.write(bytes, 0, len);
/* 152 */         fis.close();
/* 153 */         bytes = baos.toByteArray();
/* 154 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 155 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 157 */           _os_.unmarshal_int();
/* 158 */           _os_.unmarshal_int();
/* 159 */           _os_.unmarshal_int();
/*     */         }
/* 161 */         _os_.unmarshal_int();
/* 162 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 165 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 167 */           LonngBoatRaceActivityCfg _v_ = new LonngBoatRaceActivityCfg();
/* 168 */           _v_.unmarshal(_os_);
/* 169 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 170 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 175 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 180 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, LonngBoatRaceActivityCfg> all)
/*     */   {
/* 187 */     String path = dir + "mzm.gsp.lonngboatrace.confbean.LonngBoatRaceActivityCfg.bny";
/*     */     try
/*     */     {
/* 190 */       File file = new File(path);
/* 191 */       if (file.exists())
/*     */       {
/* 193 */         byte[] bytes = new byte['Ѐ'];
/* 194 */         FileInputStream fis = new FileInputStream(file);
/* 195 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 196 */         int len = 0;
/* 197 */         while ((len = fis.read(bytes)) > 0)
/* 198 */           baos.write(bytes, 0, len);
/* 199 */         fis.close();
/* 200 */         bytes = baos.toByteArray();
/* 201 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 202 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 204 */           _os_.unmarshal_int();
/* 205 */           _os_.unmarshal_int();
/* 206 */           _os_.unmarshal_int();
/*     */         }
/* 208 */         _os_.unmarshal_int();
/* 209 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 212 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 214 */           LonngBoatRaceActivityCfg _v_ = new LonngBoatRaceActivityCfg();
/* 215 */           _v_.unmarshal(_os_);
/* 216 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 217 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 222 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 227 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static LonngBoatRaceActivityCfg getOld(int key)
/*     */   {
/* 235 */     return (LonngBoatRaceActivityCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static LonngBoatRaceActivityCfg get(int key)
/*     */   {
/* 240 */     return (LonngBoatRaceActivityCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, LonngBoatRaceActivityCfg> getOldAll()
/*     */   {
/* 245 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, LonngBoatRaceActivityCfg> getAll()
/*     */   {
/* 250 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, LonngBoatRaceActivityCfg> newAll)
/*     */   {
/* 255 */     oldAll = all;
/* 256 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 261 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\confbean\LonngBoatRaceActivityCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */