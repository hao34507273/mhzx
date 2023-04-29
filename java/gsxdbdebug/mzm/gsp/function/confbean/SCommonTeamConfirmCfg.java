/*     */ package mzm.gsp.function.confbean;
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
/*     */ public class SCommonTeamConfirmCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SCommonTeamConfirmCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SCommonTeamConfirmCfg> all = null;
/*     */   
/*     */   public int confirmType;
/*     */   public int timeLimit;
/*     */   public boolean defaultRefuse;
/*     */   public boolean canSet;
/*     */   public String optionDescription;
/*     */   public int sortId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  27 */     this.confirmType = Integer.valueOf(rootElement.attributeValue("confirmType")).intValue();
/*  28 */     this.timeLimit = Integer.valueOf(rootElement.attributeValue("timeLimit")).intValue();
/*  29 */     this.defaultRefuse = Boolean.valueOf(rootElement.attributeValue("defaultRefuse")).booleanValue();
/*  30 */     this.canSet = Boolean.valueOf(rootElement.attributeValue("canSet")).booleanValue();
/*  31 */     this.optionDescription = rootElement.attributeValue("optionDescription");
/*  32 */     this.sortId = Integer.valueOf(rootElement.attributeValue("sortId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  37 */     _os_.marshal(this.confirmType);
/*  38 */     _os_.marshal(this.timeLimit);
/*  39 */     _os_.marshal(this.defaultRefuse);
/*  40 */     _os_.marshal(this.canSet);
/*  41 */     _os_.marshal(this.optionDescription, "UTF-8");
/*  42 */     _os_.marshal(this.sortId);
/*  43 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  48 */     this.confirmType = _os_.unmarshal_int();
/*  49 */     this.timeLimit = _os_.unmarshal_int();
/*  50 */     this.defaultRefuse = _os_.unmarshal_boolean();
/*  51 */     this.canSet = _os_.unmarshal_boolean();
/*  52 */     this.optionDescription = _os_.unmarshal_String("UTF-8");
/*  53 */     this.sortId = _os_.unmarshal_int();
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  59 */     String path = dir + "mzm.gsp.function.confbean.SCommonTeamConfirmCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  63 */       all = new java.util.HashMap();
/*  64 */       SAXReader reader = new SAXReader();
/*  65 */       org.dom4j.Document doc = reader.read(new File(path));
/*  66 */       Element root = doc.getRootElement();
/*  67 */       List<?> nodeList = root.elements();
/*  68 */       int len = nodeList.size();
/*  69 */       for (int i = 0; i < len; i++)
/*     */       {
/*  71 */         Element elem = (Element)nodeList.get(i);
/*  72 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.function.confbean.SCommonTeamConfirmCfg"))
/*     */         {
/*     */ 
/*  75 */           SCommonTeamConfirmCfg obj = new SCommonTeamConfirmCfg();
/*  76 */           obj.loadFromXml(elem);
/*  77 */           if (all.put(Integer.valueOf(obj.confirmType), obj) != null) {
/*  78 */             throw new RuntimeException("duplicate key : " + obj.confirmType);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  83 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SCommonTeamConfirmCfg> all)
/*     */   {
/*  89 */     String path = dir + "mzm.gsp.function.confbean.SCommonTeamConfirmCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  93 */       SAXReader reader = new SAXReader();
/*  94 */       org.dom4j.Document doc = reader.read(new File(path));
/*  95 */       Element root = doc.getRootElement();
/*  96 */       List<?> nodeList = root.elements();
/*  97 */       int len = nodeList.size();
/*  98 */       for (int i = 0; i < len; i++)
/*     */       {
/* 100 */         Element elem = (Element)nodeList.get(i);
/* 101 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.function.confbean.SCommonTeamConfirmCfg"))
/*     */         {
/*     */ 
/* 104 */           SCommonTeamConfirmCfg obj = new SCommonTeamConfirmCfg();
/* 105 */           obj.loadFromXml(elem);
/* 106 */           if (all.put(Integer.valueOf(obj.confirmType), obj) != null) {
/* 107 */             throw new RuntimeException("duplicate key : " + obj.confirmType);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 112 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 118 */     all = new java.util.HashMap();
/*     */     
/* 120 */     String path = dir + "mzm.gsp.function.confbean.SCommonTeamConfirmCfg.bny";
/*     */     try
/*     */     {
/* 123 */       File file = new File(path);
/* 124 */       if (file.exists())
/*     */       {
/* 126 */         byte[] bytes = new byte['Ѐ'];
/* 127 */         FileInputStream fis = new FileInputStream(file);
/* 128 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 129 */         int len = 0;
/* 130 */         while ((len = fis.read(bytes)) > 0)
/* 131 */           baos.write(bytes, 0, len);
/* 132 */         fis.close();
/* 133 */         bytes = baos.toByteArray();
/* 134 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 135 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 137 */           _os_.unmarshal_int();
/* 138 */           _os_.unmarshal_int();
/* 139 */           _os_.unmarshal_int();
/*     */         }
/* 141 */         _os_.unmarshal_int();
/* 142 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 145 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 147 */           SCommonTeamConfirmCfg _v_ = new SCommonTeamConfirmCfg();
/* 148 */           _v_.unmarshal(_os_);
/* 149 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 150 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 155 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 160 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SCommonTeamConfirmCfg> all)
/*     */   {
/* 167 */     String path = dir + "mzm.gsp.function.confbean.SCommonTeamConfirmCfg.bny";
/*     */     try
/*     */     {
/* 170 */       File file = new File(path);
/* 171 */       if (file.exists())
/*     */       {
/* 173 */         byte[] bytes = new byte['Ѐ'];
/* 174 */         FileInputStream fis = new FileInputStream(file);
/* 175 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 176 */         int len = 0;
/* 177 */         while ((len = fis.read(bytes)) > 0)
/* 178 */           baos.write(bytes, 0, len);
/* 179 */         fis.close();
/* 180 */         bytes = baos.toByteArray();
/* 181 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 182 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 184 */           _os_.unmarshal_int();
/* 185 */           _os_.unmarshal_int();
/* 186 */           _os_.unmarshal_int();
/*     */         }
/* 188 */         _os_.unmarshal_int();
/* 189 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 192 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 194 */           SCommonTeamConfirmCfg _v_ = new SCommonTeamConfirmCfg();
/* 195 */           _v_.unmarshal(_os_);
/* 196 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 197 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 202 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 207 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SCommonTeamConfirmCfg getOld(int key)
/*     */   {
/* 215 */     return (SCommonTeamConfirmCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SCommonTeamConfirmCfg get(int key)
/*     */   {
/* 220 */     return (SCommonTeamConfirmCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCommonTeamConfirmCfg> getOldAll()
/*     */   {
/* 225 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCommonTeamConfirmCfg> getAll()
/*     */   {
/* 230 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SCommonTeamConfirmCfg> newAll)
/*     */   {
/* 235 */     oldAll = all;
/* 236 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 241 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\function\confbean\SCommonTeamConfirmCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */