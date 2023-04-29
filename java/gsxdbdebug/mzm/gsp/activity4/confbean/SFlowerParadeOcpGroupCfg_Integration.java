/*     */ package mzm.gsp.activity4.confbean;
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
/*     */ public class SFlowerParadeOcpGroupCfg_Integration implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SFlowerParadeOcpGroupCfg_Integration> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SFlowerParadeOcpGroupCfg_Integration> all = null;
/*     */   
/*     */   public int id;
/*     */   public int groupId;
/*     */   public int ocpId;
/*     */   public int modelId;
/*     */   public int flagId;
/*     */   public int effectId;
/*     */   public int radius;
/*     */   public int ocpRole1;
/*     */   public int ocpRole2;
/*     */   public int chosenTime;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  31 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  32 */     this.groupId = Integer.valueOf(rootElement.attributeValue("groupId")).intValue();
/*  33 */     this.ocpId = Integer.valueOf(rootElement.attributeValue("ocpId")).intValue();
/*  34 */     this.modelId = Integer.valueOf(rootElement.attributeValue("modelId")).intValue();
/*  35 */     this.flagId = Integer.valueOf(rootElement.attributeValue("flagId")).intValue();
/*  36 */     this.effectId = Integer.valueOf(rootElement.attributeValue("effectId")).intValue();
/*  37 */     this.radius = Integer.valueOf(rootElement.attributeValue("radius")).intValue();
/*  38 */     this.ocpRole1 = Integer.valueOf(rootElement.attributeValue("ocpRole1")).intValue();
/*  39 */     this.ocpRole2 = Integer.valueOf(rootElement.attributeValue("ocpRole2")).intValue();
/*  40 */     this.chosenTime = Integer.valueOf(rootElement.attributeValue("chosenTime")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  45 */     _os_.marshal(this.id);
/*  46 */     _os_.marshal(this.groupId);
/*  47 */     _os_.marshal(this.ocpId);
/*  48 */     _os_.marshal(this.modelId);
/*  49 */     _os_.marshal(this.flagId);
/*  50 */     _os_.marshal(this.effectId);
/*  51 */     _os_.marshal(this.radius);
/*  52 */     _os_.marshal(this.ocpRole1);
/*  53 */     _os_.marshal(this.ocpRole2);
/*  54 */     _os_.marshal(this.chosenTime);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  60 */     this.id = _os_.unmarshal_int();
/*  61 */     this.groupId = _os_.unmarshal_int();
/*  62 */     this.ocpId = _os_.unmarshal_int();
/*  63 */     this.modelId = _os_.unmarshal_int();
/*  64 */     this.flagId = _os_.unmarshal_int();
/*  65 */     this.effectId = _os_.unmarshal_int();
/*  66 */     this.radius = _os_.unmarshal_int();
/*  67 */     this.ocpRole1 = _os_.unmarshal_int();
/*  68 */     this.ocpRole2 = _os_.unmarshal_int();
/*  69 */     this.chosenTime = _os_.unmarshal_int();
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  75 */     String path = dir + "mzm.gsp.activity4.confbean.SFlowerParadeOcpGroupCfg_Integration.xml";
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
/*  88 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity4.confbean.SFlowerParadeOcpGroupCfg_Integration"))
/*     */         {
/*     */ 
/*  91 */           SFlowerParadeOcpGroupCfg_Integration obj = new SFlowerParadeOcpGroupCfg_Integration();
/*  92 */           obj.loadFromXml(elem);
/*  93 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  94 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  99 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SFlowerParadeOcpGroupCfg_Integration> all)
/*     */   {
/* 105 */     String path = dir + "mzm.gsp.activity4.confbean.SFlowerParadeOcpGroupCfg_Integration.xml";
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
/* 117 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity4.confbean.SFlowerParadeOcpGroupCfg_Integration"))
/*     */         {
/*     */ 
/* 120 */           SFlowerParadeOcpGroupCfg_Integration obj = new SFlowerParadeOcpGroupCfg_Integration();
/* 121 */           obj.loadFromXml(elem);
/* 122 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 123 */             throw new RuntimeException("duplicate key : " + obj.id);
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
/* 136 */     String path = dir + "mzm.gsp.activity4.confbean.SFlowerParadeOcpGroupCfg_Integration.bny";
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
/* 163 */           SFlowerParadeOcpGroupCfg_Integration _v_ = new SFlowerParadeOcpGroupCfg_Integration();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, SFlowerParadeOcpGroupCfg_Integration> all)
/*     */   {
/* 183 */     String path = dir + "mzm.gsp.activity4.confbean.SFlowerParadeOcpGroupCfg_Integration.bny";
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
/* 210 */           SFlowerParadeOcpGroupCfg_Integration _v_ = new SFlowerParadeOcpGroupCfg_Integration();
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
/*     */   public static SFlowerParadeOcpGroupCfg_Integration getOld(int key)
/*     */   {
/* 231 */     return (SFlowerParadeOcpGroupCfg_Integration)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SFlowerParadeOcpGroupCfg_Integration get(int key)
/*     */   {
/* 236 */     return (SFlowerParadeOcpGroupCfg_Integration)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFlowerParadeOcpGroupCfg_Integration> getOldAll()
/*     */   {
/* 241 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFlowerParadeOcpGroupCfg_Integration> getAll()
/*     */   {
/* 246 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SFlowerParadeOcpGroupCfg_Integration> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity4\confbean\SFlowerParadeOcpGroupCfg_Integration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */