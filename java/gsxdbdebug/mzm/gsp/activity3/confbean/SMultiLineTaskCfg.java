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
/*     */ public class SMultiLineTaskCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMultiLineTaskCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMultiLineTaskCfg> all = null;
/*     */   
/*     */   public int activityId;
/*     */   public int openId;
/*     */   public int npcid;
/*     */   public int serviceid;
/*     */   public int controller;
/*     */   public int graphId;
/*     */   public int awardCircleSum;
/*     */   public int awardId;
/*     */   public boolean needMod;
/*     */   public int defaultModId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  31 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/*  32 */     this.openId = Integer.valueOf(rootElement.attributeValue("openId")).intValue();
/*  33 */     this.npcid = Integer.valueOf(rootElement.attributeValue("npcid")).intValue();
/*  34 */     this.serviceid = Integer.valueOf(rootElement.attributeValue("serviceid")).intValue();
/*  35 */     this.controller = Integer.valueOf(rootElement.attributeValue("controller")).intValue();
/*  36 */     this.graphId = Integer.valueOf(rootElement.attributeValue("graphId")).intValue();
/*  37 */     this.awardCircleSum = Integer.valueOf(rootElement.attributeValue("awardCircleSum")).intValue();
/*  38 */     this.awardId = Integer.valueOf(rootElement.attributeValue("awardId")).intValue();
/*  39 */     this.needMod = Boolean.valueOf(rootElement.attributeValue("needMod")).booleanValue();
/*  40 */     this.defaultModId = Integer.valueOf(rootElement.attributeValue("defaultModId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  45 */     _os_.marshal(this.activityId);
/*  46 */     _os_.marshal(this.openId);
/*  47 */     _os_.marshal(this.npcid);
/*  48 */     _os_.marshal(this.serviceid);
/*  49 */     _os_.marshal(this.controller);
/*  50 */     _os_.marshal(this.graphId);
/*  51 */     _os_.marshal(this.awardCircleSum);
/*  52 */     _os_.marshal(this.awardId);
/*  53 */     _os_.marshal(this.needMod);
/*  54 */     _os_.marshal(this.defaultModId);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  60 */     this.activityId = _os_.unmarshal_int();
/*  61 */     this.openId = _os_.unmarshal_int();
/*  62 */     this.npcid = _os_.unmarshal_int();
/*  63 */     this.serviceid = _os_.unmarshal_int();
/*  64 */     this.controller = _os_.unmarshal_int();
/*  65 */     this.graphId = _os_.unmarshal_int();
/*  66 */     this.awardCircleSum = _os_.unmarshal_int();
/*  67 */     this.awardId = _os_.unmarshal_int();
/*  68 */     this.needMod = _os_.unmarshal_boolean();
/*  69 */     this.defaultModId = _os_.unmarshal_int();
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  75 */     String path = dir + "mzm.gsp.activity3.confbean.SMultiLineTaskCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  79 */       all = new java.util.HashMap();
/*  80 */       SAXReader reader = new SAXReader();
/*  81 */       org.dom4j.Document doc = reader.read(new File(path));
/*  82 */       Element root = doc.getRootElement();
/*  83 */       List<?> nodeList = root.elements();
/*  84 */       int len = nodeList.size();
/*  85 */       for (int i = 0; i < len; i++)
/*     */       {
/*  87 */         Element elem = (Element)nodeList.get(i);
/*  88 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.SMultiLineTaskCfg"))
/*     */         {
/*     */ 
/*  91 */           SMultiLineTaskCfg obj = new SMultiLineTaskCfg();
/*  92 */           obj.loadFromXml(elem);
/*  93 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/*  94 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  99 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMultiLineTaskCfg> all)
/*     */   {
/* 105 */     String path = dir + "mzm.gsp.activity3.confbean.SMultiLineTaskCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 109 */       SAXReader reader = new SAXReader();
/* 110 */       org.dom4j.Document doc = reader.read(new File(path));
/* 111 */       Element root = doc.getRootElement();
/* 112 */       List<?> nodeList = root.elements();
/* 113 */       int len = nodeList.size();
/* 114 */       for (int i = 0; i < len; i++)
/*     */       {
/* 116 */         Element elem = (Element)nodeList.get(i);
/* 117 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.SMultiLineTaskCfg"))
/*     */         {
/*     */ 
/* 120 */           SMultiLineTaskCfg obj = new SMultiLineTaskCfg();
/* 121 */           obj.loadFromXml(elem);
/* 122 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 123 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 128 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 134 */     all = new java.util.HashMap();
/*     */     
/* 136 */     String path = dir + "mzm.gsp.activity3.confbean.SMultiLineTaskCfg.bny";
/*     */     try
/*     */     {
/* 139 */       File file = new File(path);
/* 140 */       if (file.exists())
/*     */       {
/* 142 */         byte[] bytes = new byte['Ѐ'];
/* 143 */         FileInputStream fis = new FileInputStream(file);
/* 144 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 145 */         int len = 0;
/* 146 */         while ((len = fis.read(bytes)) > 0)
/* 147 */           baos.write(bytes, 0, len);
/* 148 */         fis.close();
/* 149 */         bytes = baos.toByteArray();
/* 150 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 151 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 153 */           _os_.unmarshal_int();
/* 154 */           _os_.unmarshal_int();
/* 155 */           _os_.unmarshal_int();
/*     */         }
/* 157 */         _os_.unmarshal_int();
/* 158 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 161 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 163 */           SMultiLineTaskCfg _v_ = new SMultiLineTaskCfg();
/* 164 */           _v_.unmarshal(_os_);
/* 165 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 166 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 171 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 176 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMultiLineTaskCfg> all)
/*     */   {
/* 183 */     String path = dir + "mzm.gsp.activity3.confbean.SMultiLineTaskCfg.bny";
/*     */     try
/*     */     {
/* 186 */       File file = new File(path);
/* 187 */       if (file.exists())
/*     */       {
/* 189 */         byte[] bytes = new byte['Ѐ'];
/* 190 */         FileInputStream fis = new FileInputStream(file);
/* 191 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 192 */         int len = 0;
/* 193 */         while ((len = fis.read(bytes)) > 0)
/* 194 */           baos.write(bytes, 0, len);
/* 195 */         fis.close();
/* 196 */         bytes = baos.toByteArray();
/* 197 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 198 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 200 */           _os_.unmarshal_int();
/* 201 */           _os_.unmarshal_int();
/* 202 */           _os_.unmarshal_int();
/*     */         }
/* 204 */         _os_.unmarshal_int();
/* 205 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 208 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 210 */           SMultiLineTaskCfg _v_ = new SMultiLineTaskCfg();
/* 211 */           _v_.unmarshal(_os_);
/* 212 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 213 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 218 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 223 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SMultiLineTaskCfg getOld(int key)
/*     */   {
/* 231 */     return (SMultiLineTaskCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMultiLineTaskCfg get(int key)
/*     */   {
/* 236 */     return (SMultiLineTaskCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMultiLineTaskCfg> getOldAll()
/*     */   {
/* 241 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMultiLineTaskCfg> getAll()
/*     */   {
/* 246 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMultiLineTaskCfg> newAll)
/*     */   {
/* 251 */     oldAll = all;
/* 252 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 257 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity3\confbean\SMultiLineTaskCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */