/*     */ package mzm.gsp.nationalholiday.confbean;
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
/*     */ public class SBirthdayPrayCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SBirthdayPrayCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SBirthdayPrayCfg> all = null;
/*     */   
/*     */   public int activityId;
/*     */   public int openId;
/*  20 */   public java.util.ArrayList<Integer> taskActivityIdList = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  24 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/*  25 */     this.openId = Integer.valueOf(rootElement.attributeValue("openId")).intValue();
/*     */     
/*  27 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "taskActivityIdList");
/*  28 */     if (collectionElement == null)
/*     */     {
/*  30 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  33 */     List<?> _nodeList = collectionElement.elements();
/*  34 */     int _len = _nodeList.size();
/*  35 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  37 */       Element elem = (Element)_nodeList.get(i);
/*  38 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  45 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  52 */         this.taskActivityIdList.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  59 */     _os_.marshal(this.activityId);
/*  60 */     _os_.marshal(this.openId);
/*  61 */     _os_.compact_uint32(this.taskActivityIdList.size());
/*  62 */     for (Integer _v_ : this.taskActivityIdList)
/*     */     {
/*  64 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  71 */     this.activityId = _os_.unmarshal_int();
/*  72 */     this.openId = _os_.unmarshal_int();
/*  73 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  76 */       int _v_ = _os_.unmarshal_int();
/*  77 */       this.taskActivityIdList.add(Integer.valueOf(_v_));
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  84 */     String path = dir + "mzm.gsp.nationalholiday.confbean.SBirthdayPrayCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  88 */       all = new java.util.HashMap();
/*  89 */       SAXReader reader = new SAXReader();
/*  90 */       org.dom4j.Document doc = reader.read(new File(path));
/*  91 */       Element root = doc.getRootElement();
/*  92 */       List<?> nodeList = root.elements();
/*  93 */       int len = nodeList.size();
/*  94 */       for (int i = 0; i < len; i++)
/*     */       {
/*  96 */         Element elem = (Element)nodeList.get(i);
/*  97 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.nationalholiday.confbean.SBirthdayPrayCfg"))
/*     */         {
/*     */ 
/* 100 */           SBirthdayPrayCfg obj = new SBirthdayPrayCfg();
/* 101 */           obj.loadFromXml(elem);
/* 102 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 103 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 108 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SBirthdayPrayCfg> all)
/*     */   {
/* 114 */     String path = dir + "mzm.gsp.nationalholiday.confbean.SBirthdayPrayCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 118 */       SAXReader reader = new SAXReader();
/* 119 */       org.dom4j.Document doc = reader.read(new File(path));
/* 120 */       Element root = doc.getRootElement();
/* 121 */       List<?> nodeList = root.elements();
/* 122 */       int len = nodeList.size();
/* 123 */       for (int i = 0; i < len; i++)
/*     */       {
/* 125 */         Element elem = (Element)nodeList.get(i);
/* 126 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.nationalholiday.confbean.SBirthdayPrayCfg"))
/*     */         {
/*     */ 
/* 129 */           SBirthdayPrayCfg obj = new SBirthdayPrayCfg();
/* 130 */           obj.loadFromXml(elem);
/* 131 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 132 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 137 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 143 */     all = new java.util.HashMap();
/*     */     
/* 145 */     String path = dir + "mzm.gsp.nationalholiday.confbean.SBirthdayPrayCfg.bny";
/*     */     try
/*     */     {
/* 148 */       File file = new File(path);
/* 149 */       if (file.exists())
/*     */       {
/* 151 */         byte[] bytes = new byte['Ѐ'];
/* 152 */         FileInputStream fis = new FileInputStream(file);
/* 153 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 154 */         int len = 0;
/* 155 */         while ((len = fis.read(bytes)) > 0)
/* 156 */           baos.write(bytes, 0, len);
/* 157 */         fis.close();
/* 158 */         bytes = baos.toByteArray();
/* 159 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 160 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 162 */           _os_.unmarshal_int();
/* 163 */           _os_.unmarshal_int();
/* 164 */           _os_.unmarshal_int();
/*     */         }
/* 166 */         _os_.unmarshal_int();
/* 167 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 170 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 172 */           SBirthdayPrayCfg _v_ = new SBirthdayPrayCfg();
/* 173 */           _v_.unmarshal(_os_);
/* 174 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 175 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 180 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 185 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SBirthdayPrayCfg> all)
/*     */   {
/* 192 */     String path = dir + "mzm.gsp.nationalholiday.confbean.SBirthdayPrayCfg.bny";
/*     */     try
/*     */     {
/* 195 */       File file = new File(path);
/* 196 */       if (file.exists())
/*     */       {
/* 198 */         byte[] bytes = new byte['Ѐ'];
/* 199 */         FileInputStream fis = new FileInputStream(file);
/* 200 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 201 */         int len = 0;
/* 202 */         while ((len = fis.read(bytes)) > 0)
/* 203 */           baos.write(bytes, 0, len);
/* 204 */         fis.close();
/* 205 */         bytes = baos.toByteArray();
/* 206 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 207 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 209 */           _os_.unmarshal_int();
/* 210 */           _os_.unmarshal_int();
/* 211 */           _os_.unmarshal_int();
/*     */         }
/* 213 */         _os_.unmarshal_int();
/* 214 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 217 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 219 */           SBirthdayPrayCfg _v_ = new SBirthdayPrayCfg();
/* 220 */           _v_.unmarshal(_os_);
/* 221 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 222 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 227 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 232 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SBirthdayPrayCfg getOld(int key)
/*     */   {
/* 240 */     return (SBirthdayPrayCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SBirthdayPrayCfg get(int key)
/*     */   {
/* 245 */     return (SBirthdayPrayCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBirthdayPrayCfg> getOldAll()
/*     */   {
/* 250 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBirthdayPrayCfg> getAll()
/*     */   {
/* 255 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SBirthdayPrayCfg> newAll)
/*     */   {
/* 260 */     oldAll = all;
/* 261 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 266 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\nationalholiday\confbean\SBirthdayPrayCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */