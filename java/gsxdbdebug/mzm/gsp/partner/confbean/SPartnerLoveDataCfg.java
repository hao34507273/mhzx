/*     */ package mzm.gsp.partner.confbean;
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
/*     */ public class SPartnerLoveDataCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SPartnerLoveDataCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SPartnerLoveDataCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templateName;
/*     */   public String loveName;
/*     */   public String loveDes;
/*     */   public int loveIconId;
/*     */   public int loveRank;
/*     */   public int toPartner1;
/*     */   public int toPartner2;
/*     */   public int toPartner3;
/*     */   public int loveEffectId;
/*  28 */   public java.util.ArrayList<Integer> args = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  32 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  33 */     this.templateName = rootElement.attributeValue("templateName");
/*  34 */     this.loveName = rootElement.attributeValue("loveName");
/*  35 */     this.loveDes = rootElement.attributeValue("loveDes");
/*  36 */     this.loveIconId = Integer.valueOf(rootElement.attributeValue("loveIconId")).intValue();
/*  37 */     this.loveRank = Integer.valueOf(rootElement.attributeValue("loveRank")).intValue();
/*  38 */     this.toPartner1 = Integer.valueOf(rootElement.attributeValue("toPartner1")).intValue();
/*  39 */     this.toPartner2 = Integer.valueOf(rootElement.attributeValue("toPartner2")).intValue();
/*  40 */     this.toPartner3 = Integer.valueOf(rootElement.attributeValue("toPartner3")).intValue();
/*  41 */     this.loveEffectId = Integer.valueOf(rootElement.attributeValue("loveEffectId")).intValue();
/*     */     
/*  43 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "args");
/*  44 */     if (collectionElement == null)
/*     */     {
/*  46 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  49 */     List<?> _nodeList = collectionElement.elements();
/*  50 */     int _len = _nodeList.size();
/*  51 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  53 */       Element elem = (Element)_nodeList.get(i);
/*  54 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  61 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  68 */         this.args.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  75 */     _os_.marshal(this.id);
/*  76 */     _os_.marshal(this.templateName, "UTF-8");
/*  77 */     _os_.marshal(this.loveName, "UTF-8");
/*  78 */     _os_.marshal(this.loveDes, "UTF-8");
/*  79 */     _os_.marshal(this.loveIconId);
/*  80 */     _os_.marshal(this.loveRank);
/*  81 */     _os_.marshal(this.toPartner1);
/*  82 */     _os_.marshal(this.toPartner2);
/*  83 */     _os_.marshal(this.toPartner3);
/*  84 */     _os_.marshal(this.loveEffectId);
/*  85 */     _os_.compact_uint32(this.args.size());
/*  86 */     for (Integer _v_ : this.args)
/*     */     {
/*  88 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  95 */     this.id = _os_.unmarshal_int();
/*  96 */     this.templateName = _os_.unmarshal_String("UTF-8");
/*  97 */     this.loveName = _os_.unmarshal_String("UTF-8");
/*  98 */     this.loveDes = _os_.unmarshal_String("UTF-8");
/*  99 */     this.loveIconId = _os_.unmarshal_int();
/* 100 */     this.loveRank = _os_.unmarshal_int();
/* 101 */     this.toPartner1 = _os_.unmarshal_int();
/* 102 */     this.toPartner2 = _os_.unmarshal_int();
/* 103 */     this.toPartner3 = _os_.unmarshal_int();
/* 104 */     this.loveEffectId = _os_.unmarshal_int();
/* 105 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 108 */       int _v_ = _os_.unmarshal_int();
/* 109 */       this.args.add(Integer.valueOf(_v_));
/*     */     }
/* 111 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 116 */     String path = dir + "mzm.gsp.partner.confbean.SPartnerLoveDataCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 120 */       all = new java.util.HashMap();
/* 121 */       SAXReader reader = new SAXReader();
/* 122 */       org.dom4j.Document doc = reader.read(new File(path));
/* 123 */       Element root = doc.getRootElement();
/* 124 */       List<?> nodeList = root.elements();
/* 125 */       int len = nodeList.size();
/* 126 */       for (int i = 0; i < len; i++)
/*     */       {
/* 128 */         Element elem = (Element)nodeList.get(i);
/* 129 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.partner.confbean.SPartnerLoveDataCfg"))
/*     */         {
/*     */ 
/* 132 */           SPartnerLoveDataCfg obj = new SPartnerLoveDataCfg();
/* 133 */           obj.loadFromXml(elem);
/* 134 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 135 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 140 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SPartnerLoveDataCfg> all)
/*     */   {
/* 146 */     String path = dir + "mzm.gsp.partner.confbean.SPartnerLoveDataCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 150 */       SAXReader reader = new SAXReader();
/* 151 */       org.dom4j.Document doc = reader.read(new File(path));
/* 152 */       Element root = doc.getRootElement();
/* 153 */       List<?> nodeList = root.elements();
/* 154 */       int len = nodeList.size();
/* 155 */       for (int i = 0; i < len; i++)
/*     */       {
/* 157 */         Element elem = (Element)nodeList.get(i);
/* 158 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.partner.confbean.SPartnerLoveDataCfg"))
/*     */         {
/*     */ 
/* 161 */           SPartnerLoveDataCfg obj = new SPartnerLoveDataCfg();
/* 162 */           obj.loadFromXml(elem);
/* 163 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 164 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 169 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 175 */     all = new java.util.HashMap();
/*     */     
/* 177 */     String path = dir + "mzm.gsp.partner.confbean.SPartnerLoveDataCfg.bny";
/*     */     try
/*     */     {
/* 180 */       File file = new File(path);
/* 181 */       if (file.exists())
/*     */       {
/* 183 */         byte[] bytes = new byte['Ѐ'];
/* 184 */         FileInputStream fis = new FileInputStream(file);
/* 185 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 186 */         int len = 0;
/* 187 */         while ((len = fis.read(bytes)) > 0)
/* 188 */           baos.write(bytes, 0, len);
/* 189 */         fis.close();
/* 190 */         bytes = baos.toByteArray();
/* 191 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 192 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 194 */           _os_.unmarshal_int();
/* 195 */           _os_.unmarshal_int();
/* 196 */           _os_.unmarshal_int();
/*     */         }
/* 198 */         _os_.unmarshal_int();
/* 199 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 202 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 204 */           SPartnerLoveDataCfg _v_ = new SPartnerLoveDataCfg();
/* 205 */           _v_.unmarshal(_os_);
/* 206 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 207 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 212 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 217 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SPartnerLoveDataCfg> all)
/*     */   {
/* 224 */     String path = dir + "mzm.gsp.partner.confbean.SPartnerLoveDataCfg.bny";
/*     */     try
/*     */     {
/* 227 */       File file = new File(path);
/* 228 */       if (file.exists())
/*     */       {
/* 230 */         byte[] bytes = new byte['Ѐ'];
/* 231 */         FileInputStream fis = new FileInputStream(file);
/* 232 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 233 */         int len = 0;
/* 234 */         while ((len = fis.read(bytes)) > 0)
/* 235 */           baos.write(bytes, 0, len);
/* 236 */         fis.close();
/* 237 */         bytes = baos.toByteArray();
/* 238 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 239 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 241 */           _os_.unmarshal_int();
/* 242 */           _os_.unmarshal_int();
/* 243 */           _os_.unmarshal_int();
/*     */         }
/* 245 */         _os_.unmarshal_int();
/* 246 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 249 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 251 */           SPartnerLoveDataCfg _v_ = new SPartnerLoveDataCfg();
/* 252 */           _v_.unmarshal(_os_);
/* 253 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 254 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 259 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 264 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SPartnerLoveDataCfg getOld(int key)
/*     */   {
/* 272 */     return (SPartnerLoveDataCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SPartnerLoveDataCfg get(int key)
/*     */   {
/* 277 */     return (SPartnerLoveDataCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPartnerLoveDataCfg> getOldAll()
/*     */   {
/* 282 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPartnerLoveDataCfg> getAll()
/*     */   {
/* 287 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SPartnerLoveDataCfg> newAll)
/*     */   {
/* 292 */     oldAll = all;
/* 293 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 298 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\confbean\SPartnerLoveDataCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */