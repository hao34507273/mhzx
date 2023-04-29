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
/*     */ public class LonngBoatRaceCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, LonngBoatRaceCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, LonngBoatRaceCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public double boatInitSpeed;
/*     */   public double trackLen;
/*     */   public int trackCount;
/*     */   public int teamCount;
/*     */   public int showScoreTime;
/*     */   public int correctCommandSpecialEffectId;
/*     */   public int wrongCommandSpecialEffectId;
/*     */   public int endPointSpecialEffectId;
/*     */   public int endPointMusicId;
/*     */   public int beginCountDownMusicId;
/*     */   public int backgroundMusicId;
/*     */   public int hoverTipsId;
/*     */   public int previewGUIId;
/*     */   public int activityGUIId;
/*     */   public String vehicleName;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  37 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  38 */     this.boatInitSpeed = Double.valueOf(rootElement.attributeValue("boatInitSpeed")).doubleValue();
/*  39 */     this.trackLen = Double.valueOf(rootElement.attributeValue("trackLen")).doubleValue();
/*  40 */     this.trackCount = Integer.valueOf(rootElement.attributeValue("trackCount")).intValue();
/*  41 */     this.teamCount = Integer.valueOf(rootElement.attributeValue("teamCount")).intValue();
/*  42 */     this.showScoreTime = Integer.valueOf(rootElement.attributeValue("showScoreTime")).intValue();
/*  43 */     this.correctCommandSpecialEffectId = Integer.valueOf(rootElement.attributeValue("correctCommandSpecialEffectId")).intValue();
/*  44 */     this.wrongCommandSpecialEffectId = Integer.valueOf(rootElement.attributeValue("wrongCommandSpecialEffectId")).intValue();
/*  45 */     this.endPointSpecialEffectId = Integer.valueOf(rootElement.attributeValue("endPointSpecialEffectId")).intValue();
/*  46 */     this.endPointMusicId = Integer.valueOf(rootElement.attributeValue("endPointMusicId")).intValue();
/*  47 */     this.beginCountDownMusicId = Integer.valueOf(rootElement.attributeValue("beginCountDownMusicId")).intValue();
/*  48 */     this.backgroundMusicId = Integer.valueOf(rootElement.attributeValue("backgroundMusicId")).intValue();
/*  49 */     this.hoverTipsId = Integer.valueOf(rootElement.attributeValue("hoverTipsId")).intValue();
/*  50 */     this.previewGUIId = Integer.valueOf(rootElement.attributeValue("previewGUIId")).intValue();
/*  51 */     this.activityGUIId = Integer.valueOf(rootElement.attributeValue("activityGUIId")).intValue();
/*  52 */     this.vehicleName = rootElement.attributeValue("vehicleName");
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  57 */     _os_.marshal(this.id);
/*  58 */     _os_.marshal(this.boatInitSpeed);
/*  59 */     _os_.marshal(this.trackLen);
/*  60 */     _os_.marshal(this.trackCount);
/*  61 */     _os_.marshal(this.teamCount);
/*  62 */     _os_.marshal(this.showScoreTime);
/*  63 */     _os_.marshal(this.correctCommandSpecialEffectId);
/*  64 */     _os_.marshal(this.wrongCommandSpecialEffectId);
/*  65 */     _os_.marshal(this.endPointSpecialEffectId);
/*  66 */     _os_.marshal(this.endPointMusicId);
/*  67 */     _os_.marshal(this.beginCountDownMusicId);
/*  68 */     _os_.marshal(this.backgroundMusicId);
/*  69 */     _os_.marshal(this.hoverTipsId);
/*  70 */     _os_.marshal(this.previewGUIId);
/*  71 */     _os_.marshal(this.activityGUIId);
/*  72 */     _os_.marshal(this.vehicleName, "UTF-8");
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  78 */     this.id = _os_.unmarshal_int();
/*  79 */     this.boatInitSpeed = _os_.unmarshal_float();
/*  80 */     this.trackLen = _os_.unmarshal_float();
/*  81 */     this.trackCount = _os_.unmarshal_int();
/*  82 */     this.teamCount = _os_.unmarshal_int();
/*  83 */     this.showScoreTime = _os_.unmarshal_int();
/*  84 */     this.correctCommandSpecialEffectId = _os_.unmarshal_int();
/*  85 */     this.wrongCommandSpecialEffectId = _os_.unmarshal_int();
/*  86 */     this.endPointSpecialEffectId = _os_.unmarshal_int();
/*  87 */     this.endPointMusicId = _os_.unmarshal_int();
/*  88 */     this.beginCountDownMusicId = _os_.unmarshal_int();
/*  89 */     this.backgroundMusicId = _os_.unmarshal_int();
/*  90 */     this.hoverTipsId = _os_.unmarshal_int();
/*  91 */     this.previewGUIId = _os_.unmarshal_int();
/*  92 */     this.activityGUIId = _os_.unmarshal_int();
/*  93 */     this.vehicleName = _os_.unmarshal_String("UTF-8");
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  99 */     String path = dir + "mzm.gsp.lonngboatrace.confbean.LonngBoatRaceCfg.xml";
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
/* 112 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.lonngboatrace.confbean.LonngBoatRaceCfg"))
/*     */         {
/*     */ 
/* 115 */           LonngBoatRaceCfg obj = new LonngBoatRaceCfg();
/* 116 */           obj.loadFromXml(elem);
/* 117 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 118 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 123 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, LonngBoatRaceCfg> all)
/*     */   {
/* 129 */     String path = dir + "mzm.gsp.lonngboatrace.confbean.LonngBoatRaceCfg.xml";
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
/* 141 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.lonngboatrace.confbean.LonngBoatRaceCfg"))
/*     */         {
/*     */ 
/* 144 */           LonngBoatRaceCfg obj = new LonngBoatRaceCfg();
/* 145 */           obj.loadFromXml(elem);
/* 146 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 147 */             throw new RuntimeException("duplicate key : " + obj.id);
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
/* 160 */     String path = dir + "mzm.gsp.lonngboatrace.confbean.LonngBoatRaceCfg.bny";
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
/* 187 */           LonngBoatRaceCfg _v_ = new LonngBoatRaceCfg();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, LonngBoatRaceCfg> all)
/*     */   {
/* 207 */     String path = dir + "mzm.gsp.lonngboatrace.confbean.LonngBoatRaceCfg.bny";
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
/* 234 */           LonngBoatRaceCfg _v_ = new LonngBoatRaceCfg();
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
/*     */   public static LonngBoatRaceCfg getOld(int key)
/*     */   {
/* 255 */     return (LonngBoatRaceCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static LonngBoatRaceCfg get(int key)
/*     */   {
/* 260 */     return (LonngBoatRaceCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, LonngBoatRaceCfg> getOldAll()
/*     */   {
/* 265 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, LonngBoatRaceCfg> getAll()
/*     */   {
/* 270 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, LonngBoatRaceCfg> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\confbean\LonngBoatRaceCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */