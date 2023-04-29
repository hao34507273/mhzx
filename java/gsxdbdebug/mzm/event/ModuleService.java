/*     */ package mzm.event;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class ModuleService
/*     */ {
/*  12 */   private static Logger logger = Logger.getLogger(ModuleService.class);
/*     */   
/*     */ 
/*     */ 
/*     */   private static String configPath;
/*     */   
/*     */ 
/*  19 */   private static int reloadcount = 0;
/*  20 */   private static Map<Class<?>, Module> moduleList = new java.util.HashMap();
/*     */   
/*     */   public static void init(String configPath) throws Exception
/*     */   {
/*  24 */     if (configPath != null)
/*     */     {
/*  26 */       return;
/*     */     }
/*     */     
/*  29 */     configPath = configPath;
/*  30 */     List<ModulerInitInfo> modulerInitInfos = new ArrayList();
/*  31 */     List<PostModuleInitListner> postListners = new ArrayList(1);
/*  32 */     Utils.detectObjectForDirectory(new java.io.File(configPath), new XMLFileFilter(), new XStreamObjectProcessor()
/*     */     {
/*     */ 
/*     */       public boolean onObjectDetected(Object obj)
/*     */       {
/*  37 */         if ((obj instanceof ModulerInitInfo[]))
/*     */         {
/*  39 */           ModulerInitInfo[] infos = (ModulerInitInfo[])obj;
/*  40 */           for (ModulerInitInfo info : infos)
/*     */           {
/*  42 */             this.val$modulerInitInfos.add(info);
/*     */           }
/*     */         }
/*  45 */         else if ((obj instanceof List))
/*     */         {
/*  47 */           List<?> list = (List)obj;
/*  48 */           for (Object object : list)
/*     */           {
/*  50 */             if ((object instanceof String))
/*     */             {
/*  52 */               String className = (String)object;
/*     */               try
/*     */               {
/*  55 */                 Class.forName(className).newInstance();
/*     */               }
/*     */               catch (Exception e)
/*     */               {
/*  59 */                 ModuleService.logger.error(e);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         
/*  65 */         return true;
/*     */       }
/*     */       
/*  68 */     });
/*  69 */     java.util.Collections.sort(modulerInitInfos, new java.util.Comparator()
/*     */     {
/*     */ 
/*     */       public int compare(ModulerInitInfo o1, ModulerInitInfo o2)
/*     */       {
/*  74 */         return o2.getModulePriorityId() - o1.getModulePriorityId();
/*     */       }
/*     */     });
/*  77 */     for (ModulerInitInfo info : modulerInitInfos)
/*     */     {
/*     */       Module module;
/*     */       try
/*     */       {
/*  82 */         module = createModule(info.getModuleName(), info.getEnv());
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/*  86 */         logger.error("error", e);
/*  87 */         throw new Error("a unknown module can not be loaded");
/*     */       }
/*  89 */       if (module.loadconf(info.getEnv(), reloadcount) != 0)
/*     */       {
/*  91 */         throw new RuntimeException(module.getClass().getName() + " loadconf failed");
/*     */       }
/*  93 */       if (module.init(info.getEnv()) < 0)
/*     */       {
/*  95 */         throw new RuntimeException(module.getClass().getName() + " init failed");
/*     */       }
/*     */       
/*  98 */       moduleList.put(module.getClass(), module);
/*     */       
/* 100 */       Class<?>[] interfaces = module.getClass().getInterfaces();
/* 101 */       for (Class<?> interfacei : interfaces)
/*     */       {
/* 103 */         if (interfacei.equals(PostModuleInitListner.class))
/*     */         {
/* 105 */           postListners.add((PostModuleInitListner)module);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 110 */     for (PostModuleInitListner postListner : postListners)
/*     */     {
/* 112 */       postListner.postInit();
/*     */     }
/*     */   }
/*     */   
/*     */   private static Module createModule(Field field, Class<?> module) throws Exception
/*     */   {
/* 118 */     field.setAccessible(true);
/* 119 */     Object instance = field.get(module);
/*     */     
/* 121 */     if (instance == null)
/*     */     {
/* 123 */       instance = module.newInstance();
/*     */     }
/*     */     
/* 126 */     if ((instance instanceof Module))
/*     */     {
/* 128 */       Module ret = (Module)instance;
/* 129 */       return ret;
/*     */     }
/*     */     
/*     */ 
/* 133 */     throw new Error(module.getName() + " is not a module instance");
/*     */   }
/*     */   
/*     */   private static Module createModule(String moduleName, Map<String, String> envs)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 141 */       Class<?> moduleClass = Class.forName(moduleName);
/*     */       
/*     */       Singleton singleton;
/* 144 */       if ((singleton = (Singleton)moduleClass.getAnnotation(Singleton.class)) != null)
/*     */       {
/* 146 */         String instanceStr = singleton.value();
/* 147 */         Field instanceFiled = moduleClass.getDeclaredField(instanceStr);
/*     */         
/* 149 */         return createModule(instanceFiled, moduleClass);
/*     */       }
/*     */       
/* 152 */       Field[] fields = moduleClass.getDeclaredFields();
/*     */       
/* 154 */       for (Field field : fields)
/*     */       {
/* 156 */         if (field.getName().toLowerCase().contains("instance"))
/*     */         {
/*     */ 
/* 159 */           return createModule(field, moduleClass);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 164 */       return (Module)Class.forName(moduleName).newInstance();
/*     */ 
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */ 
/* 171 */       e.printStackTrace(); }
/* 172 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public static Module getModuleInstance(Class<?> cls)
/*     */   {
/* 178 */     return (Module)moduleList.get(cls);
/*     */   }
/*     */   
/*     */   public static boolean loadConf()
/*     */   {
/* 183 */     boolean fail = false;
/* 184 */     for (Module module : moduleList.values())
/*     */     {
/*     */       try
/*     */       {
/* 188 */         int ret = module.loadconf(null, ++reloadcount);
/* 189 */         if (ret != 0) {
/* 190 */           fail = true;
/*     */         }
/*     */       }
/*     */       catch (Exception ex) {
/* 194 */         logger.error("err", ex);
/* 195 */         fail = true;
/*     */       }
/*     */     }
/* 198 */     return !fail;
/*     */   }
/*     */   
/*     */   public static boolean cleanupForMerge(int zoneid)
/*     */   {
/* 203 */     GameServer.setZoneid(zoneid);
/* 204 */     boolean fail = false;
/* 205 */     for (Module module : moduleList.values())
/*     */     {
/*     */       try
/*     */       {
/* 209 */         int ret = module.cleanupForMerge();
/* 210 */         if (ret != 0) {
/* 211 */           fail = true;
/*     */         }
/*     */       }
/*     */       catch (Exception ex) {
/* 215 */         logger.error("err", ex);
/* 216 */         fail = true;
/*     */       }
/*     */     }
/* 219 */     return !fail;
/*     */   }
/*     */   
/*     */   public static void exit() throws Exception
/*     */   {
/* 224 */     for (Module module : moduleList.values())
/*     */     {
/* 226 */       module.exit();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\event\ModuleService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */