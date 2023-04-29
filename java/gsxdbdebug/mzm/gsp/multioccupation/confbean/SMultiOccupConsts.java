/*     */ package mzm.gsp.multioccupation.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SMultiOccupConsts
/*     */ {
/*  13 */   private static volatile SMultiOccupConsts oldInstance = null;
/*     */   
/*  15 */   private static SMultiOccupConsts instance = new SMultiOccupConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SMultiOccupConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SMultiOccupConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public java.util.ArrayList<Integer> ActiveNeedGolds = new java.util.ArrayList();
/*     */   public int SwitchNeedGold;
/*     */   public int LevelLimit;
/*     */   public int ActiveCoolDownHours;
/*     */   public int SwitchCoolDownHours;
/*     */   public int ActiveService;
/*     */   public int SwitchService;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  41 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  46 */     String path = dir + "mzm.gsp.multioccupation.confbean.SMultiOccupConsts.xml";
/*     */     try
/*     */     {
/*  49 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/*  50 */       org.dom4j.Document doc = reader.read(new File(path));
/*  51 */       Element root = doc.getRootElement();
/*  52 */       Map<String, Element> data = new java.util.HashMap();
/*  53 */       List<?> nodeList = root.elements();
/*  54 */       int len = nodeList.size();
/*  55 */       for (int i = 0; i < len; i++)
/*     */       {
/*  57 */         Element element = (Element)nodeList.get(i);
/*  58 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  61 */           String name = element.attributeValue("name");
/*  62 */           if (data.put(name, element) != null) {
/*  63 */             throw new RuntimeException("duplicate const : " + name);
/*     */           }
/*     */         }
/*     */       }
/*  67 */       Element collectionElement = (Element)data.get("ActiveNeedGolds");
/*  68 */       if (collectionElement == null)
/*     */       {
/*  70 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/*  73 */       List<?> _nodeList = collectionElement.elements();
/*  74 */       int _len = _nodeList.size();
/*  75 */       for (int i = 0; i < _len; i++)
/*     */       {
/*  77 */         Element elem = (Element)_nodeList.get(i);
/*  78 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/*  85 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/*  92 */           this.ActiveNeedGolds.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/*  95 */       this.SwitchNeedGold = Integer.valueOf(((Element)data.get("SwitchNeedGold")).attributeValue("value")).intValue();
/*  96 */       this.LevelLimit = Integer.valueOf(((Element)data.get("LevelLimit")).attributeValue("value")).intValue();
/*  97 */       this.ActiveCoolDownHours = Integer.valueOf(((Element)data.get("ActiveCoolDownHours")).attributeValue("value")).intValue();
/*  98 */       this.SwitchCoolDownHours = Integer.valueOf(((Element)data.get("SwitchCoolDownHours")).attributeValue("value")).intValue();
/*  99 */       this.ActiveService = Integer.valueOf(((Element)data.get("ActiveService")).attributeValue("value")).intValue();
/* 100 */       this.SwitchService = Integer.valueOf(((Element)data.get("SwitchService")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 104 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 109 */     String path = dir + "mzm.gsp.multioccupation.confbean.SMultiOccupConsts.xml";
/*     */     try
/*     */     {
/* 112 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 113 */       org.dom4j.Document doc = reader.read(new File(path));
/* 114 */       Element root = doc.getRootElement();
/* 115 */       Map<String, Element> data = new java.util.HashMap();
/* 116 */       List<?> nodeList = root.elements();
/* 117 */       int len = nodeList.size();
/* 118 */       for (int i = 0; i < len; i++)
/*     */       {
/* 120 */         Element element = (Element)nodeList.get(i);
/* 121 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 124 */           String name = element.attributeValue("name");
/* 125 */           if (data.put(name, element) != null) {
/* 126 */             throw new RuntimeException("duplicate const : " + name);
/*     */           }
/*     */         }
/*     */       }
/* 130 */       Element collectionElement = (Element)data.get("ActiveNeedGolds");
/* 131 */       if (collectionElement == null)
/*     */       {
/* 133 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 136 */       List<?> _nodeList = collectionElement.elements();
/* 137 */       int _len = _nodeList.size();
/* 138 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 140 */         Element elem = (Element)_nodeList.get(i);
/* 141 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 148 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 155 */           this.ActiveNeedGolds.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/* 158 */       this.SwitchNeedGold = Integer.valueOf(((Element)data.get("SwitchNeedGold")).attributeValue("value")).intValue();
/* 159 */       this.LevelLimit = Integer.valueOf(((Element)data.get("LevelLimit")).attributeValue("value")).intValue();
/* 160 */       this.ActiveCoolDownHours = Integer.valueOf(((Element)data.get("ActiveCoolDownHours")).attributeValue("value")).intValue();
/* 161 */       this.SwitchCoolDownHours = Integer.valueOf(((Element)data.get("SwitchCoolDownHours")).attributeValue("value")).intValue();
/* 162 */       this.ActiveService = Integer.valueOf(((Element)data.get("ActiveService")).attributeValue("value")).intValue();
/* 163 */       this.SwitchService = Integer.valueOf(((Element)data.get("SwitchService")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 167 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 171 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 174 */     String path = dir + "mzm.gsp.multioccupation.confbean.SMultiOccupConsts.bny";
/*     */     try
/*     */     {
/* 177 */       File file = new File(path);
/* 178 */       if (file.exists())
/*     */       {
/* 180 */         byte[] bytes = new byte['Ѐ'];
/* 181 */         FileInputStream fis = new FileInputStream(file);
/* 182 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 183 */         int len = 0;
/* 184 */         while ((len = fis.read(bytes)) > 0)
/* 185 */           baos.write(bytes, 0, len);
/* 186 */         fis.close();
/* 187 */         bytes = baos.toByteArray();
/* 188 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 189 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 192 */           int _v_ = _os_.unmarshal_int();
/* 193 */           this.ActiveNeedGolds.add(Integer.valueOf(_v_));
/*     */         }
/* 195 */         this.SwitchNeedGold = _os_.unmarshal_int();
/* 196 */         this.LevelLimit = _os_.unmarshal_int();
/* 197 */         this.ActiveCoolDownHours = _os_.unmarshal_int();
/* 198 */         this.SwitchCoolDownHours = _os_.unmarshal_int();
/* 199 */         this.ActiveService = _os_.unmarshal_int();
/* 200 */         this.SwitchService = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 205 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 211 */     String path = dir + "mzm.gsp.multioccupation.confbean.SMultiOccupConsts.bny";
/*     */     try
/*     */     {
/* 214 */       File file = new File(path);
/* 215 */       if (file.exists())
/*     */       {
/* 217 */         byte[] bytes = new byte['Ѐ'];
/* 218 */         FileInputStream fis = new FileInputStream(file);
/* 219 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 220 */         int len = 0;
/* 221 */         while ((len = fis.read(bytes)) > 0)
/* 222 */           baos.write(bytes, 0, len);
/* 223 */         fis.close();
/* 224 */         bytes = baos.toByteArray();
/* 225 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 226 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 229 */           int _v_ = _os_.unmarshal_int();
/* 230 */           this.ActiveNeedGolds.add(Integer.valueOf(_v_));
/*     */         }
/* 232 */         this.SwitchNeedGold = _os_.unmarshal_int();
/* 233 */         this.LevelLimit = _os_.unmarshal_int();
/* 234 */         this.ActiveCoolDownHours = _os_.unmarshal_int();
/* 235 */         this.SwitchCoolDownHours = _os_.unmarshal_int();
/* 236 */         this.ActiveService = _os_.unmarshal_int();
/* 237 */         this.SwitchService = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 242 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SMultiOccupConsts newInstance)
/*     */   {
/* 248 */     oldInstance = instance;
/* 249 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 254 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\multioccupation\confbean\SMultiOccupConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */