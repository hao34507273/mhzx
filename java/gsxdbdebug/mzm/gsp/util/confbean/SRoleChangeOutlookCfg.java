/*     */ package mzm.gsp.util.confbean;
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
/*     */ public class SRoleChangeOutlookCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SRoleChangeOutlookCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SRoleChangeOutlookCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int modelId;
/*     */   public boolean showOriginalWeapon;
/*     */   public int weaponId;
/*     */   public boolean showOriginalWing;
/*     */   public int wingId;
/*     */   public boolean showOriginalTreasure;
/*     */   public int treasureId;
/*     */   public boolean showOriginalMount;
/*     */   public int mountId;
/*     */   public boolean showOriginalAerocraft;
/*     */   public int aerocraftId;
/*     */   public boolean showInFight;
/*     */   public int priority;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  35 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  36 */     this.modelId = Integer.valueOf(rootElement.attributeValue("modelId")).intValue();
/*  37 */     this.showOriginalWeapon = Boolean.valueOf(rootElement.attributeValue("showOriginalWeapon")).booleanValue();
/*  38 */     this.weaponId = Integer.valueOf(rootElement.attributeValue("weaponId")).intValue();
/*  39 */     this.showOriginalWing = Boolean.valueOf(rootElement.attributeValue("showOriginalWing")).booleanValue();
/*  40 */     this.wingId = Integer.valueOf(rootElement.attributeValue("wingId")).intValue();
/*  41 */     this.showOriginalTreasure = Boolean.valueOf(rootElement.attributeValue("showOriginalTreasure")).booleanValue();
/*  42 */     this.treasureId = Integer.valueOf(rootElement.attributeValue("treasureId")).intValue();
/*  43 */     this.showOriginalMount = Boolean.valueOf(rootElement.attributeValue("showOriginalMount")).booleanValue();
/*  44 */     this.mountId = Integer.valueOf(rootElement.attributeValue("mountId")).intValue();
/*  45 */     this.showOriginalAerocraft = Boolean.valueOf(rootElement.attributeValue("showOriginalAerocraft")).booleanValue();
/*  46 */     this.aerocraftId = Integer.valueOf(rootElement.attributeValue("aerocraftId")).intValue();
/*  47 */     this.showInFight = Boolean.valueOf(rootElement.attributeValue("showInFight")).booleanValue();
/*  48 */     this.priority = Integer.valueOf(rootElement.attributeValue("priority")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  53 */     _os_.marshal(this.id);
/*  54 */     _os_.marshal(this.modelId);
/*  55 */     _os_.marshal(this.showOriginalWeapon);
/*  56 */     _os_.marshal(this.weaponId);
/*  57 */     _os_.marshal(this.showOriginalWing);
/*  58 */     _os_.marshal(this.wingId);
/*  59 */     _os_.marshal(this.showOriginalTreasure);
/*  60 */     _os_.marshal(this.treasureId);
/*  61 */     _os_.marshal(this.showOriginalMount);
/*  62 */     _os_.marshal(this.mountId);
/*  63 */     _os_.marshal(this.showOriginalAerocraft);
/*  64 */     _os_.marshal(this.aerocraftId);
/*  65 */     _os_.marshal(this.showInFight);
/*  66 */     _os_.marshal(this.priority);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  72 */     this.id = _os_.unmarshal_int();
/*  73 */     this.modelId = _os_.unmarshal_int();
/*  74 */     this.showOriginalWeapon = _os_.unmarshal_boolean();
/*  75 */     this.weaponId = _os_.unmarshal_int();
/*  76 */     this.showOriginalWing = _os_.unmarshal_boolean();
/*  77 */     this.wingId = _os_.unmarshal_int();
/*  78 */     this.showOriginalTreasure = _os_.unmarshal_boolean();
/*  79 */     this.treasureId = _os_.unmarshal_int();
/*  80 */     this.showOriginalMount = _os_.unmarshal_boolean();
/*  81 */     this.mountId = _os_.unmarshal_int();
/*  82 */     this.showOriginalAerocraft = _os_.unmarshal_boolean();
/*  83 */     this.aerocraftId = _os_.unmarshal_int();
/*  84 */     this.showInFight = _os_.unmarshal_boolean();
/*  85 */     this.priority = _os_.unmarshal_int();
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  91 */     String path = dir + "mzm.gsp.util.confbean.SRoleChangeOutlookCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  95 */       all = new java.util.HashMap();
/*  96 */       SAXReader reader = new SAXReader();
/*  97 */       org.dom4j.Document doc = reader.read(new File(path));
/*  98 */       Element root = doc.getRootElement();
/*  99 */       List<?> nodeList = root.elements();
/* 100 */       int len = nodeList.size();
/* 101 */       for (int i = 0; i < len; i++)
/*     */       {
/* 103 */         Element elem = (Element)nodeList.get(i);
/* 104 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.util.confbean.SRoleChangeOutlookCfg"))
/*     */         {
/*     */ 
/* 107 */           SRoleChangeOutlookCfg obj = new SRoleChangeOutlookCfg();
/* 108 */           obj.loadFromXml(elem);
/* 109 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 110 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 115 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SRoleChangeOutlookCfg> all)
/*     */   {
/* 121 */     String path = dir + "mzm.gsp.util.confbean.SRoleChangeOutlookCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 125 */       SAXReader reader = new SAXReader();
/* 126 */       org.dom4j.Document doc = reader.read(new File(path));
/* 127 */       Element root = doc.getRootElement();
/* 128 */       List<?> nodeList = root.elements();
/* 129 */       int len = nodeList.size();
/* 130 */       for (int i = 0; i < len; i++)
/*     */       {
/* 132 */         Element elem = (Element)nodeList.get(i);
/* 133 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.util.confbean.SRoleChangeOutlookCfg"))
/*     */         {
/*     */ 
/* 136 */           SRoleChangeOutlookCfg obj = new SRoleChangeOutlookCfg();
/* 137 */           obj.loadFromXml(elem);
/* 138 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 139 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 144 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 150 */     all = new java.util.HashMap();
/*     */     
/* 152 */     String path = dir + "mzm.gsp.util.confbean.SRoleChangeOutlookCfg.bny";
/*     */     try
/*     */     {
/* 155 */       File file = new File(path);
/* 156 */       if (file.exists())
/*     */       {
/* 158 */         byte[] bytes = new byte['Ѐ'];
/* 159 */         FileInputStream fis = new FileInputStream(file);
/* 160 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 161 */         int len = 0;
/* 162 */         while ((len = fis.read(bytes)) > 0)
/* 163 */           baos.write(bytes, 0, len);
/* 164 */         fis.close();
/* 165 */         bytes = baos.toByteArray();
/* 166 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 167 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 169 */           _os_.unmarshal_int();
/* 170 */           _os_.unmarshal_int();
/* 171 */           _os_.unmarshal_int();
/*     */         }
/* 173 */         _os_.unmarshal_int();
/* 174 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 177 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 179 */           SRoleChangeOutlookCfg _v_ = new SRoleChangeOutlookCfg();
/* 180 */           _v_.unmarshal(_os_);
/* 181 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 182 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 187 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 192 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SRoleChangeOutlookCfg> all)
/*     */   {
/* 199 */     String path = dir + "mzm.gsp.util.confbean.SRoleChangeOutlookCfg.bny";
/*     */     try
/*     */     {
/* 202 */       File file = new File(path);
/* 203 */       if (file.exists())
/*     */       {
/* 205 */         byte[] bytes = new byte['Ѐ'];
/* 206 */         FileInputStream fis = new FileInputStream(file);
/* 207 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 208 */         int len = 0;
/* 209 */         while ((len = fis.read(bytes)) > 0)
/* 210 */           baos.write(bytes, 0, len);
/* 211 */         fis.close();
/* 212 */         bytes = baos.toByteArray();
/* 213 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 214 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 216 */           _os_.unmarshal_int();
/* 217 */           _os_.unmarshal_int();
/* 218 */           _os_.unmarshal_int();
/*     */         }
/* 220 */         _os_.unmarshal_int();
/* 221 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 224 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 226 */           SRoleChangeOutlookCfg _v_ = new SRoleChangeOutlookCfg();
/* 227 */           _v_.unmarshal(_os_);
/* 228 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 229 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 234 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 239 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SRoleChangeOutlookCfg getOld(int key)
/*     */   {
/* 247 */     return (SRoleChangeOutlookCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SRoleChangeOutlookCfg get(int key)
/*     */   {
/* 252 */     return (SRoleChangeOutlookCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SRoleChangeOutlookCfg> getOldAll()
/*     */   {
/* 257 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SRoleChangeOutlookCfg> getAll()
/*     */   {
/* 262 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SRoleChangeOutlookCfg> newAll)
/*     */   {
/* 267 */     oldAll = all;
/* 268 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 273 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\confbean\SRoleChangeOutlookCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */