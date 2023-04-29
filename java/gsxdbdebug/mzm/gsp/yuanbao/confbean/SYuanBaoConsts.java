/*     */ package mzm.gsp.yuanbao.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Document;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SYuanBaoConsts
/*     */ {
/*  18 */   private static volatile SYuanBaoConsts oldInstance = null;
/*  19 */   private static SYuanBaoConsts instance = new SYuanBaoConsts();
/*  20 */   public ArrayList<ZengSong> ZengSongs = new ArrayList();
/*     */   public int ItemId;
/*     */   public int Percent;
/*     */   
/*     */   public static SYuanBaoConsts getOldInstance() {
/*  25 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SYuanBaoConsts getInstance() {
/*  29 */     return instance;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir) {
/*  33 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir) {
/*  37 */     String path = dir + "mzm.gsp.yuanbao.confbean.SYuanBaoConsts.xml";
/*     */     try {
/*  39 */       Element root = new SAXReader().read(new File(path)).getRootElement();
/*  40 */       Map<String, Element> data = new HashMap();
/*  41 */       List<?> nodeList = root.elements();
/*  42 */       int len = nodeList.size();
/*  43 */       for (int i = 0; i < len; i++) {
/*  44 */         Element element = (Element)nodeList.get(i);
/*  45 */         if (element.getName().equalsIgnoreCase("row")) {
/*  46 */           String name = element.attributeValue("name");
/*  47 */           if (data.put(name, element) != null) {
/*  48 */             throw new RuntimeException("duplicate const : " + name);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*  53 */       this.ItemId = Integer.valueOf(((Element)data.get("ItemId")).attributeValue("value")).intValue();
/*  54 */       this.Percent = Integer.valueOf(((Element)data.get("Percent")).attributeValue("value")).intValue();
/*     */       
/*  56 */       Element collectionElement = (Element)data.get("ZengSongs");
/*  57 */       if (collectionElement == null) {
/*  58 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*  60 */       List<?> _nodeList = collectionElement.elements();
/*  61 */       int _len = _nodeList.size();
/*  62 */       for (int j = 0; j < _len; j++) {
/*  63 */         Element elem = (Element)_nodeList.get(j);
/*  64 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.yuanbao.confbean.ZengSong")) {
/*     */           try {
/*  66 */             ZengSong _v_ = new ZengSong();
/*  67 */             _v_.loadFromXml(elem);
/*  68 */             this.ZengSongs.add(_v_);
/*     */ 
/*     */           }
/*     */           catch (Exception e) {}
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  77 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  82 */     String path = dir + "mzm.gsp.yuanbao.confbean.SYuanBaoConsts.xml";
/*     */     try {
/*  84 */       Element root = new SAXReader().read(new File(path)).getRootElement();
/*  85 */       Map<String, Element> data = new HashMap();
/*  86 */       List<?> nodeList = root.elements();
/*  87 */       int len = nodeList.size();
/*  88 */       for (int i = 0; i < len; i++) {
/*  89 */         Element element = (Element)nodeList.get(i);
/*  90 */         if (element.getName().equalsIgnoreCase("row")) {
/*  91 */           String name = element.attributeValue("name");
/*  92 */           if (data.put(name, element) != null) {
/*  93 */             throw new RuntimeException("duplicate const : " + name);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*  98 */       this.ItemId = Integer.valueOf(((Element)data.get("ItemId")).attributeValue("value")).intValue();
/*  99 */       this.Percent = Integer.valueOf(((Element)data.get("Percent")).attributeValue("value")).intValue();
/*     */       
/*     */ 
/* 102 */       Element collectionElement = (Element)data.get("ZengSongs");
/* 103 */       if (collectionElement == null)
/* 104 */         throw new RuntimeException("collection type element does not find");
/* 105 */       List<?> _nodeList = collectionElement.elements();
/* 106 */       int _len = _nodeList.size();
/* 107 */       for (int j = 0; j < _len; j++) {
/* 108 */         Element elem = (Element)_nodeList.get(j);
/* 109 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.yuanbao.confbean.ZengSong")) {
/*     */           try {
/* 111 */             ZengSong _v_ = new ZengSong();
/* 112 */             _v_.loadFromXml(elem);
/* 113 */             this.ZengSongs.add(_v_);
/*     */           }
/*     */           catch (Exception e) {}
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 121 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir) {
/* 126 */     instance._loadBny(dir);
/*     */   }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 130 */     String path = dir + "mzm.gsp.yuanbao.confbean.SYuanBaoConsts.bny";
/*     */     try {
/* 132 */       File file = new File(path);
/* 133 */       if (file.exists()) {
/* 134 */         byte[] bytes = new byte['Ѐ'];
/* 135 */         FileInputStream fis = new FileInputStream(file);
/* 136 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*     */         for (;;) {
/* 138 */           int len = fis.read(bytes);
/* 139 */           if (len <= 0) {
/*     */             break;
/*     */           }
/* 142 */           baos.write(bytes, 0, len);
/*     */         }
/* 144 */         fis.close();
/* 145 */         OctetsStream _os_ = OctetsStream.wrap(Octets.wrap(baos.toByteArray()));
/*     */         
/* 147 */         this.ItemId = _os_.unmarshal_int();
/* 148 */         this.Percent = _os_.unmarshal_int();
/*     */         
/* 150 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 151 */           ZengSong _v_ = new ZengSong();
/* 152 */           _v_.unmarshal(_os_);
/* 153 */           this.ZengSongs.add(_v_);
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 158 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir) {
/* 163 */     String path = dir + "mzm.gsp.yuanbao.confbean.SYuanBaoConsts.bny";
/*     */     try {
/* 165 */       File file = new File(path);
/* 166 */       if (file.exists()) {
/* 167 */         byte[] bytes = new byte['Ѐ'];
/* 168 */         FileInputStream fis = new FileInputStream(file);
/* 169 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*     */         for (;;) {
/* 171 */           int len = fis.read(bytes);
/* 172 */           if (len <= 0) {
/*     */             break;
/*     */           }
/* 175 */           baos.write(bytes, 0, len);
/*     */         }
/* 177 */         fis.close();
/* 178 */         OctetsStream _os_ = OctetsStream.wrap(Octets.wrap(baos.toByteArray()));
/*     */         
/* 180 */         this.ItemId = _os_.unmarshal_int();
/* 181 */         this.Percent = _os_.unmarshal_int();
/*     */         
/* 183 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 184 */           ZengSong _v_ = new ZengSong();
/* 185 */           _v_.unmarshal(_os_);
/* 186 */           this.ZengSongs.add(_v_);
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 191 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SYuanBaoConsts newInstance) {
/* 196 */     oldInstance = instance;
/* 197 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 202 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\yuanbao\confbean\SYuanBaoConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */