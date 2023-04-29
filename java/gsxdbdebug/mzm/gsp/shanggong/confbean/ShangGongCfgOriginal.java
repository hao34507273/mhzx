/*     */ package mzm.gsp.shanggong.confbean;
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
/*     */ public class ShangGongCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, ShangGongCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, ShangGongCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public String name;
/*     */   public String desc;
/*     */   public int shanggong_id;
/*     */   public int moduleid;
/*     */   public int anim_duration;
/*     */   public int sort_id;
/*     */   public String gongpin_name;
/*     */   public int point;
/*     */   public int effect_id;
/*     */   public int icon_id;
/*     */   public int money_type;
/*     */   public int money_num;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  34 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  35 */     this.name = rootElement.attributeValue("name");
/*  36 */     this.desc = rootElement.attributeValue("desc");
/*  37 */     this.shanggong_id = Integer.valueOf(rootElement.attributeValue("shanggong_id")).intValue();
/*  38 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  39 */     this.anim_duration = Integer.valueOf(rootElement.attributeValue("anim_duration")).intValue();
/*  40 */     this.sort_id = Integer.valueOf(rootElement.attributeValue("sort_id")).intValue();
/*  41 */     this.gongpin_name = rootElement.attributeValue("gongpin_name");
/*  42 */     this.point = Integer.valueOf(rootElement.attributeValue("point")).intValue();
/*  43 */     this.effect_id = Integer.valueOf(rootElement.attributeValue("effect_id")).intValue();
/*  44 */     this.icon_id = Integer.valueOf(rootElement.attributeValue("icon_id")).intValue();
/*  45 */     this.money_type = Integer.valueOf(rootElement.attributeValue("money_type")).intValue();
/*  46 */     this.money_num = Integer.valueOf(rootElement.attributeValue("money_num")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  51 */     _os_.marshal(this.id);
/*  52 */     _os_.marshal(this.name, "UTF-8");
/*  53 */     _os_.marshal(this.desc, "UTF-8");
/*  54 */     _os_.marshal(this.shanggong_id);
/*  55 */     _os_.marshal(this.moduleid);
/*  56 */     _os_.marshal(this.anim_duration);
/*  57 */     _os_.marshal(this.sort_id);
/*  58 */     _os_.marshal(this.gongpin_name, "UTF-8");
/*  59 */     _os_.marshal(this.point);
/*  60 */     _os_.marshal(this.effect_id);
/*  61 */     _os_.marshal(this.icon_id);
/*  62 */     _os_.marshal(this.money_type);
/*  63 */     _os_.marshal(this.money_num);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  69 */     this.id = _os_.unmarshal_int();
/*  70 */     this.name = _os_.unmarshal_String("UTF-8");
/*  71 */     this.desc = _os_.unmarshal_String("UTF-8");
/*  72 */     this.shanggong_id = _os_.unmarshal_int();
/*  73 */     this.moduleid = _os_.unmarshal_int();
/*  74 */     this.anim_duration = _os_.unmarshal_int();
/*  75 */     this.sort_id = _os_.unmarshal_int();
/*  76 */     this.gongpin_name = _os_.unmarshal_String("UTF-8");
/*  77 */     this.point = _os_.unmarshal_int();
/*  78 */     this.effect_id = _os_.unmarshal_int();
/*  79 */     this.icon_id = _os_.unmarshal_int();
/*  80 */     this.money_type = _os_.unmarshal_int();
/*  81 */     this.money_num = _os_.unmarshal_int();
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  87 */     String path = dir + "mzm.gsp.shanggong.confbean.ShangGongCfgOriginal.xml";
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
/* 100 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.shanggong.confbean.ShangGongCfgOriginal"))
/*     */         {
/*     */ 
/* 103 */           ShangGongCfgOriginal obj = new ShangGongCfgOriginal();
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
/*     */   public static void reLoadXml(String dir, Map<Integer, ShangGongCfgOriginal> all)
/*     */   {
/* 117 */     String path = dir + "mzm.gsp.shanggong.confbean.ShangGongCfgOriginal.xml";
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
/* 129 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.shanggong.confbean.ShangGongCfgOriginal"))
/*     */         {
/*     */ 
/* 132 */           ShangGongCfgOriginal obj = new ShangGongCfgOriginal();
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
/* 148 */     String path = dir + "mzm.gsp.shanggong.confbean.ShangGongCfgOriginal.bny";
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
/* 175 */           ShangGongCfgOriginal _v_ = new ShangGongCfgOriginal();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, ShangGongCfgOriginal> all)
/*     */   {
/* 195 */     String path = dir + "mzm.gsp.shanggong.confbean.ShangGongCfgOriginal.bny";
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
/* 222 */           ShangGongCfgOriginal _v_ = new ShangGongCfgOriginal();
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
/*     */   public static ShangGongCfgOriginal getOld(int key)
/*     */   {
/* 243 */     return (ShangGongCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static ShangGongCfgOriginal get(int key)
/*     */   {
/* 248 */     return (ShangGongCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, ShangGongCfgOriginal> getOldAll()
/*     */   {
/* 253 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, ShangGongCfgOriginal> getAll()
/*     */   {
/* 258 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, ShangGongCfgOriginal> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanggong\confbean\ShangGongCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */