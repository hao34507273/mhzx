/*     */ package mzm.gsp.ladder.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SLadderGradeCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SLadderGradeCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SLadderGradeCfg> all = null;
/*     */   
/*     */   public int level;
/*     */   public int levelUpReductionRate;
/*     */   public int localChartType;
/*     */   public int remoteChartType;
/*  22 */   public HashMap<Integer, SLadderGradeInfo> grade_infos = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  26 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*  27 */     this.levelUpReductionRate = Integer.valueOf(rootElement.attributeValue("levelUpReductionRate")).intValue();
/*  28 */     this.localChartType = Integer.valueOf(rootElement.attributeValue("localChartType")).intValue();
/*  29 */     this.remoteChartType = Integer.valueOf(rootElement.attributeValue("remoteChartType")).intValue();
/*     */     
/*  31 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "grade_infos");
/*  32 */     if (mapTypeElement == null)
/*     */     {
/*  34 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  37 */     List<?> entryNodeList = mapTypeElement.elements();
/*  38 */     int entryLen = entryNodeList.size();
/*  39 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  41 */       Element entryElement = (Element)entryNodeList.get(i);
/*  42 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  47 */         Element keyElem = null;
/*  48 */         Element valueElem = null;
/*     */         
/*  50 */         List<?> _nodeList = entryElement.elements();
/*  51 */         int _len = _nodeList.size();
/*  52 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  54 */           Element elem = (Element)_nodeList.get(j);
/*  55 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  57 */             keyElem = elem;
/*     */           }
/*  59 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.ladder.confbean.SLadderGradeInfo")))
/*     */           {
/*  61 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  65 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  67 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         SLadderGradeInfo _v_;
/*     */         try
/*     */         {
/*  74 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  75 */           _v_ = new SLadderGradeInfo();
/*  76 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  83 */         this.grade_infos.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  90 */     _os_.marshal(this.level);
/*  91 */     _os_.marshal(this.levelUpReductionRate);
/*  92 */     _os_.marshal(this.localChartType);
/*  93 */     _os_.marshal(this.remoteChartType);
/*  94 */     _os_.compact_uint32(this.grade_infos.size());
/*  95 */     for (java.util.Map.Entry<Integer, SLadderGradeInfo> _e_ : this.grade_infos.entrySet())
/*     */     {
/*  97 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  98 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 105 */     this.level = _os_.unmarshal_int();
/* 106 */     this.levelUpReductionRate = _os_.unmarshal_int();
/* 107 */     this.localChartType = _os_.unmarshal_int();
/* 108 */     this.remoteChartType = _os_.unmarshal_int();
/* 109 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 112 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 114 */       SLadderGradeInfo _v_ = new SLadderGradeInfo();
/* 115 */       _v_.unmarshal(_os_);
/* 116 */       this.grade_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 118 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 123 */     String path = dir + "mzm.gsp.ladder.confbean.SLadderGradeCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 127 */       all = new java.util.TreeMap();
/* 128 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 129 */       org.dom4j.Document doc = reader.read(new File(path));
/* 130 */       Element root = doc.getRootElement();
/* 131 */       List<?> nodeList = root.elements();
/* 132 */       int len = nodeList.size();
/* 133 */       for (int i = 0; i < len; i++)
/*     */       {
/* 135 */         Element elem = (Element)nodeList.get(i);
/* 136 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.ladder.confbean.SLadderGradeCfg"))
/*     */         {
/*     */ 
/* 139 */           SLadderGradeCfg obj = new SLadderGradeCfg();
/* 140 */           obj.loadFromXml(elem);
/* 141 */           if (all.put(Integer.valueOf(obj.level), obj) != null) {
/* 142 */             throw new RuntimeException("duplicate key : " + obj.level);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 147 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SLadderGradeCfg> all)
/*     */   {
/* 153 */     String path = dir + "mzm.gsp.ladder.confbean.SLadderGradeCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 157 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 158 */       org.dom4j.Document doc = reader.read(new File(path));
/* 159 */       Element root = doc.getRootElement();
/* 160 */       List<?> nodeList = root.elements();
/* 161 */       int len = nodeList.size();
/* 162 */       for (int i = 0; i < len; i++)
/*     */       {
/* 164 */         Element elem = (Element)nodeList.get(i);
/* 165 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.ladder.confbean.SLadderGradeCfg"))
/*     */         {
/*     */ 
/* 168 */           SLadderGradeCfg obj = new SLadderGradeCfg();
/* 169 */           obj.loadFromXml(elem);
/* 170 */           if (all.put(Integer.valueOf(obj.level), obj) != null) {
/* 171 */             throw new RuntimeException("duplicate key : " + obj.level);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 176 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 182 */     all = new java.util.TreeMap();
/*     */     
/* 184 */     String path = dir + "mzm.gsp.ladder.confbean.SLadderGradeCfg.bny";
/*     */     try
/*     */     {
/* 187 */       File file = new File(path);
/* 188 */       if (file.exists())
/*     */       {
/* 190 */         byte[] bytes = new byte['Ѐ'];
/* 191 */         FileInputStream fis = new FileInputStream(file);
/* 192 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 193 */         int len = 0;
/* 194 */         while ((len = fis.read(bytes)) > 0)
/* 195 */           baos.write(bytes, 0, len);
/* 196 */         fis.close();
/* 197 */         bytes = baos.toByteArray();
/* 198 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 199 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 201 */           _os_.unmarshal_int();
/* 202 */           _os_.unmarshal_int();
/* 203 */           _os_.unmarshal_int();
/*     */         }
/* 205 */         _os_.unmarshal_int();
/* 206 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 209 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 211 */           SLadderGradeCfg _v_ = new SLadderGradeCfg();
/* 212 */           _v_.unmarshal(_os_);
/* 213 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 214 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 219 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 224 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SLadderGradeCfg> all)
/*     */   {
/* 231 */     String path = dir + "mzm.gsp.ladder.confbean.SLadderGradeCfg.bny";
/*     */     try
/*     */     {
/* 234 */       File file = new File(path);
/* 235 */       if (file.exists())
/*     */       {
/* 237 */         byte[] bytes = new byte['Ѐ'];
/* 238 */         FileInputStream fis = new FileInputStream(file);
/* 239 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 240 */         int len = 0;
/* 241 */         while ((len = fis.read(bytes)) > 0)
/* 242 */           baos.write(bytes, 0, len);
/* 243 */         fis.close();
/* 244 */         bytes = baos.toByteArray();
/* 245 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 246 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 248 */           _os_.unmarshal_int();
/* 249 */           _os_.unmarshal_int();
/* 250 */           _os_.unmarshal_int();
/*     */         }
/* 252 */         _os_.unmarshal_int();
/* 253 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 256 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 258 */           SLadderGradeCfg _v_ = new SLadderGradeCfg();
/* 259 */           _v_.unmarshal(_os_);
/* 260 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 261 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 266 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 271 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SLadderGradeCfg getOld(int key)
/*     */   {
/* 279 */     return (SLadderGradeCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SLadderGradeCfg get(int key)
/*     */   {
/* 284 */     return (SLadderGradeCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SLadderGradeCfg> getOldAll()
/*     */   {
/* 289 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SLadderGradeCfg> getAll()
/*     */   {
/* 294 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SLadderGradeCfg> newAll)
/*     */   {
/* 299 */     oldAll = all;
/* 300 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 305 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\confbean\SLadderGradeCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */