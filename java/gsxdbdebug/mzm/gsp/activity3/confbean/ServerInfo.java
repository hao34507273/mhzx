/*    */ package mzm.gsp.activity3.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class ServerInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*  9 */   public HashSet<Integer> serverIds = new HashSet();
/*    */   
/*    */ 
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "serverIds");
/* 15 */     if (collectionElement == null)
/*    */     {
/* 17 */       throw new RuntimeException("collection type element does not find");
/*    */     }
/*    */     
/* 20 */     java.util.List<?> _nodeList = collectionElement.elements();
/* 21 */     int _len = _nodeList.size();
/* 22 */     for (int i = 0; i < _len; i++)
/*    */     {
/* 24 */       Element elem = (Element)_nodeList.get(i);
/* 25 */       if (elem.getName().equalsIgnoreCase("int"))
/*    */       {
/*    */         int _v_;
/*    */         
/*    */ 
/*    */         try
/*    */         {
/* 32 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*    */         }
/*    */         catch (Exception e)
/*    */         {
/*    */           continue;
/*    */         }
/*    */         
/* 39 */         this.serverIds.add(Integer.valueOf(_v_));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 46 */     _os_.compact_uint32(this.serverIds.size());
/* 47 */     for (Integer _v_ : this.serverIds)
/*    */     {
/* 49 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 56 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/*    */ 
/* 59 */       int _v_ = _os_.unmarshal_int();
/* 60 */       this.serverIds.add(Integer.valueOf(_v_));
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity3\confbean\ServerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */