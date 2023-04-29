/*     */ package mzm.event.generator;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Event
/*     */ {
/*     */   static final String REGISTER_HANDLER = "\t\tmanager.register(new ImpSampleEventHandler());";
/*     */   static final String REGISTER_PROCEDURE = "\t\tmanager.register(new ImpSampleEventProcedure());";
/*     */   static final String REGISTER_RUNNABLE = "\t\tmanager.register(new ImpSampleEventRunnable());";
/*     */   static final String REGISTER_CODE = "\t\tmanager.register(%s);";
/*     */   private String module;
/*     */   private String event;
/*     */   private String arg;
/*     */   private Map<String, String> handlerList;
/*     */   
/*     */   public void setModule(String module)
/*     */   {
/*  34 */     this.module = module;
/*     */   }
/*     */   
/*  37 */   public String getModule() { return this.module; }
/*     */   
/*     */   public void setEvent(String event) {
/*  40 */     this.event = event;
/*     */   }
/*     */   
/*  43 */   public String getEvent() { return this.event; }
/*     */   
/*     */   private void genEventHandler(String fileName, String templateFileName)
/*     */     throws Exception
/*     */   {
/*  48 */     BufferedReader br = new BufferedReader(new FileReader(templateFileName));
/*  49 */     PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
/*     */     
/*  51 */     String line = br.readLine();
/*  52 */     if (line != null) {
/*  53 */       pw.print(line.replace("gsframe2.Sample", this.module) + "\n");
/*     */     }
/*     */     
/*  56 */     while ((line = br.readLine()) != null) {
/*  57 */       String tmp = line.replace("SampleArg", this.arg);
/*  58 */       pw.print(tmp.replace("SampleEvent", this.event) + "\n");
/*     */     }
/*  60 */     br.close();
/*     */     
/*  62 */     pw.close();
/*     */   }
/*     */   
/*     */   private void genListeners(String fileName, String templateFileName, String handlerName) throws Exception {
/*  66 */     File file = new File(fileName);
/*  67 */     if (file.exists()) {
/*  68 */       return;
/*     */     }
/*     */     
/*  71 */     String[] tmpPackName = handlerName.split("\\.");
/*     */     
/*     */ 
/*  74 */     StringBuilder packName = new StringBuilder();
/*  75 */     packName.append(tmpPackName[0]);
/*  76 */     for (int i = 1; i < tmpPackName.length - 1; i++) {
/*  77 */       packName.append("." + tmpPackName[i]);
/*     */     }
/*     */     
/*  80 */     BufferedReader br = new BufferedReader(new FileReader(templateFileName));
/*  81 */     PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
/*     */     
/*  83 */     String line = br.readLine();
/*  84 */     if ((line != null) && (packName.toString().length() > 0)) {
/*  85 */       pw.print(line.replace("gsframe2.Sample", packName.toString()) + "\n");
/*     */     }
/*     */     
/*  88 */     while ((line = br.readLine()) != null) {
/*  89 */       String tmp = line.replace("SampleArg", this.arg);
/*  90 */       tmp = tmp.replace("ImpSampleEventHandler", tmpPackName[(tmpPackName.length - 1)]);
/*  91 */       tmp = tmp.replace("ImpSampleEventProcedure", tmpPackName[(tmpPackName.length - 1)]);
/*  92 */       tmp = tmp.replace("ImpSampleEventRunnable", tmpPackName[(tmpPackName.length - 1)]);
/*  93 */       tmp = tmp.replace("SampleEvent", this.module + "." + this.event);
/*  94 */       pw.print(tmp + "\n");
/*     */     }
/*  96 */     br.close();
/*     */     
/*  98 */     pw.close();
/*     */   }
/*     */   
/*     */   private void genEvent(String moduleEventManagerName, String fileName, String templateFileName) throws Exception
/*     */   {
/* 103 */     PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
/* 104 */     BufferedReader br = new BufferedReader(new FileReader(templateFileName));
/*     */     
/*     */ 
/* 107 */     String line = br.readLine();
/* 108 */     if (line != null) {
/* 109 */       pw.print(line.replace("gsframe2.Sample", this.module) + "\n");
/*     */     }
/*     */     
/* 112 */     LinkedList<String> fileContent = new LinkedList();
/*     */     
/* 114 */     while ((line = br.readLine()) != null) {
/* 115 */       String tmp = line.replace("SampleArg", this.arg);
/* 116 */       String temp = tmp.replace("SampleEventSyncManager", moduleEventManagerName);
/* 117 */       fileContent.add(0, temp.replace("SampleEvent", this.event));
/*     */     }
/* 119 */     br.close();
/*     */     
/* 121 */     Iterator<String> itr = fileContent.iterator();
/* 122 */     int index = 0;
/*     */     
/* 124 */     while (itr.hasNext()) {
/* 125 */       String cur = (String)itr.next();
/* 126 */       if (cur.contains("}")) {
/*     */         break;
/*     */       }
/* 129 */       index++;
/*     */     }
/*     */     
/* 132 */     if (itr.hasNext()) {
/* 133 */       index++;
/*     */       
/* 135 */       fileContent.add(index, "\tstatic{");
/*     */       
/* 137 */       for (Map.Entry<String, String> item : this.handlerList.entrySet()) {
/* 138 */         if (((String)item.getValue()).equals("handler")) {
/* 139 */           fileContent.add(index, "\t\tmanager.register(new ImpSampleEventHandler());".replace("ImpSampleEventHandler", (CharSequence)item.getKey()));
/*     */ 
/*     */ 
/*     */         }
/* 143 */         else if (((String)item.getValue()).equals("procedure")) {
/* 144 */           fileContent.add(index, "\t\tmanager.register(new ImpSampleEventProcedure());".replace("ImpSampleEventProcedure", (CharSequence)item.getKey()));
/*     */ 
/*     */ 
/*     */         }
/* 148 */         else if (((String)item.getValue()).equalsIgnoreCase("runnable")) {
/* 149 */           fileContent.add(index, "\t\tmanager.register(new ImpSampleEventRunnable());".replace("ImpSampleEventRunnable", (CharSequence)item.getKey()));
/*     */ 
/*     */ 
/*     */         }
/* 153 */         else if (((String)item.getValue()).equalsIgnoreCase("code")) {
/* 154 */           fileContent.add(index, String.format("\t\tmanager.register(%s);", new Object[] { item.getKey() }));
/*     */         }
/*     */         else {
/* 157 */           System.out.println("invalid event handler type: " + (String)item.getValue());
/*     */         }
/*     */       }
/*     */       
/* 161 */       fileContent.add(index, "\t}");
/*     */     }
/*     */     
/* 164 */     Collections.reverse(fileContent);
/*     */     
/* 166 */     for (String content : fileContent) {
/* 167 */       pw.print(content + "\n");
/*     */     }
/*     */     
/* 170 */     pw.close();
/*     */   }
/*     */   
/*     */   public void genFiles(String moduleEventManagerName, String base, String templatePath) throws Exception {
/* 174 */     String path = base + "/" + this.module.replace('.', '/');
/*     */     
/* 176 */     String fileName = path + "/" + this.event + ".java";
/* 177 */     String templateFileName = templatePath + "/" + "SampleEvent.java";
/*     */     
/* 179 */     genEvent(moduleEventManagerName, fileName, templateFileName);
/*     */     
/*     */ 
/* 182 */     fileName = path + "/" + this.event + "Handler.java";
/* 183 */     templateFileName = templatePath + "/" + "SampleEventHandler.java";
/*     */     
/* 185 */     genEventHandler(fileName, templateFileName);
/*     */     
/* 187 */     fileName = path + "/" + this.event + "Procedure.java";
/* 188 */     templateFileName = templatePath + "/" + "SampleEventProcedure.java";
/*     */     
/* 190 */     genEventHandler(fileName, templateFileName);
/*     */     
/* 192 */     fileName = path + "/" + this.event + "Runnable.java";
/* 193 */     templateFileName = templatePath + "/" + "SampleEventRunnable.java";
/*     */     
/* 195 */     genEventHandler(fileName, templateFileName);
/*     */     
/* 197 */     for (Map.Entry<String, String> listener : this.handlerList.entrySet()) {
/* 198 */       fileName = base + "/" + ((String)listener.getKey()).replace('.', '/') + ".java";
/* 199 */       if (!((String)listener.getValue()).equals("code"))
/*     */       {
/*     */ 
/* 202 */         if (((String)listener.getValue()).equals("handler")) {
/* 203 */           genListeners(fileName, templatePath + "/" + "ImpSampleEventHandler.java", (String)listener.getKey());
/*     */         }
/* 205 */         else if (((String)listener.getValue()).equals("procedure")) {
/* 206 */           genListeners(fileName, templatePath + "/" + "ImpSampleEventProcedure.java", (String)listener.getKey());
/*     */         }
/* 208 */         else if (((String)listener.getValue()).equals("runnable")) {
/* 209 */           genListeners(fileName, templatePath + "/" + "ImpSampleEventRunnable.java", (String)listener.getKey());
/*     */         }
/*     */         else
/* 212 */           System.out.println("Unkown event handler type: " + (String)listener.getValue()); }
/*     */     }
/*     */   }
/*     */   
/*     */   public void setArg(String arg) {
/* 217 */     this.arg = arg;
/*     */   }
/*     */   
/* 220 */   public String getArg() { return this.arg; }
/*     */   
/*     */   public void setHandlerList(Map<String, String> handlerList) {
/* 223 */     this.handlerList = handlerList;
/*     */   }
/*     */   
/* 226 */   public Map<String, String> getHandlerList() { return this.handlerList; }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\event\generator\Event.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */