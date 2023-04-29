/*     */ package mzm.gsp.shanghui.confbean;
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
/*     */ public class SPriceFlowFormulaCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SPriceFlowFormulaCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SPriceFlowFormulaCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templatename;
/*     */   public double riseParamX;
/*     */   public double offsetMaxLimitN;
/*     */   public double sqrtTime1;
/*     */   public double riseFormulaScaleParamZ;
/*     */   public double riseFormulaAjustParam;
/*     */   public double fallParamY;
/*     */   public double offsetMinM;
/*     */   public double sqrtTime2;
/*     */   public double fallFormulaScallParamZ;
/*     */   public double fallFormulaAjustParam;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  33 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  34 */     this.templatename = rootElement.attributeValue("templatename");
/*  35 */     this.riseParamX = Double.valueOf(rootElement.attributeValue("riseParamX")).doubleValue();
/*  36 */     this.offsetMaxLimitN = Double.valueOf(rootElement.attributeValue("offsetMaxLimitN")).doubleValue();
/*  37 */     this.sqrtTime1 = Double.valueOf(rootElement.attributeValue("sqrtTime1")).doubleValue();
/*  38 */     this.riseFormulaScaleParamZ = Double.valueOf(rootElement.attributeValue("riseFormulaScaleParamZ")).doubleValue();
/*  39 */     this.riseFormulaAjustParam = Double.valueOf(rootElement.attributeValue("riseFormulaAjustParam")).doubleValue();
/*  40 */     this.fallParamY = Double.valueOf(rootElement.attributeValue("fallParamY")).doubleValue();
/*  41 */     this.offsetMinM = Double.valueOf(rootElement.attributeValue("offsetMinM")).doubleValue();
/*  42 */     this.sqrtTime2 = Double.valueOf(rootElement.attributeValue("sqrtTime2")).doubleValue();
/*  43 */     this.fallFormulaScallParamZ = Double.valueOf(rootElement.attributeValue("fallFormulaScallParamZ")).doubleValue();
/*  44 */     this.fallFormulaAjustParam = Double.valueOf(rootElement.attributeValue("fallFormulaAjustParam")).doubleValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  49 */     _os_.marshal(this.id);
/*  50 */     _os_.marshal(this.templatename, "UTF-8");
/*  51 */     _os_.marshal(this.riseParamX);
/*  52 */     _os_.marshal(this.offsetMaxLimitN);
/*  53 */     _os_.marshal(this.sqrtTime1);
/*  54 */     _os_.marshal(this.riseFormulaScaleParamZ);
/*  55 */     _os_.marshal(this.riseFormulaAjustParam);
/*  56 */     _os_.marshal(this.fallParamY);
/*  57 */     _os_.marshal(this.offsetMinM);
/*  58 */     _os_.marshal(this.sqrtTime2);
/*  59 */     _os_.marshal(this.fallFormulaScallParamZ);
/*  60 */     _os_.marshal(this.fallFormulaAjustParam);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  66 */     this.id = _os_.unmarshal_int();
/*  67 */     this.templatename = _os_.unmarshal_String("UTF-8");
/*  68 */     this.riseParamX = _os_.unmarshal_float();
/*  69 */     this.offsetMaxLimitN = _os_.unmarshal_float();
/*  70 */     this.sqrtTime1 = _os_.unmarshal_float();
/*  71 */     this.riseFormulaScaleParamZ = _os_.unmarshal_float();
/*  72 */     this.riseFormulaAjustParam = _os_.unmarshal_float();
/*  73 */     this.fallParamY = _os_.unmarshal_float();
/*  74 */     this.offsetMinM = _os_.unmarshal_float();
/*  75 */     this.sqrtTime2 = _os_.unmarshal_float();
/*  76 */     this.fallFormulaScallParamZ = _os_.unmarshal_float();
/*  77 */     this.fallFormulaAjustParam = _os_.unmarshal_float();
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  83 */     String path = dir + "mzm.gsp.shanghui.confbean.SPriceFlowFormulaCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  87 */       all = new java.util.HashMap();
/*  88 */       SAXReader reader = new SAXReader();
/*  89 */       org.dom4j.Document doc = reader.read(new File(path));
/*  90 */       Element root = doc.getRootElement();
/*  91 */       List<?> nodeList = root.elements();
/*  92 */       int len = nodeList.size();
/*  93 */       for (int i = 0; i < len; i++)
/*     */       {
/*  95 */         Element elem = (Element)nodeList.get(i);
/*  96 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.shanghui.confbean.SPriceFlowFormulaCfg"))
/*     */         {
/*     */ 
/*  99 */           SPriceFlowFormulaCfg obj = new SPriceFlowFormulaCfg();
/* 100 */           obj.loadFromXml(elem);
/* 101 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 102 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 107 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SPriceFlowFormulaCfg> all)
/*     */   {
/* 113 */     String path = dir + "mzm.gsp.shanghui.confbean.SPriceFlowFormulaCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 117 */       SAXReader reader = new SAXReader();
/* 118 */       org.dom4j.Document doc = reader.read(new File(path));
/* 119 */       Element root = doc.getRootElement();
/* 120 */       List<?> nodeList = root.elements();
/* 121 */       int len = nodeList.size();
/* 122 */       for (int i = 0; i < len; i++)
/*     */       {
/* 124 */         Element elem = (Element)nodeList.get(i);
/* 125 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.shanghui.confbean.SPriceFlowFormulaCfg"))
/*     */         {
/*     */ 
/* 128 */           SPriceFlowFormulaCfg obj = new SPriceFlowFormulaCfg();
/* 129 */           obj.loadFromXml(elem);
/* 130 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 131 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 136 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 142 */     all = new java.util.HashMap();
/*     */     
/* 144 */     String path = dir + "mzm.gsp.shanghui.confbean.SPriceFlowFormulaCfg.bny";
/*     */     try
/*     */     {
/* 147 */       File file = new File(path);
/* 148 */       if (file.exists())
/*     */       {
/* 150 */         byte[] bytes = new byte['Ѐ'];
/* 151 */         FileInputStream fis = new FileInputStream(file);
/* 152 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 153 */         int len = 0;
/* 154 */         while ((len = fis.read(bytes)) > 0)
/* 155 */           baos.write(bytes, 0, len);
/* 156 */         fis.close();
/* 157 */         bytes = baos.toByteArray();
/* 158 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 159 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 161 */           _os_.unmarshal_int();
/* 162 */           _os_.unmarshal_int();
/* 163 */           _os_.unmarshal_int();
/*     */         }
/* 165 */         _os_.unmarshal_int();
/* 166 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 169 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 171 */           SPriceFlowFormulaCfg _v_ = new SPriceFlowFormulaCfg();
/* 172 */           _v_.unmarshal(_os_);
/* 173 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 174 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 179 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 184 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SPriceFlowFormulaCfg> all)
/*     */   {
/* 191 */     String path = dir + "mzm.gsp.shanghui.confbean.SPriceFlowFormulaCfg.bny";
/*     */     try
/*     */     {
/* 194 */       File file = new File(path);
/* 195 */       if (file.exists())
/*     */       {
/* 197 */         byte[] bytes = new byte['Ѐ'];
/* 198 */         FileInputStream fis = new FileInputStream(file);
/* 199 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 200 */         int len = 0;
/* 201 */         while ((len = fis.read(bytes)) > 0)
/* 202 */           baos.write(bytes, 0, len);
/* 203 */         fis.close();
/* 204 */         bytes = baos.toByteArray();
/* 205 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 206 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 208 */           _os_.unmarshal_int();
/* 209 */           _os_.unmarshal_int();
/* 210 */           _os_.unmarshal_int();
/*     */         }
/* 212 */         _os_.unmarshal_int();
/* 213 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 216 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 218 */           SPriceFlowFormulaCfg _v_ = new SPriceFlowFormulaCfg();
/* 219 */           _v_.unmarshal(_os_);
/* 220 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 221 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 226 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 231 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SPriceFlowFormulaCfg getOld(int key)
/*     */   {
/* 239 */     return (SPriceFlowFormulaCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SPriceFlowFormulaCfg get(int key)
/*     */   {
/* 244 */     return (SPriceFlowFormulaCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPriceFlowFormulaCfg> getOldAll()
/*     */   {
/* 249 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPriceFlowFormulaCfg> getAll()
/*     */   {
/* 254 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SPriceFlowFormulaCfg> newAll)
/*     */   {
/* 259 */     oldAll = all;
/* 260 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 265 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\confbean\SPriceFlowFormulaCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */