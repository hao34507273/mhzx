/*     */ package mzm.gsp.instance.confbean;
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
/*     */ public class SInstanceCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SInstanceCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SInstanceCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int instanceType;
/*     */   public int level;
/*     */   public int closeLevel;
/*     */   public int memberCount;
/*     */   public int itemid;
/*     */   public int in_mapid;
/*     */   public int in_x;
/*     */   public int in_y;
/*     */   public int timeLimit;
/*     */   public int out_mapid;
/*     */   public int out_x;
/*     */   public int out_y;
/*     */   public int fightType;
/*     */   public int finishTime;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  36 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  37 */     this.instanceType = Integer.valueOf(rootElement.attributeValue("instanceType")).intValue();
/*  38 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*  39 */     this.closeLevel = Integer.valueOf(rootElement.attributeValue("closeLevel")).intValue();
/*  40 */     this.memberCount = Integer.valueOf(rootElement.attributeValue("memberCount")).intValue();
/*  41 */     this.itemid = Integer.valueOf(rootElement.attributeValue("itemid")).intValue();
/*  42 */     this.in_mapid = Integer.valueOf(rootElement.attributeValue("in_mapid")).intValue();
/*  43 */     this.in_x = Integer.valueOf(rootElement.attributeValue("in_x")).intValue();
/*  44 */     this.in_y = Integer.valueOf(rootElement.attributeValue("in_y")).intValue();
/*  45 */     this.timeLimit = Integer.valueOf(rootElement.attributeValue("timeLimit")).intValue();
/*  46 */     this.out_mapid = Integer.valueOf(rootElement.attributeValue("out_mapid")).intValue();
/*  47 */     this.out_x = Integer.valueOf(rootElement.attributeValue("out_x")).intValue();
/*  48 */     this.out_y = Integer.valueOf(rootElement.attributeValue("out_y")).intValue();
/*  49 */     this.fightType = Integer.valueOf(rootElement.attributeValue("fightType")).intValue();
/*  50 */     this.finishTime = Integer.valueOf(rootElement.attributeValue("finishTime")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  55 */     _os_.marshal(this.id);
/*  56 */     _os_.marshal(this.instanceType);
/*  57 */     _os_.marshal(this.level);
/*  58 */     _os_.marshal(this.closeLevel);
/*  59 */     _os_.marshal(this.memberCount);
/*  60 */     _os_.marshal(this.itemid);
/*  61 */     _os_.marshal(this.in_mapid);
/*  62 */     _os_.marshal(this.in_x);
/*  63 */     _os_.marshal(this.in_y);
/*  64 */     _os_.marshal(this.timeLimit);
/*  65 */     _os_.marshal(this.out_mapid);
/*  66 */     _os_.marshal(this.out_x);
/*  67 */     _os_.marshal(this.out_y);
/*  68 */     _os_.marshal(this.fightType);
/*  69 */     _os_.marshal(this.finishTime);
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     this.id = _os_.unmarshal_int();
/*  76 */     this.instanceType = _os_.unmarshal_int();
/*  77 */     this.level = _os_.unmarshal_int();
/*  78 */     this.closeLevel = _os_.unmarshal_int();
/*  79 */     this.memberCount = _os_.unmarshal_int();
/*  80 */     this.itemid = _os_.unmarshal_int();
/*  81 */     this.in_mapid = _os_.unmarshal_int();
/*  82 */     this.in_x = _os_.unmarshal_int();
/*  83 */     this.in_y = _os_.unmarshal_int();
/*  84 */     this.timeLimit = _os_.unmarshal_int();
/*  85 */     this.out_mapid = _os_.unmarshal_int();
/*  86 */     this.out_x = _os_.unmarshal_int();
/*  87 */     this.out_y = _os_.unmarshal_int();
/*  88 */     this.fightType = _os_.unmarshal_int();
/*  89 */     this.finishTime = _os_.unmarshal_int();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  95 */     String path = dir + "mzm.gsp.instance.confbean.SInstanceCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  99 */       all = new java.util.HashMap();
/* 100 */       SAXReader reader = new SAXReader();
/* 101 */       org.dom4j.Document doc = reader.read(new File(path));
/* 102 */       Element root = doc.getRootElement();
/* 103 */       List<?> nodeList = root.elements();
/* 104 */       int len = nodeList.size();
/* 105 */       for (int i = 0; i < len; i++)
/*     */       {
/* 107 */         Element elem = (Element)nodeList.get(i);
/* 108 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.instance.confbean.SInstanceCfg"))
/*     */         {
/*     */ 
/* 111 */           SInstanceCfg obj = new SInstanceCfg();
/* 112 */           obj.loadFromXml(elem);
/* 113 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 114 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 119 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SInstanceCfg> all)
/*     */   {
/* 125 */     String path = dir + "mzm.gsp.instance.confbean.SInstanceCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 129 */       SAXReader reader = new SAXReader();
/* 130 */       org.dom4j.Document doc = reader.read(new File(path));
/* 131 */       Element root = doc.getRootElement();
/* 132 */       List<?> nodeList = root.elements();
/* 133 */       int len = nodeList.size();
/* 134 */       for (int i = 0; i < len; i++)
/*     */       {
/* 136 */         Element elem = (Element)nodeList.get(i);
/* 137 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.instance.confbean.SInstanceCfg"))
/*     */         {
/*     */ 
/* 140 */           SInstanceCfg obj = new SInstanceCfg();
/* 141 */           obj.loadFromXml(elem);
/* 142 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 143 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 148 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 154 */     all = new java.util.HashMap();
/*     */     
/* 156 */     String path = dir + "mzm.gsp.instance.confbean.SInstanceCfg.bny";
/*     */     try
/*     */     {
/* 159 */       File file = new File(path);
/* 160 */       if (file.exists())
/*     */       {
/* 162 */         byte[] bytes = new byte['Ѐ'];
/* 163 */         FileInputStream fis = new FileInputStream(file);
/* 164 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 165 */         int len = 0;
/* 166 */         while ((len = fis.read(bytes)) > 0)
/* 167 */           baos.write(bytes, 0, len);
/* 168 */         fis.close();
/* 169 */         bytes = baos.toByteArray();
/* 170 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 171 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 173 */           _os_.unmarshal_int();
/* 174 */           _os_.unmarshal_int();
/* 175 */           _os_.unmarshal_int();
/*     */         }
/* 177 */         _os_.unmarshal_int();
/* 178 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 181 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 183 */           SInstanceCfg _v_ = new SInstanceCfg();
/* 184 */           _v_.unmarshal(_os_);
/* 185 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 186 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 191 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 196 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SInstanceCfg> all)
/*     */   {
/* 203 */     String path = dir + "mzm.gsp.instance.confbean.SInstanceCfg.bny";
/*     */     try
/*     */     {
/* 206 */       File file = new File(path);
/* 207 */       if (file.exists())
/*     */       {
/* 209 */         byte[] bytes = new byte['Ѐ'];
/* 210 */         FileInputStream fis = new FileInputStream(file);
/* 211 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 212 */         int len = 0;
/* 213 */         while ((len = fis.read(bytes)) > 0)
/* 214 */           baos.write(bytes, 0, len);
/* 215 */         fis.close();
/* 216 */         bytes = baos.toByteArray();
/* 217 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 218 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 220 */           _os_.unmarshal_int();
/* 221 */           _os_.unmarshal_int();
/* 222 */           _os_.unmarshal_int();
/*     */         }
/* 224 */         _os_.unmarshal_int();
/* 225 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 228 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 230 */           SInstanceCfg _v_ = new SInstanceCfg();
/* 231 */           _v_.unmarshal(_os_);
/* 232 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 233 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 238 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 243 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SInstanceCfg getOld(int key)
/*     */   {
/* 251 */     return (SInstanceCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SInstanceCfg get(int key)
/*     */   {
/* 256 */     return (SInstanceCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SInstanceCfg> getOldAll()
/*     */   {
/* 261 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SInstanceCfg> getAll()
/*     */   {
/* 266 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SInstanceCfg> newAll)
/*     */   {
/* 271 */     oldAll = all;
/* 272 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 277 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\confbean\SInstanceCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */