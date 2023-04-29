/*     */ package mzm.gsp.feisheng.confbean;
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
/*     */ public class SFeiShengDevelopItemActivityCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SFeiShengDevelopItemActivityCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SFeiShengDevelopItemActivityCfg> all = null;
/*     */   
/*     */   public int activity_cfg_id;
/*     */   public int moduleid;
/*     */   public int serverlevel;
/*     */   public int npc_id;
/*     */   public int get_item_npc_service_id;
/*     */   public int commit_item_npc_service_id;
/*     */   public int item_cfg_id;
/*     */   public int extra_type;
/*     */   public int extra_value;
/*     */   public int award_id;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  31 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  32 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  33 */     this.serverlevel = Integer.valueOf(rootElement.attributeValue("serverlevel")).intValue();
/*  34 */     this.npc_id = Integer.valueOf(rootElement.attributeValue("npc_id")).intValue();
/*  35 */     this.get_item_npc_service_id = Integer.valueOf(rootElement.attributeValue("get_item_npc_service_id")).intValue();
/*  36 */     this.commit_item_npc_service_id = Integer.valueOf(rootElement.attributeValue("commit_item_npc_service_id")).intValue();
/*  37 */     this.item_cfg_id = Integer.valueOf(rootElement.attributeValue("item_cfg_id")).intValue();
/*  38 */     this.extra_type = Integer.valueOf(rootElement.attributeValue("extra_type")).intValue();
/*  39 */     this.extra_value = Integer.valueOf(rootElement.attributeValue("extra_value")).intValue();
/*  40 */     this.award_id = Integer.valueOf(rootElement.attributeValue("award_id")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  45 */     _os_.marshal(this.activity_cfg_id);
/*  46 */     _os_.marshal(this.moduleid);
/*  47 */     _os_.marshal(this.serverlevel);
/*  48 */     _os_.marshal(this.npc_id);
/*  49 */     _os_.marshal(this.get_item_npc_service_id);
/*  50 */     _os_.marshal(this.commit_item_npc_service_id);
/*  51 */     _os_.marshal(this.item_cfg_id);
/*  52 */     _os_.marshal(this.extra_type);
/*  53 */     _os_.marshal(this.extra_value);
/*  54 */     _os_.marshal(this.award_id);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  60 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  61 */     this.moduleid = _os_.unmarshal_int();
/*  62 */     this.serverlevel = _os_.unmarshal_int();
/*  63 */     this.npc_id = _os_.unmarshal_int();
/*  64 */     this.get_item_npc_service_id = _os_.unmarshal_int();
/*  65 */     this.commit_item_npc_service_id = _os_.unmarshal_int();
/*  66 */     this.item_cfg_id = _os_.unmarshal_int();
/*  67 */     this.extra_type = _os_.unmarshal_int();
/*  68 */     this.extra_value = _os_.unmarshal_int();
/*  69 */     this.award_id = _os_.unmarshal_int();
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  75 */     String path = dir + "mzm.gsp.feisheng.confbean.SFeiShengDevelopItemActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  79 */       all = new java.util.HashMap();
/*  80 */       SAXReader reader = new SAXReader();
/*  81 */       org.dom4j.Document doc = reader.read(new File(path));
/*  82 */       Element root = doc.getRootElement();
/*  83 */       List<?> nodeList = root.elements();
/*  84 */       int len = nodeList.size();
/*  85 */       for (int i = 0; i < len; i++)
/*     */       {
/*  87 */         Element elem = (Element)nodeList.get(i);
/*  88 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.feisheng.confbean.SFeiShengDevelopItemActivityCfg"))
/*     */         {
/*     */ 
/*  91 */           SFeiShengDevelopItemActivityCfg obj = new SFeiShengDevelopItemActivityCfg();
/*  92 */           obj.loadFromXml(elem);
/*  93 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/*  94 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  99 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SFeiShengDevelopItemActivityCfg> all)
/*     */   {
/* 105 */     String path = dir + "mzm.gsp.feisheng.confbean.SFeiShengDevelopItemActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 109 */       SAXReader reader = new SAXReader();
/* 110 */       org.dom4j.Document doc = reader.read(new File(path));
/* 111 */       Element root = doc.getRootElement();
/* 112 */       List<?> nodeList = root.elements();
/* 113 */       int len = nodeList.size();
/* 114 */       for (int i = 0; i < len; i++)
/*     */       {
/* 116 */         Element elem = (Element)nodeList.get(i);
/* 117 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.feisheng.confbean.SFeiShengDevelopItemActivityCfg"))
/*     */         {
/*     */ 
/* 120 */           SFeiShengDevelopItemActivityCfg obj = new SFeiShengDevelopItemActivityCfg();
/* 121 */           obj.loadFromXml(elem);
/* 122 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 123 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 128 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 134 */     all = new java.util.HashMap();
/*     */     
/* 136 */     String path = dir + "mzm.gsp.feisheng.confbean.SFeiShengDevelopItemActivityCfg.bny";
/*     */     try
/*     */     {
/* 139 */       File file = new File(path);
/* 140 */       if (file.exists())
/*     */       {
/* 142 */         byte[] bytes = new byte['Ѐ'];
/* 143 */         FileInputStream fis = new FileInputStream(file);
/* 144 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 145 */         int len = 0;
/* 146 */         while ((len = fis.read(bytes)) > 0)
/* 147 */           baos.write(bytes, 0, len);
/* 148 */         fis.close();
/* 149 */         bytes = baos.toByteArray();
/* 150 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 151 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 153 */           _os_.unmarshal_int();
/* 154 */           _os_.unmarshal_int();
/* 155 */           _os_.unmarshal_int();
/*     */         }
/* 157 */         _os_.unmarshal_int();
/* 158 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 161 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 163 */           SFeiShengDevelopItemActivityCfg _v_ = new SFeiShengDevelopItemActivityCfg();
/* 164 */           _v_.unmarshal(_os_);
/* 165 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 166 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 171 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 176 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SFeiShengDevelopItemActivityCfg> all)
/*     */   {
/* 183 */     String path = dir + "mzm.gsp.feisheng.confbean.SFeiShengDevelopItemActivityCfg.bny";
/*     */     try
/*     */     {
/* 186 */       File file = new File(path);
/* 187 */       if (file.exists())
/*     */       {
/* 189 */         byte[] bytes = new byte['Ѐ'];
/* 190 */         FileInputStream fis = new FileInputStream(file);
/* 191 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 192 */         int len = 0;
/* 193 */         while ((len = fis.read(bytes)) > 0)
/* 194 */           baos.write(bytes, 0, len);
/* 195 */         fis.close();
/* 196 */         bytes = baos.toByteArray();
/* 197 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 198 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 200 */           _os_.unmarshal_int();
/* 201 */           _os_.unmarshal_int();
/* 202 */           _os_.unmarshal_int();
/*     */         }
/* 204 */         _os_.unmarshal_int();
/* 205 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 208 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 210 */           SFeiShengDevelopItemActivityCfg _v_ = new SFeiShengDevelopItemActivityCfg();
/* 211 */           _v_.unmarshal(_os_);
/* 212 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 213 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 218 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 223 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SFeiShengDevelopItemActivityCfg getOld(int key)
/*     */   {
/* 231 */     return (SFeiShengDevelopItemActivityCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SFeiShengDevelopItemActivityCfg get(int key)
/*     */   {
/* 236 */     return (SFeiShengDevelopItemActivityCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFeiShengDevelopItemActivityCfg> getOldAll()
/*     */   {
/* 241 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFeiShengDevelopItemActivityCfg> getAll()
/*     */   {
/* 246 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SFeiShengDevelopItemActivityCfg> newAll)
/*     */   {
/* 251 */     oldAll = all;
/* 252 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 257 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\confbean\SFeiShengDevelopItemActivityCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */