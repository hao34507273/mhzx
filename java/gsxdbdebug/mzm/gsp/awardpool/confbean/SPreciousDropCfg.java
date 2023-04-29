/*     */ package mzm.gsp.awardpool.confbean;
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
/*     */ public class SPreciousDropCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SPreciousDropCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SPreciousDropCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int serverDropNeedCount1;
/*     */   public int serverMaxDropCount1;
/*     */   public int serverDropNeedCount2;
/*     */   public int serverMaxDropCount2;
/*     */   public int serverClearTypeEnum2;
/*     */   public int roleDropType;
/*     */   public int awardTypeId;
/*     */   public int roleDropNeedCount1;
/*     */   public int roleMaxDropCount1;
/*     */   public int roleDropNeedCount2;
/*     */   public int roleMaxDropCount2;
/*     */   public int roleClearTypeEnum2;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  34 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  35 */     this.serverDropNeedCount1 = Integer.valueOf(rootElement.attributeValue("serverDropNeedCount1")).intValue();
/*  36 */     this.serverMaxDropCount1 = Integer.valueOf(rootElement.attributeValue("serverMaxDropCount1")).intValue();
/*  37 */     this.serverDropNeedCount2 = Integer.valueOf(rootElement.attributeValue("serverDropNeedCount2")).intValue();
/*  38 */     this.serverMaxDropCount2 = Integer.valueOf(rootElement.attributeValue("serverMaxDropCount2")).intValue();
/*  39 */     this.serverClearTypeEnum2 = Integer.valueOf(rootElement.attributeValue("serverClearTypeEnum2")).intValue();
/*  40 */     this.roleDropType = Integer.valueOf(rootElement.attributeValue("roleDropType")).intValue();
/*  41 */     this.awardTypeId = Integer.valueOf(rootElement.attributeValue("awardTypeId")).intValue();
/*  42 */     this.roleDropNeedCount1 = Integer.valueOf(rootElement.attributeValue("roleDropNeedCount1")).intValue();
/*  43 */     this.roleMaxDropCount1 = Integer.valueOf(rootElement.attributeValue("roleMaxDropCount1")).intValue();
/*  44 */     this.roleDropNeedCount2 = Integer.valueOf(rootElement.attributeValue("roleDropNeedCount2")).intValue();
/*  45 */     this.roleMaxDropCount2 = Integer.valueOf(rootElement.attributeValue("roleMaxDropCount2")).intValue();
/*  46 */     this.roleClearTypeEnum2 = Integer.valueOf(rootElement.attributeValue("roleClearTypeEnum2")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  51 */     _os_.marshal(this.id);
/*  52 */     _os_.marshal(this.serverDropNeedCount1);
/*  53 */     _os_.marshal(this.serverMaxDropCount1);
/*  54 */     _os_.marshal(this.serverDropNeedCount2);
/*  55 */     _os_.marshal(this.serverMaxDropCount2);
/*  56 */     _os_.marshal(this.serverClearTypeEnum2);
/*  57 */     _os_.marshal(this.roleDropType);
/*  58 */     _os_.marshal(this.awardTypeId);
/*  59 */     _os_.marshal(this.roleDropNeedCount1);
/*  60 */     _os_.marshal(this.roleMaxDropCount1);
/*  61 */     _os_.marshal(this.roleDropNeedCount2);
/*  62 */     _os_.marshal(this.roleMaxDropCount2);
/*  63 */     _os_.marshal(this.roleClearTypeEnum2);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  69 */     this.id = _os_.unmarshal_int();
/*  70 */     this.serverDropNeedCount1 = _os_.unmarshal_int();
/*  71 */     this.serverMaxDropCount1 = _os_.unmarshal_int();
/*  72 */     this.serverDropNeedCount2 = _os_.unmarshal_int();
/*  73 */     this.serverMaxDropCount2 = _os_.unmarshal_int();
/*  74 */     this.serverClearTypeEnum2 = _os_.unmarshal_int();
/*  75 */     this.roleDropType = _os_.unmarshal_int();
/*  76 */     this.awardTypeId = _os_.unmarshal_int();
/*  77 */     this.roleDropNeedCount1 = _os_.unmarshal_int();
/*  78 */     this.roleMaxDropCount1 = _os_.unmarshal_int();
/*  79 */     this.roleDropNeedCount2 = _os_.unmarshal_int();
/*  80 */     this.roleMaxDropCount2 = _os_.unmarshal_int();
/*  81 */     this.roleClearTypeEnum2 = _os_.unmarshal_int();
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  87 */     String path = dir + "mzm.gsp.awardpool.confbean.SPreciousDropCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  91 */       all = new java.util.HashMap();
/*  92 */       SAXReader reader = new SAXReader();
/*  93 */       org.dom4j.Document doc = reader.read(new File(path));
/*  94 */       Element root = doc.getRootElement();
/*  95 */       List<?> nodeList = root.elements();
/*  96 */       int len = nodeList.size();
/*  97 */       for (int i = 0; i < len; i++)
/*     */       {
/*  99 */         Element elem = (Element)nodeList.get(i);
/* 100 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.awardpool.confbean.SPreciousDropCfg"))
/*     */         {
/*     */ 
/* 103 */           SPreciousDropCfg obj = new SPreciousDropCfg();
/* 104 */           obj.loadFromXml(elem);
/* 105 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 106 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 111 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SPreciousDropCfg> all)
/*     */   {
/* 117 */     String path = dir + "mzm.gsp.awardpool.confbean.SPreciousDropCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 121 */       SAXReader reader = new SAXReader();
/* 122 */       org.dom4j.Document doc = reader.read(new File(path));
/* 123 */       Element root = doc.getRootElement();
/* 124 */       List<?> nodeList = root.elements();
/* 125 */       int len = nodeList.size();
/* 126 */       for (int i = 0; i < len; i++)
/*     */       {
/* 128 */         Element elem = (Element)nodeList.get(i);
/* 129 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.awardpool.confbean.SPreciousDropCfg"))
/*     */         {
/*     */ 
/* 132 */           SPreciousDropCfg obj = new SPreciousDropCfg();
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
/*     */   public static void loadBny(String dir)
/*     */   {
/* 146 */     all = new java.util.HashMap();
/*     */     
/* 148 */     String path = dir + "mzm.gsp.awardpool.confbean.SPreciousDropCfg.bny";
/*     */     try
/*     */     {
/* 151 */       File file = new File(path);
/* 152 */       if (file.exists())
/*     */       {
/* 154 */         byte[] bytes = new byte['Ѐ'];
/* 155 */         FileInputStream fis = new FileInputStream(file);
/* 156 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 157 */         int len = 0;
/* 158 */         while ((len = fis.read(bytes)) > 0)
/* 159 */           baos.write(bytes, 0, len);
/* 160 */         fis.close();
/* 161 */         bytes = baos.toByteArray();
/* 162 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 163 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 165 */           _os_.unmarshal_int();
/* 166 */           _os_.unmarshal_int();
/* 167 */           _os_.unmarshal_int();
/*     */         }
/* 169 */         _os_.unmarshal_int();
/* 170 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 173 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 175 */           SPreciousDropCfg _v_ = new SPreciousDropCfg();
/* 176 */           _v_.unmarshal(_os_);
/* 177 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 178 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 183 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 188 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SPreciousDropCfg> all)
/*     */   {
/* 195 */     String path = dir + "mzm.gsp.awardpool.confbean.SPreciousDropCfg.bny";
/*     */     try
/*     */     {
/* 198 */       File file = new File(path);
/* 199 */       if (file.exists())
/*     */       {
/* 201 */         byte[] bytes = new byte['Ѐ'];
/* 202 */         FileInputStream fis = new FileInputStream(file);
/* 203 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 204 */         int len = 0;
/* 205 */         while ((len = fis.read(bytes)) > 0)
/* 206 */           baos.write(bytes, 0, len);
/* 207 */         fis.close();
/* 208 */         bytes = baos.toByteArray();
/* 209 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 210 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 212 */           _os_.unmarshal_int();
/* 213 */           _os_.unmarshal_int();
/* 214 */           _os_.unmarshal_int();
/*     */         }
/* 216 */         _os_.unmarshal_int();
/* 217 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 220 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 222 */           SPreciousDropCfg _v_ = new SPreciousDropCfg();
/* 223 */           _v_.unmarshal(_os_);
/* 224 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 225 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 230 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 235 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SPreciousDropCfg getOld(int key)
/*     */   {
/* 243 */     return (SPreciousDropCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SPreciousDropCfg get(int key)
/*     */   {
/* 248 */     return (SPreciousDropCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPreciousDropCfg> getOldAll()
/*     */   {
/* 253 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPreciousDropCfg> getAll()
/*     */   {
/* 258 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SPreciousDropCfg> newAll)
/*     */   {
/* 263 */     oldAll = all;
/* 264 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 269 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\confbean\SPreciousDropCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */