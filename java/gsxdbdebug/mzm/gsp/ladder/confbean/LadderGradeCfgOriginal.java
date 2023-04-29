/*     */ package mzm.gsp.ladder.confbean;
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
/*     */ public class LadderGradeCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, LadderGradeCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, LadderGradeCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public int level;
/*     */   public String levelRangeName;
/*     */   public int levelUpReductionRate;
/*     */   public int localChartType;
/*     */   public int remoteChartType;
/*     */   public boolean hidden;
/*     */   public int sort;
/*     */   public String honorName;
/*     */   public String iconName;
/*     */   public int levelUpScoreMin;
/*     */   public int levelDownScoreMin;
/*     */   public int winToken;
/*     */   public int loseToken;
/*     */   public int awardid;
/*     */   public int reductionRate;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  37 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  38 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*  39 */     this.levelRangeName = rootElement.attributeValue("levelRangeName");
/*  40 */     this.levelUpReductionRate = Integer.valueOf(rootElement.attributeValue("levelUpReductionRate")).intValue();
/*  41 */     this.localChartType = Integer.valueOf(rootElement.attributeValue("localChartType")).intValue();
/*  42 */     this.remoteChartType = Integer.valueOf(rootElement.attributeValue("remoteChartType")).intValue();
/*  43 */     this.hidden = Boolean.valueOf(rootElement.attributeValue("hidden")).booleanValue();
/*  44 */     this.sort = Integer.valueOf(rootElement.attributeValue("sort")).intValue();
/*  45 */     this.honorName = rootElement.attributeValue("honorName");
/*  46 */     this.iconName = rootElement.attributeValue("iconName");
/*  47 */     this.levelUpScoreMin = Integer.valueOf(rootElement.attributeValue("levelUpScoreMin")).intValue();
/*  48 */     this.levelDownScoreMin = Integer.valueOf(rootElement.attributeValue("levelDownScoreMin")).intValue();
/*  49 */     this.winToken = Integer.valueOf(rootElement.attributeValue("winToken")).intValue();
/*  50 */     this.loseToken = Integer.valueOf(rootElement.attributeValue("loseToken")).intValue();
/*  51 */     this.awardid = Integer.valueOf(rootElement.attributeValue("awardid")).intValue();
/*  52 */     this.reductionRate = Integer.valueOf(rootElement.attributeValue("reductionRate")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  57 */     _os_.marshal(this.id);
/*  58 */     _os_.marshal(this.level);
/*  59 */     _os_.marshal(this.levelRangeName, "UTF-8");
/*  60 */     _os_.marshal(this.levelUpReductionRate);
/*  61 */     _os_.marshal(this.localChartType);
/*  62 */     _os_.marshal(this.remoteChartType);
/*  63 */     _os_.marshal(this.hidden);
/*  64 */     _os_.marshal(this.sort);
/*  65 */     _os_.marshal(this.honorName, "UTF-8");
/*  66 */     _os_.marshal(this.iconName, "UTF-8");
/*  67 */     _os_.marshal(this.levelUpScoreMin);
/*  68 */     _os_.marshal(this.levelDownScoreMin);
/*  69 */     _os_.marshal(this.winToken);
/*  70 */     _os_.marshal(this.loseToken);
/*  71 */     _os_.marshal(this.awardid);
/*  72 */     _os_.marshal(this.reductionRate);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  78 */     this.id = _os_.unmarshal_int();
/*  79 */     this.level = _os_.unmarshal_int();
/*  80 */     this.levelRangeName = _os_.unmarshal_String("UTF-8");
/*  81 */     this.levelUpReductionRate = _os_.unmarshal_int();
/*  82 */     this.localChartType = _os_.unmarshal_int();
/*  83 */     this.remoteChartType = _os_.unmarshal_int();
/*  84 */     this.hidden = _os_.unmarshal_boolean();
/*  85 */     this.sort = _os_.unmarshal_int();
/*  86 */     this.honorName = _os_.unmarshal_String("UTF-8");
/*  87 */     this.iconName = _os_.unmarshal_String("UTF-8");
/*  88 */     this.levelUpScoreMin = _os_.unmarshal_int();
/*  89 */     this.levelDownScoreMin = _os_.unmarshal_int();
/*  90 */     this.winToken = _os_.unmarshal_int();
/*  91 */     this.loseToken = _os_.unmarshal_int();
/*  92 */     this.awardid = _os_.unmarshal_int();
/*  93 */     this.reductionRate = _os_.unmarshal_int();
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  99 */     String path = dir + "mzm.gsp.ladder.confbean.LadderGradeCfgOriginal.xml";
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
/* 112 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.ladder.confbean.LadderGradeCfgOriginal"))
/*     */         {
/*     */ 
/* 115 */           LadderGradeCfgOriginal obj = new LadderGradeCfgOriginal();
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
/*     */   public static void reLoadXml(String dir, Map<Integer, LadderGradeCfgOriginal> all)
/*     */   {
/* 129 */     String path = dir + "mzm.gsp.ladder.confbean.LadderGradeCfgOriginal.xml";
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
/* 141 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.ladder.confbean.LadderGradeCfgOriginal"))
/*     */         {
/*     */ 
/* 144 */           LadderGradeCfgOriginal obj = new LadderGradeCfgOriginal();
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
/* 160 */     String path = dir + "mzm.gsp.ladder.confbean.LadderGradeCfgOriginal.bny";
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
/* 187 */           LadderGradeCfgOriginal _v_ = new LadderGradeCfgOriginal();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, LadderGradeCfgOriginal> all)
/*     */   {
/* 207 */     String path = dir + "mzm.gsp.ladder.confbean.LadderGradeCfgOriginal.bny";
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
/* 234 */           LadderGradeCfgOriginal _v_ = new LadderGradeCfgOriginal();
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
/*     */   public static LadderGradeCfgOriginal getOld(int key)
/*     */   {
/* 255 */     return (LadderGradeCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static LadderGradeCfgOriginal get(int key)
/*     */   {
/* 260 */     return (LadderGradeCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, LadderGradeCfgOriginal> getOldAll()
/*     */   {
/* 265 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, LadderGradeCfgOriginal> getAll()
/*     */   {
/* 270 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, LadderGradeCfgOriginal> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\confbean\LadderGradeCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */