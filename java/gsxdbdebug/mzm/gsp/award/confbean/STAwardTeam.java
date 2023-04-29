/*     */ package mzm.gsp.award.confbean;
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
/*     */ public class STAwardTeam implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STAwardTeam> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STAwardTeam> all = null;
/*     */   
/*     */   public int teamerCount;
/*     */   public int silverAdd;
/*     */   public int gangConbAdd;
/*     */   public int chivalryAdd;
/*     */   public int vitalityAdd;
/*     */   public int roleExpAdd;
/*     */   public int petExpAdd;
/*     */   public int practiceAdd;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  29 */     this.teamerCount = Integer.valueOf(rootElement.attributeValue("teamerCount")).intValue();
/*  30 */     this.silverAdd = Integer.valueOf(rootElement.attributeValue("silverAdd")).intValue();
/*  31 */     this.gangConbAdd = Integer.valueOf(rootElement.attributeValue("gangConbAdd")).intValue();
/*  32 */     this.chivalryAdd = Integer.valueOf(rootElement.attributeValue("chivalryAdd")).intValue();
/*  33 */     this.vitalityAdd = Integer.valueOf(rootElement.attributeValue("vitalityAdd")).intValue();
/*  34 */     this.roleExpAdd = Integer.valueOf(rootElement.attributeValue("roleExpAdd")).intValue();
/*  35 */     this.petExpAdd = Integer.valueOf(rootElement.attributeValue("petExpAdd")).intValue();
/*  36 */     this.practiceAdd = Integer.valueOf(rootElement.attributeValue("practiceAdd")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  41 */     _os_.marshal(this.teamerCount);
/*  42 */     _os_.marshal(this.silverAdd);
/*  43 */     _os_.marshal(this.gangConbAdd);
/*  44 */     _os_.marshal(this.chivalryAdd);
/*  45 */     _os_.marshal(this.vitalityAdd);
/*  46 */     _os_.marshal(this.roleExpAdd);
/*  47 */     _os_.marshal(this.petExpAdd);
/*  48 */     _os_.marshal(this.practiceAdd);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  54 */     this.teamerCount = _os_.unmarshal_int();
/*  55 */     this.silverAdd = _os_.unmarshal_int();
/*  56 */     this.gangConbAdd = _os_.unmarshal_int();
/*  57 */     this.chivalryAdd = _os_.unmarshal_int();
/*  58 */     this.vitalityAdd = _os_.unmarshal_int();
/*  59 */     this.roleExpAdd = _os_.unmarshal_int();
/*  60 */     this.petExpAdd = _os_.unmarshal_int();
/*  61 */     this.practiceAdd = _os_.unmarshal_int();
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  67 */     String path = dir + "mzm.gsp.award.confbean.STAwardTeam.xml";
/*     */     
/*     */     try
/*     */     {
/*  71 */       all = new java.util.HashMap();
/*  72 */       SAXReader reader = new SAXReader();
/*  73 */       org.dom4j.Document doc = reader.read(new File(path));
/*  74 */       Element root = doc.getRootElement();
/*  75 */       List<?> nodeList = root.elements();
/*  76 */       int len = nodeList.size();
/*  77 */       for (int i = 0; i < len; i++)
/*     */       {
/*  79 */         Element elem = (Element)nodeList.get(i);
/*  80 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.STAwardTeam"))
/*     */         {
/*     */ 
/*  83 */           STAwardTeam obj = new STAwardTeam();
/*  84 */           obj.loadFromXml(elem);
/*  85 */           if (all.put(Integer.valueOf(obj.teamerCount), obj) != null) {
/*  86 */             throw new RuntimeException("duplicate key : " + obj.teamerCount);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  91 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STAwardTeam> all)
/*     */   {
/*  97 */     String path = dir + "mzm.gsp.award.confbean.STAwardTeam.xml";
/*     */     
/*     */     try
/*     */     {
/* 101 */       SAXReader reader = new SAXReader();
/* 102 */       org.dom4j.Document doc = reader.read(new File(path));
/* 103 */       Element root = doc.getRootElement();
/* 104 */       List<?> nodeList = root.elements();
/* 105 */       int len = nodeList.size();
/* 106 */       for (int i = 0; i < len; i++)
/*     */       {
/* 108 */         Element elem = (Element)nodeList.get(i);
/* 109 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.STAwardTeam"))
/*     */         {
/*     */ 
/* 112 */           STAwardTeam obj = new STAwardTeam();
/* 113 */           obj.loadFromXml(elem);
/* 114 */           if (all.put(Integer.valueOf(obj.teamerCount), obj) != null) {
/* 115 */             throw new RuntimeException("duplicate key : " + obj.teamerCount);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 120 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 126 */     all = new java.util.HashMap();
/*     */     
/* 128 */     String path = dir + "mzm.gsp.award.confbean.STAwardTeam.bny";
/*     */     try
/*     */     {
/* 131 */       File file = new File(path);
/* 132 */       if (file.exists())
/*     */       {
/* 134 */         byte[] bytes = new byte['Ѐ'];
/* 135 */         FileInputStream fis = new FileInputStream(file);
/* 136 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 137 */         int len = 0;
/* 138 */         while ((len = fis.read(bytes)) > 0)
/* 139 */           baos.write(bytes, 0, len);
/* 140 */         fis.close();
/* 141 */         bytes = baos.toByteArray();
/* 142 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 143 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 145 */           _os_.unmarshal_int();
/* 146 */           _os_.unmarshal_int();
/* 147 */           _os_.unmarshal_int();
/*     */         }
/* 149 */         _os_.unmarshal_int();
/* 150 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 153 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 155 */           STAwardTeam _v_ = new STAwardTeam();
/* 156 */           _v_.unmarshal(_os_);
/* 157 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 158 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 163 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 168 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STAwardTeam> all)
/*     */   {
/* 175 */     String path = dir + "mzm.gsp.award.confbean.STAwardTeam.bny";
/*     */     try
/*     */     {
/* 178 */       File file = new File(path);
/* 179 */       if (file.exists())
/*     */       {
/* 181 */         byte[] bytes = new byte['Ѐ'];
/* 182 */         FileInputStream fis = new FileInputStream(file);
/* 183 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 184 */         int len = 0;
/* 185 */         while ((len = fis.read(bytes)) > 0)
/* 186 */           baos.write(bytes, 0, len);
/* 187 */         fis.close();
/* 188 */         bytes = baos.toByteArray();
/* 189 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 190 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 192 */           _os_.unmarshal_int();
/* 193 */           _os_.unmarshal_int();
/* 194 */           _os_.unmarshal_int();
/*     */         }
/* 196 */         _os_.unmarshal_int();
/* 197 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 200 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 202 */           STAwardTeam _v_ = new STAwardTeam();
/* 203 */           _v_.unmarshal(_os_);
/* 204 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 205 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 210 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 215 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STAwardTeam getOld(int key)
/*     */   {
/* 223 */     return (STAwardTeam)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STAwardTeam get(int key)
/*     */   {
/* 228 */     return (STAwardTeam)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STAwardTeam> getOldAll()
/*     */   {
/* 233 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STAwardTeam> getAll()
/*     */   {
/* 238 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STAwardTeam> newAll)
/*     */   {
/* 243 */     oldAll = all;
/* 244 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 249 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\confbean\STAwardTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */