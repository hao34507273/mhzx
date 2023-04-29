/*    */ package mzm.event;
/*    */ 
/*    */ import java.io.File;
/*    */ import mzm.event.generator.Event;
/*    */ 
/*    */ public class EventInitialiser
/*    */ {
/*    */   public static void init(String configPath)
/*    */     throws Exception
/*    */   {
/* 11 */     Utils.detectObjectForDirectory(new File(configPath), new XMLFileFilter(), new XStreamObjectProcessor()
/*    */     {
/*    */ 
/*    */ 
/*    */       public boolean onObjectDetected(Object obj)
/*    */       {
/*    */ 
/* 18 */         if ((obj instanceof Event[])) {
/* 19 */           Event[] events = (Event[])obj;
/*    */           
/*    */ 
/* 22 */           for (Event event : events) {
/*    */             try {
/* 24 */               Class.forName(event.getModule() + "." + event.getEvent()).newInstance();
/*    */             }
/*    */             catch (Exception e) {
/* 27 */               throw new Error(event.getModule() + "." + event.getEvent() + "can not be init");
/*    */             }
/*    */           }
/*    */         }
/*    */         
/*    */ 
/* 33 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\event\EventInitialiser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */