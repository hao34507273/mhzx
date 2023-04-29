/*    */ package mzm.gsp.homeland.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class ChildPos implements Marshal
/*    */ {
/*    */   public int childX;
/*    */   public int childY;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.childX = Integer.valueOf(rootElement.attributeValue("childX")).intValue();
/* 15 */     this.childY = Integer.valueOf(rootElement.attributeValue("childY")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.childX);
/* 21 */     _os_.marshal(this.childY);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.childX = _os_.unmarshal_int();
/* 28 */     this.childY = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\confbean\ChildPos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */