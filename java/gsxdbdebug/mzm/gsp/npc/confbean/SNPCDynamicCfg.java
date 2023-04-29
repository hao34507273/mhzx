/*     */ package mzm.gsp.npc.confbean;
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
/*     */ public class SNPCDynamicCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SNPCDynamicCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SNPCDynamicCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int npcCfgid;
/*     */   public int mapCfgid;
/*     */   public int mainLocation1X;
/*     */   public int mainLocation1Y;
/*     */   public int mainLocation1Z;
/*     */   public int subLocation1X;
/*     */   public int subLocation1Y;
/*     */   public int subLocation1Z;
/*     */   public int mainLocation2X;
/*     */   public int mainLocation2Y;
/*     */   public int mainLocation2Z;
/*     */   public int subLocation2X;
/*     */   public int subLocation2Y;
/*     */   public int subLocation2Z;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  36 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  37 */     this.npcCfgid = Integer.valueOf(rootElement.attributeValue("npcCfgid")).intValue();
/*  38 */     this.mapCfgid = Integer.valueOf(rootElement.attributeValue("mapCfgid")).intValue();
/*  39 */     this.mainLocation1X = Integer.valueOf(rootElement.attributeValue("mainLocation1X")).intValue();
/*  40 */     this.mainLocation1Y = Integer.valueOf(rootElement.attributeValue("mainLocation1Y")).intValue();
/*  41 */     this.mainLocation1Z = Integer.valueOf(rootElement.attributeValue("mainLocation1Z")).intValue();
/*  42 */     this.subLocation1X = Integer.valueOf(rootElement.attributeValue("subLocation1X")).intValue();
/*  43 */     this.subLocation1Y = Integer.valueOf(rootElement.attributeValue("subLocation1Y")).intValue();
/*  44 */     this.subLocation1Z = Integer.valueOf(rootElement.attributeValue("subLocation1Z")).intValue();
/*  45 */     this.mainLocation2X = Integer.valueOf(rootElement.attributeValue("mainLocation2X")).intValue();
/*  46 */     this.mainLocation2Y = Integer.valueOf(rootElement.attributeValue("mainLocation2Y")).intValue();
/*  47 */     this.mainLocation2Z = Integer.valueOf(rootElement.attributeValue("mainLocation2Z")).intValue();
/*  48 */     this.subLocation2X = Integer.valueOf(rootElement.attributeValue("subLocation2X")).intValue();
/*  49 */     this.subLocation2Y = Integer.valueOf(rootElement.attributeValue("subLocation2Y")).intValue();
/*  50 */     this.subLocation2Z = Integer.valueOf(rootElement.attributeValue("subLocation2Z")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  55 */     _os_.marshal(this.id);
/*  56 */     _os_.marshal(this.npcCfgid);
/*  57 */     _os_.marshal(this.mapCfgid);
/*  58 */     _os_.marshal(this.mainLocation1X);
/*  59 */     _os_.marshal(this.mainLocation1Y);
/*  60 */     _os_.marshal(this.mainLocation1Z);
/*  61 */     _os_.marshal(this.subLocation1X);
/*  62 */     _os_.marshal(this.subLocation1Y);
/*  63 */     _os_.marshal(this.subLocation1Z);
/*  64 */     _os_.marshal(this.mainLocation2X);
/*  65 */     _os_.marshal(this.mainLocation2Y);
/*  66 */     _os_.marshal(this.mainLocation2Z);
/*  67 */     _os_.marshal(this.subLocation2X);
/*  68 */     _os_.marshal(this.subLocation2Y);
/*  69 */     _os_.marshal(this.subLocation2Z);
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     this.id = _os_.unmarshal_int();
/*  76 */     this.npcCfgid = _os_.unmarshal_int();
/*  77 */     this.mapCfgid = _os_.unmarshal_int();
/*  78 */     this.mainLocation1X = _os_.unmarshal_int();
/*  79 */     this.mainLocation1Y = _os_.unmarshal_int();
/*  80 */     this.mainLocation1Z = _os_.unmarshal_int();
/*  81 */     this.subLocation1X = _os_.unmarshal_int();
/*  82 */     this.subLocation1Y = _os_.unmarshal_int();
/*  83 */     this.subLocation1Z = _os_.unmarshal_int();
/*  84 */     this.mainLocation2X = _os_.unmarshal_int();
/*  85 */     this.mainLocation2Y = _os_.unmarshal_int();
/*  86 */     this.mainLocation2Z = _os_.unmarshal_int();
/*  87 */     this.subLocation2X = _os_.unmarshal_int();
/*  88 */     this.subLocation2Y = _os_.unmarshal_int();
/*  89 */     this.subLocation2Z = _os_.unmarshal_int();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  95 */     String path = dir + "mzm.gsp.npc.confbean.SNPCDynamicCfg.xml";
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
/* 108 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.npc.confbean.SNPCDynamicCfg"))
/*     */         {
/*     */ 
/* 111 */           SNPCDynamicCfg obj = new SNPCDynamicCfg();
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
/*     */   public static void reLoadXml(String dir, Map<Integer, SNPCDynamicCfg> all)
/*     */   {
/* 125 */     String path = dir + "mzm.gsp.npc.confbean.SNPCDynamicCfg.xml";
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
/* 137 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.npc.confbean.SNPCDynamicCfg"))
/*     */         {
/*     */ 
/* 140 */           SNPCDynamicCfg obj = new SNPCDynamicCfg();
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
/* 156 */     String path = dir + "mzm.gsp.npc.confbean.SNPCDynamicCfg.bny";
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
/* 183 */           SNPCDynamicCfg _v_ = new SNPCDynamicCfg();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, SNPCDynamicCfg> all)
/*     */   {
/* 203 */     String path = dir + "mzm.gsp.npc.confbean.SNPCDynamicCfg.bny";
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
/* 230 */           SNPCDynamicCfg _v_ = new SNPCDynamicCfg();
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
/*     */   public static SNPCDynamicCfg getOld(int key)
/*     */   {
/* 251 */     return (SNPCDynamicCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SNPCDynamicCfg get(int key)
/*     */   {
/* 256 */     return (SNPCDynamicCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SNPCDynamicCfg> getOldAll()
/*     */   {
/* 261 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SNPCDynamicCfg> getAll()
/*     */   {
/* 266 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SNPCDynamicCfg> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\confbean\SNPCDynamicCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */