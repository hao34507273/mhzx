/*     */ package mzm.gsp.activity.confbean;
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
/*     */ public class SingleTaskCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SingleTaskCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SingleTaskCfg> all = null;
/*     */   
/*     */   public int activityId;
/*     */   public int npcid;
/*     */   public int serviceid;
/*     */   public int controller;
/*     */   public int guyNum;
/*     */   public int openId;
/*     */   public int graphLibId;
/*     */   public int ranType;
/*     */   public boolean popTipPerCircle;
/*     */   public boolean autoGetGraph;
/*     */   public boolean atuoNextTask;
/*     */   public int circleSum;
/*     */   public int awardId;
/*     */   public boolean needMod;
/*     */   public int defaultModId;
/*     */   public int storExpExchangeRate;
/*     */   public boolean needChivalry;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  38 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/*  39 */     this.npcid = Integer.valueOf(rootElement.attributeValue("npcid")).intValue();
/*  40 */     this.serviceid = Integer.valueOf(rootElement.attributeValue("serviceid")).intValue();
/*  41 */     this.controller = Integer.valueOf(rootElement.attributeValue("controller")).intValue();
/*  42 */     this.guyNum = Integer.valueOf(rootElement.attributeValue("guyNum")).intValue();
/*  43 */     this.openId = Integer.valueOf(rootElement.attributeValue("openId")).intValue();
/*  44 */     this.graphLibId = Integer.valueOf(rootElement.attributeValue("graphLibId")).intValue();
/*  45 */     this.ranType = Integer.valueOf(rootElement.attributeValue("ranType")).intValue();
/*  46 */     this.popTipPerCircle = Boolean.valueOf(rootElement.attributeValue("popTipPerCircle")).booleanValue();
/*  47 */     this.autoGetGraph = Boolean.valueOf(rootElement.attributeValue("autoGetGraph")).booleanValue();
/*  48 */     this.atuoNextTask = Boolean.valueOf(rootElement.attributeValue("atuoNextTask")).booleanValue();
/*  49 */     this.circleSum = Integer.valueOf(rootElement.attributeValue("circleSum")).intValue();
/*  50 */     this.awardId = Integer.valueOf(rootElement.attributeValue("awardId")).intValue();
/*  51 */     this.needMod = Boolean.valueOf(rootElement.attributeValue("needMod")).booleanValue();
/*  52 */     this.defaultModId = Integer.valueOf(rootElement.attributeValue("defaultModId")).intValue();
/*  53 */     this.storExpExchangeRate = Integer.valueOf(rootElement.attributeValue("storExpExchangeRate")).intValue();
/*  54 */     this.needChivalry = Boolean.valueOf(rootElement.attributeValue("needChivalry")).booleanValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  59 */     _os_.marshal(this.activityId);
/*  60 */     _os_.marshal(this.npcid);
/*  61 */     _os_.marshal(this.serviceid);
/*  62 */     _os_.marshal(this.controller);
/*  63 */     _os_.marshal(this.guyNum);
/*  64 */     _os_.marshal(this.openId);
/*  65 */     _os_.marshal(this.graphLibId);
/*  66 */     _os_.marshal(this.ranType);
/*  67 */     _os_.marshal(this.popTipPerCircle);
/*  68 */     _os_.marshal(this.autoGetGraph);
/*  69 */     _os_.marshal(this.atuoNextTask);
/*  70 */     _os_.marshal(this.circleSum);
/*  71 */     _os_.marshal(this.awardId);
/*  72 */     _os_.marshal(this.needMod);
/*  73 */     _os_.marshal(this.defaultModId);
/*  74 */     _os_.marshal(this.storExpExchangeRate);
/*  75 */     _os_.marshal(this.needChivalry);
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  81 */     this.activityId = _os_.unmarshal_int();
/*  82 */     this.npcid = _os_.unmarshal_int();
/*  83 */     this.serviceid = _os_.unmarshal_int();
/*  84 */     this.controller = _os_.unmarshal_int();
/*  85 */     this.guyNum = _os_.unmarshal_int();
/*  86 */     this.openId = _os_.unmarshal_int();
/*  87 */     this.graphLibId = _os_.unmarshal_int();
/*  88 */     this.ranType = _os_.unmarshal_int();
/*  89 */     this.popTipPerCircle = _os_.unmarshal_boolean();
/*  90 */     this.autoGetGraph = _os_.unmarshal_boolean();
/*  91 */     this.atuoNextTask = _os_.unmarshal_boolean();
/*  92 */     this.circleSum = _os_.unmarshal_int();
/*  93 */     this.awardId = _os_.unmarshal_int();
/*  94 */     this.needMod = _os_.unmarshal_boolean();
/*  95 */     this.defaultModId = _os_.unmarshal_int();
/*  96 */     this.storExpExchangeRate = _os_.unmarshal_int();
/*  97 */     this.needChivalry = _os_.unmarshal_boolean();
/*  98 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 103 */     String path = dir + "mzm.gsp.activity.confbean.SingleTaskCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 107 */       all = new java.util.HashMap();
/* 108 */       SAXReader reader = new SAXReader();
/* 109 */       org.dom4j.Document doc = reader.read(new File(path));
/* 110 */       Element root = doc.getRootElement();
/* 111 */       List<?> nodeList = root.elements();
/* 112 */       int len = nodeList.size();
/* 113 */       for (int i = 0; i < len; i++)
/*     */       {
/* 115 */         Element elem = (Element)nodeList.get(i);
/* 116 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity.confbean.SingleTaskCfg"))
/*     */         {
/*     */ 
/* 119 */           SingleTaskCfg obj = new SingleTaskCfg();
/* 120 */           obj.loadFromXml(elem);
/* 121 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 122 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 127 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SingleTaskCfg> all)
/*     */   {
/* 133 */     String path = dir + "mzm.gsp.activity.confbean.SingleTaskCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 137 */       SAXReader reader = new SAXReader();
/* 138 */       org.dom4j.Document doc = reader.read(new File(path));
/* 139 */       Element root = doc.getRootElement();
/* 140 */       List<?> nodeList = root.elements();
/* 141 */       int len = nodeList.size();
/* 142 */       for (int i = 0; i < len; i++)
/*     */       {
/* 144 */         Element elem = (Element)nodeList.get(i);
/* 145 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity.confbean.SingleTaskCfg"))
/*     */         {
/*     */ 
/* 148 */           SingleTaskCfg obj = new SingleTaskCfg();
/* 149 */           obj.loadFromXml(elem);
/* 150 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 151 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 156 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 162 */     all = new java.util.HashMap();
/*     */     
/* 164 */     String path = dir + "mzm.gsp.activity.confbean.SingleTaskCfg.bny";
/*     */     try
/*     */     {
/* 167 */       File file = new File(path);
/* 168 */       if (file.exists())
/*     */       {
/* 170 */         byte[] bytes = new byte['Ѐ'];
/* 171 */         FileInputStream fis = new FileInputStream(file);
/* 172 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 173 */         int len = 0;
/* 174 */         while ((len = fis.read(bytes)) > 0)
/* 175 */           baos.write(bytes, 0, len);
/* 176 */         fis.close();
/* 177 */         bytes = baos.toByteArray();
/* 178 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 179 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 181 */           _os_.unmarshal_int();
/* 182 */           _os_.unmarshal_int();
/* 183 */           _os_.unmarshal_int();
/*     */         }
/* 185 */         _os_.unmarshal_int();
/* 186 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 189 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 191 */           SingleTaskCfg _v_ = new SingleTaskCfg();
/* 192 */           _v_.unmarshal(_os_);
/* 193 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 194 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 199 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 204 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SingleTaskCfg> all)
/*     */   {
/* 211 */     String path = dir + "mzm.gsp.activity.confbean.SingleTaskCfg.bny";
/*     */     try
/*     */     {
/* 214 */       File file = new File(path);
/* 215 */       if (file.exists())
/*     */       {
/* 217 */         byte[] bytes = new byte['Ѐ'];
/* 218 */         FileInputStream fis = new FileInputStream(file);
/* 219 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 220 */         int len = 0;
/* 221 */         while ((len = fis.read(bytes)) > 0)
/* 222 */           baos.write(bytes, 0, len);
/* 223 */         fis.close();
/* 224 */         bytes = baos.toByteArray();
/* 225 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 226 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 228 */           _os_.unmarshal_int();
/* 229 */           _os_.unmarshal_int();
/* 230 */           _os_.unmarshal_int();
/*     */         }
/* 232 */         _os_.unmarshal_int();
/* 233 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 236 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 238 */           SingleTaskCfg _v_ = new SingleTaskCfg();
/* 239 */           _v_.unmarshal(_os_);
/* 240 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 241 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 246 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 251 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SingleTaskCfg getOld(int key)
/*     */   {
/* 259 */     return (SingleTaskCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SingleTaskCfg get(int key)
/*     */   {
/* 264 */     return (SingleTaskCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SingleTaskCfg> getOldAll()
/*     */   {
/* 269 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SingleTaskCfg> getAll()
/*     */   {
/* 274 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SingleTaskCfg> newAll)
/*     */   {
/* 279 */     oldAll = all;
/* 280 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 285 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\confbean\SingleTaskCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */