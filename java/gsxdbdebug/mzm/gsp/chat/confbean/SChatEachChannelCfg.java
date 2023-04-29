/*     */ package mzm.gsp.chat.confbean;
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
/*     */ public class SChatEachChannelCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SChatEachChannelCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SChatEachChannelCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templatename;
/*     */   public int channelType;
/*     */   public int timeLag;
/*     */   public int levelMin;
/*     */   public int channelIconId;
/*     */   public boolean channelBubble;
/*     */   public int energyConsume;
/*     */   public boolean mainInterfaceDisplay;
/*     */   public int mainInterfaceFontColorR;
/*     */   public int mainInterfaceFontColorG;
/*     */   public int mainInterfaceFontColorB;
/*     */   public int packageNumMax;
/*     */   public boolean chatInterfaceHint;
/*     */   public boolean autoPlayVoice;
/*     */   public boolean shieldChannelMessage;
/*     */   public boolean canChatInCross;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  38 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  39 */     this.templatename = rootElement.attributeValue("templatename");
/*  40 */     this.channelType = Integer.valueOf(rootElement.attributeValue("channelType")).intValue();
/*  41 */     this.timeLag = Integer.valueOf(rootElement.attributeValue("timeLag")).intValue();
/*  42 */     this.levelMin = Integer.valueOf(rootElement.attributeValue("levelMin")).intValue();
/*  43 */     this.channelIconId = Integer.valueOf(rootElement.attributeValue("channelIconId")).intValue();
/*  44 */     this.channelBubble = Boolean.valueOf(rootElement.attributeValue("channelBubble")).booleanValue();
/*  45 */     this.energyConsume = Integer.valueOf(rootElement.attributeValue("energyConsume")).intValue();
/*  46 */     this.mainInterfaceDisplay = Boolean.valueOf(rootElement.attributeValue("mainInterfaceDisplay")).booleanValue();
/*  47 */     this.mainInterfaceFontColorR = Integer.valueOf(rootElement.attributeValue("mainInterfaceFontColorR")).intValue();
/*  48 */     this.mainInterfaceFontColorG = Integer.valueOf(rootElement.attributeValue("mainInterfaceFontColorG")).intValue();
/*  49 */     this.mainInterfaceFontColorB = Integer.valueOf(rootElement.attributeValue("mainInterfaceFontColorB")).intValue();
/*  50 */     this.packageNumMax = Integer.valueOf(rootElement.attributeValue("packageNumMax")).intValue();
/*  51 */     this.chatInterfaceHint = Boolean.valueOf(rootElement.attributeValue("chatInterfaceHint")).booleanValue();
/*  52 */     this.autoPlayVoice = Boolean.valueOf(rootElement.attributeValue("autoPlayVoice")).booleanValue();
/*  53 */     this.shieldChannelMessage = Boolean.valueOf(rootElement.attributeValue("shieldChannelMessage")).booleanValue();
/*  54 */     this.canChatInCross = Boolean.valueOf(rootElement.attributeValue("canChatInCross")).booleanValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  59 */     _os_.marshal(this.id);
/*  60 */     _os_.marshal(this.templatename, "UTF-8");
/*  61 */     _os_.marshal(this.channelType);
/*  62 */     _os_.marshal(this.timeLag);
/*  63 */     _os_.marshal(this.levelMin);
/*  64 */     _os_.marshal(this.channelIconId);
/*  65 */     _os_.marshal(this.channelBubble);
/*  66 */     _os_.marshal(this.energyConsume);
/*  67 */     _os_.marshal(this.mainInterfaceDisplay);
/*  68 */     _os_.marshal(this.mainInterfaceFontColorR);
/*  69 */     _os_.marshal(this.mainInterfaceFontColorG);
/*  70 */     _os_.marshal(this.mainInterfaceFontColorB);
/*  71 */     _os_.marshal(this.packageNumMax);
/*  72 */     _os_.marshal(this.chatInterfaceHint);
/*  73 */     _os_.marshal(this.autoPlayVoice);
/*  74 */     _os_.marshal(this.shieldChannelMessage);
/*  75 */     _os_.marshal(this.canChatInCross);
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  81 */     this.id = _os_.unmarshal_int();
/*  82 */     this.templatename = _os_.unmarshal_String("UTF-8");
/*  83 */     this.channelType = _os_.unmarshal_int();
/*  84 */     this.timeLag = _os_.unmarshal_int();
/*  85 */     this.levelMin = _os_.unmarshal_int();
/*  86 */     this.channelIconId = _os_.unmarshal_int();
/*  87 */     this.channelBubble = _os_.unmarshal_boolean();
/*  88 */     this.energyConsume = _os_.unmarshal_int();
/*  89 */     this.mainInterfaceDisplay = _os_.unmarshal_boolean();
/*  90 */     this.mainInterfaceFontColorR = _os_.unmarshal_int();
/*  91 */     this.mainInterfaceFontColorG = _os_.unmarshal_int();
/*  92 */     this.mainInterfaceFontColorB = _os_.unmarshal_int();
/*  93 */     this.packageNumMax = _os_.unmarshal_int();
/*  94 */     this.chatInterfaceHint = _os_.unmarshal_boolean();
/*  95 */     this.autoPlayVoice = _os_.unmarshal_boolean();
/*  96 */     this.shieldChannelMessage = _os_.unmarshal_boolean();
/*  97 */     this.canChatInCross = _os_.unmarshal_boolean();
/*  98 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 103 */     String path = dir + "mzm.gsp.chat.confbean.SChatEachChannelCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 107 */       all = new java.util.HashMap();
/* 108 */       SAXReader reader = new SAXReader();
/* 109 */       org.dom4j.Document doc = reader.read(new File(path));
/* 110 */       Element root = doc.getRootElement();
/* 111 */       List<?> nodeList = root.elements();
/* 112 */       int len = nodeList.size();
/* 113 */       for (int i = 0; i < len; i++)
/*     */       {
/* 115 */         Element elem = (Element)nodeList.get(i);
/* 116 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.chat.confbean.SChatEachChannelCfg"))
/*     */         {
/*     */ 
/* 119 */           SChatEachChannelCfg obj = new SChatEachChannelCfg();
/* 120 */           obj.loadFromXml(elem);
/* 121 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 122 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 127 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SChatEachChannelCfg> all)
/*     */   {
/* 133 */     String path = dir + "mzm.gsp.chat.confbean.SChatEachChannelCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 137 */       SAXReader reader = new SAXReader();
/* 138 */       org.dom4j.Document doc = reader.read(new File(path));
/* 139 */       Element root = doc.getRootElement();
/* 140 */       List<?> nodeList = root.elements();
/* 141 */       int len = nodeList.size();
/* 142 */       for (int i = 0; i < len; i++)
/*     */       {
/* 144 */         Element elem = (Element)nodeList.get(i);
/* 145 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.chat.confbean.SChatEachChannelCfg"))
/*     */         {
/*     */ 
/* 148 */           SChatEachChannelCfg obj = new SChatEachChannelCfg();
/* 149 */           obj.loadFromXml(elem);
/* 150 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 151 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 156 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 162 */     all = new java.util.HashMap();
/*     */     
/* 164 */     String path = dir + "mzm.gsp.chat.confbean.SChatEachChannelCfg.bny";
/*     */     try
/*     */     {
/* 167 */       File file = new File(path);
/* 168 */       if (file.exists())
/*     */       {
/* 170 */         byte[] bytes = new byte['Ѐ'];
/* 171 */         FileInputStream fis = new FileInputStream(file);
/* 172 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 173 */         int len = 0;
/* 174 */         while ((len = fis.read(bytes)) > 0)
/* 175 */           baos.write(bytes, 0, len);
/* 176 */         fis.close();
/* 177 */         bytes = baos.toByteArray();
/* 178 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 179 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 181 */           _os_.unmarshal_int();
/* 182 */           _os_.unmarshal_int();
/* 183 */           _os_.unmarshal_int();
/*     */         }
/* 185 */         _os_.unmarshal_int();
/* 186 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 189 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 191 */           SChatEachChannelCfg _v_ = new SChatEachChannelCfg();
/* 192 */           _v_.unmarshal(_os_);
/* 193 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 194 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 199 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 204 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SChatEachChannelCfg> all)
/*     */   {
/* 211 */     String path = dir + "mzm.gsp.chat.confbean.SChatEachChannelCfg.bny";
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
/* 226 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 228 */           _os_.unmarshal_int();
/* 229 */           _os_.unmarshal_int();
/* 230 */           _os_.unmarshal_int();
/*     */         }
/* 232 */         _os_.unmarshal_int();
/* 233 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 236 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 238 */           SChatEachChannelCfg _v_ = new SChatEachChannelCfg();
/* 239 */           _v_.unmarshal(_os_);
/* 240 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 241 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 246 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 251 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SChatEachChannelCfg getOld(int key)
/*     */   {
/* 259 */     return (SChatEachChannelCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SChatEachChannelCfg get(int key)
/*     */   {
/* 264 */     return (SChatEachChannelCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SChatEachChannelCfg> getOldAll()
/*     */   {
/* 269 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SChatEachChannelCfg> getAll()
/*     */   {
/* 274 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SChatEachChannelCfg> newAll)
/*     */   {
/* 279 */     oldAll = all;
/* 280 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 285 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\confbean\SChatEachChannelCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */