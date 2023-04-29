/*    */ package mzm.gsp.task.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.List;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class STaskToProperty implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int taskId;
/*    */   public SNodeProperty nodeProperty;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.taskId = Integer.valueOf(rootElement.attributeValue("taskId")).intValue();
/*    */     
/* 16 */     Element beanElement = util.XmlHelper.getVariableElement(rootElement, "nodeProperty");
/* 17 */     if (beanElement == null)
/*    */     {
/* 19 */       throw new RuntimeException("beanElement element does not find");
/*    */     }
/*    */     
/* 22 */     List<?> _nodeList = beanElement.elements();
/* 23 */     int _len = _nodeList.size();
/* 24 */     for (int i = 0; i < _len; i++)
/*    */     {
/* 26 */       Element elem = (Element)_nodeList.get(i);
/* 27 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.task.confbean.SNodeProperty"))
/*    */       {
/*    */ 
/*    */         try
/*    */         {
/*    */ 
/* 33 */           this.nodeProperty = new SNodeProperty();
/* 34 */           this.nodeProperty.loadFromXml(elem);
/*    */         }
/*    */         catch (Exception e) {}
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 47 */     _os_.marshal(this.taskId);
/* 48 */     _os_.marshal(this.nodeProperty);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 54 */     this.taskId = _os_.unmarshal_int();
/* 55 */     this.nodeProperty = new SNodeProperty();
/* 56 */     this.nodeProperty.unmarshal(_os_);
/* 57 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\confbean\STaskToProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */