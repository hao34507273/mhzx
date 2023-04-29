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
/*     */ public class STFloorHelpCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STFloorHelpCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STFloorHelpCfg> all = null;
/*     */   
/*     */   public int helpLibId;
/*     */   public int awardId;
/*     */   public int countMax;
/*     */   public int floorMin;
/*     */   public int floorMax;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  26 */     this.helpLibId = Integer.valueOf(rootElement.attributeValue("helpLibId")).intValue();
/*  27 */     this.awardId = Integer.valueOf(rootElement.attributeValue("awardId")).intValue();
/*  28 */     this.countMax = Integer.valueOf(rootElement.attributeValue("countMax")).intValue();
/*  29 */     this.floorMin = Integer.valueOf(rootElement.attributeValue("floorMin")).intValue();
/*  30 */     this.floorMax = Integer.valueOf(rootElement.attributeValue("floorMax")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  35 */     _os_.marshal(this.helpLibId);
/*  36 */     _os_.marshal(this.awardId);
/*  37 */     _os_.marshal(this.countMax);
/*  38 */     _os_.marshal(this.floorMin);
/*  39 */     _os_.marshal(this.floorMax);
/*  40 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  45 */     this.helpLibId = _os_.unmarshal_int();
/*  46 */     this.awardId = _os_.unmarshal_int();
/*  47 */     this.countMax = _os_.unmarshal_int();
/*  48 */     this.floorMin = _os_.unmarshal_int();
/*  49 */     this.floorMax = _os_.unmarshal_int();
/*  50 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  55 */     String path = dir + "mzm.gsp.activity3.confbean.STFloorHelpCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  59 */       all = new java.util.HashMap();
/*  60 */       SAXReader reader = new SAXReader();
/*  61 */       org.dom4j.Document doc = reader.read(new File(path));
/*  62 */       Element root = doc.getRootElement();
/*  63 */       List<?> nodeList = root.elements();
/*  64 */       int len = nodeList.size();
/*  65 */       for (int i = 0; i < len; i++)
/*     */       {
/*  67 */         Element elem = (Element)nodeList.get(i);
/*  68 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.STFloorHelpCfg"))
/*     */         {
/*     */ 
/*  71 */           STFloorHelpCfg obj = new STFloorHelpCfg();
/*  72 */           obj.loadFromXml(elem);
/*  73 */           if (all.put(Integer.valueOf(obj.helpLibId), obj) != null) {
/*  74 */             throw new RuntimeException("duplicate key : " + obj.helpLibId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  79 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STFloorHelpCfg> all)
/*     */   {
/*  85 */     String path = dir + "mzm.gsp.activity3.confbean.STFloorHelpCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  89 */       SAXReader reader = new SAXReader();
/*  90 */       org.dom4j.Document doc = reader.read(new File(path));
/*  91 */       Element root = doc.getRootElement();
/*  92 */       List<?> nodeList = root.elements();
/*  93 */       int len = nodeList.size();
/*  94 */       for (int i = 0; i < len; i++)
/*     */       {
/*  96 */         Element elem = (Element)nodeList.get(i);
/*  97 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.STFloorHelpCfg"))
/*     */         {
/*     */ 
/* 100 */           STFloorHelpCfg obj = new STFloorHelpCfg();
/* 101 */           obj.loadFromXml(elem);
/* 102 */           if (all.put(Integer.valueOf(obj.helpLibId), obj) != null) {
/* 103 */             throw new RuntimeException("duplicate key : " + obj.helpLibId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 108 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 114 */     all = new java.util.HashMap();
/*     */     
/* 116 */     String path = dir + "mzm.gsp.activity3.confbean.STFloorHelpCfg.bny";
/*     */     try
/*     */     {
/* 119 */       File file = new File(path);
/* 120 */       if (file.exists())
/*     */       {
/* 122 */         byte[] bytes = new byte['Ѐ'];
/* 123 */         FileInputStream fis = new FileInputStream(file);
/* 124 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 125 */         int len = 0;
/* 126 */         while ((len = fis.read(bytes)) > 0)
/* 127 */           baos.write(bytes, 0, len);
/* 128 */         fis.close();
/* 129 */         bytes = baos.toByteArray();
/* 130 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 131 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 133 */           _os_.unmarshal_int();
/* 134 */           _os_.unmarshal_int();
/* 135 */           _os_.unmarshal_int();
/*     */         }
/* 137 */         _os_.unmarshal_int();
/* 138 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 141 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 143 */           STFloorHelpCfg _v_ = new STFloorHelpCfg();
/* 144 */           _v_.unmarshal(_os_);
/* 145 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 146 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 151 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 156 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STFloorHelpCfg> all)
/*     */   {
/* 163 */     String path = dir + "mzm.gsp.activity3.confbean.STFloorHelpCfg.bny";
/*     */     try
/*     */     {
/* 166 */       File file = new File(path);
/* 167 */       if (file.exists())
/*     */       {
/* 169 */         byte[] bytes = new byte['Ѐ'];
/* 170 */         FileInputStream fis = new FileInputStream(file);
/* 171 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 172 */         int len = 0;
/* 173 */         while ((len = fis.read(bytes)) > 0)
/* 174 */           baos.write(bytes, 0, len);
/* 175 */         fis.close();
/* 176 */         bytes = baos.toByteArray();
/* 177 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 178 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 180 */           _os_.unmarshal_int();
/* 181 */           _os_.unmarshal_int();
/* 182 */           _os_.unmarshal_int();
/*     */         }
/* 184 */         _os_.unmarshal_int();
/* 185 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 188 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 190 */           STFloorHelpCfg _v_ = new STFloorHelpCfg();
/* 191 */           _v_.unmarshal(_os_);
/* 192 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 193 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 198 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 203 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STFloorHelpCfg getOld(int key)
/*     */   {
/* 211 */     return (STFloorHelpCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STFloorHelpCfg get(int key)
/*     */   {
/* 216 */     return (STFloorHelpCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STFloorHelpCfg> getOldAll()
/*     */   {
/* 221 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STFloorHelpCfg> getAll()
/*     */   {
/* 226 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STFloorHelpCfg> newAll)
/*     */   {
/* 231 */     oldAll = all;
/* 232 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 237 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity3\confbean\STFloorHelpCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */