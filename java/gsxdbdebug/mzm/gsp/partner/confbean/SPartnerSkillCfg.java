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
/*     */ public class SPartnerSkillCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SPartnerSkillCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SPartnerSkillCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templateName;
/*     */   public int skillId;
/*     */   public int needPartnerLevel;
/*     */   public int needPartnerXiuLianLevel;
/*     */   public int needPartnerXiuLianLevelCount;
/*     */   public int unLockYuanLevel;
/*     */   public int improveYuanLevel;
/*     */   public int upLimit;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  30 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  31 */     this.templateName = rootElement.attributeValue("templateName");
/*  32 */     this.skillId = Integer.valueOf(rootElement.attributeValue("skillId")).intValue();
/*  33 */     this.needPartnerLevel = Integer.valueOf(rootElement.attributeValue("needPartnerLevel")).intValue();
/*  34 */     this.needPartnerXiuLianLevel = Integer.valueOf(rootElement.attributeValue("needPartnerXiuLianLevel")).intValue();
/*  35 */     this.needPartnerXiuLianLevelCount = Integer.valueOf(rootElement.attributeValue("needPartnerXiuLianLevelCount")).intValue();
/*  36 */     this.unLockYuanLevel = Integer.valueOf(rootElement.attributeValue("unLockYuanLevel")).intValue();
/*  37 */     this.improveYuanLevel = Integer.valueOf(rootElement.attributeValue("improveYuanLevel")).intValue();
/*  38 */     this.upLimit = Integer.valueOf(rootElement.attributeValue("upLimit")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  43 */     _os_.marshal(this.id);
/*  44 */     _os_.marshal(this.templateName, "UTF-8");
/*  45 */     _os_.marshal(this.skillId);
/*  46 */     _os_.marshal(this.needPartnerLevel);
/*  47 */     _os_.marshal(this.needPartnerXiuLianLevel);
/*  48 */     _os_.marshal(this.needPartnerXiuLianLevelCount);
/*  49 */     _os_.marshal(this.unLockYuanLevel);
/*  50 */     _os_.marshal(this.improveYuanLevel);
/*  51 */     _os_.marshal(this.upLimit);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  57 */     this.id = _os_.unmarshal_int();
/*  58 */     this.templateName = _os_.unmarshal_String("UTF-8");
/*  59 */     this.skillId = _os_.unmarshal_int();
/*  60 */     this.needPartnerLevel = _os_.unmarshal_int();
/*  61 */     this.needPartnerXiuLianLevel = _os_.unmarshal_int();
/*  62 */     this.needPartnerXiuLianLevelCount = _os_.unmarshal_int();
/*  63 */     this.unLockYuanLevel = _os_.unmarshal_int();
/*  64 */     this.improveYuanLevel = _os_.unmarshal_int();
/*  65 */     this.upLimit = _os_.unmarshal_int();
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  71 */     String path = dir + "mzm.gsp.partner.confbean.SPartnerSkillCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  75 */       all = new java.util.HashMap();
/*  76 */       SAXReader reader = new SAXReader();
/*  77 */       org.dom4j.Document doc = reader.read(new File(path));
/*  78 */       Element root = doc.getRootElement();
/*  79 */       List<?> nodeList = root.elements();
/*  80 */       int len = nodeList.size();
/*  81 */       for (int i = 0; i < len; i++)
/*     */       {
/*  83 */         Element elem = (Element)nodeList.get(i);
/*  84 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.partner.confbean.SPartnerSkillCfg"))
/*     */         {
/*     */ 
/*  87 */           SPartnerSkillCfg obj = new SPartnerSkillCfg();
/*  88 */           obj.loadFromXml(elem);
/*  89 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  90 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  95 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SPartnerSkillCfg> all)
/*     */   {
/* 101 */     String path = dir + "mzm.gsp.partner.confbean.SPartnerSkillCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 105 */       SAXReader reader = new SAXReader();
/* 106 */       org.dom4j.Document doc = reader.read(new File(path));
/* 107 */       Element root = doc.getRootElement();
/* 108 */       List<?> nodeList = root.elements();
/* 109 */       int len = nodeList.size();
/* 110 */       for (int i = 0; i < len; i++)
/*     */       {
/* 112 */         Element elem = (Element)nodeList.get(i);
/* 113 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.partner.confbean.SPartnerSkillCfg"))
/*     */         {
/*     */ 
/* 116 */           SPartnerSkillCfg obj = new SPartnerSkillCfg();
/* 117 */           obj.loadFromXml(elem);
/* 118 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 119 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 124 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 130 */     all = new java.util.HashMap();
/*     */     
/* 132 */     String path = dir + "mzm.gsp.partner.confbean.SPartnerSkillCfg.bny";
/*     */     try
/*     */     {
/* 135 */       File file = new File(path);
/* 136 */       if (file.exists())
/*     */       {
/* 138 */         byte[] bytes = new byte['Ѐ'];
/* 139 */         FileInputStream fis = new FileInputStream(file);
/* 140 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 141 */         int len = 0;
/* 142 */         while ((len = fis.read(bytes)) > 0)
/* 143 */           baos.write(bytes, 0, len);
/* 144 */         fis.close();
/* 145 */         bytes = baos.toByteArray();
/* 146 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 147 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 149 */           _os_.unmarshal_int();
/* 150 */           _os_.unmarshal_int();
/* 151 */           _os_.unmarshal_int();
/*     */         }
/* 153 */         _os_.unmarshal_int();
/* 154 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 157 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 159 */           SPartnerSkillCfg _v_ = new SPartnerSkillCfg();
/* 160 */           _v_.unmarshal(_os_);
/* 161 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 162 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 167 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 172 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SPartnerSkillCfg> all)
/*     */   {
/* 179 */     String path = dir + "mzm.gsp.partner.confbean.SPartnerSkillCfg.bny";
/*     */     try
/*     */     {
/* 182 */       File file = new File(path);
/* 183 */       if (file.exists())
/*     */       {
/* 185 */         byte[] bytes = new byte['Ѐ'];
/* 186 */         FileInputStream fis = new FileInputStream(file);
/* 187 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 188 */         int len = 0;
/* 189 */         while ((len = fis.read(bytes)) > 0)
/* 190 */           baos.write(bytes, 0, len);
/* 191 */         fis.close();
/* 192 */         bytes = baos.toByteArray();
/* 193 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 194 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 196 */           _os_.unmarshal_int();
/* 197 */           _os_.unmarshal_int();
/* 198 */           _os_.unmarshal_int();
/*     */         }
/* 200 */         _os_.unmarshal_int();
/* 201 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 204 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 206 */           SPartnerSkillCfg _v_ = new SPartnerSkillCfg();
/* 207 */           _v_.unmarshal(_os_);
/* 208 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 209 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 214 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 219 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SPartnerSkillCfg getOld(int key)
/*     */   {
/* 227 */     return (SPartnerSkillCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SPartnerSkillCfg get(int key)
/*     */   {
/* 232 */     return (SPartnerSkillCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPartnerSkillCfg> getOldAll()
/*     */   {
/* 237 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPartnerSkillCfg> getAll()
/*     */   {
/* 242 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SPartnerSkillCfg> newAll)
/*     */   {
/* 247 */     oldAll = all;
/* 248 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 253 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\confbean\SPartnerSkillCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */