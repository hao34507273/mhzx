/*     */ package mzm.gsp.grc.confbean;
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
/*     */ public class SRecallFriendSignAwardCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SRecallFriendSignAwardCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SRecallFriendSignAwardCfg> all = null;
/*     */   
/*     */   public int signDay;
/*     */   public int awardId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  23 */     this.signDay = Integer.valueOf(rootElement.attributeValue("signDay")).intValue();
/*  24 */     this.awardId = Integer.valueOf(rootElement.attributeValue("awardId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  29 */     _os_.marshal(this.signDay);
/*  30 */     _os_.marshal(this.awardId);
/*  31 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  36 */     this.signDay = _os_.unmarshal_int();
/*  37 */     this.awardId = _os_.unmarshal_int();
/*  38 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  43 */     String path = dir + "mzm.gsp.grc.confbean.SRecallFriendSignAwardCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  47 */       all = new java.util.TreeMap();
/*  48 */       SAXReader reader = new SAXReader();
/*  49 */       org.dom4j.Document doc = reader.read(new File(path));
/*  50 */       Element root = doc.getRootElement();
/*  51 */       List<?> nodeList = root.elements();
/*  52 */       int len = nodeList.size();
/*  53 */       for (int i = 0; i < len; i++)
/*     */       {
/*  55 */         Element elem = (Element)nodeList.get(i);
/*  56 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.grc.confbean.SRecallFriendSignAwardCfg"))
/*     */         {
/*     */ 
/*  59 */           SRecallFriendSignAwardCfg obj = new SRecallFriendSignAwardCfg();
/*  60 */           obj.loadFromXml(elem);
/*  61 */           if (all.put(Integer.valueOf(obj.signDay), obj) != null) {
/*  62 */             throw new RuntimeException("duplicate key : " + obj.signDay);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  67 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SRecallFriendSignAwardCfg> all)
/*     */   {
/*  73 */     String path = dir + "mzm.gsp.grc.confbean.SRecallFriendSignAwardCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  77 */       SAXReader reader = new SAXReader();
/*  78 */       org.dom4j.Document doc = reader.read(new File(path));
/*  79 */       Element root = doc.getRootElement();
/*  80 */       List<?> nodeList = root.elements();
/*  81 */       int len = nodeList.size();
/*  82 */       for (int i = 0; i < len; i++)
/*     */       {
/*  84 */         Element elem = (Element)nodeList.get(i);
/*  85 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.grc.confbean.SRecallFriendSignAwardCfg"))
/*     */         {
/*     */ 
/*  88 */           SRecallFriendSignAwardCfg obj = new SRecallFriendSignAwardCfg();
/*  89 */           obj.loadFromXml(elem);
/*  90 */           if (all.put(Integer.valueOf(obj.signDay), obj) != null) {
/*  91 */             throw new RuntimeException("duplicate key : " + obj.signDay);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  96 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 102 */     all = new java.util.TreeMap();
/*     */     
/* 104 */     String path = dir + "mzm.gsp.grc.confbean.SRecallFriendSignAwardCfg.bny";
/*     */     try
/*     */     {
/* 107 */       File file = new File(path);
/* 108 */       if (file.exists())
/*     */       {
/* 110 */         byte[] bytes = new byte['Ѐ'];
/* 111 */         FileInputStream fis = new FileInputStream(file);
/* 112 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 113 */         int len = 0;
/* 114 */         while ((len = fis.read(bytes)) > 0)
/* 115 */           baos.write(bytes, 0, len);
/* 116 */         fis.close();
/* 117 */         bytes = baos.toByteArray();
/* 118 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 119 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 121 */           _os_.unmarshal_int();
/* 122 */           _os_.unmarshal_int();
/* 123 */           _os_.unmarshal_int();
/*     */         }
/* 125 */         _os_.unmarshal_int();
/* 126 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 129 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 131 */           SRecallFriendSignAwardCfg _v_ = new SRecallFriendSignAwardCfg();
/* 132 */           _v_.unmarshal(_os_);
/* 133 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 134 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 139 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 144 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SRecallFriendSignAwardCfg> all)
/*     */   {
/* 151 */     String path = dir + "mzm.gsp.grc.confbean.SRecallFriendSignAwardCfg.bny";
/*     */     try
/*     */     {
/* 154 */       File file = new File(path);
/* 155 */       if (file.exists())
/*     */       {
/* 157 */         byte[] bytes = new byte['Ѐ'];
/* 158 */         FileInputStream fis = new FileInputStream(file);
/* 159 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 160 */         int len = 0;
/* 161 */         while ((len = fis.read(bytes)) > 0)
/* 162 */           baos.write(bytes, 0, len);
/* 163 */         fis.close();
/* 164 */         bytes = baos.toByteArray();
/* 165 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 166 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 168 */           _os_.unmarshal_int();
/* 169 */           _os_.unmarshal_int();
/* 170 */           _os_.unmarshal_int();
/*     */         }
/* 172 */         _os_.unmarshal_int();
/* 173 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 176 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 178 */           SRecallFriendSignAwardCfg _v_ = new SRecallFriendSignAwardCfg();
/* 179 */           _v_.unmarshal(_os_);
/* 180 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 181 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 186 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 191 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SRecallFriendSignAwardCfg getOld(int key)
/*     */   {
/* 199 */     return (SRecallFriendSignAwardCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SRecallFriendSignAwardCfg get(int key)
/*     */   {
/* 204 */     return (SRecallFriendSignAwardCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SRecallFriendSignAwardCfg> getOldAll()
/*     */   {
/* 209 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SRecallFriendSignAwardCfg> getAll()
/*     */   {
/* 214 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SRecallFriendSignAwardCfg> newAll)
/*     */   {
/* 219 */     oldAll = all;
/* 220 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 225 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\confbean\SRecallFriendSignAwardCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */