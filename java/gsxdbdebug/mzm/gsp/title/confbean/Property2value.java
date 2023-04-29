/*    */ package mzm.gsp.title.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class Property2value implements Marshal
/*    */ {
/*    */   public int property;
/*    */   public int value;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.property = Integer.valueOf(rootElement.attributeValue("property")).intValue();
/* 15 */     this.value = Integer.valueOf(rootElement.attributeValue("value")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.property);
/* 21 */     _os_.marshal(this.value);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.property = _os_.unmarshal_int();
/* 28 */     this.value = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\confbean\Property2value.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */