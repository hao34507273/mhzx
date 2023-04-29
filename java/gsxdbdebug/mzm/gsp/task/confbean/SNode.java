/*    */ package mzm.gsp.task.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SNode implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int nodeID;
/*    */   public int childWeight;
/* 11 */   public ArrayList<STaskToProperty> taskIdToProperty = new ArrayList();
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.nodeID = Integer.valueOf(rootElement.attributeValue("nodeID")).intValue();
/* 16 */     this.childWeight = Integer.valueOf(rootElement.attributeValue("childWeight")).intValue();
/*    */     
/* 18 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "taskIdToProperty");
/* 19 */     if (collectionElement == null)
/*    */     {
/* 21 */       throw new RuntimeException("collection type element does not find");
/*    */     }
/*    */     
/* 24 */     java.util.List<?> _nodeList = collectionElement.elements();
/* 25 */     int _len = _nodeList.size();
/* 26 */     for (int i = 0; i < _len; i++)
/*    */     {
/* 28 */       Element elem = (Element)_nodeList.get(i);
/* 29 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.task.confbean.STaskToProperty"))
/*    */       {
/*    */         STaskToProperty _v_;
/*    */         
/*    */ 
/*    */         try
/*    */         {
/* 36 */           _v_ = new STaskToProperty();
/* 37 */           _v_.loadFromXml(elem);
/*    */         }
/*    */         catch (Exception e)
/*    */         {
/*    */           continue;
/*    */         }
/*    */         
/* 44 */         this.taskIdToProperty.add(_v_);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 51 */     _os_.marshal(this.nodeID);
/* 52 */     _os_.marshal(this.childWeight);
/* 53 */     _os_.compact_uint32(this.taskIdToProperty.size());
/* 54 */     for (STaskToProperty _v_ : this.taskIdToProperty)
/*    */     {
/* 56 */       _os_.marshal(_v_);
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 63 */     this.nodeID = _os_.unmarshal_int();
/* 64 */     this.childWeight = _os_.unmarshal_int();
/* 65 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/*    */ 
/* 68 */       STaskToProperty _v_ = new STaskToProperty();
/* 69 */       _v_.unmarshal(_os_);
/* 70 */       this.taskIdToProperty.add(_v_);
/*    */     }
/* 72 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\confbean\SNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */