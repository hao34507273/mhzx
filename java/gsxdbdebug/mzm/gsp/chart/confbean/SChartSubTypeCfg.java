/*     */ package mzm.gsp.chart.confbean;
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
/*     */ public class SChartSubTypeCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SChartSubTypeCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SChartSubTypeCfg> all = null;
/*     */   
/*     */   public int chartType;
/*     */   public int capacity;
/*     */   public int extraSize;
/*     */   public int timeCfgId;
/*     */   public int intervalSec;
/*  23 */   public java.util.ArrayList<Integer> timeCommonCfgids = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  27 */     this.chartType = Integer.valueOf(rootElement.attributeValue("chartType")).intValue();
/*  28 */     this.capacity = Integer.valueOf(rootElement.attributeValue("capacity")).intValue();
/*  29 */     this.extraSize = Integer.valueOf(rootElement.attributeValue("extraSize")).intValue();
/*  30 */     this.timeCfgId = Integer.valueOf(rootElement.attributeValue("timeCfgId")).intValue();
/*  31 */     this.intervalSec = Integer.valueOf(rootElement.attributeValue("intervalSec")).intValue();
/*     */     
/*  33 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "timeCommonCfgids");
/*  34 */     if (collectionElement == null)
/*     */     {
/*  36 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  39 */     List<?> _nodeList = collectionElement.elements();
/*  40 */     int _len = _nodeList.size();
/*  41 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  43 */       Element elem = (Element)_nodeList.get(i);
/*  44 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  51 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  58 */         this.timeCommonCfgids.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  65 */     _os_.marshal(this.chartType);
/*  66 */     _os_.marshal(this.capacity);
/*  67 */     _os_.marshal(this.extraSize);
/*  68 */     _os_.marshal(this.timeCfgId);
/*  69 */     _os_.marshal(this.intervalSec);
/*  70 */     _os_.compact_uint32(this.timeCommonCfgids.size());
/*  71 */     for (Integer _v_ : this.timeCommonCfgids)
/*     */     {
/*  73 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     this.chartType = _os_.unmarshal_int();
/*  81 */     this.capacity = _os_.unmarshal_int();
/*  82 */     this.extraSize = _os_.unmarshal_int();
/*  83 */     this.timeCfgId = _os_.unmarshal_int();
/*  84 */     this.intervalSec = _os_.unmarshal_int();
/*  85 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  88 */       int _v_ = _os_.unmarshal_int();
/*  89 */       this.timeCommonCfgids.add(Integer.valueOf(_v_));
/*     */     }
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  96 */     String path = dir + "mzm.gsp.chart.confbean.SChartSubTypeCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 100 */       all = new java.util.HashMap();
/* 101 */       SAXReader reader = new SAXReader();
/* 102 */       org.dom4j.Document doc = reader.read(new File(path));
/* 103 */       Element root = doc.getRootElement();
/* 104 */       List<?> nodeList = root.elements();
/* 105 */       int len = nodeList.size();
/* 106 */       for (int i = 0; i < len; i++)
/*     */       {
/* 108 */         Element elem = (Element)nodeList.get(i);
/* 109 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.chart.confbean.SChartSubTypeCfg"))
/*     */         {
/*     */ 
/* 112 */           SChartSubTypeCfg obj = new SChartSubTypeCfg();
/* 113 */           obj.loadFromXml(elem);
/* 114 */           if (all.put(Integer.valueOf(obj.chartType), obj) != null) {
/* 115 */             throw new RuntimeException("duplicate key : " + obj.chartType);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 120 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SChartSubTypeCfg> all)
/*     */   {
/* 126 */     String path = dir + "mzm.gsp.chart.confbean.SChartSubTypeCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 130 */       SAXReader reader = new SAXReader();
/* 131 */       org.dom4j.Document doc = reader.read(new File(path));
/* 132 */       Element root = doc.getRootElement();
/* 133 */       List<?> nodeList = root.elements();
/* 134 */       int len = nodeList.size();
/* 135 */       for (int i = 0; i < len; i++)
/*     */       {
/* 137 */         Element elem = (Element)nodeList.get(i);
/* 138 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.chart.confbean.SChartSubTypeCfg"))
/*     */         {
/*     */ 
/* 141 */           SChartSubTypeCfg obj = new SChartSubTypeCfg();
/* 142 */           obj.loadFromXml(elem);
/* 143 */           if (all.put(Integer.valueOf(obj.chartType), obj) != null) {
/* 144 */             throw new RuntimeException("duplicate key : " + obj.chartType);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 149 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 155 */     all = new java.util.HashMap();
/*     */     
/* 157 */     String path = dir + "mzm.gsp.chart.confbean.SChartSubTypeCfg.bny";
/*     */     try
/*     */     {
/* 160 */       File file = new File(path);
/* 161 */       if (file.exists())
/*     */       {
/* 163 */         byte[] bytes = new byte['Ѐ'];
/* 164 */         FileInputStream fis = new FileInputStream(file);
/* 165 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 166 */         int len = 0;
/* 167 */         while ((len = fis.read(bytes)) > 0)
/* 168 */           baos.write(bytes, 0, len);
/* 169 */         fis.close();
/* 170 */         bytes = baos.toByteArray();
/* 171 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 172 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 174 */           _os_.unmarshal_int();
/* 175 */           _os_.unmarshal_int();
/* 176 */           _os_.unmarshal_int();
/*     */         }
/* 178 */         _os_.unmarshal_int();
/* 179 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 182 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 184 */           SChartSubTypeCfg _v_ = new SChartSubTypeCfg();
/* 185 */           _v_.unmarshal(_os_);
/* 186 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 187 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 192 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 197 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SChartSubTypeCfg> all)
/*     */   {
/* 204 */     String path = dir + "mzm.gsp.chart.confbean.SChartSubTypeCfg.bny";
/*     */     try
/*     */     {
/* 207 */       File file = new File(path);
/* 208 */       if (file.exists())
/*     */       {
/* 210 */         byte[] bytes = new byte['Ѐ'];
/* 211 */         FileInputStream fis = new FileInputStream(file);
/* 212 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 213 */         int len = 0;
/* 214 */         while ((len = fis.read(bytes)) > 0)
/* 215 */           baos.write(bytes, 0, len);
/* 216 */         fis.close();
/* 217 */         bytes = baos.toByteArray();
/* 218 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 219 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 221 */           _os_.unmarshal_int();
/* 222 */           _os_.unmarshal_int();
/* 223 */           _os_.unmarshal_int();
/*     */         }
/* 225 */         _os_.unmarshal_int();
/* 226 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 229 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 231 */           SChartSubTypeCfg _v_ = new SChartSubTypeCfg();
/* 232 */           _v_.unmarshal(_os_);
/* 233 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 234 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 239 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 244 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SChartSubTypeCfg getOld(int key)
/*     */   {
/* 252 */     return (SChartSubTypeCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SChartSubTypeCfg get(int key)
/*     */   {
/* 257 */     return (SChartSubTypeCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SChartSubTypeCfg> getOldAll()
/*     */   {
/* 262 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SChartSubTypeCfg> getAll()
/*     */   {
/* 267 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SChartSubTypeCfg> newAll)
/*     */   {
/* 272 */     oldAll = all;
/* 273 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 278 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\confbean\SChartSubTypeCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */