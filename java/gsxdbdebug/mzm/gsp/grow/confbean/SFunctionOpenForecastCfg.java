/*     */ package mzm.gsp.grow.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SFunctionOpenForecastCfg extends SLevelTargetCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SFunctionOpenForecastCfg> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SFunctionOpenForecastCfg> all = null;
/*     */   
/*     */ 
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  22 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  23 */     this.templateName = rootElement.attributeValue("templateName");
/*  24 */     this.moduleType = Integer.valueOf(rootElement.attributeValue("moduleType")).intValue();
/*  25 */     this.openLevel = Integer.valueOf(rootElement.attributeValue("openLevel")).intValue();
/*  26 */     this.goalType = Integer.valueOf(rootElement.attributeValue("goalType")).intValue();
/*  27 */     this.title = rootElement.attributeValue("title");
/*  28 */     this.goalDes = rootElement.attributeValue("goalDes");
/*  29 */     this.iconId = Integer.valueOf(rootElement.attributeValue("iconId")).intValue();
/*  30 */     this.fixAwardId = Integer.valueOf(rootElement.attributeValue("fixAwardId")).intValue();
/*     */     
/*  32 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "goalParameters");
/*  33 */     if (collectionElement == null)
/*     */     {
/*  35 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  38 */     List<?> _nodeList = collectionElement.elements();
/*  39 */     int _len = _nodeList.size();
/*  40 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  42 */       Element elem = (Element)_nodeList.get(i);
/*  43 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.grow.confbean.GoalParameter"))
/*     */       {
/*     */         GoalParameter _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  50 */           _v_ = new GoalParameter();
/*  51 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  58 */         this.goalParameters.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  65 */     _os_.marshal(this.id);
/*  66 */     _os_.marshal(this.templateName, "UTF-8");
/*  67 */     _os_.marshal(this.moduleType);
/*  68 */     _os_.marshal(this.openLevel);
/*  69 */     _os_.marshal(this.goalType);
/*  70 */     _os_.marshal(this.title, "UTF-8");
/*  71 */     _os_.marshal(this.goalDes, "UTF-8");
/*  72 */     _os_.marshal(this.iconId);
/*  73 */     _os_.marshal(this.fixAwardId);
/*  74 */     _os_.compact_uint32(this.goalParameters.size());
/*  75 */     for (GoalParameter _v_ : this.goalParameters)
/*     */     {
/*  77 */       _os_.marshal(_v_);
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  84 */     this.id = _os_.unmarshal_int();
/*  85 */     this.templateName = _os_.unmarshal_String("UTF-8");
/*  86 */     this.moduleType = _os_.unmarshal_int();
/*  87 */     this.openLevel = _os_.unmarshal_int();
/*  88 */     this.goalType = _os_.unmarshal_int();
/*  89 */     this.title = _os_.unmarshal_String("UTF-8");
/*  90 */     this.goalDes = _os_.unmarshal_String("UTF-8");
/*  91 */     this.iconId = _os_.unmarshal_int();
/*  92 */     this.fixAwardId = _os_.unmarshal_int();
/*  93 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  96 */       GoalParameter _v_ = new GoalParameter();
/*  97 */       _v_.unmarshal(_os_);
/*  98 */       this.goalParameters.add(_v_);
/*     */     }
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 105 */     String path = dir + "mzm.gsp.grow.confbean.SFunctionOpenForecastCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 109 */       all = new java.util.HashMap();
/* 110 */       SAXReader reader = new SAXReader();
/* 111 */       org.dom4j.Document doc = reader.read(new File(path));
/* 112 */       Element root = doc.getRootElement();
/* 113 */       List<?> nodeList = root.elements();
/* 114 */       int len = nodeList.size();
/* 115 */       for (int i = 0; i < len; i++)
/*     */       {
/* 117 */         Element elem = (Element)nodeList.get(i);
/* 118 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.grow.confbean.SFunctionOpenForecastCfg"))
/*     */         {
/*     */ 
/* 121 */           SFunctionOpenForecastCfg obj = new SFunctionOpenForecastCfg();
/* 122 */           obj.loadFromXml(elem);
/* 123 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 124 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 129 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SFunctionOpenForecastCfg> all)
/*     */   {
/* 135 */     String path = dir + "mzm.gsp.grow.confbean.SFunctionOpenForecastCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 139 */       SAXReader reader = new SAXReader();
/* 140 */       org.dom4j.Document doc = reader.read(new File(path));
/* 141 */       Element root = doc.getRootElement();
/* 142 */       List<?> nodeList = root.elements();
/* 143 */       int len = nodeList.size();
/* 144 */       for (int i = 0; i < len; i++)
/*     */       {
/* 146 */         Element elem = (Element)nodeList.get(i);
/* 147 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.grow.confbean.SFunctionOpenForecastCfg"))
/*     */         {
/*     */ 
/* 150 */           SFunctionOpenForecastCfg obj = new SFunctionOpenForecastCfg();
/* 151 */           obj.loadFromXml(elem);
/* 152 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 153 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 158 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 164 */     all = new java.util.HashMap();
/*     */     
/* 166 */     String path = dir + "mzm.gsp.grow.confbean.SFunctionOpenForecastCfg.bny";
/*     */     try
/*     */     {
/* 169 */       File file = new File(path);
/* 170 */       if (file.exists())
/*     */       {
/* 172 */         byte[] bytes = new byte['Ѐ'];
/* 173 */         FileInputStream fis = new FileInputStream(file);
/* 174 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 175 */         int len = 0;
/* 176 */         while ((len = fis.read(bytes)) > 0)
/* 177 */           baos.write(bytes, 0, len);
/* 178 */         fis.close();
/* 179 */         bytes = baos.toByteArray();
/* 180 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 181 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 183 */           _os_.unmarshal_int();
/* 184 */           _os_.unmarshal_int();
/* 185 */           _os_.unmarshal_int();
/*     */         }
/* 187 */         _os_.unmarshal_int();
/* 188 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 191 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 193 */           SFunctionOpenForecastCfg _v_ = new SFunctionOpenForecastCfg();
/* 194 */           _v_.unmarshal(_os_);
/* 195 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 196 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 201 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 206 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SFunctionOpenForecastCfg> all)
/*     */   {
/* 213 */     String path = dir + "mzm.gsp.grow.confbean.SFunctionOpenForecastCfg.bny";
/*     */     try
/*     */     {
/* 216 */       File file = new File(path);
/* 217 */       if (file.exists())
/*     */       {
/* 219 */         byte[] bytes = new byte['Ѐ'];
/* 220 */         FileInputStream fis = new FileInputStream(file);
/* 221 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 222 */         int len = 0;
/* 223 */         while ((len = fis.read(bytes)) > 0)
/* 224 */           baos.write(bytes, 0, len);
/* 225 */         fis.close();
/* 226 */         bytes = baos.toByteArray();
/* 227 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 228 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 230 */           _os_.unmarshal_int();
/* 231 */           _os_.unmarshal_int();
/* 232 */           _os_.unmarshal_int();
/*     */         }
/* 234 */         _os_.unmarshal_int();
/* 235 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 238 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 240 */           SFunctionOpenForecastCfg _v_ = new SFunctionOpenForecastCfg();
/* 241 */           _v_.unmarshal(_os_);
/* 242 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 243 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 248 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 253 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 259 */     for (Map.Entry<Integer, SFunctionOpenForecastCfg> entry : all.entrySet())
/*     */     {
/* 261 */       if (SLevelTargetCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 263 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 267 */       SLevelTargetCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SFunctionOpenForecastCfg> all, Map<Integer, SLevelTargetCfg> parent)
/*     */   {
/* 274 */     for (Map.Entry<Integer, SFunctionOpenForecastCfg> entry : all.entrySet())
/*     */     {
/* 276 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 278 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 282 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SFunctionOpenForecastCfg getOld(int key)
/*     */   {
/* 289 */     return (SFunctionOpenForecastCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SFunctionOpenForecastCfg get(int key)
/*     */   {
/* 294 */     return (SFunctionOpenForecastCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFunctionOpenForecastCfg> getOldAllSelf()
/*     */   {
/* 299 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFunctionOpenForecastCfg> getAllSelf()
/*     */   {
/* 304 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SFunctionOpenForecastCfg> newAll)
/*     */   {
/* 309 */     oldAll = all;
/* 310 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 315 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\confbean\SFunctionOpenForecastCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */